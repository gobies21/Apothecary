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

public class Vulnerable extends MobEffect {
    public Vulnerable(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID DAMAGE_RESISTANCE = UUID.fromString("929669ea-eaa5-4c3a-8166-c8da1f413869");

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(AAttributes.DAMAGE_RESISTANCE.get(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.DAMAGE_RESISTANCE.get(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(DAMAGE_RESISTANCE, this::getDescriptionId, -CommonConfig.VULNERABLE_DAMAGE_TAKEN.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
