package net.minecraft;

public class PacketPlayInUpdateSign implements Packet<PlayInPacketListener> {

	private Position position;
	private IChatBaseComponent[] lines;

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
		this.lines = new IChatBaseComponent[4];

		for (int i = 0; i < 4; ++i) {
			this.lines[i] = serializer.readJSONComponent();
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);

		for (int i = 0; i < 4; ++i) {
			serializer.writeJSONComponent(this.lines[i]);
		}
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public Position getPosition() {
		return this.position;
	}

	public IChatBaseComponent[] getLines() {
		return this.lines;
	}

}
