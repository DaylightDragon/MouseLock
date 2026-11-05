package org.daylight.neoforge.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.LevelEvent;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NeoForgeWorldEventsFB {
    @SubscribeEvent
    public static void onWorldUnloaded(LevelEvent.Unload event) {
        if(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get()) State.MOUSE_LOCK_ACTIVE = false;
    }
}
