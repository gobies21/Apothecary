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

public class QuickDraw extends MobEffect {
    public QuickDraw(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final UUID DRAW_SPEED = UUID.fromString("96525014-96d8-4425-b51a-45527e810463");
    private static final UUID PROJECTILE_VELOCITY = UUID.fromString("0c444657-a4ff-4183-8490-16aec2875a5d");


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
        return new AttributeModifier(DRAW_SPEED, this::getDescriptionId, CommonConfig.QUICK_DRAW_SPEED_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }

    private AttributeModifier createModifier2() {
        return new AttributeModifier(PROJECTILE_VELOCITY, this::getDescriptionId, CommonConfig.QUICK_DRAW_VELOCITY_INCREASE.get(), AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
