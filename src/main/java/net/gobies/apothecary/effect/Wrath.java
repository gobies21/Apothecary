package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class Wrath extends MobEffect {
    public Wrath(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID DAMAGE_MULTIPLIER = UUID.fromString("34565c67-7ef3-4efb-991d-a09abcb2219d");

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(AAttributes.DAMAGE_MULTIPLIER.get(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.DAMAGE_MULTIPLIER.get(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(DAMAGE_MULTIPLIER, this::getDescriptionId, CommonConfig.WRATH_DAMAGE_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}