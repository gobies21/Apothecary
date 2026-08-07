package net.gobies.apothecary;

import com.mojang.logging.LogUtils;
import net.gobies.apothecary.client.overlay.ArmorOverlay;
import net.gobies.apothecary.compat.FluidEffectEvents;
import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbooksCompat;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.event.AttributeEvents;
import net.gobies.apothecary.event.EffectEvents;
import net.gobies.apothecary.event.WorldEvents;
import net.gobies.apothecary.helper.AttributeHelper;
import net.gobies.apothecary.init.AAttributes;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.init.APotions;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import org.slf4j.Logger;

@Mod(Apothecary.MOD_ID)
public class Apothecary {

    public static final String MOD_ID = "apothecary";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Apothecary(IEventBus modBus, ModContainer container) {
        APotions.register(modBus);
        AAttributes.register(modBus);
        EffectEvents.register();
        WorldEvents.register();
        AttributeEvents.register();
        AEffects.register(modBus);
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::registerGuiOverlays);
        modBus.addListener(AttributeHelper::attachAttributes);
        container.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        if (ModList.get().isLoaded("irons_spellbooks")) {
            IronsSpellbooksCompat.loadCompat();
            LOGGER.info("[Apothecary] Iron's Spellbooks Compat Loaded");
        }
        if (ModList.get().isLoaded("spartanweaponry")) {
            //SpartanWeaponryCompat.loadCompat();
            LOGGER.info("[Apothecary] Spartan Weaponry Compat Loaded");
        }
        if (ModList.get().isLoaded("alexscaves") || ModList.get().isLoaded("biomesoplenty")) {
            FluidEffectEvents.loadCompat();
            LOGGER.info("[Apothecary] Modded Fluid Effects Compat Loaded");
        }
        if (ModList.get().isLoaded("iceandfire")) {
            //IceandFireCompat.loadCompat();
            LOGGER.info("[Apothecary] Ice and Fire Compat Loaded");
        }
        if (ModList.get().isLoaded("jlme")) {
            //NaturalBlockingHandler.loadCompat();
            LOGGER.info("[Apothecary] JLME Compat Loaded");
        }
        if (ModList.get().isLoaded("moreartifacts")) {
            //MoreArtifactsCompat.loadCompat();
            LOGGER.info("[Apothecary] More Artifacts Compat Loaded");
        }
    }

     private void registerGuiOverlays(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.ARMOR_LEVEL, ResourceLocation.fromNamespaceAndPath(Apothecary.MOD_ID, "armor_overlay"), ArmorOverlay.ARMOR_HUD);
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, ResourceLocation.fromNamespaceAndPath(Apothecary.MOD_ID, "armor_toughness_overlay"), ArmorOverlay.ARMOR_TOUGHNESS_HUD);
        event.registerBelow(VanillaGuiLayers.ARMOR_LEVEL, ResourceLocation.fromNamespaceAndPath("apothecary", "resistance_overlay"), ArmorOverlay.RESISTANCE_HUD);
    }
}
