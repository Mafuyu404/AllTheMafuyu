package com.mafuyu404.allthemafuyu.compat.kubejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.rhino.util.wrap.TypeWrappers;

public class MafuyuJSPlugin extends KubeJSPlugin {

    public void registerEvents() {
        MafuyuEvents.GROUP.register();
    }

    @Override
    public void registerBindings(BindingsEvent event) {

    }


    @Override
    public void registerTypeWrappers(ScriptType type, TypeWrappers typeWrappers) {

    }
}
