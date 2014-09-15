package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.MessageToByteEncoder;

public class PacketPrepender extends MessageToByteEncoder<ByteBuf> {

	protected void encode(ChannelHandlerContext ctx, ByteBuf byteBuf1, ByteBuf byteBuf2) {
		int length = byteBuf1.readableBytes();
		int j = PacketDataSerializer.getPrependLength(length);
		if (j > 3) {
			throw new IllegalArgumentException("unable to fit " + length + " into " + 3);
		} else {
			PacketDataSerializer serializer = new PacketDataSerializer(byteBuf2);
			serializer.ensureWritable(j + length);
			serializer.writeVarInt(length);
			serializer.writeBytes(byteBuf1, byteBuf1.readerIndex(), length);
		}
	}

}
