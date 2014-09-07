package net.minecraft;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

class rk implements GenericFutureListener {

	// $FF: synthetic field
	final ChatComponentText a;
	// $FF: synthetic field
	final PlayerConnection b;

	rk(PlayerConnection var1, ChatComponentText var2) {
		this.b = var1;
		this.a = var2;
	}

	public void operationComplete(Future var1) {
		this.b.a.a((IChatBaseComponent) this.a);
	}
}
