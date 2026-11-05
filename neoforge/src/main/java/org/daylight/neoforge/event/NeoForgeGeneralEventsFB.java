package org.daylight.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;
import org.daylight.neoforge.NeoForgeCommands;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NeoForgeGeneralEventsFB {
    @SubscribeEvent
    public static void onRegisterClientCommands(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(NeoForgeCommands.register());
    }
}
