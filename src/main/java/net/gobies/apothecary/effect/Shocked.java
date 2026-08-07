package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class Shocked extends MobEffect {
    public Shocked(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation MOVEMENT_SPEED_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.shocked.movement_speed");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double speedDecrease = CommonConfig.SHOCKED_SPEED_DECREASE.get();
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_KEY, -speedDecrease, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        super.createModifiers(amplifier, consumer);
    }
}