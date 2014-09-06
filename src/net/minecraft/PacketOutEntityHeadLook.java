package net.minecraft;

public class PacketOutEntityHeadLook implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private byte headYaw;

	public PacketOutEntityHeadLook() {
	}

	public PacketOutEntityHeadLook(Entity entity, byte headYaw) {
		this.entityId = entity.getId();
		this.headYaw = headYaw;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.headYaw = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.headYaw);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
