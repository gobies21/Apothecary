package net.gobies.apothecary.event;

import net.gobies.apothecary.init.AAttributes;
import net.gobies.apothecary.util.AUtils;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AttributeEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new AttributeEvents());
    }

    /*
     * Final values are located in -> net.gobies.apothecary.util.AUtils
     */

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.isCanceled()) return;

        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getSource();
        float finalAmount = event.getAmount();

        if (source.getEntity() instanceof LivingEntity attacker) {
            if (attacker.getAttribute(AAttributes.DAMAGE_MULTIPLIER.get()) != null) {
                double damageMultiplier = AAttributes.getDamageMultiplier(attacker);
                finalAmount *= AUtils.getDamageMultiplier(damageMultiplier);
            }
        }

        if (!source.is(DamageTypeTags.BYPASSES_RESISTANCE)) {
            if (livingEntity.getAttribute(AAttributes.DAMAGE_RESISTANCE.get()) != null) {
                double damageResistance = AAttributes.getDamageResistance(livingEntity);
                finalAmount *= AUtils.getDamageResistance(damageResistance);
            }
        }

        if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
            if (livingEntity.getAttribute(AAttributes.MAGIC_RESISTANCE.get()) != null) {
                double magicResistance = AAttributes.getMagicResistance(livingEntity);
                finalAmount *= AUtils.getMagicResistance(magicResistance);
            }
        }

        event.setAmount(Math.max(0, finalAmount));
    }

    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
        if (event.isCanceled()) return;
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity.getAttribute(AAttributes.JUMP_HEIGHT.get()) != null) {
            double jumpHeight = AAttributes.getJumpHeight(livingEntity);
            if (jumpHeight <= 0.0D) {
                livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().x, 0.0D, livingEntity.getDeltaMovement().z);
                return;
            }

            if (jumpHeight != 1.0D) {
                double finalVelocity = AUtils.getJumpVelocity(jumpHeight);
                livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().x, finalVelocity, livingEntity.getDeltaMovement().z);
            }
        }
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event) {
        if (event.isCanceled()) return;
        LivingEntity livingEntity = event.getEntity();

        if (livingEntity.getAttribute(AAttributes.JUMP_HEIGHT.get()) != null) {
            double jumpHeight = AAttributes.getJumpHeight(livingEntity);

            float adjustedDistance = event.getDistance() - AUtils.getFallDistanceModifier(jumpHeight);
            event.setDistance(Math.max(0, adjustedDistance));
        }
    }

    @SubscribeEvent
    public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.isCanceled()) return;

        Player player = event.getEntity();

        if (player.getAttribute(AAttributes.DIG_SPEED.get()) != null) {
            double digSpeed = AAttributes.getDigSpeed(player);
            event.setNewSpeed(event.getNewSpeed() * AUtils.getDigSpeedMultiplier(digSpeed));
        }
    }
}