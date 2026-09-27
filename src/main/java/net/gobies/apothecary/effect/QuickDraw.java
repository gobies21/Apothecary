 package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class QuickDraw extends MobEffect {
    public QuickDraw(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation DRAW_SPEED_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.quick_draw.draw_speed");
    private static final ResourceLocation PROJECTILE_VELOCITY_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.quick_draw.projectile_velocity");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double drawSpeed = CommonConfig.QUICK_DRAW_SPEED_INCREASE.get();
        double projectileVelocity = CommonConfig.QUICK_DRAW_VELOCITY_INCREASE.get();
        this.addAttributeModifier(AAttributes.DRAW_SPEED, DRAW_SPEED_KEY, drawSpeed, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(AAttributes.PROJECTILE_VELOCITY, PROJECTILE_VELOCITY_KEY, projectileVelocity, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        super.createModifiers(amplifier, consumer);
    }
}
