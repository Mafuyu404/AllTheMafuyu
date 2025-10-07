package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.config.Config;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {

    @Inject(method = "renderItem", at = @At("HEAD"))
    private void onRenderItem(LivingEntity entity, ItemStack stack,
                              ItemDisplayContext displayContext, boolean leftHanded,
                              PoseStack poseStack, MultiBufferSource buffer,
                              int light, CallbackInfo ci) {
        if (!Config.ItemZoom.ENABLE.get()) return;
        Minecraft mc = Minecraft.getInstance();
        if (Config.ItemZoom.DISABLE_FIRST_PERSONAL.get() && entity.getUUID().equals(mc.player.getUUID()) && mc.options.getCameraType().isFirstPerson()) return;
        if (Config.ItemZoom.checkItemValid(stack)) {
            poseStack.pushPose();
            poseStack.scale(2.0F, 2.0F, 2.0F);
        }
    }

    @Inject(method = "renderItem", at = @At("RETURN"))
    private void afterRenderItem(LivingEntity entity, ItemStack stack,
                                 ItemDisplayContext displayContext, boolean leftHanded,
                                 PoseStack poseStack, MultiBufferSource buffer,
                                 int light, CallbackInfo ci) {
        if (!Config.ItemZoom.ENABLE.get()) return;
        Minecraft mc = Minecraft.getInstance();
        if (Config.ItemZoom.DISABLE_FIRST_PERSONAL.get() && entity.getUUID().equals(mc.player.getUUID()) && mc.options.getCameraType().isFirstPerson()) return;
        if (Config.ItemZoom.checkItemValid(stack)) {
            poseStack.popPose();
        }
    }
}
