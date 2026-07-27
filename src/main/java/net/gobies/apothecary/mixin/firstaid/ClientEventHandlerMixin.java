package net.gobies.apothecary.mixin.firstaid;

import ichttt.mods.firstaid.client.ClientEventHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ClientEventHandler.class)
public class ClientEventHandlerMixin {

    @Redirect(
            method = "tooltipItems(Lnet/minecraftforge/event/entity/player/ItemTooltipEvent;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;isEmpty()Z"
            ), remap = false
    )
    private static boolean emptyList(List<?> list) {
        return true;
    }
}
