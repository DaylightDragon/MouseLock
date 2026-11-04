package org.daylight.neoforge.event;

import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;
import org.daylight.neoforge.NeoForgeCommands;

@EventBusSubscriber(modid = MouseLock.MOD_ID)
public class NeoForgeGeneralEvents {
    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        ModKeybindListeners.initCommonKeybinds();

        event.register(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY);
    }

    @SubscribeEvent
    public static void onRegisterClientCommands(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(NeoForgeCommands.register());
    }
}
