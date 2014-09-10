package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRegionLoader implements IChunkLoader, IAsyncChunkSaver {

	private static final Logger logger = LogManager.getLogger();

	private Object lock = new Object();
	private List<PendingChunkToSave> chunksToSave = Lists.newArrayList();
	private Set<ChunkCoordIntPair> coords = Sets.newHashSet();
	private final File file;

	public ChunkRegionLoader(File file) {
		this.file = file;
	}

	public Chunk loadChunk(World world, int chunkX, int chunkZ) throws IOException {
		NBTCompoundTag tag = null;
		ChunkCoordIntPair pair = new ChunkCoordIntPair(chunkX, chunkZ);
		synchronized (this.lock) {
			if (this.coords.contains(pair)) {
				for (int i = 0; i < this.chunksToSave.size(); ++i) {
					if (this.chunksToSave.get(i).coorPair.equals(pair)) {
						tag = (this.chunksToSave.get(i)).tag;
						break;
					}
				}
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
			Chunk chunk = this.a(world, tag.getCompound("Level"));
			if (!chunk.a(chunkX, chunkZ)) {
				logger.error("Chunk file at " + chunkX + "," + chunkZ + " is in the wrong location; relocating. (Expected " + chunkX + ", " + chunkZ + ", got " + chunk.x + ", " + chunk.y + ")");
				tag.put("xPos", chunkX);
				tag.put("zPos", chunkZ);
				chunk = this.a(world, tag.getCompound("Level"));
			}

			return chunk;
		}
	}

	public void requestChunkSave(World world, Chunk chunk) throws aqz {
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
			if (this.coords.contains(coordPair)) {
				for (int i = 0; i < this.chunksToSave.size(); ++i) {
					if (((PendingChunkToSave) this.chunksToSave.get(i)).coorPair.equals(coordPair)) {
						this.chunksToSave.set(i, new PendingChunkToSave(coordPair, tag));
						return;
					}
				}
			}

			this.chunksToSave.add(new PendingChunkToSave(coordPair, tag));
			this.coords.add(coordPair);
			FileIOThread.getInstance().addChunkSaver(this);
		}
	}

	public boolean saveChunks() {
		PendingChunkToSave chunkToSave = null;
		synchronized (this.lock) {
			if (this.chunksToSave.isEmpty()) {
				return false;
			}

			chunkToSave = (PendingChunkToSave) this.chunksToSave.remove(0);
			this.coords.remove(chunkToSave.coorPair);
		}

		if (chunkToSave != null) {
			try {
				this.saveChunk(chunkToSave);
			} catch (Exception var4) {
				var4.printStackTrace();
			}
		}

		return true;
	}

	private void saveChunk(PendingChunkToSave chunkToSave) throws IOException {
		DataOutputStream outputStream = RegionFileCache.getOutputStream(this.file, chunkToSave.coorPair.chunkX, chunkToSave.coorPair.chunkZ);
		NBTCompressedStreamTools.writeTag(chunkToSave.tag, (DataOutput) outputStream);
		outputStream.close();
	}

	public void b(World var1, Chunk var2) {
	}

	public void a() {
	}

	public void saveAllChunks() {
		while (this.saveChunks()) {
		}
	}

	private void writeChunkInfo(Chunk chunk, World world, NBTCompoundTag tag) {
		tag.put("V", (byte) 1);
		tag.put("xPos", chunk.x);
		tag.put("zPos", chunk.y);
		tag.put("LastUpdate", world.getLastUpdate());
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

				sectionsTag.addTag((NBTTag) sectionTag);
			}
		}
		tag.put("Sections", (NBTTag) sectionsTag);

		tag.put("Biomes", chunk.getBiomes());
		chunk.g(false);
		NBTListTag var20 = new NBTListTag();

		Iterator var22;
		for (int var8 = 0; var8 < chunk.getEntitySlices().length; ++var8) {
			var22 = chunk.getEntitySlices()[var8].iterator();

			while (var22.hasNext()) {
				Entity var24 = (Entity) var22.next();
				NBTCompoundTag sectionTag = new NBTCompoundTag();
				if (var24.d(sectionTag)) {
					chunk.g(true);
					var20.addTag((NBTTag) sectionTag);
				}
			}
		}

		tag.put("Entities", (NBTTag) var20);
		NBTListTag var21 = new NBTListTag();
		var22 = chunk.r().values().iterator();

		while (var22.hasNext()) {
			TileEntity var25 = (TileEntity) var22.next();
			NBTCompoundTag sectionTag = new NBTCompoundTag();
			var25.write(sectionTag);
			var21.addTag((NBTTag) sectionTag);
		}

		tag.put("TileEntities", (NBTTag) var21);
		List var23 = world.a(chunk, false);
		if (var23 != null) {
			long var26 = world.getLastUpdate();
			NBTListTag var27 = new NBTListTag();
			Iterator var28 = var23.iterator();

			while (var28.hasNext()) {
				ark var29 = (ark) var28.next();
				NBTCompoundTag var30 = new NBTCompoundTag();
				RegistryObjectName var31 = (RegistryObjectName) Block.BLOCKREGISTRY.c(var29.a());
				var30.put("i", var31 == null ? "" : var31.toString());
				var30.put("x", var29.a.getX());
				var30.put("y", var29.a.getY());
				var30.put("z", var29.a.getZ());
				var30.put("t", (int) (var29.b - var26));
				var30.put("p", var29.c);
				var27.addTag((NBTTag) var30);
			}

			tag.put("TileTicks", (NBTTag) var27);
		}

	}

	private Chunk a(World var1, NBTCompoundTag var2) {
		int var3 = var2.getInt("xPos");
		int var4 = var2.getInt("zPos");
		Chunk var5 = new Chunk(var1, var3, var4);
		var5.a(var2.getIntArray("HeightMap"));
		var5.d(var2.getBoolean("TerrainPopulated"));
		var5.e(var2.getBoolean("LightPopulated"));
		var5.c(var2.getLong("InhabitedTime"));
		NBTListTag var6 = var2.getList("Sections", 10);
		byte var7 = 16;
		ChunkSection[] var8 = new ChunkSection[var7];
		boolean var9 = !var1.worldProvider.noSkyLight();

		for (int var10 = 0; var10 < var6.getSize(); ++var10) {
			NBTCompoundTag var11 = var6.getCompound(var10);
			byte var12 = var11.getByte("Y");
			ChunkSection var13 = new ChunkSection(var12 << 4, var9);
			byte[] var14 = var11.getByteArray("Blocks");
			ChunkNibbleArray var15 = new ChunkNibbleArray(var11.getByteArray("Data"));
			ChunkNibbleArray var16 = var11.isTagAssignableFrom("Add", 7) ? new ChunkNibbleArray(var11.getByteArray("Add")) : null;
			char[] var17 = new char[var14.length];

			for (int var18 = 0; var18 < var17.length; ++var18) {
				int var19 = var18 & 15;
				int var20 = var18 >> 8 & 15;
				int var21 = var18 >> 4 & 15;
				int var22 = var16 != null ? var16.getValue(var19, var20, var21) : 0;
				var17[var18] = (char) (var22 << 12 | (var14[var18] & 255) << 4 | var15.getValue(var19, var20, var21));
			}

			var13.setBlockIds(var17);
			var13.setEmittedLight(new ChunkNibbleArray(var11.getByteArray("BlockLight")));
			if (var9) {
				var13.setSkyLight(new ChunkNibbleArray(var11.getByteArray("SkyLight")));
			}

			var13.e();
			var8[var12] = var13;
		}

		var5.a(var8);
		if (var2.isTagAssignableFrom("Biomes", 7)) {
			var5.a(var2.getByteArray("Biomes"));
		}

		NBTListTag var23 = var2.getList("Entities", 10);
		if (var23 != null) {
			for (int var24 = 0; var24 < var23.getSize(); ++var24) {
				NBTCompoundTag var26 = var23.getCompound(var24);
				Entity var29 = EntityTypes.loadEntity(var26, var1);
				var5.g(true);
				if (var29 != null) {
					var5.addEntity(var29);
					Entity var32 = var29;

					for (NBTCompoundTag var35 = var26; var35.isTagAssignableFrom("Riding", 10); var35 = var35.getCompound("Riding")) {
						Entity var37 = EntityTypes.loadEntity(var35.getCompound("Riding"), var1);
						if (var37 != null) {
							var5.addEntity(var37);
							var32.a(var37);
						}

						var32 = var37;
					}
				}
			}
		}

		NBTListTag var25 = var2.getList("TileEntities", 10);
		if (var25 != null) {
			for (int var27 = 0; var27 < var25.getSize(); ++var27) {
				NBTCompoundTag var30 = var25.getCompound(var27);
				TileEntity var33 = TileEntity.fromNBT(var30);
				if (var33 != null) {
					var5.a(var33);
				}
			}
		}

		if (var2.isTagAssignableFrom("TileTicks", 9)) {
			NBTListTag var28 = var2.getList("TileTicks", 10);
			if (var28 != null) {
				for (int var31 = 0; var31 < var28.getSize(); ++var31) {
					NBTCompoundTag var34 = var28.getCompound(var31);
					Block var36;
					if (var34.isTagAssignableFrom("i", 8)) {
						var36 = Block.b(var34.getString("i"));
					} else {
						var36 = Block.c(var34.getInt("i"));
					}

					var1.b(new Position(var34.getInt("x"), var34.getInt("y"), var34.getInt("z")), var36, var34.getInt("t"), var34.getInt("p"));
				}
			}
		}

		return var5;
	}

}
