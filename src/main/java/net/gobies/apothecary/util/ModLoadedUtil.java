package net.gobies.apothecary.util;

import net.minecraftforge.fml.ModList;

public class ModLoadedUtil {

    public static boolean isIronsSpellbooksLoaded() {
        return ModList.get().isLoaded("irons_spellbooks");
    }
}
