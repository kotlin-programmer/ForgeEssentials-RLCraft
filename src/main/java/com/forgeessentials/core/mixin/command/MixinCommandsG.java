package com.forgeessentials.core.mixin.command;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;

@Mixin(Commands.class)
public class MixinCommandsG<S>
{
    @Redirect(method = "performCommand", at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/CommandDispatcher;parse(Lcom/mojang/brigadier/StringReader;Ljava/lang/Object;)Lcom/mojang/brigadier/ParseResults;", remap = false))
    public ParseResults<S> performCommand(CommandDispatcher<S> instance, StringReader command, S source)
    {
        if (source instanceof CommandSource && ((CommandSource) source).getEntity() != null)
        {
            source = (S) new CommandSource(((CommandSource) source).getEntity(), ((CommandSource) source).getPosition(), ((CommandSource) source).getRotation(),
                    ((CommandSource) source).getLevel(), 4, ((CommandSource) source).getTextName(),
                    ((CommandSource) source).getDisplayName(), ((CommandSource) source).getServer(), ((CommandSource) source).getEntity());
        }
        return instance.parse(command, source);
    }
}
