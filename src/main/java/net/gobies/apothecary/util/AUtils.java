package net.gobies.apothecary.util;

import net.gobies.apothecary.init.APotions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.alchemy.Potion;

public class AUtils {

    public static Potion determinePotionByRarity(RandomSource random) {
        float chance = random.nextFloat();
        if (chance < 0.4f) { // 40% chance
            return APotions.Burning.get();
        } else if (chance < 0.7f) { // 30% chance
            return APotions.BrokenArmor.get();
        } else if (chance < 0.9f) { // 20% chance
            return APotions.Indolence.get();
        } else { // 10% chance
            return APotions.Confusion.get();
        }
    }
}
