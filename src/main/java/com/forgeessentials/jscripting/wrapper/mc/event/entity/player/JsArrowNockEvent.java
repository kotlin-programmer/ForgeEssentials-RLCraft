package com.forgeessentials.jscripting.wrapper.mc.event.entity.player;

import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class JsArrowNockEvent extends JsPlayerEvent<ArrowNockEvent> {

	@SubscribeEvent
	public final void _handle(ArrowNockEvent event) {
		_callEvent(event);
	}

}
