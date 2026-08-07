package net.gobies.apothecary.compat;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.DurationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FluidEffectEvents {

    private static final Map<UUID, Integer> acidDurationMap = new HashMap<>();

    public static void loadCompat() {
        NeoForge.EVENT_BUS.register(new FluidEffectEvents());
    }

    @SubscribeEvent
    public void fluidEffects(EntityTickEvent.Post event) {
        if (!CommonConfig.APOTHECARY_ENABLED.get()) return;
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            Level level = livingEntity.level();
            if (livingEntity.tickCount % 10 != 0) return;
            BlockPos blockPos = livingEntity.blockPosition();
            FluidState fluidState = level.getFluidState(blockPos);
            ResourceLocation fluidLocation = BuiltInRegistries.FLUID.getKey(fluidState.getType());

            if (ModList.get().isLoaded("alexscaves")) {
                boolean isAcid = fluidLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "acid"));
                boolean isAcidFlowing = fluidLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "acid_flowing"));

                if ((isAcid || isAcidFlowing) && !isWearingHazmatArmor(livingEntity)) {
                    acidDurationMap.put(livingEntity.getUUID(), acidDurationMap.getOrDefault(livingEntity.getUUID(), 0) + 1);

                    int duration = acidDurationMap.get(livingEntity.getUUID());
                    int amplifier = 0;
                    int effectDuration;

                    if (isAcid) {
                        effectDuration = DurationUtils.getRandomVeryLongDuration();
                    } else {
                        effectDuration = DurationUtils.getRandomMediumDuration();
                    }

                    if (duration > 500) {
                        amplifier = 1;
                    }
                    if (duration > 1000) {
                        amplifier = 2;
                    }

                    MobEffectInstance existingEffect = livingEntity.getEffect(AEffects.Corrosion);
                    if (existingEffect == null) {
                        livingEntity.addEffect(new MobEffectInstance(AEffects.Corrosion, effectDuration, amplifier));
                    } else {
                        int existingAmplifier = existingEffect.getAmplifier();
                        int existingDuration = existingEffect.getDuration();

                        if (existingAmplifier < amplifier) {
                            livingEntity.addEffect(new MobEffectInstance(AEffects.Corrosion, existingDuration, amplifier));
                        } else {
                            int newDuration = existingDuration + 20;
                            livingEntity.addEffect(new MobEffectInstance(AEffects.Corrosion, Math.min(newDuration, effectDuration), existingAmplifier));
                        }
                    }
                } else {
                    acidDurationMap.remove(livingEntity.getUUID());
                }
            }
            if (ModList.get().isLoaded("biomesoplenty")) {
                boolean isBlood = fluidLocation.equals(ResourceLocation.fromNamespaceAndPath("biomesoplenty", "blood"));
                boolean isBloodFlowing = fluidLocation.equals(ResourceLocation.fromNamespaceAndPath("biomesoplenty", "flowing_blood"));
                if (isBlood || isBloodFlowing) {
                    livingEntity.addEffect(new MobEffectInstance(AEffects.Vulnerable, DurationUtils.getRandomLongDuration(), 0));
                }
            }
        }
    }

    private static boolean isWearingHazmatArmor(LivingEntity entity) {
        ItemStack head = entity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = entity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = entity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = entity.getItemBySlot(EquipmentSlot.FEET);

        ResourceLocation headLocation = BuiltInRegistries.ITEM.getKey(head.getItem());
        ResourceLocation chestLocation = BuiltInRegistries.ITEM.getKey(chest.getItem());
        ResourceLocation legsLocation = BuiltInRegistries.ITEM.getKey(legs.getItem());
        ResourceLocation feetLocation = BuiltInRegistries.ITEM.getKey(feet.getItem());

        return headLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "hazmat_mask"))
                && chestLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "hazmat_chestplate"))
                && legsLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "hazmat_leggings"))
                && feetLocation.equals(ResourceLocation.fromNamespaceAndPath("alexscaves", "hazmat_boots"));
    }

    public static void clearMaps(UUID uuid) {
        acidDurationMap.remove(uuid);
    }

    @SubscribeEvent
    public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
        if (event.getEntity() instanceof LivingEntity livingEntity) {
            clearMaps(livingEntity.getUUID());
        }
    }
}