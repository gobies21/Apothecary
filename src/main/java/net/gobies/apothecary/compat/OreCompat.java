package net.gobies.apothecary.compat;

import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OreCompat {

    public static boolean isModdedOre(Block block) {
        Set<ResourceLocation> oreBlockLocations = getOreString()
                .stream()
                .map(ResourceLocation::new)
                .collect(Collectors.toSet());

        ResourceLocation blockLocation = ForgeRegistries.BLOCKS.getKey(block);

        return blockLocation != null && oreBlockLocations.contains(blockLocation);
    }

    private static Set<String> getOreString() {
        Set<String> ores = new HashSet<>();
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            ores.add("irons_spellbooks:arcane_debris");
        }
        if (ModList.get().isLoaded("additions")) {
            ores.addAll(Set.of("additions:tin_ore", "additions:deepslate_tin_ore", "additions:ruby_ore"));
        }
        if (ModList.get().isLoaded("iceandfire")) {
            ores.addAll(Set.of("iceandfire:silver_ore", "iceandfire:deepslate_silver_ore", "iceandfire:sapphire_ore"));
        }
        if (ModList.get().isLoaded("alexscaves")) {
            ores.addAll(Set.of("alexscaves:galena_iron_ore", "alexscaves:guanostone_redstone_ore", "alexscaves:coprolith_coal_ore", "alexscaves:radrock_uranium_ore"));
        }
        return ores;
    }
}