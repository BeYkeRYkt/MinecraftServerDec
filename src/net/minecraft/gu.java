package net.minecraft;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.GenericFutureListener;

class gu implements Runnable {

	// $FF: synthetic field
	final EnumProtocol a;
	// $FF: synthetic field
	final EnumProtocol b;
	// $FF: synthetic field
	final id c;
	// $FF: synthetic field
	final GenericFutureListener[] d;
	// $FF: synthetic field
	final gr e;

	gu(gr var1, EnumProtocol var2, EnumProtocol var3, id var4, GenericFutureListener[] var5) {
		this.e = var1;
		this.a = var2;
		this.b = var3;
		this.c = var4;
		this.d = var5;
	}

	public void run() {
		if (this.a != this.b) {
			this.e.a(this.a);
		}

		ChannelFuture var1 = gr.a(this.e).writeAndFlush(this.c);
		if (this.d != null) {
			var1.addListeners(this.d);
		}

		var1.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
	}
}
