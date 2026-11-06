package org.daylight.config;


import net.minecraftforge.common.ForgeConfigSpec;

public class MouseLockConfig {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue TEXT_SIZE;
    public static final ForgeConfigSpec.IntValue TEXT_HORIZONTAL_POS;
    public static final ForgeConfigSpec.IntValue TEXT_VERTICAL_POS;
    public static final ForgeConfigSpec.BooleanValue REACT_TO_HOTBAR_HEIGHT;
    public static final ForgeConfigSpec.BooleanValue RESET_ON_WORLD_CHANGE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

//        builder.push("overlay");

        TEXT_SIZE = builder
                .comment("Scale percent multiplier for the \"Mouse Locked\" overlay text.")
                .defineInRange("textSize", 100, 20, 200);

        TEXT_HORIZONTAL_POS = builder
                .comment("Horizontal position of the overlay text")
                .defineInRange("textHorizontalPos", 50, 0, 100);

        TEXT_VERTICAL_POS = builder
                .comment("Vertical position of the overlay text")
                .defineInRange("textVerticalPos", 80, 0, 100);

        REACT_TO_HOTBAR_HEIGHT = builder
                .comment("If true, the overlay text automatically shifts down in game modes without a health bar")
                .define("reactToHotbarHeight", true);

        RESET_ON_WORLD_CHANGE = builder
                .comment("Reset lock state when leaving or switching worlds")
                .define("resetOnWorldChange", true);

//        builder.pop();

        SPEC = builder.build();
    }
}
