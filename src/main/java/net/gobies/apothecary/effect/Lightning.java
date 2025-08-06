package net.gobies.apothecary.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Lightning extends MobEffect {
    public Lightning(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        summonLightning(entity);
    }

    private void summonLightning(LivingEntity entity) {
        if (!entity.level().isClientSide) {
            Level level = entity.level();
            BlockPos blockPos = entity.blockPosition();
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightningBolt.setPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            level.addFreshEntity(lightningBolt);
        }
    }
}