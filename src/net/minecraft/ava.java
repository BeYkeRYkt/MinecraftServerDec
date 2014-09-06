package net.minecraft;

import java.util.Random;

public abstract class ava extends avb {

	protected final boolean M;

	protected ava(boolean var1) {
		super(Material.ORIENTABLE);
		this.M = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return World.a((ard) var1, var2.b()) ? super.c(var1, var2) : false;
	}

	public boolean d(World var1, Position var2) {
		return World.a((ard) var1, var2.b());
	}

	public void a(World var1, Position var2, bec var3, Random var4) {
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var5 = this.e(var1, var2, var3);
			if (this.M && !var5) {
				var1.a(var2, this.k(var3), 2);
			} else if (!this.M) {
				var1.a(var2, this.e(var3), 2);
				if (!var5) {
					var1.a(var2, this.e(var3).getBlock(), this.m(var3), -1);
				}
			}

		}
	}

	protected boolean l(bec var1) {
		return this.M;
	}

	public int b(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return this.a(var1, var2, var3, var4);
	}

	public int a(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return !this.l(var3) ? 0 : (var3.b(N) == var4 ? this.a(var1, var2, var3) : 0);
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (this.d(var1, var2)) {
			this.g(var1, var2, var3);
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			PaintingDirection[] var5 = PaintingDirection.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				PaintingDirection var8 = var5[var7];
				var1.c(var2.a(var8), (Block) this);
			}

		}
	}

	protected void g(World var1, Position var2, bec var3) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var4 = this.e(var1, var2, var3);
			if ((this.M && !var4 || !this.M && var4) && !var1.a(var2, (Block) this)) {
				byte var5 = -1;
				if (this.i(var1, var2, var3)) {
					var5 = -3;
				} else if (this.M) {
					var5 = -2;
				}

				var1.a(var2, this, this.d(var3), var5);
			}

		}
	}

	public boolean b(ard var1, Position var2, bec var3) {
		return false;
	}

	protected boolean e(World var1, Position var2, bec var3) {
		return this.f(var1, var2, var3) > 0;
	}

	protected int f(World var1, Position var2, bec var3) {
		PaintingDirection var4 = (PaintingDirection) var3.b(N);
		Position var5 = var2.a(var4);
		int var6 = var1.c(var5, var4);
		if (var6 >= 15) {
			return var6;
		} else {
			bec var7 = var1.p(var5);
			return Math.max(var6, var7.getBlock() == aty.af ? ((Integer) var7.b(BlockRedstoneWire.O)).intValue() : 0);
		}
	}

	protected int c(ard var1, Position var2, bec var3) {
		PaintingDirection var4 = (PaintingDirection) var3.b(N);
		PaintingDirection var5 = var4.e();
		PaintingDirection var6 = var4.f();
		return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
	}

	protected int c(ard var1, Position var2, PaintingDirection var3) {
		bec var4 = var1.p(var2);
		Block var5 = var4.getBlock();
		return this.c(var5) ? (var5 == aty.af ? ((Integer) var4.b(BlockRedstoneWire.O)).intValue() : var1.a(var2, var3)) : 0;
	}

	public boolean g() {
		return true;
	}

	public bec a(World var1, Position var2, PaintingDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(N, var8.aO().d());
	}

	public void a(World var1, Position var2, bec var3, EntityLiving var4, ItemStack var5) {
		if (this.e(var1, var2, var3)) {
			var1.a(var2, (Block) this, 1);
		}

	}

	public void c(World var1, Position var2, bec var3) {
		this.h(var1, var2, var3);
	}

	protected void h(World var1, Position var2, bec var3) {
		PaintingDirection var4 = (PaintingDirection) var3.b(N);
		Position var5 = var2.a(var4.d());
		var1.d(var5, this);
		var1.a(var5, (Block) this, var4);
	}

	public void d(World var1, Position var2, bec var3) {
		if (this.M) {
			PaintingDirection[] var4 = PaintingDirection.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				PaintingDirection var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}
		}

		super.d(var1, var2, var3);
	}

	public boolean c() {
		return false;
	}

	protected boolean c(Block var1) {
		return var1.g();
	}

	protected int a(ard var1, Position var2, bec var3) {
		return 15;
	}

	public static boolean d(Block var0) {
		return aty.bb.e(var0) || aty.cj.e(var0);
	}

	public boolean e(Block var1) {
		return var1 == this.e(this.P()).getBlock() || var1 == this.k(this.P()).getBlock();
	}

	public boolean i(World var1, Position var2, bec var3) {
		PaintingDirection var4 = ((PaintingDirection) var3.b(N)).d();
		Position var5 = var2.a(var4);
		return d(var1.p(var5).getBlock()) ? var1.p(var5).b(N) != var4 : false;
	}

	protected int m(bec var1) {
		return this.d(var1);
	}

	protected abstract int d(bec var1);

	protected abstract bec e(bec var1);

	protected abstract bec k(bec var1);

	public boolean b(Block var1) {
		return this.e(var1);
	}
}
