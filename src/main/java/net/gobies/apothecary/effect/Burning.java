package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Burning extends MobEffect {
    public Burning(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.hasEffect(AEffects.Burning) || !livingEntity.fireImmune()) {
            if (livingEntity.isInWaterOrRain()) {
                livingEntity.removeEffect(AEffects.Burning);
            } else {
                if (livingEntity instanceof Player player) {
                    if (player.isCreative() || player.isSpectator()) {
                        return false;
                    }
                }
                int duration = Objects.requireNonNull(livingEntity.getEffect(AEffects.Burning)).getDuration();
                livingEntity.setRemainingFireTicks(duration);

                if (amplifier >= 0) {
                    float damage = 1.0F + (float) amplifier;
                    livingEntity.hurt(livingEntity.damageSources().onFire(), damage);
                }
            }
        }
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity livingEntity, int pAmplifier, double pHealth) {
        super.applyInstantenousEffect(pSource, pIndirectSource, livingEntity, pAmplifier, pHealth);
        livingEntity.setRemainingFireTicks(livingEntity.getRemainingFireTicks() + 20);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}