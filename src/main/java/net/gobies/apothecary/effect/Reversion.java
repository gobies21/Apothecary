package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AEffects;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Reversion extends MobEffect {
    public Reversion(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int pAmplifier) {
        if (!entity.getCommandSenderWorld().isClientSide()) {
            revertEffects(entity, pAmplifier);
            if (!entity.getActiveEffects().isEmpty()) {
                entity.removeEffect(this);
            }
        }
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        if (!entity.getCommandSenderWorld().isClientSide()) {
            revertEffects(entity, pAmplifier);
        }
    }

    private void revertEffects(@NotNull LivingEntity entity, int pAmplifier) {
        if (!entity.getActiveEffects().isEmpty()) {
            if (entity.level().isClientSide() || !(entity.level() instanceof ServerLevel serverLevel)) return;
            List<MobEffectInstance> effectsToUpdate = new ArrayList<>(entity.getActiveEffects());
            for (MobEffectInstance effectInstance : effectsToUpdate) {
                MobEffect effect = effectInstance.getEffect();
                if (effect == this || effect == AEffects.PotionSickness.get() || effect.getCategory() != MobEffectCategory.BENEFICIAL) continue;
                int currentDuration = effectInstance.getDuration();
                if (currentDuration != -1) {
                    int durationToRemove = 20 * 15 * (pAmplifier + 1);
                    int newDuration = currentDuration - durationToRemove;

                    if (newDuration > 0) {
                        effectInstance.duration = newDuration;
                        ClientboundUpdateMobEffectPacket packet = new ClientboundUpdateMobEffectPacket(entity.getId(), effectInstance);
                        if (entity instanceof ServerPlayer serverPlayer) {
                            serverPlayer.connection.send(packet);
                        }
                        serverLevel.getChunkSource().broadcast(entity, packet);
                    } else {
                        entity.removeEffect(effect);
                    }
                }
            }
        } else {
            System.out.println("No active effects to update");
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}