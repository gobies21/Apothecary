package net.gobies.apothecary.effect;

import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class MagicShield extends MobEffect {
    public MagicShield(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation MAGIC_SHIELDING_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.magic_shield.magic_shielding");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        this.addAttributeModifier(AAttributes.MAGIC_SHIELDING, MAGIC_SHIELDING_KEY, 2, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}
