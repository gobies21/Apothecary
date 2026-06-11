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

public class BrokenArmor extends MobEffect {
    private static final UUID ARMOR = UUID.fromString("929669ea-eaa5-4c3a-8166-c8da1f413869");

    public BrokenArmor(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(Attributes.ARMOR, createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(Attributes.ARMOR, createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(ARMOR, this::getDescriptionId, -CommonConfig.BROKEN_ARMOR_ARMOR_DECREASE.get(), AttributeModifier.Operation.ADDITION);
    }
}
