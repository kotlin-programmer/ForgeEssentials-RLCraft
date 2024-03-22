package com.forgeessentials.commands.player;

import com.forgeessentials.core.commands.ForgeEssentialsCommandBuilder;
import com.forgeessentials.util.WorldUtil;
import com.forgeessentials.util.output.ChatOutputHandler;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import org.jetbrains.annotations.NotNull;

public class CommandFly extends ForgeEssentialsCommandBuilder
{
    public CommandFly(boolean enabled)
    {
        super(enabled);
    }

    @Override
    public @NotNull String getPrimaryAlias()
    {
        return "fly";
    }

    @Override
    public boolean canConsoleUseCommand()
    {
        return false;
    }

    @Override
    public DefaultPermissionLevel getPermissionLevel()
    {
        return DefaultPermissionLevel.OP;
    }

    public LiteralArgumentBuilder<CommandSourceStack> setExecution()
    {
        return baseBuilder
                .then(Commands.argument("toggle", BoolArgumentType.bool())
                        .executes(CommandContext -> execute(CommandContext, "set")))
                .executes(CommandContext -> execute(CommandContext, "toggle"));
    }

    @Override
    public int processCommandPlayer(CommandContext<CommandSourceStack> ctx, String params) throws CommandSyntaxException
    {
        ServerPlayer player = (ServerPlayer) ctx.getSource().getEntity();
        if (params.equals("toggle"))
        {
            player.getAbilities().mayfly = !player.getAbilities().mayfly;
        }
        else
        {
            player.abilities.mayfly = BoolArgumentType.getBool(ctx, "toggle");
        }

        if (!player.isOnGround())
            player.abilities.flying = player.abilities.mayfly;
        if (!player.abilities.mayfly)
            WorldUtil.placeInWorld(player);
        player.onUpdateAbilities();
        ChatOutputHandler.chatNotification(player, "Flying " + (player.abilities.mayfly ? "enabled" : "disabled"));
        return Command.SINGLE_SUCCESS;
    }
}
