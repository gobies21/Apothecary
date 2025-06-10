package net.gobies.apothecary;

import com.mojang.logging.LogUtils;
import net.gobies.apothecary.compat.ironsspellbooks.IronsSpellbookEvents;
import net.gobies.apothecary.compat.spartanweaponry.CrossbowArchery;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.init.APotions;
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

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ABrewing::register);

        if (ModList.get().isLoaded("irons_spellbooks") && (Config.ENABLE_WORLD_EVENTS.get())) {
            IronsSpellbookEvents.loadCompat();
            LOGGER.info("[Apothecary] Iron's Spellbooks Compat Loaded");
        }
        if (ModList.get().isLoaded("spartanweaponry")) {
            CrossbowArchery.loadCompat();
            LOGGER.info("[Apothecary] Spartan Weaponry Compat Loaded");
        }
    }
}
