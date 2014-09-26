package net.minecraft;

import net.minecraft.util.io.netty.channel.nio.NioEventLoopGroup;

public abstract class ConnectionNioEventLoopGroup {

	private NioEventLoopGroup group;
	private boolean initialized = false;

	public NioEventLoopGroup getGroup() {
		if (!this.initialized) {
			this.initialized = true;
			this.group = this.createGroup();
		}
		return this.group;
	}

	protected abstract NioEventLoopGroup createGroup();

}
