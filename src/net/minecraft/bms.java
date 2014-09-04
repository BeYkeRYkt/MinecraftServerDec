package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class bms {

	protected bjb l;
	protected ej m;
	protected int n;

	public bms() {
	}

	protected bms(int var1) {
		this.n = var1;
	}

	public NBTCompoundTag b() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.put("id", bmq.a(this));
		var1.put("BB", (NBTTag) this.l.g());
		var1.put("O", this.m == null ? -1 : this.m.b());
		var1.put("GD", this.n);
		this.a(var1);
		return var1;
	}

	protected abstract void a(NBTCompoundTag var1);

	public void a(World var1, NBTCompoundTag var2) {
		if (var2.hasKey("BB")) {
			this.l = new bjb(var2.getIntArray("BB"));
		}

		int var3 = var2.getInt("O");
		this.m = var3 == -1 ? null : ej.b(var3);
		this.n = var2.getInt("GD");
		this.b(var2);
	}

	protected abstract void b(NBTCompoundTag var1);

	public void a(bms var1, List var2, Random var3) {
	}

	public abstract boolean a(World var1, Random var2, bjb var3);

	public bjb c() {
		return this.l;
	}

	public int d() {
		return this.n;
	}

	public static bms a(List var0, bjb var1) {
		Iterator var2 = var0.iterator();

		bms var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (bms) var2.next();
		} while (var3.c() == null || !var3.c().a(var1));

		return var3;
	}

	public dt a() {
		return new dt(this.l.f());
	}

	protected boolean a(World var1, bjb var2) {
		int var3 = Math.max(this.l.a - 1, var2.a);
		int var4 = Math.max(this.l.b - 1, var2.b);
		int var5 = Math.max(this.l.c - 1, var2.c);
		int var6 = Math.min(this.l.d + 1, var2.d);
		int var7 = Math.min(this.l.e + 1, var2.e);
		int var8 = Math.min(this.l.f + 1, var2.f);

		int var9;
		int var10;
		for (var9 = var3; var9 <= var6; ++var9) {
			for (var10 = var5; var10 <= var8; ++var10) {
				if (var1.p(new dt(var9, var4, var10)).c().r().d()) {
					return true;
				}

				if (var1.p(new dt(var9, var7, var10)).c().r().d()) {
					return true;
				}
			}
		}

		for (var9 = var3; var9 <= var6; ++var9) {
			for (var10 = var4; var10 <= var7; ++var10) {
				if (var1.p(new dt(var9, var10, var5)).c().r().d()) {
					return true;
				}

				if (var1.p(new dt(var9, var10, var8)).c().r().d()) {
					return true;
				}
			}
		}

		for (var9 = var5; var9 <= var8; ++var9) {
			for (var10 = var4; var10 <= var7; ++var10) {
				if (var1.p(new dt(var3, var10, var9)).c().r().d()) {
					return true;
				}

				if (var1.p(new dt(var6, var10, var9)).c().r().d()) {
					return true;
				}
			}
		}

		return false;
	}

	protected int a(int var1, int var2) {
		if (this.m == null) {
			return var1;
		} else {
			switch (bmt.a[this.m.ordinal()]) {
				case 1:
				case 2:
					return this.l.a + var1;
				case 3:
					return this.l.d - var2;
				case 4:
					return this.l.a + var2;
				default:
					return var1;
			}
		}
	}

	protected int d(int var1) {
		return this.m == null ? var1 : var1 + this.l.b;
	}

	protected int b(int var1, int var2) {
		if (this.m == null) {
			return var2;
		} else {
			switch (bmt.a[this.m.ordinal()]) {
				case 1:
					return this.l.f - var2;
				case 2:
					return this.l.c + var2;
				case 3:
				case 4:
					return this.l.c + var1;
				default:
					return var2;
			}
		}
	}

	protected int a(atr var1, int var2) {
		if (var1 == aty.av) {
			if (this.m == ej.e || this.m == ej.f) {
				if (var2 == 1) {
					return 0;
				}

				return 1;
			}
		} else if (var1 instanceof avf) {
			if (this.m == ej.d) {
				if (var2 == 0) {
					return 2;
				}

				if (var2 == 2) {
					return 0;
				}
			} else {
				if (this.m == ej.e) {
					return var2 + 1 & 3;
				}

				if (this.m == ej.f) {
					return var2 + 3 & 3;
				}
			}
		} else if (var1 != aty.aw && var1 != aty.ad && var1 != aty.bA && var1 != aty.bv && var1 != aty.bO) {
			if (var1 == aty.au) {
				if (this.m == ej.d) {
					if (var2 == ej.c.a()) {
						return ej.d.a();
					}

					if (var2 == ej.d.a()) {
						return ej.c.a();
					}
				} else if (this.m == ej.e) {
					if (var2 == ej.c.a()) {
						return ej.e.a();
					}

					if (var2 == ej.d.a()) {
						return ej.f.a();
					}

					if (var2 == ej.e.a()) {
						return ej.c.a();
					}

					if (var2 == ej.f.a()) {
						return ej.d.a();
					}
				} else if (this.m == ej.f) {
					if (var2 == ej.c.a()) {
						return ej.f.a();
					}

					if (var2 == ej.d.a()) {
						return ej.e.a();
					}

					if (var2 == ej.e.a()) {
						return ej.c.a();
					}

					if (var2 == ej.f.a()) {
						return ej.d.a();
					}
				}
			} else if (var1 == aty.aG) {
				if (this.m == ej.d) {
					if (var2 == 3) {
						return 4;
					}

					if (var2 == 4) {
						return 3;
					}
				} else if (this.m == ej.e) {
					if (var2 == 3) {
						return 1;
					}

					if (var2 == 4) {
						return 2;
					}

					if (var2 == 2) {
						return 3;
					}

					if (var2 == 1) {
						return 4;
					}
				} else if (this.m == ej.f) {
					if (var2 == 3) {
						return 2;
					}

					if (var2 == 4) {
						return 1;
					}

					if (var2 == 2) {
						return 3;
					}

					if (var2 == 1) {
						return 4;
					}
				}
			} else if (var1 != aty.bR && !(var1 instanceof avb)) {
				if (var1 == aty.J || var1 == aty.F || var1 == aty.ay || var1 == aty.z) {
					if (this.m == ej.d) {
						if (var2 == ej.c.a() || var2 == ej.d.a()) {
							return ej.a(var2).d().a();
						}
					} else if (this.m == ej.e) {
						if (var2 == ej.c.a()) {
							return ej.e.a();
						}

						if (var2 == ej.d.a()) {
							return ej.f.a();
						}

						if (var2 == ej.e.a()) {
							return ej.c.a();
						}

						if (var2 == ej.f.a()) {
							return ej.d.a();
						}
					} else if (this.m == ej.f) {
						if (var2 == ej.c.a()) {
							return ej.f.a();
						}

						if (var2 == ej.d.a()) {
							return ej.e.a();
						}

						if (var2 == ej.e.a()) {
							return ej.c.a();
						}

						if (var2 == ej.f.a()) {
							return ej.d.a();
						}
					}
				}
			} else {
				ej var3 = ej.b(var2);
				if (this.m == ej.d) {
					if (var3 == ej.d || var3 == ej.c) {
						return var3.d().b();
					}
				} else if (this.m == ej.e) {
					if (var3 == ej.c) {
						return ej.e.b();
					}

					if (var3 == ej.d) {
						return ej.f.b();
					}

					if (var3 == ej.e) {
						return ej.c.b();
					}

					if (var3 == ej.f) {
						return ej.d.b();
					}
				} else if (this.m == ej.f) {
					if (var3 == ej.c) {
						return ej.f.b();
					}

					if (var3 == ej.d) {
						return ej.e.b();
					}

					if (var3 == ej.e) {
						return ej.c.b();
					}

					if (var3 == ej.f) {
						return ej.d.b();
					}
				}
			}
		} else if (this.m == ej.d) {
			if (var2 == 2) {
				return 3;
			}

			if (var2 == 3) {
				return 2;
			}
		} else if (this.m == ej.e) {
			if (var2 == 0) {
				return 2;
			}

			if (var2 == 1) {
				return 3;
			}

			if (var2 == 2) {
				return 0;
			}

			if (var2 == 3) {
				return 1;
			}
		} else if (this.m == ej.f) {
			if (var2 == 0) {
				return 2;
			}

			if (var2 == 1) {
				return 3;
			}

			if (var2 == 2) {
				return 1;
			}

			if (var2 == 3) {
				return 0;
			}
		}

		return var2;
	}

	protected void a(World var1, bec var2, int var3, int var4, int var5, bjb var6) {
		dt var7 = new dt(this.a(var3, var5), this.d(var4), this.b(var3, var5));
		if (var6.b((fd) var7)) {
			var1.a(var7, var2, 2);
		}
	}

	protected bec a(World var1, int var2, int var3, int var4, bjb var5) {
		int var6 = this.a(var2, var4);
		int var7 = this.d(var3);
		int var8 = this.b(var2, var4);
		return !var5.b((fd) (new dt(var6, var7, var8))) ? aty.a.P() : var1.p(new dt(var6, var7, var8));
	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		for (int var9 = var4; var9 <= var7; ++var9) {
			for (int var10 = var3; var10 <= var6; ++var10) {
				for (int var11 = var5; var11 <= var8; ++var11) {
					this.a(var1, aty.a.P(), var10, var9, var11, var2);
				}
			}
		}

	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, bec var9, bec var10, boolean var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var11 || this.a(var1, var13, var12, var14, var2).c().r() != bof.a) {
						if (var12 != var4 && var12 != var7 && var13 != var3 && var13 != var6 && var14 != var5 && var14 != var8) {
							this.a(var1, var10, var13, var12, var14, var2);
						} else {
							this.a(var1, var9, var13, var12, var14, var2);
						}
					}
				}
			}
		}

	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, bmu var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var9 || this.a(var1, var13, var12, var14, var2).c().r() != bof.a) {
						var11.a(var10, var13, var12, var14, var12 == var4 || var12 == var7 || var13 == var3 || var13 == var6 || var14 == var5 || var14 == var8);
						this.a(var1, var11.a(), var13, var12, var14, var2);
					}
				}
			}
		}

	}

	protected void a(World var1, bjb var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, bec var11, bec var12, boolean var13) {
		for (int var14 = var6; var14 <= var9; ++var14) {
			for (int var15 = var5; var15 <= var8; ++var15) {
				for (int var16 = var7; var16 <= var10; ++var16) {
					if (var3.nextFloat() <= var4 && (!var13 || this.a(var1, var15, var14, var16, var2).c().r() != bof.a)) {
						if (var14 != var6 && var14 != var9 && var15 != var5 && var15 != var8 && var16 != var7 && var16 != var10) {
							this.a(var1, var12, var15, var14, var16, var2);
						} else {
							this.a(var1, var11, var15, var14, var16, var2);
						}
					}
				}
			}
		}

	}

	protected void a(World var1, bjb var2, Random var3, float var4, int var5, int var6, int var7, bec var8) {
		if (var3.nextFloat() < var4) {
			this.a(var1, var8, var5, var6, var7, var2);
		}

	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, bec var9, boolean var10) {
		float var11 = (float) (var6 - var3 + 1);
		float var12 = (float) (var7 - var4 + 1);
		float var13 = (float) (var8 - var5 + 1);
		float var14 = (float) var3 + var11 / 2.0F;
		float var15 = (float) var5 + var13 / 2.0F;

		for (int var16 = var4; var16 <= var7; ++var16) {
			float var17 = (float) (var16 - var4) / var12;

			for (int var18 = var3; var18 <= var6; ++var18) {
				float var19 = ((float) var18 - var14) / (var11 * 0.5F);

				for (int var20 = var5; var20 <= var8; ++var20) {
					float var21 = ((float) var20 - var15) / (var13 * 0.5F);
					if (!var10 || this.a(var1, var18, var16, var20, var2).c().r() != bof.a) {
						float var22 = var19 * var19 + var17 * var17 + var21 * var21;
						if (var22 <= 1.05F) {
							this.a(var1, var9, var18, var16, var20, var2);
						}
					}
				}
			}
		}

	}

	protected void b(World var1, int var2, int var3, int var4, bjb var5) {
		dt var6 = new dt(this.a(var2, var4), this.d(var3), this.b(var2, var4));
		if (var5.b((fd) var6)) {
			while (!var1.d(var6) && var6.o() < 255) {
				var1.a(var6, aty.a.P(), 2);
				var6 = var6.a();
			}

		}
	}

	protected void b(World var1, bec var2, int var3, int var4, int var5, bjb var6) {
		int var7 = this.a(var3, var5);
		int var8 = this.d(var4);
		int var9 = this.b(var3, var5);
		if (var6.b((fd) (new dt(var7, var8, var9)))) {
			while ((var1.d(new dt(var7, var8, var9)) || var1.p(new dt(var7, var8, var9)).c().r().d()) && var8 > 1) {
				var1.a(new dt(var7, var8, var9), var2, 2);
				--var8;
			}

		}
	}

	protected boolean a(World var1, bjb var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
		dt var9 = new dt(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var9) && var1.p(var9).c() != aty.ae) {
			bec var10 = aty.ae.P();
			var1.a(var9, aty.ae.f(var1, var9, var10), 2);
			bcm var11 = var1.s(var9);
			if (var11 instanceof bcr) {
				vl.a(var3, var7, (vq) ((bcr) var11), var8);
			}

			return true;
		} else {
			return false;
		}
	}

	protected boolean a(World var1, bjb var2, Random var3, int var4, int var5, int var6, int var7, List var8, int var9) {
		dt var10 = new dt(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var10) && var1.p(var10).c() != aty.z) {
			var1.a(var10, aty.z.a(this.a(aty.z, var7)), 2);
			bcm var11 = var1.s(var10);
			if (var11 instanceof bcx) {
				vl.a(var3, var8, (bcx) var11, var9);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(World var1, bjb var2, Random var3, int var4, int var5, int var6, ej var7) {
		dt var8 = new dt(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b((fd) var8)) {
			akt.a(var1, var8, var7.f(), aty.ao);
		}

	}
}
