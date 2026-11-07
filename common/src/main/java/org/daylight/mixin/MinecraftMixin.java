package org.daylight.mixin;

import net.minecraft.client.Minecraft;
import org.daylight.config.MouseLockConfig;
import org.daylight.data.State;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(
            method = "setLevel",
            at = @At("HEAD")
    )
    public void onLevelChange(CallbackInfo ci) {
        if(MouseLockConfig.RESET_ON_WORLD_CHANGE.get()) State.MOUSE_LOCK_ACTIVE = false;
    }
}
