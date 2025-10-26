package com.mafuyu404.allthemafuyu.compat.kubejs;

import com.mafuyu404.allthemafuyu.init.VariedModelEvent;
import net.minecraftforge.fml.ModList;

public class KubeJSCompat {
    private static final String MOD_ID = "kubejs";
    private static boolean INSTALLED = false;

    public static void init() {
        INSTALLED = ModList.get().isLoaded(MOD_ID);
    }

    public static VariedModelEvent variedModel(VariedModelEvent event) {
        if (INSTALLED) {
            return KubeJSCompatInner.variedModel(event);
        }
        return event;
    }
}
