package net.gobies.apothecary.effect;

import net.gobies.apothecary.handler.BlacklistedEffects;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Cleansed extends MobEffect {

    public Cleansed(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.getActiveEffects().stream()
                .filter(effectInstance -> effectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL)
                .filter(effectInstance -> BlacklistedEffects.isHarmfulEffectBlacklisted(effectInstance.getEffect()))
                .forEach(effectInstance -> entity.removeEffect(effectInstance.getEffect()));
    }

    @SubscribeEvent
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (event.getEntity().hasEffect(AEffects.Cleansed.get()) &&
                BlacklistedEffects.isHarmfulEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
