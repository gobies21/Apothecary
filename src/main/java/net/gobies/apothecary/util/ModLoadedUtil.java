package net.gobies.apothecary.util;


import net.neoforged.fml.ModList;

public class ModLoadedUtil {

    public static boolean isMoreArtifactsLoaded() {
        return ModList.get().isLoaded("moreartifacts");
    }

    public static boolean isIronsSpellbooksLoaded() {
        return ModList.get().isLoaded("irons_spellbooks");
    }
}
