package net.gobies.apothecary.util;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class AUtils {

    /**
     * The final damage multiplier value of the damage multiplier attribute
     * Returns the damage multiplier as a percentage, e.g. 1.5 = 50%
     */
    public static float getDamageMultiplier(double damageMultiplier) {
        return (float) damageMultiplier;
    }

    /**
     * The final damage resistance value of the damage resistance attribute
     * Example: a damage resistance value of 1.2 will be converted into 0.8
     * Damage * 0.8 = 20% damage resistance
     */
    public static float getDamageResistance(double damageResistance) {
        double resistanceCap = CommonConfig.MAX_DAMAGE_RESISTANCE.get();

        if (damageResistance >= 1.0) {
            double damageReduction = damageResistance - 1.0;
            damageReduction = Math.min(damageReduction, resistanceCap);
            return (float) (1.0 - damageReduction);
        } else {
            double vulnerability = 1.0 - damageResistance;
            return (float) (1.0 + vulnerability);
        }
    }

    /**
     * The final damage resistance value of the magic resistance attribute
     * Example: a magic resistance value of 5 will be converted to 0.75
     * Damage * 0.75 = 25% magic resistance
     */
    public static float getMagicResistance(double magicResistance) {
        double magicReduction = Math.min(magicResistance * 0.05, 1.0);
        return (float) (1.0 - magicReduction);
    }

    /**
     * The final jump height value of the jump height attribute
     * Example: a jump height value of 1.5 will be converted to 0.5
     * Jump Height + 0.5 = +0.5 extra jump height in blocks
     */
    public static double getJumpVelocity(double jumpHeight) {
        double targetHeight = 1.25D + (jumpHeight - 1.0D);
        return Math.sqrt(0.16D * targetHeight);
    }

    /**
     * The final fall distance value of the jump height attribute
     * Example: a jump height value of 1.5 will be converted to 0.5
     * Jump Height + 0.5 = +0.5 max fall damage distance
     */
    public static float getFallDistanceModifier(double jumpHeight) {
        return (float) (jumpHeight - 1.0D);
    }

    /**
     * The final dig speed value of the dig speed attribute
     * Returns the dig speed as a percentage, e.g. 1.5 = 50%
     */
    public static float getDigSpeedMultiplier(double digSpeed) {
        return (float) digSpeed;
    }

    private record ValidPotion(String id, int weight) {}

    public static String determinePotionByRarity(RandomSource random) {
        List<? extends String> entries = CommonConfig.POTION_SELECTOR.get();
        if (entries == null || entries.isEmpty()) {
            return "minecraft:poison";
        }

        List<ValidPotion> validPotions = new ArrayList<>(entries.size());
        int totalWeight = 0;

        for (String entry : entries) {
            if (entry == null || entry.isEmpty()) continue;

            int commaIndex = entry.indexOf(',');
            if (commaIndex <= 0 || commaIndex == entry.length() - 1) continue;

            try {
                String potionId = entry.substring(0, commaIndex).trim();
                ResourceLocation rl = ResourceLocation.tryParse(potionId);

                if (rl == null || !ForgeRegistries.POTIONS.containsKey(rl)) continue;

                int weight = Integer.parseInt(entry.substring(commaIndex + 1).trim());
                if (weight <= 0) continue;

                validPotions.add(new ValidPotion(potionId, weight));
                totalWeight += weight;
            } catch (NumberFormatException e) {
                Apothecary.LOGGER.warn("Invalid weight value in config");
            }
        }

        if (totalWeight <= 0 || validPotions.isEmpty()) {
            return "minecraft:poison";
        }

        int roll = random.nextInt(totalWeight);
        int currentSum = 0;

        for (ValidPotion potion : validPotions) {
            currentSum += potion.weight;
            if (roll < currentSum) {
                return potion.id;
            }
        }

        return validPotions.get(0).id;
    }
}
