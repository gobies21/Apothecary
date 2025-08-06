package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class Chilled extends MobEffect {
    private static final UUID MOVEMENT_SPEED_UUID = UUID.randomUUID();
    private static final UUID ATTACK_SPEED_UUID = UUID.randomUUID();

    public Chilled(MobEffectCategory category, int color) {
        super(category, color);
        MinecraftForge.EVENT_BUS.register(this);
    }

    static {
        MinecraftForge.EVENT_BUS.register(Chilled.class);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.hasEffect(AEffects.Chilled.get())) {
            if (entity.isOnFire() || entity.isInLava()) {
                entity.removeEffect(AEffects.Chilled.get());

            }
        }
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);

        var AttackSpeed = entity.getAttribute(Attributes.ATTACK_SPEED);
        if (AttackSpeed != null && AttackSpeed.getModifier(ATTACK_SPEED_UUID) == null) {
            double attackSpeed = CommonConfig.CHILLED_SPEED_DECREASE.get() * (amplifier + 1);
            AttackSpeed.addPermanentModifier(
                    new AttributeModifier(ATTACK_SPEED_UUID, "Chilled Reduced Attack Speed", -attackSpeed, AttributeModifier.Operation.MULTIPLY_BASE));
        }

        var MovementSpeed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (MovementSpeed != null && MovementSpeed.getModifier(MOVEMENT_SPEED_UUID) == null) {
            double movementSpeed = CommonConfig.CHILLED_SPEED_DECREASE.get() * (amplifier + 1);
            MovementSpeed.addPermanentModifier(
                    new AttributeModifier(MOVEMENT_SPEED_UUID, "Chilled Reduced Movement Speed", -movementSpeed, AttributeModifier.Operation.MULTIPLY_BASE));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.removeAttributeModifiers(entity, attribute, amplifier);
        var AttackSpeed = entity.getAttribute(Attributes.ATTACK_SPEED);
        if (AttackSpeed != null && AttackSpeed.getModifier(ATTACK_SPEED_UUID) != null) {
            AttackSpeed.removeModifier(ATTACK_SPEED_UUID);
        }

        var MovementSpeed = entity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (MovementSpeed != null && MovementSpeed.getModifier(MOVEMENT_SPEED_UUID) != null) {
            MovementSpeed.removeModifier(MOVEMENT_SPEED_UUID);
        }
    }

    @SubscribeEvent
    public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        LivingEntity player = event.getEntity();
        if (player.hasEffect(AEffects.Chilled.get())) {
            int amplifier = Objects.requireNonNull(player.getEffect(AEffects.Chilled.get())).getAmplifier();
            double miningSpeedDecrease = 0;
            if (amplifier >= 0) {
                miningSpeedDecrease = CommonConfig.CHILLED_SPEED_DECREASE.get() * (amplifier + 1);
            }
            double newBreakSpeed = event.getNewSpeed() * (1.0 - miningSpeedDecrease);

            event.setNewSpeed((float) newBreakSpeed);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}