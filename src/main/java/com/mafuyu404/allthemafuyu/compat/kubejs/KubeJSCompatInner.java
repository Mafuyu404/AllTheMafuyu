package com.mafuyu404.allthemafuyu.compat.kubejs;

import com.mafuyu404.allthemafuyu.init.VariedModelEvent;

public class KubeJSCompatInner {
    public static VariedModelEvent variedModel(VariedModelEvent event) {
        VariedModelModifyEventJS e = new VariedModelModifyEventJS(event.getItemStack());
        MafuyuEvents.VARIED_MODEL.post(e);
        event.setModelPath(e.getModelPath());
        return event;
    }
}
