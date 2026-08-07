package net.gobies.apothecary.event;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = Apothecary.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRenderTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);
        if (stack.getItem() instanceof PotionItem && contents != null && contents.hasEffects()) {
            if (ClientConfig.ENABLE_POTION_DESCRIPTIONS.get()) {
                if (Screen.hasShiftDown()) {
                    contents.forEachEffect(effect -> {
                        String potionDescription = effect.getEffect().value().getDescriptionId();
                        event.getToolTip().add(Component.translatable(potionDescription + ".description").withStyle(ChatFormatting.GRAY));
                    });
                } else {
                    event.getToolTip().add(Component.translatable("tooltip.apothecary.potion_info").withStyle(ChatFormatting.GRAY));
                }
            }
            if (ClientConfig.ADDITIONAL_POTION_TOOLTIPS.get()) {
                contents.potion().ifPresent(potionHolder -> {
                    if (!potionHolder.value().getEffects().isEmpty()) {
                        MobEffectInstance effectInstance = potionHolder.value().getEffects().getFirst();

                        int amplifier = effectInstance.getAmplifier();
                        MobEffect getEffect = effectInstance.getEffect().value();

                        // Positive effects
                        if (getEffect == AEffects.Spelunker.get()) {
                            int radius = 7 * (amplifier + 1);
                            applyTooltips(event);
                            event.getToolTip().add(4, (Component.literal("+" + radius + " Detection Radius").withStyle(ChatFormatting.BLUE)));
                        }
                        if (getEffect == AEffects.Thorns.get()) {
                            int damageReflect = (int) (100 * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1));
                            applyTooltips(event);
                            event.getToolTip().add(4, (Component.literal("+" + damageReflect + "% Damage Reflect").withStyle(ChatFormatting.BLUE)));
                        }
                    }
                });
            }
        }
    }

    private static void applyTooltips(ItemTooltipEvent event) {
        event.getToolTip().add(2, (Component.literal("")));
        event.getToolTip().add(3, (Component.literal("When Applied:").withStyle(ChatFormatting.DARK_PURPLE)));
    }

    private static void addNumberTooltip(List<Component> tooltipList, String descriptionId, int value) {
        tooltipList.add(Component.translatable(descriptionId + ".description")
                .append(Component.translatable("tooltip.apothecary.number", value))
                .withStyle(ChatFormatting.GRAY));
    }

    private static void addPercentageTooltip(List<Component> tooltipList, String descriptionId, double value) {
        int percentage = (int) (value * 100);
        tooltipList.add(Component.translatable(descriptionId + ".description")
                .append(Component.translatable("tooltip.apothecary.percentage", percentage))
                .withStyle(ChatFormatting.GRAY));
    }
}