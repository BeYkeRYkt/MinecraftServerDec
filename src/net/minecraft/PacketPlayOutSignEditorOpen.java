package net.minecraft;

public class PacketPlayOutSignEditorOpen implements Packet<PlayOutPacketListener> {

	private Position position;

	public PacketPlayOutSignEditorOpen() {
	}

	public PacketPlayOutSignEditorOpen(Position position) {
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
