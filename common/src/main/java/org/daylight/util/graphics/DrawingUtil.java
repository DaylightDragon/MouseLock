package org.daylight.util.graphics;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

public class DrawingUtil {
    public static void drawCenteredText(GuiGraphics graphics, String text, Font font, int x, int y, float scale, int textWidth) {
        float centerX = x + textWidth / 2f;
        float centerY = y + font.lineHeight / 2f;

        graphics.pose().pushPose();
        graphics.pose().translate(centerX, centerY, 0);
        graphics.pose().scale(scale, scale, scale);
        graphics.drawString(font, text, -textWidth / 2, -font.lineHeight / 2, 0xFFFFD966);
        graphics.pose().popPose();
    }
}
