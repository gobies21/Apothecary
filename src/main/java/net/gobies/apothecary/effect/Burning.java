package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Burning extends MobEffect {
    public Burning(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.hasEffect(this) || !entity.fireImmune()) {
            if (entity.isInWaterOrRain()) {
                entity.removeEffect(this);
            } else {
                int duration = Objects.requireNonNull(entity.getEffect(this)).getDuration();
                entity.setSecondsOnFire(duration / 20);

                if (amplifier >= 0) {
                    float damage = 1.0F + (float) amplifier;
                    entity.hurt(entity.damageSources().onFire(), damage);
                }
            }
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributes, int amplifier) {
        super.removeAttributeModifiers(entity, attributes, amplifier);
        entity.setSecondsOnFire(0);
        entity.extinguishFire();
    }


    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}