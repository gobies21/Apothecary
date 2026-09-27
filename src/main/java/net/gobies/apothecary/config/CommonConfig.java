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

    public static ForgeConfigSpec.ConfigValue<Boolean> APOTHECARY_ENABLED;
    public static boolean apothecary_enabled;
    public static ForgeConfigSpec.ConfigValue<Boolean> POTIONS_ENABLED;
    public static boolean potions_enabled;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WORLD_EVENTS;
    public static boolean enable_world_events;
    public static ForgeConfigSpec.ConfigValue<Double> MAX_DAMAGE_RESISTANCE;
    public static float max_damage_resistance;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_IRON_SKIN;
    public static boolean enable_iron_skin;
    public static ForgeConfigSpec.ConfigValue<String> IRON_SKIN_INGREDIENT;
    public static String iron_skin_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> IRON_SKIN_ARMOR_INCREASE;
    public static int iron_skin_armor_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_BROKEN_ARMOR;
    public static boolean enable_broken_armor;
    public static ForgeConfigSpec.ConfigValue<String> BROKEN_ARMOR_INGREDIENT;
    public static String broken_armor_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> BROKEN_ARMOR_ARMOR_DECREASE;
    public static int broken_armor_armor_decrease;


    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DIAMOND_SKIN;
    public static boolean enable_diamond_skin;
    public static ForgeConfigSpec.ConfigValue<String> DIAMOND_SKIN_INGREDIENT;
    public static String diamond_skin_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> DIAMOND_SKIN_ARMOR_INCREASE;
    public static int diamond_skin_armor_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_SHIELD;
    public static boolean enable_magic_shield;
    public static ForgeConfigSpec.ConfigValue<String> MAGIC_SHIELD_INGREDIENT;
    public static String magic_shield_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> MAGIC_SHIELD_INCREASE;
    public static int magic_shield_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RUPTURED_ARMOR;
    public static boolean enable_ruptured_armor;
    public static ForgeConfigSpec.ConfigValue<String> RUPTURED_ARMOR_INGREDIENT;
    public static String ruptured_armor_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> RUPTURED_ARMOR_ARMOR_DECREASE;
    public static int ruptured_armor_armor_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ARCHERY;
    public static boolean enable_archery;
    public static ForgeConfigSpec.ConfigValue<String> ARCHERY_INGREDIENT;
    public static String archery_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> ARCHERY_DAMAGE_INCREASE;
    public static int archery_damage_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_QUICK_DRAW;
    public static boolean enable_quick_draw;
    public static ForgeConfigSpec.ConfigValue<String> QUICK_DRAW_INGREDIENT;
    public static String quick_draw_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> QUICK_DRAW_SPEED_INCREASE;
    public static float quick_draw_speed_increase;
    public static ForgeConfigSpec.ConfigValue<Double> QUICK_DRAW_VELOCITY_INCREASE;
    public static float quick_draw_velocity_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MISFIRE;
    public static boolean enable_misfire;
    public static ForgeConfigSpec.ConfigValue<String> MISFIRE_INGREDIENT;
    public static String misfire_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> MISFIRE_DAMAGE_DECREASE;
    public static int misfire_damage_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LETHARGY;
    public static boolean enable_lethargy;
    public static ForgeConfigSpec.ConfigValue<String> LETHARGY_INGREDIENT;
    public static String lethargy_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> LETHARGY_SPEED_DECREASE;
    public static float lethargy_speed_decrease;
    public static ForgeConfigSpec.ConfigValue<Double> LETHARGY_VELOCITY_DECREASE;
    public static float lethargy_velocity_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WRATH;
    public static boolean enable_wrath;
    public static ForgeConfigSpec.ConfigValue<String> WRATH_INGREDIENT;
    public static String wrath_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> WRATH_DAMAGE_INCREASE;
    public static float wrath_damage_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_FRAIL;
    public static boolean enable_frail;
    public static ForgeConfigSpec.ConfigValue<String> FRAIL_INGREDIENT;
    public static String frail_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> FRAIL_DAMAGE_DECREASE;
    public static float frail_damage_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_FLIGHT;
    public static boolean enable_flight;
    public static ForgeConfigSpec.ConfigValue<String> FLIGHT_INGREDIENT;
    public static String flight_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REACH;
    public static boolean enable_reach;
    public static ForgeConfigSpec.ConfigValue<String> REACH_INGREDIENT;
    public static String reach_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> REACH_INCREASE;
    public static int reach_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REPAIRING;
    public static boolean enable_repairing;
    public static ForgeConfigSpec.ConfigValue<String> REPAIRING_INGREDIENT;
    public static String repairing_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> REPAIRING_AMOUNT;
    public static int repairing_amount;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORROSION;
    public static boolean enable_corrosion;
    public static ForgeConfigSpec.ConfigValue<String> CORROSION_INGREDIENT;
    public static String corrosion_ingredient;
    public static ForgeConfigSpec.ConfigValue<Integer> CORROSION_AMOUNT;
    public static int corrosion_amount;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_POWER;
    public static boolean enable_magic_power;
    public static ForgeConfigSpec.ConfigValue<String> MAGIC_POWER_INGREDIENT;
    public static String magic_power_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MAGIC_POWER_INCREASE;
    public static float magic_power_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_DRAIN;
    public static boolean enable_magic_drain;
    public static ForgeConfigSpec.ConfigValue<String> MAGIC_DRAIN_INGREDIENT;
    public static String magic_drain_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MAGIC_DRAIN_DECREASE;
    public static float magic_drain_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MANA_REGENERATION;
    public static boolean enable_mana_regeneration;
    public static ForgeConfigSpec.ConfigValue<String> MANA_REGENERATION_INGREDIENT;
    public static String mana_regeneration_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MANA_REGENERATION_INCREASE;
    public static float mana_regeneration_increase;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MANA_EXHAUSTION;
    public static boolean enable_mana_exhaustion;
    public static ForgeConfigSpec.ConfigValue<String> MANA_EXHAUSTION_INGREDIENT;
    public static String mana_exhaustion_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> MANA_EXHAUSTION_DECREASE;
    public static float mana_exhaustion_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_THORNS;
    public static boolean enable_thorns;
    public static ForgeConfigSpec.ConfigValue<String> THORNS_INGREDIENT;
    public static String thorns_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> THORNS_DAMAGE_REFLECT;
    public static float thorns_damage_reflect;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CONFUSION;
    public static boolean enable_confusion;
    public static ForgeConfigSpec.ConfigValue<String> CONFUSION_INGREDIENT;
    public static String confusion_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> CONFUSION_HEALTH_THRESHOLD;
    public static float confusion_health_threshold;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_PURIFICATION;
    public static boolean enable_purification;
    public static ForgeConfigSpec.ConfigValue<String> PURIFICATION_INGREDIENT;
    public static String purification_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PURIFICATION_BLACKLIST_EFFECTS;
    public static List<? extends String> purification_blacklist_effects;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CORRUPTION;
    public static boolean enable_corruption;
    public static ForgeConfigSpec.ConfigValue<String> CORRUPTION_INGREDIENT;
    public static String corruption_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> CORRUPTION_BLACKLIST_EFFECTS;
    public static List<? extends String> corruption_blacklist_effects;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SHUFFLING;
    public static boolean enable_shuffling;
    public static ForgeConfigSpec.ConfigValue<String> SHUFFLING_INGREDIENT;
    public static String shuffling_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_BURNING;
    public static boolean enable_burning;
    public static ForgeConfigSpec.ConfigValue<String> BURNING_INGREDIENT;
    public static String burning_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SHOCKED;
    public static boolean enable_shocked;
    public static ForgeConfigSpec.ConfigValue<String> SHOCKED_INGREDIENT;
    public static String shocked_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> SHOCKED_SPEED_DECREASE;
    public static float shocked_speed_decrease;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LIGHTNING;
    public static boolean enable_lightning;
    public static ForgeConfigSpec.ConfigValue<String> LIGHTNING_INGREDIENT;
    public static String lightning_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SPELUNKER;
    public static boolean enable_spelunker;
    public static ForgeConfigSpec.ConfigValue<String> SPELUNKER_INGREDIENT;
    public static String spelunker_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> SPELUNKER_ORE_LIST;
    public static List<? extends String> spelunker_ore_list;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_EXTENSION;
    public static boolean enable_extension;
    public static ForgeConfigSpec.ConfigValue<String> EXTENSION_INGREDIENT;
    public static String extension_ingredient;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> EXTENSION_BLACKLIST_EFFECTS;
    public static List<? extends String> extended_blacklist_effects;
    public static ForgeConfigSpec.ConfigValue<Integer> EXTENSION_CAP;
    public static int extension_cap;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_REVERSION;
    public static boolean enable_reversion;
    public static ForgeConfigSpec.ConfigValue<String> REVERSION_INGREDIENT;
    public static String reversion_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_HEALTH_BOOST;
    public static boolean enable_health_boost;
    public static ForgeConfigSpec.ConfigValue<String> HEALTH_BOOST_INGREDIENT;
    public static String health_boost_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LUCK;
    public static boolean enable_luck;
    public static ForgeConfigSpec.ConfigValue<String> LUCK_INGREDIENT;
    public static String luck_ingredient;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RESISTANCE;
    public static boolean enable_resistance;
    public static ForgeConfigSpec.ConfigValue<String> RESISTANCE_INGREDIENT;
    public static String resistance_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> RESISTANCE_DAMAGE_RESISTANCE;
    public static float resistance_damage_resistance;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_VULNERABLE;
    public static boolean enable_vulnerable;
    public static ForgeConfigSpec.ConfigValue<String> VULNERABLE_INGREDIENT;
    public static String vulnerable_ingredient;
    public static ForgeConfigSpec.ConfigValue<Double> VULNERABLE_DAMAGE_TAKEN;
    public static float vulnerable_damage_taken;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_WITHER;
    public static boolean enable_wither;
    public static ForgeConfigSpec.ConfigValue<String> WITHER_INGREDIENT;
    public static String wither_ingredient;

    public static ForgeConfigSpec.ConfigValue<Double> JUMP_BOOST_JUMP_HEIGHT;
    public static float jump_boost_jump_height;

    public static ForgeConfigSpec.ConfigValue<Double> HASTE_DIG_SPEED;
    public static float haste_dig_speed;

    // World Events
    public static ForgeConfigSpec.ConfigValue<Integer> WITCH_POTION_COUNT;
    public static int witch_potion_count;
    public static ForgeConfigSpec.ConfigValue<Integer> WITCH_POTION_COOLDOWN;
    public static int witch_potion_cooldown;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> POTION_SELECTOR;
    public static List<? extends String> potion_selector;

    public static ForgeConfigSpec.ConfigValue<Integer> POTION_STACK_SIZE;
    public static int potion_stack_size;
    public static ForgeConfigSpec.ConfigValue<Boolean> DISABLE_ICEANDFIRE_COMPAT;
    public static boolean disable_iceandfire_compat;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_POTION_SICKNESS;
    public static boolean enable_potion_sickness;
    public static ForgeConfigSpec.ConfigValue<Integer> POTION_SICKNESS_MAX_EFFECTS;
    public static int potion_sickness_max_effects;
    public static ForgeConfigSpec.ConfigValue<Double> POTION_SICKNESS_CHANCE;
    public static float potion_sickness_chance;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> POTION_SICKNESS_WHITELIST;
    public static List<? extends String> potion_sickness_whitelist;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> POTION_SICKNESS_BLACKLIST;
    public static List<? extends String> potion_sickness_blacklist;
    public static ForgeConfigSpec.ConfigValue<Boolean> POTION_SICKNESS_INSTANT_EFFECT;
    public static boolean potion_sickness_instant_effect;

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getFileName().equals(FILENAME)) {
            apothecary_enabled = APOTHECARY_ENABLED.get();
            potions_enabled = POTIONS_ENABLED.get();
            max_damage_resistance = MAX_DAMAGE_RESISTANCE.get().floatValue();
            enable_world_events = ENABLE_WORLD_EVENTS.get();
            enable_iron_skin = ENABLE_IRON_SKIN.get();
            iron_skin_ingredient = IRON_SKIN_INGREDIENT.get();
            iron_skin_armor_increase = IRON_SKIN_ARMOR_INCREASE.get();
            enable_broken_armor = ENABLE_BROKEN_ARMOR.get();
            broken_armor_ingredient = BROKEN_ARMOR_INGREDIENT.get();
            broken_armor_armor_decrease = BROKEN_ARMOR_ARMOR_DECREASE.get();
            enable_diamond_skin = ENABLE_DIAMOND_SKIN.get();
            diamond_skin_ingredient = DIAMOND_SKIN_INGREDIENT.get();
            diamond_skin_armor_increase = DIAMOND_SKIN_ARMOR_INCREASE.get();
            enable_magic_shield = ENABLE_MAGIC_SHIELD.get();
            magic_shield_ingredient = MAGIC_SHIELD_INGREDIENT.get();
            magic_shield_increase = MAGIC_SHIELD_INCREASE.get();
            enable_ruptured_armor = ENABLE_RUPTURED_ARMOR.get();
            ruptured_armor_ingredient = RUPTURED_ARMOR_INGREDIENT.get();
            ruptured_armor_armor_decrease = RUPTURED_ARMOR_ARMOR_DECREASE.get();
            enable_archery = ENABLE_ARCHERY.get();
            archery_ingredient = ARCHERY_INGREDIENT.get();
            archery_damage_increase = ARCHERY_DAMAGE_INCREASE.get();
            enable_quick_draw = ENABLE_QUICK_DRAW.get();
            quick_draw_ingredient = QUICK_DRAW_INGREDIENT.get();
            quick_draw_speed_increase = QUICK_DRAW_SPEED_INCREASE.get().floatValue();
            quick_draw_velocity_increase = QUICK_DRAW_VELOCITY_INCREASE.get().floatValue();
            enable_misfire = ENABLE_MISFIRE.get();
            misfire_ingredient = MISFIRE_INGREDIENT.get();
            misfire_damage_decrease = MISFIRE_DAMAGE_DECREASE.get();
            enable_lethargy = ENABLE_LETHARGY.get();
            lethargy_ingredient = LETHARGY_INGREDIENT.get();
            lethargy_speed_decrease = LETHARGY_SPEED_DECREASE.get().floatValue();
            lethargy_velocity_decrease = LETHARGY_VELOCITY_DECREASE.get().floatValue();
            enable_wrath = ENABLE_WRATH.get();
            wrath_ingredient = WRATH_INGREDIENT.get();
            wrath_damage_increase = WRATH_DAMAGE_INCREASE.get().floatValue();
            enable_frail = ENABLE_FRAIL.get();
            frail_ingredient = FRAIL_INGREDIENT.get();
            frail_damage_decrease = FRAIL_DAMAGE_DECREASE.get().floatValue();
            enable_flight = ENABLE_FLIGHT.get();
            flight_ingredient = FLIGHT_INGREDIENT.get();
            enable_reach = ENABLE_REACH.get();
            reach_ingredient = REACH_INGREDIENT.get();
            reach_increase = REACH_INCREASE.get();
            enable_repairing = ENABLE_REPAIRING.get();
            repairing_ingredient = REPAIRING_INGREDIENT.get();
            repairing_amount = REPAIRING_AMOUNT.get();
            enable_corrosion = ENABLE_CORROSION.get();
            corrosion_ingredient = CORROSION_INGREDIENT.get();
            enable_magic_power = ENABLE_MAGIC_POWER.get();
            magic_power_ingredient = MAGIC_POWER_INGREDIENT.get();
            magic_power_increase = MAGIC_POWER_INCREASE.get().floatValue();
            enable_magic_drain = ENABLE_MAGIC_DRAIN.get();
            magic_drain_ingredient = MAGIC_DRAIN_INGREDIENT.get();
            magic_drain_decrease = MAGIC_DRAIN_DECREASE.get().floatValue();
            enable_mana_regeneration = ENABLE_MANA_REGENERATION.get();
            mana_regeneration_ingredient = MANA_REGENERATION_INGREDIENT.get();
            mana_regeneration_increase = MANA_REGENERATION_INCREASE.get().floatValue();
            enable_mana_exhaustion = ENABLE_MANA_EXHAUSTION.get();
            mana_exhaustion_ingredient = MANA_EXHAUSTION_INGREDIENT.get();
            mana_exhaustion_decrease = MANA_EXHAUSTION_DECREASE.get().floatValue();
            corrosion_amount = CORROSION_AMOUNT.get();
            enable_thorns = ENABLE_THORNS.get();
            thorns_ingredient = THORNS_INGREDIENT.get();
            thorns_damage_reflect = THORNS_DAMAGE_REFLECT.get().floatValue();
            enable_confusion = ENABLE_CONFUSION.get();
            confusion_ingredient = CONFUSION_INGREDIENT.get();
            confusion_health_threshold = CONFUSION_HEALTH_THRESHOLD.get().floatValue();
            enable_purification = ENABLE_PURIFICATION.get();
            purification_ingredient = PURIFICATION_INGREDIENT.get();
            purification_blacklist_effects = PURIFICATION_BLACKLIST_EFFECTS.get();
            enable_corruption = ENABLE_CORRUPTION.get();
            corruption_ingredient = CORRUPTION_INGREDIENT.get();
            corruption_blacklist_effects = CORRUPTION_BLACKLIST_EFFECTS.get();
            enable_shuffling = ENABLE_SHUFFLING.get();
            shuffling_ingredient = SHUFFLING_INGREDIENT.get();
            enable_burning = ENABLE_BURNING.get();
            burning_ingredient = BURNING_INGREDIENT.get();
            enable_shocked = ENABLE_SHOCKED.get();
            shocked_ingredient = SHOCKED_INGREDIENT.get();
            shocked_speed_decrease = SHOCKED_SPEED_DECREASE.get().floatValue();
            enable_lightning = ENABLE_LIGHTNING.get();
            lightning_ingredient = LIGHTNING_INGREDIENT.get();
            enable_spelunker = ENABLE_SPELUNKER.get();
            spelunker_ingredient = SPELUNKER_INGREDIENT.get();
            spelunker_ore_list = SPELUNKER_ORE_LIST.get();
            enable_extension = ENABLE_EXTENSION.get();
            extension_ingredient = EXTENSION_INGREDIENT.get();
            extension_cap = EXTENSION_CAP.get();
            enable_reversion = ENABLE_REVERSION.get();
            extended_blacklist_effects = EXTENSION_BLACKLIST_EFFECTS.get();
            reversion_ingredient = REVERSION_INGREDIENT.get();
            enable_health_boost = ENABLE_HEALTH_BOOST.get();
            health_boost_ingredient = HEALTH_BOOST_INGREDIENT.get();
            enable_luck = ENABLE_LUCK.get();
            luck_ingredient = LUCK_INGREDIENT.get();
            enable_resistance = ENABLE_RESISTANCE.get();
            resistance_ingredient = RESISTANCE_INGREDIENT.get();
            resistance_damage_resistance = RESISTANCE_DAMAGE_RESISTANCE.get().floatValue();
            enable_vulnerable = ENABLE_VULNERABLE.get();
            vulnerable_ingredient = VULNERABLE_INGREDIENT.get();
            vulnerable_damage_taken = VULNERABLE_DAMAGE_TAKEN.get().floatValue();
            enable_wither = ENABLE_WITHER.get();
            wither_ingredient = WITHER_INGREDIENT.get();
            jump_boost_jump_height = JUMP_BOOST_JUMP_HEIGHT.get().floatValue();
            haste_dig_speed = HASTE_DIG_SPEED.get().floatValue();
            witch_potion_count = WITCH_POTION_COUNT.get();
            witch_potion_cooldown = WITCH_POTION_COOLDOWN.get();
            potion_selector = POTION_SELECTOR.get();
            enable_potion_sickness = ENABLE_POTION_SICKNESS.get();
            potion_sickness_max_effects = POTION_SICKNESS_MAX_EFFECTS.get();
            potion_sickness_chance = POTION_SICKNESS_CHANCE.get().floatValue();
            potion_sickness_whitelist = POTION_SICKNESS_WHITELIST.get();
            potion_sickness_blacklist = POTION_SICKNESS_BLACKLIST.get();
            potion_sickness_instant_effect = POTION_SICKNESS_INSTANT_EFFECT.get();

            disable_iceandfire_compat = DISABLE_ICEANDFIRE_COMPAT.get();
        }
    }

    @SubscribeEvent
    static void afterLoad(final ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getFileName().equals(FILENAME)) {
            potion_stack_size = POTION_STACK_SIZE.get();
        }
    }

    static {
        BUILDER.push("General");
        APOTHECARY_ENABLED = BUILDER.comment("Global toggle to disable this entire mod, client config, stack size, and attributes will still work if this is disabled").define("Apothecary_Enabled", true);
        POTIONS_ENABLED = BUILDER.comment("Global toggle to disable all potions from this mod").define("Potions_Enabled", true);
        ENABLE_WORLD_EVENTS = BUILDER.comment("Enable world events (effects being able to occur in the world outside of potions)").define("World_Events", true);
        POTION_STACK_SIZE = BUILDER.comment("Max stack size of potions").defineInRange("Stack_Size", 1, 1, 64);
        MAX_DAMAGE_RESISTANCE = BUILDER.comment("Max amount of damage resistance the player can get").defineInRange("Max_Damage_Resistance", 1, 0.0, 1);
        DISABLE_ICEANDFIRE_COMPAT = BUILDER.comment("Disable ice and fire compat").define("Disable", false);
        BUILDER.pop();

        //
        BUILDER.push("Potions");
        //

        BUILDER.push("Iron_Skin");
        ENABLE_IRON_SKIN = BUILDER.comment("Enable Iron Skin").define("Enable", true);
        IRON_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew iron skin potions").define("Ingredient", "minecraft:iron_block");
        IRON_SKIN_ARMOR_INCREASE = BUILDER.comment("Armor points provided by iron skin potions").define("Armor_Increase", 4);
        BUILDER.pop();

        BUILDER.push("Broken_Armor");
        ENABLE_BROKEN_ARMOR = BUILDER.comment("Enable  Broken Armor").define("Enable", true);
        BROKEN_ARMOR_INGREDIENT = BUILDER.comment("Main ingredient used to brew broken armor potions").define("Ingredient", "minecraft:fermented_spider_eye");
        BROKEN_ARMOR_ARMOR_DECREASE = BUILDER.comment("Armor points decreased by broken armor potions").define("Armor_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Diamond_Skin");
        ENABLE_DIAMOND_SKIN = BUILDER.comment("Enable Diamond Skin").define("Enable", true);
        DIAMOND_SKIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew diamond skin potions").define("Ingredient", "minecraft:diamond_block");
        DIAMOND_SKIN_ARMOR_INCREASE = BUILDER.comment("Armor toughness points provided by diamond skin potions").define("Armor_Toughness_Increase", 4);
        BUILDER.pop();

        BUILDER.push("Magic_Shield");
        ENABLE_MAGIC_SHIELD = BUILDER.comment("Enable Magic Shield").define("Enable", true);
        MAGIC_SHIELD_INGREDIENT = BUILDER.comment("Main ingredient used to brew magic shield potions").define("Ingredient", "minecraft:lapis_block");
        MAGIC_SHIELD_INCREASE = BUILDER.comment("Magic shielding points provided by magic shield potions").define("Magic_Shielding_Increase", 2);
        BUILDER.pop();

        BUILDER.push("Ruptured_Armor");
        ENABLE_RUPTURED_ARMOR = BUILDER.comment("Enable Ruptured Armor").define("Enable", true);
        RUPTURED_ARMOR_INGREDIENT = BUILDER.comment("Main ingredient used to brew ruptured armor potions").define("Ingredient", "minecraft:fermented_spider_eye");
        RUPTURED_ARMOR_ARMOR_DECREASE = BUILDER.comment("Armor toughness points decreased by ruptured armor potions").define("Armor_Toughness_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Archery");
        ENABLE_ARCHERY = BUILDER.comment("Enable Archery").define("Enable", true);
        ARCHERY_INGREDIENT = BUILDER.comment("Main ingredient used to brew archery potions").define("Ingredient", "minecraft:skeleton_skull");
        ARCHERY_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by archery potions").define("Damage_Increase", 3);
        BUILDER.pop();

        BUILDER.push("Misfire");
        ENABLE_MISFIRE = BUILDER.comment("Enable Misfire").define("Enable", true);
        MISFIRE_INGREDIENT = BUILDER.comment("Main ingredient used to brew misfire potions").define("Ingredient", "minecraft:fermented_spider_eye");
        MISFIRE_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by misfire potions").define("Damage_Decrease", 4);
        BUILDER.pop();

        BUILDER.push("Quick_Draw");
        ENABLE_QUICK_DRAW = BUILDER.comment("Enable Quick Draw").define("Enable", true);
        QUICK_DRAW_INGREDIENT = BUILDER.comment("Main ingredient used to brew quick draw potions").define("Ingredient", "minecraft:wither_skeleton_skull");
        QUICK_DRAW_SPEED_INCREASE = BUILDER.comment("Draw speed increase provided by quick draw potions").define("Draw_Speed_Increase", 0.1);
        QUICK_DRAW_VELOCITY_INCREASE = BUILDER.comment("Projectile velocity increase provided by quick draw potions").define("Projectile_Velocity_Increase", 0.05);
        BUILDER.pop();

        BUILDER.push("Lethargy");
        ENABLE_LETHARGY = BUILDER.comment("Enable Lethargy").define("Enable", true);
        LETHARGY_INGREDIENT = BUILDER.comment("Main ingredient used to brew lethargy potions").define("Ingredient", "minecraft:fermented_spider_eye");
        LETHARGY_SPEED_DECREASE = BUILDER.comment("Draw speed increase provided by lethargy potions").define("Draw_Speed_Decrease", 0.1);
        LETHARGY_VELOCITY_DECREASE = BUILDER.comment("Projectile velocity increase provided by lethargy potions").define("Projectile_Velocity_Decrease", 0.05);
        BUILDER.pop();

        BUILDER.push("Wrath");
        ENABLE_WRATH = BUILDER.comment("Enable Wrath").define("Enable", true);
        WRATH_INGREDIENT = BUILDER.comment("Main ingredient used to brew wrath potions").define("Ingredient", "minecraft:crimson_fungus");
        WRATH_DAMAGE_INCREASE = BUILDER.comment("Damage increase provided by wrath potions in percentage").define("Damage_Increase", 0.10);
        BUILDER.pop();

        BUILDER.push("Frail");
        ENABLE_FRAIL = BUILDER.comment("Enable Frail").define("Enable", true);
        FRAIL_INGREDIENT = BUILDER.comment("Main ingredient used to brew frail potions").define("Ingredient", "minecraft:fermented_spider_eye");
        FRAIL_DAMAGE_DECREASE = BUILDER.comment("Damage decrease provided by frail potions in percentage").define("Damage_Decrease", 0.10);
        BUILDER.pop();

        BUILDER.push("Vulnerable");
        ENABLE_VULNERABLE = BUILDER.comment("Enable Vulnerable").define("Enable", true);
        VULNERABLE_INGREDIENT = BUILDER.comment("Main ingredient used to brew vulnerable potions").define("Ingredient", "minecraft:fermented_spider_eye");
        VULNERABLE_DAMAGE_TAKEN = BUILDER.comment("Decreased damage resistance provided by vulnerable potions in percentage").define("Damage_Resistance", 0.20);
        BUILDER.pop();

        BUILDER.push("Flight");
        ENABLE_FLIGHT = BUILDER.comment("Enable Flight").define("Enable", true);
        FLIGHT_INGREDIENT = BUILDER.comment("Main ingredient used to brew flight potions").define("Ingredient", "minecraft:dragon_head");
        BUILDER.pop();

        BUILDER.push("Reach");
        ENABLE_REACH = BUILDER.comment("Enable Reach").define("Enable", true);
        REACH_INGREDIENT = BUILDER.comment("Main ingredient used to brew reach potions").define("Ingredient", "minecraft:end_rod");
        REACH_INCREASE = BUILDER.comment("Reach distance increased by reach potions").define("Reach_Increase", 1);
        BUILDER.pop();

        BUILDER.push("Repairing");
        ENABLE_REPAIRING = BUILDER.comment("Enable Repairing").define("Enable", true);
        REPAIRING_INGREDIENT = BUILDER.comment("Main ingredient used to brew repairing potions").define("Ingredient", "minecraft:anvil");
        REPAIRING_AMOUNT = BUILDER.comment("Repair amount provided by repairing potions").define("Repair_Amount", 1);
        BUILDER.pop();

        BUILDER.push("Corrosion");
        ENABLE_CORROSION = BUILDER.comment("Enable Corrosion").define("Enable", true);
        CORROSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew corrosion potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORROSION_AMOUNT = BUILDER.comment("Corrosion amount provided by corrosion potions").define("Corrosion_Amount", 1);
        BUILDER.pop();

        BUILDER.push("Magic_Power");
        ENABLE_MAGIC_POWER = BUILDER.comment("Enable Magic Power").define("Enable", true);
        MAGIC_POWER_INGREDIENT = BUILDER.comment("Main ingredient used to brew magic power potions").define("Ingredient", "minecraft:lapis_lazuli");
        MAGIC_POWER_INCREASE = BUILDER.comment("Damage increase provided by magic power potions in percentage").define("Magic_Power_Increase", 0.1);
        BUILDER.pop();

        BUILDER.push("Magic_Drain");
        ENABLE_MAGIC_DRAIN = BUILDER.comment("Enable Magic Drain").define("Enable", true);
        MAGIC_DRAIN_INGREDIENT = BUILDER.comment("Main ingredient used to brew magic drain potions").define("Ingredient", "minecraft:fermented_spider_eye");
        MAGIC_DRAIN_DECREASE = BUILDER.comment("Damage decrease provided by magic drain potions in percentage").define("Magic_Drain_Increase", 0.1);
        BUILDER.pop();

        BUILDER.push("Mana_Regeneration");
        ENABLE_MANA_REGENERATION = BUILDER.comment("Enable Mana Regeneration").define("Enable", true);
        MANA_REGENERATION_INGREDIENT = BUILDER.comment("Main ingredient used to brew mana regeneration potions").define("Ingredient", "irons_spellbooks:arcane_essence");
        MANA_REGENERATION_INCREASE = BUILDER.comment("Mana regeneration increase provided by mana regeneration potions in percentage").define("Mana_Regeneration_Increase", 0.20);
        BUILDER.pop();

        BUILDER.push("Mana_Exhaustion");
        ENABLE_MANA_EXHAUSTION = BUILDER.comment("Enable Mana Exhaustion").define("Enable", true);
        MANA_EXHAUSTION_INGREDIENT = BUILDER.comment("Main ingredient used to brew mana exhaustion potions").define("Ingredient", "irons_spellbooks:arcane_essence");
        MANA_EXHAUSTION_DECREASE = BUILDER.comment("Mana regeneration decrease provided by mana exhaustion potions in percentage").define("Mana_Regeneration_Decrease", 0.20);
        BUILDER.pop();

        BUILDER.push("Thorns");
        ENABLE_THORNS = BUILDER.comment("Enable Thorns").define("Enable", true);
        THORNS_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:cactus");
        THORNS_DAMAGE_REFLECT = BUILDER.comment("Damage reflected by thorns potions in percentage").define("Damage_Reflected", 0.20);
        BUILDER.pop();

        BUILDER.push("Confusion");
        ENABLE_CONFUSION = BUILDER.comment("Enable Confusion").define("Enable", true);
        CONFUSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew thorns potions").define("Ingredient", "minecraft:sniffer_egg");
        CONFUSION_HEALTH_THRESHOLD = BUILDER.comment("Max health a mob can have to be able to get confused, any value under this allows confusion").define("Confusion_Health_Threshold", 50.0);
        BUILDER.pop();

        BUILDER.push("Purification");
        ENABLE_PURIFICATION = BUILDER.comment("Enable Purification").define("Enable", true);
        PURIFICATION_INGREDIENT = BUILDER.comment("Main ingredient used to brew purification potions").define("Ingredient", "minecraft:heart_of_the_sea");
        PURIFICATION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the purification effect (e.g., minecraft:poison, minecraft:slowness etc)").defineList("Purification_Blacklist_Effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Corruption");
        ENABLE_CORRUPTION = BUILDER.comment("Enable Corruption").define("Enable", true);
        CORRUPTION_INGREDIENT = BUILDER.comment("Main ingredient used to brew corruption potions").define("Ingredient", "minecraft:fermented_spider_eye");
        CORRUPTION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being immune to from the corruption effect (e.g., minecraft:strength, minecraft:speed etc)").defineList("Corruption_Blacklist_Effects", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Shuffling");
        ENABLE_SHUFFLING = BUILDER.comment("Enable Shuffling").define("Enable", true);
        SHUFFLING_INGREDIENT = BUILDER.comment("Main ingredient used to brew shuffling potions").define("Ingredient", "minecraft:trapped_chest");
        BUILDER.pop();

        BUILDER.push("Burning");
        ENABLE_BURNING = BUILDER.comment("Enable Burning").define("Enable", true);
        BURNING_INGREDIENT = BUILDER.comment("Main ingredient used to brew burning potions").define("Ingredient", "minecraft:magma_block");
        BUILDER.pop();

        BUILDER.push("Shocked");
        ENABLE_SHOCKED = BUILDER.comment("Enable Shocked").define("Enable", true);
        SHOCKED_INGREDIENT = BUILDER.comment("Main ingredient used to brew shocked potions").define("Ingredient", "minecraft:copper_block");
        SHOCKED_SPEED_DECREASE = BUILDER.comment("Amount of movement speed reduction for the shocked effect").define("Shocked_Speed_Decrease", 0.5);
        BUILDER.pop();

        BUILDER.push("Lightning");
        ENABLE_LIGHTNING = BUILDER.comment("Enable Lightning").define("Enable", true);
        LIGHTNING_INGREDIENT = BUILDER.comment("Main ingredient used to brew lightning potions").define("Ingredient", "minecraft:lightning_rod");
        BUILDER.pop();

        BUILDER.push("Spelunker");
        ENABLE_SPELUNKER = BUILDER.comment("Enable Spelunker").define("Enable", true);
        SPELUNKER_INGREDIENT = BUILDER.comment("Main ingredient used to brew spelunker potions").define("Ingredient", "minecraft:raw_gold_block");
        SPELUNKER_ORE_LIST = BUILDER.comment("List of ores that the spelunker effect can detect (e.g., minecraft:iron_ore, minecraft:gold_ore etc)").defineList("Spelunker_Ore_List", List.of(), s -> s instanceof String);
        BUILDER.pop();

        BUILDER.push("Extension");
        ENABLE_EXTENSION = BUILDER.comment("Enable Extension").define("Enable", true);
        EXTENSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew extension potions").define("Ingredient", "minecraft:amethyst_cluster");
        EXTENSION_BLACKLIST_EFFECTS = BUILDER.comment("List of effects to blacklist being extended from the extension effect (e.g., minecraft:jump_boost, minecraft:water_breathing etc)").defineList("Extension_Blacklist_Effects", List.of(), s -> s instanceof String);
        EXTENSION_CAP = BUILDER.comment("Max duration cap for the extension effect to increase in seconds").define("Extension_Cap", 600);
        BUILDER.pop();

        BUILDER.push("Reversion");
        ENABLE_REVERSION = BUILDER.comment("Enable Reversion").define("Enable", true);
        REVERSION_INGREDIENT = BUILDER.comment("Main ingredient used to brew reversion potions").define("Ingredient", "minecraft:fermented_spider_eye");
        BUILDER.pop();

        BUILDER.push("Health_Boost");
        ENABLE_HEALTH_BOOST = BUILDER.comment("Enable the Health Boost potion recipe").define("Enable", true);
        HEALTH_BOOST_INGREDIENT = BUILDER.comment("Main ingredient used to brew health boost potions").define("Ingredient", "minecraft:golden_apple");
        BUILDER.pop();

        BUILDER.push("Luck");
        ENABLE_LUCK = BUILDER.comment("Enable the Luck potion recipe").define("Enable", true);
        LUCK_INGREDIENT = BUILDER.comment("Main ingredient used to brew luck potions").define("Ingredient", "minecraft:emerald_block");
        BUILDER.pop();

        BUILDER.push("Resistance");
        ENABLE_RESISTANCE = BUILDER.comment("Enable the Resistance potion recipe").define("Enable", true);
        RESISTANCE_INGREDIENT = BUILDER.comment("Main ingredient used to brew resistance potions").define("Ingredient", "minecraft:warped_fungus");
        RESISTANCE_DAMAGE_RESISTANCE = BUILDER.comment("Increased damage resistance provided by resistance potions in percentage").define("Damage_Resistance", 0.20);
        BUILDER.pop();

        BUILDER.push("Jump_Boost");
        JUMP_BOOST_JUMP_HEIGHT = BUILDER.comment("Increased jump height in blocks").define("Jump_Height", 0.5);
        BUILDER.pop();

        BUILDER.push("Haste");
        HASTE_DIG_SPEED = BUILDER.comment("Increased digging speed in percentage").define("Dig_Speed", 0.2);
        BUILDER.pop();

        BUILDER.push("Wither");
        ENABLE_WITHER = BUILDER.comment("Enable Wither").define("Enable", true);
        WITHER_INGREDIENT = BUILDER.comment("Main ingredient used to brew wither potions").define("Ingredient", "minecraft:wither_rose");
        BUILDER.pop();

        //
        BUILDER.pop();
        //

        BUILDER.push("World_Events");
        WITCH_POTION_COUNT = BUILDER.comment("Amount of apothecary potions witches can throw before they default back to vanilla potions.").define("Witch_Potion_Count", 1);
        WITCH_POTION_COOLDOWN = BUILDER.comment("Cooldown for witches to be able to throw apothecary potions again after the potion count has been reached in seconds").define("Witch_Potion_Cooldown", 5);
        POTION_SELECTOR = BUILDER.comment("A list of potions witches can throw with formatting as 'modid:potion_id,weight'.", "Lower weights means rarer potions while higher weights means more common potions, supports modded potions").defineListAllowEmpty("configurable_potions", List.of(
                "apothecary:vulnerable, 10",
                "apothecary:burning, 10",
                "apothecary:lightning, 10",
                "apothecary:wither, 10",
                "apothecary:corruption, 10",
                "apothecary:corrosion, 10",
                "apothecary:confusion, 10",
                "apothecary:feeble, 15",
                "apothecary:shuffling, 5"
        ), o -> o instanceof String && ((String) o).contains(","));

        BUILDER.push("Potion_Sickness");
        ENABLE_POTION_SICKNESS = BUILDER.comment("Enable the potion sickness effect, adding a max limit of how many positive effects players can have").define("Enable_Potion_Sickness", true);
        POTION_SICKNESS_MAX_EFFECTS = BUILDER.comment("Max effects a player can have before they can get potion sickness, any number after this value will cause potion sickness").define("Max_Effects", 10);
        POTION_SICKNESS_CHANCE = BUILDER.comment("Chance that potion sickness will cause chaos every second (in percentage)").define("Potion_Sickness_Chance", 0.01);
        POTION_SICKNESS_WHITELIST = BUILDER.comment("A list of harmful effects potion sickness can apply, overwrites the random harmful effects, format as: 'modid:potion_id'.").defineListAllowEmpty("Effect_Whitelist", List.of(), o -> o instanceof String);
        POTION_SICKNESS_BLACKLIST = BUILDER.comment("A list of harmful effects potion sickness cannot apply, format as: 'modid:potion_id'.").defineListAllowEmpty("Effect_Blacklist", List.of("minecraft:levitation", "apothecary:shuffling", "apothecary:reversion", "apothecary:corruption"), o -> o instanceof String);
        POTION_SICKNESS_INSTANT_EFFECT = BUILDER.comment("Enable potion sickness instantly applying one random negative effect when first applied").define("Instant_Effect", false);
        BUILDER.pop();

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
