package net.minecraft;

import java.util.Random;

class WorldGenStrongholdStones extends bmu {

	private WorldGenStrongholdStones() {
	}

	public void a(Random var1, int var2, int var3, int var4, boolean var5) {
		if (var5) {
			float var6 = var1.nextFloat();
			if (var6 < 0.2F) {
				this.a = Blocks.STONEBRICK.a(BlockSmoothBrick.N);
			} else if (var6 < 0.5F) {
				this.a = Blocks.STONEBRICK.a(BlockSmoothBrick.M);
			} else if (var6 < 0.55F) {
				this.a = Blocks.MONSTER_EGG.a(axu.c.a());
			} else {
				this.a = Blocks.STONEBRICK.getBlockState();
			}
		} else {
			this.a = Blocks.AIR.getBlockState();
		}

	}

	// $FF: synthetic method
	WorldGenStrongholdStones(WorldGenStrongholdUnknown var1) {
		this();
	}
}
