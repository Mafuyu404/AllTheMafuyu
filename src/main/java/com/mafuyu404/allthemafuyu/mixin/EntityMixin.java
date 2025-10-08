package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Entity.class)
public class EntityMixin {
    @Inject(method = "isFullyFrozen", at = @At("HEAD"), cancellable = true)
    private void merry(CallbackInfoReturnable<Boolean> cir) {
        if (!Config.MerrySnow.MERRY_POWDER_SNOW.get()) return;
        cir.setReturnValue(false);
    }
}
