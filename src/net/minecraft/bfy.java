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

public class bfy implements bfq, brq {

	private static final Logger a = LogManager.getLogger();
	private List b = Lists.newArrayList();
	private Set c = Sets.newHashSet();
	private Object d = new Object();
	private final File e;

	public bfy(File var1) {
		this.e = var1;
	}

	public Chunk a(World var1, int var2, int var3) throws IOException {
		NBTCompoundTag var4 = null;
		ChunkCoordIntPair var5 = new ChunkCoordIntPair(var2, var3);
		Object var6 = this.d;
		synchronized (this.d) {
			if (this.c.contains(var5)) {
				for (int var7 = 0; var7 < this.b.size(); ++var7) {
					if (((bfz) this.b.get(var7)).a.equals(var5)) {
						var4 = ((bfz) this.b.get(var7)).b;
						break;
					}
				}
			}
		}

		if (var4 == null) {
			DataInputStream var10 = RegionFileCache.getInputStream(this.e, var2, var3);
			if (var10 == null) {
				return null;
			}

			var4 = NBTCompressedStreamTools.readTag(var10);
		}

		return this.a(var1, var2, var3, var4);
	}

	protected Chunk a(World var1, int var2, int var3, NBTCompoundTag var4) {
		if (!var4.isTagAssignableFrom("Level", 10)) {
			a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
			return null;
		} else if (!var4.getCompound("Level").isTagAssignableFrom("Sections", 9)) {
			a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
			return null;
		} else {
			Chunk var5 = this.a(var1, var4.getCompound("Level"));
			if (!var5.a(var2, var3)) {
				a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var5.x + ", " + var5.y + ")");
				var4.put("xPos", var2);
				var4.put("zPos", var3);
				var5 = this.a(var1, var4.getCompound("Level"));
			}

			return var5;
		}
	}

	public void a(World var1, Chunk var2) throws aqz {
		var1.I();

		try {
			NBTCompoundTag var3 = new NBTCompoundTag();
			NBTCompoundTag var4 = new NBTCompoundTag();
			var3.put("Level", (NBTTag) var4);
			this.a(var2, var1, var4);
			this.a(var2.j(), var3);
		} catch (Exception var5) {
			var5.printStackTrace();
		}

	}

	protected void a(ChunkCoordIntPair var1, NBTCompoundTag var2) {
		Object var3 = this.d;
		synchronized (this.d) {
			if (this.c.contains(var1)) {
				for (int var4 = 0; var4 < this.b.size(); ++var4) {
					if (((bfz) this.b.get(var4)).a.equals(var1)) {
						this.b.set(var4, new bfz(var1, var2));
						return;
					}
				}
			}

			this.b.add(new bfz(var1, var2));
			this.c.add(var1);
			FileIOThread.getInstance().a(this);
		}
	}

	public boolean c() {
		bfz var1 = null;
		Object var2 = this.d;
		synchronized (this.d) {
			if (this.b.isEmpty()) {
				return false;
			}

			var1 = (bfz) this.b.remove(0);
			this.c.remove(var1.a);
		}

		if (var1 != null) {
			try {
				this.a(var1);
			} catch (Exception var4) {
				var4.printStackTrace();
			}
		}

		return true;
	}

	private void a(bfz var1) throws IOException {
		DataOutputStream var2 = RegionFileCache.getOutputStream(this.e, var1.a.chunkX, var1.a.chunkZ);
		NBTCompressedStreamTools.writeTag(var1.b, (DataOutput) var2);
		var2.close();
	}

	public void b(World var1, Chunk var2) {
	}

	public void a() {
	}

	public void b() {
		while (this.c()) {
			;
		}

	}

	private void a(Chunk var1, World var2, NBTCompoundTag var3) {
		var3.put("V", (byte) 1);
		var3.put("xPos", var1.x);
		var3.put("zPos", var1.y);
		var3.put("LastUpdate", var2.K());
		var3.put("HeightMap", var1.q());
		var3.put("TerrainPopulated", var1.t());
		var3.put("LightPopulated", var1.u());
		var3.put("InhabitedTime", var1.w());
		ChunkSection[] var4 = var1.getChunkSections();
		NBTListTag var5 = new NBTListTag();
		boolean var6 = !var2.worldProvider.noSkyLight();
		ChunkSection[] var7 = var4;
		int var8 = var4.length;

		NBTCompoundTag var11;
		for (int var9 = 0; var9 < var8; ++var9) {
			ChunkSection var10 = var7[var9];
			if (var10 != null) {
				var11 = new NBTCompoundTag();
				var11.put("Y", (byte) (var10.d() >> 4 & 255));
				byte[] var12 = new byte[var10.getBlockIds().length];
				NibbleArray var13 = new NibbleArray();
				NibbleArray var14 = null;

				for (int var15 = 0; var15 < var10.getBlockIds().length; ++var15) {
					char var16 = var10.getBlockIds()[var15];
					int var17 = var15 & 15;
					int var18 = var15 >> 8 & 15;
					int var19 = var15 >> 4 & 15;
					if (var16 >> 12 != 0) {
						if (var14 == null) {
							var14 = new NibbleArray();
						}

						var14.a(var17, var18, var19, var16 >> 12);
					}

					var12[var15] = (byte) (var16 >> 4 & 255);
					var13.a(var17, var18, var19, var16 & 15);
				}

				var11.put("Blocks", var12);
				var11.put("Data", var13.getArray());
				if (var14 != null) {
					var11.put("Add", var14.getArray());
				}

				var11.put("BlockLight", var10.getEmittedLight().getArray());
				if (var6) {
					var11.put("SkyLight", var10.getSkyLight().getArray());
				} else {
					var11.put("SkyLight", new byte[var10.getEmittedLight().getArray().length]);
				}

				var5.addTag((NBTTag) var11);
			}
		}

		var3.put("Sections", (NBTTag) var5);
		var3.put("Biomes", var1.getBiomes());
		var1.g(false);
		NBTListTag var20 = new NBTListTag();

		Iterator var22;
		for (var8 = 0; var8 < var1.s().length; ++var8) {
			var22 = var1.s()[var8].iterator();

			while (var22.hasNext()) {
				Entity var24 = (Entity) var22.next();
				var11 = new NBTCompoundTag();
				if (var24.d(var11)) {
					var1.g(true);
					var20.addTag((NBTTag) var11);
				}
			}
		}

		var3.put("Entities", (NBTTag) var20);
		NBTListTag var21 = new NBTListTag();
		var22 = var1.r().values().iterator();

		while (var22.hasNext()) {
			bcm var25 = (bcm) var22.next();
			var11 = new NBTCompoundTag();
			var25.b(var11);
			var21.addTag((NBTTag) var11);
		}

		var3.put("TileEntities", (NBTTag) var21);
		List var23 = var2.a(var1, false);
		if (var23 != null) {
			long var26 = var2.K();
			NBTListTag var27 = new NBTListTag();
			Iterator var28 = var23.iterator();

			while (var28.hasNext()) {
				ark var29 = (ark) var28.next();
				NBTCompoundTag var30 = new NBTCompoundTag();
				BlockNameInfo var31 = (BlockNameInfo) Block.BLOCKREGISTRY.c(var29.a());
				var30.put("i", var31 == null ? "" : var31.toString());
				var30.put("x", var29.a.n());
				var30.put("y", var29.a.o());
				var30.put("z", var29.a.p());
				var30.put("t", (int) (var29.b - var26));
				var30.put("p", var29.c);
				var27.addTag((NBTTag) var30);
			}

			var3.put("TileTicks", (NBTTag) var27);
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
			NibbleArray var15 = new NibbleArray(var11.getByteArray("Data"));
			NibbleArray var16 = var11.isTagAssignableFrom("Add", 7) ? new NibbleArray(var11.getByteArray("Add")) : null;
			char[] var17 = new char[var14.length];

			for (int var18 = 0; var18 < var17.length; ++var18) {
				int var19 = var18 & 15;
				int var20 = var18 >> 8 & 15;
				int var21 = var18 >> 4 & 15;
				int var22 = var16 != null ? var16.a(var19, var20, var21) : 0;
				var17[var18] = (char) (var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
			}

			var13.setBlockIds(var17);
			var13.setEmittedLight(new NibbleArray(var11.getByteArray("BlockLight")));
			if (var9) {
				var13.setSkyLight(new NibbleArray(var11.getByteArray("SkyLight")));
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
				Entity var29 = EntityTypes.a(var26, var1);
				var5.g(true);
				if (var29 != null) {
					var5.a(var29);
					Entity var32 = var29;

					for (NBTCompoundTag var35 = var26; var35.isTagAssignableFrom("Riding", 10); var35 = var35.getCompound("Riding")) {
						Entity var37 = EntityTypes.a(var35.getCompound("Riding"), var1);
						if (var37 != null) {
							var5.a(var37);
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
				bcm var33 = bcm.c(var30);
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
