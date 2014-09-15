package net.minecraft;

public class PacketPlayOutCamera implements Packet<PlayOutPacketListener> {

	public int cameraId;

	public PacketPlayOutCamera() {
	}

	public PacketPlayOutCamera(Entity var1) {
		this.cameraId = var1.getId();
	}

	public void readData(PacketDataSerializer serializer) {
		this.cameraId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.cameraId);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
