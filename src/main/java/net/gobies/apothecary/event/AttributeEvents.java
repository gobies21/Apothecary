package net.gobies.apothecary.event;

import net.gobies.apothecary.init.AAttributes;
import net.gobies.apothecary.util.AUtils;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class AttributeEvents {

    public static void register() {
        NeoForge.EVENT_BUS.register(new AttributeEvents());
    }

    /*
     * Final values are located in -> net.gobies.apothecary.util.AUtils
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onLivingHurt(LivingIncomingDamageEvent event) {
        if (event.isCanceled()) return;

        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getSource();
        float finalAmount = event.getAmount();

        if (source.getEntity() instanceof LivingEntity attacker) {
            if (attacker.getAttribute(AAttributes.DAMAGE_MULTIPLIER) != null) {
                double damageMultiplier = AAttributes.getDamageMultiplier(attacker);
                finalAmount *= AUtils.getDamageMultiplier(damageMultiplier);
            }

            if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
                if (attacker.getAttribute(AAttributes.MAGIC_DAMAGE) != null) {
                    double magicDamage = AAttributes.getMagicDamage(attacker);
                    finalAmount *= AUtils.getMagicDamage(magicDamage);
                }
            }


            if (source.is(DamageTypeTags.IS_PROJECTILE)) {
                var attribute = attacker.getAttribute(AAttributes.PROJECTILE_DAMAGE);
                if (attribute != null) {
                    double flatBonus = 0.0D;
                    double multiplier = 1.0D;

                    for (var modifier : attribute.getModifiers()) {
                        if (modifier.operation() == AttributeModifier.Operation.ADD_VALUE) {
                            flatBonus += modifier.amount();
                        } else if (modifier.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_BASE) {
                            multiplier += modifier.amount();
                        } else if (modifier.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL) {
                            multiplier *= (1.0D + modifier.amount());
                        }
                    }

                    finalAmount += AUtils.getProjectileDamage(flatBonus);

                    finalAmount *= AUtils.getProjectileDamage(multiplier);
                }
            }
        }

        if (!source.is(DamageTypeTags.BYPASSES_RESISTANCE)) {
            if (livingEntity.getAttribute(AAttributes.DAMAGE_RESISTANCE) != null) {
                double damageResistance = AAttributes.getDamageResistance(livingEntity);
                finalAmount *= AUtils.getDamageResistance(damageResistance);
            }
        }

        if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
            if (livingEntity.getAttribute(AAttributes.MAGIC_SHIELDING) != null) {
                double magicResistance = AAttributes.getMagicResistance(livingEntity);
                finalAmount *= AUtils.getMagicShielding(magicResistance);
            }
        }

        event.setAmount(Math.max(0, finalAmount));
    }

    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity.getAttribute(AAttributes.JUMP_HEIGHT) != null) {
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

        if (livingEntity.getAttribute(AAttributes.JUMP_HEIGHT) != null) {
            double jumpHeight = AAttributes.getJumpHeight(livingEntity);

            float adjustedDistance = event.getDistance() - AUtils.getFallDistanceModifier(jumpHeight);
            event.setDistance(Math.max(0, adjustedDistance));
        }
    }

    @SubscribeEvent
    public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.isCanceled()) return;

        Player player = event.getEntity();

        if (player.getAttribute(AAttributes.DIG_SPEED) != null) {
            double digSpeed = AAttributes.getDigSpeed(player);
            event.setNewSpeed(event.getNewSpeed() * AUtils.getDigSpeedMultiplier(digSpeed));
        }
    }
}