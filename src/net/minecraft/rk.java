package net.minecraft;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

class rk implements GenericFutureListener {

	// $FF: synthetic field
	final hy a;
	// $FF: synthetic field
	final rj b;

	rk(rj var1, hy var2) {
		this.b = var1;
		this.a = var2;
	}

	public void operationComplete(Future var1) {
		this.b.a.a((ho) this.a);
	}
}
