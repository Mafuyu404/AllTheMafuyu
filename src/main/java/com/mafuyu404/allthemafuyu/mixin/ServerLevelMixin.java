package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ServerLevel.class)
public class ServerLevelMixin {
    @Inject(method = "isVillage(Lnet/minecraft/core/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
    private void modify(BlockPos p_8803_, CallbackInfoReturnable<Boolean> cir) {
        if (!Config.RaidAnywhere.ENABLE.get()) return;
        if (checkRaid()) {
            cir.setReturnValue(true);
        }
    }

    private boolean checkRaid() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();

            if (className.contains("Raid")) {
                return true;
            }
        }
        return false;
    }
}
