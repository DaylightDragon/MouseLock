package org.daylight.fabric.client;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.Minecraft;
import org.daylight.MouseLock;
import org.daylight.data.State;

import java.util.Optional;

public class FabricCommands {
    public static void init() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, context) -> {
            dispatcher.register(
                    ClientCommandManager.literal("mouselock")
                            .executes(context1 -> {
                                State.MOUSE_LOCK_ACTIVE = !State.MOUSE_LOCK_ACTIVE;
                                return Command.SINGLE_SUCCESS;
                            })
                            .then(ClientCommandManager.literal("settings")
                                    .executes(source -> openConfigScreen()))
            );
        });
    }

    private static int openConfigScreen() {
        State.SHOULD_OPEN_SETTINGS = true;
        return Command.SINGLE_SUCCESS;
    }
}
