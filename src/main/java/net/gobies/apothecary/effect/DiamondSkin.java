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

public class DiamondSkin extends MobEffect {
    private static final UUID ARMOR_TOUGHNESS = UUID.fromString("92a78aa3-c5b4-422e-82c1-270ccbc2e2d2");

    public DiamondSkin(MobEffectCategory category, int color) {
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
        return new AttributeModifier(ARMOR_TOUGHNESS, this::getDescriptionId, CommonConfig.DIAMOND_SKIN_ARMOR_INCREASE.get(), AttributeModifier.Operation.ADDITION);
    }
}
