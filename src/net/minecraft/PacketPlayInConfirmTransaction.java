package net.minecraft;

public class PacketPlayInConfirmTransaction implements Packet<PlayInPacketListener> {

	private int windowId;
	private short action;
	private boolean succ;

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readByte();
		this.action = serializer.readShort();
		this.succ = serializer.readByte() != 0;
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.action);
		serializer.writeByte(this.succ ? 1 : 0);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public short getAction() {
		return this.action;
	}

}
