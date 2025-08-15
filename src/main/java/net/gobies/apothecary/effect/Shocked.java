package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Shocked extends MobEffect {
    private static final UUID MOVEMENT_SPEED_UUID = UUID.randomUUID();

    public Shocked(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(livingEntity, attribute, amplifier);
        var MovementSpeed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (MovementSpeed != null && MovementSpeed.getModifier(MOVEMENT_SPEED_UUID) == null) {
            double attackSpeed = CommonConfig.SHOCKED_SPEED_DECREASE.get() * (amplifier + 1);
            MovementSpeed.addPermanentModifier(
                    new AttributeModifier(MOVEMENT_SPEED_UUID, "Shocked Reduced Speed", -attackSpeed, AttributeModifier.Operation.MULTIPLY_BASE));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attribute, amplifier);
        var MovementSpeed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (MovementSpeed != null && MovementSpeed.getModifier(MOVEMENT_SPEED_UUID) != null) {
            MovementSpeed.removeModifier(MOVEMENT_SPEED_UUID);
        }
    }

}