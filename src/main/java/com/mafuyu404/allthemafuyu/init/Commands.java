package com.mafuyu404.allthemafuyu.init;

import com.mafuyu404.allthemafuyu.utils.RaidUtils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;
import java.util.function.Consumer;

public class Commands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> MafuyuCommand =
                net.minecraft.commands.Commands.literal("mafuyu")
                        .requires(source -> source.hasPermission(2));

        MafuyuCommand.then(net.minecraft.commands.Commands.literal("raid")
                .then(net.minecraft.commands.Commands.argument("targets", EntityArgument.players())
                        .executes(ctx -> handleTarget(ctx, RaidUtils::create))));

        dispatcher.register(MafuyuCommand);
    }

    private static int handleTarget(CommandContext<CommandSourceStack> ctx, Consumer<ServerPlayer> action) throws CommandSyntaxException {
        Collection<ServerPlayer> targets = EntityArgument.getPlayers(ctx, "targets");
        for (ServerPlayer player : targets) {
            action.accept(player);
        }
        return targets.size();
    }
}
