package net.gobies.apothecary.init;

import net.gobies.apothecary.Apothecary;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES;
    //public static final RegistryObject<Attribute> DRAW_SPEED;

    public static void register (IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }

    static {
        ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Apothecary.MOD_ID);
        //DRAW_SPEED = ATTRIBUTES.register("draw_speed", () -> new RangedAttribute("attribute.name.apothecary.draw_speed", 1.0D, 0.0D, 2.0D).setSyncable(true));
    }
}