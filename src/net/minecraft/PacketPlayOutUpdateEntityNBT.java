package net.minecraft;

import java.io.IOException;

public class PacketPlayOutUpdateEntityNBT implements Packet<PlayOutPacketListener> {

	private int entityId;
	private NBTCompoundTag tag;

	public PacketPlayOutUpdateEntityNBT() {
	}

	public PacketPlayOutUpdateEntityNBT(int entityId, NBTCompoundTag tag) {
		this.entityId = entityId;
		this.tag = tag;
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.tag = serializer.readCompound();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeCompound(this.tag);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
