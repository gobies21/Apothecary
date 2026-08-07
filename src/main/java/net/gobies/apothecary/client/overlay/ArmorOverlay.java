package net.gobies.apothecary.client.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class ArmorOverlay {

    private static final ResourceLocation ARMOR_OVERLAY = ResourceLocation.fromNamespaceAndPath("apothecary", "textures/gui/armor_overlay.png");
    private static final ResourceLocation ARMOR_TOUGHNESS_OVERLAY = ResourceLocation.fromNamespaceAndPath("apothecary", "textures/gui/armor_toughness_overlay.png");
    private static final ResourceLocation RESISTANCE_OVERLAY = ResourceLocation.fromNamespaceAndPath("apothecary", "textures/gui/resistance_overlay.png");
    private static final ResourceLocation VANILLA_GUI_ICONS = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/sprites/hud/armor_empty.png");

    public static final LayeredDraw.Layer ARMOR_HUD = (guiGraphics, deltaTracker) -> {
        final Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.options.hideGui || minecraft.gameMode == null || !minecraft.gameMode.canHurtPlayer()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Player player = minecraft.player;
        if (player == null) return;

        int totalArmor = player.getArmorValue();
        if (totalArmor <= 20) return;

        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();

        int startX = screenWidth / 2 - 91;

        int startY = screenHeight - (minecraft.gui.leftHeight - 10);
        int armorPoints = Math.min(totalArmor - 20, 40);

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        for (int i = 0; i < 10; i++) {
            int slotPoints = armorPoints - (i * 2);
            if (slotPoints <= 0) break;

            int tier = (slotPoints - 1) / 20;
            int textureXOffset = tier * 18;
            int remainingPoints = slotPoints - (tier * 20);

            if (remainingPoints >= 2) {
                textureXOffset += 9;
            }

            guiGraphics.blit(ARMOR_OVERLAY, startX + (i * 8), startY, textureXOffset, 0, 9, 9, 36, 9);
        }
        RenderSystem.disableBlend();
    };

    public static final LayeredDraw.Layer ARMOR_TOUGHNESS_HUD = (guiGraphics, deltaTracker) -> {
        final Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.options.hideGui || minecraft.gameMode == null || !minecraft.gameMode.canHurtPlayer()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Player player = minecraft.player;
        if (player == null) return;

        double toughnessValue = player.getAttributeValue(Attributes.ARMOR_TOUGHNESS);
        int totalToughness = (int) Math.floor(toughnessValue);
        if (totalToughness <= 0) return;

        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (minecraft.gui.leftHeight - 10);
        int toughnessPoints = Math.min(totalToughness, 40);

        RenderSystem.enableBlend();

        boolean noArmor = player.getArmorValue() == 0;

        if (noArmor) {
            for (int i = 0; i < 10; i++) {
                guiGraphics.blit(VANILLA_GUI_ICONS, startX + (i * 8), startY - 10, 0, 0, 9, 9, 9, 9);
            }
        }

        RenderSystem.defaultBlendFunc();

        for (int i = 0; i < 10; i++) {
            int slotPoints = toughnessPoints - (i * 2);
            if (slotPoints <= 0) break;

            int tier = (slotPoints - 1) / 20;
            int textureXOffset = tier * 18;
            int remainingPoints = slotPoints - (tier * 20);

            if (remainingPoints < 2) {
                textureXOffset += 9;
            }


            guiGraphics.blit(ARMOR_TOUGHNESS_OVERLAY, startX + (i * 8), noArmor ? startY - 10 : startY, textureXOffset, 0, 9, 9, 36, 9);
        }
        RenderSystem.disableBlend();
    };

    public static final LayeredDraw.Layer RESISTANCE_HUD = (guiGraphics, deltaTracker) -> {
        final Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.options.hideGui || minecraft.gameMode == null || !minecraft.gameMode.canHurtPlayer()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Player player = minecraft.player;
        if (player == null) return;

        double resistanceValue = getResistanceValue(player);
        if (resistanceValue <= 0.0) return;

        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - minecraft.gui.leftHeight - 1;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        for (int i = 0; i < 10; i++) {
            double startPercent = i * 0.10;
            double endPercent = (i + 1) * 0.10;
            if (resistanceValue <= startPercent) break;

            int iconX = startX + (i * 8) - 1;

            if (resistanceValue >= endPercent) {
                guiGraphics.blit(RESISTANCE_OVERLAY, iconX, startY, 0, 0, 11, 11, 11, 11);
            } else {
                double slotProgress = (resistanceValue - startPercent) / 0.10;
                int pixelWidth = (int) Math.ceil(slotProgress * 11.0);
                if (pixelWidth > 0) {
                    guiGraphics.blit(RESISTANCE_OVERLAY, iconX, startY, 0, 0, pixelWidth, 11, 11, 11);
                }
            }
        }

        if (player.getArmorValue() == 0) {
            for (int i = 0; i < 10; i++) {
                guiGraphics.blit(VANILLA_GUI_ICONS, startX + (i * 8), startY + 1, 0, 0, 9, 9, 9, 9);            }
        }
        RenderSystem.disableBlend();
    };

    private static double getResistanceValue(Player player) {
        double damageResistance = AAttributes.getDamageResistance(player);

        double resistance = damageResistance - 1.0;

        double cap = CommonConfig.MAX_DAMAGE_RESISTANCE.get();
        return Math.min(resistance, cap);
    }
}