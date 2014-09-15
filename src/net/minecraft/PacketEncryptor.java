package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.MessageToByteEncoder;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class PacketEncryptor extends MessageToByteEncoder {

	private final gm a;

	public PacketEncryptor(Cipher var1) {
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
