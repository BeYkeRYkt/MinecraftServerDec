package net.minecraft;

import java.util.Random;

public class BlockCrops extends auc implements atz {

	public static final bew a = bew.a("age", 0, 7);

	protected BlockCrops() {
		this.j(this.L.b().a(a, Integer.valueOf(0)));
		this.a(true);
		float var1 = 0.5F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
		this.a((CreativeModeTab) null);
		this.c(0.0F);
		this.a(h);
		this.J();
	}

	protected boolean c(Block var1) {
		return var1 == Blocks.FARMLAND;
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.l(var2.a()) >= 9) {
			int var5 = ((Integer) var3.b(a)).intValue();
			if (var5 < 7) {
				float var6 = a(this, var1, var2);
				if (var4.nextInt((int) (25.0F / var6) + 1) == 0) {
					var1.a(var2, var3.a(a, Integer.valueOf(var5 + 1)), 2);
				}
			}
		}

	}

	public void g(World var1, Position var2, bec var3) {
		int var4 = ((Integer) var3.b(a)).intValue() + DataTypesConverter.a(var1.s, 2, 5);
		if (var4 > 7) {
			var4 = 7;
		}

		var1.a(var2, var3.a(a, Integer.valueOf(var4)), 2);
	}

	protected static float a(Block var0, World var1, Position var2) {
		float var3 = 1.0F;
		Position var4 = var2.b();

		for (int var5 = -1; var5 <= 1; ++var5) {
			for (int var6 = -1; var6 <= 1; ++var6) {
				float var7 = 0.0F;
				bec var8 = var1.p(var4.a(var5, 0, var6));
				if (var8.getBlock() == Blocks.FARMLAND) {
					var7 = 1.0F;
					if (((Integer) var8.b(BlockSoil.a)).intValue() > 0) {
						var7 = 3.0F;
					}
				}

				if (var5 != 0 || var6 != 0) {
					var7 /= 4.0F;
				}

				var3 += var7;
			}
		}

		Position var12 = var2.c();
		Position var13 = var2.d();
		Position var14 = var2.e();
		Position var15 = var2.f();
		boolean var9 = var0 == var1.p(var14).getBlock() || var0 == var1.p(var15).getBlock();
		boolean var10 = var0 == var1.p(var12).getBlock() || var0 == var1.p(var13).getBlock();
		if (var9 && var10) {
			var3 /= 2.0F;
		} else {
			boolean var11 = var0 == var1.p(var14.c()).getBlock() || var0 == var1.p(var15.c()).getBlock() || var0 == var1.p(var15.d()).getBlock() || var0 == var1.p(var14.d()).getBlock();
			if (var11) {
				var3 /= 2.0F;
			}
		}

		return var3;
	}

	public boolean f(World var1, Position var2, bec var3) {
		return (var1.k(var2) >= 8 || var1.i(var2)) && this.c(var1.p(var2.b()).getBlock());
	}

	protected Item j() {
		return Items.N;
	}

	protected Item l() {
		return Items.O;
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, 0);
		if (!var1.D) {
			int var6 = ((Integer) var3.b(a)).intValue();
			if (var6 >= 7) {
				int var7 = 3 + var5;

				for (int var8 = 0; var8 < var7; ++var8) {
					if (var1.s.nextInt(15) <= var6) {
						a(var1, var2, new ItemStack(this.j(), 1, 0));
					}
				}
			}

		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return ((Integer) var1.b(a)).intValue() == 7 ? this.l() : this.j();
	}

	public boolean a(World var1, Position var2, bec var3, boolean var4) {
		return ((Integer) var3.b(a)).intValue() < 7;
	}

	public boolean a(World var1, Random var2, Position var3, bec var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, bec var4) {
		this.g(var1, var3, var4);
	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
