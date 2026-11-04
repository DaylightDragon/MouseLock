package org.daylight.util.graphics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class DummyScreen extends Screen {
    public DummyScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        super.init();
        Minecraft.getInstance().execute(this::onClose);
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().gui.setScreen(null);
    }
}
