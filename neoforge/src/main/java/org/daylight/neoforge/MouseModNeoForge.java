package org.daylight.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.ConfigScreenHandler;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.gui.SettingsScreen;

@Mod(MouseLock.MOD_ID)
public final class MouseModNeoForge {
    public MouseModNeoForge(ModContainer container) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MouseLockConfig.SPEC);
        container.registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (minecraft, parentScreen) -> new SettingsScreen(parentScreen)
                )
        );

        MouseLock.init();

        NeoForgeKeybinds.init();
    }
}
