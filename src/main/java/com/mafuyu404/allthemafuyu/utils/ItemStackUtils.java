package com.mafuyu404.allthemafuyu.utils;

import com.mafuyu404.allthemafuyu.api.IItemStack;
import net.minecraft.world.item.ItemStack;

public class ItemStackUtils {
    public static void setVariedModelCache(ItemStack itemStack, String path) {
        ((IItemStack) (Object) itemStack).setVariedModelCache(path);
    }
    public static String getVariedModelCache(ItemStack itemStack) {
        return ((IItemStack) (Object) itemStack).getVariedModelCache();
    }
}
