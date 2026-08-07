package net.gobies.apothecary.mixin;

import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class LivingEntityMixin {

    @Inject(
            method = "createLivingAttributes",
            at = @At("RETURN")
    )
    private static void addAttributes(final CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        cir.getReturnValue().add(AAttributes.DAMAGE_RESISTANCE).add(AAttributes.MAGIC_SHIELDING).add(AAttributes.DAMAGE_MULTIPLIER).add(AAttributes.JUMP_HEIGHT).add(AAttributes.MAGIC_DAMAGE).add(AAttributes.PROJECTILE_DAMAGE);
    }

    @Redirect(
            method = "getDamageAfterMagicAbsorb",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;hasEffect(Lnet/minecraft/core/Holder;)Z"
            )
    )
    private boolean redirectResistance(LivingEntity instance, Holder<MobEffect> effect) {
        if (effect.value() == MobEffects.DAMAGE_RESISTANCE.value()) {
            return false;
        }
        return instance.hasEffect(effect);
    }

    @Redirect(
            method = "getJumpBoostPower",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;hasEffect(Lnet/minecraft/core/Holder;)Z"
            )
    )
    private boolean redirectJumpBoost(LivingEntity instance, Holder<MobEffect> effect) {
        if (effect.value() == MobEffects.JUMP.value()) {
            return false;
        }
        return instance.hasEffect(effect);
    }
}