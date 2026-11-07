package org.daylight.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;

@EventBusSubscriber(modid = MouseLock.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class NeoForgeGeneralEventsMB {
    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        ModKeybindListeners.initCommonKeybinds();

        event.register(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY);
    }
}
