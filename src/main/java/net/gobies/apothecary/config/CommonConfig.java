package net.gobies.apothecary.config;

import net.gobies.apothecary.Apothecary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final String FILENAME = "apothecary-common.toml";

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
    public static ForgeConfigSpec.ConfigValue<Integer> ARCHERY_DAMAGE_INCREASE;
    public static int archery_damage_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MISFIRE_RECIPE;
    public static boolean enable_misfire_recipe;
    public static ForgeConfigSpec.ConfigValue<String> MISFIRE_INGREDIENT;
    public static String misfire_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> MISFIRE_DAMAGE_DECREASE;
    public static int misfire_damage_decrease;

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
    public static ForgeConfigSpec.ConfigValue<Integer> REACH_INCREASE;
    public static int reach_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REPAIRING_RECIPE;
    public static boolean enable_repairing_recipe;
    public static ForgeConfigSpec.ConfigValue<String> REPAIRING_INGREDIENT;
    public static String repairing_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> REPAIRING_AMOUNT;
    public static int repairing_amount;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORROSION_RECIPE;
    public static boolean enable_corrosion_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CORROSION_INGREDIENT;
    public static String corrosion_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> CORROSION_AMOUNT;
    public static int corrosion_amount;

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

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_PURIFICATION_RECIPE;
    public static boolean enable_purification_recipe;
    public static ForgeConfigSpec.ConfigValue<String> PURIFICATION_INGREDIENT;
    public static String purification_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PURIFICATION_BLACKLIST_EFFECTS;
    public static List<? extends String> purification_blacklist_effects;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORRUPTION_RECIPE;
    public static boolean enable_corruption_recipe;
    public static ForgeConfigSpec.ConfigValue<String> CORRUPTION_INGREDIENT;
    public static String corruption_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTION_BLACKLIST_EFFECTS;
    public static List<? extends String> corruption_blacklist_effects;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SHUFFLING_RECIPE;
    public static boolean enable_shuffling_recipe;
    public static ForgeConfigSpec.ConfigValue<String> SHUFFLING_INGREDIENT;
    public static String shuffling_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_BURNING_RECIPE;
    public static boolean enable_burning_recipe;
    public static ForgeConfigSpec.ConfigValue<String> BURNING_INGREDIENT;
    public static String burning_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SHOCKED_RECIPE;
    public static boolean enable_shocked_recipe;
    public static ForgeConfigSpec.ConfigValue<String> SHOCKED_INGREDIENT;
    public static String shocked_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> SHOCKED_SPEED_DECREASE;
    public static float shocked_speed_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LIGHTNING_RECIPE;
    public static boolean enable_lightning_recipe;
    public static ForgeConfigSpec.ConfigValue<String> LIGHTNING_INGREDIENT;
    public static String lightning_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SPELUNKER_RECIPE;
    public static boolean enable_spelunker_recipe;
    public static ForgeConfigSpec.ConfigValue<String> SPELUNKER_INGREDIENT;
    public static String spelunker_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SPELUNKER_ORE_LIST;
    public static List<? extends String> spelunker_ore_list;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_EXTENSION_RECIPE;
    public static boolean enable_extension_recipe;
    public static ForgeConfigSpec.ConfigValue<String> EXTENSION_INGREDIENT;
    public static String extension_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXTENSION_BLACKLIST_EFFECTS;
    public static List<? extends String> extended_blacklist_effects;
    public static ForgeConfigSpec.ConfigValue<Integer> EXTENSION_CAP;
    public static int extension_cap;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REVERSION_RECIPE;
    public static boolean enable_reversion_recipe;
    public static ForgeConfigSpec.ConfigValue<String> REVERSION_INGREDIENT;
    public static String reversion_ingredient;

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

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_VULNERABLE_RECIPE;
    public static boolean enable_vulnerable_recipe;
    public static ForgeConfigSpec.ConfigValue<String> VULNERABLE_INGREDIENT;
    public static String vulnerable_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> VULNERABLE_DAMAGE_TAKEN;
    public static float vulnerable_damage_taken;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WITHER_RECIPE;
    public static boolean enable_wither_recipe;
    public static ForgeConfigSpec.ConfigValue<String> WITHER_INGREDIENT;
    public static String wither_ingredient;

    // World Events
    public static ForgeConfigSpec.ConfigValue<Integer> WITCH_POTION_COUNT;
    public static int witch_potion_count;
    public static ForgeConfigSpec.ConfigValue<Integer> WITCH_POTION_COOLDOWN;
    public static int witch_potion_cooldown;

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getFileName().equals(FILENAME)) {
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
            archery_damage_increase = ARCHERY_DAMAGE_INCREASE.get();
            enable_misfire_recipe = ENABLE_MISFIRE_RECIPE.get();
            misfire_ingredient = MISFIRE_INGREDIENT.get();
            misfire_damage_decrease = MISFIRE_DAMAGE_DECREASE.get();
            enable_wrath_recipe = ENABLE_WRATH_RECIPE.get();
            wrath_ingredient = WRATH_INGREDIENT.get();
            wrath_damage_increase = WRATH_DAMAGE_INCREASE.get().floatValue();
            enable_feeble_recipe = ENABLE_FEEBLE_RECIPE.get();
            feeble_ingredient = FEEBLE_INGREDIENT.get();
            feeble_damage_decrease = FEEBLE_DAMAGE_DECREASE.get().floatValue();
            enable_flight_recipe = ENABLE_FLIGHT_RECIPE.get();
            flight_ingredient = FLIGHT_INGREDIENT.get();
            enable_reach_recipe = ENABLE_REACH_RECIPE.get();
            reach_ingredient = REACH_INGREDIENT.get();
            reach_increase = REACH_INCREASE.get();
            enable_repairing_recipe = ENABLE_REPAIRING_RECIPE.get();
            repairing_ingredient = REPAIRING_INGREDIENT.get();
            repairing_amount = REPAIRING_AMOUNT.get();
            enable_corrosion_recipe = ENABLE_CORROSION_RECIPE.get();
            corrosion_ingredient = CORROSION_INGREDIENT.get();
            enable_magic_power_recipe = ENABLE_MAGIC_POWER_RECIPE.get();
            magic_power_ingredient = MAGIC_POWER_INGREDIENT.get();
            magic_power_increase = MAGIC_POWER_INCREASE.get().floatValue();
            enable_magic_drain_recipe = ENABLE_MAGIC_DRAIN_RECIPE.get();
            magic_drain_ingredient = MAGIC_DRAIN_INGREDIENT.get();
            magic_drain_decrease = MAGIC_DRAIN_DECREASE.get().floatValue();
            corrosion_amount = CORROSION_AMOUNT.get();
            enable_thorns_recipe = ENABLE_THORNS_RECIPE.get();
            thorns_ingredient = THORNS_INGREDIENT.get();
            thorns_damage_reflect = THORNS_DAMAGE_REFLECT.get().floatValue();
            enable_confusion_recipe = ENABLE_CONFUSION_RECIPE.get();
            confusion_ingredient = CONFUSION_INGREDIENT.get();
            enable_purification_recipe = ENABLE_PURIFICATION_RECIPE.get();
            purification_ingredient = PURIFICATION_INGREDIENT.get();
            purification_blacklist_effects = PURIFICATION_BLACKLIST_EFFECTS.get();
            enable_corruption_recipe = ENABLE_CORRUPTION_RECIPE.get();
            corruption_ingredient = CORRUPTION_INGREDIENT.get();
            corruption_blacklist_effects = CORRUPTION_BLACKLIST_EFFECTS.get();
            enable_shuffling_recipe = ENABLE_SHUFFLING_RECIPE.get();
            shuffling_ingredient = SHUFFLING_INGREDIENT.get();
            enable_burning_recipe = ENABLE_BURNING_RECIPE.get();
            burning_ingredient = BURNING_INGREDIENT.get();
            enable_shocked_recipe = ENABLE_SHOCKED_RECIPE.get();
            shocked_ingredient = SHOCKED_INGREDIENT.get();
            shocked_speed_decrease = SHOCKED_SPEED_DECREASE.get().floatValue();
            enable_lightning_recipe = ENABLE_LIGHTNING_RECIPE.get();
            lightning_ingredient = LIGHTNING_INGREDIENT.get();
            enable_spelunker_recipe = ENABLE_SPELUNKER_RECIPE.get();
            spelunker_ingredient = SPELUNKER_INGREDIENT.get();
            spelunker_ore_list = SPELUNKER_ORE_LIST.get();
            enable_extension_recipe = ENABLE_EXTENSION_RECIPE.get();
            extension_ingredient = EXTENSION_INGREDIENT.get();
            extension_cap = EXTENSION_CAP.get();
            enable_reversion_recipe = ENABLE_REVERSION_RECIPE.get();
            extended_blacklist_effects = EXTENSION_BLACKLIST_EFFECTS.get();
            reversion_ingredient = REVERSION_INGREDIENT.get();
            enable_health_boost_recipe = ENABLE_HEALTH_BOOST_RECIPE.get();
            health_boost_ingredient = HEALTH_BOOST_INGREDIENT.get();
            enable_luck_recipe = ENABLE_LUCK_RECIPE.get();
            luck_ingredient = LUCK_INGREDIENT.get();
            enable_resistance_recipe = ENABLE_RESISTANCE_RECIPE.get();
            resistance_ingredient = RESISTANCE_INGREDIENT.get();
            enable_vulnerable_recipe = ENABLE_VULNERABLE_RECIPE.get();
            vulnerable_ingredient = VULNERABLE_INGREDIENT.get();
            vulnerable_damage_taken = VULNERABLE_DAMAGE_TAKEN.get().floatValue();
            enable_wither_recipe = ENABLE_WITHER_RECIPE.get();
            wither_ingredient = WITHER_INGREDIENT.get();
            witch_potion_count = WITCH_POTION_COUNT.get();
            witch_potion_cooldown = WITCH_POTION_COOLDOWN.get();
        }
    }

    static {

        BUILDER.push("General");
        ENABLE_WORLD_EVENTS = BUILDER.comment("Enable world events (effects being able to occur in the world outside of potions)").define("World_Events", true);
        BUILDER.pop();

        //
        BUILDER.push("Potions");
        //

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
        DIAMOND_SKIN_ARMOR_INCREASE = BUILDER.comment("Armor toughness points provided by diamond skin potions").define("Armor_Toughness_Increase", 4);
        BUILDER.pop();

        BUILDER.push("Ruptured_Armor");
        ENABLE_RUPTURED_ARMOR_RECIPE = BUILDER.comment("Enable the ruptured armor potion recipe").define("Enable", true);
        RUPTURED_ARMOR_INGREDIENT = BUILDER.comment("Main ingredient used to brew ruptured armor potions").define("Ingredient", "minecraft:fermented_spider_eye");
        RUPTURED_ARMOR_ARMOR_DECREASE = BUILDER.comment("Armor toughness points decreased by ruptured armor potions").define("Armor_Toughness_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Archery");
        ENABLE_ARCHERY_RECIPE = BUILDER.comment("Enable the archery potion recipe").define("Enable", true);
        ARCHERY_INGREDIENT = BUILDER.comment("Main ingredient used to brew archery potions").define("Ingredient", "minecraft:skeleton_skull");
        ARCHERY_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by archery potions").define("Damage_Increase", 3);
        BUILDER.pop();

        BUILDER.push("Misfire");
        ENABLE_MISFIRE_RECIPE = BUILDER.comment("Enable the misfire potion recipe").define("Enable", true);
        MISFIRE_INGREDIENT = BUILDER.comment("Main ingredient used to brew misfire potions").define("Ingredient", "minecraft:fermented_spider_eye");
        MISFIRE_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by misfire potions").define("Damage_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Wrath");
        ENABLE_WRATH_RECIPE = BUILDER.comment("Enable the wrath potion recipe").define("Enable", true);
        WRATH_INGREDIENT = BUILDER.comment("Main ingredient used to brew wrath potions").define("Ingredient", "minecraft:crimson_fungus");
        WRATH_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by wrath potions in percentage").define("Damage_Increase", 0.10);
        BUILDER.pop();

        BUILDER.push("Feeble");
        ENABLE_FEEBLE_RECIPE = BUILDER.comment("Enable the feeble potion recipe").define("Enable", true);
        FEEBLE_INGREDIENT = BUILDER.comment("Main ingredient used to brew feeble potions").define("Ingredient", "minecraft:fermented_spider_eye");
        FEEBLE_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by feeble potions in percentage").define("Damage_Decrease", 0.10);
        BUILDER.pop();

        BUILDER.push("Vulnerable");
        ENABLE_VULNERABLE_RECIPE = BUILDER.comment("Enable the vulnerable potion recipe").define("Enable", true);
        VULNERABLE_INGREDIENT = BUILDER.comment("Main ingredient used to brew vulnerable potions").define("Ingredient", "minecraft:fermented_spider_eye");
        VULNERABLE_DAMAGE_TAKEN = BUILDER.comment("Increased damage taken provided by vulnerable potions in percentage").define("Damage_Taken", 0.20);
        BUILDER.pop();

        BUILDER.push("Flight");
        ENABLE_FLIGHT_RECIPE = BUILDER.comment("Enable the flight potion recipe").define("Enable", true);
        FLIGHT_INGREDIENT = BUILDER.comment("Main ingredient used to brew flight potions").define("Ingredient", "minecraft:dragon_head");
        BUILDER.pop();

        BUILDER.push("Reach");
        ENABLE_REACH_RECIPE = BUILDER.comment("Enable the reach potion recipe").define("Enable", true);
        REACH_INGREDIENT = BUILDER.comment("Main ingredient used to brew reach potions").define("Ingredient", "minecraft:end_rod");
        REACH_INCREASE = BUILDER.comment("Reach distance increased by reach potions").define("Reach_Increase", 1);
        BUILDER.pop();

        BUILDER.push("Repairing");
        ENABLE_REPAIRING_RECIPE = BUILDER.comment("Enable the repairing potion recipe").define("Enable", true);
        REPAIRING_INGREDIENT = BUILDER.comment("Main ingredient used to brew repairing potions").define("Ingredient", "minecraft:anvil");
        REPAIRING_AMOUNT = BUILDER.comment("Repair amount provided by repairing potions").define("Repair_Amount", 1);
        BUILDER.pop();

        BUILDER.push("Corrosion");
        ENABLE_CORROSION_RECIPE = BUILDER.comment("Enable the corrosion potion recipe").define("Enable", true);
        CORROSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew corrosion potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORROSION_AMOUNT = BUILDER.comment("Corrosion amount provided by corrosion potions").define("Corrosion_Amount", 1);
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
        THORNS_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:cactus");
        THORNS_DAMAGE_REFLECT = BUILDER.comment("Damage reflected by thorns potions in percentage").define("Damage_Reflected", 0.20);
        BUILDER.pop();

        BUILDER.push("Confusion");
        ENABLE_CONFUSION_RECIPE = BUILDER.comment("Enable the confusion potion recipe").define("Enable", true);
        CONFUSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:sniffer_egg");
        BUILDER.pop();

        BUILDER.push("Purification");
        ENABLE_PURIFICATION_RECIPE = BUILDER.comment("Enable the purification potion recipe").define("Enable", true);
        PURIFICATION_INGREDIENT = BUILDER.comment("Main ingredient used to brew purification potions").define("Ingredient", "minecraft:heart_of_the_sea");
        PURIFICATION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the purification effect (e.g., minecraft:poison, minecraft:slowness etc)").defineList("Purification_Blacklist_Effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Corruption");
        ENABLE_CORRUPTION_RECIPE = BUILDER.comment("Enable the corruption potion recipe").define("Enable", true);
        CORRUPTION_INGREDIENT = BUILDER.comment("Main ingredient used to brew corruption potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORRUPTION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the corruption effect (e.g., minecraft:strength, minecraft:speed etc)").defineList("Corruption_Blacklist_Effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Shuffling");
        ENABLE_SHUFFLING_RECIPE = BUILDER.comment("Enable the shuffling potion recipe").define("Enable", true);
        SHUFFLING_INGREDIENT = BUILDER.comment("Main ingredient used to brew shuffling potions").define("Ingredient", "minecraft:trapped_chest");
        BUILDER.pop();

        BUILDER.push("Burning");
        ENABLE_BURNING_RECIPE = BUILDER.comment("Enable the burning potion recipe").define("Enable", true);
        BURNING_INGREDIENT = BUILDER.comment("Main ingredient used to brew burning potions").define("Ingredient", "minecraft:magma_block");
        BUILDER.pop();

        BUILDER.push("Shocked");
        ENABLE_SHOCKED_RECIPE = BUILDER.comment("Enable the shocked potion recipe").define("Enable", true);
        SHOCKED_INGREDIENT = BUILDER.comment("Main ingredient used to brew shocked potions").define("Ingredient", "minecraft:copper_block");
        SHOCKED_SPEED_DECREASE = BUILDER.comment("Amount of movement speed reduction for the shocked effect").define("Shocked_Speed_Decrease", 0.5);
        BUILDER.pop();

        BUILDER.push("Lightning");
        ENABLE_LIGHTNING_RECIPE = BUILDER.comment("Enable the lightning potion recipe").define("Enable", true);
        LIGHTNING_INGREDIENT = BUILDER.comment("Main ingredient used to brew lightning potions").define("Ingredient", "minecraft:lightning_rod");
        BUILDER.pop();

        BUILDER.push("Spelunker");
        ENABLE_SPELUNKER_RECIPE = BUILDER.comment("Enable the spelunker potion recipe").define("Enable", true);
        SPELUNKER_INGREDIENT = BUILDER.comment("Main ingredient used to brew spelunker potions").define("Ingredient", "minecraft:raw_gold_block");
        SPELUNKER_ORE_LIST = BUILDER.comment("List of ores that the spelunker effect can detect (e.g., minecraft:iron_ore, minecraft:gold_ore etc)").defineList("Spelunker_Ore_List", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Extension");
        ENABLE_EXTENSION_RECIPE = BUILDER.comment("Enable the extension potion recipe").define("Enable", true);
        EXTENSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew extension potions").define("Ingredient", "minecraft:amethyst_cluster");
        EXTENSION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being extended from the extension effect (e.g., minecraft:jump_boost, minecraft:water_breathing etc)").defineList("Extension_Blacklist_Effects", List.of(), s -> s instanceof String);
        EXTENSION_CAP = BUILDER.comment("Max duration cap for the extension effect to increase in seconds").define("Extension_Cap", 600);
        BUILDER.pop();

        BUILDER.push("Reversion");
        ENABLE_REVERSION_RECIPE = BUILDER.comment("Enable the reversion potion recipe").define("Enable", true);
        REVERSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew reversion potions").define("Ingredient", "minecraft:fermented_spider_eye");
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
        RESISTANCE_INGREDIENT = BUILDER.comment("Main ingredient used to brew resistance potions").define("Ingredient", "minecraft:warped_fungus");
        BUILDER.pop();

        BUILDER.push("Wither");
        ENABLE_WITHER_RECIPE = BUILDER.comment("Enable the wither potion recipe").define("Enable", true);
        WITHER_INGREDIENT = BUILDER.comment("Main ingredient used to brew wither potions").define("Ingredient", "minecraft:wither_rose");
        BUILDER.pop();

        //
        BUILDER.pop();
        //

        BUILDER.push("World_Events");
        WITCH_POTION_COUNT = BUILDER.comment("Amount of apothecary potions witches can throw before they default back to vanilla potions.").define("Witch_Potion_Count", 1);
        WITCH_POTION_COOLDOWN = BUILDER.comment("Cooldown for witches to be able to throw apothecary potions again after the potion count has been reached in seconds").define("Witch_Potion_Cooldown", 5);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
