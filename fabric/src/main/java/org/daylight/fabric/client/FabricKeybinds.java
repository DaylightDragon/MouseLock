package org.daylight.fabric.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;
import org.daylight.util.hotkey.TickBasedHotkeyListener;

public class FabricKeybinds {
    public static void init() {
        ModKeybindListeners.KEYBIND_CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MouseLock.MOD_ID, "main"));
        ModKeybindListeners.initCommonKeybinds();

        KeyMappingHelper.registerKeyMapping(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY);

        ModKeybindListeners.KEYBIND_CATEGORY = KeyMapping.Category.register(ModKeybindListeners.KEYBIND_CATEGORY.id());


        initCustomKeybinds();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ModKeybindListeners.MOUSE_LOCK_SWITCH_LISTENER.tick();
        });
    }

    private static void initCustomKeybinds() {
        ModKeybindListeners.MOUSE_LOCK_SWITCH_LISTENER = new TickBasedHotkeyListener(
                () -> KeyMappingHelper.getBoundKeyOf(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY).getValue(), // TODO CHECK IF OPTIMIZED
                ModKeybindListeners::toggleMouseLock,
                ModKeybindListeners.DEFAULT_VALIDATOR
        );
    }
}
