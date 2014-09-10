package net.minecraft;

public class bft {

	public static bfu a(NBTCompoundTag var0) {
		int var1 = var0.getInt("xPos");
		int var2 = var0.getInt("zPos");
		bfu var3 = new bfu(var1, var2);
		var3.g = var0.getByteArray("Blocks");
		var3.f = new bfn(var0.getByteArray("Data"), 7);
		var3.e = new bfn(var0.getByteArray("SkyLight"), 7);
		var3.d = new bfn(var0.getByteArray("BlockLight"), 7);
		var3.c = var0.getByteArray("HeightMap");
		var3.b = var0.getBoolean("TerrainPopulated");
		var3.h = var0.getList("Entities", 10);
		var3.i = var0.getList("TileEntities", 10);
		var3.j = var0.getList("TileTicks", 10);

		try {
			var3.a = var0.getLong("LastUpdate");
		} catch (ClassCastException var5) {
			var3.a = (long) var0.getInt("LastUpdate");
		}

		return var3;
	}

	public static void a(bfu var0, NBTCompoundTag var1, WorldChunkManager var2) {
		var1.put("xPos", var0.k);
		var1.put("zPos", var0.l);
		var1.put("LastUpdate", var0.a);
		int[] var3 = new int[var0.c.length];

		for (int var4 = 0; var4 < var0.c.length; ++var4) {
			var3[var4] = var0.c[var4];
		}

		var1.put("HeightMap", var3);
		var1.put("TerrainPopulated", var0.b);
		NBTListTag var16 = new NBTListTag();

		int var7;
		for (int var5 = 0; var5 < 8; ++var5) {
			boolean var6 = true;

			for (var7 = 0; var7 < 16 && var6; ++var7) {
				int var8 = 0;

				while (var8 < 16 && var6) {
					int var9 = 0;

					while (true) {
						if (var9 < 16) {
							int var10 = var7 << 11 | var9 << 7 | var8 + (var5 << 4);
							byte var11 = var0.g[var10];
							if (var11 == 0) {
								++var9;
								continue;
							}

							var6 = false;
						}

						++var8;
						break;
					}
				}
			}

			if (!var6) {
				byte[] var19 = new byte[4096];
				ChunkNibbleArray var20 = new ChunkNibbleArray();
				ChunkNibbleArray var21 = new ChunkNibbleArray();
				ChunkNibbleArray var22 = new ChunkNibbleArray();

				for (int var23 = 0; var23 < 16; ++var23) {
					for (int var12 = 0; var12 < 16; ++var12) {
						for (int var13 = 0; var13 < 16; ++var13) {
							int var14 = var23 << 11 | var13 << 7 | var12 + (var5 << 4);
							byte var15 = var0.g[var14];
							var19[var12 << 8 | var13 << 4 | var23] = (byte) (var15 & 255);
							var20.setValue(var23, var12, var13, var0.f.a(var23, var12 + (var5 << 4), var13));
							var21.setValue(var23, var12, var13, var0.e.a(var23, var12 + (var5 << 4), var13));
							var22.setValue(var23, var12, var13, var0.d.a(var23, var12 + (var5 << 4), var13));
						}
					}
				}

				NBTCompoundTag var24 = new NBTCompoundTag();
				var24.put("Y", (byte) (var5 & 255));
				var24.put("Blocks", var19);
				var24.put("Data", var20.getArray());
				var24.put("SkyLight", var21.getArray());
				var24.put("BlockLight", var22.getArray());
				var16.addTag((NBTTag) var24);
			}
		}

		var1.put("Sections", (NBTTag) var16);
		byte[] var17 = new byte[256];

		for (int var18 = 0; var18 < 16; ++var18) {
			for (var7 = 0; var7 < 16; ++var7) {
				var17[var7 << 4 | var18] = (byte) (var2.a(new Position(var0.k << 4 | var18, 0, var0.l << 4 | var7), BiomeBase.ad).az & 255);
			}
		}

		var1.put("Biomes", var17);
		var1.put("Entities", (NBTTag) var0.h);
		var1.put("TileEntities", (NBTTag) var0.i);
		if (var0.j != null) {
			var1.put("TileTicks", (NBTTag) var0.j);
		}

	}
}
