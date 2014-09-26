package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.Unpooled;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.ByteToMessageDecoder;
import net.minecraft.util.io.netty.handler.codec.DecoderException;

import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class PacketDecompressor extends ByteToMessageDecoder {

	private final Inflater a;
	private int b;

	public PacketDecompressor(int var1) {
		this.b = var1;
		this.a = new Inflater();
	}

	protected void decode(ChannelHandlerContext var1, ByteBuf var2, List var3) throws DataFormatException {
		if (var2.readableBytes() != 0) {
			PacketDataSerializer var4 = new PacketDataSerializer(var2);
			int var5 = var4.readVarInt();
			if (var5 == 0) {
				var3.add(var4.readBytes(var4.readableBytes()));
			} else {
				if (var5 < this.b) {
					throw new DecoderException("Badly compressed packet - size of " + var5 + " is below server threshold of " + this.b);
				}

				if (var5 > 2097152) {
					throw new DecoderException("Badly compressed packet - size of " + var5 + " is larger than protocol maximum of " + 2097152);
				}

				byte[] var6 = new byte[var4.readableBytes()];
				var4.readBytes(var6);
				this.a.setInput(var6);
				byte[] var7 = new byte[var5];
				this.a.inflate(var7);
				var3.add(Unpooled.wrappedBuffer(var7));
				this.a.reset();
			}

		}
	}

	public void setCompressionThreshold(int var1) {
		this.b = var1;
	}
}
