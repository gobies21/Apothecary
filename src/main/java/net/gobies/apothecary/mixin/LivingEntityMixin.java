package net.gobies.apothecary.mixin;

import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(
            method = "createLivingAttributes",
            at = @At("RETURN")
    )
    private static void addAttributes(final CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        cir.getReturnValue().add(AAttributes.DAMAGE_RESISTANCE.get()).add(AAttributes.MAGIC_SHIELDING.get()).add(AAttributes.DAMAGE_MULTIPLIER.get()).add(AAttributes.JUMP_HEIGHT.get()).add(AAttributes.MAGIC_DAMAGE.get()).add(AAttributes.PROJECTILE_DAMAGE.get());
    }

    @Redirect(
            method = "getDamageAfterMagicAbsorb",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;hasEffect(Lnet/minecraft/world/effect/MobEffect;)Z"
            )
    )
    private boolean redirectResistance(LivingEntity instance, MobEffect effect) {
        if (effect == MobEffects.DAMAGE_RESISTANCE) {
            return false;
        }
        return instance.hasEffect(effect);
    }

    @Redirect(
            method = "getJumpBoostPower",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;hasEffect(Lnet/minecraft/world/effect/MobEffect;)Z"
            )
    )
    private boolean redirectJumpBoost(LivingEntity instance, MobEffect effect) {
        if (effect == MobEffects.JUMP) {
            return false;
        }
        return instance.hasEffect(effect);
    }
}