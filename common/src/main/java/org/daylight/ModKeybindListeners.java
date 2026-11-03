package org.daylight;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.daylight.data.State;
import org.daylight.util.hotkey.IHotkeyListener;

import java.util.function.Supplier;

public class ModKeybindListeners {
    public static final Supplier<Boolean> DEFAULT_VALIDATOR = () -> Minecraft.getInstance().gui.screen() == null;

    public static KeyMapping.Category KEYBIND_CATEGORY;

    public static KeyMapping MOUSE_LOCK_SWITCH_KEY;

    public static void initCommonKeybinds() {
        MOUSE_LOCK_SWITCH_KEY = new KeyMapping(
                "key." + MouseLock.MOD_ID + ".toggle_mouse_lock",
                InputConstants.UNKNOWN.getValue(),
                KEYBIND_CATEGORY
        );
    }

    public static IHotkeyListener MOUSE_LOCK_SWITCH_LISTENER;

    public static void toggleMouseLock() {
        State.MOUSE_LOCK_ACTIVE = !State.MOUSE_LOCK_ACTIVE;
    }
}
