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

public class Frail extends MobEffect {
    public Frail(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation DAMAGE_MULTIPLIER_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.frail.damage_multiplier");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double damageDecrease = CommonConfig.FRAIL_DAMAGE_DECREASE.get();
        this.addAttributeModifier(AAttributes.DAMAGE_MULTIPLIER, DAMAGE_MULTIPLIER_KEY, -damageDecrease, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        super.createModifiers(amplifier, consumer);
    }
}
