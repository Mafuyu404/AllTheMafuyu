package com.mafuyu404.allthemafuyu.compat.kubejs;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import com.mafuyu404.allthemafuyu.init.VariedModelEvent;
import dev.latvian.mods.kubejs.client.ClientInitEventJS;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Allthemafuyu.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VariedModelModifyEvent extends ClientInitEventJS {
    @SubscribeEvent
    public static void item(VariedModelEvent event) {
        var e = new VariedModelModifyEvent(event.getItemStack());
        MafuyuEvents.VARIED_MODEL.post(e);
        if (e.modelPath != null) event.setModelPath(e.modelPath);

//        if (event.getItemStack().is(Items.APPLE)) {
//            event.setModelPath("allthemafuyu:stalker_core");
//        }
    }

    private final ItemStack itemStack;
    private String modelPath = null;

    public VariedModelModifyEvent(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }
}
