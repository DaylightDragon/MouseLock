package org.daylight.fabric;

import net.fabricmc.api.ModInitializer;

import org.daylight.MouseLock;
import org.daylight.fabric.client.FabricKeybinds;

public final class MouseModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MouseLock.init();

        FabricKeybinds.init();
    }
}
