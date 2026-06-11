package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class RupturedArmor extends MobEffect {
    private static final UUID ARMOR_TOUGHNESS = UUID.fromString("8e4725c8-5704-4627-8b57-6234c01feb42");

    public RupturedArmor(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(Attributes.ARMOR_TOUGHNESS, createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(Attributes.ARMOR_TOUGHNESS, createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(ARMOR_TOUGHNESS, this::getDescriptionId, -CommonConfig.RUPTURED_ARMOR_ARMOR_DECREASE.get(), AttributeModifier.Operation.ADDITION);
    }
}
