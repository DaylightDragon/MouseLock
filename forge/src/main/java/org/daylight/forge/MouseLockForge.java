package org.daylight.forge;

import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.gui.SettingsScreen;

@Mod(MouseLock.MOD_ID)
public final class MouseLockForge {
    public MouseLockForge() {
        ModContainer container = ModList.get().getModContainerById(MouseLock.MOD_ID).orElse(null);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MouseLockConfig.SPEC);
        if(container != null) container.registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (minecraft, parentScreen) -> new SettingsScreen(parentScreen)
                )
        );

        MouseLock.init();

        ForgeKeybinds.init();
    }
}
