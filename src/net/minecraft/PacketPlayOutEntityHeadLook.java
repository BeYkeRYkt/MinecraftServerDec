package net.minecraft;

public class PacketPlayOutEntityHeadLook implements Packet<PlayOutPacketListener> {

	private int entityId;
	private byte headYaw;

	public PacketPlayOutEntityHeadLook() {
	}

	public PacketPlayOutEntityHeadLook(Entity entity, byte headYaw) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
