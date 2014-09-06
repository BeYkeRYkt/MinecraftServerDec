package net.minecraft;

public class PacketOutUpdateSign implements Packet<PlayClientboundPacketListener> {

	private Position position;
	private IJSONComponent[] lines;

	public PacketOutUpdateSign() {
	}

	public PacketOutUpdateSign(World world, Position position, IJSONComponent[] lines) {
		this.position = position;
		this.lines = new IJSONComponent[] { lines[0], lines[1], lines[2], lines[3] };
	}

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
		this.lines = new IJSONComponent[4];

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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
