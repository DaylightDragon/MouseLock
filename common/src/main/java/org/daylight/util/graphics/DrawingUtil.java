package org.daylight.util.graphics;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class DrawingUtil {
    public static void drawCenteredText(GuiGraphicsExtractor graphics, String text, Font font, int x, int y, float scale, int textWidth) {
        float centerX = x + textWidth / 2f;
        float centerY = y + font.lineHeight / 2f;

        graphics.pose().pushMatrix();
        graphics.pose().translate(centerX, centerY);
        graphics.pose().scale(scale, scale);
        graphics.text(font, text, -textWidth / 2, -font.lineHeight / 2, 0xFFFFD966);
        graphics.pose().popMatrix();
    }
}
