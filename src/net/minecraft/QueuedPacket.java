package net.minecraft;

import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;

class QueuedPacket {

	private final Packet<? extends PacketListener> packet;
	private final GenericFutureListener<? extends Future<? super Void>> futureListener;

	public QueuedPacket(Packet<? extends PacketListener> packet, GenericFutureListener<? extends Future<? super Void>> futureListener) {
		this.packet = packet;
		this.futureListener = futureListener;
	}

	public Packet<? extends PacketListener> getPacket() {
		return packet;
	}

	public GenericFutureListener<? extends Future<? super Void>> getListener() {
		return futureListener;
	}

}
