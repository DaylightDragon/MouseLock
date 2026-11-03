package org.daylight.neoforge.event;

import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.daylight.ModKeybindListeners;
import org.daylight.MouseLock;

@EventBusSubscriber(modid = MouseLock.MOD_ID)
public class GeneralEvents {
    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        ModKeybindListeners.KEYBIND_CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MouseLock.MOD_ID, "main"));
        ModKeybindListeners.initCommonKeybinds();

        event.registerCategory(ModKeybindListeners.KEYBIND_CATEGORY);

        event.register(ModKeybindListeners.MOUSE_LOCK_SWITCH_KEY);
    }
}
