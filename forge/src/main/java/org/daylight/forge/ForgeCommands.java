package org.daylight.forge;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.fml.ModContainer;import net.minecraftforge.fml.ModList;import org.daylight.MouseLock;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;

public class ForgeCommands {
    public static LiteralArgumentBuilder<CommandSourceStack> register() {
        return Commands.literal("mouselock")
                .then(Commands.literal("settings")
                        .executes(context -> {
                            ModContainer container = ModList.get().getModContainerById(MouseLock.MOD_ID).orElse(null);
                            if (container == null) return Command.SINGLE_SUCCESS;

                            Minecraft.getInstance().forceSetScreen(new ConfigurationScreen(container, Minecraft.getInstance().screen));
                            return Command.SINGLE_SUCCESS;
                        })
                )
                .executes(context -> {
                    State.MOUSE_LOCK_ACTIVE = !State.MOUSE_LOCK_ACTIVE;
                    return Command.SINGLE_SUCCESS;
                });
    }
}
