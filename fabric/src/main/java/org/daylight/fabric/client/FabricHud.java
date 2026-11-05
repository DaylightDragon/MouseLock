package org.daylight.fabric.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.resources.ResourceLocation;
import org.daylight.MouseLock;
import org.daylight.gui.MouseLockedOverlay;

public class FabricHud {
    public static void init() {
        HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> {
            layeredDrawer.attachLayerAfter(IdentifiedLayer.MISC_OVERLAYS,
                    ResourceLocation.fromNamespaceAndPath(MouseLock.MOD_ID, "mouse_locked_text_overlay"),
                    (guiGraphics, deltaTracker) -> {
                        MouseLockedOverlay.drawIfNeeded(guiGraphics);
                    }
            );
        });
    }
}
