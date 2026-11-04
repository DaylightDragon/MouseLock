package org.daylight.fabric;

import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;

import net.neoforged.fml.config.ModConfig;
import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.fabric.client.FabricCommands;
import org.daylight.fabric.client.FabricHud;
import org.daylight.fabric.client.FabricKeybinds;
import org.daylight.fabric.client.events.FabricGeneralEvents;
import org.daylight.fabric.client.events.FabricWorldEvents;

public final class MouseLockFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigRegistry.INSTANCE.register(
                MouseLock.MOD_ID,
                ModConfig.Type.CLIENT,
                MouseLockConfig.SPEC
        );

        MouseLock.init();

        FabricKeybinds.init();
        FabricHud.init();
        FabricCommands.init();

        registerEvents();
    }

    private void registerEvents() {
        FabricGeneralEvents.init();
        FabricWorldEvents.init();
    }
}
