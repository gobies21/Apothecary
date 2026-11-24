package net.gobies.apothecary.client.overlay;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.config.ClientConfig;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.lwjgl.opengl.GL11;

public class ArmorOverlay {

    private static final ResourceLocation ARMOR_OVERLAY = new ResourceLocation(Apothecary.MOD_ID, "textures/gui/armor_overlay.png");
    private static final ResourceLocation ARMOR_TOUGHNESS_OVERLAY = new ResourceLocation(Apothecary.MOD_ID, "textures/gui/armor_toughness_overlay.png");
    private static final ResourceLocation RESISTANCE_OVERLAY = new ResourceLocation(Apothecary.MOD_ID, "textures/gui/resistance_overlay.png");
    private static final ResourceLocation MAGIC_SHIELDING_GLINT = new ResourceLocation(Apothecary.MOD_ID, "textures/gui/magic_shielding_glint.png");
    private static final ResourceLocation VANILLA_GUI_ICONS = new ResourceLocation("minecraft", "textures/gui/icons.png");

    public static final IGuiOverlay ARMOR_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements() || !ClientConfig.ENABLE_OVERLAYS.get() || !ClientConfig.ENABLE_ARMOR_OVERLAY.get()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        int totalArmor = player.getArmorValue();
        if (totalArmor <= 20) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (gui.leftHeight - 10);
        int armorPoints = Math.min(totalArmor - 20, 60);

        guiGraphics.flush();

        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, ARMOR_OVERLAY);

        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        for (int i = 0; i < 10; i++) {
            int slotPoints = armorPoints - (i * 2);
            if (slotPoints <= 0) break;

            int tier = (slotPoints - 1) / 20;
            int textureXOffset = tier * 18;
            if (slotPoints - (tier * 20) >= 2) {
                textureXOffset += 9;
            }

            addBlitQuad(builder, startX + (i * 8), startY, textureXOffset, 0, 9, 9, 54.0F, 9.0F);
        }
        BufferUploader.drawWithShader(builder.end());

        RenderSystem.disableBlend();
    };

    public static final IGuiOverlay ARMOR_TOUGHNESS_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements() || !ClientConfig.ENABLE_OVERLAYS.get() || !ClientConfig.ENABLE_ARMOR_TOUGHNESS_OVERLAY.get()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        int totalToughness = (int) Math.floor(player.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
        if (totalToughness <= 0) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (gui.leftHeight - 10);
        int toughnessPoints = Math.min(totalToughness, 60);

        guiGraphics.flush();

        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        if (player.getArmorValue() == 0) {
            RenderSystem.setShaderTexture(0, VANILLA_GUI_ICONS);
            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            for (int i = 0; i < 10; i++) {
                addBlitQuad(builder, startX + (i * 8), startY, 16, 9, 9, 9, 256.0F, 256.0F);
            }
            BufferUploader.drawWithShader(builder.end());
        }

        RenderSystem.setShaderTexture(0, ARMOR_TOUGHNESS_OVERLAY);
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        for (int i = 0; i < 10; i++) {
            int slotPoints = toughnessPoints - (i * 2);
            if (slotPoints <= 0) break;

            int tier = (slotPoints - 1) / 20;
            int textureXOffset = tier * 18;
            if (slotPoints - (tier * 20) < 2) {
                textureXOffset += 9;
            }

            addBlitQuad(builder, startX + (i * 8), startY, textureXOffset, 0, 9, 9, 54.0F, 9.0F);
        }
        BufferUploader.drawWithShader(builder.end());

        RenderSystem.disableBlend();
    };

    public static final IGuiOverlay RESISTANCE_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements() || !ClientConfig.ENABLE_OVERLAYS.get() || !ClientConfig.ENABLE_RESISTANCE_OVERLAY.get()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        double resistanceValue = getResistanceValue(player);
        if (resistanceValue <= 0.0) return;

        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - gui.leftHeight - 1;

        guiGraphics.flush();

        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        RenderSystem.setShaderTexture(0, RESISTANCE_OVERLAY);
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        for (int i = 0; i < 10; i++) {
            double startPercent = i * 0.10;
            if (resistanceValue <= startPercent) break;

            double endPercent = (i + 1) * 0.10;
            int iconX = startX + (i * 8) - 1;

            if (resistanceValue >= endPercent) {
                addBlitQuad(builder, iconX, startY, 0, 0, 11, 11, 11.0F, 11.0F);
            } else {
                int pixelWidth = (int) Math.ceil(((resistanceValue - startPercent) / 0.10) * 11.0);
                if (pixelWidth > 0) {
                    addBlitQuad(builder, iconX, startY, 0, 0, pixelWidth, 11, 11.0F, 11.0F);
                }
            }
        }
        BufferUploader.drawWithShader(builder.end());

        if (player.getArmorValue() == 0) {
            RenderSystem.setShaderTexture(0, VANILLA_GUI_ICONS);
            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            for (int i = 0; i < 10; i++) {
                addBlitQuad(builder, startX + (i * 8), startY + 1, 16, 9, 9, 9, 256.0F, 256.0F);
            }
            BufferUploader.drawWithShader(builder.end());
        }

        RenderSystem.disableBlend();
    };

    private static final long GLINT_START_TIME = System.currentTimeMillis();

    public static final IGuiOverlay MAGIC_SHIELDING_HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (!gui.shouldDrawSurvivalElements() || !ClientConfig.ENABLE_OVERLAYS.get() || !ClientConfig.ENABLE_MAGIC_SHIELDING_OVERLAY.get()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        double shieldingValue = player.getAttributeValue(AAttributes.MAGIC_SHIELDING.get());
        if (shieldingValue <= 0.0) return;

        int glintWidth = Math.min(90, Mth.floor(shieldingValue * 4.5 + 0.5));
        if (glintWidth <= 2) return;

        double resistanceValue = getResistanceValue(player);
        int startX = screenWidth / 2 - 91;
        int startY = screenHeight - (gui.leftHeight - 10);

        guiGraphics.flush();

        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        if (player.getArmorValue() == 0) {
            RenderSystem.setShaderTexture(0, VANILLA_GUI_ICONS);
            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            for (int i = 0; i < 10; i++) {
                addBlitQuad(builder, startX + (i * 8), startY, 16, 9, 9, 9, 256.0F, 256.0F);
            }
            BufferUploader.drawWithShader(builder.end());
        }

        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.colorMask(false, false, false, false);
        RenderSystem.depthFunc(GL11.GL_ALWAYS);
        RenderSystem.clear(GL11.GL_DEPTH_BUFFER_BIT, Minecraft.ON_OSX);

        RenderSystem.setShaderTexture(0, VANILLA_GUI_ICONS);
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        for (int slot = 0; slot < 10; slot++) {
            int remainingWidth = glintWidth - (slot * 9);
            if (remainingWidth <= 0) break;

            int armorWidth = Math.min(remainingWidth, 9);
            addBlitQuad(builder, startX + (slot * 8), startY, 16, 9, armorWidth, 9, 256.0F, 256.0F);
        }
        BufferUploader.drawWithShader(builder.end());

        if (resistanceValue > 0.0) {
            RenderSystem.setShaderTexture(0, RESISTANCE_OVERLAY);
            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            for (int slot = 0; slot < 10; slot++) {
                int remainingWidth = glintWidth - (slot * 9);
                if (remainingWidth <= 0) break;

                double startPercent = slot * 0.10;
                if (resistanceValue <= startPercent) break;

                double endPercent = (slot + 1) * 0.10;
                double slotProgress = Math.min((resistanceValue - startPercent) / 0.10, 1.0);

                int minX = (slot == 0) ? 0 : 1;
                int maxEdge = (resistanceValue <= endPercent || slot == 9) ? 11 : 9;
                int filledWidth = (int) Math.ceil(slotProgress * 11.0);
                int resistanceWidth = Math.min(Math.min(filledWidth, maxEdge), remainingWidth + 2);

                if (resistanceWidth > minX) {
                    addBlitQuad(builder, startX + (slot * 8) - 1 + minX, startY - 1, minX, 0, resistanceWidth - minX, 11, 11.0F, 11.0F);
                }
            }
            BufferUploader.drawWithShader(builder.end());
        }

        RenderSystem.colorMask(true, true, true, true);
        RenderSystem.depthMask(false);
        RenderSystem.depthFunc(GL11.GL_EQUAL);

        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, MAGIC_SHIELDING_GLINT);

        long time = System.currentTimeMillis() - GLINT_START_TIME;
        float firstWave = (time / 1800.0F / 8.0F) * 3.0F;
        float secondWave = (time / 2800.0F / 8.0F) * 3.0F;

        renderGlint(builder, startX, startY, firstWave, secondWave);

        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthFunc(GL11.GL_LEQUAL);
        RenderSystem.depthMask(true);
        RenderSystem.disableDepthTest();
    };

    private static void addBlitQuad(BufferBuilder builder, int x, int y, int texX, int texY, int width, int height, float texWidth, float texHeight) {
        float x1 = x + width;
        float y1 = y + height;
        float u0 = texX / texWidth;
        float u1 = (texX + width) / texWidth;
        float v0 = texY / texHeight;
        float v1 = (texY + height) / texHeight;

        builder.vertex(x, y1, 0.0F).uv(u0, v1).endVertex();
        builder.vertex(x1, y1, 0.0F).uv(u1, v1).endVertex();
        builder.vertex(x1, y, 0.0F).uv(u1, v0).endVertex();
        builder.vertex(x, y, 0.0F).uv(u0, v0).endVertex();
    }

    private static void renderGlint(BufferBuilder builder, int startX, int startY, float firstWave, float secondWave) {
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        float left = startX - 1.0F;
        float right = startX + 82.0F;
        float top = startY - 1.0F;
        float bottom = startY + 10.0F;

        float u0 = -1.0F / 80.0F;
        float u1 = 82.0F / 80.0F;

        for (int pass = 0; pass < 2; pass++) {
            float radians = (float) Math.toRadians(pass == 0 ? -50.0F : 10.0F);
            float cos = (float) Math.cos(radians) * 3.0F;
            float sin = (float) Math.sin(radians) * 3.0F;
            float waveOffset = (pass == 0) ? firstWave : secondWave;

            addVertex(builder, left, bottom, u0, 1.0F, cos, sin, waveOffset);
            addVertex(builder, right, bottom, u1, 1.0F, cos, sin, waveOffset);
            addVertex(builder, right, top, u1, 0.0F, cos, sin, waveOffset);
            addVertex(builder, left, top, u0, 0.0F, cos, sin, waveOffset);
        }

        BufferUploader.drawWithShader(builder.end());
    }

    private static void addVertex(BufferBuilder builder, float x, float y, float u, float v, float cos, float sin, float waveOffset) {
        float finalU = u * cos - v * sin + waveOffset;
        float finalV = u * sin + v * cos;
        builder.vertex(x, y, 0.0F).uv(finalU, finalV).color(255, 55, 242, 160).endVertex();
    }

    private static double getResistanceValue(Player player) {
        double damageResistance = AAttributes.getDamageResistanceValue(player);
        double resistance = damageResistance - 1.0;

        double cap = CommonConfig.MAX_DAMAGE_RESISTANCE.get();
        return Math.min(resistance, cap);
    }
}