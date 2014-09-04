package net.minecraft;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.channel.nio.NioEventLoopGroup;

final class rd extends up {

	protected NioEventLoopGroup a() {
		return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
	}

	// $FF: synthetic method
	protected Object b() {
		return this.a();
	}
}
