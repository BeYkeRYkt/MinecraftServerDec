package net.minecraft;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.io.netty.channel.ChannelFuture;
import net.minecraft.util.io.netty.channel.ChannelFutureListener;

class CompressionEnableListener implements ChannelFutureListener {

	final LoginListener loginListener;

	protected CompressionEnableListener(LoginListener listener) {
		this.loginListener = listener;
	}

	public void operationComplete(ChannelFuture var1) {
		this.loginListener.networkManager.setCompression(MinecraftServer.getInstance().getCompressionThreshold());
	}

}
