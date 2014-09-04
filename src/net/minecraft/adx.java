package net.minecraft;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public abstract class adx extends Entity implements vz {

	private boolean a;
	private String b;
	private static final int[][][] c = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
	private int d;
	private double e;
	private double f;
	private double g;
	private double h;
	private double i;

	public adx(World var1) {
		super(var1);
		this.k = true;
		this.a(0.98F, 0.7F);
	}

	public static adx a(World var0, double var1, double var3, double var5, adz var7) {
		switch (ady.a[var7.ordinal()]) {
			case 1:
				return new aea(var0, var1, var3, var5);
			case 2:
				return new aee(var0, var1, var3, var5);
			case 3:
				return new aej(var0, var1, var3, var5);
			case 4:
				return new aeh(var0, var1, var3, var5);
			case 5:
				return new aef(var0, var1, var3, var5);
			case 6:
				return new aeb(var0, var1, var3, var5);
			default:
				return new aeg(var0, var1, var3, var5);
		}
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.ac.a(17, new Integer(0));
		this.ac.a(18, new Integer(1));
		this.ac.a(19, new Float(0.0F));
		this.ac.a(20, new Integer(0));
		this.ac.a(21, new Integer(6));
		this.ac.a(22, Byte.valueOf((byte) 0));
	}

	public brt j(Entity var1) {
		return var1.ae() ? var1.aQ() : null;
	}

	public brt S() {
		return null;
	}

	public boolean ae() {
		return true;
	}

	public adx(World var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		this.v = 0.0D;
		this.w = 0.0D;
		this.x = 0.0D;
		this.p = var2;
		this.q = var4;
		this.r = var6;
	}

	public double an() {
		return (double) this.K * 0.5D - 0.20000000298023224D;
	}

	public boolean a(wh var1, float var2) {
		if (!this.o.D && !this.I) {
			if (this.b(var1)) {
				return false;
			} else {
				this.k(-this.r());
				this.j(10);
				this.ac();
				this.a(this.p() + var2 * 10.0F);
				boolean var3 = var1.j() instanceof ahd && ((ahd) var1.j()).by.instabuild;
				if (var3 || this.p() > 40.0F) {
					if (this.l != null) {
						this.l.a((Entity) null);
					}

					if (var3 && !this.k_()) {
						this.J();
					} else {
						this.a(var1);
					}
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public void a(wh var1) {
		this.J();
		amj var2 = new amj(amk.az, 1);
		if (this.b != null) {
			var2.c(this.b);
		}

		this.a(var2, 0.0F);
	}

	public boolean ad() {
		return !this.I;
	}

	public void J() {
		super.J();
	}

	public void s_() {
		if (this.q() > 0) {
			this.j(this.q() - 1);
		}

		if (this.p() > 0.0F) {
			this.a(this.p() - 1.0F);
		}

		if (this.t < -64.0D) {
			this.O();
		}

		int var2;
		if (!this.o.D && this.o instanceof WorldServer) {
			this.o.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.o).r();
			var2 = this.L();
			if (this.ak) {
				if (var1.isNetherAllowed()) {
					if (this.m == null && this.al++ >= var2) {
						this.al = var2;
						this.aj = this.ar();
						byte var3;
						if (this.o.t.q() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.c(var3);
					}

					this.ak = false;
				}
			} else {
				if (this.al > 0) {
					this.al -= 4;
				}

				if (this.al < 0) {
					this.al = 0;
				}
			}

			if (this.aj > 0) {
				--this.aj;
			}

			this.o.B.b();
		}

		if (this.o.D) {
			if (this.d > 0) {
				double var15 = this.s + (this.e - this.s) / (double) this.d;
				double var17 = this.t + (this.f - this.t) / (double) this.d;
				double var18 = this.u + (this.g - this.u) / (double) this.d;
				double var7 = NumberConverter.g(this.h - (double) this.y);
				this.y = (float) ((double) this.y + var7 / (double) this.d);
				this.z = (float) ((double) this.z + (this.i - (double) this.z) / (double) this.d);
				--this.d;
				this.b(var15, var17, var18);
				this.b(this.y, this.z);
			} else {
				this.b(this.s, this.t, this.u);
				this.b(this.y, this.z);
			}

		} else {
			this.p = this.s;
			this.q = this.t;
			this.r = this.u;
			this.w -= 0.03999999910593033D;
			int var14 = NumberConverter.c(this.s);
			var2 = NumberConverter.c(this.t);
			int var16 = NumberConverter.c(this.u);
			if (ati.d(this.o, new dt(var14, var2 - 1, var16))) {
				--var2;
			}

			dt var4 = new dt(var14, var2, var16);
			bec var5 = this.o.p(var4);
			if (ati.d(var5)) {
				this.a(var4, var5);
				if (var5.c() == aty.cs) {
					this.a(var14, var2, var16, ((Boolean) var5.b(azc.M)).booleanValue());
				}
			} else {
				this.n();
			}

			this.Q();
			this.z = 0.0F;
			double var6 = this.p - this.s;
			double var8 = this.r - this.u;
			if (var6 * var6 + var8 * var8 > 0.001D) {
				this.y = (float) (Math.atan2(var8, var6) * 180.0D / 3.141592653589793D);
				if (this.a) {
					this.y += 180.0F;
				}
			}

			double var10 = (double) NumberConverter.g(this.y - this.A);
			if (var10 < -170.0D || var10 >= 170.0D) {
				this.y += 180.0F;
				this.a = !this.a;
			}

			this.b(this.y, this.z);
			Iterator var12 = this.o.b((Entity) this, this.aQ().b(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

			while (var12.hasNext()) {
				Entity var13 = (Entity) var12.next();
				if (var13 != this.l && var13.ae() && var13 instanceof adx) {
					var13.i(this);
				}
			}

			if (this.l != null && this.l.I) {
				if (this.l.m == this) {
					this.l.m = null;
				}

				this.l = null;
			}

			this.W();
		}
	}

	protected double m() {
		return 0.4D;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
	}

	protected void n() {
		double var1 = this.m();
		this.v = NumberConverter.a(this.v, -var1, var1);
		this.x = NumberConverter.a(this.x, -var1, var1);
		if (this.C) {
			this.v *= 0.5D;
			this.w *= 0.5D;
			this.x *= 0.5D;
		}

		this.d(this.v, this.w, this.x);
		if (!this.C) {
			this.v *= 0.949999988079071D;
			this.w *= 0.949999988079071D;
			this.x *= 0.949999988079071D;
		}

	}

	protected void a(dt var1, bec var2) {
		this.O = 0.0F;
		brw var3 = this.k(this.s, this.t, this.u);
		this.t = (double) var1.o();
		boolean var4 = false;
		boolean var5 = false;
		ati var6 = (ati) var2.c();
		if (var6 == aty.D) {
			var4 = ((Boolean) var2.b(azc.M)).booleanValue();
			var5 = !var4;
		}

		double var7 = 0.0078125D;
		atl var9 = (atl) var2.b(var6.l());
		switch (ady.b[var9.ordinal()]) {
			case 1:
				this.v -= 0.0078125D;
				++this.t;
				break;
			case 2:
				this.v += 0.0078125D;
				++this.t;
				break;
			case 3:
				this.x += 0.0078125D;
				++this.t;
				break;
			case 4:
				this.x -= 0.0078125D;
				++this.t;
		}

		int[][] var10 = c[var9.a()];
		double var11 = (double) (var10[1][0] - var10[0][0]);
		double var13 = (double) (var10[1][2] - var10[0][2]);
		double var15 = Math.sqrt(var11 * var11 + var13 * var13);
		double var17 = this.v * var11 + this.x * var13;
		if (var17 < 0.0D) {
			var11 = -var11;
			var13 = -var13;
		}

		double var19 = Math.sqrt(this.v * this.v + this.x * this.x);
		if (var19 > 2.0D) {
			var19 = 2.0D;
		}

		this.v = var19 * var11 / var15;
		this.x = var19 * var13 / var15;
		double var21;
		double var23;
		double var25;
		double var27;
		if (this.l instanceof EntityLiving) {
			var21 = (double) ((EntityLiving) this.l).aY;
			if (var21 > 0.0D) {
				var23 = -Math.sin((double) (this.l.y * 3.1415927F / 180.0F));
				var25 = Math.cos((double) (this.l.y * 3.1415927F / 180.0F));
				var27 = this.v * this.v + this.x * this.x;
				if (var27 < 0.01D) {
					this.v += var23 * 0.1D;
					this.x += var25 * 0.1D;
					var5 = false;
				}
			}
		}

		if (var5) {
			var21 = Math.sqrt(this.v * this.v + this.x * this.x);
			if (var21 < 0.03D) {
				this.v *= 0.0D;
				this.w *= 0.0D;
				this.x *= 0.0D;
			} else {
				this.v *= 0.5D;
				this.w *= 0.0D;
				this.x *= 0.5D;
			}
		}

		var21 = 0.0D;
		var23 = (double) var1.n() + 0.5D + (double) var10[0][0] * 0.5D;
		var25 = (double) var1.p() + 0.5D + (double) var10[0][2] * 0.5D;
		var27 = (double) var1.n() + 0.5D + (double) var10[1][0] * 0.5D;
		double var29 = (double) var1.p() + 0.5D + (double) var10[1][2] * 0.5D;
		var11 = var27 - var23;
		var13 = var29 - var25;
		double var31;
		double var33;
		if (var11 == 0.0D) {
			this.s = (double) var1.n() + 0.5D;
			var21 = this.u - (double) var1.p();
		} else if (var13 == 0.0D) {
			this.u = (double) var1.p() + 0.5D;
			var21 = this.s - (double) var1.n();
		} else {
			var31 = this.s - var23;
			var33 = this.u - var25;
			var21 = (var31 * var11 + var33 * var13) * 2.0D;
		}

		this.s = var23 + var11 * var21;
		this.u = var25 + var13 * var21;
		this.b(this.s, this.t, this.u);
		var31 = this.v;
		var33 = this.x;
		if (this.l != null) {
			var31 *= 0.75D;
			var33 *= 0.75D;
		}

		double var35 = this.m();
		var31 = NumberConverter.a(var31, -var35, var35);
		var33 = NumberConverter.a(var33, -var35, var35);
		this.d(var31, 0.0D, var33);
		if (var10[0][1] != 0 && NumberConverter.c(this.s) - var1.n() == var10[0][0] && NumberConverter.c(this.u) - var1.p() == var10[0][2]) {
			this.b(this.s, this.t + (double) var10[0][1], this.u);
		} else if (var10[1][1] != 0 && NumberConverter.c(this.s) - var1.n() == var10[1][0] && NumberConverter.c(this.u) - var1.p() == var10[1][2]) {
			this.b(this.s, this.t + (double) var10[1][1], this.u);
		}

		this.o();
		brw var37 = this.k(this.s, this.t, this.u);
		if (var37 != null && var3 != null) {
			double var38 = (var3.b - var37.b) * 0.05D;
			var19 = Math.sqrt(this.v * this.v + this.x * this.x);
			if (var19 > 0.0D) {
				this.v = this.v / var19 * (var19 + var38);
				this.x = this.x / var19 * (var19 + var38);
			}

			this.b(this.s, var37.b, this.u);
		}

		int var44 = NumberConverter.c(this.s);
		int var39 = NumberConverter.c(this.u);
		if (var44 != var1.n() || var39 != var1.p()) {
			var19 = Math.sqrt(this.v * this.v + this.x * this.x);
			this.v = var19 * (double) (var44 - var1.n());
			this.x = var19 * (double) (var39 - var1.p());
		}

		if (var4) {
			double var40 = Math.sqrt(this.v * this.v + this.x * this.x);
			if (var40 > 0.01D) {
				double var42 = 0.06D;
				this.v += this.v / var40 * var42;
				this.x += this.x / var40 * var42;
			} else if (var9 == atl.b) {
				if (this.o.p(var1.e()).c().t()) {
					this.v = 0.02D;
				} else if (this.o.p(var1.f()).c().t()) {
					this.v = -0.02D;
				}
			} else if (var9 == atl.a) {
				if (this.o.p(var1.c()).c().t()) {
					this.x = 0.02D;
				} else if (this.o.p(var1.d()).c().t()) {
					this.x = -0.02D;
				}
			}
		}

	}

	protected void o() {
		if (this.l != null) {
			this.v *= 0.996999979019165D;
			this.w *= 0.0D;
			this.x *= 0.996999979019165D;
		} else {
			this.v *= 0.9599999785423279D;
			this.w *= 0.0D;
			this.x *= 0.9599999785423279D;
		}

	}

	public void b(double var1, double var3, double var5) {
		this.s = var1;
		this.t = var3;
		this.u = var5;
		float var7 = this.J / 2.0F;
		float var8 = this.K;
		this.a(new brt(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public brw k(double var1, double var3, double var5) {
		int var7 = NumberConverter.c(var1);
		int var8 = NumberConverter.c(var3);
		int var9 = NumberConverter.c(var5);
		if (ati.d(this.o, new dt(var7, var8 - 1, var9))) {
			--var8;
		}

		bec var10 = this.o.p(new dt(var7, var8, var9));
		if (ati.d(var10)) {
			atl var11 = (atl) var10.b(((ati) var10.c()).l());
			int[][] var12 = c[var11.a()];
			double var13 = 0.0D;
			double var15 = (double) var7 + 0.5D + (double) var12[0][0] * 0.5D;
			double var17 = (double) var8 + 0.0625D + (double) var12[0][1] * 0.5D;
			double var19 = (double) var9 + 0.5D + (double) var12[0][2] * 0.5D;
			double var21 = (double) var7 + 0.5D + (double) var12[1][0] * 0.5D;
			double var23 = (double) var8 + 0.0625D + (double) var12[1][1] * 0.5D;
			double var25 = (double) var9 + 0.5D + (double) var12[1][2] * 0.5D;
			double var27 = var21 - var15;
			double var29 = (var23 - var17) * 2.0D;
			double var31 = var25 - var19;
			if (var27 == 0.0D) {
				var1 = (double) var7 + 0.5D;
				var13 = var5 - (double) var9;
			} else if (var31 == 0.0D) {
				var5 = (double) var9 + 0.5D;
				var13 = var1 - (double) var7;
			} else {
				double var33 = var1 - var15;
				double var35 = var5 - var19;
				var13 = (var33 * var27 + var35 * var31) * 2.0D;
			}

			var1 = var15 + var27 * var13;
			var3 = var17 + var29 * var13;
			var5 = var19 + var31 * var13;
			if (var29 < 0.0D) {
				++var3;
			}

			if (var29 > 0.0D) {
				var3 += 0.5D;
			}

			return new brw(var1, var3, var5);
		} else {
			return null;
		}
	}

	protected void a(NBTCompoundTag var1) {
		if (var1.getBoolean("CustomDisplayTile")) {
			int var2 = var1.getInt("DisplayData");
			atr var3;
			if (var1.isTagAssignableFrom("DisplayTile", 8)) {
				var3 = atr.b(var1.getString("DisplayTile"));
				if (var3 == null) {
					this.a(aty.a.P());
				} else {
					this.a(var3.a(var2));
				}
			} else {
				var3 = atr.c(var1.getInt("DisplayTile"));
				if (var3 == null) {
					this.a(aty.a.P());
				} else {
					this.a(var3.a(var2));
				}
			}

			this.l(var1.getInt("DisplayOffset"));
		}

		if (var1.isTagAssignableFrom("CustomName", 8) && var1.getString("CustomName").length() > 0) {
			this.b = var1.getString("CustomName");
		}

	}

	protected void b(NBTCompoundTag var1) {
		if (this.x()) {
			var1.put("CustomDisplayTile", true);
			bec var2 = this.t();
			oa var3 = (oa) atr.c.c(var2.c());
			var1.put("DisplayTile", var3 == null ? "" : var3.toString());
			var1.put("DisplayData", var2.c().c(var2));
			var1.put("DisplayOffset", this.v());
		}

		if (this.b != null && this.b.length() > 0) {
			var1.put("CustomName", this.b);
		}

	}

	public void i(Entity var1) {
		if (!this.o.D) {
			if (!var1.T && !this.T) {
				if (var1 != this.l) {
					if (var1 instanceof EntityLiving && !(var1 instanceof ahd) && !(var1 instanceof acq) && this.s() == adz.a && this.v * this.v + this.x * this.x > 0.01D && this.l == null && var1.m == null) {
						var1.a((Entity) this);
					}

					double var2 = var1.s - this.s;
					double var4 = var1.u - this.u;
					double var6 = var2 * var2 + var4 * var4;
					if (var6 >= 9.999999747378752E-5D) {
						var6 = (double) NumberConverter.a(var6);
						var2 /= var6;
						var4 /= var6;
						double var8 = 1.0D / var6;
						if (var8 > 1.0D) {
							var8 = 1.0D;
						}

						var2 *= var8;
						var4 *= var8;
						var2 *= 0.10000000149011612D;
						var4 *= 0.10000000149011612D;
						var2 *= (double) (1.0F - this.U);
						var4 *= (double) (1.0F - this.U);
						var2 *= 0.5D;
						var4 *= 0.5D;
						if (var1 instanceof adx) {
							double var10 = var1.s - this.s;
							double var12 = var1.u - this.u;
							brw var14 = (new brw(var10, 0.0D, var12)).a();
							brw var15 = (new brw((double) NumberConverter.b(this.y * 3.1415927F / 180.0F), 0.0D, (double) NumberConverter.a(this.y * 3.1415927F / 180.0F))).a();
							double var16 = Math.abs(var14.b(var15));
							if (var16 < 0.800000011920929D) {
								return;
							}

							double var18 = var1.v + this.v;
							double var20 = var1.x + this.x;
							if (((adx) var1).s() == adz.c && this.s() != adz.c) {
								this.v *= 0.20000000298023224D;
								this.x *= 0.20000000298023224D;
								this.g(var1.v - var2, 0.0D, var1.x - var4);
								var1.v *= 0.949999988079071D;
								var1.x *= 0.949999988079071D;
							} else if (((adx) var1).s() != adz.c && this.s() == adz.c) {
								var1.v *= 0.20000000298023224D;
								var1.x *= 0.20000000298023224D;
								var1.g(this.v + var2, 0.0D, this.x + var4);
								this.v *= 0.949999988079071D;
								this.x *= 0.949999988079071D;
							} else {
								var18 /= 2.0D;
								var20 /= 2.0D;
								this.v *= 0.20000000298023224D;
								this.x *= 0.20000000298023224D;
								this.g(var18 - var2, 0.0D, var20 - var4);
								var1.v *= 0.20000000298023224D;
								var1.x *= 0.20000000298023224D;
								var1.g(var18 + var2, 0.0D, var20 + var4);
							}
						} else {
							this.g(-var2, 0.0D, -var4);
							var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
						}
					}

				}
			}
		}
	}

	public void a(float var1) {
		this.ac.b(19, Float.valueOf(var1));
	}

	public float p() {
		return this.ac.d(19);
	}

	public void j(int var1) {
		this.ac.b(17, Integer.valueOf(var1));
	}

	public int q() {
		return this.ac.c(17);
	}

	public void k(int var1) {
		this.ac.b(18, Integer.valueOf(var1));
	}

	public int r() {
		return this.ac.c(18);
	}

	public abstract adz s();

	public bec t() {
		return !this.x() ? this.u() : atr.d(this.H().c(20));
	}

	public bec u() {
		return aty.a.P();
	}

	public int v() {
		return !this.x() ? this.w() : this.H().c(21);
	}

	public int w() {
		return 6;
	}

	public void a(bec var1) {
		this.H().b(20, Integer.valueOf(atr.f(var1)));
		this.a(true);
	}

	public void l(int var1) {
		this.H().b(21, Integer.valueOf(var1));
		this.a(true);
	}

	public boolean x() {
		return this.H().a(22) == 1;
	}

	public void a(boolean var1) {
		this.H().b(22, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public void a(String var1) {
		this.b = var1;
	}

	public String d_() {
		return this.b != null ? this.b : super.d_();
	}

	public boolean k_() {
		return this.b != null;
	}

	public String aL() {
		return this.b;
	}

	public ho e_() {
		if (this.k_()) {
			hy var2 = new hy(this.b);
			var2.b().a(this.aP());
			var2.b().a(this.aJ().toString());
			return var2;
		} else {
			hz var1 = new hz(this.d_(), new Object[0]);
			var1.b().a(this.aP());
			var1.b().a(this.aJ().toString());
			return var1;
		}
	}

}
