package org.daylight.forge.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.daylight.MouseLock;
import org.daylight.gui.MouseLockedOverlay;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeGuiEvents {
    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiOverlaysEvent event) {
        event.registerBelowAll(
                "mouse_locked_text_overlay", // not sure if this should be without a namespace. 1.20.4- requires a String
                (forgeGui, matrixStack, f, i, j) -> {
                    MouseLockedOverlay.drawIfNeeded(matrixStack);
                }
        );
    }
}
