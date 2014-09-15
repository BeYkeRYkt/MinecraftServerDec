package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.ByteToMessageDecoder;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class PacketDecoder extends ByteToMessageDecoder {

	private static final Logger logger = LogManager.getLogger();
	private static final Marker marker = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.markerNetworkPackets);
	private final PacketDirection direction;

	public PacketDecoder(PacketDirection direction) {
		this.direction = direction;
	}

	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws InstantiationException, IllegalAccessException, IOException {
		if (byteBuf.readableBytes() != 0) {
			PacketDataSerializer serializer = new PacketDataSerializer(byteBuf);
			int packetId = serializer.readVarInt();
			Packet<? extends PacketListener> packet = (ctx.channel().attr(NetworkManager.attributeKey).get()).createPacket(this.direction, packetId);
			if (packet == null) {
				throw new IOException("Bad packet id " + packetId);
			} else {
				packet.readData(serializer);
				if (serializer.readableBytes() > 0) {
					throw new IOException("Packet " + (ctx.channel().attr(NetworkManager.attributeKey).get()).getStateId() + "/" + packetId + " (" + packet.getClass().getSimpleName() + ") was larger than I expected, found " + serializer.readableBytes() + " bytes extra whilst reading packet " + packetId);
				} else {
					list.add(packet);
					if (logger.isDebugEnabled()) {
						logger.debug(marker, " IN: [{}:{}] {}", new Object[] { ctx.channel().attr(NetworkManager.attributeKey).get(), Integer.valueOf(packetId), packet.getClass().getName() });
					}

				}
			}
		}
	}

}
