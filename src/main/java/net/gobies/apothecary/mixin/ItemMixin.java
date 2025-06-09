package net.gobies.apothecary.mixin;

import net.gobies.apothecary.Config;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(
            method = "isFoil",
            at = @At("HEAD"),
            cancellable = true
    )
    private void potionEnchanted(ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        if (pStack.getItem() instanceof PotionItem) {
            List<MobEffectInstance> effects = PotionUtils.getMobEffects(pStack);
            if (!effects.isEmpty()) {
                cir.setReturnValue(Config.ENABLE_ENCHANTED_GLOW.get());
            }
        }
    }
}