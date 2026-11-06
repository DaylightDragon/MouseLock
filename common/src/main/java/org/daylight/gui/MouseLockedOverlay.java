package org.daylight.gui;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;
import org.daylight.util.graphics.DrawingUtil;

public class MouseLockedOverlay {
    public static void drawIfNeeded(PoseStack matrixStack) {
        if (State.MOUSE_LOCK_ACTIVE && Minecraft.getInstance().level != null) {
            Window window = Minecraft.getInstance().getWindow();
            int width  = window.getGuiScaledWidth();
            int height = window.getGuiScaledHeight();

            Component textComponent = Component.translatable("mouselock.overlay.text.mouseLocked");
            String text = textComponent.getString();
            Font font = Minecraft.getInstance().font;

            int textWidth = font.width(text);

            int x = (int) ((width - textWidth) * ((float) MouseLockConfig.TEXT_HORIZONTAL_POS.get() / 100));
            int y = (int) ((height - font.lineHeight) * ((float) MouseLockConfig.TEXT_VERTICAL_POS.get() / 100)); // height - 22 - 18 - font.lineHeight;
            if (MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get() &&
                    Minecraft.getInstance().gameMode != null &&
                    !Minecraft.getInstance().gameMode.canHurtPlayer()) {
                y += 14;
            }

            DrawingUtil.drawCenteredText(matrixStack, text, font, x, y,
                    (float) MouseLockConfig.TEXT_SIZE.get() / 100, textWidth, 0xFFFFD966);
        }
    }
}
