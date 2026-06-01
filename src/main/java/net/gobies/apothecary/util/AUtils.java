package net.gobies.apothecary.util;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class AUtils {

    private record ValidPotion(String id, int weight) {
    }

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
