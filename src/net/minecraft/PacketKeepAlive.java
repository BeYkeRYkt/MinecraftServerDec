package net.minecraft;

public class PacketKeepAlive implements Packet<PlayPacketListener> {

	private int keepAliveId;

	public PacketKeepAlive() {
	}

	public PacketKeepAlive(int var1) {
		this.keepAliveId = var1;
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

	public void readData(PacketDataSerializer serializer) {
		this.keepAliveId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.keepAliveId);
	}

}
