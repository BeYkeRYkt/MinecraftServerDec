package net.minecraft;

public class PacketOutEntity implements Packet<PlayClientboundPacketListener> {

	protected int entityId;
	protected byte diffX;
	protected byte diffY;
	protected byte diffZ;
	protected byte yaw;
	protected byte pitch;
	protected boolean onGround;

	public PacketOutEntity() {
	}

	public PacketOutEntity(int entityId) {
		this.entityId = entityId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public String toString() {
		return "Entity_" + super.toString();
	}

}
