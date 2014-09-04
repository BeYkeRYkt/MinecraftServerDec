package net.minecraft;

import java.util.Arrays;
import java.util.List;

public class ado extends Entity {

	private static final List d = Arrays.asList(new adp[] { (new adp(new amj(amk.T), 10)).a(0.9F), new adp(new amj(amk.aF), 10), new adp(new amj(amk.aX), 10), new adp(new amj(amk.bz), 10), new adp(new amj(amk.F), 5), (new adp(new amj(amk.aR), 2)).a(0.9F), new adp(new amj(amk.z), 10), new adp(new amj(amk.y), 5), new adp(new amj(amk.aW, 10, akv.p.b()), 1), new adp(new amj(aty.bR), 10), new adp(new amj(amk.bt), 10) });
	private static final List e = Arrays.asList(new adp[] { new adp(new amj(aty.bx), 1), new adp(new amj(amk.co), 1), new adp(new amj(amk.aA), 1), (new adp(new amj(amk.f), 1)).a(0.25F).a(), (new adp(new amj(amk.aR), 1)).a(0.25F).a(), (new adp(new amj(amk.aL), 1)).a() });
	private static final List f = Arrays.asList(new adp[] { new adp(new amj(amk.aU, 1, ali.a.a()), 60), new adp(new amj(amk.aU, 1, ali.b.a()), 25), new adp(new amj(amk.aU, 1, ali.c.a()), 2), new adp(new amj(amk.aU, 1, ali.d.a()), 13) });
	private int g = -1;
	private int h = -1;
	private int i = -1;
	private atr ap;
	private boolean aq;
	public int a;
	public ahd b;
	private int ar;
	private int as;
	private int at;
	private int au;
	private int av;
	private float aw;
	public Entity c;
	private int ax;
	private double ay;
	private double az;
	private double aA;
	private double aB;
	private double aC;

	public static List j() {
		return f;
	}

	public ado(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
		this.ah = true;
	}

	public ado(World var1, ahd var2) {
		super(var1);
		this.ah = true;
		this.b = var2;
		this.b.bE = this;
		this.a(0.25F, 0.25F);
		this.b(var2.s, var2.t + (double) var2.aR(), var2.u, var2.y, var2.z);
		this.s -= (double) (uv.b(this.y / 180.0F * 3.1415927F) * 0.16F);
		this.t -= 0.10000000149011612D;
		this.u -= (double) (uv.a(this.y / 180.0F * 3.1415927F) * 0.16F);
		this.b(this.s, this.t, this.u);
		float var3 = 0.4F;
		this.v = (double) (-uv.a(this.y / 180.0F * 3.1415927F) * uv.b(this.z / 180.0F * 3.1415927F) * var3);
		this.x = (double) (uv.b(this.y / 180.0F * 3.1415927F) * uv.b(this.z / 180.0F * 3.1415927F) * var3);
		this.w = (double) (-uv.a(this.z / 180.0F * 3.1415927F) * var3);
		this.c(this.v, this.w, this.x, 1.5F, 1.0F);
	}

	protected void h() {
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = uv.a(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var3 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var5 += this.V.nextGaussian() * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.v = var1;
		this.w = var3;
		this.x = var5;
		float var10 = uv.a(var1 * var1 + var5 * var5);
		this.A = this.y = (float) (Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
		this.B = this.z = (float) (Math.atan2(var3, (double) var10) * 180.0D / 3.1415927410125732D);
		this.ar = 0;
	}

	public void s_() {
		super.s_();
		if (this.ax > 0) {
			double var28 = this.s + (this.ay - this.s) / (double) this.ax;
			double var29 = this.t + (this.az - this.t) / (double) this.ax;
			double var30 = this.u + (this.aA - this.u) / (double) this.ax;
			double var7 = uv.g(this.aB - (double) this.y);
			this.y = (float) ((double) this.y + var7 / (double) this.ax);
			this.z = (float) ((double) this.z + (this.aC - (double) this.z) / (double) this.ax);
			--this.ax;
			this.b(var28, var29, var30);
			this.b(this.y, this.z);
		} else {
			if (!this.o.D) {
				amj var1 = this.b.bY();
				if (this.b.I || !this.b.ai() || var1 == null || var1.b() != amk.aR || this.h(this.b) > 1024.0D) {
					this.J();
					this.b.bE = null;
					return;
				}

				if (this.c != null) {
					if (!this.c.I) {
						this.s = this.c.s;
						double var10002 = (double) this.c.K;
						this.t = this.c.aQ().b + var10002 * 0.8D;
						this.u = this.c.u;
						return;
					}

					this.c = null;
				}
			}

			if (this.a > 0) {
				--this.a;
			}

			if (this.aq) {
				if (this.o.p(new dt(this.g, this.h, this.i)).c() == this.ap) {
					++this.ar;
					if (this.ar == 1200) {
						this.J();
					}

					return;
				}

				this.aq = false;
				this.v *= (double) (this.V.nextFloat() * 0.2F);
				this.w *= (double) (this.V.nextFloat() * 0.2F);
				this.x *= (double) (this.V.nextFloat() * 0.2F);
				this.ar = 0;
				this.as = 0;
			} else {
				++this.as;
			}

			brw var27 = new brw(this.s, this.t, this.u);
			brw var2 = new brw(this.s + this.v, this.t + this.w, this.u + this.x);
			bru var3 = this.o.a(var27, var2);
			var27 = new brw(this.s, this.t, this.u);
			var2 = new brw(this.s + this.v, this.t + this.w, this.u + this.x);
			if (var3 != null) {
				var2 = new brw(var3.c.a, var3.c.b, var3.c.c);
			}

			Entity var4 = null;
			List var5 = this.o.b((Entity) this, this.aQ().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;

			double var13;
			for (int var8 = 0; var8 < var5.size(); ++var8) {
				Entity var9 = (Entity) var5.get(var8);
				if (var9.ad() && (var9 != this.b || this.as >= 5)) {
					float var10 = 0.3F;
					brt var11 = var9.aQ().b((double) var10, (double) var10, (double) var10);
					bru var12 = var11.a(var27, var2);
					if (var12 != null) {
						var13 = var27.f(var12.c);
						if (var13 < var6 || var6 == 0.0D) {
							var4 = var9;
							var6 = var13;
						}
					}
				}
			}

			if (var4 != null) {
				var3 = new bru(var4);
			}

			if (var3 != null) {
				if (var3.d != null) {
					if (var3.d.a(wh.a((Entity) this, this.b), 0.0F)) {
						this.c = var3.d;
					}
				} else {
					this.aq = true;
				}
			}

			if (!this.aq) {
				this.d(this.v, this.w, this.x);
				float var31 = uv.a(this.v * this.v + this.x * this.x);
				this.y = (float) (Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);

				for (this.z = (float) (Math.atan2(this.w, (double) var31) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
					;
				}

				while (this.z - this.B >= 180.0F) {
					this.B += 360.0F;
				}

				while (this.y - this.A < -180.0F) {
					this.A -= 360.0F;
				}

				while (this.y - this.A >= 180.0F) {
					this.A += 360.0F;
				}

				this.z = this.B + (this.z - this.B) * 0.2F;
				this.y = this.A + (this.y - this.A) * 0.2F;
				float var32 = 0.92F;
				if (this.C || this.D) {
					var32 = 0.5F;
				}

				byte var33 = 5;
				double var34 = 0.0D;

				double var19;
				for (int var35 = 0; var35 < var33; ++var35) {
					brt var14 = this.aQ();
					double var15 = var14.e - var14.b;
					double var17 = var14.b + var15 * (double) var35 / (double) var33;
					var19 = var14.b + var15 * (double) (var35 + 1) / (double) var33;
					brt var21 = new brt(var14.a, var17, var14.c, var14.d, var19, var14.f);
					if (this.o.b(var21, bof.h)) {
						var34 += 1.0D / (double) var33;
					}
				}

				if (!this.o.D && var34 > 0.0D) {
					WorldServer var36 = (WorldServer) this.o;
					int var37 = 1;
					dt var38 = (new dt(this)).a();
					if (this.V.nextFloat() < 0.25F && this.o.C(var38)) {
						var37 = 2;
					}

					if (this.V.nextFloat() < 0.5F && !this.o.i(var38)) {
						--var37;
					}

					if (this.at > 0) {
						--this.at;
						if (this.at <= 0) {
							this.au = 0;
							this.av = 0;
						}
					} else {
						float var16;
						float var18;
						double var23;
						float var39;
						double var40;
						if (this.av > 0) {
							this.av -= var37;
							if (this.av <= 0) {
								this.w -= 0.20000000298023224D;
								this.a("random.splash", 0.25F, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
								var16 = (float) uv.c(this.aQ().b);
								var36.a(ew.e, this.s, (double) (var16 + 1.0F), this.u, (int) (1.0F + this.J * 20.0F), (double) this.J, 0.0D, (double) this.J, 0.20000000298023224D, new int[0]);
								var36.a(ew.g, this.s, (double) (var16 + 1.0F), this.u, (int) (1.0F + this.J * 20.0F), (double) this.J, 0.0D, (double) this.J, 0.20000000298023224D, new int[0]);
								this.at = uv.a(this.V, 10, 30);
							} else {
								this.aw = (float) ((double) this.aw + this.V.nextGaussian() * 4.0D);
								var16 = this.aw * 0.017453292F;
								var39 = uv.a(var16);
								var18 = uv.b(var16);
								var19 = this.s + (double) (var39 * (float) this.av * 0.1F);
								var40 = (double) ((float) uv.c(this.aQ().b) + 1.0F);
								var23 = this.u + (double) (var18 * (float) this.av * 0.1F);
								if (this.V.nextFloat() < 0.15F) {
									var36.a(ew.e, var19, var40 - 0.10000000149011612D, var23, 1, (double) var39, 0.1D, (double) var18, 0.0D, new int[0]);
								}

								float var25 = var39 * 0.04F;
								float var26 = var18 * 0.04F;
								var36.a(ew.g, var19, var40, var23, 0, (double) var26, 0.01D, (double) (-var25), 1.0D, new int[0]);
								var36.a(ew.g, var19, var40, var23, 0, (double) (-var26), 0.01D, (double) var25, 1.0D, new int[0]);
							}
						} else if (this.au > 0) {
							this.au -= var37;
							var16 = 0.15F;
							if (this.au < 20) {
								var16 = (float) ((double) var16 + (double) (20 - this.au) * 0.05D);
							} else if (this.au < 40) {
								var16 = (float) ((double) var16 + (double) (40 - this.au) * 0.02D);
							} else if (this.au < 60) {
								var16 = (float) ((double) var16 + (double) (60 - this.au) * 0.01D);
							}

							if (this.V.nextFloat() < var16) {
								var39 = uv.a(this.V, 0.0F, 360.0F) * 0.017453292F;
								var18 = uv.a(this.V, 25.0F, 60.0F);
								var19 = this.s + (double) (uv.a(var39) * var18 * 0.1F);
								var40 = (double) ((float) uv.c(this.aQ().b) + 1.0F);
								var23 = this.u + (double) (uv.b(var39) * var18 * 0.1F);
								var36.a(ew.f, var19, var40, var23, 2 + this.V.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
							}

							if (this.au <= 0) {
								this.aw = uv.a(this.V, 0.0F, 360.0F);
								this.av = uv.a(this.V, 20, 80);
							}
						} else {
							this.au = uv.a(this.V, 100, 900);
							this.au -= aph.h(this.b) * 20 * 5;
						}
					}

					if (this.at > 0) {
						this.w -= (double) (this.V.nextFloat() * this.V.nextFloat() * this.V.nextFloat()) * 0.2D;
					}
				}

				var13 = var34 * 2.0D - 1.0D;
				this.w += 0.03999999910593033D * var13;
				if (var34 > 0.0D) {
					var32 = (float) ((double) var32 * 0.9D);
					this.w *= 0.8D;
				}

				this.v *= (double) var32;
				this.w *= (double) var32;
				this.x *= (double) var32;
				this.b(this.s, this.t, this.u);
			}
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.a("xTile", (short) this.g);
		var1.a("yTile", (short) this.h);
		var1.a("zTile", (short) this.i);
		oa var2 = (oa) atr.c.c(this.ap);
		var1.a("inTile", var2 == null ? "" : var2.toString());
		var1.a("shake", (byte) this.a);
		var1.a("inGround", (byte) (this.aq ? 1 : 0));
	}

	public void a(NBTCompoundTag var1) {
		this.g = var1.e("xTile");
		this.h = var1.e("yTile");
		this.i = var1.e("zTile");
		if (var1.b("inTile", 8)) {
			this.ap = atr.b(var1.j("inTile"));
		} else {
			this.ap = atr.c(var1.d("inTile") & 255);
		}

		this.a = var1.d("shake") & 255;
		this.aq = var1.d("inGround") == 1;
	}

	public int l() {
		if (this.o.D) {
			return 0;
		} else {
			byte var1 = 0;
			if (this.c != null) {
				double var2 = this.b.s - this.s;
				double var4 = this.b.t - this.t;
				double var6 = this.b.u - this.u;
				double var8 = (double) uv.a(var2 * var2 + var4 * var4 + var6 * var6);
				double var10 = 0.1D;
				this.c.v += var2 * var10;
				this.c.w += var4 * var10 + (double) uv.a(var8) * 0.08D;
				this.c.x += var6 * var10;
				var1 = 3;
			} else if (this.at > 0) {
				adw var13 = new adw(this.o, this.s, this.t, this.u, this.m());
				double var3 = this.b.s - this.s;
				double var5 = this.b.t - this.t;
				double var7 = this.b.u - this.u;
				double var9 = (double) uv.a(var3 * var3 + var5 * var5 + var7 * var7);
				double var11 = 0.1D;
				var13.v = var3 * var11;
				var13.w = var5 * var11 + (double) uv.a(var9) * 0.08D;
				var13.x = var7 * var11;
				this.o.d((Entity) var13);
				this.b.o.d((Entity) (new xk(this.b.o, this.b.s, this.b.t + 0.5D, this.b.u + 0.5D, this.V.nextInt(6) + 1)));
				var1 = 1;
			}

			if (this.aq) {
				var1 = 2;
			}

			this.J();
			this.b.bE = null;
			return var1;
		}
	}

	private amj m() {
		float var1 = this.o.s.nextFloat();
		int var2 = aph.g(this.b);
		int var3 = aph.h(this.b);
		float var4 = 0.1F - (float) var2 * 0.025F - (float) var3 * 0.01F;
		float var5 = 0.05F + (float) var2 * 0.01F - (float) var3 * 0.01F;
		var4 = uv.a(var4, 0.0F, 1.0F);
		var5 = uv.a(var5, 0.0F, 1.0F);
		if (var1 < var4) {
			this.b.b(ty.D);
			return ((adp) vj.a(this.V, d)).a(this.V);
		} else {
			var1 -= var4;
			if (var1 < var5) {
				this.b.b(ty.E);
				return ((adp) vj.a(this.V, e)).a(this.V);
			} else {
				float var10000 = var1 - var5;
				this.b.b(ty.C);
				return ((adp) vj.a(this.V, f)).a(this.V);
			}
		}
	}

	public void J() {
		super.J();
		if (this.b != null) {
			this.b.bE = null;
		}

	}

}
