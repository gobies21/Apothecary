package net.gobies.apothecary.event;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.effect.PotionSickness;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.BlacklistedEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class EffectEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new EffectEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getSource();
        Entity entity = event.getEntity();
        float damageDealt = event.getAmount();
        if (source.getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(AEffects.Wrath.get())) {
                int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Wrath.get())).getAmplifier();
                float increasedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.WRATH_DAMAGE_INCREASE.get() * (amplifier + 1))));
                event.setAmount(increasedDamage);
            }
            if (source.is(DamageTypes.ARROW)) {
                if (attacker.hasEffect(AEffects.Archery.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Archery.get())).getAmplifier();
                    int increasedDamage = (int) (event.getAmount() + CommonConfig.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1));
                    event.setAmount(increasedDamage);
                }
                if (attacker.hasEffect(AEffects.Misfire.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Misfire.get())).getAmplifier();
                    int reducedDamage = (int) (event.getAmount() - CommonConfig.MISFIRE_DAMAGE_DECREASE.get() * (amplifier + 1));
                    if (reducedDamage < 1) {
                        reducedDamage = 1;
                    }
                    event.setAmount(reducedDamage);
                }
            }
            if (attacker.hasEffect(AEffects.Feeble.get())) {
                int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.Feeble.get())).getAmplifier();
                float reducedDamage = event.getAmount() * (1.0f - (0.10f * (amplifier + 1)));
                event.setAmount(reducedDamage);
            }
            if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
                if (attacker.hasEffect(AEffects.MagicPower.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.MagicPower.get())).getAmplifier();
                    float increasedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.MAGIC_POWER_INCREASE.get() * (amplifier + 1))));
                    event.setAmount(increasedDamage);
                }
                if (attacker.hasEffect(AEffects.MagicDrain.get())) {
                    int amplifier = Objects.requireNonNull(attacker.getEffect(AEffects.MagicDrain.get())).getAmplifier();
                    float reducedDamage = (float) (event.getAmount() * (1.0f - (CommonConfig.MAGIC_DRAIN_DECREASE.get() * (amplifier + 1))));
                    event.setAmount(reducedDamage);
                }
            }
        }
        if (entity instanceof LivingEntity defender) {
            if (defender.hasEffect(AEffects.Vulnerable.get())) {
                int amplifier = Objects.requireNonNull(defender.getEffect(AEffects.Vulnerable.get())).getAmplifier();
                float reducedDamage = (float) (event.getAmount() * (1.0f + (CommonConfig.VULNERABLE_DAMAGE_TAKEN.get() * (amplifier + 1))));
                event.setAmount(reducedDamage);
            }
        }
        if (livingEntity.hasEffect(AEffects.Thorns.get()) && source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker) {
            int amplifier = Objects.requireNonNull(livingEntity.getEffect(AEffects.Thorns.get())).getAmplifier();
            float damageReflect = (float) (damageDealt * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1)) + 1;

            DamageSource thornsDamage = source.getEntity().damageSources().thorns(livingEntity);

            attacker.hurt(thornsDamage, damageReflect);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance.getEffect() == AEffects.PotionSickness.get()) {
            event.setResult(MobEffectEvent.Result.ALLOW);
            return;
        }
        if (event.getEntity().hasEffect(AEffects.PotionSickness.get())) return;

        if (event.getEntity().hasEffect(AEffects.Purification.get()) && BlacklistedEffects.isHarmfulEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
        if (event.getEntity().hasEffect(AEffects.Corruption.get()) && BlacklistedEffects.isBeneficialEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
    }

    @SubscribeEvent
    public void onMobEffectRemovable(MobEffectEvent.Remove event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(AEffects.PotionSickness.get())) {
                if (player.getUseItem().is(Items.MILK_BUCKET)) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (!CommonConfig.ENABLE_WORLD_EVENTS.get() && !CommonConfig.ENABLE_POTION_SICKNESS.get()) return;
        if (event.getEntity().level().isClientSide() || !(event.getEntity() instanceof Player player)) return;
        if (player.tickCount % 10 != 0) return;

        int beneficialEffectCount = (int) player.getActiveEffects().stream()
                .filter(instance -> instance.getEffect().getCategory() == MobEffectCategory.BENEFICIAL)
                .filter(instance -> instance.getEffect() != MobEffects.HEAL)
                .filter(instance -> instance.getEffect() != AEffects.Extension.get())
                .count();

        boolean hasPotionSickness = player.hasEffect(AEffects.PotionSickness.get());
        int maxAllowedEffects = CommonConfig.POTION_SICKNESS_MAX_EFFECTS.get();
        int amplifier = (beneficialEffectCount - maxAllowedEffects) - 1;

        if (beneficialEffectCount > maxAllowedEffects && !hasPotionSickness) {
            player.addEffect(new MobEffectInstance(AEffects.PotionSickness.get(), 320, amplifier));
            if (CommonConfig.POTION_SICKNESS_INSTANT_EFFECT.get()) {
                PotionSickness.applyRandomNegativeEffects(player, 1);
            }
            return;
        }

        if (hasPotionSickness && beneficialEffectCount > maxAllowedEffects) {
            MobEffectInstance potionSickness = player.getEffect(AEffects.PotionSickness.get());
            if (potionSickness != null && (potionSickness.getDuration() < 290 || potionSickness.getAmplifier() != amplifier)) {
                if (potionSickness.getAmplifier() > amplifier) {
                    player.removeEffect(AEffects.PotionSickness.get());
                }
                player.addEffect(new MobEffectInstance(AEffects.PotionSickness.get(), 320, amplifier, false, true, true));
            }
        }
        if (beneficialEffectCount <= maxAllowedEffects) {
            player.removeEffect(AEffects.PotionSickness.get());
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void MovementEvent(MovementInputUpdateEvent event) {
        Minecraft player = Minecraft.getInstance();
        if (event.getEntity().hasEffect(AEffects.Confusion.get())) {
            Input input = event.getInput();
            input.leftImpulse *= -1;
            input.forwardImpulse *= -1;
            input.up = !input.up;
            input.down = !input.down;
            input.jumping = player.options.keyShift.isDown();
            input.shiftKeyDown = player.options.keyJump.isDown();
        }
    }
}
