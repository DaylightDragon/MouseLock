package org.daylight.neoforge.event;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import org.daylight.MouseLock;
import org.daylight.gui.MouseLockedOverlay;

@EventBusSubscriber(modid = MouseLock.MOD_ID)
public class GuiEvents {
    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiLayersEvent event) {
        event.registerBelowAll(
                Identifier.fromNamespaceAndPath(MouseLock.MOD_ID, "mouse_locked_text_overlay"),
                (guiGraphics, deltaTracker) -> {
                    MouseLockedOverlay.drawIfNeeded(guiGraphics);
                }
        );
    }
}
