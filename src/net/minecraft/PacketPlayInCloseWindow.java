package net.minecraft;

public class PacketPlayInCloseWindow implements Packet<PlayInPacketListener> {

	private int windowId;

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

}
