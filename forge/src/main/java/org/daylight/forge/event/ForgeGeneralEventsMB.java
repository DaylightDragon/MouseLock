package org.daylight.forge.event;

import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;
import org.daylight.forge.ForgeCommands;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeGeneralEventsMB {
    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        ModKeybindListeners.initCommonKeybinds();

        event.register(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY);
    }
}
