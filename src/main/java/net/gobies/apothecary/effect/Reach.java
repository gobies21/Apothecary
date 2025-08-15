package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Reach extends MobEffect {
    private static final UUID ENTITY_REACH_UUID = UUID.randomUUID();
    private static final UUID BLOCK_REACH_UUID = UUID.randomUUID();

    public Reach(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void addAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(livingEntity, attribute, amplifier);
        var EntityReach = livingEntity.getAttribute(ForgeMod.ENTITY_REACH.get());
        if (EntityReach != null && EntityReach.getModifier(ENTITY_REACH_UUID) == null) {
            double entityReach = CommonConfig.REACH_INCREASE.get() * (amplifier + 1);
            EntityReach.addPermanentModifier(
                    new AttributeModifier(ENTITY_REACH_UUID, "Entity Reach", entityReach, AttributeModifier.Operation.ADDITION));
        }

        var BlockReach = livingEntity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (BlockReach != null && BlockReach.getModifier(BLOCK_REACH_UUID) == null) {
            double blockReach = CommonConfig.REACH_INCREASE.get() * (amplifier + 1);
            BlockReach.addPermanentModifier(
                    new AttributeModifier(BLOCK_REACH_UUID, "Block Reach", blockReach, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity livingEntity, @NotNull AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(livingEntity, attributeMap, amplifier);
        var EntityReach = livingEntity.getAttribute(ForgeMod.ENTITY_REACH.get());
        if (EntityReach != null && EntityReach.getModifier(ENTITY_REACH_UUID) != null) {
            EntityReach.removeModifier(ENTITY_REACH_UUID);
        }

        var BlockReach = livingEntity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (BlockReach != null && BlockReach.getModifier(BLOCK_REACH_UUID) != null) {
            BlockReach.removeModifier(BLOCK_REACH_UUID);
        }
    }
}