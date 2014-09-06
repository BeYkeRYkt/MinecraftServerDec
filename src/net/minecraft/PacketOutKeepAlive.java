package net.minecraft;

public class PacketOutKeepAlive implements Packet<PlayClientboundPacketListener> {

	private int keepAliveId;

	public PacketOutKeepAlive() {
	}

	public PacketOutKeepAlive(int var1) {
		this.keepAliveId = var1;
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public void readData(PacketDataSerializer serializer) {
		this.keepAliveId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.keepAliveId);
	}

}
