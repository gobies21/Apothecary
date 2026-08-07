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

public class Archery extends MobEffect {
    public Archery(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation PROJECTILE_DAMAGE_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.archery.projectile_damage");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double projectileDamage = CommonConfig.ARCHERY_DAMAGE_INCREASE.get();
        this.addAttributeModifier(AAttributes.PROJECTILE_DAMAGE, PROJECTILE_DAMAGE_KEY, projectileDamage, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}
