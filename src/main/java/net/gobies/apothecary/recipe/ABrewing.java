package net.gobies.apothecary.recipe;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.registries.PotionRegistry;
import net.gobies.apothecary.config.CommonConfig;
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
        if (CommonConfig.ENABLE_IRON_SKIN_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.IRON_SKIN_INGREDIENT.get()))), APotions.IronSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(Items.REDSTONE), APotions.LongIronSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongIronSkin.get());
        }

        if (CommonConfig.ENABLE_BROKEN_ARMOR_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.IronSkin.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.BROKEN_ARMOR_INGREDIENT.get()))), APotions.BrokenArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.BrokenArmor.get(), Ingredient.of(Items.REDSTONE), APotions.LongBrokenArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.BrokenArmor.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBrokenArmor.get());
        }

        if (CommonConfig.ENABLE_DIAMOND_SKIN_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.DIAMOND_SKIN_INGREDIENT.get()))), APotions.DiamondSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(Items.REDSTONE), APotions.LongDiamondSkin.get());
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongDiamondSkin.get());
        }

        if (CommonConfig.ENABLE_RUPTURED_ARMOR_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.DiamondSkin.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.RUPTURED_ARMOR_INGREDIENT.get()))), APotions.RupturedArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.RupturedArmor.get(), Ingredient.of(Items.REDSTONE), APotions.LongRupturedArmor.get());
            BrewingHandler.addBrewingRecipe(APotions.RupturedArmor.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRupturedArmor.get());
        }

        if (CommonConfig.ENABLE_ARCHERY_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.ARCHERY_INGREDIENT.get()))), APotions.Archery.get());
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(Items.REDSTONE), APotions.LongArchery.get());
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongArchery.get());
        }

        if (CommonConfig.ENABLE_MISFIRE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Archery.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.MISFIRE_INGREDIENT.get()))), APotions.Misfire.get());
            BrewingHandler.addBrewingRecipe(APotions.Misfire.get(), Ingredient.of(Items.REDSTONE), APotions.LongMisfire.get());
        }

        if (CommonConfig.ENABLE_WRATH_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.WRATH_INGREDIENT.get()))), APotions.Wrath.get());
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(Items.REDSTONE), APotions.LongWrath.get());
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWrath.get());
        }

        if (CommonConfig.ENABLE_FEEBLE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Wrath.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.FEEBLE_INGREDIENT.get()))), APotions.Feeble.get());
            BrewingHandler.addBrewingRecipe(APotions.Feeble.get(), Ingredient.of(Items.REDSTONE), APotions.LongFeeble.get());
            BrewingHandler.addBrewingRecipe(APotions.Feeble.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongFeeble.get());
        }

        if (CommonConfig.ENABLE_RESISTANCE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.RESISTANCE_INGREDIENT.get()))), APotions.Resistance.get());
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(Items.REDSTONE), APotions.LongResistance.get());
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongResistance.get());
        }

        if (CommonConfig.ENABLE_VULNERABLE_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Resistance.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.VULNERABLE_INGREDIENT.get()))), APotions.Vulnerable.get());
            BrewingHandler.addBrewingRecipe(APotions.Vulnerable.get(), Ingredient.of(Items.REDSTONE), APotions.LongVulnerable.get());
            BrewingHandler.addBrewingRecipe(APotions.Vulnerable.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongVulnerable.get());
        }

        if (CommonConfig.ENABLE_FLIGHT_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.FLIGHT_INGREDIENT.get()))), APotions.Flight.get());
        }

        if (CommonConfig.ENABLE_REACH_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.REACH_INGREDIENT.get()))), APotions.Reach.get());
            BrewingHandler.addBrewingRecipe(APotions.Reach.get(), Ingredient.of(Items.REDSTONE), APotions.LongReach.get());
            BrewingHandler.addBrewingRecipe(APotions.Reach.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongReach.get());
        }

        if (CommonConfig.ENABLE_REPAIRING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.REPAIRING_INGREDIENT.get()))), APotions.Repairing.get());
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(Items.REDSTONE), APotions.LongRepairing.get());
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRepairing.get());
        }

        if (CommonConfig.ENABLE_CORROSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Repairing.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.CORROSION_INGREDIENT.get()))), APotions.Corrosion.get());
            BrewingHandler.addBrewingRecipe(APotions.Corrosion.get(), Ingredient.of(Items.REDSTONE), APotions.LongCorrosion.get());
            BrewingHandler.addBrewingRecipe(APotions.Corrosion.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongCorrosion.get());
        }

        if (CommonConfig.ENABLE_THORNS_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.THORNS_INGREDIENT.get()))), APotions.Thorns.get());
            BrewingHandler.addBrewingRecipe(APotions.Thorns.get(), Ingredient.of(Items.REDSTONE), APotions.LongThorns.get());
            BrewingHandler.addBrewingRecipe(APotions.Thorns.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongThorns.get());
        }

        if (CommonConfig.ENABLE_CONFUSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.CONFUSION_INGREDIENT.get()))), APotions.Confusion.get());
            BrewingHandler.addBrewingRecipe(APotions.Confusion.get(), Ingredient.of(Items.REDSTONE), APotions.LongConfusion.get());
        }

        if (CommonConfig.ENABLE_PURIFICATION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.PURIFICATION_INGREDIENT.get()))), APotions.Purification.get());
        }

        if (CommonConfig.ENABLE_CORRUPTION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(APotions.Purification.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.CORRUPTION_INGREDIENT.get()))), APotions.Corruption.get());
        }

        if (CommonConfig.ENABLE_BURNING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.BURNING_INGREDIENT.get()))), APotions.Burning.get());
            BrewingHandler.addBrewingRecipe(APotions.Burning.get(), Ingredient.of(Items.REDSTONE), APotions.LongBurning.get());
            BrewingHandler.addBrewingRecipe(APotions.Burning.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBurning.get());
        }

        if (CommonConfig.ENABLE_SHOCKED_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.SHOCKED_INGREDIENT.get()))), APotions.Shocked.get());
            BrewingHandler.addBrewingRecipe(APotions.Shocked.get(), Ingredient.of(Items.REDSTONE), APotions.LongShocked.get());
            BrewingHandler.addBrewingRecipe(APotions.Shocked.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongShocked.get());
        }

        if (CommonConfig.ENABLE_LIGHTNING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.LIGHTNING_INGREDIENT.get()))), APotions.Lightning.get());
            BrewingHandler.addBrewingRecipe(APotions.Lightning.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongLightning.get());
        }

        if (CommonConfig.ENABLE_SPELUNKER_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.SPELUNKER_INGREDIENT.get()))), APotions.Spelunker.get());
            BrewingHandler.addBrewingRecipe(APotions.Spelunker.get(), Ingredient.of(Items.REDSTONE), APotions.LongSpelunker.get());
            BrewingHandler.addBrewingRecipe(APotions.Spelunker.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongSpelunker.get());
        }

        if (CommonConfig.ENABLE_EXTENSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.EXTENSION_INGREDIENT.get()))), APotions.Extension.get());
            BrewingHandler.addBrewingRecipe(APotions.Extension.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongExtension.get());
        }

        if (CommonConfig.ENABLE_REVERSION_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.REVERSION_INGREDIENT.get()))), APotions.Reversion.get());
            BrewingHandler.addBrewingRecipe(APotions.Reversion.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongReversion.get());
        }

        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            if (CommonConfig.ENABLE_MANA_REGENERATION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(PotionRegistry.INSTANT_MANA_TWO.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.MANA_REGENERATION_INGREDIENT.get()))), APotions.ManaRegeneration.get());
                BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(Items.REDSTONE), APotions.LongManaRegeneration.get());
                BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaRegeneration.get());
            }

            if (CommonConfig.ENABLE_MANA_EXHAUSTION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(APotions.ManaRegeneration.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.MANA_EXHAUSTION_INGREDIENT.get()))), APotions.ManaExhaustion.get());
                BrewingHandler.addBrewingRecipe(APotions.ManaExhaustion.get(), Ingredient.of(Items.REDSTONE), APotions.LongManaExhaustion.get());
                BrewingHandler.addBrewingRecipe(APotions.ManaExhaustion.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaExhaustion.get());
            }

            if (CommonConfig.ENABLE_MAGIC_POWER_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(PotionRegistry.INSTANT_MANA_THREE.get(), Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.MAGIC_POWER_INGREDIENT.get()))), APotions.MagicPower.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Items.REDSTONE), APotions.LongMagicPower.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicPower.get());
            }

            if (CommonConfig.ENABLE_MAGIC_DRAIN_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(APotions.MagicPower.get(), Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.MAGIC_DRAIN_INGREDIENT.get())))), APotions.MagicDrain.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicDrain.get(), Ingredient.of(Items.REDSTONE), APotions.LongMagicDrain.get());
                BrewingHandler.addBrewingRecipe(APotions.MagicDrain.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicDrain.get());
            }
        }

        if (CommonConfig.ENABLE_SHUFFLING_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.SHUFFLING_INGREDIENT.get()))), APotions.Shuffling.get());
        }

        if (CommonConfig.ENABLE_HEALTH_BOOST_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.HEALTH_BOOST_INGREDIENT.get()))), APotions.HealthBoost.get());
            BrewingHandler.addBrewingRecipe(APotions.HealthBoost.get(), Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost.get());
            BrewingHandler.addBrewingRecipe(APotions.HealthBoost.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost.get());
        }

        if (CommonConfig.ENABLE_LUCK_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.LUCK_INGREDIENT.get()))), Potions.LUCK);
            BrewingHandler.addBrewingRecipe(Potions.LUCK, Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost.get());
            BrewingHandler.addBrewingRecipe(Potions.LUCK, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost.get());
        }

        if (CommonConfig.ENABLE_WITHER_RECIPE.get()) {
            BrewingHandler.addBrewingRecipe(Potions.AWKWARD, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(CommonConfig.WITHER_INGREDIENT.get()))), APotions.Wither.get());
            BrewingHandler.addBrewingRecipe(APotions.Wither.get(), Ingredient.of(Items.REDSTONE), APotions.LongWither.get());
            BrewingHandler.addBrewingRecipe(APotions.Wither.get(), Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWither.get());
        }
    }
}