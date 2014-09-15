package net.minecraft;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

public class PacketSplitter extends ByteToMessageDecoder {

	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) {
		byteBuf.markReaderIndex();
		byte[] abyte = new byte[3];

		for (int i = 0; i < abyte.length; ++i) {
			if (!byteBuf.isReadable()) {
				byteBuf.resetReaderIndex();
				return;
			}

			abyte[i] = byteBuf.readByte();
			if (abyte[i] >= 0) {
				PacketDataSerializer serializer = new PacketDataSerializer(Unpooled.wrappedBuffer(abyte));

				try {
					int j = serializer.readVarInt();
					if (byteBuf.readableBytes() < j) {
						byteBuf.resetReaderIndex();
						return;
					}

					list.add(byteBuf.readBytes(j));
				} finally {
					serializer.release();
				}

				return;
			}
		}

		throw new CorruptedFrameException("length wider than 21-bit");
	}

}
