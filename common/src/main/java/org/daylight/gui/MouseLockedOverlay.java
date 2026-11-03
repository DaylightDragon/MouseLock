package org.daylight.gui;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.daylight.data.State;
import org.daylight.util.graphics.DrawingUtil;

public class MouseLockedOverlay {
    public static void drawIfNeeded(GuiGraphicsExtractor graphics) {
        if (State.MOUSE_LOCK_ACTIVE && Minecraft.getInstance().level != null) {
            Window window = Minecraft.getInstance().getWindow();
            int width  = window.getGuiScaledWidth();
            int height = window.getGuiScaledHeight();

            String text = "Mouse Locked";
            Font font = Minecraft.getInstance().font;

            int textWidth = font.width(text);

            int x = (width - textWidth) / 2;
            int y = height - 22 - 18 - font.lineHeight;
            if (Minecraft.getInstance().gameMode != null && !Minecraft.getInstance().gameMode.canHurtPlayer()) {
                y += 14;
            }

            DrawingUtil.drawCenteredText(graphics, text, font, x, y, 1f, textWidth);
        }
    }
}
