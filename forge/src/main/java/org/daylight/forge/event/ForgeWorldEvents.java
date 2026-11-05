package org.daylight.forge.event;

import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID)
public class ForgeWorldEvents {
    @SubscribeEvent
    public static void onWorldUnloaded(LevelEvent.Unload event) {
        if(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get()) State.MOUSE_LOCK_ACTIVE = false;
    }
}
