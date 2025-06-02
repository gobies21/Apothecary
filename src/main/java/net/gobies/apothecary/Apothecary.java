package net.gobies.apothecary;

import com.mojang.logging.LogUtils;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.init.APotions;
import net.gobies.apothecary.recipe.ABrewing;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Apothecary.MOD_ID)
public class Apothecary {

    public static final String MOD_ID = "apothecary";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Apothecary() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        APotions.register(modBus);

        AEffects.REGISTRY.register(modBus);

        modBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ABrewing::register);
    }
}