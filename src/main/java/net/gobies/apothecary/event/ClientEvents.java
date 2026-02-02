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
                if (getEffect == AEffects.IronSkin.get()) {
                    int armor = CommonConfig.IRON_SKIN_ARMOR_INCREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + armor + " Armor").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.DiamondSkin.get()) {
                    int armorToughness = CommonConfig.DIAMOND_SKIN_ARMOR_INCREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + armorToughness + " Armor Toughness").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Archery.get()) {
                    int arrowDamage = CommonConfig.ARCHERY_DAMAGE_INCREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + arrowDamage + " Arrow Damage").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Reach.get()) {
                    int reach = CommonConfig.REACH_INCREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + reach + " Entity Reach").withStyle(ChatFormatting.BLUE)));
                    event.getToolTip().add(5, (Component.literal("+" + reach + " Block Reach").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.MagicPower.get() && ModLoadedUtil.isIronsSpellbooksLoaded()) {
                    int spellPower = (int) (100 * CommonConfig.MAGIC_POWER_INCREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + spellPower + "% Spell Power").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.ManaRegeneration.get() && ModLoadedUtil.isIronsSpellbooksLoaded()) {
                    int manaRegen = 25 * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + manaRegen + "% Mana Regeneration").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Spelunker.get()) {
                    int radius = 7 * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + radius + " Detection Radius").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Wrath.get()) {
                    int damageIncrease = (int) (100 * CommonConfig.WRATH_DAMAGE_INCREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + damageIncrease + "% Damage Increase").withStyle(ChatFormatting.BLUE)));
                }
                if (getEffect == AEffects.Thorns.get()) {
                    int damageReflect = (int) (100 * CommonConfig.THORNS_DAMAGE_REFLECT.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("+" + damageReflect + "% Damage Reflect").withStyle(ChatFormatting.BLUE)));
                }

                // Negative effects
                if (getEffect == AEffects.BrokenArmor.get()) {
                    int armor = CommonConfig.BROKEN_ARMOR_ARMOR_DECREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + armor + " Armor").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.RupturedArmor.get()) {
                    int armorToughness = CommonConfig.RUPTURED_ARMOR_ARMOR_DECREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + armorToughness + " Armor Toughness").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.Misfire.get()) {
                    int arrowDamage = CommonConfig.MISFIRE_DAMAGE_DECREASE.get() * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + arrowDamage + " Arrow Damage").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.Shocked.get()) {
                    int speed = (int) (100 * CommonConfig.SHOCKED_SPEED_DECREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + speed + "% Speed").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.MagicDrain.get() && ModLoadedUtil.isIronsSpellbooksLoaded()) {
                    int spellPower = (int) (100 * CommonConfig.MAGIC_DRAIN_DECREASE.get() * (amplifier + 1));
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + spellPower + "% Spell Power").withStyle(ChatFormatting.RED)));
                }
                if (getEffect == AEffects.ManaExhaustion.get() && ModLoadedUtil.isIronsSpellbooksLoaded()) {
                    int manaRegen = 25 * (amplifier + 1);
                    applyTooltips(event);
                    event.getToolTip().add(4, (Component.literal("-" + manaRegen + "% Mana Regeneration").withStyle(ChatFormatting.RED)));
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