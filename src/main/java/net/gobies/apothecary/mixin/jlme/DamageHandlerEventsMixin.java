package net.gobies.apothecary.mixin.jlme;

/*
import com.kettle.jlme.events.DamageHandlerEvents;
import com.kettle.jlme.init.JlmeModEnchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DamageHandlerEvents.class)
public class DamageHandlerEventsMixin {

    @Redirect(
            method = "DamageIncrease",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;)I"
            ), remap = false
    )
    private static int disableNaturalBlockingEnchant(ItemStack stack, Enchantment enchantment) {
        if (enchantment == JlmeModEnchantments.natural_blocking) {
            return 0;
        }
        return stack.getEnchantmentLevel(enchantment);
    }
}

 */
