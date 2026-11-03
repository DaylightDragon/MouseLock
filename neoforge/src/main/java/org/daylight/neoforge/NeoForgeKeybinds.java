package org.daylight.neoforge;

import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.daylight.ModKeybindListeners;
import org.daylight.util.hotkey.InputBasedHotkeyListener;

public class NeoForgeKeybinds {
    public static void init() {
        NeoForge.EVENT_BUS.addListener(NeoForgeKeybinds::onKeyInput);
        initCustomKeybinds();
    }

    private static void initCustomKeybinds() {
        ModKeybindListeners.MOUSE_LOCK_SWITCH_LISTENER = new InputBasedHotkeyListener(
                () -> ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY.getKey().getValue(),
                ModKeybindListeners::toggleMouseLock,
                ModKeybindListeners.DEFAULT_VALIDATOR
        );
    }

    private static void onKeyInput(InputEvent.Key event) {
        ModKeybindListeners.MOUSE_LOCK_SWITCH_LISTENER.onRawKeyInput(event.getAction(), event.getKey());
    }
}
