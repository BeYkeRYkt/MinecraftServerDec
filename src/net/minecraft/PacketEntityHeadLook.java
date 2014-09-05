package net.minecraft;

public class PacketEntityHeadLook implements Packet<PlayPacketListener> {

	private int entityId;
	private byte headYaw;

	public PacketEntityHeadLook() {
	}

	public PacketEntityHeadLook(Entity entity, byte headYaw) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
