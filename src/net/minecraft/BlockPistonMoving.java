package net.minecraft;

import java.util.Random;

public class BlockPistonMoving extends atg {

	public static final beu a = BlockPistonExtension.a;
	public static final bev b = BlockPistonExtension.b;

	public BlockPistonMoving() {
		super(Material.PISTON);
		this.j(this.L.b().a(a, PaintingDirection.c).a(b, bdu.a));
		this.c(-1.0F);
	}

	public bcm a(World var1, int var2) {
		return null;
	}

	public static bcm a(bec var0, PaintingDirection var1, boolean var2, boolean var3) {
		return new bdv(var0, var1, var2, var3);
	}

	public void b(World var1, Position var2, bec var3) {
		bcm var4 = var1.s(var2);
		if (var4 instanceof bdv) {
			((bdv) var4).h();
		} else {
			super.b(var1, var2, var3);
		}

	}

	public boolean c(World var1, Position var2) {
		return false;
	}

	public boolean a(World var1, Position var2, PaintingDirection var3) {
		return false;
	}

	public void d(World var1, Position var2, bec var3) {
		Position var4 = var2.a(((PaintingDirection) var3.b(a)).d());
		bec var5 = var1.p(var4);
		if (var5.c() instanceof BlockPiston && ((Boolean) var5.b(BlockPiston.b)).booleanValue()) {
			var1.g(var4);
		}

	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (!var1.D && var1.s(var2) == null) {
			var1.g(var2);
			return true;
		} else {
			return false;
		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return null;
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		if (!var1.D) {
			bdv var6 = this.e(var1, var2);
			if (var6 != null) {
				bec var7 = var6.b();
				var7.c().b(var1, var2, var7, 0);
			}
		}
	}

	public bru a(World var1, Position var2, brw var3, brw var4) {
		return null;
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			var1.s(var2);
		}

	}

	public brt a(World var1, Position var2, bec var3) {
		bdv var4 = this.e(var1, var2);
		if (var4 == null) {
			return null;
		} else {
			float var5 = var4.a(0.0F);
			if (var4.d()) {
				var5 = 1.0F - var5;
			}

			return this.a(var1, var2, var4.b(), var5, var4.e());
		}
	}

	public void a(ard var1, Position var2) {
		bdv var3 = this.e(var1, var2);
		if (var3 != null) {
			bec var4 = var3.b();
			Block var5 = var4.c();
			if (var5 == this || var5.r() == Material.AIR) {
				return;
			}

			float var6 = var3.a(0.0F);
			if (var3.d()) {
				var6 = 1.0F - var6;
			}

			var5.a(var1, var2);
			if (var5 == aty.J || var5 == aty.F) {
				var6 = 0.0F;
			}

			PaintingDirection var7 = var3.e();
			this.B = var5.z() - (double) ((float) var7.g() * var6);
			this.C = var5.B() - (double) ((float) var7.h() * var6);
			this.D = var5.D() - (double) ((float) var7.i() * var6);
			this.E = var5.A() - (double) ((float) var7.g() * var6);
			this.F = var5.C() - (double) ((float) var7.h() * var6);
			this.G = var5.E() - (double) ((float) var7.i() * var6);
		}

	}

	public brt a(World var1, Position var2, bec var3, float var4, PaintingDirection var5) {
		if (var3.c() != this && var3.c().r() != Material.AIR) {
			brt var6 = var3.c().a(var1, var2, var3);
			if (var6 == null) {
				return null;
			} else {
				double var7 = var6.a;
				double var9 = var6.b;
				double var11 = var6.c;
				double var13 = var6.d;
				double var15 = var6.e;
				double var17 = var6.f;
				if (var5.g() < 0) {
					var7 -= (double) ((float) var5.g() * var4);
				} else {
					var13 -= (double) ((float) var5.g() * var4);
				}

				if (var5.h() < 0) {
					var9 -= (double) ((float) var5.h() * var4);
				} else {
					var15 -= (double) ((float) var5.h() * var4);
				}

				if (var5.i() < 0) {
					var11 -= (double) ((float) var5.i() * var4);
				} else {
					var17 -= (double) ((float) var5.i() * var4);
				}

				return new brt(var7, var9, var11, var13, var15, var17);
			}
		} else {
			return null;
		}
	}

	private bdv e(ard var1, Position var2) {
		bcm var3 = var1.s(var2);
		return var3 instanceof bdv ? (bdv) var3 : null;
	}

	public bec a(int var1) {
		return this.P().a(a, BlockPistonExtension.b(var1)).a(b, (var1 & 8) > 0 ? bdu.b : bdu.a);
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((PaintingDirection) var1.b(a)).a();
		if (var1.b(b) == bdu.b) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
