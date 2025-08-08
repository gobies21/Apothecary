package net.gobies.apothecary.util;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class BlacklistedEffects {

    private static Set<ResourceLocation> CLEANSED_BLACKLISTED_EFFECTS = null;
    private static Set<ResourceLocation> CORRUPTED_BLACKLISTED_EFFECTS = null;

    //Cleansed
    public static void initCleansedBlacklist() {
        if (CLEANSED_BLACKLISTED_EFFECTS == null) {
            CLEANSED_BLACKLISTED_EFFECTS = new HashSet<>();
            for (String effects : CommonConfig.CLEANSED_BLACKLIST_EFFECTS.get()) {
                CLEANSED_BLACKLISTED_EFFECTS.add(new ResourceLocation(effects));
            }
        }
    }

    public static boolean isHarmfulEffectBlacklisted(MobEffect effect) {
        if (CLEANSED_BLACKLISTED_EFFECTS == null) {
            initCleansedBlacklist();
        }
        ResourceLocation effectRegistryName = ForgeRegistries.MOB_EFFECTS.getKey(effect);
        return effectRegistryName == null || !CLEANSED_BLACKLISTED_EFFECTS.contains(effectRegistryName);
    }

    public static boolean isHarmfulEffectApplicable(LivingEntity ignoredEntity, MobEffectInstance effectInstance) {
        MobEffect effect = effectInstance.getEffect();
        return effect.getCategory() == MobEffectCategory.HARMFUL && isHarmfulEffectBlacklisted(effect);
    }



    //Corrupted
    public static void initCorruptedBlacklist() {
        if (CORRUPTED_BLACKLISTED_EFFECTS == null) {
            CORRUPTED_BLACKLISTED_EFFECTS = new HashSet<>();
            for (String effects : CommonConfig.CORRUPTED_BLACKLIST_EFFECTS.get()) {
                CORRUPTED_BLACKLISTED_EFFECTS.add(new ResourceLocation(effects));
            }
        }
    }

    public static boolean isBeneficialEffectBlacklisted(MobEffect effect) {
        if (CORRUPTED_BLACKLISTED_EFFECTS == null) {
            initCorruptedBlacklist();
        }
        ResourceLocation effectRegistryName = ForgeRegistries.MOB_EFFECTS.getKey(effect);
        return effectRegistryName == null || !CORRUPTED_BLACKLISTED_EFFECTS.contains(effectRegistryName);
    }

    public static boolean isBeneficialEffectApplicable(LivingEntity ignoredEntity, MobEffectInstance effectInstance) {
        MobEffect effect = effectInstance.getEffect();
        return effect.getCategory() == MobEffectCategory.BENEFICIAL && isBeneficialEffectBlacklisted(effect);
    }
}

