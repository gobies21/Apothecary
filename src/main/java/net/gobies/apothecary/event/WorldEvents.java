package net.gobies.apothecary.event;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.Config;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID)
public class WorldEvents {

    static {
        MinecraftForge.EVENT_BUS.register(WorldEvents.class);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        Entity mob = event.getSource().getEntity();
        if (entity != null && (Config.ENABLE_WORLD_EVENTS.get())) {
            float damageAmount = event.getAmount();
            int randomMediumDuration = DurationUtils.getRandomMediumDuration();
            int randomShortDuration = DurationUtils.getRandomShortDuration();
            int randomVeryShortDuration = DurationUtils.getRandomVeryShortDuration();
            int randomLongDuration = DurationUtils.getRandomLongDuration();
            int baseAmplifier = 0;
            MobEffectInstance currentEffect = entity.getEffect(AEffects.BrokenArmor.get());
            int newAmplifier = (currentEffect != null) ? currentEffect.getAmplifier() + 1 : 0;
            if (event.getSource().is(DamageTypes.EXPLOSION) || event.getSource().is(DamageTypes.PLAYER_EXPLOSION)) {
                if (entity.getArmorValue() > 0) {
                    if (entity.getRandom().nextFloat() < 0.5) {
                        entity.addEffect(new MobEffectInstance(AEffects.BrokenArmor.get(), randomLongDuration, newAmplifier));

                    }
                    if (damageAmount > 3.0) {
                        currentEffect = entity.getEffect(AEffects.RupturedArmor.get());
                        newAmplifier = (currentEffect != null) ? currentEffect.getAmplifier() + 1 : 0;
                        if (entity.getRandom().nextFloat() < 0.1) {
                            entity.addEffect(new MobEffectInstance(AEffects.RupturedArmor.get(), randomMediumDuration, newAmplifier));
                        }
                    }
                }
            }

            if (event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {
                entity.addEffect(new MobEffectInstance(AEffects.Shocked.get(), randomVeryShortDuration, baseAmplifier));
            }

            if (mob instanceof Mob && ((Mob) mob).isAggressive()) {
                currentEffect = entity.getEffect(AEffects.Feeble.get());
                newAmplifier = (currentEffect != null) ? currentEffect.getAmplifier() + 1 : 0;
                if (entity.getRandom().nextFloat() < 0.05) {
                    entity.addEffect(new MobEffectInstance(AEffects.Feeble.get(), randomMediumDuration, newAmplifier));
                }
            }

            if (mob instanceof PiglinBrute) {
                currentEffect = entity.getEffect(AEffects.RupturedArmor.get());
                newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 4) : 0;
                if (entity.getArmorValue() > 0) {
                    entity.addEffect(new MobEffectInstance(AEffects.RupturedArmor.get(), randomShortDuration, newAmplifier));
                }
            }

            if (mob instanceof Blaze) {
                if (entity.getRandom().nextFloat() < 0.25) {
                    entity.addEffect(new MobEffectInstance(AEffects.Burning.get(), randomShortDuration, baseAmplifier));
                }
            }

            if (mob instanceof Illusioner) {
                if (entity.getRandom().nextFloat() < 0.1) {
                    entity.addEffect(new MobEffectInstance(AEffects.Confusion.get(), randomShortDuration, baseAmplifier));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {

    }
}