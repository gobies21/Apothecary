package net.gobies.apothecary.compat;

import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class  OreCompat {

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
            ores.addAll(Set.of("irons_spellbooks:mithril_ore", "irons_spellbooks:deepslate_mithril_ore"));
        }
        if (ModList.get().isLoaded("additions")) {
            ores.addAll(Set.of("additions:tin_ore", "additions:deepslate_tin_ore", "additions:ruby_ore"));
        }
        if (ModList.get().isLoaded("iceandfire")) {
            ores.addAll(Set.of("iceandfire:silver_ore", "iceandfire:deepslate_silver_ore", "iceandfire:sapphire_ore"));
        }
        if (ModList.get().isLoaded("iceandfire2")) {
            ores.addAll(Set.of("iceandfire2:silver_ore", "iceandfire2:deepslate_silver_ore"));
        }
        if (ModList.get().isLoaded("alexscaves")) {
            ores.addAll(Set.of("alexscaves:galena_iron_ore", "alexscaves:guanostone_redstone_ore", "alexscaves:coprolith_coal_ore", "alexscaves:radrock_uranium_ore"));
        }
        if (ModList.get().isLoaded("natures_spirit")) {
            ores.addAll(Set.of("natures_spirit:chert_coal_ore", "natures_spirit:chert_iron_ore", "natures_spirit:chert_copper_ore", "natures_spirit:chert_redstone_ore", "natures_spirit:chert_gold_ore", "natures_spirit:chert_emerald_ore", "natures_spirit:chert_lapis_ore", "natures_spirit:chert_diamond_ore"));
        }
        return ores;
    }
}