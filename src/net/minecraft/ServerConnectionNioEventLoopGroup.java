package net.minecraft;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import net.minecraft.util.io.netty.channel.nio.NioEventLoopGroup;

final class ServerConnectionNioEventLoopGroup extends ConnectionNioEventLoopGroup {

	protected NioEventLoopGroup createGroup() {
		return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
	}

}
