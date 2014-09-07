package net.minecraft;

public class PacketPlayOutSpawnPosition implements Packet<PlayOutPacketListener> {

	private Position position;

	public PacketPlayOutSpawnPosition() {
	}

	public PacketPlayOutSpawnPosition(Position position) {
		this.position = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
