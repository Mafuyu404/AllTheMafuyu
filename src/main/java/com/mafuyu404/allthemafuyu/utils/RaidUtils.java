package com.mafuyu404.allthemafuyu.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raids;

public class RaidUtils {
    public static void create(ServerPlayer player) {
        BlockPos blockPos = player.blockPosition();
        if (!player.serverLevel().isRaided(blockPos)) {
            Raids raids = player.serverLevel().getRaids();
            Raid raid = raids.createOrExtendRaid(player);
            if (raid != null) {
                MobEffectInstance badOmen = player.getEffect(MobEffects.BAD_OMEN);
                raid.setBadOmenLevel(badOmen == null ? 1 : badOmen.getAmplifier());
                raids.setDirty();
            }
        }
    }
}
