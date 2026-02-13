package net.gobies.apothecary.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        player.server.execute(() -> shufflePlayerInventory(player));
    }

    private void shufflePlayerInventory(ServerPlayer player) {

        Inventory inventory = player.getInventory();
        int size = 37;

        Map<Integer, ItemStack> snapshot = new HashMap<>();
        for (int slot = 0; slot < size; slot++) {
            if (slot < 36) {
                snapshot.put(slot, inventory.getItem(slot).copy());
            } else {
                snapshot.put(slot, player.getOffhandItem().copy());
            }
        }

        List<Integer> originalSlots = new ArrayList<>(snapshot.keySet());
        List<Integer> shuffledSlots = new ArrayList<>(snapshot.keySet());

        Collections.shuffle(shuffledSlots, ThreadLocalRandom.current());

        Map<Integer, ItemStack> relocationMap = new HashMap<>();

        for (int i = 0; i < originalSlots.size(); i++) {
            int fromSlot = originalSlots.get(i);
            int toSlot   = shuffledSlots.get(i);

            relocationMap.put(toSlot, snapshot.get(fromSlot));
        }

        for (int slot = 0; slot < 36; slot++) {
            inventory.setItem(slot, ItemStack.EMPTY);
        }
        player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);

        for (Map.Entry<Integer, ItemStack> entry : relocationMap.entrySet()) {

            int slot = entry.getKey();
            ItemStack stack = entry.getValue();

            if (slot < 36) {
                inventory.setItem(slot, stack);
            } else {
                player.setItemInHand(InteractionHand.OFF_HAND, stack);
            }
        }
        inventory.setChanged();
        player.containerMenu.broadcastChanges();
        player.inventoryMenu.broadcastChanges();

        snapshot.clear();
        relocationMap.clear();
        originalSlots.clear();
        shuffledSlots.clear();
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 100 == 0;
    }
}