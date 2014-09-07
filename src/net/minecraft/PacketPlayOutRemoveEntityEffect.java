package net.minecraft;

public class PacketPlayOutRemoveEntityEffect implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int effectId;

	public PacketPlayOutRemoveEntityEffect() {
	}

	public PacketPlayOutRemoveEntityEffect(int entityId, MobEffect effect) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
