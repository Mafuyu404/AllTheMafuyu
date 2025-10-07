package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.api.IModelManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(value = ModelManager.class)
@Implements(@Interface(iface = IModelManager.class, prefix = "lazy$"))
public class ModelManagerMixin implements IModelManager {
    @Shadow private Map<ResourceLocation, BakedModel> bakedRegistry;

    public Map<ResourceLocation, BakedModel> getBakedRegistry() {
        return bakedRegistry;
    }
}
