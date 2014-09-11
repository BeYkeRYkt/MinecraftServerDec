package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class PacketPlayOutChunkData implements Packet<PlayOutPacketListener> {

	private int chunkX;
	private int chunkY;
	private ChunkPacketData data;
	private boolean allSections;

	public PacketPlayOutChunkData() {
	}

	public PacketPlayOutChunkData(Chunk chunk, boolean allSections, int inputBitMap) {
		this.chunkX = chunk.x;
		this.chunkY = chunk.z;
		this.allSections = allSections;
		this.data = getChunkData(chunk, allSections, !chunk.getWorld().worldProvider.noSkyLight(), inputBitMap);
	}

	public void readData(PacketDataSerializer serializer) {
		this.chunkX = serializer.readInt();
		this.chunkY = serializer.readInt();
		this.allSections = serializer.readBoolean();
		this.data = new ChunkPacketData();
		this.data.bitMap = serializer.readShort();
		this.data.blockData = serializer.readByteArray();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.chunkX);
		serializer.writeInt(this.chunkY);
		serializer.writeBoolean(this.allSections);
		serializer.writeShort((short) (this.data.bitMap & '\uffff'));
		serializer.writeByteArray(this.data.blockData);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	protected static int calculateArraySize(int sectionCount, boolean hasLight, boolean allSections) {
		int blocksIdLength = sectionCount * 2 * 16 * 16 * 16;
		int emittedLightLength = sectionCount * 16 * 16 * 16 / 2;
		int skyLightLength = hasLight ? sectionCount * 16 * 16 * 16 / 2 : 0;
		int biomesLength = allSections ? 256 : 0;
		return blocksIdLength + emittedLightLength + skyLightLength + biomesLength;
	}

	public static ChunkPacketData getChunkData(Chunk chunk, boolean allSections, boolean hasLight, int inputBitMap) {
		ChunkSection[] sections = chunk.getChunkSections();
		ChunkPacketData packetData = new ChunkPacketData();

		ArrayList<ChunkSection> packetChunkSections = Lists.newArrayList();

		for (int i = 0; i < sections.length; ++i) {
			ChunkSection chunkSection = sections[i];
			if (chunkSection != null && (!allSections || !chunkSection.isEmpty()) && (inputBitMap & 1 << i) != 0) {
				packetData.bitMap |= 1 << i;
				packetChunkSections.add(chunkSection);
			}
		}

		packetData.blockData = new byte[calculateArraySize(Integer.bitCount(packetData.bitMap), hasLight, allSections)];

		int index = 0;

		for (ChunkSection packetChunkSection : packetChunkSections) {
			char[] blockIds = packetChunkSection.getBlockIds();
			for (int i = 0; i < blockIds.length; ++i) {
				char blockId = blockIds[i];
				packetData.blockData[index++] = (byte) (blockId & 255);
				packetData.blockData[index++] = (byte) (blockId >> 8 & 255);
			}
		}

		for (ChunkSection packetChunkSection : packetChunkSections) {
			index = copyData(packetChunkSection.getEmittedLight().getArray(), packetData.blockData, index);
		}

		if (hasLight) {
			for (ChunkSection packetChunkSection : packetChunkSections) {
				index = copyData(packetChunkSection.getSkyLight().getArray(), packetData.blockData, index);
			}
		}

		if (allSections) {
			copyData(chunk.getBiomes(), packetData.blockData, index);
		}

		return packetData;
	}

	private static int copyData(byte[] biomes, byte[] blockData, int chunkSectionNumber) {
		System.arraycopy(biomes, 0, blockData, chunkSectionNumber, biomes.length);
		return chunkSectionNumber + biomes.length;
	}

}
