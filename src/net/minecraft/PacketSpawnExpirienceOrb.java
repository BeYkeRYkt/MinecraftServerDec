package net.minecraft;

public class PacketSpawnExpirienceOrb implements Packet<PlayPacketListener> {

	private int entityId;
	private int x;
	private int y;
	private int z;
	private int expcount;

	public PacketSpawnExpirienceOrb() {
	}

	public PacketSpawnExpirienceOrb(EntityExpirienceOrb orb) {
		this.entityId = orb.getId();
		this.x = DataTypesConverter.toFixedPointInt(orb.locationX * 32.0D);
		this.y = DataTypesConverter.toFixedPointInt(orb.locationY * 32.0D);
		this.z = DataTypesConverter.toFixedPointInt(orb.locationZ * 32.0D);
		this.expcount = orb.getExp();
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.expcount = serializer.readShort();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeShort(this.expcount);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
