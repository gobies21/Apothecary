package net.gobies.apothecary.recipe;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.registries.PotionRegistry;
import net.gobies.apothecary.Config;
import net.gobies.apothecary.init.APotions;
import net.gobies.apothecary.util.BrewingHandler;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Objects;

public class ABrewing {

    public static void register() {
        if (Config.ENABLE_IRON_SKIN_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.IRON_SKIN_INGREDIENT.get())))), APotions.IronSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(Items.REDSTONE), APotions.LongIronSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongIronSkin.get());
        }

        if (Config.ENABLE_BROKEN_ARMOR_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.BROKEN_ARMOR_INGREDIENT.get())))), APotions.BrokenArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.BrokenArmor.get(), Ingredient.of(Items.REDSTONE), APotions.LongBrokenArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.BrokenArmor.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBrokenArmor.get());
        }

        if (Config.ENABLE_DIAMOND_SKIN_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.DIAMOND_SKIN_INGREDIENT.get())))), APotions.DiamondSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(Items.REDSTONE), APotions.LongDiamondSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongDiamondSkin.get());
        }

        if (Config.ENABLE_RUPTURED_ARMOR_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.RUPTURED_ARMOR_INGREDIENT.get())))), APotions.RupturedArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.RupturedArmor.get(), Ingredient.of(Items.REDSTONE), APotions.LongRupturedArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.RupturedArmor.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRupturedArmor.get());
        }

        if (Config.ENABLE_ARCHERY_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.ARCHERY_INGREDIENT.get())))), APotions.Archery.get());
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(Items.REDSTONE), APotions.LongArchery.get());
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongArchery.get());
        }

        if (Config.ENABLE_MISFIRE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.MISFIRE_INGREDIENT.get())))), APotions.Misfire.get());
            BrewingHandler.addBrewingRecipe(APotions.Misfire.get(), Ingredient.of(Items.REDSTONE), APotions.LongMisfire.get());
            BrewingHandler.addBrewingRecipe(APotions.Misfire.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMisfire.get());
        }

        if (Config.ENABLE_WRATH_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.WRATH_INGREDIENT.get())))), APotions.Wrath.get());
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(Items.REDSTONE), APotions.LongWrath.get());
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWrath.get());
        }

        if (Config.ENABLE_FEEBLE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.FEEBLE_INGREDIENT.get())))), APotions.Feeble.get());
            BrewingHandler.addBrewingRecipe(APotions.Feeble.get(), Ingredient.of(Items.REDSTONE), APotions.LongFeeble.get());
            BrewingHandler.addBrewingRecipe(APotions.Feeble.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongFeeble.get());
        }

        if (Config.ENABLE_RESISTANCE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.RESISTANCE_INGREDIENT.get())))), APotions.Resistance.get());
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(Items.REDSTONE), APotions.LongResistance.get());
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongResistance.get());
        }

        if (Config.ENABLE_INDOLENCE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.INDOLENCE_INGREDIENT.get())))), APotions.Indolence.get());
            BrewingHandler.addBrewingRecipe(APotions.Indolence.get(), Ingredient.of(Items.REDSTONE), APotions.LongIndolence.get());
            BrewingHandler.addBrewingRecipe(APotions.Indolence.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongIndolence.get());
        }

        if (Config.ENABLE_FLIGHT_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.FLIGHT_INGREDIENT.get())))), APotions.Flight.get());
            BrewingHandler.addBrewingRecipe(APotions.Flight.get(), Ingredient.of(Items.REDSTONE), APotions.LongFlight.get());
        }

        if (Config.ENABLE_REACH_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.REACH_INGREDIENT.get())))), APotions.Reach.get());
            BrewingHandler.addBrewingRecipe(APotions.Reach.get(), Ingredient.of(Items.REDSTONE), APotions.LongReach.get());
            BrewingHandler.addBrewingRecipe(APotions.Reach.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongReach.get());
        }

        if (Config.ENABLE_REPAIRING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.REPAIRING_INGREDIENT.get())))), APotions.Repairing.get());
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(Items.REDSTONE), APotions.LongRepairing.get());
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRepairing.get());
        }

        if (Config.ENABLE_CORROSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.CORROSION_INGREDIENT.get())))), APotions.Corrosion.get());
            BrewingHandler.addBrewingRecipe(APotions.Corrosion.get(), Ingredient.of(Items.REDSTONE), APotions.LongCorrosion.get());
            BrewingHandler.addBrewingRecipe(APotions.Corrosion.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongCorrosion.get());
        }

        if (Config.ENABLE_THORNS_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.THORNS_INGREDIENT.get())))), APotions.Thorns.get());
            BrewingHandler.addBrewingRecipe(APotions.Thorns.get(), Ingredient.of(Items.REDSTONE), APotions.LongThorns.get());
            BrewingHandler.addBrewingRecipe(APotions.Thorns.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongThorns.get());
        }

        if (Config.ENABLE_CONFUSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.CONFUSION_INGREDIENT.get())))), APotions.Confusion.get());
            BrewingHandler.addBrewingRecipe(APotions.Confusion.get(), Ingredient.of(Items.REDSTONE), APotions.LongConfusion.get());
        }

        if (Config.ENABLE_CLEANSED_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.CLEANSED_INGREDIENT.get())))), APotions.Cleansed.get());
        }

        if (Config.ENABLE_CORRUPTED_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Cleansed.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.CORRUPTED_INGREDIENT.get())))), APotions.Corrupted.get());
        }

        if (Config.ENABLE_BURNING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.BURNING_INGREDIENT.get())))), APotions.Burning.get());
            BrewingHandler.addBrewingRecipe(APotions.Burning.get(), Ingredient.of(Items.REDSTONE), APotions.LongBurning.get());
            BrewingHandler.addBrewingRecipe(APotions.Burning.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBurning.get());
        }

        if (Config.ENABLE_CHILLED_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.CHILLED_INGREDIENT.get())))), APotions.Chilled.get());
            BrewingHandler.addBrewingRecipe(APotions.Chilled.get(), Ingredient.of(Items.REDSTONE), APotions.LongChilled.get());
            BrewingHandler.addBrewingRecipe(APotions.Chilled.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongChilled.get());
        }

        if (Config.ENABLE_SHOCKED_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.SHOCKED_INGREDIENT.get())))), APotions.Shocked.get());
            BrewingHandler.addBrewingRecipe(APotions.Shocked.get(), Ingredient.of(Items.REDSTONE), APotions.LongShocked.get());
            BrewingHandler.addBrewingRecipe(APotions.Shocked.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongShocked.get());
        }

        if (Config.ENABLE_LIGHTNING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.LIGHTNING_INGREDIENT.get())))), APotions.Lightning.get());
        }

        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            BrewingHandler.addBrewingRecipe(PotionRegistry.INSTANT_MANA_TWO.get(), Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()), APotions.ManaRegeneration.get());
            BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(Items.REDSTONE), APotions.LongManaRegeneration.get());
            BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaRegeneration.get());

            BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(Items.FERMENTED_SPIDER_EYE), APotions.ManaExhaustion.get());
            BrewingHandler.addBrewingRecipe(APotions.ManaExhaustion.get(), Ingredient.of(Items.REDSTONE), APotions.LongManaExhaustion.get());
            BrewingHandler.addBrewingRecipe(APotions.ManaExhaustion.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaExhaustion.get());

            if (Config.ENABLE_MAGIC_POWER_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(PotionRegistry.INSTANT_MANA_THREE.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.MAGIC_POWER_INGREDIENT.get())))), APotions.MagicPower.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Items.REDSTONE), APotions.LongMagicPower.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicPower.get());
            }

            if (Config.ENABLE_MAGIC_DRAIN_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.MAGIC_DRAIN_INGREDIENT.get())))), APotions.MagicDrain.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicDrain.get(), Ingredient.of(Items.REDSTONE), APotions.LongMagicDrain.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicDrain.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicDrain.get());
            }
        }

        if (Config.ENABLE_SHUFFLING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.SHUFFLING_INGREDIENT.get())))), APotions.Shuffling.get());
        }

        if (Config.ENABLE_HEALTH_BOOST_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.HEALTH_BOOST_INGREDIENT.get())))), APotions.HealthBoost.get());
            BrewingHandler.addBrewingRecipe(APotions.HealthBoost.get(), Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost.get());
            BrewingHandler.addBrewingRecipe(APotions.HealthBoost.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost.get());
        }

        if (Config.ENABLE_LUCK_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.LUCK_INGREDIENT.get())))), Potions.LUCK);
            BrewingHandler.addBrewingRecipe(Potions.LUCK, Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost.get());
            BrewingHandler.addBrewingRecipe(Potions.LUCK, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost.get());
        }

        if (Config.ENABLE_WITHER_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.WITHER_INGREDIENT.get())))), APotions.Wither.get());
            BrewingHandler.addBrewingRecipe(APotions.Wither.get(), Ingredient.of(Items.REDSTONE), APotions.LongWither.get());
            BrewingHandler.addBrewingRecipe(APotions.Wither.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWither.get());
        }
    }
}