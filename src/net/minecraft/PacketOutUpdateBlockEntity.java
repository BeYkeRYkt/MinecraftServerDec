package net.minecraft;

import java.io.IOException;

public class PacketOutUpdateBlockEntity implements Packet<PlayClientboundPacketListener> {

	private Position position;
	private int action;
	private NBTCompoundTag tag;

	public PacketOutUpdateBlockEntity() {
	}

	public PacketOutUpdateBlockEntity(Position position, int action, NBTCompoundTag tag) {
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
