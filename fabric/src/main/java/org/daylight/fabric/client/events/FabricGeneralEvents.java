package org.daylight.fabric.client.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.daylight.MouseLock;
import org.daylight.data.State;
import org.daylight.util.graphics.DummyScreen;

public class FabricGeneralEvents {
    public static void init() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            openConfigIfNeeded();
        });
    }

    private static void openConfigIfNeeded() {
        if(!State.SHOULD_OPEN_SETTINGS) return;
        State.SHOULD_OPEN_SETTINGS = false;

        Screen dummyParent = new DummyScreen();
//        Minecraft.getInstance().forceSetScreen(new ConfigurationScreen(MouseLock.MOD_ID, dummyParent)); // shouldn't be null or dummy screen if ever called not from chat
    }
}
