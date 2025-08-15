package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Burning extends MobEffect {
    public Burning(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.hasEffect(this) || !livingEntity.fireImmune()) {
            if (livingEntity.isInWaterOrRain()) {
                livingEntity.removeEffect(this);
            } else {
                if (livingEntity instanceof Player player) {
                    if (player.isCreative() || player.isSpectator()) {
                        return;
                    }
                }
                int duration = Objects.requireNonNull(livingEntity.getEffect(this)).getDuration();
                livingEntity.setSecondsOnFire(duration / 20);

                if (amplifier >= 0) {
                    float damage = 1.0F + (float) amplifier;
                    livingEntity.hurt(livingEntity.damageSources().onFire(), damage);
                }
            }
        }
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity livingEntity, int pAmplifier, double pHealth) {
        super.applyInstantenousEffect(pSource, pIndirectSource, livingEntity, pAmplifier, pHealth);
        livingEntity.setSecondsOnFire(20);
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributes, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attributes, amplifier);
        livingEntity.setSecondsOnFire(0);
        livingEntity.extinguishFire();
    }


    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}