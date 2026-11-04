package org.daylight.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.neoforge.event.InputEvents;

@Mod(MouseLock.MOD_ID)
public final class MouseModNeoForge {
    public MouseModNeoForge(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, MouseLockConfig.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        MouseLock.init();

        NeoForgeKeybinds.init();
    }
}
