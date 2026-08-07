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

public class MagicPower extends MobEffect {
    public MagicPower(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation MAGIC_DAMAGE_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.magic_power.magic_damage");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double magicDamage = CommonConfig.MAGIC_POWER_INCREASE.get();
        this.addAttributeModifier(AAttributes.MAGIC_DAMAGE, MAGIC_DAMAGE_KEY, magicDamage, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        super.createModifiers(amplifier, consumer);
    }
}
