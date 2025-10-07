package com.mafuyu404.allthemafuyu.compat.kubejs;

import com.mafuyu404.allthemafuyu.event.VariedModelModifyEvent;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface MafuyuEvents {

    EventGroup GROUP = EventGroup.of("MafuyuEvents");

    EventHandler VARIED_MODEL = GROUP.client("modifyVariedModel", () -> VariedModelModifyEvent.class);

}
