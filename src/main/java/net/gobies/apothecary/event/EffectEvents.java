package net.gobies.apothecary.event;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.effect.PotionSickness;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.BlacklistedEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.Objects;

public class EffectEvents {

    public static void register() {
        NeoForge.EVENT_BUS.register(new EffectEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingIncomingDamageEvent event) {
        if (!CommonConfig.APOTHECARY_ENABLED.get()) return;
        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getSource();
        float damageDealt = event.getAmount();
        if (livingEntity.hasEffect(AEffects.Thorns) && source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker) {
            int amplifier = Objects.requireNonNull(livingEntity.getEffect(AEffects.Thorns)).getAmplifier();
            float damageReflect = (float) (damageDealt * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1)) + 1;

            DamageSource thornsDamage = source.getEntity().damageSources().thorns(livingEntity);
            attacker.hurt(thornsDamage, damageReflect);
        }
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance.getEffect().is(AEffects.PotionSickness.getKey())) {
            event.setResult(MobEffectEvent.Applicable.Result.APPLY);
            return;
        }
        if (event.getEntity().hasEffect(AEffects.PotionSickness)) return;

        if (event.getEntity().hasEffect(AEffects.Purification) && BlacklistedEffects.isHarmfulEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        }
        if (event.getEntity().hasEffect(AEffects.Corruption) && BlacklistedEffects.isBeneficialEffectApplicable(event.getEntity(), effectInstance)) {
            event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
        }
    }

    @SubscribeEvent
    public void onMobEffectRemovable(MobEffectEvent.Remove event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(AEffects.PotionSickness)) {
                if (player.getUseItem().is(Items.MILK_BUCKET)) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(EntityTickEvent.Post event) {
        if (!CommonConfig.ENABLE_WORLD_EVENTS.get() && !CommonConfig.ENABLE_POTION_SICKNESS.get()) return;
        if (event.getEntity().level().isClientSide() || !(event.getEntity() instanceof Player player)) return;
        if (player.tickCount % 10 != 0) return;

        int beneficialEffectCount = (int) player.getActiveEffects().stream()
                .filter(instance -> instance.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL)
                .filter(instance -> instance.getEffect().value() != MobEffects.HEAL.value())
                .filter(instance -> instance.getEffect().value() != AEffects.Extension.get())
                .count();

        boolean hasPotionSickness = player.hasEffect(AEffects.PotionSickness);
        int maxAllowedEffects = CommonConfig.POTION_SICKNESS_MAX_EFFECTS.get();
        int amplifier = (beneficialEffectCount - maxAllowedEffects) - 1;

        if (beneficialEffectCount > maxAllowedEffects && !hasPotionSickness) {
            player.addEffect(new MobEffectInstance(AEffects.PotionSickness, 320, amplifier));
            if (CommonConfig.POTION_SICKNESS_INSTANT_EFFECT.get()) {
                PotionSickness.applyRandomNegativeEffects(player, 1);
            }
            return;
        }

        if (hasPotionSickness && beneficialEffectCount > maxAllowedEffects) {
            MobEffectInstance potionSickness = player.getEffect(AEffects.PotionSickness);
            if (potionSickness != null && (potionSickness.getDuration() < 290 || potionSickness.getAmplifier() != amplifier)) {
                if (potionSickness.getAmplifier() > amplifier) {
                    player.removeEffect(AEffects.PotionSickness);
                }
                player.addEffect(new MobEffectInstance(AEffects.PotionSickness, 320, amplifier, false, true, true));
            }
        }
        if (beneficialEffectCount <= maxAllowedEffects) {
            player.removeEffect(AEffects.PotionSickness);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void MovementEvent(MovementInputUpdateEvent event) {
        Minecraft player = Minecraft.getInstance();
        if (event.getEntity().hasEffect(AEffects.Confusion)) {
            Input input = event.getInput();
            input.leftImpulse *= -1;
            input.forwardImpulse *= -1;
            input.up = !input.up;
            input.down = !input.down;
            input.jumping = player.options.keyShift.isDown();
            input.shiftKeyDown = player.options.keyJump.isDown();
        }
    }

    @SubscribeEvent
    public void onEffectExpired(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null) {
            if (event.getEffectInstance().getEffect().is(AEffects.Flight.getKey())) {
                if (event.getEntity() instanceof Player player) {
                    removeFlight(player);
                }
            }
        }
        if (event.getEffectInstance() != null) {
            if (event.getEffectInstance().getEffect().is(AEffects.Flight.getKey())) {
                event.getEntity().setRemainingFireTicks(0);
                event.getEntity().extinguishFire();
            }
        }
    }

    @SubscribeEvent
    public void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffect().is(AEffects.Flight.getKey())) {
            if (event.getEntity() instanceof Player player) {
                removeFlight(player);
            }
        }
        if (event.getEffect().is(AEffects.Burning.getKey())) {
            event.getEntity().setRemainingFireTicks(0);
            event.getEntity().extinguishFire();
        }
    }

    private static void removeFlight(Player player) {
        if (!player.isCreative() && !player.isSpectator()) {
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
            player.onUpdateAbilities();
        }
    }
}
