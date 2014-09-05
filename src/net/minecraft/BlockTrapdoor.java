package net.minecraft;

import com.google.common.base.Predicate;

public class BlockTrapdoor extends Block {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	public static final bet b = bet.a("open");
	public static final bev M = bev.a("half", bbr.class);

	protected BlockTrapdoor(Material var1) {
		super(var1);
		this.j(this.L.b().a(a, PaintingDirection.c).a(b, Boolean.valueOf(false)).a(M, bbr.b));
		float var2 = 0.5F;
		float var3 = 1.0F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.a(CreativeModeTab.d);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean b(ard var1, Position var2) {
		return !((Boolean) var1.p(var2).b(b)).booleanValue();
	}

	public brt a(World var1, Position var2, bec var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public void a(ard var1, Position var2) {
		this.d(var1.p(var2));
	}

	public void h() {
		float var1 = 0.1875F;
		this.a(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
	}

	public void d(bec var1) {
		if (var1.c() == this) {
			boolean var2 = var1.b(M) == bbr.a;
			Boolean var3 = (Boolean) var1.b(b);
			PaintingDirection var4 = (PaintingDirection) var1.b(a);
			float var5 = 0.1875F;
			if (var2) {
				this.a(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
			}

			if (var3.booleanValue()) {
				if (var4 == PaintingDirection.c) {
					this.a(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
				}

				if (var4 == PaintingDirection.d) {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
				}

				if (var4 == PaintingDirection.e) {
					this.a(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}

				if (var4 == PaintingDirection.f) {
					this.a(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
				}
			}

		}
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (this.J == Material.ORE) {
			return true;
		} else {
			var3 = var3.a(b);
			var1.a(var2, var3, 2);
			var1.a(var4, ((Boolean) var3.b(b)).booleanValue() ? 1003 : 1006, var2, 0);
			return true;
		}
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			Position var5 = var2.a(((PaintingDirection) var3.b(a)).d());
			if (!c(var1.p(var5).c())) {
				var1.g(var2);
				this.b(var1, var2, var3, 0);
			} else {
				boolean var6 = var1.z(var2);
				if (var6 || var4.g()) {
					boolean var7 = ((Boolean) var3.b(b)).booleanValue();
					if (var7 != var6) {
						var1.a(var2, var3.a(b, Boolean.valueOf(var6)), 2);
						var1.a((EntityHuman) null, var6 ? 1003 : 1006, var2, 0);
					}
				}

			}
		}
	}

	public bru a(World var1, Position var2, brw var3, brw var4) {
		this.a(var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	public bec a(World var1, Position var2, PaintingDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		bec var9 = this.P();
		if (var3.k().c()) {
			var9 = var9.a(a, var3).a(b, Boolean.valueOf(false));
			var9 = var9.a(M, var5 > 0.5F ? bbr.a : bbr.b);
		}

		return var9;
	}

	public boolean a(World var1, Position var2, PaintingDirection var3) {
		return !var3.k().b() && c(var1.p(var2.a(var3.d())).c());
	}

	protected static PaintingDirection b(int var0) {
		switch (var0 & 3) {
			case 0:
				return PaintingDirection.c;
			case 1:
				return PaintingDirection.d;
			case 2:
				return PaintingDirection.e;
			case 3:
			default:
				return PaintingDirection.f;
		}
	}

	protected static int a(PaintingDirection var0) {
		switch (bbq.a[var0.ordinal()]) {
			case 1:
				return 0;
			case 2:
				return 1;
			case 3:
				return 2;
			case 4:
			default:
				return 3;
		}
	}

	private static boolean c(Block var0) {
		return var0.J.k() && var0.d() || var0 == aty.aX || var0 instanceof awq || var0 instanceof BlockStairs;
	}

	public bec a(int var1) {
		return this.P().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 4) != 0)).a(M, (var1 & 8) == 0 ? bbr.b : bbr.a);
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | a((PaintingDirection) var1.b(a));
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 4;
		}

		if (var1.b(M) == bbr.a) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M });
	}

}
