package net.gobies.apothecary.recipe;

import io.redspace.ironsspellbooks.registries.PotionRegistry;
import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.APotions;
import net.gobies.apothecary.util.BrewingHandler;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

import java.util.Objects;

@EventBusSubscriber(modid = Apothecary.MOD_ID)
public class ABrewing {

    @SubscribeEvent
    public static void register(RegisterBrewingRecipesEvent event) {
        if (CommonConfig.APOTHECARY_ENABLED.get() && CommonConfig.POTIONS_ENABLED.get()) {
            // Positive Potions
            if (CommonConfig.ENABLE_IRON_SKIN_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.IRON_SKIN_INGREDIENT.get()))), APotions.IronSkin);
                BrewingHandler.addBrewingRecipe(event, APotions.IronSkin, Ingredient.of(Items.REDSTONE), APotions.LongIronSkin);
                BrewingHandler.addBrewingRecipe(event, APotions.IronSkin, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongIronSkin);
            }

            if (CommonConfig.ENABLE_DIAMOND_SKIN_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.DIAMOND_SKIN_INGREDIENT.get()))), APotions.DiamondSkin);
                BrewingHandler.addBrewingRecipe(event, APotions.DiamondSkin, Ingredient.of(Items.REDSTONE), APotions.LongDiamondSkin);
                BrewingHandler.addBrewingRecipe(event, APotions.DiamondSkin, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongDiamondSkin);
            }

            BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse("minecraft:lapis_block"))), APotions.MagicShield);
            BrewingHandler.addBrewingRecipe(event, APotions.MagicShield, Ingredient.of(Items.REDSTONE), APotions.LongMagicShield);
            BrewingHandler.addBrewingRecipe(event, APotions.MagicShield, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicShield);

            if (CommonConfig.ENABLE_ARCHERY_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.ARCHERY_INGREDIENT.get()))), APotions.Archery);
                BrewingHandler.addBrewingRecipe(event, APotions.Archery, Ingredient.of(Items.REDSTONE), APotions.LongArchery);
                BrewingHandler.addBrewingRecipe(event, APotions.Archery, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongArchery);
            }

            if (CommonConfig.ENABLE_WRATH_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.WRATH_INGREDIENT.get()))), APotions.Wrath);
                BrewingHandler.addBrewingRecipe(event, APotions.Wrath, Ingredient.of(Items.REDSTONE), APotions.LongWrath);
                BrewingHandler.addBrewingRecipe(event, APotions.Wrath, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWrath);
            }

            if (CommonConfig.ENABLE_FLIGHT_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.FLIGHT_INGREDIENT.get()))), APotions.Flight);
            }

            if (CommonConfig.ENABLE_REACH_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.REACH_INGREDIENT.get()))), APotions.Reach);
                BrewingHandler.addBrewingRecipe(event, APotions.Reach, Ingredient.of(Items.REDSTONE), APotions.LongReach);
                BrewingHandler.addBrewingRecipe(event, APotions.Reach, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongReach);
            }

            if (CommonConfig.ENABLE_REPAIRING_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.REPAIRING_INGREDIENT.get()))), APotions.Repairing);
                BrewingHandler.addBrewingRecipe(event, APotions.Repairing, Ingredient.of(Items.REDSTONE), APotions.LongRepairing);
                BrewingHandler.addBrewingRecipe(event, APotions.Repairing, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRepairing);
            }

            if (CommonConfig.ENABLE_THORNS_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.THORNS_INGREDIENT.get()))), APotions.Thorns);
                BrewingHandler.addBrewingRecipe(event, APotions.Thorns, Ingredient.of(Items.REDSTONE), APotions.LongThorns);
                BrewingHandler.addBrewingRecipe(event, APotions.Thorns, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongThorns);
            }

            if (CommonConfig.ENABLE_PURIFICATION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.PURIFICATION_INGREDIENT.get()))), APotions.Purification);
            }

            if (CommonConfig.ENABLE_SPELUNKER_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.SPELUNKER_INGREDIENT.get()))), APotions.Spelunker);
                BrewingHandler.addBrewingRecipe(event, APotions.Spelunker, Ingredient.of(Items.REDSTONE), APotions.LongSpelunker);
                BrewingHandler.addBrewingRecipe(event, APotions.Spelunker, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongSpelunker);
            }

            if (CommonConfig.ENABLE_EXTENSION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.EXTENSION_INGREDIENT.get()))), APotions.Extension);
                BrewingHandler.addBrewingRecipe(event, APotions.Extension, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongExtension);
            }

            if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
                if (CommonConfig.ENABLE_MANA_REGENERATION_RECIPE.get()) {
                    BrewingHandler.addBrewingRecipe(event, PotionRegistry.INSTANT_MANA_TWO, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.MANA_REGENERATION_INGREDIENT.get()))), APotions.ManaRegeneration);
                    BrewingHandler.addBrewingRecipe(event, APotions.ManaRegeneration, Ingredient.of(Items.REDSTONE), APotions.LongManaRegeneration);
                    BrewingHandler.addBrewingRecipe(event, APotions.ManaRegeneration, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaRegeneration);
                }
            }

            if (CommonConfig.ENABLE_MAGIC_POWER_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.MAGIC_POWER_INGREDIENT.get()))), APotions.MagicPower);
                BrewingHandler.addBrewingRecipe(event, APotions.MagicPower, Ingredient.of(Items.REDSTONE), APotions.LongMagicPower);
                BrewingHandler.addBrewingRecipe(event, APotions.MagicPower, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicPower);
            }

            if (CommonConfig.ENABLE_BROKEN_ARMOR_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.IronSkin, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.BROKEN_ARMOR_INGREDIENT.get()))), APotions.BrokenArmor);
                BrewingHandler.addBrewingRecipe(event, APotions.BrokenArmor, Ingredient.of(Items.REDSTONE), APotions.LongBrokenArmor);
                BrewingHandler.addBrewingRecipe(event, APotions.BrokenArmor, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBrokenArmor);
            }

            if (CommonConfig.ENABLE_RUPTURED_ARMOR_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.DiamondSkin, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.RUPTURED_ARMOR_INGREDIENT.get()))), APotions.RupturedArmor);
                BrewingHandler.addBrewingRecipe(event, APotions.RupturedArmor, Ingredient.of(Items.REDSTONE), APotions.LongRupturedArmor);
                BrewingHandler.addBrewingRecipe(event, APotions.RupturedArmor, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongRupturedArmor);
            }

            if (CommonConfig.ENABLE_MISFIRE_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Archery, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.MISFIRE_INGREDIENT.get()))), APotions.Misfire);
                BrewingHandler.addBrewingRecipe(event, APotions.Misfire, Ingredient.of(Items.REDSTONE), APotions.LongMisfire);
            }

            if (CommonConfig.ENABLE_FRAIL_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Wrath, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.FRAIL_INGREDIENT.get()))), APotions.Frail);
                BrewingHandler.addBrewingRecipe(event, APotions.Frail, Ingredient.of(Items.REDSTONE), APotions.LongFrail);
                BrewingHandler.addBrewingRecipe(event, APotions.Frail, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongFrail);
            }

            if (CommonConfig.ENABLE_VULNERABLE_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Resistance, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.VULNERABLE_INGREDIENT.get()))), APotions.Vulnerable);
                BrewingHandler.addBrewingRecipe(event, APotions.Vulnerable, Ingredient.of(Items.REDSTONE), APotions.LongVulnerable);
                BrewingHandler.addBrewingRecipe(event, APotions.Vulnerable, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongVulnerable);
            }

            if (CommonConfig.ENABLE_CORROSION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Repairing, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.CORROSION_INGREDIENT.get()))), APotions.Corrosion);
                BrewingHandler.addBrewingRecipe(event, APotions.Corrosion, Ingredient.of(Items.REDSTONE), APotions.LongCorrosion);
                BrewingHandler.addBrewingRecipe(event, APotions.Corrosion, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongCorrosion);
            }

            if (CommonConfig.ENABLE_CONFUSION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.CONFUSION_INGREDIENT.get()))), APotions.Confusion);
                BrewingHandler.addBrewingRecipe(event, APotions.Confusion, Ingredient.of(Items.REDSTONE), APotions.LongConfusion);
            }

            if (CommonConfig.ENABLE_CORRUPTION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Purification, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.CORRUPTION_INGREDIENT.get()))), APotions.Corruption);
            }

            if (CommonConfig.ENABLE_BURNING_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.BURNING_INGREDIENT.get()))), APotions.Burning);
                BrewingHandler.addBrewingRecipe(event, APotions.Burning, Ingredient.of(Items.REDSTONE), APotions.LongBurning);
                BrewingHandler.addBrewingRecipe(event, APotions.Burning, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongBurning);
            }

            if (CommonConfig.ENABLE_SHOCKED_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.SHOCKED_INGREDIENT.get()))), APotions.Shocked);
                BrewingHandler.addBrewingRecipe(event, APotions.Shocked, Ingredient.of(Items.REDSTONE), APotions.LongShocked);
                BrewingHandler.addBrewingRecipe(event, APotions.Shocked, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongShocked);
            }

            if (CommonConfig.ENABLE_LIGHTNING_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.LIGHTNING_INGREDIENT.get()))), APotions.Lightning);
                BrewingHandler.addBrewingRecipe(event, APotions.Lightning, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongLightning);
            }

            if (CommonConfig.ENABLE_REVERSION_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.Extension, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.REVERSION_INGREDIENT.get()))), APotions.Reversion);
                BrewingHandler.addBrewingRecipe(event, APotions.Reversion, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongReversion);
            }

            if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
                if (CommonConfig.ENABLE_MANA_EXHAUSTION_RECIPE.get()) {
                    BrewingHandler.addBrewingRecipe(event, APotions.ManaRegeneration, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.MANA_EXHAUSTION_INGREDIENT.get()))), APotions.ManaExhaustion);
                    BrewingHandler.addBrewingRecipe(event, APotions.ManaExhaustion, Ingredient.of(Items.REDSTONE), APotions.LongManaExhaustion);
                    BrewingHandler.addBrewingRecipe(event, APotions.ManaExhaustion, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongManaExhaustion);
                }
            }

            if (CommonConfig.ENABLE_MAGIC_DRAIN_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, APotions.MagicPower, Ingredient.of(Objects.requireNonNull(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.MAGIC_DRAIN_INGREDIENT.get())))), APotions.MagicDrain);
                BrewingHandler.addBrewingRecipe(event, APotions.MagicDrain, Ingredient.of(Items.REDSTONE), APotions.LongMagicDrain);
                BrewingHandler.addBrewingRecipe(event, APotions.MagicDrain, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongMagicDrain);
            }

            if (CommonConfig.ENABLE_SHUFFLING_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.SHUFFLING_INGREDIENT.get()))), APotions.Shuffling);
            }

            if (CommonConfig.ENABLE_RESISTANCE_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.RESISTANCE_INGREDIENT.get()))), APotions.Resistance);
                BrewingHandler.addBrewingRecipe(event, APotions.Resistance, Ingredient.of(Items.REDSTONE), APotions.LongResistance);
                BrewingHandler.addBrewingRecipe(event, APotions.Resistance, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongResistance);
            }

            if (CommonConfig.ENABLE_HEALTH_BOOST_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.HEALTH_BOOST_INGREDIENT.get()))), APotions.HealthBoost);
                BrewingHandler.addBrewingRecipe(event, APotions.HealthBoost, Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost);
                BrewingHandler.addBrewingRecipe(event, APotions.HealthBoost, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost);
            }

            if (CommonConfig.ENABLE_LUCK_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.LUCK_INGREDIENT.get()))), Potions.LUCK);
                BrewingHandler.addBrewingRecipe(event, Potions.LUCK, Ingredient.of(Items.REDSTONE), APotions.LongHealthBoost);
                BrewingHandler.addBrewingRecipe(event, Potions.LUCK, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongHealthBoost);
            }

            if (CommonConfig.ENABLE_WITHER_RECIPE.get()) {
                BrewingHandler.addBrewingRecipe(event, Potions.AWKWARD, Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(CommonConfig.WITHER_INGREDIENT.get()))), APotions.Wither);
                BrewingHandler.addBrewingRecipe(event, APotions.Wither, Ingredient.of(Items.REDSTONE), APotions.LongWither);
                BrewingHandler.addBrewingRecipe(event, APotions.Wither, Ingredient.of(Items.GLOWSTONE_DUST), APotions.StrongWither);
            }
        }
    }
}