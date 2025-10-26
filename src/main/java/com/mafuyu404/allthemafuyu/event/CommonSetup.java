package com.mafuyu404.allthemafuyu.event;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import com.mafuyu404.allthemafuyu.compat.kubejs.KubeJSCompat;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Allthemafuyu.MODID)
public class CommonSetup {
    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        event.enqueueWork(KubeJSCompat::init);
    }
}
