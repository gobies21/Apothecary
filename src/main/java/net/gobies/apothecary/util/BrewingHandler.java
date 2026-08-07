package net.gobies.apothecary.util;

import net.minecraft.core.Holder;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

public class BrewingHandler {

    public static void addBrewingRecipe(RegisterBrewingRecipesEvent event, Holder<Potion> basePotion, Ingredient ingredient, Holder<Potion> resultPotion) {
        if (ingredient.getItems().length > 0) {
            event.getBuilder().addMix(basePotion, ingredient.getItems()[0].getItem(), resultPotion);
        }
    }
}
