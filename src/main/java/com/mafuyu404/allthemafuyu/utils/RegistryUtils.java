package com.mafuyu404.allthemafuyu.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryUtils {
    public static String getItemRegistryName(Item item) {
        if (item == null) {
            return null;
        }

        ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
        if (registryName == null) {
            return null;
        }

        return registryName.toString();
    }
}
