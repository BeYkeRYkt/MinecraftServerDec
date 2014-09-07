package net.minecraft;

public class PacketOutSignEditorOpen implements Packet<PlayClientboundPacketListener> {

	private Position position;

	public PacketOutSignEditorOpen() {
	}

	public PacketOutSignEditorOpen(Position position) {
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
