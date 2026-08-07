package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.BlacklistedEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Corruption extends MobEffect {
    public Corruption(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.hasEffect(AEffects.PotionSickness)) return false;
        livingEntity.getActiveEffects().stream()
                .filter(effectInstance -> effectInstance.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL)
                .filter(effectInstance -> BlacklistedEffects.isBeneficialEffectBlacklisted(effectInstance.getEffect().value()))
                .forEach(effectInstance -> livingEntity.removeEffect(effectInstance.getEffect()));
        return true;
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        List<Holder<MobEffect>> effectsToRemove = new ArrayList<>();
        if (entity.hasEffect(AEffects.PotionSickness)) return;

        for (MobEffectInstance effectInstance : entity.getActiveEffects()) {
            Holder<MobEffect> effect = effectInstance.getEffect();
            if (effect.value().getCategory() == MobEffectCategory.BENEFICIAL && BlacklistedEffects.isBeneficialEffectBlacklisted(effect.value())) {
                effectsToRemove.add(effect);
            }
        }
        for (Holder<MobEffect> effect : effectsToRemove) {
            entity.removeEffect(effect);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
