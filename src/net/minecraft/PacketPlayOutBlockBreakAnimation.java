package net.minecraft;

public class PacketPlayOutBlockBreakAnimation implements Packet<PlayOutPacketListener> {

	private int entityId;
	private Position position;
	private int destroyStage;

	public PacketPlayOutBlockBreakAnimation() {
	}

	public PacketPlayOutBlockBreakAnimation(int entityId, Position position, int destroyStage) {
		this.entityId = entityId;
		this.position = position;
		this.destroyStage = destroyStage;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.position = serializer.readPosition();
		this.destroyStage = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writePosition(this.position);
		serializer.writeByte(this.destroyStage);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
