package com.mafuyu404.allthemafuyu.api;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public interface IModelManager {
    Map<ResourceLocation, BakedModel> getBakedRegistry();
}
