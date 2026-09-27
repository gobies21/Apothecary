package net.gobies.apothecary.event;

import net.gobies.apothecary.init.AAttributes;
import net.gobies.apothecary.util.AUtils;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
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
                double damageMultiplier = AAttributes.getDamageMultiplierValue(attacker);
                finalAmount *= AUtils.getDamageMultiplier(damageMultiplier);
            }

            if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
                if (attacker.getAttribute(AAttributes.MAGIC_DAMAGE.get()) != null) {
                    double magicDamage = AAttributes.getMagicDamageValue(attacker);
                    finalAmount *= AUtils.getMagicDamage(magicDamage);
                }
            }


            if (source.is(DamageTypeTags.IS_PROJECTILE)) {
                var attribute = attacker.getAttribute(AAttributes.PROJECTILE_DAMAGE.get());
                if (attribute != null) {
                    double flatBonus = 0.0D;
                    double multiplier = 1.0D;

                    for (var modifier : attribute.getModifiers()) {
                        if (modifier.getOperation() == AttributeModifier.Operation.ADDITION) {
                            flatBonus += modifier.getAmount();
                        } else if (modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE) {
                            multiplier += modifier.getAmount();
                        } else if (modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                            multiplier *= (1.0D + modifier.getAmount());
                        }
                    }

                    finalAmount += AUtils.getProjectileDamage(flatBonus);

                    finalAmount *= AUtils.getProjectileDamage(multiplier);
                }
            }
        }

        if (!source.is(DamageTypeTags.BYPASSES_RESISTANCE)) {
            if (livingEntity.getAttribute(AAttributes.DAMAGE_RESISTANCE.get()) != null) {
                double damageResistance = AAttributes.getDamageResistanceValue(livingEntity);
                finalAmount *= AUtils.getDamageResistance(damageResistance);
            }
        }

        if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC)) {
            if (livingEntity.getAttribute(AAttributes.MAGIC_SHIELDING.get()) != null) {
                double magicResistance = AAttributes.getMagicResistanceValue(livingEntity);
                finalAmount *= AUtils.getMagicShielding(magicResistance);
            }
        }

        event.setAmount(Math.max(0, finalAmount));
    }

    @SubscribeEvent
    public void onLivingItemUseTick(LivingEntityUseItemEvent.Tick event) {
        LivingEntity livingEntity = event.getEntity();
        ItemStack stack = event.getItem();

        if (stack.getItem() instanceof ProjectileWeaponItem) {
            double drawSpeed = AAttributes.getDrawSpeedValue(livingEntity);
            int newTicks = AUtils.getDrawSpeed(drawSpeed, livingEntity.tickCount);

            if (newTicks != 0) {
                event.setDuration(event.getDuration() - newTicks);
            }
        }
    }

    @SubscribeEvent
    public void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getEntity() instanceof Projectile projectile)) return;
        if (projectile.getPersistentData().getBoolean("apothecary_velocity")) return;

        var owner = projectile.getOwner();
        if (!(owner instanceof LivingEntity livingEntity)) return;
        var projectileVelocity = AAttributes.getProjectileVelocityValue(livingEntity);
        float finalVelocity = AUtils.getProjectileVelocity(projectileVelocity);
        if (finalVelocity == 0.0f || finalVelocity == 1.0f) return;

        projectile.setDeltaMovement(projectile.getDeltaMovement().scale(finalVelocity));
        projectile.getPersistentData().putBoolean("apothecary_velocity", true);
    }

    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
        if (event.isCanceled()) return;
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity.getAttribute(AAttributes.JUMP_HEIGHT.get()) != null) {
            double jumpHeight = AAttributes.getJumpHeightValue(livingEntity);
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
            double jumpHeight = AAttributes.getJumpHeightValue(livingEntity);

            float adjustedDistance = event.getDistance() - AUtils.getFallDistanceModifier(jumpHeight);
            event.setDistance(Math.max(0, adjustedDistance));
        }
    }

    @SubscribeEvent
    public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.isCanceled()) return;

        Player player = event.getEntity();

        if (player.getAttribute(AAttributes.DIG_SPEED.get()) != null) {
            double digSpeed = AAttributes.getDigSpeedValue(player);
            event.setNewSpeed(event.getNewSpeed() * AUtils.getDigSpeedMultiplier(digSpeed));
        }
    }
}