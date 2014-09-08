package net.minecraft;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class PacketEncoder extends MessageToByteEncoder {

	private static final Logger a = LogManager.getLogger();
	private static final Marker b = MarkerManager.getMarker("PACKET_SENT", NetworkManager.markerNetworkPackets);
	private final PacketDirection c;

	public PacketEncoder(PacketDirection var1) {
		this.c = var1;
	}

	protected void a(ChannelHandlerContext var1, Packet var2, ByteBuf var3) throws IOException {
		Integer var4 = ((EnumProtocol) var1.channel().attr(NetworkManager.attributeKey).get()).getPacketId(this.c, var2);
		if (a.isDebugEnabled()) {
			a.debug(b, "OUT: [{}:{}] {}", new Object[] { var1.channel().attr(NetworkManager.attributeKey).get(), var4, var2.getClass().getName() });
		}

		if (var4 == null) {
			throw new IOException("Can\'t serialize unregistered packet");
		} else {
			PacketDataSerializer var5 = new PacketDataSerializer(var3);
			var5.writeVarInt(var4.intValue());

			try {
				if (var2 instanceof PacketPlayOutSpawnPlayer) {
					var2 = var2;
				}

				var2.writeData(var5);
			} catch (Throwable var7) {
				a.error((Object) var7);
			}

		}
	}

	// $FF: synthetic method
	protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws IOException {
		this.a(var1, (Packet) var2, var3);
	}

}
