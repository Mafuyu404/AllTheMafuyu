package com.mafuyu404.allthemafuyu.init;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

// VariedModelEvent.java
public class VariedModelEvent extends Event {
    private final ItemStack itemStack;
    private String modelPath = null;

    public VariedModelEvent(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String newPath) {
        this.modelPath = newPath;
    }
}