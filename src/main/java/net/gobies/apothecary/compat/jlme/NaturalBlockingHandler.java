package net.gobies.apothecary.compat.jlme;

import com.kettle.jlme.configuration.JLMEConfiguration;
import com.kettle.jlme.init.JlmeModEnchantments;
import com.kettle.pml.core.DamageControl;
import com.kettle.pml.events.DamageHandler;
import net.gobies.apothecary.helper.AttributeHelper;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class NaturalBlockingHandler {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new NaturalBlockingHandler());
    }

    private static final UUID DAMAGE_RESISTANCE = UUID.fromString("ae3d7287-7e36-44d9-a60f-1c3117e1a1dd");

    /*
    // Reworks natural blocking to use the damage resistance attribute
     */
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
    public void onLivingHurt(LivingHurtEvent event) {
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
}
