package net.gobies.apothecary;

import com.mojang.logging.LogUtils;
import net.gobies.apothecary.client.overlay.ArmorOverlay;
import net.gobies.apothecary.compat.FluidEffectEvents;
import net.gobies.apothecary.compat.iceandfire.IceandFireCompat;
import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbooksCompat;
import net.gobies.apothecary.compat.jlme.NaturalBlockingHandler;
import net.gobies.apothecary.compat.moreartifacts.MoreArtifactsCompat;
import net.gobies.apothecary.compat.spartanweaponry.SpartanWeaponryCompat;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.event.AttributeEvents;
import net.gobies.apothecary.event.EffectEvents;
import net.gobies.apothecary.event.WorldEvents;
import net.gobies.apothecary.helper.AttributeHelper;
import net.gobies.apothecary.init.AAttributes;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.init.APotions;
import net.gobies.apothecary.recipe.ABrewing;
import net.gobies.apothecary.util.StackSizeSetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Apothecary.MOD_ID)
public class Apothecary {

    public static final String MOD_ID = "apothecary";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Apothecary() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        APotions.register(modBus);
        AAttributes.register(modBus);
        EffectEvents.register();
        WorldEvents.register();
        AttributeEvents.register();
        MinecraftForge.EVENT_BUS.register(EffectEvents.class);
        AEffects.register(modBus);
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::registerGuiOverlays);
        modBus.addListener(AttributeHelper::attachAttributes);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ABrewing::register);
        event.enqueueWork(StackSizeSetter::setStackSize);

        if (ModList.get().isLoaded("irons_spellbooks")) {
            IronsSpellbooksCompat.loadCompat();
            LOGGER.info("[Apothecary] Iron's Spellbooks Compat Loaded");
        }
        if (ModList.get().isLoaded("spartanweaponry")) {
            SpartanWeaponryCompat.loadCompat();
            LOGGER.info("[Apothecary] Spartan Weaponry Compat Loaded");
        }
        if (ModList.get().isLoaded("alexscaves") || ModList.get().isLoaded("biomesoplenty")) {
            FluidEffectEvents.loadCompat();
            LOGGER.info("[Apothecary] Modded Fluid Effects Compat Loaded");
        }
        if (ModList.get().isLoaded("iceandfire")) {
            IceandFireCompat.loadCompat();
            LOGGER.info("[Apothecary] Ice and Fire Compat Loaded");
        }
        if (ModList.get().isLoaded("jlme")) {
            NaturalBlockingHandler.loadCompat();
            LOGGER.info("[Apothecary] JLME Compat Loaded");
        }
        if (ModList.get().isLoaded("moreartifacts")) {
            MoreArtifactsCompat.loadCompat();
            LOGGER.info("[Apothecary] More Artifacts Compat Loaded");
        }
    }

     private void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.ARMOR_LEVEL.id(), "armor_overlay", ArmorOverlay.ARMOR_HUD);
        event.registerAbove(new ResourceLocation(Apothecary.MOD_ID, "armor_overlay"), "armor_toughness_overlay", ArmorOverlay.ARMOR_TOUGHNESS_HUD);
        event.registerBelow(VanillaGuiOverlay.ARMOR_LEVEL.id(), "resistance_overlay", ArmorOverlay.RESISTANCE_HUD);
    }
}
