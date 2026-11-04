package org.daylight.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.daylight.MouseLock;

@EventBusSubscriber(modid = MouseLock.MOD_ID)
public class NeoForgeInputEvents {
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
    }
}
