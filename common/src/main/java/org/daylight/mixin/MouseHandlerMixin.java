package org.daylight.mixin;

import net.minecraft.client.MouseHandler;
import org.daylight.data.State;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Inject(
            method = "onMove",
            at = @At("HEAD"),
            cancellable = true
    )
    public void onMove(final long handle, final double xpos, final double ypos, final double xrel, final double yrel, CallbackInfo ci) {
        if(State.MOUSE_LOCK_ACTIVE) {
            ci.cancel();
        }
    }
}
