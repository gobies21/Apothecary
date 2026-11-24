package net.gobies.apothecary.helper;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeHelper {

    private static final UUID RESISTANCE_DAMAGE_RESISTANCE = UUID.fromString("0450b038-97d4-47f7-993c-8c6451bb1475");
    private static final UUID JUMP_BOOST_JUMP_HEIGHT = UUID.fromString("6c97a292-6352-4af9-afd0-2c52ecdecf88");
    private static final UUID HASTE_DIG_SPEED = UUID.fromString("e7e166af-47e9-497d-a0b4-64ce5a8ba78d");
    private static final UUID MINING_FATIGUE_DIG_SPEED = UUID.fromString("a7e166af-47e9-497d-a0b4-64ce5a8ba78c");


    public static void attachAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MobEffects.DAMAGE_RESISTANCE.addAttributeModifier(AAttributes.DAMAGE_RESISTANCE.get(), String.valueOf(RESISTANCE_DAMAGE_RESISTANCE), CommonConfig.RESISTANCE_DAMAGE_RESISTANCE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
            MobEffects.JUMP.addAttributeModifier(AAttributes.JUMP_HEIGHT.get(), String.valueOf(JUMP_BOOST_JUMP_HEIGHT), CommonConfig.JUMP_BOOST_JUMP_HEIGHT.get(), AttributeModifier.Operation.ADDITION);
            MobEffects.DIG_SPEED.addAttributeModifier(AAttributes.DIG_SPEED.get(), String.valueOf(HASTE_DIG_SPEED), CommonConfig.HASTE_DIG_SPEED.get(), AttributeModifier.Operation.MULTIPLY_BASE);
            MobEffects.DIG_SLOWDOWN.addAttributeModifier(AAttributes.DIG_SPEED.get(), String.valueOf(MINING_FATIGUE_DIG_SPEED), -CommonConfig.MINING_FATIGUE_DIG_SPEED.get(), AttributeModifier.Operation.MULTIPLY_BASE);
        });
    }

    @SubscribeEvent
    public static void onAttributeModification(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, AAttributes.DIG_SPEED.get());
    }

    public static void applyModifiers(ItemAttributeModifierEvent event, Attribute attribute, UUID uuid, String name, double value) {
        if (event.getModifiers().containsKey(attribute)) {
            var existing = event.getModifiers().get(attribute);
            if (!existing.isEmpty()) {
                AttributeModifier original = existing.iterator().next();
                event.removeModifier(attribute, original);
                event.addModifier(attribute, new AttributeModifier(Objects.requireNonNull(original).getId(), original.getName(), original.getAmount() + value, original.getOperation()));
                return;
            }
        }
        event.addModifier(attribute, new AttributeModifier(uuid, name, value, AttributeModifier.Operation.MULTIPLY_BASE));
    }
}