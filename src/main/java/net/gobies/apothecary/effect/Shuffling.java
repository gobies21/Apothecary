package net.gobies.apothecary.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffling extends MobEffect {

    public Shuffling(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayer player) {
            shufflePlayerInventory(player);
        }
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        if (!(entity instanceof ServerPlayer player)) {
            return;
        }

        shufflePlayerInventory(player);
    }

    private void shufflePlayerInventory(ServerPlayer player) {
        Inventory inventory = player.getInventory();

        List<Integer> shuffleSlots = new ArrayList<>();
        List<ItemStack> stacks = new ArrayList<>();

        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (i >= 36 && i <= 39) { // Skip armor slots
                continue;
            }

            ItemStack stack = inventory.getItem(i);
            shuffleSlots.add(i);
            stacks.add(stack.copy());
        }
        Random random = new Random();
        Collections.shuffle(stacks, random);

        // Clear slots
        for (int slot : shuffleSlots) {
            inventory.setItem(slot, ItemStack.EMPTY);
        }

        // Reassign stacks
        for (int i = 0; i < shuffleSlots.size(); i++) {
            inventory.setItem(shuffleSlots.get(i), stacks.get(i));
        }

        inventory.setChanged();
        player.containerMenu.broadcastChanges();
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 50 == 0;
    }
}