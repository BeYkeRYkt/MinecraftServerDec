package net.minecraft;

import net.minecraft.server.MinecraftServer;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

class CompressionEnableListener implements ChannelFutureListener {

	final LoginListener loginListener;

	protected CompressionEnableListener(LoginListener listener) {
		this.loginListener = listener;
	}

	public void operationComplete(ChannelFuture var1) {
		this.loginListener.networkManager.setCompression(MinecraftServer.getInstance().getCompressionThreshold());
	}

}
