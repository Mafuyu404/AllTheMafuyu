package com.mafuyu404.allthemafuyu.event;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import com.mafuyu404.allthemafuyu.config.Config;
import com.mafuyu404.allthemafuyu.utils.ItemStackUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Allthemafuyu.MODID)
public class MerrySnow {
    @SubscribeEvent
    public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
        if (!Config.MerrySnow.MERRY_SNOW_WEATHER.get()) return;
        if (event.getSpawnType() != MobSpawnType.NATURAL) return;

        BlockPos blockPos = event.getEntity().blockPosition();
        Biome biome = event.getLevel().getBiome(blockPos).get();
        MobCategory category = event.getEntity().getClassification(false);

        boolean isSnowing = biome.getPrecipitationAt(blockPos).equals(Biome.Precipitation.SNOW);
        boolean isMonster = !category.isFriendly() && !category.isPersistent();

        if (isSnowing && isMonster) {
//            Allthemafuyu.LOGGER.warn("Prevent spawning: {}", event.getEntity());
            event.setSpawnCancelled(true);
        }
    }
}
