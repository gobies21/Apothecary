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

public class DiamondSkin extends MobEffect {
    public DiamondSkin(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation ARMOR_TOUGHNESS_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.diamond_skin.armor_toughness");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double armorToughness = CommonConfig.DIAMOND_SKIN_ARMOR_INCREASE.get();
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS_KEY, armorToughness, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}
