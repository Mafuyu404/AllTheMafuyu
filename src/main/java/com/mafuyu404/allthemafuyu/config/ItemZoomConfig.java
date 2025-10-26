package com.mafuyu404.allthemafuyu.config;

import com.mafuyu404.allthemafuyu.utils.RegistryUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ItemZoomConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE;
    public static ForgeConfigSpec.ConfigValue<Boolean> DISABLE_FIRST_PERSONAL;
    public static ForgeConfigSpec.ConfigValue<Float> SCALE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WHITELIST;

    public static void init(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("ItemZoomConfig");

        ENABLE = BUILDER
                .comment("是否启用物品尺寸缩放。")
                .define("enable", false);
        DISABLE_FIRST_PERSONAL = BUILDER
                .comment("不会对第一人称下自己手中的物品生效。")
                .define("DisableFirstPersonal", false);
        SCALE = BUILDER
                .comment("缩放系数。")
                .define("scale", 3.0f);
        WHITELIST = BUILDER
                .comment("白名单里填物品ID。如果不为空，则只对填上的物品生效。")
                .defineList("Whitelist",
                        List.of(),
                        entry -> entry instanceof String
                );

        BUILDER.pop();
    }

    public static boolean checkItemValid(ItemStack itemStack) {
        if (WHITELIST.get().isEmpty()) return true;
        String id = RegistryUtils.getItemRegistryName(itemStack.getItem());
        return WHITELIST.get().contains(id);
    }
}