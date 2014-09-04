package net.minecraft;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;

class rf extends ChannelInitializer {

	// $FF: synthetic field
	final ServerConnection a;

	rf(ServerConnection var1) {
		this.a = var1;
	}

	protected void initChannel(Channel var1) {
		try {
			var1.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
		} catch (ChannelException var4) {
			;
		}

		try {
			var1.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
		} catch (ChannelException var3) {
			;
		}

		var1.pipeline().addLast("timeout", (ChannelHandler) (new ReadTimeoutHandler(30))).addLast("legacy_query", (ChannelHandler) (new ra(this.a))).addLast("splitter", (ChannelHandler) (new hh())).addLast("decoder", (ChannelHandler) (new he(ie.a))).addLast("prepender", (ChannelHandler) (new hi())).addLast("encoder", (ChannelHandler) (new hf(ie.b)));
		gr var2 = new gr(ie.a);
		ServerConnection.a(this.a).add(var2);
		var1.pipeline().addLast("packet_handler", (ChannelHandler) var2);
		var2.a((hg) (new ro(ServerConnection.b(this.a), var2)));
	}
}
