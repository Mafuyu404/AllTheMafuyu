package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PowderSnowBlock.class)
public class PowderSnowBlockMixin {
    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    private void merry(BlockState p_154285_, BlockGetter p_154286_, BlockPos p_154287_, CollisionContext p_154288_, CallbackInfoReturnable<VoxelShape> cir) {
        if (!Config.MerrySnow.MERRY_POWDER_SNOW.get()) return;
        cir.setReturnValue(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
    }
}
