package net.minecraft;

public class PacketOutAnimation implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private int animationId;

	public PacketOutAnimation() {
	}

	public PacketOutAnimation(Entity entity, int animationId) {
		this.entityId = entity.getId();
		this.animationId = animationId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.animationId = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.animationId);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
