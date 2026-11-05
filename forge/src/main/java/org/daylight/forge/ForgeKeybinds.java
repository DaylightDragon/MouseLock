package org.daylight.forge;

import net.minecraftforge.client.event.InputEvent;
import org.daylight.ModKeybindListeners;
import org.daylight.util.hotkey.InputBasedHotkeyListener;

public class ForgeKeybinds {
    public static void init() {
        Forge.EVENT_BUS.addListener(ForgeKeybinds::onKeyInput);
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
