package net.minecraft;

public class PacketOutCloseWindow implements Packet<PlayClientboundPacketListener> {

	private int windowId;

	public PacketOutCloseWindow() {
	}

	public PacketOutCloseWindow(int windowId) {
		this.windowId = windowId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
