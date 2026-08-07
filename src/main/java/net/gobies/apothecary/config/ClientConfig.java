package net.gobies.apothecary.config;

import net.gobies.apothecary.Apothecary;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Apothecary.MOD_ID)
public class ClientConfig {
    private static final String FILENAME = "apothecary-client.toml";

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_ENCHANTED_GLOW;
    public static boolean enable_enchanted_glow;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_POTION_DESCRIPTIONS;
    public static boolean enable_potion_descriptions;
    public static ModConfigSpec.ConfigValue<Boolean> ADDITIONAL_POTION_TOOLTIPS;
    public static boolean additional_potion_tooltips;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_ARMOR_OVERLAYS;
    public static boolean enable_armor_overlays;

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getFileName().equals(FILENAME)) {
            enable_enchanted_glow = ENABLE_ENCHANTED_GLOW.get();
            enable_potion_descriptions = ENABLE_POTION_DESCRIPTIONS.get();
            additional_potion_tooltips = ADDITIONAL_POTION_TOOLTIPS.get();
            enable_armor_overlays = ENABLE_ARMOR_OVERLAYS.get();
        }
    }

    static {
        BUILDER.push("General");
        ENABLE_ENCHANTED_GLOW = BUILDER.comment("Enable potions having enchanted glow").define("Glow", false);
        ENABLE_POTION_DESCRIPTIONS = BUILDER.comment("Enable potion descriptions as tooltips").define("Descriptions", false);
        ADDITIONAL_POTION_TOOLTIPS = BUILDER.comment("Shows information about what the potions do in their tooltips").define("Additional_Tooltips", true);
        ENABLE_ARMOR_OVERLAYS = BUILDER.comment("Enable armor overlays to show over-capped armor, armor toughness and damage resistance on the armor bar").define("Armor_Overlays", true);
        BUILDER.pop();

        SPEC = BUILDER.build();

    }
}