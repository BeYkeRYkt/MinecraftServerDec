package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class auj extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	private final Random M = new Random();
	public final int b;

	protected auj(int var1) {
		super(bof.d);
		this.j(this.L.b().a(a, ej.c));
		this.b = var1;
		this.a(akf.c);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 2;
	}

	public void a(ard var1, dt var2) {
		if (var1.p(var2.c()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.p(var2.d()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (var1.p(var2.e()).c() == this) {
			this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.p(var2.f()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}

	}

	public void c(World var1, dt var2, bec var3) {
		this.e(var1, var2, var3);
		Iterator var4 = en.a.iterator();

		while (var4.hasNext()) {
			ej var5 = (ej) var4.next();
			dt var6 = var2.a(var5);
			bec var7 = var1.p(var6);
			if (var7.c() == this) {
				this.e(var1, var6, var7);
			}
		}

	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, var8.aO());
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
		ej var6 = ej.b(NumberConverter.c((double) (var4.y * 4.0F / 360.0F) + 0.5D) & 3).d();
		var3 = var3.a(a, var6);
		dt var7 = var2.c();
		dt var8 = var2.d();
		dt var9 = var2.e();
		dt var10 = var2.f();
		boolean var11 = this == var1.p(var7).c();
		boolean var12 = this == var1.p(var8).c();
		boolean var13 = this == var1.p(var9).c();
		boolean var14 = this == var1.p(var10).c();
		if (!var11 && !var12 && !var13 && !var14) {
			var1.a(var2, var3, 3);
		} else if (var6.k() == el.a && (var11 || var12)) {
			if (var11) {
				var1.a(var7, var3, 3);
			} else {
				var1.a(var8, var3, 3);
			}

			var1.a(var2, var3, 3);
		} else if (var6.k() == el.c && (var13 || var14)) {
			if (var13) {
				var1.a(var9, var3, 3);
			} else {
				var1.a(var10, var3, 3);
			}

			var1.a(var2, var3, 3);
		}

		if (var5.s()) {
			bcm var15 = var1.s(var2);
			if (var15 instanceof bcr) {
				((bcr) var15).a(var5.q());
			}
		}

	}

	public bec e(World var1, dt var2, bec var3) {
		if (var1.D) {
			return var3;
		} else {
			bec var4 = var1.p(var2.c());
			bec var5 = var1.p(var2.d());
			bec var6 = var1.p(var2.e());
			bec var7 = var1.p(var2.f());
			ej var8 = (ej) var3.b(a);
			atr var9 = var4.c();
			atr var10 = var5.c();
			atr var11 = var6.c();
			atr var12 = var7.c();
			if (var9 != this && var10 != this) {
				boolean var21 = var9.m();
				boolean var22 = var10.m();
				if (var11 == this || var12 == this) {
					dt var23 = var11 == this ? var2.e() : var2.f();
					bec var24 = var1.p(var23.c());
					bec var25 = var1.p(var23.d());
					var8 = ej.d;
					ej var26;
					if (var11 == this) {
						var26 = (ej) var6.b(a);
					} else {
						var26 = (ej) var7.b(a);
					}

					if (var26 == ej.c) {
						var8 = ej.c;
					}

					atr var19 = var24.c();
					atr var20 = var25.c();
					if ((var21 || var19.m()) && !var22 && !var20.m()) {
						var8 = ej.d;
					}

					if ((var22 || var20.m()) && !var21 && !var19.m()) {
						var8 = ej.c;
					}
				}
			} else {
				dt var13 = var9 == this ? var2.c() : var2.d();
				bec var14 = var1.p(var13.e());
				bec var15 = var1.p(var13.f());
				var8 = ej.f;
				ej var16;
				if (var9 == this) {
					var16 = (ej) var4.b(a);
				} else {
					var16 = (ej) var5.b(a);
				}

				if (var16 == ej.e) {
					var8 = ej.e;
				}

				atr var17 = var14.c();
				atr var18 = var15.c();
				if ((var11.m() || var17.m()) && !var12.m() && !var18.m()) {
					var8 = ej.f;
				}

				if ((var12.m() || var18.m()) && !var11.m() && !var17.m()) {
					var8 = ej.e;
				}
			}

			var3 = var3.a(a, var8);
			var1.a(var2, var3, 3);
			return var3;
		}
	}

	public bec f(World var1, dt var2, bec var3) {
		ej var4 = null;
		Iterator var5 = en.a.iterator();

		while (var5.hasNext()) {
			ej var6 = (ej) var5.next();
			bec var7 = var1.p(var2.a(var6));
			if (var7.c() == this) {
				return var3;
			}

			if (var7.c().m()) {
				if (var4 != null) {
					var4 = null;
					break;
				}

				var4 = var6;
			}
		}

		if (var4 != null) {
			return var3.a(a, var4.d());
		} else {
			ej var8 = (ej) var3.b(a);
			if (var1.p(var2.a(var8)).c().m()) {
				var8 = var8.d();
			}

			if (var1.p(var2.a(var8)).c().m()) {
				var8 = var8.e();
			}

			if (var1.p(var2.a(var8)).c().m()) {
				var8 = var8.d();
			}

			return var3.a(a, var8);
		}
	}

	public boolean c(World var1, dt var2) {
		int var3 = 0;
		dt var4 = var2.e();
		dt var5 = var2.f();
		dt var6 = var2.c();
		dt var7 = var2.d();
		if (var1.p(var4).c() == this) {
			if (this.e(var1, var4)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var5).c() == this) {
			if (this.e(var1, var5)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var6).c() == this) {
			if (this.e(var1, var6)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var7).c() == this) {
			if (this.e(var1, var7)) {
				return false;
			}

			++var3;
		}

		return var3 <= 1;
	}

	private boolean e(World var1, dt var2) {
		if (var1.p(var2).c() != this) {
			return false;
		} else {
			Iterator var3 = en.a.iterator();

			ej var4;
			do {
				if (!var3.hasNext()) {
					return false;
				}

				var4 = (ej) var3.next();
			} while (var1.p(var2.a(var4)).c() != this);

			return true;
		}
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		super.a(var1, var2, var3, var4);
		bcm var5 = var1.s(var2);
		if (var5 instanceof bcr) {
			var5.E();
		}

	}

	public void b(World var1, dt var2, bec var3) {
		bcm var4 = var1.s(var2);
		if (var4 instanceof vq) {
			vs.a(var1, var2, (vq) var4);
			var1.e(var2, this);
		}

		super.b(var1, var2, var3);
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			vy var9 = this.d(var1, var2);
			if (var9 != null) {
				var4.a((vq) var9);
			}

			return true;
		}
	}

	public vy d(World var1, dt var2) {
		bcm var3 = var1.s(var2);
		if (!(var3 instanceof bcr)) {
			return null;
		} else {
			Object var4 = (bcr) var3;
			if (this.m(var1, var2)) {
				return null;
			} else {
				Iterator var5 = en.a.iterator();

				while (var5.hasNext()) {
					ej var6 = (ej) var5.next();
					dt var7 = var2.a(var6);
					atr var8 = var1.p(var7).c();
					if (var8 == this) {
						if (this.m(var1, var7)) {
							return null;
						}

						bcm var9 = var1.s(var7);
						if (var9 instanceof bcr) {
							if (var6 != ej.e && var6 != ej.c) {
								var4 = new vp("container.chestDouble", (vy) var4, (bcr) var9);
							} else {
								var4 = new vp("container.chestDouble", (bcr) var9, (vy) var4);
							}
						}
					}
				}

				return (vy) var4;
			}
		}
	}

	public bcm a(World var1, int var2) {
		return new bcr();
	}

	public boolean g() {
		return this.b == 1;
	}

	public int a(ard var1, dt var2, bec var3, ej var4) {
		if (!this.g()) {
			return 0;
		} else {
			int var5 = 0;
			bcm var6 = var1.s(var2);
			if (var6 instanceof bcr) {
				var5 = ((bcr) var6).l;
			}

			return NumberConverter.a(var5, 0, 15);
		}
	}

	public int b(ard var1, dt var2, bec var3, ej var4) {
		return var4 == ej.b ? this.a(var1, var2, var3, var4) : 0;
	}

	private boolean m(World var1, dt var2) {
		return this.n(var1, var2) || this.o(var1, var2);
	}

	private boolean n(World var1, dt var2) {
		return var1.p(var2.a()).c().t();
	}

	private boolean o(World var1, dt var2) {
		Iterator var3 = var1.a(aby.class, new brt((double) var2.n(), (double) (var2.o() + 1), (double) var2.p(), (double) (var2.n() + 1), (double) (var2.o() + 2), (double) (var2.p() + 1))).iterator();

		aby var5;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			Entity var4 = (Entity) var3.next();
			var5 = (aby) var4;
		} while (!var5.cl());

		return true;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, dt var2) {
		return aib.b((vq) this.d(var1, var2));
	}

	public bec a(int var1) {
		ej var2 = ej.a(var1);
		if (var2.k() == el.b) {
			var2 = ej.c;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((ej) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
