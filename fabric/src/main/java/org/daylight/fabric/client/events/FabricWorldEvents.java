package org.daylight.fabric.client.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientWorldEvents;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

public class FabricWorldEvents {
    public static void init() {
        ClientWorldEvents.AFTER_CLIENT_WORLD_CHANGE.register((client, level) -> {
            if(MouseLockConfig.RESET_ON_WORLD_CHANGE.get()) State.MOUSE_LOCK_ACTIVE = false;
        });
    }
}
