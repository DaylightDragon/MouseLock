package org.daylight.neoforge.event;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import org.daylight.MouseLock;
import org.daylight.gui.MouseLockedOverlay;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeoForgeGuiEventsMB {
    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiOverlaysEvent event) {
        event.registerBelowAll(
                new ResourceLocation(MouseLock.MOD_ID, "mouse_locked_text_overlay"),
                (extendedGui, guiGraphics, f, i, j) -> {
                    MouseLockedOverlay.drawIfNeeded(guiGraphics);
                }
        );
    }
}
