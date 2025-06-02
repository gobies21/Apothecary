package net.gobies.apothecary.effect;

import net.gobies.apothecary.Config;
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
    public void addAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attribute, int amplifier) {
        super.addAttributeModifiers(entity, attribute, amplifier);
        var EntityReach = entity.getAttribute(ForgeMod.ENTITY_REACH.get());
        if (EntityReach != null && EntityReach.getModifier(ENTITY_REACH_UUID) == null) {
            double entityReach = Config.REACH_INCREASE.get() * (amplifier + 1);
            EntityReach.addTransientModifier(
                    new AttributeModifier(ENTITY_REACH_UUID, "Entity Reach", entityReach, AttributeModifier.Operation.ADDITION));
        }

        var BlockReach = entity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (BlockReach != null && BlockReach.getModifier(BLOCK_REACH_UUID) == null) {
            double blockReach = Config.REACH_INCREASE.get() * (amplifier + 1);
            BlockReach.addTransientModifier(
                    new AttributeModifier(BLOCK_REACH_UUID, "Block Reach", blockReach, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void removeAttributeModifiers(@NotNull LivingEntity entity, @NotNull AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        var EntityReach = entity.getAttribute(ForgeMod.ENTITY_REACH.get());
        if (EntityReach != null && EntityReach.getModifier(ENTITY_REACH_UUID) != null) {
            EntityReach.removeModifier(ENTITY_REACH_UUID);
        }

        var BlockReach = entity.getAttribute(ForgeMod.BLOCK_REACH.get());
        if (BlockReach != null && BlockReach.getModifier(BLOCK_REACH_UUID) != null) {
            BlockReach.removeModifier(BLOCK_REACH_UUID);
        }
    }
}