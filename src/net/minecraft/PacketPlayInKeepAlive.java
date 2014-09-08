package net.minecraft;

public class PacketPlayInKeepAlive implements Packet<PlayInPacketListener> {

	private int keepAliveId;

	public void readData(PacketDataSerializer serializer) {
		this.keepAliveId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.keepAliveId);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getKeepAliveId() {
		return this.keepAliveId;
	}

}
