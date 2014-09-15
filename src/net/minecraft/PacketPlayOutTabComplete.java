package net.minecraft;

public class PacketPlayOutTabComplete implements Packet<PlayOutPacketListener> {

	private String[] data;

	public PacketPlayOutTabComplete() {
	}

	public PacketPlayOutTabComplete(String[] data) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
