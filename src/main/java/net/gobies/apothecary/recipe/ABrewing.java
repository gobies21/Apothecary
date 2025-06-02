package net.gobies.apothecary.recipe;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.registries.PotionRegistry;
import net.gobies.apothecary.Config;
import net.gobies.apothecary.init.APotions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Objects;

public class ABrewing {

    public static void register() {
        if (Config.ENABLE_IRON_SKIN_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.IRON_SKIN_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.IronSkin.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.IronSkin.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongIronSkin.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.IronSkin.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongIronSkin.get()))
            );
        }

        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.IronSkin.get())),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.BrokenArmor.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.BrokenArmor.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongBrokenArmor.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.BrokenArmor.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongBrokenArmor.get()))
        );

        if (Config.ENABLE_DIAMOND_SKIN_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.DIAMOND_SKIN_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.DiamondSkin.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.DiamondSkin.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongDiamondSkin.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.DiamondSkin.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongDiamondSkin.get()))
            );
        }

        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.DiamondSkin.get())),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.RupturedArmor.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.RupturedArmor.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongRupturedArmor.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.RupturedArmor.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongRupturedArmor.get()))
        );

        if (Config.ENABLE_ARCHERY_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.ARCHERY_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Archery.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Archery.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongArchery.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Archery.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongArchery.get()))
            );
        }

        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Archery.get())),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Misfire.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Misfire.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongMisfire.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Misfire.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongMisfire.get()))
        );

        if (Config.ENABLE_WRATH_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.WRATH_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Wrath.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Wrath.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongWrath.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Wrath.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongWrath.get()))
            );
        }

        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Wrath.get())),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Feeble.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Feeble.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongFeeble.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Feeble.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongFeeble.get()))
        );

        if (Config.ENABLE_RESISTANCE_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.RESISTANCE_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Resistance.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Resistance.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongResistance.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Resistance.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongResistance.get()))
            );
        }

        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Resistance.get())),
                Ingredient.of(Items.FERMENTED_SPIDER_EYE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Indolence.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Indolence.get())),
                Ingredient.of(Items.REDSTONE),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongIndolence.get())));
        BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Indolence.get())),
                Ingredient.of(Items.GLOWSTONE_DUST),
                PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongIndolence.get()))
        );

        if (Config.ENABLE_FLIGHT_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.FLIGHT_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Flight.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Flight.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongFlight.get()))
            );
        }

        if (Config.ENABLE_REACH_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.REACH_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Reach.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Reach.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongReach.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.Reach.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongReach.get()))
            );
        }

        if (ModList.get().isLoaded("irons_spellbooks")) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.INSTANT_MANA_TWO.get())),
                    Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.ManaRegeneration.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.ManaRegeneration.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongManaRegeneration.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.ManaRegeneration.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongManaRegeneration.get()))
            );

            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.INSTANT_MANA_THREE.get())),
                    Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.MagicPower.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.MagicPower.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongMagicPower.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.MagicPower.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongMagicPower.get()))
            );
        }

        if (Config.ENABLE_HEALTH_BOOST_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.HEALTH_BOOST_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.HealthBoost.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.HealthBoost.get())),
                    Ingredient.of(Items.REDSTONE),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.LongHealthBoost.get())));
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.HealthBoost.get())),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), APotions.StrongHealthBoost.get()))
            );
        }

        if (Config.ENABLE_LUCK_RECIPE.get()) {
            BrewingRecipeRegistry.addRecipe(new TrueBrewingRecipe(
                    Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                    Ingredient.of(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.LUCK_INGREDIENT.get())))),
                    PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LUCK))
            );
        }
    }
}