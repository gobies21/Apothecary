package net.gobies.apothecary.mixin;

import net.gobies.apothecary.init.AEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(BowItem.class)
public abstract class BowItemMixin {

    /*
    @Inject(
            method = "getUseDuration",
            at = @At("RETURN"),
            cancellable = true
    )
    private void modifyDrawSpeed(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
        if (!player.hasEffect(AEffects.QuickDraw.get())) return;
        int amplifier = Objects.requireNonNull(player.getEffect(AEffects.QuickDraw.get())).getAmplifier();
        double speedPercent = 0.20 * (amplifier + 1);
        int duration = cir.getReturnValue();
        duration -= (int) (duration * speedPercent);

        cir.setReturnValue(duration);
    }

     */
}