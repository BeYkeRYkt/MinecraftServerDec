package net.minecraft;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;

class rr implements ChannelFutureListener {

	// $FF: synthetic field
	final rq a;

	rr(rq var1) {
		this.a = var1;
	}

	public void a(ChannelFuture var1) {
		this.a.a.setCompression(rq.a(this.a).getCompressionThreshold());
	}

	// $FF: synthetic method
	public void operationComplete(ChannelFuture var1) {
		this.a((ChannelFuture) var1);
	}
}
