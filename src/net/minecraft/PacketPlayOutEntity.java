package net.minecraft;

public class PacketPlayOutEntity implements Packet<PlayOutPacketListener> {

	protected int entityId;
	protected byte diffX;
	protected byte diffY;
	protected byte diffZ;
	protected byte yaw;
	protected byte pitch;
	protected boolean onGround;

	public PacketPlayOutEntity() {
	}

	public PacketPlayOutEntity(int entityId) {
		this.entityId = entityId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public String toString() {
		return "Entity_" + super.toString();
	}

}
