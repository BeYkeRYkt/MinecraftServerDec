package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class PacketDecryptor extends MessageToMessageDecoder {

	private final gm a;

	public PacketDecryptor(Cipher var1) {
		this.a = new gm(var1);
	}

	protected void a(ChannelHandlerContext var1, ByteBuf var2, List var3) throws ShortBufferException {
		var3.add(this.a.a(var1, var2));
	}

	// $FF: synthetic method
	protected void decode(ChannelHandlerContext var1, Object var2, List var3) throws ShortBufferException {
		this.a(var1, (ByteBuf) var2, var3);
	}
}
