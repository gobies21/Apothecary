package net.gobies.apothecary.mixin;

import net.gobies.apothecary.Config;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


//@Mixin(PotionItem.class)
public class PotionItemMixin {

//    @Unique
//    private static int apothecary$stackSize = 1;

//    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
//    private static Item.Properties potionStack(Item.Properties properties) {
//        return properties.stacksTo(apothecary$stackSize);
//    }

//    @Unique
//    @SubscribeEvent
//    private static void apothecary$initStackSize() {
//        if (apothecary$stackSize == 1) {
//            apothecary$stackSize = Config.IRON_SKIN_ARMOR_INCREASE.get();
//        }
//    }
}