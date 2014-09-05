package net.minecraft;

public class PacketAttachEntity implements Packet<PlayPacketListener> {

	private int entityId;
	private int vehicleId;
	private int leash;

	public PacketAttachEntity() {
	}

	public PacketAttachEntity(int entityId, Entity vehicle, Entity leash) {
		this.entityId = entityId;
		this.vehicleId = vehicle.getId();
		this.leash = leash != null ? leash.getId() : -1;
	}

	public void readData(PacketDataSerializer serializer) {
		this.vehicleId = serializer.readInt();
		this.leash = serializer.readInt();
		this.entityId = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.vehicleId);
		serializer.writeInt(this.leash);
		serializer.writeByte(this.entityId);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
