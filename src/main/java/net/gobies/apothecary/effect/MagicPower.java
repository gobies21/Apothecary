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

public class MagicPower extends MobEffect {
    public MagicPower(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID MAGIC_DAMAGE = UUID.fromString("b7a21d45-b2af-444b-973e-d53fc9fb3c55");

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(AAttributes.MAGIC_DAMAGE.get(), createModifier());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.MAGIC_DAMAGE.get(), createModifier());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(MAGIC_DAMAGE, this::getDescriptionId, CommonConfig.MAGIC_POWER_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
