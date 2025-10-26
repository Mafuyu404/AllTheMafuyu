package com.mafuyu404.allthemafuyu.compat.kubejs;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface MafuyuEvents {

    EventGroup GROUP = EventGroup.of("MafuyuEvents");

    EventHandler VARIED_MODEL = GROUP.client("modifyVariedModel", () -> VariedModelModifyEventJS.class);

}
