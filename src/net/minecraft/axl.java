package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public abstract class axl extends Block {

	public static final bew b = bew.a("level", 0, 15);

	protected axl(bof var1) {
		super(var1);
		this.j(this.L.b().a(b, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.a(true);
	}

	public boolean b(ard var1, Position var2) {
		return this.J != bof.i;
	}

	public static float b(int var0) {
		if (var0 >= 8) {
			var0 = 0;
		}

		return (float) (var0 + 1) / 9.0F;
	}

	protected int e(ard var1, Position var2) {
		return var1.p(var2).c().r() == this.J ? ((Integer) var1.p(var2).b(b)).intValue() : -1;
	}

	protected int f(ard var1, Position var2) {
		int var3 = this.e(var1, var2);
		return var3 >= 8 ? 0 : var3;
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean a(bec var1, boolean var2) {
		return var2 && ((Integer) var1.b(b)).intValue() == 0;
	}

	public boolean b(ard var1, Position var2, PaintingDirection var3) {
		bof var4 = var1.p(var2).c().r();
		return var4 == this.J ? false : (var3 == PaintingDirection.b ? true : (var4 == bof.w ? false : super.b(var1, var2, var3)));
	}

	public brt a(World var1, Position var2, bec var3) {
		return null;
	}

	public int b() {
		return 1;
	}

	public Item a(bec var1, Random var2, int var3) {
		return null;
	}

	public int a(Random var1) {
		return 0;
	}

	protected brw h(ard var1, Position var2) {
		brw var3 = new brw(0.0D, 0.0D, 0.0D);
		int var4 = this.f(var1, var2);
		Iterator var5 = en.a.iterator();

		PaintingDirection var6;
		Position var7;
		while (var5.hasNext()) {
			var6 = (PaintingDirection) var5.next();
			var7 = var2.a(var6);
			int var8 = this.f(var1, var7);
			int var9;
			if (var8 < 0) {
				if (!var1.p(var7).c().r().c()) {
					var8 = this.f(var1, var7.b());
					if (var8 >= 0) {
						var9 = var8 - (var4 - 8);
						var3 = var3.b((double) ((var7.n() - var2.n()) * var9), (double) ((var7.o() - var2.o()) * var9), (double) ((var7.p() - var2.p()) * var9));
					}
				}
			} else if (var8 >= 0) {
				var9 = var8 - var4;
				var3 = var3.b((double) ((var7.n() - var2.n()) * var9), (double) ((var7.o() - var2.o()) * var9), (double) ((var7.p() - var2.p()) * var9));
			}
		}

		if (((Integer) var1.p(var2).b(b)).intValue() >= 8) {
			var5 = en.a.iterator();

			while (var5.hasNext()) {
				var6 = (PaintingDirection) var5.next();
				var7 = var2.a(var6);
				if (this.b(var1, var7, var6) || this.b(var1, var7.a(), var6)) {
					var3 = var3.a().b(0.0D, -6.0D, 0.0D);
					break;
				}
			}
		}

		return var3.a();
	}

	public brw a(World var1, Position var2, Entity var3, brw var4) {
		return var4.e(this.h(var1, var2));
	}

	public int a(World var1) {
		return this.J == bof.h ? 5 : (this.J == bof.i ? (var1.worldProvider.o() ? 10 : 30) : 0);
	}

	public void c(World var1, Position var2, bec var3) {
		this.e(var1, var2, var3);
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		this.e(var1, var2, var3);
	}

	public boolean e(World var1, Position var2, bec var3) {
		if (this.J == bof.i) {
			boolean var4 = false;
			PaintingDirection[] var5 = PaintingDirection.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				PaintingDirection var8 = var5[var7];
				if (var8 != PaintingDirection.a && var1.p(var2.a(var8)).c().r() == bof.h) {
					var4 = true;
					break;
				}
			}

			if (var4) {
				Integer var9 = (Integer) var3.b(b);
				if (var9.intValue() == 0) {
					var1.a(var2, aty.Z.P());
					this.d(var1, var2);
					return true;
				}

				if (var9.intValue() <= 4) {
					var1.a(var2, aty.e.P());
					this.d(var1, var2);
					return true;
				}
			}
		}

		return false;
	}

	protected void d(World var1, Position var2) {
		double var3 = (double) var2.n();
		double var5 = (double) var2.o();
		double var7 = (double) var2.p();
		var1.a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

		for (int var9 = 0; var9 < 8; ++var9) {
			var1.a(ew.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	public bec a(int var1) {
		return this.P().a(b, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(b)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { b });
	}

	public static avn a(bof var0) {
		if (var0 == bof.h) {
			return aty.i;
		} else if (var0 == bof.i) {
			return aty.k;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

	public static bax b(bof var0) {
		if (var0 == bof.h) {
			return aty.j;
		} else if (var0 == bof.i) {
			return aty.l;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

}
