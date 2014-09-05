package net.minecraft;

import io.netty.util.concurrent.GenericFutureListener;

class gx {

	private final Packet a;
	private final GenericFutureListener[] b;

	public gx(Packet var1, GenericFutureListener... var2) {
		this.a = var1;
		this.b = var2;
	}

	// $FF: synthetic method
	static Packet a(gx var0) {
		return var0.a;
	}

	// $FF: synthetic method
	static GenericFutureListener[] b(gx var0) {
		return var0.b;
	}
}
