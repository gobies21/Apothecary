package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Extension extends MobEffect {
    public Extension(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        if (!entity.getActiveEffects().isEmpty()) {
            List<MobEffectInstance> effectsToUpdate = new ArrayList<>(entity.getActiveEffects());
            for (MobEffectInstance effectInstance : effectsToUpdate) {
                MobEffect effect = effectInstance.getEffect();
                ResourceLocation effectId = ForgeRegistries.MOB_EFFECTS.getKey(effect);
                if (effectId != null && !CommonConfig.EXTENSION_BLACKLIST_EFFECTS.get().contains(effectId.toString())) {
                    int currentDuration = effectInstance.getDuration();
                    int extensionCap = (20 * CommonConfig.EXTENSION_CAP.get()) + 10;
                    int durationToAdd = 20 * 15 * (pAmplifier + 1);
                    int newDuration = Math.min(currentDuration + durationToAdd, extensionCap);

                    int amplifier = effectInstance.getAmplifier();
                    entity.removeEffect(effect);
                    entity.addEffect(new MobEffectInstance(effect, newDuration, amplifier));
                }
            }
        } else {
            System.out.println("No active effects to update");
        }
    }
}
