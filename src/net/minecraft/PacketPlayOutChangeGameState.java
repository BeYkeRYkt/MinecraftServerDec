package net.minecraft;

public class PacketPlayOutChangeGameState implements Packet<PlayOutPacketListener> {

	public static final String[] reason = new String[] { "tile.bed.notValid" };
	private int idk;
	private float value;

	public PacketPlayOutChangeGameState() {
	}

	public PacketPlayOutChangeGameState(int idk, float value) {
		this.idk = idk;
		this.value = value;
	}

	public void readData(PacketDataSerializer serializer) {
		this.idk = serializer.readUnsignedByte();
		this.value = serializer.readFloat();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.idk);
		serializer.writeFloat(this.value);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
