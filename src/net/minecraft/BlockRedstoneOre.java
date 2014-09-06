package net.minecraft;

import java.util.Random;

public class BlockRedstoneOre extends Block {

	private final boolean a;

	public BlockRedstoneOre(boolean var1) {
		super(Material.STONE);
		if (var1) {
			this.a(true);
		}

		this.a = var1;
	}

	public int a(World var1) {
		return 30;
	}

	public void a(World var1, Position var2, EntityHuman var3) {
		this.d(var1, var2);
		super.a(var1, var2, var3);
	}

	public void a(World var1, Position var2, Entity var3) {
		this.d(var1, var2);
		super.a(var1, var2, var3);
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		this.d(var1, var2);
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
	}

	private void d(World var1, Position var2) {
		this.e(var1, var2);
		if (this == Blocks.REDSTONE_ORE) {
			var1.a(var2, Blocks.LIT_REDSTONE_ORE.P());
		}

	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (this == Blocks.LIT_REDSTONE_ORE) {
			var1.a(var2, Blocks.REDSTONE_ORE.P());
		}

	}

	public Item a(bec var1, Random var2, int var3) {
		return Items.aC;
	}

	public int a(int var1, Random var2) {
		return this.a(var2) + var2.nextInt(var1 + 1);
	}

	public int a(Random var1) {
		return 4 + var1.nextInt(2);
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (this.a(var3, var1.s, var5) != Item.getItemOf((Block) this)) {
			int var6 = 1 + var1.s.nextInt(5);
			this.b(var1, var2, var6);
		}

	}

	private void e(World var1, Position var2) {
		Random var3 = var1.s;
		double var4 = 0.0625D;

		for (int var6 = 0; var6 < 6; ++var6) {
			double var7 = (double) ((float) var2.getX() + var3.nextFloat());
			double var9 = (double) ((float) var2.getY() + var3.nextFloat());
			double var11 = (double) ((float) var2.getZ() + var3.nextFloat());
			if (var6 == 0 && !var1.p(var2.a()).getBlock().c()) {
				var9 = (double) var2.getY() + var4 + 1.0D;
			}

			if (var6 == 1 && !var1.p(var2.b()).getBlock().c()) {
				var9 = (double) var2.getY() - var4;
			}

			if (var6 == 2 && !var1.p(var2.d()).getBlock().c()) {
				var11 = (double) var2.getZ() + var4 + 1.0D;
			}

			if (var6 == 3 && !var1.p(var2.c()).getBlock().c()) {
				var11 = (double) var2.getZ() - var4;
			}

			if (var6 == 4 && !var1.p(var2.f()).getBlock().c()) {
				var7 = (double) var2.getX() + var4 + 1.0D;
			}

			if (var6 == 5 && !var1.p(var2.e()).getBlock().c()) {
				var7 = (double) var2.getX() - var4;
			}

			if (var7 < (double) var2.getX() || var7 > (double) (var2.getX() + 1) || var9 < 0.0D || var9 > (double) (var2.getY() + 1) || var11 < (double) var2.getZ() || var11 > (double) (var2.getZ() + 1)) {
				var1.a(Particle.E, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}

	}

	protected ItemStack i(bec var1) {
		return new ItemStack(Blocks.REDSTONE_ORE);
	}
}
