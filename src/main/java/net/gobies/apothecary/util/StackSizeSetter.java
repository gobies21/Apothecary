package net.gobies.apothecary.util;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = Apothecary.MOD_ID)
public class StackSizeSetter {

    @SubscribeEvent
    public static void modifyPotionStackSizes(ModifyDefaultComponentsEvent event) {
        int maxStackSize = CommonConfig.POTION_STACK_SIZE.get();

        event.modify(Items.POTION, components -> components.set(DataComponents.MAX_STACK_SIZE, maxStackSize));
        event.modify(Items.SPLASH_POTION, components -> components.set(DataComponents.MAX_STACK_SIZE, maxStackSize));
        event.modify(Items.LINGERING_POTION, components -> components.set(DataComponents.MAX_STACK_SIZE, maxStackSize));
    }
}
