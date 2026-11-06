package org.daylight.mixin;

import net.minecraft.server.MinecraftServer;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(
            method = "stopServer",
            at = @At("HEAD")
    )
    private void onStopServer(CallbackInfo ci) {
        if(MouseLockConfig.RESET_ON_WORLD_CHANGE.get()) State.MOUSE_LOCK_ACTIVE = false;
    }
}
