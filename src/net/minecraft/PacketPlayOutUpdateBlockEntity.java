package net.minecraft;

import java.io.IOException;

public class PacketPlayOutUpdateBlockEntity implements Packet<PlayOutPacketListener> {

	private Position position;
	private int action;
	private NBTCompoundTag tag;

	public PacketPlayOutUpdateBlockEntity() {
	}

	public PacketPlayOutUpdateBlockEntity(Position position, int action, NBTCompoundTag tag) {
		this.position = position;
		this.action = action;
		this.tag = tag;
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.position = serializer.readPosition();
		this.action = serializer.readUnsignedByte();
		this.tag = serializer.readCompound();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
		serializer.writeByte((byte) this.action);
		serializer.writeCompound(this.tag);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
