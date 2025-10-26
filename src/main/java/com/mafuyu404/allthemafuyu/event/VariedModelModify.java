package com.mafuyu404.allthemafuyu.event;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import com.mafuyu404.allthemafuyu.compat.kubejs.KubeJSCompat;
import com.mafuyu404.allthemafuyu.init.VariedModelEvent;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Allthemafuyu.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VariedModelModify {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void item(VariedModelEvent event) {
        var e = new VariedModelEvent(event.getItemStack());
        e = KubeJSCompat.variedModel(event);
        if (e.getModelPath() != null) event.setModelPath(e.getModelPath());
    }
}
