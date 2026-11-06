package org.daylight.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;
import org.daylight.config.MouseLockConfig;

public class SettingsScreen extends Screen {
    private final Screen parent;

    private static final int ROW_WIDTH = 310;
    private static final int TEXT_WIDTH = 200;
    private static final int WIDGET_WIDTH = 100;
    private static final int GAP = 10;

    public SettingsScreen(Screen parent) {
        super(Component.translatable("mouselock.configuration.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int leftX = (this.width - ROW_WIDTH) / 2;
        int widgetX = leftX + TEXT_WIDTH + GAP;
        int y = 40;
        int step = 25;

        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_SIZE, 20, 200));
        y += step;
        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_HORIZONTAL_POS, 0, 100));
        y += step;
        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_VERTICAL_POS, 0, 100));
        y += step;

        CycleButton<Boolean> reactBtn = CycleButton.onOffBuilder(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get())
                .create(widgetX, y, WIDGET_WIDTH, 20, Component.empty(),
                        (btn, v) -> {
                            MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.set(v);
                            btn.setMessage(Component.literal(v ? "ON" : "OFF"));
                        });
        reactBtn.setMessage(Component.literal(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get() ? "ON" : "OFF"));
        this.addRenderableWidget(reactBtn);
        y += step;

        CycleButton<Boolean> resetBtn = CycleButton.onOffBuilder(MouseLockConfig.RESET_ON_WORLD_CHANGE.get())
                .create(widgetX, y, WIDGET_WIDTH, 20, Component.empty(),
                        (btn, v) -> {
                            MouseLockConfig.RESET_ON_WORLD_CHANGE.set(v);
                            btn.setMessage(Component.literal(v ? "ON" : "OFF"));
                        });
        resetBtn.setMessage(Component.literal(MouseLockConfig.RESET_ON_WORLD_CHANGE.get() ? "ON" : "OFF"));
        this.addRenderableWidget(resetBtn);

        this.addRenderableWidget(new Button(
                this.width / 2 - 100,
                this.height - 27,
                200,
                20,
                CommonComponents.GUI_DONE,
                b -> {
//                    MouseLockConfig.SPEC.save();
                    this.minecraft.setScreen(this.parent);
                }
        ));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        // Отрисовка стандартного фона (в 1.19 это делается через renderBackground)
        this.renderBackground(poseStack);

        // Отрисовка виджетов
        super.render(poseStack, mouseX, mouseY, partialTick);

        int leftX = (this.width - ROW_WIDTH) / 2;
        int textX = leftX + 5;
        int y = 45;
        int step = 25;

        // В 1.19 Font.drawString принимает PoseStack первым аргументом
        this.font.draw(poseStack, Component.translatable("mouselock.configuration.textSize"), textX, y, 0xFFFFFF);
        y += step;
        this.font.draw(poseStack, Component.translatable("mouselock.configuration.textHorizontalPos"), textX, y, 0xFFFFFF);
        y += step;
        this.font.draw(poseStack, Component.translatable("mouselock.configuration.textVerticalPos"), textX, y, 0xFFFFFF);
        y += step;
        this.font.draw(poseStack, Component.translatable("mouselock.configuration.reactToHotbarHeight"), textX, y, 0xFFFFFF);
        y += step;
        this.font.draw(poseStack, Component.translatable("mouselock.configuration.resetOnWorldChange"), textX, y, 0xFFFFFF);

        // Центрированный заголовок
        this.font.drawShadow(poseStack, this.title, (this.width - this.font.width(this.title)) / 2f, 15, 0xFFFFFF);
    }

    @Override
    public void onClose() {
//        MouseLockConfig.SPEC.save();
        this.minecraft.setScreen(this.parent);
    }

    private AbstractWidget createIntSlider(int x, int y, int width, ForgeConfigSpec.IntValue configValue, int min, int max) {
        OptionInstance<Integer> instance = new OptionInstance<>(
                "",
                OptionInstance.noTooltip(),
                (caption, val) -> Component.literal(String.valueOf(val)),
                new OptionInstance.IntRange(min, max),
                configValue.get(),
                v -> configValue.set(v)
        );

        AbstractWidget widget = instance.createButton(this.minecraft.options, x, y, width);
        widget.setWidth(width);
        widget.x = x;
        widget.y = y;
        return widget;
    }
}
