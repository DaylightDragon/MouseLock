package org.daylight.fabric;

import net.fabricmc.api.ModInitializer;

import org.daylight.MouseLock;
import org.daylight.fabric.client.FabricHud;
import org.daylight.fabric.client.FabricKeybinds;
import org.daylight.fabric.client.events.WorldEvents;

public final class MouseModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MouseLock.init();

        FabricKeybinds.init();
        FabricHud.init();

        registerEvents();
    }

    private void registerEvents() {
        WorldEvents.init();
    }
}
