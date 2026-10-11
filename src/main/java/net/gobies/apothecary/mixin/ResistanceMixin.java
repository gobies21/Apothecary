package net.gobies.apothecary.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LivingEntity.class, priority = 1500)
public class ResistanceMixin {

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
}
