package net.minecraft;

public class PacketOutRemoveEntityEffect implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private int effectId;

	public PacketOutRemoveEntityEffect() {
	}

	public PacketOutRemoveEntityEffect(int entityId, MobEffect effect) {
		this.entityId = entityId;
		this.effectId = effect.getId();
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.effectId = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.effectId);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
