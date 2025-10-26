package com.mafuyu404.allthemafuyu.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MerrySnowConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> MERRY_POWDER_SNOW;
    public static ForgeConfigSpec.ConfigValue<Boolean> MERRY_SNOW_WEATHER;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("MerrySnowConfig");

        MERRY_POWDER_SNOW = BUILDER
                .comment("细雪有台阶碰撞箱且无冷冻伤害。")
                .define("merryPowderSnow", true);
        MERRY_SNOW_WEATHER = BUILDER
                .comment("下雪区块不刷怪。")
                .define("merrySnowWeather", true);

        BUILDER.pop();
    }
}
