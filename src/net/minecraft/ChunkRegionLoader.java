package net.minecraft;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRegionLoader implements IChunkLoader, IAsyncChunkSaver {

	private static final Logger logger = LogManager.getLogger();

	private Object lock = new Object();
	private HashMap<ChunkCoordIntPair, NBTCompoundTag> chunksToSave = new HashMap<ChunkCoordIntPair, NBTCompoundTag>();
	private final File file;

	public ChunkRegionLoader(File file) {
		this.file = file;
	}

	public Chunk loadChunk(World world, int chunkX, int chunkZ) throws IOException {
		NBTCompoundTag tag = null;
		ChunkCoordIntPair pair = new ChunkCoordIntPair(chunkX, chunkZ);

		synchronized (this.lock) {
			if (chunksToSave.containsKey(pair)) {
				tag = chunksToSave.get(pair);
			}
		}

		if (tag == null) {
			DataInputStream inputStream = RegionFileCache.getInputStream(this.file, chunkX, chunkZ);
			if (inputStream == null) {
				return null;
			}

			tag = NBTCompressedStreamTools.readTag(inputStream);
		}

		return this.loadChunk(world, chunkX, chunkZ, tag);
	}

	protected Chunk loadChunk(World world, int chunkX, int chunkZ, NBTCompoundTag tag) {
		if (!tag.isTagAssignableFrom("Level", 10)) {
			logger.error("Chunk file at " + chunkX + "," + chunkZ + " is missing level data, skipping");
			return null;
		} else if (!tag.getCompound("Level").isTagAssignableFrom("Sections", 9)) {
			logger.error("Chunk file at " + chunkX + "," + chunkZ + " is missing block data, skipping");
			return null;
		} else {
			Chunk chunk = this.readChunkInfo(world, tag.getCompound("Level"));
			if (!chunk.a(chunkX, chunkZ)) {
				logger.error("Chunk file at " + chunkX + "," + chunkZ + " is in the wrong location; relocating. (Expected " + chunkX + ", " + chunkZ + ", got " + chunk.x + ", " + chunk.z + ")");
				tag.put("xPos", chunkX);
				tag.put("zPos", chunkZ);
				chunk = this.readChunkInfo(world, tag.getCompound("Level"));
			}

			return chunk;
		}
	}

	public void requestChunkSave(World world, Chunk chunk) throws ExceptionWorldConflict {
		world.checkSessionLock();

		try {
			NBTCompoundTag tagToSave = new NBTCompoundTag();
			NBTCompoundTag chunkInfo = new NBTCompoundTag();
			tagToSave.put("Level", (NBTTag) chunkInfo);
			this.writeChunkInfo(chunk, world, chunkInfo);
			this.requestChunkSave(chunk.getCoords(), tagToSave);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void requestChunkSave(ChunkCoordIntPair coordPair, NBTCompoundTag tag) {
		synchronized (this.lock) {
			chunksToSave.put(coordPair, tag);

			FileIOThread.getInstance().addChunkSaver(this);
		}
	}

	public boolean saveChunks() {
		Entry<ChunkCoordIntPair, NBTCompoundTag> entry = null;

		synchronized (this.lock) {
			if (this.chunksToSave.isEmpty()) {
				return false;
			}

			Iterator<Entry<ChunkCoordIntPair, NBTCompoundTag>> iterator = chunksToSave.entrySet().iterator();
			entry = iterator.next();
			iterator.remove();
		}

		if (entry != null) {
			try {
				this.saveChunk(entry);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return true;
	}

	private void saveChunk(Entry<ChunkCoordIntPair, NBTCompoundTag> entry) throws IOException {
		DataOutputStream outputStream = RegionFileCache.getOutputStream(this.file, entry.getKey().chunkX, entry.getKey().chunkZ);
		NBTCompressedStreamTools.writeTag(entry.getValue(), (DataOutput) outputStream);
		outputStream.close();
	}

	public void saveAllChunks() {
		while (this.saveChunks()) {
		}
	}

	private void writeChunkInfo(Chunk chunk, World world, NBTCompoundTag tag) {
		tag.put("V", (byte) 1);
		tag.put("xPos", chunk.x);
		tag.put("zPos", chunk.z);
		tag.put("LastUpdate", world.getTime());
		tag.put("HeightMap", chunk.getHeightMap());
		tag.put("TerrainPopulated", chunk.isTerrainPopulated());
		tag.put("LightPopulated", chunk.isLightPopulated());
		tag.put("InhabitedTime", chunk.getInhabitedTime());

		NBTListTag sectionsTag = new NBTListTag();
		for (ChunkSection chunkSection : chunk.getChunkSections()) {
			if (chunkSection != null) {
				NBTCompoundTag sectionTag = new NBTCompoundTag();
				sectionTag.put("Y", (byte) (chunkSection.getYPos() >> 4 & 255));
				byte[] blockIds = new byte[chunkSection.getBlockIds().length];
				ChunkNibbleArray dataBlockIds = new ChunkNibbleArray();
				ChunkNibbleArray addBlockIds = null;

				for (int i = 0; i < chunkSection.getBlockIds().length; ++i) {
					char packedBlockId = chunkSection.getBlockIds()[i];
					int x = i & 15;
					int y = i >> 8 & 15;
					int z = i >> 4 & 15;
					if (packedBlockId >> 12 != 0) {
						if (addBlockIds == null) {
							addBlockIds = new ChunkNibbleArray();
						}

						addBlockIds.setValue(x, y, z, packedBlockId >> 12);
					}

					blockIds[i] = (byte) ((packedBlockId >> 4) & 255);
					dataBlockIds.setValue(x, y, z, packedBlockId & 15);
				}

				sectionTag.put("Blocks", blockIds);
				sectionTag.put("Data", dataBlockIds.getArray());
				if (addBlockIds != null) {
					sectionTag.put("Add", addBlockIds.getArray());
				}

				sectionTag.put("BlockLight", chunkSection.getEmittedLight().getArray());
				if (!world.worldProvider.noSkyLight()) {
					sectionTag.put("SkyLight", chunkSection.getSkyLight().getArray());
				} else {
					sectionTag.put("SkyLight", new byte[chunkSection.getEmittedLight().getArray().length]);
				}

				sectionsTag.addTag(sectionTag);
			}
		}
		tag.put("Sections", sectionsTag);

		tag.put("Biomes", chunk.getBiomes());

		chunk.g(false);
		NBTListTag entitesTag = new NBTListTag();
		for (EntitySlice<Entity> ecititySlice : chunk.getEntitySlices()) {
			Iterator<Entity> sliceIt = ecititySlice.iterator();
			while (sliceIt.hasNext()) {
				Entity entity = sliceIt.next();
				NBTCompoundTag sectionTag = new NBTCompoundTag();
				if (entity.writeIfNoPassenger(sectionTag)) {
					chunk.g(true);
					entitesTag.addTag(sectionTag);
				}
			}
		}
		tag.put("Entities", entitesTag);

		NBTListTag tileEntiesTag = new NBTListTag();
		for (TileEntity tileEntity : chunk.getTileEntites().values()) {
			NBTCompoundTag sectionTag = new NBTCompoundTag();
			tileEntity.write(sectionTag);
			tileEntiesTag.addTag((NBTTag) sectionTag);
		}
		tag.put("TileEntities", tileEntiesTag);

		List<NextTickListEntry> nextTickList = world.getNextTickList(chunk, false);
		if (nextTickList != null) {
			long lastUpdate = world.getTime();
			NBTListTag nextTickListTag = new NBTListTag();
			for (NextTickListEntry listEntry : nextTickList) {
				NBTCompoundTag entryTag = new NBTCompoundTag();
				RegistryObjectName objectName = (RegistryObjectName) Block.BLOCKREGISTRY.c(listEntry.getBlock());
				entryTag.put("i", objectName == null ? "" : objectName.toString());
				entryTag.put("x", listEntry.position.getX());
				entryTag.put("y", listEntry.position.getY());
				entryTag.put("z", listEntry.position.getZ());
				entryTag.put("t", (int) (listEntry.b - lastUpdate));
				entryTag.put("p", listEntry.c);
				nextTickListTag.addTag(entryTag);
			}
			tag.put("TileTicks", nextTickListTag);
		}

	}

	private Chunk readChunkInfo(World world, NBTCompoundTag tag) {
		int chunkX = tag.getInt("xPos");
		int chunkZ = tag.getInt("zPos");
		Chunk chunk = new Chunk(world, chunkX, chunkZ);
		chunk.setHeightMap(tag.getIntArray("HeightMap"));
		chunk.setTerrainPopulated(tag.getBoolean("TerrainPopulated"));
		chunk.setLightPopulated(tag.getBoolean("LightPopulated"));
		chunk.setInhabitedTime(tag.getLong("InhabitedTime"));

		NBTListTag sectionsTag = tag.getList("Sections", 10);
		ChunkSection[] chunkSections = new ChunkSection[16];
		for (int sectionNumber = 0; sectionNumber < sectionsTag.getSize(); ++sectionNumber) {
			NBTCompoundTag sectionTag = sectionsTag.getCompound(sectionNumber);
			byte sectionYPos = sectionTag.getByte("Y");
			ChunkSection section = new ChunkSection(sectionYPos << 4, !world.worldProvider.noSkyLight());
			byte[] blockIds = sectionTag.getByteArray("Blocks");
			ChunkNibbleArray dataIds = new ChunkNibbleArray(sectionTag.getByteArray("Data"));
			ChunkNibbleArray addBlockIds = sectionTag.isTagAssignableFrom("Add", 7) ? new ChunkNibbleArray(sectionTag.getByteArray("Add")) : null;
			char[] packedBlockIds = new char[blockIds.length];

			for (int i = 0; i < packedBlockIds.length; ++i) {
				int x = i & 15;
				int y = i >> 8 & 15;
				int z = i >> 4 & 15;
				int addBlockId = addBlockIds != null ? addBlockIds.getValue(x, y, z) : 0;
				packedBlockIds[i] = (char) (addBlockId << 12 | (blockIds[i] & 255) << 4 | dataIds.getValue(x, y, z));
			}

			section.setBlockIds(packedBlockIds);
			section.setEmittedLight(new ChunkNibbleArray(sectionTag.getByteArray("BlockLight")));
			if (!world.worldProvider.noSkyLight()) {
				section.setSkyLight(new ChunkNibbleArray(sectionTag.getByteArray("SkyLight")));
			}
			section.recalcBlockCounts();
			chunkSections[sectionYPos] = section;
		}
		chunk.setSections(chunkSections);

		if (tag.isTagAssignableFrom("Biomes", 7)) {
			chunk.setBiomes(tag.getByteArray("Biomes"));
		}

		NBTListTag entitesTag = tag.getList("Entities", 10);
		if (entitesTag != null) {
			for (int i = 0; i < entitesTag.getSize(); ++i) {
				NBTCompoundTag entityTag = entitesTag.getCompound(i);
				Entity entity = EntityTypes.loadEntity(entityTag, world);
				chunk.g(true);
				if (entity != null) {
					chunk.addEntity(entity);
					Entity passenger = entity;

					for (NBTCompoundTag vehicleTag = entityTag; vehicleTag.isTagAssignableFrom("Riding", 10); vehicleTag = vehicleTag.getCompound("Riding")) {
						Entity vehicle = EntityTypes.loadEntity(vehicleTag.getCompound("Riding"), world);
						if (vehicle != null) {
							chunk.addEntity(vehicle);
							passenger.mount(vehicle);
						}

						passenger = vehicle;
					}
				}
			}
		}

		NBTListTag tileEntiesTag = tag.getList("TileEntities", 10);
		if (tileEntiesTag != null) {
			for (int i = 0; i < tileEntiesTag.getSize(); ++i) {
				NBTCompoundTag tileEntityTag = tileEntiesTag.getCompound(i);
				TileEntity tileEntity = TileEntity.fromNBT(tileEntityTag);
				if (tileEntity != null) {
					chunk.a(tileEntity);
				}
			}
		}

		if (tag.isTagAssignableFrom("TileTicks", 9)) {
			NBTListTag nextTickListTag = tag.getList("TileTicks", 10);
			if (nextTickListTag != null) {
				for (int i = 0; i < nextTickListTag.getSize(); ++i) {
					NBTCompoundTag entryTag = nextTickListTag.getCompound(i);
					Block block;
					if (entryTag.isTagAssignableFrom("i", 8)) {
						block = Block.getByName(entryTag.getString("i"));
					} else {
						block = Block.getById(entryTag.getInt("i"));
					}

					world.addNextTickEntry(new Position(entryTag.getInt("x"), entryTag.getInt("y"), entryTag.getInt("z")), block, entryTag.getInt("t"), entryTag.getInt("p"));
				}
			}
		}

		return chunk;
	}

}
