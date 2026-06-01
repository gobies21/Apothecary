package net.gobies.apothecary.util;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.mixin.accessor.ItemAccessor;
import net.minecraft.world.item.Items;

public class StackSizeSetter {

    public static void setStackSize() {
        if (CommonConfig.POTION_STACK_SIZE.get().equals(1)) return;
        ((ItemAccessor) Items.POTION).apothecary$setMaxStackSize(CommonConfig.POTION_STACK_SIZE.get());
        ((ItemAccessor) Items.SPLASH_POTION).apothecary$setMaxStackSize(CommonConfig.POTION_STACK_SIZE.get());
        ((ItemAccessor) Items.LINGERING_POTION).apothecary$setMaxStackSize(CommonConfig.POTION_STACK_SIZE.get());
    }
}
