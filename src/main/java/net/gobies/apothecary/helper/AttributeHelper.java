package net.gobies.apothecary.helper;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

import java.util.UUID;

@EventBusSubscriber(modid = Apothecary.MOD_ID)
public class AttributeHelper {

    private static final ResourceLocation DAMAGE_RESISTANCE_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.resistance.damage_resistance");
    private static final ResourceLocation JUMP_HEIGHT_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.jump_boost.jump_height");
    private static final ResourceLocation DIG_SPEED_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.haste.dig_speed");

    public static void attachAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MobEffects.DAMAGE_RESISTANCE.value().addAttributeModifier(AAttributes.DAMAGE_RESISTANCE, DAMAGE_RESISTANCE_KEY, CommonConfig.RESISTANCE_DAMAGE_RESISTANCE.get(), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
            MobEffects.JUMP.value().addAttributeModifier(AAttributes.JUMP_HEIGHT, JUMP_HEIGHT_KEY, CommonConfig.JUMP_BOOST_JUMP_HEIGHT.get(), AttributeModifier.Operation.ADD_VALUE);
            MobEffects.DIG_SPEED.value().addAttributeModifier(AAttributes.DIG_SPEED, DIG_SPEED_KEY, CommonConfig.HASTE_DIG_SPEED.get(), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        });
    }

    @SubscribeEvent
    public static void onAttributeModification(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, AAttributes.DIG_SPEED);
    }

    public static void applyModifiers(ItemAttributeModifierEvent event, Attribute attribute, UUID uuid, String name, double value) {
        Holder<Attribute> holder = BuiltInRegistries.ATTRIBUTE.wrapAsHolder(attribute);
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath("apothecary", uuid.toString().toLowerCase().replace(":", ""));

        for (ItemAttributeModifiers.Entry entry : event.getModifiers()) {
            if (entry.attribute().equals(holder)) {
                AttributeModifier original = entry.modifier();
                event.removeModifier(holder, original.id());
                event.addModifier(holder, new AttributeModifier(original.id(), original.amount() + value, original.operation()), entry.slot());
                return;
            }
        }

        event.addModifier(holder, new AttributeModifier(resourceLocation, value, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ANY);
    }
}