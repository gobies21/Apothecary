package net.gobies.apothecary.effect;

import net.gobies.apothecary.network.NetworkHandler;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffling extends MobEffect {

    public Shuffling(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            shufflePlayerInventory(player);
        }
    }


    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        if (entity instanceof Player player && player.level().isClientSide) {
            return;
        }
        if (entity instanceof Player player) {
            shufflePlayerInventory(player);
        }
    }

    private void shufflePlayerInventory(Player player) {
        if (!player.level().isClientSide) {
            List<ItemStack> inventory = new ArrayList<>();
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if (i < 36 || i > 39) { // Skip armor slots (36 to 39)
                    inventory.add(player.getInventory().getItem(i)); // Get item from slot i
                }
            }
            Collections.shuffle(inventory);

            int inventoryIndex = 0;
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if (i < 36 || i > 39) { // Skip armor slots (36 to 39)
                    player.getInventory().setItem(i, inventory.get(inventoryIndex));
                    inventoryIndex++;
                }
            }

            player.getInventory().setChanged();
            player.containerMenu.broadcastChanges();

            NetworkHandler.sendShuffleInventoryPacket((ServerPlayer) player, inventory);
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 50 == 0;
    }
}