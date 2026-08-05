package net.gobies.apothecary.mixin;

import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Player.class, priority = 1500)
public class PlayerMixin {

    @Redirect(
            method = "getDigSpeed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/effect/MobEffectUtil;hasDigSpeed(Lnet/minecraft/world/entity/LivingEntity;)Z"
            )
    )
    private boolean redirectJumpBoost(LivingEntity entity) {
        if (MobEffectUtil.hasDigSpeed(entity)) {
            return false;
        }
        return entity.hasEffect(MobEffects.DIG_SPEED);
    }
}
