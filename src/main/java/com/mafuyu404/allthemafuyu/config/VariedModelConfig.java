package com.mafuyu404.allthemafuyu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class VariedModelConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> LOAD_IDLE_MODEL;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("VariedModel");

        LOAD_IDLE_MODEL = BUILDER
                .comment("是否自动读取所有闲置模型。")
                .define("loadIdleModel", true);

        BUILDER.pop();
    }
}
