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

public class BrokenArmor extends MobEffect {
    public BrokenArmor(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation ARMOR_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.broken_armor.armor");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double armorDecrease = CommonConfig.BROKEN_ARMOR_ARMOR_DECREASE.get();
        this.addAttributeModifier(Attributes.ARMOR, ARMOR_KEY, -armorDecrease, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}
