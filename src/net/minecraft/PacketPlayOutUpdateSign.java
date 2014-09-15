package net.minecraft;

public class PacketPlayOutUpdateSign implements Packet<PlayOutPacketListener> {

	private Position position;
	private IChatBaseComponent[] lines;

	public PacketPlayOutUpdateSign() {
	}

	public PacketPlayOutUpdateSign(World world, Position position, IChatBaseComponent[] lines) {
		this.position = position;
		this.lines = new IChatBaseComponent[] { lines[0], lines[1], lines[2], lines[3] };
	}

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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
