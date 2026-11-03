package org.daylight.neoforge;

import net.neoforged.fml.common.Mod;

import org.daylight.MouseLock;
import org.daylight.neoforge.event.InputEvents;

@Mod(MouseLock.MOD_ID)
public final class MouseModNeoForge {
    public MouseModNeoForge() {
        MouseLock.init();

        NeoForgeKeybinds.init();
    }
}
