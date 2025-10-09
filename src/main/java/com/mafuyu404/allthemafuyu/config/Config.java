package com.mafuyu404.allthemafuyu.config;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Allthemafuyu.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec SPEC;
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static class ItemZoom extends ItemZoomConfig {}
    public static class NoDamageBar extends NoDamageBarConfig {}
    public static class VariedModel extends VariedModelConfig {}
    public static class MerrySnow extends MerrySnowConfig {}
    public static class RaidAnywhere extends RaidAnywhereConfig {}

    static {
        ItemZoom.init(BUILDER);
        NoDamageBar.init(BUILDER);
        VariedModel.init(BUILDER);
        MerrySnow.init(BUILDER);
        RaidAnywhere.init(BUILDER);

        SPEC = BUILDER.build();
    }
}
