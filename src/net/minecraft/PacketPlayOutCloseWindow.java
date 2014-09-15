package net.minecraft;

public class PacketPlayOutCloseWindow implements Packet<PlayOutPacketListener> {

	private int windowId;

	public PacketPlayOutCloseWindow() {
	}

	public PacketPlayOutCloseWindow(int windowId) {
		this.windowId = windowId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
