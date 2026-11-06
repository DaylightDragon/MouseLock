package org.daylight.forge.platform;

import org.daylight.config.MouseLockConfig;
import org.daylight.platform.IPlatform;

public class ForgePlatform implements IPlatform {
    public void saveConfigSpec() {
        MouseLockConfig.SPEC.save();
    }
}
