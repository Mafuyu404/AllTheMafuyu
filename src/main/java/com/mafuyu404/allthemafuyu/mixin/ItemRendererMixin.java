package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.init.VariedModelEvent;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow @Final private ItemModelShaper itemModelShaper;

    @Inject(
            method = "getModel",
            at = @At("RETURN"),
            cancellable = true
    )
    private void onGetModel(ItemStack itemStack, @Nullable Level level, @Nullable LivingEntity entity, int seed, CallbackInfoReturnable<BakedModel> cir) {
        VariedModelEvent event = new VariedModelEvent(itemStack);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.getModelPath() != null) {
            ModelResourceLocation resourceLocation = new ModelResourceLocation(new ResourceLocation(event.getModelPath()), "inventory");
            BakedModel newModel = this.itemModelShaper.getModelManager().getModel(resourceLocation);
            cir.setReturnValue(newModel);
        }
    }
}