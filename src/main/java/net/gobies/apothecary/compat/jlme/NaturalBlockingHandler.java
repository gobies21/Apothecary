package net.gobies.apothecary.compat.jlme;

import net.gobies.apothecary.helper.AttributeHelper;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class NaturalBlockingHandler {

    public static void loadCompat() {
        NeoForge.EVENT_BUS.register(new NaturalBlockingHandler());
    }

    /*
    // Reworks natural blocking to use the damage resistance attribute
     */

    /*
    @SubscribeEvent
    public void onItemAttributes(ItemAttributeModifierEvent event) {
        if (event.getSlotType() != EquipmentSlot.OFFHAND) return;
        ItemStack stack = event.getItemStack();

        int naturalBlockingLevel = EnchantmentHelper.getTagEnchantmentLevel(JlmeModEnchantments.natural_blocking, stack);
        double damageResistance = JLMEConfiguration.natural_blocking_base + (JLMEConfiguration.natural_blocking_increase * naturalBlockingLevel);
        double roundedValue = Math.round(damageResistance * 100.0) / 100.0;
        if (naturalBlockingLevel > 0) {
            AttributeHelper.applyModifiers(event, AAttributes.DAMAGE_RESISTANCE.get(), DAMAGE_RESISTANCE, "Damage Resistance", roundedValue);
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        float amount = event.getAmount();
        DamageSource damageSource = event.getSource();
        DamageControl controller = DamageHandler.getDamageControl(damageSource);
        if (!event.getEntity().getOffhandItem().isEmpty()) {
            int naturalBlocking = event.getEntity().getOffhandItem().getEnchantmentLevel(JlmeModEnchantments.natural_blocking);
            if (naturalBlocking > 0) {
                float blocked = controller.calculateFinalDamage(amount) * (JLMEConfiguration.natural_blocking_base + JLMEConfiguration.natural_blocking_increase * (float) naturalBlocking);
                entity.getOffhandItem().hurtAndBreak((int) ((double) blocked * (1.6 - 0.2 * (double) naturalBlocking)) + 1, entity, (p) -> p.broadcastBreakEvent(EquipmentSlot.OFFHAND));
            }
        }
    }

     */
}
