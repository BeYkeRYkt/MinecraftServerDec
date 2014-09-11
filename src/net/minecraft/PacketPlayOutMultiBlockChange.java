package net.minecraft;

public class PacketPlayOutMultiBlockChange implements Packet<PlayOutPacketListener> {

	private ChunkCoordIntPair coordPair;
	private BlockChangeRecord[] packetData;

	public PacketPlayOutMultiBlockChange() {
	}

	public PacketPlayOutMultiBlockChange(int count, short[] data, Chunk chunk) {
		this.coordPair = new ChunkCoordIntPair(chunk.x, chunk.z);
		this.packetData = new BlockChangeRecord[count];

		for (int i = 0; i < this.packetData.length; ++i) {
			this.packetData[i] = new BlockChangeRecord(coordPair, data[i], chunk);
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.coordPair = new ChunkCoordIntPair(serializer.readInt(), serializer.readInt());
		this.packetData = new BlockChangeRecord[serializer.readVarInt()];

		for (int i = 0; i < this.packetData.length; ++i) {
			this.packetData[i] = new BlockChangeRecord(coordPair, serializer.readShort(), (BlockState) Block.IDREGISTRY.getObject(serializer.readVarInt()));
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.coordPair.chunkX);
		serializer.writeInt(this.coordPair.chunkZ);
		serializer.writeVarInt(this.packetData.length);

		for (BlockChangeRecord packetData : packetData) {
			serializer.writeShort(packetData.getBlockCangePosition());
			serializer.writeVarInt(Block.IDREGISTRY.getId(packetData.getBlock()));
		}
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	private static class BlockChangeRecord {

		private ChunkCoordIntPair chunkCoords;
		private final short position;
		private final BlockState block;

		public BlockChangeRecord(ChunkCoordIntPair chunkCoords, short localposition, BlockState block) {
			this.chunkCoords = chunkCoords;
			this.position = localposition;
			this.block = block;
		}

		public BlockChangeRecord(ChunkCoordIntPair chunkCoords, short localposition, Chunk chunk) {
			this.chunkCoords = chunkCoords;
			this.position = localposition;
			this.block = chunk.getBlockState(this.getPosition());
		}

		public Position getPosition() {
			return new Position(chunkCoords.getPosition(this.position >> 12 & 15, this.position & 255, this.position >> 8 & 15));
		}

		public short getBlockCangePosition() {
			return this.position;
		}

		public BlockState getBlock() {
			return this.block;
		}

	}

}
