package net.minecraft;

public class PacketOutAttachEntity implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private int vehicleId;
	private int leash;

	public PacketOutAttachEntity() {
	}

	public PacketOutAttachEntity(int entityId, Entity vehicle, Entity leash) {
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
