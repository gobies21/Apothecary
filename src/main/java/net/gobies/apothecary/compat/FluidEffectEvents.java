package net.gobies.apothecary.compat;

import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.DurationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class FluidEffectEvents {

    private static final Map<LivingEntity, Integer> acidDurationMap = new HashMap<>();

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new FluidEffectEvents());
    }

    @SubscribeEvent
    public void fluidEffects(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        BlockPos blockPos = entity.blockPosition();
        FluidState fluidState = level.getFluidState(blockPos);
        ResourceLocation fluidLocation = ForgeRegistries.FLUIDS.getKey(fluidState.getType());

        if (ModList.get().isLoaded("alexscaves") && fluidLocation != null) {
            boolean isAcid = fluidLocation.equals(new ResourceLocation("alexscaves", "acid"));
            boolean isAcidFlowing = fluidLocation.equals(new ResourceLocation("alexscaves", "acid_flowing"));

            if ((isAcid || isAcidFlowing) && !isWearingHazmatArmor(entity)) {
                acidDurationMap.put(entity, acidDurationMap.getOrDefault(entity, 0) + 1);

                int duration = acidDurationMap.get(entity);
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

                MobEffectInstance existingEffect = entity.getEffect(AEffects.Corrosion.get());
                if (existingEffect == null) {
                    entity.addEffect(new MobEffectInstance(AEffects.Corrosion.get(), effectDuration, amplifier));
                } else {
                    int existingAmplifier = existingEffect.getAmplifier();
                    int existingDuration = existingEffect.getDuration();

                    if (existingAmplifier < amplifier) {
                        entity.addEffect(new MobEffectInstance(AEffects.Corrosion.get(), existingDuration, amplifier));
                    } else {
                        int newDuration = existingDuration + 20;
                        entity.addEffect(new MobEffectInstance(AEffects.Corrosion.get(), Math.min(newDuration, effectDuration), existingAmplifier));
                    }
                }
            } else {
                acidDurationMap.remove(entity);
            }
        }
        if (ModList.get().isLoaded("biomesoplenty") && fluidLocation != null) {
            boolean isBlood = fluidLocation.equals(new ResourceLocation("biomesoplenty", "blood"));
            boolean isBloodFlowing = fluidLocation.equals(new ResourceLocation("biomesoplenty", "flowing_blood"));
            if (isBlood || isBloodFlowing) {
                entity.addEffect(new MobEffectInstance(AEffects.Indolence.get(), DurationUtils.getRandomLongDuration(), 0));
            }
        }
    }

    private static boolean isWearingHazmatArmor(LivingEntity entity) {
        ItemStack head = entity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = entity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = entity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = entity.getItemBySlot(EquipmentSlot.FEET);

        ResourceLocation headLocation = ForgeRegistries.ITEMS.getKey(head.getItem());
        ResourceLocation chestLocation = ForgeRegistries.ITEMS.getKey(chest.getItem());
        ResourceLocation legsLocation = ForgeRegistries.ITEMS.getKey(legs.getItem());
        ResourceLocation feetLocation = ForgeRegistries.ITEMS.getKey(feet.getItem());

        return (headLocation != null && headLocation.equals(new ResourceLocation("alexscaves", "hazmat_mask")) &&
                chestLocation != null && chestLocation.equals(new ResourceLocation("alexscaves", "hazmat_chestplate")) &&
                legsLocation != null && legsLocation.equals(new ResourceLocation("alexscaves", "hazmat_leggings")) &&
                feetLocation != null && feetLocation.equals(new ResourceLocation("alexscaves", "hazmat_boots")));
    }
}