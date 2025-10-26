package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.api.IModelBakery;
import com.mafuyu404.allthemafuyu.event.VariedModelSetup;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = ModelBakery.class)
@Implements(@Interface(iface = IModelBakery.class, prefix = "lazy$"))
public class ModelBakeryMixin implements IModelBakery {
    @Shadow @Final private Map<ResourceLocation, UnbakedModel> unbakedCache;

    public Map<ResourceLocation, UnbakedModel> getUnbakedCache() {
        return unbakedCache;
    }

    @Inject(method = "loadTopLevel", at = @At("HEAD"))
    private void dd(ModelResourceLocation resourceLocation, CallbackInfo ci) {
        if (resourceLocation.getVariant().equals("inventory")) {
            VariedModelSetup.putRegistryCache(resourceLocation);
        }
    }
}
