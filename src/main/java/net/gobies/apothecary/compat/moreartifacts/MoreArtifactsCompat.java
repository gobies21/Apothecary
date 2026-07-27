package net.gobies.apothecary.compat.moreartifacts;

import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.gobies.moreartifacts.event.DamageEvents;
import net.gobies.moreartifacts.item.potions.RecallPotionItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MoreArtifactsCompat {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new MoreArtifactsCompat());
    }

   /* @SubscribeEvent
    public void onRenderTooltip(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        if (ClientConfig.ENABLE_POTION_DESCRIPTIONS.get()) {
            if (Screen.hasShiftDown()) {
                if (item instanceof RecallPotionItem) {
                    event.getToolTip().add(Component.translatable("apothecary.moreartifacts.recall_potion").withStyle(ChatFormatting.GRAY));
                } /*else if (item instanceof WormholePotionItem) {
                    event.getToolTip().add(Component.translatable("apothecary.moreartifacts.wormhole_potion").withStyle(ChatFormatting.GRAY));
                }
            } else if (item instanceof RecallPotionItem /*|| item instanceof WormholePotionItem){
                event.getToolTip().add(Component.translatable("tooltip.apothecary.potion_info").withStyle(ChatFormatting.GRAY));
            }
        }
    }
        */
    public static double getDamageReduction(Player player) {
        if (ModLoadedUtil.isMoreArtifactsLoaded()) {
            return DamageEvents.getTotalDamageReduction(player);
        }
        return 0;
    }
}
