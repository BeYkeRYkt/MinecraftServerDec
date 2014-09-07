package net.minecraft;

public class PacketPlayOutKeepAlive implements Packet<PlayOutPacketListener> {

	private int keepAliveId;

	public PacketPlayOutKeepAlive() {
	}

	public PacketPlayOutKeepAlive(int var1) {
		this.keepAliveId = var1;
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public void readData(PacketDataSerializer serializer) {
		this.keepAliveId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.keepAliveId);
	}

}
