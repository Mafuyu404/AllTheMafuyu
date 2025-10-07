package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class RemoveDamageBar {
    @Inject(method = "isBarVisible", at = @At("HEAD"), cancellable = true)
    private void aaa(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (Config.NoDamageBar.checkItemValid(itemStack)) cir.setReturnValue(false);
    }
}
