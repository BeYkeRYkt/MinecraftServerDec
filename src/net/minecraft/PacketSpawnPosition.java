package net.minecraft;

public class PacketSpawnPosition implements Packet<PlayPacketListener> {

	private Position position;

	public PacketSpawnPosition() {
	}

	public PacketSpawnPosition(Position position) {
		this.position = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
