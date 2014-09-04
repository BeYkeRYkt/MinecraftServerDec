package net.minecraft;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.channel.local.LocalEventLoopGroup;

final class gt extends up {

	protected LocalEventLoopGroup a() {
		return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
	}

	// $FF: synthetic method
	protected Object b() {
		return this.a();
	}
}
