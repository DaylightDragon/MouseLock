package org.daylight.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.daylight.data.State;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Shadow
    private double xpos;

    @Shadow
    private double ypos;

    @Inject(
            method = "onMove",
            at = @At("HEAD"),
            cancellable = true
    )
    public void onMove(long handle, double xpos, double ypos, CallbackInfo ci) {
        if(State.MOUSE_LOCK_ACTIVE && Minecraft.getInstance().gui.screen() == null) {
            this.xpos = xpos;
            this.ypos = ypos;
            ci.cancel();
        }
    }
}
