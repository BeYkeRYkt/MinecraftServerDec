package net.minecraft;

public class PacketRemoveEntityEffect implements Packet<PlayPacketListener> {

	private int entityId;
	private int effectId;

	public PacketRemoveEntityEffect() {
	}

	public PacketRemoveEntityEffect(int entityId, MobEffect effect) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
