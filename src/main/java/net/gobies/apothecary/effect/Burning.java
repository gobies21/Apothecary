package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class Burning extends MobEffect {
    public Burning(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.fireImmune()) {
            if (entity.isInWater()) {
                entity.removeEffect(this);
            } else {
                entity.setSecondsOnFire(1);

                if (amplifier >= 0) {
                    float damage = 1.0F + (float) amplifier * 0.5F;
                    entity.hurt(entity.damageSources().onFire(), damage);
                }
            }
        }
    }



    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}