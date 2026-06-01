package net.gobies.apothecary.effect;

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
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        if (!entity.getActiveEffects().isEmpty()) {
            List<MobEffectInstance> effectsToUpdate = new ArrayList<>(entity.getActiveEffects());
            for (MobEffectInstance effectInstance : effectsToUpdate) {
                int currentDuration = effectInstance.getDuration();
                if (currentDuration != -1) {
                    MobEffect effect = effectInstance.getEffect();
                    int newDuration = currentDuration + (20 * -15 * (pAmplifier + 1));
                    int amplifier = effectInstance.getAmplifier();
                    entity.removeEffect(effect);
                    entity.addEffect(new MobEffectInstance(effect, newDuration, amplifier));
                }
            }
        } else {
            System.out.println("No active effects to update");
        }
    }
}
