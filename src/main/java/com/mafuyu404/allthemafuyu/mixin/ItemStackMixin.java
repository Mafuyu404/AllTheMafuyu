package com.mafuyu404.allthemafuyu.mixin;

import com.mafuyu404.allthemafuyu.api.IItemStack;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.*;

@Mixin(value = ItemStack.class)
@Implements(@Interface(iface = IItemStack.class, prefix = "lazy$"))
public class ItemStackMixin implements IItemStack {
    @Unique
    private String variedModelCache;

    public String getVariedModelCache() {
        return variedModelCache;
    }

    public void setVariedModelCache(String variedModelCache) {
        this.variedModelCache = variedModelCache;
    }
}
