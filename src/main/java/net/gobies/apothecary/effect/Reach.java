package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class Reach extends MobEffect {
    private static final UUID ENTITY_REACH  = UUID.randomUUID();
    private static final UUID BLOCK_REACH = UUID.randomUUID();

    public Reach(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        this.getAttributeModifiers().put(ForgeMod.ENTITY_REACH.get(), createModifier(ENTITY_REACH, CommonConfig.REACH_INCREASE.get()));
        this.getAttributeModifiers().put(ForgeMod.BLOCK_REACH.get(), createModifier(BLOCK_REACH, CommonConfig.REACH_INCREASE.get()));
        super.addAttributeModifiers(livingEntity, attributeMap, amplifier);
    }

    @Override
    public @NotNull Map<Attribute, AttributeModifier> getAttributeModifiers() {
        Map<Attribute, AttributeModifier> modifiers = super.getAttributeModifiers();
        modifiers.put(ForgeMod.ENTITY_REACH.get(), createModifier(ENTITY_REACH, CommonConfig.REACH_INCREASE.get()));
        modifiers.put(ForgeMod.BLOCK_REACH.get(), createModifier(BLOCK_REACH, CommonConfig.REACH_INCREASE.get()));

        return modifiers;
    }

    private AttributeModifier createModifier(UUID uuid, double configValue) {
        return new AttributeModifier(uuid, this::getDescriptionId, configValue, AttributeModifier.Operation.ADDITION);
    }
}