package net.minecraft;

public class PacketOutEntityStatus implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private byte entityStatus;

	public PacketOutEntityStatus() {
	}

	public PacketOutEntityStatus(Entity entity, byte entityStatus) {
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
