package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ChunkProviderDebug implements IChunkProvider {

	private static final List a = Lists.newArrayList();
	private static final int b;
	private final WorldServer c;

	public ChunkProviderDebug(WorldServer var1) {
		this.c = var1;
	}

	public Chunk getOrCreateChunk(int var1, int var2) {
		bgk var3 = new bgk();

		int var7;
		for (int var4 = 0; var4 < 16; ++var4) {
			for (int var5 = 0; var5 < 16; ++var5) {
				int var6 = var1 * 16 + var4;
				var7 = var2 * 16 + var5;
				var3.a(var4, 60, var5, Blocks.BARRIER.getBlockState());
				IBlockState var8 = b(var6, var7);
				if (var8 != null) {
					var3.a(var4, 70, var5, var8);
				}
			}
		}

		Chunk var9 = new Chunk(this.c, var3, var1, var2);
		var9.b();
		BiomeBase[] var10 = this.c.v().b((BiomeBase[]) null, var1 * 16, var2 * 16, 16, 16);
		byte[] var11 = var9.getBiomes();

		for (var7 = 0; var7 < var11.length; ++var7) {
			var11[var7] = (byte) var10[var7].az;
		}

		var9.b();
		return var9;
	}

	public static IBlockState b(int var0, int var1) {
		IBlockState var2 = null;
		if (var0 > 0 && var1 > 0 && var0 % 2 != 0 && var1 % 2 != 0) {
			var0 /= 2;
			var1 /= 2;
			if (var0 <= b && var1 <= b) {
				int var3 = MathHelper.a(var0 * b + var1);
				if (var3 < a.size()) {
					var2 = (IBlockState) a.get(var3);
				}
			}
		}

		return var2;
	}

	public boolean isChunkLoaded(int var1, int var2) {
		return true;
	}

	public void getChunkAt(IChunkProvider var1, int var2, int var3) {
	}

	public boolean ae(IChunkProvider var1, Chunk var2, int var3, int var4) {
		return false;
	}

	public boolean requestChunksSave(boolean var1, IProgressUpdate var2) {
		return true;
	}

	public void saveChunks() {
	}

	public boolean unloadChunks() {
		return false;
	}

	public boolean canSave() {
		return true;
	}

	public String getName() {
		return "DebugLevelSource";
	}

	public List getMobsFor(EnumCreatureType var1, Position var2) {
		BiomeBase var3 = this.c.b(var2);
		return var3.a(var1);
	}

	public Position findNearestMapFeature(World var1, String var2, Position var3) {
		return null;
	}

	public int getLoadedChunks() {
		return 0;
	}

	public void recreateStructures(Chunk var1, int var2, int var3) {
	}

	public Chunk getChunkAtWorldCoords(Position var1) {
		return this.getOrCreateChunk(var1.getX() >> 4, var1.getZ() >> 4);
	}

	static {
		Iterator var0 = Block.BLOCKREGISTRY.iterator();

		while (var0.hasNext()) {
			Block var1 = (Block) var0.next();
			a.addAll(var1.O().a());
		}

		b = MathHelper.f(MathHelper.c((float) a.size()));
	}
}
