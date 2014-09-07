package net.minecraft;

public class PacketPlayOutAnimation implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int animationId;

	public PacketPlayOutAnimation() {
	}

	public PacketPlayOutAnimation(Entity entity, int animationId) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
