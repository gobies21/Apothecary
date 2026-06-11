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

public class IronSkin extends MobEffect {
    private static final UUID ARMOR = UUID.fromString("3ac7adb5-cd93-4287-b34f-8cc9135e7abc");

    public IronSkin(MobEffectCategory category, int color) {
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
        return new AttributeModifier(ARMOR, this::getDescriptionId, CommonConfig.IRON_SKIN_ARMOR_INCREASE.get(), AttributeModifier.Operation.ADDITION);
    }
}