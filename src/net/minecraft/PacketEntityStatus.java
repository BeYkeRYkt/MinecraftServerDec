package net.minecraft;

public class PacketEntityStatus implements Packet<PlayPacketListener> {

	private int entityId;
	private byte entityStatus;

	public PacketEntityStatus() {
	}

	public PacketEntityStatus(Entity entity, byte entityStatus) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
