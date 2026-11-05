package org.daylight.forge;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.config.ModConfig;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;

@Mod(MouseLock.MOD_ID)
public final class MouseLockForge {
    public MouseLockForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MouseLockConfig.SPEC);

        MouseLock.init();

        ForgeKeybinds.init();
    }
}
