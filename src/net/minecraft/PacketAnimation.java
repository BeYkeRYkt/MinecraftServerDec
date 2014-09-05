package net.minecraft;

public class PacketAnimation implements Packet<PlayPacketListener> {

	private int entityId;
	private int animationId;

	public PacketAnimation() {
	}

	public PacketAnimation(Entity entity, int animationId) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
