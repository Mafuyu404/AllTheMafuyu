package com.mafuyu404.allthemafuyu.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class VariedModelConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> LOAD_IDLE_MODEL;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> PRESET_MODEL;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("VariedModelConfig");

        LOAD_IDLE_MODEL = BUILDER
                .comment("是否自动读取所有闲置模型。")
                .define("loadIdleModel", false);
        PRESET_MODEL = BUILDER
                .comment("强制预加载的模型。")
                .defineList("PresetModel",
                        List.of(),
                        entry -> entry instanceof String
                );

        BUILDER.pop();
    }

    public static List<String> getPresetModel() {
        if (PRESET_MODEL.get().isEmpty()) return List.of();
        return new ArrayList<>(PRESET_MODEL.get());
    }
}
