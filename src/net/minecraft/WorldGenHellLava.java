package net.minecraft;

import java.util.Random;

public class WorldGenHellLava extends WorldGenerator {

	private final Block a;
	private final boolean b;

	public WorldGenHellLava(Block var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		if (var1.getBlockState(var3.getUp()).getBlock() != Blocks.NETHERRACK) {
			return false;
		} else if (var1.getBlockState(var3).getBlock().getMaterial() != Material.AIR && var1.getBlockState(var3).getBlock() != Blocks.NETHERRACK) {
			return false;
		} else {
			int var4 = 0;
			if (var1.getBlockState(var3.getWest()).getBlock() == Blocks.NETHERRACK) {
				++var4;
			}

			if (var1.getBlockState(var3.getEast()).getBlock() == Blocks.NETHERRACK) {
				++var4;
			}

			if (var1.getBlockState(var3.getNorth()).getBlock() == Blocks.NETHERRACK) {
				++var4;
			}

			if (var1.getBlockState(var3.getSouth()).getBlock() == Blocks.NETHERRACK) {
				++var4;
			}

			if (var1.getBlockState(var3.getDown()).getBlock() == Blocks.NETHERRACK) {
				++var4;
			}

			int var5 = 0;
			if (var1.d(var3.getWest())) {
				++var5;
			}

			if (var1.d(var3.getEast())) {
				++var5;
			}

			if (var1.d(var3.getNorth())) {
				++var5;
			}

			if (var1.d(var3.getSouth())) {
				++var5;
			}

			if (var1.d(var3.getDown())) {
				++var5;
			}

			if (!this.b && var4 == 4 && var5 == 1 || var4 == 5) {
				var1.setBlockAt(var3, this.a.getBlockState(), 2);
				var1.a(this.a, var3, var2);
			}

			return true;
		}
	}
}
