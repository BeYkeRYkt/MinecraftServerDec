package net.minecraft;

public class PacketPlayOutConfirmTransaction implements Packet<PlayOutPacketListener> {

	private int windowId;
	private short actionNumber;
	private boolean succ;

	public PacketPlayOutConfirmTransaction() {
	}

	public PacketPlayOutConfirmTransaction(int windowId, short actionNumber, boolean succ) {
		this.windowId = windowId;
		this.actionNumber = actionNumber;
		this.succ = succ;
	}

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readUnsignedByte();
		this.actionNumber = serializer.readShort();
		this.succ = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.actionNumber);
		serializer.writeBoolean(this.succ);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
