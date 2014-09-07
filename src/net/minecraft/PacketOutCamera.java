package net.minecraft;

public class PacketOutCamera implements Packet<PlayClientboundPacketListener> {

	public int cameraId;

	public PacketOutCamera() {
	}

	public PacketOutCamera(Entity var1) {
		this.cameraId = var1.getId();
	}

	public void readData(PacketDataSerializer serializer) {
		this.cameraId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.cameraId);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
