package com.mafuyu404.allthemafuyu.api;

import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public interface IModelBakery {
    Map<ResourceLocation, UnbakedModel> getUnbakedCache();
}
