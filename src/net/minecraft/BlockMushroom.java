package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class BlockMushroom extends auc implements atz {

	protected BlockMushroom() {
		float var1 = 0.2F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
		this.a(true);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (var4.nextInt(25) == 0) {
			int var5 = 5;
			boolean var6 = true;
			Iterator var7 = Position.b(var2.a(-4, -1, -4), var2.a(4, 1, 4)).iterator();

			while (var7.hasNext()) {
				Position var8 = (Position) var7.next();
				if (var1.getBlockState(var8).getBlock() == this) {
					--var5;
					if (var5 <= 0) {
						return;
					}
				}
			}

			Position var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);

			for (int var10 = 0; var10 < 4; ++var10) {
				if (var1.d(var9) && this.f(var1, var9, this.getBlockState())) {
					var2 = var9;
				}

				var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);
			}

			if (var1.d(var9) && this.f(var1, var9, this.getBlockState())) {
				var1.setBlockAt(var9, this.getBlockState(), 2);
			}
		}

	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) && this.f(var1, var2, this.getBlockState());
	}

	protected boolean c(Block var1) {
		return var1.m();
	}

	public boolean f(World var1, Position var2, IBlockState var3) {
		if (var2.getY() >= 0 && var2.getY() < 256) {
			IBlockState var4 = var1.getBlockState(var2.getDown());
			return var4.getBlock() == Blocks.MYCELIUM ? true : (var4.getBlock() == Blocks.DIRT && var4.b(BlockDirt.a) == avd.c ? true : var1.k(var2) < 13 && this.c(var4.getBlock()));
		} else {
			return false;
		}
	}

	public boolean d(World var1, Position var2, IBlockState var3, Random var4) {
		var1.g(var2);
		WorldGenHugeMushroom var5 = null;
		if (this == Blocks.BRWON_MUSHROOM) {
			var5 = new WorldGenHugeMushroom(0);
		} else if (this == Blocks.RED_MUSHROOM) {
			var5 = new WorldGenHugeMushroom(1);
		}

		if (var5 != null && var5.b(var1, var4, var2)) {
			return true;
		} else {
			var1.setBlockAt(var2, var3, 3);
			return false;
		}
	}

	public boolean a(World var1, Position var2, IBlockState var3, boolean var4) {
		return true;
	}

	public boolean a(World var1, Random var2, Position var3, IBlockState var4) {
		return (double) var2.nextFloat() < 0.4D;
	}

	public void b(World var1, Random var2, Position var3, IBlockState var4) {
		this.d(var1, var3, var4, var2);
	}
}
