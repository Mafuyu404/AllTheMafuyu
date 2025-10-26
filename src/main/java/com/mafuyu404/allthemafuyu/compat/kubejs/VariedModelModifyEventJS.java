package com.mafuyu404.allthemafuyu.compat.kubejs;

import com.mafuyu404.allthemafuyu.utils.ItemStackUtils;
import dev.latvian.mods.kubejs.client.ClientInitEventJS;
import net.minecraft.world.item.ItemStack;

public class VariedModelModifyEventJS extends ClientInitEventJS {
    private final ItemStack itemStack;
    private String modelPath = null;

    public VariedModelModifyEventJS(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getModelPath() {
        return this.modelPath;
    }

    public String getVariedModelCache() {
        return ItemStackUtils.getVariedModelCache(itemStack);
    }

    public void setVariedModelCache(String path) {
        ItemStackUtils.setVariedModelCache(itemStack, path);
    }
}
