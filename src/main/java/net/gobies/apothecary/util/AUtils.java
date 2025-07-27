package net.gobies.apothecary.util;

import net.gobies.apothecary.init.APotions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class AUtils {

    public static Potion determinePotionByRarity(RandomSource random) {
        float chance = random.nextFloat();

        if (chance < 0.10f) { // 10% chance
            return APotions.Indolence.get();

        } else if (chance < 0.20f) { // 10% chance
            return APotions.Burning.get();

        } else if (chance < 0.30f) { // 10% chance
            return Potions.HARMING;

        } else if (chance < 0.40) { // 10 % Chance
            return APotions.Lightning.get();

        } else if (chance < 0.50) { // 10 % Chance
            return APotions.Wither.get();

        } else if (chance < 0.60) { // 10 % Chance
            return APotions.Shuffling.get();

        } else if (chance < 0.70) { // 10 % Chance
            return APotions.Corrosion.get();

        } else if (chance < 0.80) { // 10 % Chance
            return APotions.Confusion.get();

        } else if (chance < 0.95) { // 15 % Chance
            return APotions.Wither.get();

        } else { // 5% chance
            return APotions.Corrupted.get();
        }
    }
}
