package net.minecraft;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class PacketPlayInPluginMessage implements Packet<PlayInPacketListener> {

	private String channelName;
	private PacketDataSerializer message;

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.channelName = serializer.readString(20);
		int length = serializer.readableBytes();
		if (length >= 0 && length <= 32767) {
			this.message = new PacketDataSerializer(serializer.readBytes(length));
		} else {
			throw new IOException("Payload may not be larger than 32767 bytes");
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.channelName);
		serializer.writeBytes((ByteBuf) this.message);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public String getChannelName() {
		return this.channelName;
	}

	public PacketDataSerializer getMessage() {
		return this.message;
	}

}
