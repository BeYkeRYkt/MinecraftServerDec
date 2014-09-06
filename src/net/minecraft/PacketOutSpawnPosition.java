package net.minecraft;

public class PacketOutSpawnPosition implements Packet<PlayClientboundPacketListener> {

	private Position position;

	public PacketOutSpawnPosition() {
	}

	public PacketOutSpawnPosition(Position position) {
		this.position = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
