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

public class Reach extends MobEffect {
    public Reach(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ResourceLocation ENTITY_REACH_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.reach.entity_reach");
    private static final ResourceLocation BLOCK_REACH_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.reach.block_reach");

    @Override
    public void createModifiers(int amplifier, @NotNull BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        double reach = CommonConfig.REACH_INCREASE.get();
        this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ENTITY_REACH_KEY, reach, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, BLOCK_REACH_KEY, reach, AttributeModifier.Operation.ADD_VALUE);
        super.createModifiers(amplifier, consumer);
    }
}