package net.minecraft;

public class PacketPlayOutDestroyEntities implements Packet<PlayOutPacketListener> {

	private int[] entityIds;

	public PacketPlayOutDestroyEntities() {
	}

	public PacketPlayOutDestroyEntities(int... entityIds) {
		this.entityIds = entityIds;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityIds = new int[serializer.readVarInt()];

		for (int i = 0; i < this.entityIds.length; ++i) {
			this.entityIds[i] = serializer.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.entityIds.length);

		for (int entityId : this.entityIds) {
			var1.writeVarInt(entityId);
		}
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
