package net.minecraft;

import java.util.List;

public class adu extends Entity {

	private boolean a;
	private double b;
	private int c;
	private double d;
	private double e;
	private double f;
	private double g;
	private double h;

	public adu(World var1) {
		super(var1);
		this.a = true;
		this.b = 0.07D;
		this.k = true;
		this.a(1.5F, 0.6F);
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.ac.a(17, new Integer(0));
		this.ac.a(18, new Integer(1));
		this.ac.a(19, new Float(0.0F));
	}

	public brt j(Entity var1) {
		return var1.aQ();
	}

	public brt S() {
		return this.aQ();
	}

	public boolean ae() {
		return true;
	}

	public adu(World var1, double var2, double var4, double var6) {
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
		return (double) this.K * 0.0D - 0.30000001192092896D;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!this.o.D && !this.I) {
			if (this.l != null && this.l == var1.j() && var1 instanceof wj) {
				return false;
			} else {
				this.b(-this.m());
				this.a(10);
				this.a(this.j() + var2 * 10.0F);
				this.ac();
				boolean var3 = var1.j() instanceof ahd && ((ahd) var1.j()).by.instabuild;
				if (var3 || this.j() > 40.0F) {
					if (this.l != null) {
						this.l.a((Entity) this);
					}

					if (!var3) {
						this.a(amk.aE, 1, 0.0F);
					}

					this.J();
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public boolean ad() {
		return !this.I;
	}

	public void s_() {
		super.s_();
		if (this.l() > 0) {
			this.a(this.l() - 1);
		}

		if (this.j() > 0.0F) {
			this.a(this.j() - 1.0F);
		}

		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		byte var1 = 5;
		double var2 = 0.0D;

		for (int var4 = 0; var4 < var1; ++var4) {
			double var5 = this.aQ().b + (this.aQ().e - this.aQ().b) * (double) (var4 + 0) / (double) var1 - 0.125D;
			double var7 = this.aQ().b + (this.aQ().e - this.aQ().b) * (double) (var4 + 1) / (double) var1 - 0.125D;
			brt var9 = new brt(this.aQ().a, var5, this.aQ().c, this.aQ().d, var7, this.aQ().f);
			if (this.o.b(var9, bof.h)) {
				var2 += 1.0D / (double) var1;
			}
		}

		double var19 = Math.sqrt(this.v * this.v + this.x * this.x);
		double var6;
		double var8;
		int var10;
		if (var19 > 0.2975D) {
			var6 = Math.cos((double) this.y * 3.141592653589793D / 180.0D);
			var8 = Math.sin((double) this.y * 3.141592653589793D / 180.0D);

			for (var10 = 0; (double) var10 < 1.0D + var19 * 60.0D; ++var10) {
				double var11 = (double) (this.V.nextFloat() * 2.0F - 1.0F);
				double var13 = (double) (this.V.nextInt(2) * 2 - 1) * 0.7D;
				double var15;
				double var17;
				if (this.V.nextBoolean()) {
					var15 = this.s - var6 * var11 * 0.8D + var8 * var13;
					var17 = this.u - var8 * var11 * 0.8D - var6 * var13;
					this.o.a(ew.f, var15, this.t - 0.125D, var17, this.v, this.w, this.x, new int[0]);
				} else {
					var15 = this.s + var6 + var8 * var11 * 0.7D;
					var17 = this.u + var8 - var6 * var11 * 0.7D;
					this.o.a(ew.f, var15, this.t - 0.125D, var17, this.v, this.w, this.x, new int[0]);
				}
			}
		}

		double var24;
		double var26;
		if (this.o.D && this.a) {
			if (this.c > 0) {
				var6 = this.s + (this.d - this.s) / (double) this.c;
				var8 = this.t + (this.e - this.t) / (double) this.c;
				var24 = this.u + (this.f - this.u) / (double) this.c;
				var26 = uv.g(this.g - (double) this.y);
				this.y = (float) ((double) this.y + var26 / (double) this.c);
				this.z = (float) ((double) this.z + (this.h - (double) this.z) / (double) this.c);
				--this.c;
				this.b(var6, var8, var24);
				this.b(this.y, this.z);
			} else {
				var6 = this.s + this.v;
				var8 = this.t + this.w;
				var24 = this.u + this.x;
				this.b(var6, var8, var24);
				if (this.C) {
					this.v *= 0.5D;
					this.w *= 0.5D;
					this.x *= 0.5D;
				}

				this.v *= 0.9900000095367432D;
				this.w *= 0.949999988079071D;
				this.x *= 0.9900000095367432D;
			}

		} else {
			if (var2 < 1.0D) {
				var6 = var2 * 2.0D - 1.0D;
				this.w += 0.03999999910593033D * var6;
			} else {
				if (this.w < 0.0D) {
					this.w /= 2.0D;
				}

				this.w += 0.007000000216066837D;
			}

			if (this.l instanceof EntityLiving) {
				EntityLiving var20 = (EntityLiving) this.l;
				float var21 = this.l.y + -var20.aX * 90.0F;
				this.v += -Math.sin((double) (var21 * 3.1415927F / 180.0F)) * this.b * (double) var20.aY * 0.05000000074505806D;
				this.x += Math.cos((double) (var21 * 3.1415927F / 180.0F)) * this.b * (double) var20.aY * 0.05000000074505806D;
			}

			var6 = Math.sqrt(this.v * this.v + this.x * this.x);
			if (var6 > 0.35D) {
				var8 = 0.35D / var6;
				this.v *= var8;
				this.x *= var8;
				var6 = 0.35D;
			}

			if (var6 > var19 && this.b < 0.35D) {
				this.b += (0.35D - this.b) / 35.0D;
				if (this.b > 0.35D) {
					this.b = 0.35D;
				}
			} else {
				this.b -= (this.b - 0.07D) / 35.0D;
				if (this.b < 0.07D) {
					this.b = 0.07D;
				}
			}

			int var22;
			for (var22 = 0; var22 < 4; ++var22) {
				int var23 = uv.c(this.s + ((double) (var22 % 2) - 0.5D) * 0.8D);
				var10 = uv.c(this.u + ((double) (var22 / 2) - 0.5D) * 0.8D);

				for (int var25 = 0; var25 < 2; ++var25) {
					int var12 = uv.c(this.t) + var25;
					dt var27 = new dt(var23, var12, var10);
					atr var14 = this.o.p(var27).c();
					if (var14 == aty.aH) {
						this.o.g(var27);
						this.D = false;
					} else if (var14 == aty.bx) {
						this.o.b(var27, true);
						this.D = false;
					}
				}
			}

			if (this.C) {
				this.v *= 0.5D;
				this.w *= 0.5D;
				this.x *= 0.5D;
			}

			this.d(this.v, this.w, this.x);
			if (this.D && var19 > 0.2D) {
				if (!this.o.D && !this.I) {
					this.J();

					for (var22 = 0; var22 < 3; ++var22) {
						this.a(alq.a(aty.f), 1, 0.0F);
					}

					for (var22 = 0; var22 < 2; ++var22) {
						this.a(amk.y, 1, 0.0F);
					}
				}
			} else {
				this.v *= 0.9900000095367432D;
				this.w *= 0.949999988079071D;
				this.x *= 0.9900000095367432D;
			}

			this.z = 0.0F;
			var8 = (double) this.y;
			var24 = this.p - this.s;
			var26 = this.r - this.u;
			if (var24 * var24 + var26 * var26 > 0.001D) {
				var8 = (double) ((float) (Math.atan2(var26, var24) * 180.0D / 3.141592653589793D));
			}

			double var28 = uv.g(var8 - (double) this.y);
			if (var28 > 20.0D) {
				var28 = 20.0D;
			}

			if (var28 < -20.0D) {
				var28 = -20.0D;
			}

			this.y = (float) ((double) this.y + var28);
			this.b(this.y, this.z);
			if (!this.o.D) {
				List var16 = this.o.b((Entity) this, this.aQ().b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
				if (var16 != null && !var16.isEmpty()) {
					for (int var29 = 0; var29 < var16.size(); ++var29) {
						Entity var18 = (Entity) var16.get(var29);
						if (var18 != this.l && var18.ae() && var18 instanceof adu) {
							var18.i(this);
						}
					}
				}

				if (this.l != null && this.l.I) {
					this.l = null;
				}

			}
		}
	}

	public void al() {
		if (this.l != null) {
			double var1 = Math.cos((double) this.y * 3.141592653589793D / 180.0D) * 0.4D;
			double var3 = Math.sin((double) this.y * 3.141592653589793D / 180.0D) * 0.4D;
			this.l.b(this.s + var1, this.t + this.an() + this.l.am(), this.u + var3);
		}
	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	public boolean e(ahd var1) {
		if (this.l != null && this.l instanceof ahd && this.l != var1) {
			return true;
		} else {
			if (!this.o.D) {
				var1.a((Entity) this);
			}

			return true;
		}
	}

	protected void a(double var1, boolean var3, atr var4, dt var5) {
		if (var3) {
			if (this.O > 3.0F) {
				this.e(this.O, 1.0F);
				if (!this.o.D && !this.I) {
					this.J();

					int var6;
					for (var6 = 0; var6 < 3; ++var6) {
						this.a(alq.a(aty.f), 1, 0.0F);
					}

					for (var6 = 0; var6 < 2; ++var6) {
						this.a(amk.y, 1, 0.0F);
					}
				}

				this.O = 0.0F;
			}
		} else if (this.o.p((new dt(this)).b()).c().r() != bof.h && var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public void a(float var1) {
		this.ac.b(19, Float.valueOf(var1));
	}

	public float j() {
		return this.ac.d(19);
	}

	public void a(int var1) {
		this.ac.b(17, Integer.valueOf(var1));
	}

	public int l() {
		return this.ac.c(17);
	}

	public void b(int var1) {
		this.ac.b(18, Integer.valueOf(var1));
	}

	public int m() {
		return this.ac.c(18);
	}
}
