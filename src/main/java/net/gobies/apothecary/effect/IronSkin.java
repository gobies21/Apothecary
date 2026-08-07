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

public class IronSkin extends MobEffect {
    public IronSkin(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation ARMOR_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.iron_skin.armor");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double armor = CommonConfig.IRON_SKIN_ARMOR_INCREASE.get();
        this.addAttributeModifier(Attributes.ARMOR, ARMOR_KEY, armor, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}