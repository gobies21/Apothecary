package net.gobies.apothecary.event;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.DurationUtils;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class WorldEvents {

    public static void register() {
        NeoForge.EVENT_BUS.register(new WorldEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingIncomingDamageEvent event) {
        if (!CommonConfig.APOTHECARY_ENABLED.get()) return;
        if (event.isCanceled()) return;
        LivingEntity entity = event.getEntity();
        Entity mob = event.getSource().getEntity();
        if (CommonConfig.ENABLE_WORLD_EVENTS.get()) {
            float damageAmount = event.getAmount();
            int randomMediumDuration = DurationUtils.getRandomMediumDuration();
            int randomShortDuration = DurationUtils.getRandomShortDuration();
            int randomVeryShortDuration = DurationUtils.getRandomVeryShortDuration();
            int randomLongDuration = DurationUtils.getRandomLongDuration();
            int baseAmplifier = 0;
            int rangedAmplifier = entity.getRandom().nextFloat() < 0.75 ? 0 : 1;
            MobEffectInstance currentEffect = entity.getEffect(AEffects.BrokenArmor);
            int newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 4) : 0;
            if (event.getSource().is(DamageTypes.EXPLOSION) || event.getSource().is(DamageTypes.PLAYER_EXPLOSION)) {
                if (entity.getArmorValue() > 0) {
                    if (entity.getRandom().nextFloat() < 0.4) {
                        entity.addEffect(new MobEffectInstance(AEffects.BrokenArmor, randomLongDuration, newAmplifier));

                    }
                    if (damageAmount > 10.0) {
                        currentEffect = entity.getEffect(AEffects.RupturedArmor);
                        newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 2) : 0;
                        if (entity.getRandom().nextFloat() < 0.1) {
                            entity.addEffect(new MobEffectInstance(AEffects.RupturedArmor, randomMediumDuration, newAmplifier));
                        }
                    }
                }
            }

            if (event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {
                entity.addEffect(new MobEffectInstance(AEffects.Shocked, randomVeryShortDuration, rangedAmplifier));
            }

            if (mob instanceof Mob && ((Mob) mob).isAggressive()) {
                currentEffect = entity.getEffect(AEffects.Frail);
                newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 2) : 0;
                if (entity.getRandom().nextFloat() < 0.05) {
                    entity.addEffect(new MobEffectInstance(AEffects.Frail, randomMediumDuration, newAmplifier));
                }
            }

            if (mob instanceof PiglinBrute) {
                currentEffect = entity.getEffect(AEffects.RupturedArmor);
                newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 2) : 0;
                if (entity.getArmorValue() > 0) {
                    entity.addEffect(new MobEffectInstance(AEffects.RupturedArmor, randomShortDuration, newAmplifier));
                }
            }

            if (mob instanceof Blaze) {
                if (entity.getRandom().nextFloat() < 0.25) {
                    entity.addEffect(new MobEffectInstance(AEffects.Burning, randomShortDuration, baseAmplifier));
                }
            }

            if (mob instanceof Illusioner) {
                if (entity.getRandom().nextFloat() < 0.1) {
                    entity.addEffect(new MobEffectInstance(AEffects.Confusion, randomShortDuration, baseAmplifier));
                }
            }
        }
    }
}