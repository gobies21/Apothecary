package net.gobies.apothecary.event;

import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
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
        ItemStack stack = event.getItemStack();
        Potion potion = PotionUtils.getPotion(stack);
        List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);
        if (stack.getItem() instanceof PotionItem && !effects.isEmpty()) {
            if (ClientConfig.ENABLE_POTION_DESCRIPTIONS.get()) {
                if (Screen.hasShiftDown()) {
                    potion.getEffects().forEach(effect -> {
                        String potionDescription = effect.getEffect().getDescriptionId();
                        event.getToolTip().add(Component.translatable(potionDescription + ".description").withStyle(ChatFormatting.GRAY));
                    });
                } else {
                    event.getToolTip().add(Component.translatable("tooltip.apothecary.potion_info").withStyle(ChatFormatting.GRAY));
                }
            }
            if (ClientConfig.ADDITIONAL_POTION_TOOLTIPS.get()) {
                MobEffectInstance effectInstance = effects.get(0);
                int amplifier = effectInstance.getAmplifier();
                MobEffect getEffect = effectInstance.getEffect();

                // Positive effects
                if (getEffect == AEffects.Archery.get()) {
                    int arrowDamage = CommonConfig.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + arrowDamage + " Arrow Damage").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Spelunker.get()) {
                    int radius = 7 * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + radius + " Detection Radius").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Wrath.get()) {
                    int damageIncrease = (int) (100 * CommonConfig.WRATH_DAMAGE_INCREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + damageIncrease + "% Damage Dealt").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Thorns.get()) {
                    int damageReflect = (int) (100 * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + damageReflect + "% Damage Reflect").withStyle(ChatFormatting.BLUE)));
                }

                // Negative effects
                if (getEffect == AEffects.Misfire.get()) {
                    int arrowDamage = CommonConfig.MISFIRE_DAMAGE_DECREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + arrowDamage + " Arrow Damage").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.Feeble.get()) {
                    int damageIncrease = (int) (100 * CommonConfig.FEEBLE_DAMAGE_DECREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + damageIncrease + "% Damage Increase").withStyle(ChatFormatting.RED)));
                }
            }
        }
    }

    private static void applyTooltips(ItemTooltipEvent event) {
        event.getToolTip().add(2, (Component.literal("")));
        event.getToolTip().add(3, (Component.literal("When Applied:").withStyle(ChatFormatting.DARK_PURPLE)));
    }
}