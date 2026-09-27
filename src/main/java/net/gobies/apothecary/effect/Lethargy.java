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

public class Lethargy extends MobEffect {
    public Lethargy(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID DRAW_SPEED = UUID.fromString("d48e7557-c3cc-4136-84d9-eaed8600a634");
    private static final UUID PROJECTILE_VELOCITY = UUID.fromString("83de54db-ef60-4c46-a7e8-c787975fd133");


    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(AAttributes.DRAW_SPEED.get(), createModifier());
        this.getAttributeModifiers().put(AAttributes.PROJECTILE_VELOCITY.get(), createModifier2());
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(AAttributes.DRAW_SPEED.get(), createModifier());
        modifiers.put(AAttributes.PROJECTILE_VELOCITY.get(), createModifier2());
        return modifiers;
    }

    private AttributeModifier createModifier() {
        return new AttributeModifier(DRAW_SPEED, this::getDescriptionId, -CommonConfig.LETHARGY_SPEED_DECREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }

    private AttributeModifier createModifier2() {
        return new AttributeModifier(PROJECTILE_VELOCITY, this::getDescriptionId, -CommonConfig.LETHARGY_VELOCITY_DECREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
