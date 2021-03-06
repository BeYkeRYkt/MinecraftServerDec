package net.minecraft;

public class PacketPlayOutBlockChange implements Packet<PlayOutPacketListener> {

	private Position position;
	private IBlockState block;

	public PacketPlayOutBlockChange() {
	}

	public PacketPlayOutBlockChange(World world, Position position) {
		this.position = position;
		this.block = world.getBlockState(position);
	}

	public void readData(PacketDataSerializer serializer) {
		this.position = serializer.readPosition();
		this.block = (IBlockState) Block.IDREGISTRY.getObject(serializer.readVarInt());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
		serializer.writeVarInt(Block.IDREGISTRY.getId(this.block));
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
