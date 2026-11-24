package net.gobies.apothecary.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_ENCHANTED_GLOW;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_POTION_DESCRIPTIONS;
    public static ModConfigSpec.ConfigValue<Boolean> ADDITIONAL_POTION_TOOLTIPS;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_OVERLAYS;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_ARMOR_OVERLAY;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_ARMOR_TOUGHNESS_OVERLAY;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_RESISTANCE_OVERLAY;
    public static ModConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC_SHIELDING_OVERLAY;

    static {
        BUILDER.push("General");
        ENABLE_ENCHANTED_GLOW = BUILDER.comment("Enable potions having enchanted glow").define("Glow", false);
        ENABLE_POTION_DESCRIPTIONS = BUILDER.comment("Enable potion descriptions as tooltips").define("Descriptions", false);
        ADDITIONAL_POTION_TOOLTIPS = BUILDER.comment("Shows information about what the potions do in their tooltips").define("Additional_Tooltips", true);
        BUILDER.pop();

        BUILDER.push("Overlays");
        ENABLE_OVERLAYS = BUILDER.comment("Global toggle for all overlays").define("Enable_Overlays", true);
        ENABLE_ARMOR_OVERLAY = BUILDER.comment("Enable armor overlay, displays armor over 20 and 40").define("Armor_Overlay", true);
        ENABLE_ARMOR_TOUGHNESS_OVERLAY = BUILDER.comment("Enable armor toughness overlay, displays armor toughness").define("Armor_Toughness_Overlay", true);
        ENABLE_RESISTANCE_OVERLAY = BUILDER.comment("Enable resistance overlay, displays resistance around armor icons").define("Resistance_Overlay", true);
        ENABLE_MAGIC_SHIELDING_OVERLAY = BUILDER.comment("Enable magic shielding overlay, displays magic shielding").define("Magic_Shielding_Overlay", true);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}