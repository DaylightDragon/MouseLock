package org.daylight.forge.event;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.daylight.MouseLock;

@Mod.EventBusSubscriber(modid = MouseLock.MOD_ID)
public class ForgeInputEvents {
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
    }
}
