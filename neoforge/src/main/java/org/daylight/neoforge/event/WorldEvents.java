package org.daylight.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

@EventBusSubscriber(modid = MouseLock.MOD_ID)
public class WorldEvents {
    @SubscribeEvent
    public static void onWorldUnloaded(LevelEvent.Unload event) {
        if(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get()) State.MOUSE_LOCK_ACTIVE = false;
    }
}
