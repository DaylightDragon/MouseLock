package org.daylight.util.graphics;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;

public class DrawingUtil {
    public static void drawCenteredText(PoseStack pose, String text, Font font, int x, int y, float scale, int textWidth, int color) {
        float centerX = x + textWidth / 2f;
        float centerY = y + font.lineHeight / 2f;

        pose.pushPose();
        pose.translate(centerX, centerY, 0);
        pose.scale(scale, scale, scale);

        // В 1.19 Font.draw принимает PoseStack, а не DrawContext/GuiGraphics
        font.draw(pose, text, -textWidth / 2f, -font.lineHeight / 2f, color);

        pose.popPose();
    }
}
