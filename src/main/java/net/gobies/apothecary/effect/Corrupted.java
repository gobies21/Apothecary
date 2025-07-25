package net.gobies.apothecary.effect;

import net.gobies.apothecary.util.BlacklistedEffects;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Corrupted extends MobEffect {
    public Corrupted(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.getActiveEffects().stream()
                .filter(effectInstance -> effectInstance.getEffect().getCategory() == MobEffectCategory.BENEFICIAL)
                .filter(effectInstance -> BlacklistedEffects.isBeneficialEffectBlacklisted(effectInstance.getEffect()))
                .forEach(effectInstance -> entity.removeEffect(effectInstance.getEffect()));
    }

    @SubscribeEvent
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (event.getEntity().hasEffect(AEffects.Corrupted.get()) &&
                BlacklistedEffects.isBeneficialEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }


    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        List<MobEffect> effectsToRemove = new ArrayList<>();

        for (MobEffectInstance effectInstance : entity.getActiveEffects()) {
            MobEffect effect = effectInstance.getEffect();
            if (effect.getCategory() == MobEffectCategory.BENEFICIAL && BlacklistedEffects.isBeneficialEffectBlacklisted(effect)) {
                effectsToRemove.add(effect);
            }
        }
        for (MobEffect effect : effectsToRemove) {
            entity.removeEffect(effect);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
