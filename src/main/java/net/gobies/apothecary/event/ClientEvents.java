package net.gobies.apothecary.event;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.ClientConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    @SubscribeEvent
    public static void onRenderTooltip(ItemTooltipEvent event) {
        if (ClientConfig.ENABLE_POTION_DESCRIPTIONS.get()) {
            ItemStack stack = event.getItemStack();
            Potion potion = PotionUtils.getPotion(stack);
            List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);
            if (stack.getItem() instanceof PotionItem && !effects.isEmpty()) {
                if (Screen.hasShiftDown()) {
                    potion.getEffects().forEach(effect -> {
                        String potionDescription = effect.getEffect().getDescriptionId();
                        event.getToolTip().add(Component.translatable(potionDescription + ".description").withStyle(ChatFormatting.GRAY));
                    });
                } else {
                    event.getToolTip().add(Component.translatable("tooltip.apothecary.potion_info").withStyle(ChatFormatting.GRAY));
                }
            }
        }
    }
}