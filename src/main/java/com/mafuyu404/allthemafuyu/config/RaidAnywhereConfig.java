package com.mafuyu404.allthemafuyu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RaidAnywhereConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("RaidAnywhereConfig");

        ENABLE = BUILDER
                .comment("使袭击的发生与村庄、村民或者工作方块再也没有关系。")
                .define("enable", false);

        BUILDER.pop();
    }
}
