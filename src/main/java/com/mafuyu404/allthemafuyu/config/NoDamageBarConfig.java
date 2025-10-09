package com.mafuyu404.allthemafuyu.config;

import com.mafuyu404.allthemafuyu.utils.RegistryUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class NoDamageBarConfig {
        public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE;
        public static ForgeConfigSpec.ConfigValue<List<? extends String>> WHITELIST;

        public static void init(ForgeConfigSpec.Builder BUILDER) {
            BUILDER.push("NoDamageBarConfig");

            ENABLE = BUILDER
                    .comment("是否启用隐藏物品耐久条。")
                    .define("enable", false);
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