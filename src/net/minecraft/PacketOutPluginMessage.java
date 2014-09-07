package net.minecraft;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class PacketOutPluginMessage implements Packet<PlayClientboundPacketListener> {

	private String channelName;
	private PacketDataSerializer message;

	public PacketOutPluginMessage() {
	}

	public PacketOutPluginMessage(String channelName, PacketDataSerializer messageSerializer) {
		this.channelName = channelName;
		this.message = messageSerializer;
		if (messageSerializer.writerIndex() > 1048576) {
			throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
		}
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.channelName = serializer.readString(20);
		int length = serializer.readableBytes();
		if (length >= 0 && length <= 1048576) {
			this.message = new PacketDataSerializer(serializer.readBytes(length));
		} else {
			throw new IOException("Payload may not be larger than 1048576 bytes");
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.channelName);
		serializer.writeBytes((ByteBuf) this.message);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
