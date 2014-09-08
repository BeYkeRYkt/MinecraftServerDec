package net.minecraft;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

class QueuedProtocolSwitch implements Runnable {

	final EnumProtocol packetProtocolState;
	final EnumProtocol channelProtocolState;
	final Packet<? extends PacketListener> packet;
	final GenericFutureListener<? extends Future<? super Void>> futureListener;
	final NetworkManager networkManager;

	QueuedProtocolSwitch(NetworkManager networkManager, EnumProtocol packetProtocolState, EnumProtocol channelProtocolState, Packet<? extends PacketListener> var4, GenericFutureListener<? extends Future<? super Void>> futureListener) {
		this.networkManager = networkManager;
		this.packetProtocolState = packetProtocolState;
		this.channelProtocolState = channelProtocolState;
		this.packet = var4;
		this.futureListener = futureListener;
	}

	public void run() {
		if (this.packetProtocolState != this.channelProtocolState) {
			this.networkManager.setProtocolState(this.packetProtocolState);
		}

		ChannelFuture channelFuture = networkManager.getChannel().writeAndFlush(this.packet);
		if (this.futureListener != null) {
			channelFuture.addListener(this.futureListener);
		}

		channelFuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
	}

}
