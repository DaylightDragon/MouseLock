package org.daylight.fabric.client.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLevelEvents;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

public class WorldEvents {
    public static void init() {
        ClientLevelEvents.AFTER_CLIENT_LEVEL_CHANGE.register((client, level) -> {
            if(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get()) State.MOUSE_LOCK_ACTIVE = false;
        });
    }
}
