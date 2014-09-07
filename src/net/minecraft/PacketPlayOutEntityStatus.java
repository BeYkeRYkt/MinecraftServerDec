package net.minecraft;

public class PacketPlayOutEntityStatus implements Packet<PlayOutPacketListener> {

	private int entityId;
	private byte entityStatus;

	public PacketPlayOutEntityStatus() {
	}

	public PacketPlayOutEntityStatus(Entity entity, byte entityStatus) {
		this.entityId = entity.getId();
		this.entityStatus = entityStatus;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readInt();
		this.entityStatus = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.entityId);
		serializer.writeByte(this.entityStatus);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
