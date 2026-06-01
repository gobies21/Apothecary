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

public class Shocked extends MobEffect {
    private static final UUID MOVEMENT_SPEED = UUID.randomUUID();

    public Shocked(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(Attributes.MOVEMENT_SPEED, createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(Attributes.MOVEMENT_SPEED, createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(MOVEMENT_SPEED, this::getDescriptionId, -CommonConfig.SHOCKED_SPEED_DECREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}