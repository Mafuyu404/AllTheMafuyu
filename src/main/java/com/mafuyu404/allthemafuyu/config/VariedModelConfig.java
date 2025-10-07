package com.mafuyu404.allthemafuyu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class VariedModelConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("VariedModel");

        ENABLE = BUILDER
                .comment("是否自动读取所有闲置模型。")
                .define("enable", true);

        BUILDER.pop();
    }
}
