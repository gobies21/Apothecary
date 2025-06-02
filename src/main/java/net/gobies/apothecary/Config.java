package net.gobies.apothecary;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_IRON_SKIN_RECIPE;
    public static boolean enable_iron_skin_recipe;
    public static ForgeConfigSpec.ConfigValue<String> IRON_SKIN_INGREDIENT;
    public static String iron_skin_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DIAMOND_SKIN_RECIPE;
    public static boolean enable_diamond_skin_recipe;
    public static ForgeConfigSpec.ConfigValue<String> DIAMOND_SKIN_INGREDIENT;
    public static String diamond_skin_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ARCHERY_RECIPE;
    public static boolean enable_archery_recipe;
    public static ForgeConfigSpec.ConfigValue<String> ARCHERY_INGREDIENT;
    public static String archery_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WRATH_RECIPE;
    public static boolean enable_wrath_recipe;
    public static ForgeConfigSpec.ConfigValue<String> WRATH_INGREDIENT;
    public static String wrath_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_FLIGHT_RECIPE;
    public static boolean enable_flight_recipe;
    public static ForgeConfigSpec.ConfigValue<String> FLIGHT_INGREDIENT;
    public static String flight_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REACH_RECIPE;
    public static boolean enable_reach_recipe;
    public static ForgeConfigSpec.ConfigValue<String> REACH_INGREDIENT;
    public static String reach_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_HEALTH_BOOST_RECIPE;
    public static boolean enable_health_boost_recipe;
    public static ForgeConfigSpec.ConfigValue<String> HEALTH_BOOST_INGREDIENT;
    public static String health_boost_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LUCK_RECIPE;
    public static boolean enable_luck_recipe;
    public static ForgeConfigSpec.ConfigValue<String> LUCK_INGREDIENT;
    public static String luck_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RESISTANCE_RECIPE;
    public static boolean enable_resistance_recipe;
    public static ForgeConfigSpec.ConfigValue<String> RESISTANCE_INGREDIENT;
    public static String resistance_ingredient;

    public Config() {
    }

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        enable_iron_skin_recipe = ENABLE_IRON_SKIN_RECIPE.get();
        iron_skin_ingredient = IRON_SKIN_INGREDIENT.get();
        enable_diamond_skin_recipe = ENABLE_DIAMOND_SKIN_RECIPE.get();
        diamond_skin_ingredient = DIAMOND_SKIN_INGREDIENT.get();
        enable_archery_recipe = ENABLE_ARCHERY_RECIPE.get();
        archery_ingredient = ARCHERY_INGREDIENT.get();
        enable_wrath_recipe = ENABLE_WRATH_RECIPE.get();
        wrath_ingredient = WRATH_INGREDIENT.get();
        enable_flight_recipe = ENABLE_FLIGHT_RECIPE.get();
        flight_ingredient = FLIGHT_INGREDIENT.get();
        enable_reach_recipe = ENABLE_REACH_RECIPE.get();
        reach_ingredient = REACH_INGREDIENT.get();
        enable_health_boost_recipe = ENABLE_HEALTH_BOOST_RECIPE.get();
        health_boost_ingredient = HEALTH_BOOST_INGREDIENT.get();
        enable_luck_recipe = ENABLE_LUCK_RECIPE.get();
        luck_ingredient = LUCK_INGREDIENT.get();
        enable_resistance_recipe = ENABLE_RESISTANCE_RECIPE.get();
        resistance_ingredient = RESISTANCE_INGREDIENT.get();
    }

    static {

        BUILDER.push("Iron Skin");
        ENABLE_IRON_SKIN_RECIPE = BUILDER.comment("Enable the iron skin potion recipe").define("Enable", true);
        IRON_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew iron skin potions").define("Ingredient", "minecraft:iron_block");
        BUILDER.pop();

        BUILDER.push("Diamond Skin");
        ENABLE_DIAMOND_SKIN_RECIPE = BUILDER.comment("Enable the diamond skin potion recipe").define("Enable", true);
        DIAMOND_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew diamond skin potions").define("Ingredient", "minecraft:diamond_block");
        BUILDER.pop();

        BUILDER.push("Archery");
        ENABLE_ARCHERY_RECIPE = BUILDER.comment("Enable the archery potion recipe").define("Enable", true);
        ARCHERY_INGREDIENT = BUILDER.comment("Main ingredient used to brew archery potions").define("Ingredient", "minecraft:skeleton_skull");
        BUILDER.pop();

        BUILDER.push("Wrath");
        ENABLE_WRATH_RECIPE = BUILDER.comment("Enable the wrath potion recipe").define("Enable", true);
        WRATH_INGREDIENT = BUILDER.comment("Main ingredient used to brew wrath potions").define("Ingredient", "minecraft:warped_fungus");
        BUILDER.pop();

        BUILDER.push("Flight");
        ENABLE_FLIGHT_RECIPE = BUILDER.comment("Enable the flight potion recipe").define("Enable", true);
        FLIGHT_INGREDIENT = BUILDER.comment("Main ingredient used to brew flight potions").define("Ingredient", "minecraft:dragon_head");
        BUILDER.pop();

        BUILDER.push("Reach");
        ENABLE_REACH_RECIPE = BUILDER.comment("Enable the reach potion recipe").define("Enable", true);
        REACH_INGREDIENT = BUILDER.comment("Main ingredient used to brew reach potions").define("Ingredient", "minecraft:end_rod");
        BUILDER.pop();

        BUILDER.push("Health Boost");
        ENABLE_HEALTH_BOOST_RECIPE = BUILDER.comment("Enable the health boost potion recipe").define("Enable", true);
        HEALTH_BOOST_INGREDIENT = BUILDER.comment("Main ingredient used to brew health boost potions").define("Ingredient", "minecraft:golden_apple");
        BUILDER.pop();

        BUILDER.push("Luck");
        ENABLE_LUCK_RECIPE = BUILDER.comment("Enable the luck potion recipe").define("Enable", true);
        LUCK_INGREDIENT = BUILDER.comment("Main ingredient used to brew luck potions").define("Ingredient", "minecraft:emerald_block");
        BUILDER.pop();

        BUILDER.push("Resistance");
        ENABLE_RESISTANCE_RECIPE = BUILDER.comment("Enable the resistance potion recipe").define("Enable", true);
        RESISTANCE_INGREDIENT = BUILDER.comment("Main ingredient used to brew resistance potions").define("Ingredient", "minecraft:crimson_fungus");
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
