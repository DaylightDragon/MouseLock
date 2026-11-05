package org.daylight.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.config.ModConfig;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;

@Mod(MouseLock.MOD_ID)
public final class MouseModNeoForge {
    public MouseModNeoForge(ModContainer container) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MouseLockConfig.SPEC);
//        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        MouseLock.init();

        NeoForgeKeybinds.init();
    }
}
