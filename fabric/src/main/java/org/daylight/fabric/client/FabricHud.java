package org.daylight.fabric.client;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.resources.ResourceLocation;
import org.daylight.MouseLock;
import org.daylight.gui.MouseLockedOverlay;

public class FabricHud {
    public static void init() {
        HudElementRegistry.addLast(
                ResourceLocation.fromNamespaceAndPath(MouseLock.MOD_ID, "mouse_locked_text_overlay"),
                (guiGraphics, deltaTracker) -> {
                    MouseLockedOverlay.drawIfNeeded(guiGraphics);
                }
        );
    }
}
