package net.gobies.apothecary;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WORLD_EVENTS;
    public static boolean enable_world_events;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_IRON_SKIN_RECIPE;
    public static boolean enable_iron_skin_recipe;
    public static ForgeConfigSpec.ConfigValue<String> IRON_SKIN_INGREDIENT;
    public static String iron_skin_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> IRON_SKIN_ARMOR_INCREASE;
    public static int iron_skin_armor_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_BROKEN_ARMOR_RECIPE;
    public static boolean enable_broken_armor_recipe;
    public static ForgeConfigSpec.ConfigValue<String> BROKEN_ARMOR_INGREDIENT;
    public static String broken_armor_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> BROKEN_ARMOR_ARMOR_DECREASE;
    public static int broken_armor_armor_decrease;


    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DIAMOND_SKIN_RECIPE;
    public static boolean enable_diamond_skin_recipe;
    public static ForgeConfigSpec.ConfigValue<String> DIAMOND_SKIN_INGREDIENT;
    public static String diamond_skin_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> DIAMOND_SKIN_ARMOR_INCREASE;
    public static int diamond_skin_armor_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RUPTURED_ARMOR_RECIPE;
    public static boolean enable_ruptured_armor_recipe;
    public static ForgeConfigSpec.ConfigValue<String> RUPTURED_ARMOR_INGREDIENT;
    public static String ruptured_armor_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> RUPTURED_ARMOR_ARMOR_DECREASE;
    public static int ruptured_armor_armor_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ARCHERY_RECIPE;
    public static boolean enable_archery_recipe;
    public static ForgeConfigSpec.ConfigValue<String> ARCHERY_INGREDIENT;
    public static String archery_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> ARCHERY_DAMAGE_INCREASE;
    public static float archery_damage_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MISFIRE_RECIPE;
    public static boolean enable_misfire_recipe;
    public static ForgeConfigSpec.ConfigValue<String> MISFIRE_INGREDIENT;
    public static String misfire_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MISFIRE_DAMAGE_DECREASE;
    public static float misfire_damage_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WRATH_RECIPE;
    public static boolean enable_wrath_recipe;
    public static ForgeConfigSpec.ConfigValue<String> WRATH_INGREDIENT;
    public static String wrath_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> WRATH_DAMAGE_INCREASE;
    public static float wrath_damage_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_FEEBLE_RECIPE;
    public static boolean enable_feeble_recipe;
    public static ForgeConfigSpec.ConfigValue<String> FEEBLE_INGREDIENT;
    public static String feeble_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> FEEBLE_DAMAGE_DECREASE;
    public static float feeble_damage_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_FLIGHT_RECIPE;
    public static boolean enable_flight_recipe;
    public static ForgeConfigSpec.ConfigValue<String> FLIGHT_INGREDIENT;
    public static String flight_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REACH_RECIPE;
    public static boolean enable_reach_recipe;
    public static ForgeConfigSpec.ConfigValue<String> REACH_INGREDIENT;
    public static String reach_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> REACH_INCREASE;
    public static float reach_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REPAIRING_RECIPE;
    public static boolean enable_repairing_recipe;
    public static ForgeConfigSpec.ConfigValue<String> REPAIRING_INGREDIENT;
    public static String repairing_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> REPAIRING_RATE;
    public static int repairing_rate;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORROSION_RECIPE;
    public static boolean enable_corrosion_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CORROSION_INGREDIENT;
    public static String corrosion_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> CORROSION_RATE;
    public static int corrosion_rate;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_POWER_RECIPE;
    public static boolean enable_magic_power_recipe;
    public static ForgeConfigSpec.ConfigValue<String> MAGIC_POWER_INGREDIENT;
    public static String magic_power_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MAGIC_POWER_INCREASE;
    public static float magic_power_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_DRAIN_RECIPE;
    public static boolean enable_magic_drain_recipe;
    public static ForgeConfigSpec.ConfigValue<String> MAGIC_DRAIN_INGREDIENT;
    public static String magic_drain_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MAGIC_DRAIN_DECREASE;
    public static float magic_drain_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_THORNS_RECIPE;
    public static boolean enable_thorns_recipe;
    public static ForgeConfigSpec.ConfigValue<String> THORNS_INGREDIENT;
    public static String thorns_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> THORNS_DAMAGE_REFLECT;
    public static float thorns_damage_reflect;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CONFUSION_RECIPE;
    public static boolean enable_confusion_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CONFUSION_INGREDIENT;
    public static String confusion_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CLEANSED_RECIPE;
    public static boolean enable_cleansed_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CLEANSED_INGREDIENT;
    public static String cleansed_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CLEANSED_BLACKLIST_EFFECTS;
    public static List<? extends String> cleansed_blacklist_effects;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORRUPTED_RECIPE;
    public static boolean enable_corrupted_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CORRUPTED_INGREDIENT;
    public static String corrupted_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTED_BLACKLIST_EFFECTS;
    public static List<? extends String> corrupted_blacklist_effects;

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

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_INDOLENCE_RECIPE;
    public static boolean enable_indolence_recipe;
    public static ForgeConfigSpec.ConfigValue<String> INDOLENCE_INGREDIENT;
    public static String indolence_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> INDOLENCE_DAMAGE_TAKEN;
    public static float indolence_damage_taken;

    public Config() {
    }

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        enable_world_events = ENABLE_WORLD_EVENTS.get();
        enable_iron_skin_recipe = ENABLE_IRON_SKIN_RECIPE.get();
        iron_skin_ingredient = IRON_SKIN_INGREDIENT.get();
        iron_skin_armor_increase = IRON_SKIN_ARMOR_INCREASE.get();
        enable_broken_armor_recipe = ENABLE_BROKEN_ARMOR_RECIPE.get();
        broken_armor_ingredient = BROKEN_ARMOR_INGREDIENT.get();
        broken_armor_armor_decrease = BROKEN_ARMOR_ARMOR_DECREASE.get();
        enable_diamond_skin_recipe = ENABLE_DIAMOND_SKIN_RECIPE.get();
        diamond_skin_ingredient = DIAMOND_SKIN_INGREDIENT.get();
        diamond_skin_armor_increase = DIAMOND_SKIN_ARMOR_INCREASE.get();
        enable_ruptured_armor_recipe = ENABLE_RUPTURED_ARMOR_RECIPE.get();
        ruptured_armor_ingredient = RUPTURED_ARMOR_INGREDIENT.get();
        ruptured_armor_armor_decrease = RUPTURED_ARMOR_ARMOR_DECREASE.get();
        enable_archery_recipe = ENABLE_ARCHERY_RECIPE.get();
        archery_ingredient = ARCHERY_INGREDIENT.get();
        archery_damage_increase = (float) (ARCHERY_DAMAGE_INCREASE.get() * (double) 1.0F);
        enable_misfire_recipe = ENABLE_MISFIRE_RECIPE.get();
        misfire_ingredient = MISFIRE_INGREDIENT.get();
        misfire_damage_decrease = (float) (MISFIRE_DAMAGE_DECREASE.get() * (double) 1.0F);
        enable_wrath_recipe = ENABLE_WRATH_RECIPE.get();
        wrath_ingredient = WRATH_INGREDIENT.get();
        wrath_damage_increase = (float) (WRATH_DAMAGE_INCREASE.get() * (double) 1.0F);
        enable_feeble_recipe = ENABLE_FEEBLE_RECIPE.get();
        feeble_ingredient = FEEBLE_INGREDIENT.get();
        feeble_damage_decrease = (float) (FEEBLE_DAMAGE_DECREASE.get() * (double) 1.0F);
        enable_flight_recipe = ENABLE_FLIGHT_RECIPE.get();
        flight_ingredient = FLIGHT_INGREDIENT.get();
        enable_reach_recipe = ENABLE_REACH_RECIPE.get();
        reach_ingredient = REACH_INGREDIENT.get();
        reach_increase = (float) (REACH_INCREASE.get() * (double) 1.0F);
        enable_repairing_recipe = ENABLE_REPAIRING_RECIPE.get();
        repairing_ingredient = REPAIRING_INGREDIENT.get();
        repairing_rate = REPAIRING_RATE.get();
        enable_corrosion_recipe = ENABLE_CORROSION_RECIPE.get();
        corrosion_ingredient = CORROSION_INGREDIENT.get();
        enable_magic_power_recipe = ENABLE_MAGIC_POWER_RECIPE.get();
        magic_power_ingredient = MAGIC_POWER_INGREDIENT.get();
        magic_power_increase = (float) (MAGIC_POWER_INCREASE.get() * (double) 1.0F);
        enable_magic_drain_recipe = ENABLE_MAGIC_DRAIN_RECIPE.get();
        magic_drain_ingredient = MAGIC_DRAIN_INGREDIENT.get();
        magic_drain_decrease = (float) (MAGIC_DRAIN_DECREASE.get() * (double) 1.0F);
        corrosion_rate = CORROSION_RATE.get();
        enable_thorns_recipe = ENABLE_THORNS_RECIPE.get();
        thorns_ingredient = THORNS_INGREDIENT.get();
        thorns_damage_reflect = (float) (THORNS_DAMAGE_REFLECT.get() * (double) 1.0F);
        enable_confusion_recipe = ENABLE_CONFUSION_RECIPE.get();
        confusion_ingredient = CONFUSION_INGREDIENT.get();
        enable_cleansed_recipe = ENABLE_CLEANSED_RECIPE.get();
        cleansed_ingredient = CLEANSED_INGREDIENT.get();
        cleansed_blacklist_effects = CLEANSED_BLACKLIST_EFFECTS.get();
        enable_corrupted_recipe = ENABLE_CORRUPTED_RECIPE.get();
        corrupted_ingredient = CORRUPTED_INGREDIENT.get();
        corrupted_blacklist_effects = CORRUPTED_BLACKLIST_EFFECTS.get();
        enable_health_boost_recipe = ENABLE_HEALTH_BOOST_RECIPE.get();
        health_boost_ingredient = HEALTH_BOOST_INGREDIENT.get();
        enable_luck_recipe = ENABLE_LUCK_RECIPE.get();
        luck_ingredient = LUCK_INGREDIENT.get();
        enable_resistance_recipe = ENABLE_RESISTANCE_RECIPE.get();
        resistance_ingredient = RESISTANCE_INGREDIENT.get();
        enable_indolence_recipe = ENABLE_INDOLENCE_RECIPE.get();
        indolence_ingredient = INDOLENCE_INGREDIENT.get();
        indolence_damage_taken = (float) (INDOLENCE_DAMAGE_TAKEN.get() * (double) 1.0F);
    }

    static {

        BUILDER.push("General");
        ENABLE_WORLD_EVENTS = BUILDER.comment("Enable world events (effects being able to occur in the world outside of potions)").define("Enable", true);
        BUILDER.pop();

        BUILDER.push("Iron_Skin");
        ENABLE_IRON_SKIN_RECIPE = BUILDER.comment("Enable the iron skin potion recipe").define("Enable", true);
        IRON_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew iron skin potions").define("Ingredient", "minecraft:iron_block");
        IRON_SKIN_ARMOR_INCREASE = BUILDER.comment("Armor points provided by iron skin potions").define("Armor_Increase", 4);
        BUILDER.pop();

        BUILDER.push("Broken_Armor");
        ENABLE_BROKEN_ARMOR_RECIPE = BUILDER.comment("Enable the broken armor potion recipe").define("Enable", true);
        BROKEN_ARMOR_INGREDIENT = BUILDER.comment("Main ingredient used to brew broken armor potions").define("Ingredient", "minecraft:fermented_spider_eye");
        BROKEN_ARMOR_ARMOR_DECREASE = BUILDER.comment("Armor points decreased by broken armor potions").define("Armor_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Diamond_Skin");
        ENABLE_DIAMOND_SKIN_RECIPE = BUILDER.comment("Enable the diamond skin potion recipe").define("Enable", true);
        DIAMOND_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew diamond skin potions").define("Ingredient", "minecraft:diamond_block");
        DIAMOND_SKIN_ARMOR_INCREASE = BUILDER.comment("Armor toughness points provided by diamond skin potions").define("Armor_Toughness_Increase", 2);
        BUILDER.pop();

        BUILDER.push("Ruptured_Armor");
        ENABLE_RUPTURED_ARMOR_RECIPE = BUILDER.comment("Enable the ruptured armor potion recipe").define("Enable", true);
        RUPTURED_ARMOR_INGREDIENT = BUILDER.comment("Main ingredient used to brew ruptured armor potions").define("Ingredient", "minecraft:fermented_spider_eye");
        RUPTURED_ARMOR_ARMOR_DECREASE = BUILDER.comment("Armor toughness points decreased by ruptured armor potions").define("Armor_Toughness_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Archery");
        ENABLE_ARCHERY_RECIPE = BUILDER.comment("Enable the archery potion recipe").define("Enable", true);
        ARCHERY_INGREDIENT = BUILDER.comment("Main ingredient used to brew archery potions").define("Ingredient", "minecraft:skeleton_skull");
        ARCHERY_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by archery potions in percentage").define("Damage_Increase", 0.20);
        BUILDER.pop();

        BUILDER.push("Misfire");
        ENABLE_MISFIRE_RECIPE = BUILDER.comment("Enable the misfire potion recipe").define("Enable", true);
        MISFIRE_INGREDIENT = BUILDER.comment("Main ingredient used to brew misfire potions").define("Ingredient", "minecraft:fermented_spider_eye");
        MISFIRE_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by misfire potions in percentage").define("Damage_Decrease", 0.20);
        BUILDER.pop();

        BUILDER.push("Wrath");
        ENABLE_WRATH_RECIPE = BUILDER.comment("Enable the wrath potion recipe").define("Enable", true);
        WRATH_INGREDIENT = BUILDER.comment("Main ingredient used to brew wrath potions").define("Ingredient", "minecraft:warped_fungus");
        WRATH_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by wrath potions in percentage").define("Damage_Increase", 0.10);
        BUILDER.pop();

        BUILDER.push("Feeble");
        ENABLE_FEEBLE_RECIPE = BUILDER.comment("Enable the feeble potion recipe").define("Enable", true);
        FEEBLE_INGREDIENT = BUILDER.comment("Main ingredient used to brew feeble potions").define("Ingredient", "minecraft:fermented_spider_eye");
        FEEBLE_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by feeble potions in percentage").define("Damage_Decrease", 0.10);
        BUILDER.pop();

        BUILDER.push("Indolence");
        ENABLE_INDOLENCE_RECIPE = BUILDER.comment("Enable the indolence potion recipe").define("Enable", true);
        INDOLENCE_INGREDIENT = BUILDER.comment("Main ingredient used to brew indolence potions").define("Ingredient", "minecraft:fermented_spider_eye");
        INDOLENCE_DAMAGE_TAKEN = BUILDER.comment("Increased damage taken provided by indolence potions in percentage").define("Damage_Taken", 0.20);
        BUILDER.pop();

        BUILDER.push("Flight");
        ENABLE_FLIGHT_RECIPE = BUILDER.comment("Enable the flight potion recipe").define("Enable", true);
        FLIGHT_INGREDIENT = BUILDER.comment("Main ingredient used to brew flight potions").define("Ingredient", "minecraft:dragon_head");
        BUILDER.pop();

        BUILDER.push("Reach");
        ENABLE_REACH_RECIPE = BUILDER.comment("Enable the reach potion recipe").define("Enable", true);
        REACH_INGREDIENT = BUILDER.comment("Main ingredient used to brew reach potions").define("Ingredient", "minecraft:end_rod");
        REACH_INCREASE = BUILDER.comment("Reach distance increased by reach potions").define("Reach_Increase", 1.0);
        BUILDER.pop();

        BUILDER.push("Repairing");
        ENABLE_REPAIRING_RECIPE = BUILDER.comment("Enable the repairing potion recipe").define("Enable", true);
        REPAIRING_INGREDIENT = BUILDER.comment("Main ingredient used to brew repairing potions").define("Ingredient", "minecraft:anvil");
        REPAIRING_RATE = BUILDER.comment("Repair rate provided by repairing potions").define("Repair_Rate", 1);
        BUILDER.pop();

        BUILDER.push("Corrosion");
        ENABLE_CORROSION_RECIPE = BUILDER.comment("Enable the corrosion potion recipe").define("Enable", true);
        CORROSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew corrosion potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORROSION_RATE = BUILDER.comment("Corrosion rate provided by corrosion potions").define("Corrosion_Rate", 1);
        BUILDER.pop();

        BUILDER.push("Magic_Power");
        ENABLE_MAGIC_POWER_RECIPE = BUILDER.comment("Enable the magic power potion recipe").define("Enable", true);
        MAGIC_POWER_INGREDIENT = BUILDER.comment("Main ingredient used to brew magic power potions").define("Ingredient", "irons_spellbooks:arcane_essence");
        MAGIC_POWER_INCREASE = BUILDER.comment("Damage increase provided by magic power potions in percentage").define("Magic_Power_Increase", 0.1);
        BUILDER.pop();

        BUILDER.push("Magic_Drain");
        ENABLE_MAGIC_DRAIN_RECIPE = BUILDER.comment("Enable the magic drain potion recipe").define("Enable", true);
        MAGIC_DRAIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew magic drain potions").define("Ingredient", "irons_spellbooks:arcane_essence");
        MAGIC_DRAIN_DECREASE = BUILDER.comment("Damage decrease provided by magic drain potions in percentage").define("Magic_Drain_Increase", 0.1);
        BUILDER.pop();

        BUILDER.push("Thorns");
        ENABLE_THORNS_RECIPE = BUILDER.comment("Enable the thorns potion recipe").define("Enable", true);
        THORNS_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:sweet_berries");
        THORNS_DAMAGE_REFLECT = BUILDER.comment("Damage reflected by thorns potions in percentage").define("Damage_Reflected", 0.20);
        BUILDER.pop();

        BUILDER.push("Confusion");
        ENABLE_CONFUSION_RECIPE = BUILDER.comment("Enable the confusion potion recipe").define("Enable", true);
        CONFUSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:sniffer_egg");
        BUILDER.pop();

        BUILDER.push("Cleansed");
        ENABLE_CLEANSED_RECIPE = BUILDER.comment("Enable the cleansed potion recipe").define("Enable", true);
        CLEANSED_INGREDIENT = BUILDER.comment("Main ingredient used to brew cleansed potions").define("Ingredient", "minecraft:heart_of_the_sea");
        CLEANSED_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the cleansed effect (e.g., minecraft:poison, minecraft:slowness etc)").defineList("cleansed_blacklist_effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Corrupted");
        ENABLE_CORRUPTED_RECIPE = BUILDER.comment("Enable the corrupted potion recipe").define("Enable", true);
        CORRUPTED_INGREDIENT = BUILDER.comment("Main ingredient used to brew corrupted potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORRUPTED_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the corrupted effect (e.g., minecraft:strength, minecraft:speed etc)").defineList("corrupted_blacklist_effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Health_Boost");
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
