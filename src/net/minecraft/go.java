package net.minecraft;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class go extends MessageToByteEncoder {

	private final gm a;

	public go(Cipher var1) {
		this.a = new gm(var1);
	}

	protected void a(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws ShortBufferException {
		this.a.a(var2, var3);
	}

	// $FF: synthetic method
	protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws ShortBufferException {
		this.a(var1, (ByteBuf) var2, var3);
	}
}
