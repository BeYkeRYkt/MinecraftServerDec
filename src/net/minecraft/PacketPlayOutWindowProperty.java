package net.minecraft;

public class PacketPlayOutWindowProperty implements Packet<PlayOutPacketListener> {

	private int windowId;
	private int property;
	private int value;

	public PacketPlayOutWindowProperty() {
	}

	public PacketPlayOutWindowProperty(int windowId, int property, int value) {
		this.windowId = windowId;
		this.property = property;
		this.value = value;
	}

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readUnsignedByte();
		this.property = serializer.readShort();
		this.value = serializer.readShort();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.property);
		serializer.writeShort(this.value);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
