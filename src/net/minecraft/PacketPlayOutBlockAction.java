package net.minecraft;

public class PacketPlayOutBlockAction implements Packet<PlayOutPacketListener> {

	private Position a;
	private int b1;
	private int b2;
	private Block block;

	public PacketPlayOutBlockAction() {
	}

	public PacketPlayOutBlockAction(Position position, Block block, int b1, int b2) {
		this.a = position;
		this.b1 = b1;
		this.b2 = b2;
		this.block = block;
	}

	public void readData(PacketDataSerializer serializer) {
		this.a = serializer.readPosition();
		this.b1 = serializer.readUnsignedByte();
		this.b2 = serializer.readUnsignedByte();
		this.block = Block.c(serializer.readVarInt() & 4095);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.a);
		serializer.writeByte(this.b1);
		serializer.writeByte(this.b2);
		serializer.writeVarInt(Block.getBlockId(this.block) & 4095);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
