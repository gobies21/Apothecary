package net.gobies.apothecary.mixin;

import net.gobies.apothecary.config.ClientConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(
            method = "isFoil",
            at = @At("HEAD"),
            cancellable = true
    )
    private void potionEnchanted(ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        if (pStack.getItem() instanceof PotionItem) {
            PotionContents contents = pStack.get(DataComponents.POTION_CONTENTS);
            if (contents != null && contents.hasEffects()) {
                cir.setReturnValue(ClientConfig.ENABLE_ENCHANTED_GLOW.get());
            }
        }
    }
}