package net.minecraft;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
import net.minecraft.util.io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class PacketEncoder extends MessageToByteEncoder<Packet<? extends PacketListener>> {

	private static final Logger logger = LogManager.getLogger();
	private static final Marker marker = MarkerManager.getMarker("PACKET_SENT", NetworkManager.markerNetworkPackets);
	private final PacketDirection direction;

	public PacketEncoder(PacketDirection direction) {
		this.direction = direction;
	}

	protected void encode(ChannelHandlerContext ctx, Packet<? extends PacketListener> packet, ByteBuf byteBuf) throws IOException {
		Integer packetId = ((EnumProtocol) ctx.channel().attr(NetworkManager.attributeKey).get()).getPacketId(this.direction, packet);
		if (logger.isDebugEnabled()) {
			logger.debug(marker, "OUT: [{}:{}] {}", new Object[] { ctx.channel().attr(NetworkManager.attributeKey).get(), packetId, packet.getClass().getName() });
		}

		if (packetId == null) {
			throw new IOException("Can\'t serialize unregistered packet");
		} else {
			PacketDataSerializer serializer = new PacketDataSerializer(byteBuf);
			serializer.writeVarInt(packetId.intValue());

			try {
				packet.writeData(serializer);
			} catch (Throwable t) {
				logger.error(t);
			}

		}
	}

}
