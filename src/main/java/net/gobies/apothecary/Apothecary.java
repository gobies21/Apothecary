package net.gobies.apothecary;

import com.mojang.logging.LogUtils;
import net.gobies.apothecary.compat.FluidEffectEvents;
import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbookEvents;
import net.gobies.apothecary.compat.spartanweaponry.SpartanWeaponryCompat;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.init.APotions;
import net.gobies.apothecary.network.NetworkHandler;
import net.gobies.apothecary.recipe.ABrewing;
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

        AEffects.register(modBus);

        modBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ABrewing::register);
        NetworkHandler.registerPackets();

        if (ModList.get().isLoaded("irons_spellbooks")) {
            IronsSpellbookEvents.loadCompat();
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
    }
}
