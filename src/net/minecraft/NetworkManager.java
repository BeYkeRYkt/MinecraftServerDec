package net.minecraft;

import com.google.common.collect.Queues;

import net.minecraft.util.io.netty.channel.Channel;
import net.minecraft.util.io.netty.channel.ChannelFuture;
import net.minecraft.util.io.netty.channel.ChannelFutureListener;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.util.io.netty.channel.local.LocalChannel;
import net.minecraft.util.io.netty.channel.local.LocalServerChannel;
import net.minecraft.util.io.netty.util.AttributeKey;
import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;

import java.net.SocketAddress;
import java.util.Queue;

import javax.crypto.SecretKey;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NetworkManager extends SimpleChannelInboundHandler<Packet<PacketListener>> {

	private static final Logger logger = LogManager.getLogger();
	public static final Marker markerNetwork = MarkerManager.getMarker("NETWORK");
	public static final Marker markerNetworkPackets = MarkerManager.getMarker("NETWORK_PACKETS", markerNetwork);
	public static final AttributeKey<EnumProtocol> attributeKey = new AttributeKey<EnumProtocol>("protocol");
	private final Queue<QueuedPacket> outPacketQueue = Queues.newConcurrentLinkedQueue();
	private Channel channel;
	private SocketAddress address;
	private PacketListener listener;
	private IChatBaseComponent disconnectMessage;
	private boolean closed;

	public NetworkManager(PacketDirection direction) {
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		this.channel = ctx.channel();
		this.address = this.channel.remoteAddress();

		try {
			this.setProtocolState(EnumProtocol.HANDSHAKING);
		} catch (Throwable t) {
			logger.fatal(t);
		}

	}

	public void setProtocolState(EnumProtocol protocol) {
		this.channel.attr(attributeKey).set(protocol);
		this.channel.config().setAutoRead(true);
		logger.debug("Enabled auto read");
	}

	public void channelInactive(ChannelHandlerContext ctx) {
		this.disconnect(new ChatMessage("disconnect.endOfStream", new Object[0]));
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
		logger.debug("Disconnecting " + this.getAddress(), t);
		this.disconnect(new ChatMessage("disconnect.genericReason", new Object[] { "Internal Exception: " + t }));
	}

	protected void channelRead0(ChannelHandlerContext ctx, Packet<PacketListener> packet) {
		if (this.channel.isOpen()) {
			try {
				packet.handlePacket(this.listener);
			} catch (UhandledPacketException e) {
			}
		}
	}

	public void setPacketListener(PacketListener listener) {
		Validate.notNull(listener, "packetListener", new Object[0]);
		logger.debug("Set listener of {} to {}", new Object[] { this, listener });
		this.listener = listener;
	}

	public void handleSendPacket(Packet<? extends PacketListener> packet) {
		if (this.channel != null && this.channel.isOpen()) {
			this.sendQueuedPacket();
			this.handleSendPacket0(packet, (GenericFutureListener<? extends Future<? super Void>>) null);
		} else {
			this.outPacketQueue.add(new QueuedPacket(packet, (GenericFutureListener<? extends Future<? super Void>>) null));
		}

	}

	public void handleSendPacket(Packet<? extends PacketListener> packet, GenericFutureListener<? extends Future<? super Void>> listener) {
		if (this.channel != null && this.channel.isOpen()) {
			this.sendQueuedPacket();
			this.handleSendPacket0(packet, listener);
		} else {
			this.outPacketQueue.add(new QueuedPacket(packet, listener));
		}

	}

	private void handleSendPacket0(Packet<? extends PacketListener> packet, GenericFutureListener<? extends Future<? super Void>> futureListener) {
		EnumProtocol packetProtocolState = EnumProtocol.getByPacket(packet);
		EnumProtocol channelProtocolState = (EnumProtocol) this.channel.attr(attributeKey).get();
		if (channelProtocolState != packetProtocolState) {
			logger.debug("Disabled auto read");
			this.channel.config().setAutoRead(false);
		}

		if (this.channel.eventLoop().inEventLoop()) {
			if (packetProtocolState != channelProtocolState) {
				this.setProtocolState(packetProtocolState);
			}

			ChannelFuture channelFuture = this.channel.writeAndFlush(packet);
			if (futureListener != null) {
				channelFuture.addListener(futureListener);
			}

			channelFuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
		} else {
			this.channel.eventLoop().execute(new QueuedProtocolSwitch(this, packetProtocolState, channelProtocolState, packet, futureListener));
		}
	}

	private void sendQueuedPacket() {
		if (this.channel != null && this.channel.isOpen()) {
			while (!this.outPacketQueue.isEmpty()) {
				QueuedPacket queuedPacket = this.outPacketQueue.poll();
				this.handleSendPacket0(queuedPacket.getPacket(), queuedPacket.getListener());
			}
		}
	}

	public void sendAndFlushQueuedPacket() {
		this.sendQueuedPacket();
		if (this.listener instanceof ITickable) {
			((ITickable) this.listener).doTick();
		}
		this.channel.flush();
	}

	public SocketAddress getAddress() {
		return this.address;
	}

	public void disconnect(IChatBaseComponent disconnectMessage) {
		if (this.channel.isOpen()) {
			this.channel.close().awaitUninterruptibly();
			this.disconnectMessage = disconnectMessage;
		}

	}

	public boolean isLocal() {
		return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
	}

	public void setEncryption(SecretKey var1) {
		this.channel.pipeline().addBefore("splitter", "decrypt", new PacketDecryptor(ServerCryptoUtils.a(2, var1)));
		this.channel.pipeline().addBefore("prepender", "encrypt", new PacketEncryptor(ServerCryptoUtils.a(1, var1)));
	}

	public boolean isConnected() {
		return this.channel != null && this.channel.isOpen();
	}

	public boolean hasChannel() {
		return this.channel == null;
	}

	public PacketListener getPacketListener() {
		return this.listener;
	}

	public IChatBaseComponent getDisconnectMessage() {
		return this.disconnectMessage;
	}

	public void disableAutoRead() {
		this.channel.config().setAutoRead(false);
	}

	public void setCompression(int threshold) {
		if (threshold >= 0) {
			if (this.channel.pipeline().get("decompress") instanceof PacketDecompressor) {
				((PacketDecompressor) this.channel.pipeline().get("decompress")).setCompressionThreshold(threshold);
			} else {
				this.channel.pipeline().addBefore("decoder", "decompress", new PacketDecompressor(threshold));
			}

			if (this.channel.pipeline().get("compress") instanceof PacketCompressor) {
				((PacketCompressor) this.channel.pipeline().get("decompress")).setCompressionThreshold(threshold);
			} else {
				this.channel.pipeline().addBefore("encoder", "compress", new PacketCompressor(threshold));
			}
		} else {
			if (this.channel.pipeline().get("decompress") instanceof PacketDecompressor) {
				this.channel.pipeline().remove("decompress");
			}

			if (this.channel.pipeline().get("compress") instanceof PacketCompressor) {
				this.channel.pipeline().remove("compress");
			}
		}
	}

	public void closeChannel() {
		if (!this.hasChannel() && !this.isConnected() && !this.closed) {
			this.closed = true;
			if (this.getDisconnectMessage() != null) {
				this.getPacketListener().handle(this.getDisconnectMessage());
			} else if (this.getPacketListener() != null) {
				this.getPacketListener().handle(new ChatComponentText("Disconnected"));
			}
		}
	}

	protected Channel getChannel() {
		return channel;
	}

}
