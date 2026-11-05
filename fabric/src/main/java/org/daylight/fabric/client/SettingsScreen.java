package org.daylight.fabric.client;

import com.terraformersmc.modmenu.config.ModMenuConfig;
import com.terraformersmc.modmenu.config.ModMenuConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.io.File;

//public class SettingsScreen extends OptionsScreen {
//    private final Screen previous;
//    private OptionsList list;
//
//    public SettingsScreen(Screen previous) {
//        super(previous, new Options(Minecraft.getInstance(), new File(Minecraft.getInstance().gameDirectory, "configs/temp/mouselock")));
//        this.previous = previous;
//    }
//
//    @Override
//    protected void init() {
//        // OptionsList вместо OptionListWidget
//        this.list = new OptionsList(this.minecraft, this.width, this.height - 64, 32, 25);
//        this.list.addSmall(ModMenuConfig.asOptions());   // <-- ключевое отличие: addSmall
//        this.addWidget(this.list);
//
//        this.addRenderableWidget(
//                Button.builder(CommonComponents.GUI_DONE, (button) -> {
//                            ModMenuConfigManager.save();
//                            this.minecraft.setScreen(this.previous);
//                        })
//                        .pos(this.width / 2 - 100, this.height - 27)
//                        .size(200, 20)
//                        .build()
//        );
//    }
//
//    @Override
//    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
//        super.render(guiGraphics, mouseX, mouseY, delta);
//        this.list.render(guiGraphics, mouseX, mouseY, delta);
//        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 5, 0xFFFFFF);
//    }
//
//    @Override
//    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
//        this.renderBackground(guiGraphics, mouseX, mouseY, delta); // или this.renderTransparentBackground(guiGraphics)
//    }
//
//    @Override
//    public void removed() {
//        ModMenuConfigManager.save();
//    }
//}

