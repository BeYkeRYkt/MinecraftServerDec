package net.minecraft;

public class PacketOutMultiBlockChange implements Packet<PlayClientboundPacketListener> {

	private ChunkCoordIntPair coordPair;
	private BlockChangeRecord[] packetData;

	public PacketOutMultiBlockChange() {
	}

	public PacketOutMultiBlockChange(int count, short[] data, Chunk chunk) {
		this.coordPair = new ChunkCoordIntPair(chunk.x, chunk.y);
		this.packetData = new BlockChangeRecord[count];

		for (int i = 0; i < this.packetData.length; ++i) {
			this.packetData[i] = new BlockChangeRecord(coordPair, data[i], chunk);
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.coordPair = new ChunkCoordIntPair(serializer.readInt(), serializer.readInt());
		this.packetData = new BlockChangeRecord[serializer.readVarInt()];

		for (int i = 0; i < this.packetData.length; ++i) {
			this.packetData[i] = new BlockChangeRecord(coordPair, serializer.readShort(), (bec) Block.IDREGISTRY.getObject(serializer.readVarInt()));
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	private static class BlockChangeRecord {

		private ChunkCoordIntPair chunkCoords;
		private final short position;
		private final bec block;

		public BlockChangeRecord(ChunkCoordIntPair chunkCoords, short localposition, bec block) {
			this.chunkCoords = chunkCoords;
			this.position = localposition;
			this.block = block;
		}

		public BlockChangeRecord(ChunkCoordIntPair chunkCoords, short localposition, Chunk chunk) {
			this.chunkCoords = chunkCoords;
			this.position = localposition;
			this.block = chunk.g(this.getPosition());
		}

		public Position getPosition() {
			return new Position(chunkCoords.getPosition(this.position >> 12 & 15, this.position & 255, this.position >> 8 & 15));
		}

		public short getBlockCangePosition() {
			return this.position;
		}

		public bec getBlock() {
			return this.block;
		}

	}

}
