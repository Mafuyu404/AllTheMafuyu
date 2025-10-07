package com.mafuyu404.allthemafuyu;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Allthemafuyu.MODID)
public class Allthemafuyu {

    public static final String MODID = "allthemafuyu";

    public Allthemafuyu() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
