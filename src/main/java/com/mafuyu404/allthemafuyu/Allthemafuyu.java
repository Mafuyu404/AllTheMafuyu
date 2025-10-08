package com.mafuyu404.allthemafuyu;

import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Allthemafuyu.MODID)
public class Allthemafuyu {

    public static final String MODID = "allthemafuyu";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Allthemafuyu() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
