package net.gobies.apothecary.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PotionItem.class)
public class PotionItemMixin {

//    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
//    private static Item.Properties potionStack(Item.Properties properties) {
//        return properties.stacksTo(8);
//    }
}