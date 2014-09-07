package net.minecraft;

import java.util.List;

public class PacketPlayOutMapChunkBulk implements Packet<PlayOutPacketListener> {

	private int[] xCoords;
	private int[] zCoords;
	private ChunkPacketData[] packetData;
	private boolean hasLight;

	public PacketPlayOutMapChunkBulk() {
	}

	public PacketPlayOutMapChunkBulk(List<Chunk> chunkList) {
		int chunkNumber = chunkList.size();
		this.xCoords = new int[chunkNumber];
		this.zCoords = new int[chunkNumber];
		this.packetData = new ChunkPacketData[chunkNumber];
		this.hasLight = !(chunkList.get(0)).getWorld().worldProvider.noSkyLight();

		for (int i = 0; i < chunkNumber; ++i) {
			Chunk chunk = chunkList.get(i);
			ChunkPacketData var5 = PacketPlayOutChunkData.getChunkData(chunk, true, this.hasLight, '\uffff');
			this.xCoords[i] = chunk.x;
			this.zCoords[i] = chunk.y;
			this.packetData[i] = var5;
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.hasLight = serializer.readBoolean();
		int chunkNumber = serializer.readVarInt();
		this.xCoords = new int[chunkNumber];
		this.zCoords = new int[chunkNumber];
		this.packetData = new ChunkPacketData[chunkNumber];

		for (int i = 0; i < chunkNumber; ++i) {
			this.xCoords[i] = serializer.readInt();
			this.zCoords[i] = serializer.readInt();
			this.packetData[i] = new ChunkPacketData();
			this.packetData[i].bitMap = serializer.readShort() & '\uffff';
			this.packetData[i].blockData = new byte[PacketPlayOutChunkData.calculateArraySize(Integer.bitCount(this.packetData[i].bitMap), this.hasLight, true)];
		}

		for (int i = 0; i < chunkNumber; ++i) {
			serializer.readBytes(this.packetData[i].blockData);
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeBoolean(this.hasLight);
		serializer.writeVarInt(this.packetData.length);

		for (int i = 0; i < this.xCoords.length; ++i) {
			serializer.writeInt(this.xCoords[i]);
			serializer.writeInt(this.zCoords[i]);
			serializer.writeShort((short) (this.packetData[i].bitMap & '\uffff'));
		}

		for (int i = 0; i < this.xCoords.length; ++i) {
			serializer.writeBytes(this.packetData[i].blockData);
		}

	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
