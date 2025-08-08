package net.gobies.apothecary.config;

import net.gobies.apothecary.Apothecary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientConfig {
    private static final String FILENAME = "apothecary-client.toml";

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ENCHANTED_GLOW;
    public static boolean enable_enchanted_glow;
    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_POTION_DESCRIPTIONS;
    public static boolean enable_potion_descriptions;

    @SubscribeEvent
    static void onLoad(ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getFileName().equals(FILENAME)) {
            enable_enchanted_glow = ENABLE_ENCHANTED_GLOW.get();
            enable_potion_descriptions = ENABLE_POTION_DESCRIPTIONS.get();
        }
    }

    static {
        BUILDER.push("General");
        ENABLE_ENCHANTED_GLOW = BUILDER.comment("Enable potions having enchanted glow").define("Glow", false);
        ENABLE_POTION_DESCRIPTIONS = BUILDER.comment("Enable potion descriptions as tooltips").define("Descriptions", false);
        BUILDER.pop();

        SPEC = BUILDER.build();

    }
}