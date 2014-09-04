package net.minecraft;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class hi extends MessageToByteEncoder {

	protected void a(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) {
		int var4 = var2.readableBytes();
		int var5 = hd.a(var4);
		if (var5 > 3) {
			throw new IllegalArgumentException("unable to fit " + var4 + " into " + 3);
		} else {
			hd var6 = new hd(var3);
			var6.ensureWritable(var5 + var4);
			var6.b(var4);
			var6.writeBytes(var2, var2.readerIndex(), var4);
		}
	}

	// $FF: synthetic method
	protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) {
		this.a(var1, (ByteBuf) var2, var3);
	}
}
