package org.daylight.forge.event;

import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;
import org.daylight.forge.ForgeCommands;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeGeneralEventsFB {
    @SubscribeEvent
    public static void onRegisterClientCommands(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(ForgeCommands.register());
    }
}
