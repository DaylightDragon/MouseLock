package org.daylight.fabric.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.daylight.gui.MouseLockedOverlay;

public class FabricHud {
    public static void init() {
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            MouseLockedOverlay.drawIfNeeded(matrixStack);
        });
    }
}
