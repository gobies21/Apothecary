package net.gobies.apothecary.client.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gobies.apothecary.compat.moreartifacts.MoreArtifactsCompat;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ArmorOverlay {

    private static final ResourceLocation ARMOR_OVERLAY = new ResourceLocation("apothecary", "textures/gui/armor_overlay.png");
    private static final ResourceLocation ARMOR_TOUGHNESS_OVERLAY = new ResourceLocation("apothecary", "textures/gui/armor_toughness_overlay.png");
    private static final ResourceLocation RESISTANCE_OVERLAY = new ResourceLocation("apothecary", "textures/gui/resistance_overlay.png");
    private static final ResourceLocation VANILLA_GUI_ICONS = new ResourceLocation("minecraft", "textures/gui/icons.png");

    public static final IGuiOverlay ARMOR_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Minecraft minecraft = Minecraft.getInstance();
        final Player player = minecraft.player;
        if (player == null) return;

        int totalArmor = player.getArmorValue();
        if (totalArmor <= 20) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (gui.leftHeight - 10);
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

    public static final IGuiOverlay ARMOR_TOUGHNESS_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Minecraft minecraft = Minecraft.getInstance();
        final Player player = minecraft.player;
        if (player == null) return;

        double toughnessValue = player.getAttributeValue(Attributes.ARMOR_TOUGHNESS);
        int totalToughness = (int) Math.floor(toughnessValue);
        if (totalToughness <= 0) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (gui.leftHeight - 10);
        int toughnessPoints = Math.min(totalToughness, 40);

        RenderSystem.enableBlend();

        if (player.getArmorValue() == 0) {
            for (int i = 0; i < 10; i++) {
                guiGraphics.blit(VANILLA_GUI_ICONS, startX + (i * 8), startY, 16, 9, 9, 9, 256, 256);
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

            guiGraphics.blit(ARMOR_TOUGHNESS_OVERLAY, startX + (i * 8), startY, textureXOffset, 0, 9, 9, 36, 9);
        }

        RenderSystem.disableBlend();
    };

    public static final IGuiOverlay RESISTANCE_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements()) return;
        if (!ClientConfig.ENABLE_ARMOR_OVERLAYS.get()) return;

        final Minecraft minecraft = Minecraft.getInstance();
        final Player player = minecraft.player;
        if (player == null) return;

        double resistanceValue = getResistanceValue(player);

        if (resistanceValue <= 0.0) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - gui.leftHeight - 1;

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
                guiGraphics.blit(VANILLA_GUI_ICONS, startX + (i * 8), startY + 1, 16, 9, 9, 9, 256, 256);
            }
        }

        RenderSystem.disableBlend();
    };

    private static double getResistanceValue(Player player) {
        double damageResistance = AAttributes.getDamageResistance(player);

        double resistance = damageResistance - 1.0;

        resistance += MoreArtifactsCompat.getDamageReduction(player);

        double cap = CommonConfig.MAX_DAMAGE_RESISTANCE.get();
        return Math.min(resistance, cap);
    }
}