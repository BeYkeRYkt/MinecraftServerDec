package net.minecraft;

public class PacketOutTabComplete implements Packet<PlayClientboundPacketListener> {

	private String[] data;

	public PacketOutTabComplete() {
	}

	public PacketOutTabComplete(String[] data) {
		this.data = data;
	}

	public void readData(PacketDataSerializer serializer) {
		this.data = new String[serializer.readVarInt()];

		for (int i = 0; i < this.data.length; ++i) {
			this.data[i] = serializer.readString(32767);
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.data.length);

		for (String string : data) {
			serializer.writeString(string);
		}

	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
