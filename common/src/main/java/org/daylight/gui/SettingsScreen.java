package org.daylight.gui;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.daylight.config.MouseLockConfig;

public class SettingsScreen extends Screen {
    private final Screen parent;

    // Константы для симметричной сетки
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
        int leftX = (this.width - ROW_WIDTH) / 2; // Левый край всего блока
        int widgetX = leftX + TEXT_WIDTH + GAP;   // Позиция для кнопок справа
        int y = 40;
        int step = 25;

        // 1. Text Size
        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_SIZE, 20, 200));
        y += step;
        // 2. Text Horizontal Pos
        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_HORIZONTAL_POS, 0, 100));
        y += step;
        // 3. Text Vertical Pos
        this.addRenderableWidget(createIntSlider(widgetX, y, WIDGET_WIDTH, MouseLockConfig.TEXT_VERTICAL_POS, 0, 100));
        y += step;

        // 4. React to Hotbar
        CycleButton<Boolean> reactBtn = CycleButton.onOffBuilder(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get())
                .create(widgetX, y, WIDGET_WIDTH, 20, Component.empty(),
                        (btn, v) -> {
                            MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.set(v);
                            btn.setMessage(Component.literal(v ? "ON" : "OFF"));
                        });
        reactBtn.setMessage(Component.literal(MouseLockConfig.REACT_TO_HOTBAR_HEIGHT.get() ? "ON" : "OFF"));
        this.addRenderableWidget(reactBtn);
        y += step;

        // 5. Reset on Leaving a World
        CycleButton<Boolean> resetBtn = CycleButton.onOffBuilder(MouseLockConfig.RESET_ON_WORLD_CHANGE.get())
                .create(widgetX, y, WIDGET_WIDTH, 20, Component.empty(),
                        (btn, v) -> {
                            MouseLockConfig.RESET_ON_WORLD_CHANGE.set(v);
                            btn.setMessage(Component.literal(v ? "ON" : "OFF"));
                        });
        resetBtn.setMessage(Component.literal(MouseLockConfig.RESET_ON_WORLD_CHANGE.get() ? "ON" : "OFF"));
        this.addRenderableWidget(resetBtn);

        // Кнопка "Done"
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, b -> {
            MouseLockConfig.SPEC.save();
            this.minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 - 100, this.height - 27, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);

        int leftX = (this.width - ROW_WIDTH) / 2;
        int textX = leftX + 5; // Небольшой отступ от края
        int y = 45;
        int step = 25;

        // Текст рисуется слева, привязываясь к общей сетке
        graphics.drawString(this.font, Component.translatable("mouselock.configuration.textSize"), textX, y, 0xFFFFFF, false);
        y += step;
        graphics.drawString(this.font, Component.translatable("mouselock.configuration.textHorizontalPos"), textX, y, 0xFFFFFF, false);
        y += step;
        graphics.drawString(this.font, Component.translatable("mouselock.configuration.textVerticalPos"), textX, y, 0xFFFFFF, false);
        y += step;
        graphics.drawString(this.font, Component.translatable("mouselock.configuration.reactToHotbarHeight"), textX, y, 0xFFFFFF, false);
        y += step;
        graphics.drawString(this.font, Component.translatable("mouselock.configuration.resetOnWorldChange"), textX, y, 0xFFFFFF, false);

        graphics.drawCenteredString(this.font, this.title, this.width / 2, 15, 0xFFFFFF);
    }

    @Override
    public void onClose() {
        MouseLockConfig.SPEC.save();
        this.minecraft.setScreen(this.parent);
    }

    private AbstractWidget createIntSlider(int x, int y, int width, ModConfigSpec.IntValue configValue, int min, int max) {
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
        widget.setX(x);
        widget.setY(y);
        return widget;
    }
}
