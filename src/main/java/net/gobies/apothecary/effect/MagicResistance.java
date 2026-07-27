package net.gobies.apothecary.effect;

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

public class MagicResistance extends MobEffect {
    private static final UUID MAGIC_RESISTANCE = UUID.fromString("cc47d5b8-0525-403a-a631-a9f3e282ff39");

    public MagicResistance(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(AAttributes.MAGIC_RESISTANCE.get(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.MAGIC_RESISTANCE.get(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(MAGIC_RESISTANCE, this::getDescriptionId, 2, AttributeModifier.Operation.ADDITION);
    }
}
