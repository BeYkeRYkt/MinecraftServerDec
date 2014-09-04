package net.minecraft;

import java.util.List;

public class ahj extends Entity implements aho {

	private int d = -1;
	private int e = -1;
	private int f = -1;
	private atr g;
	private int h;
	private boolean i;
	public int a;
	public int b;
	public Entity c;
	private int ap;
	private int aq;
	private double ar = 2.0D;
	private int as;

	public ahj(World var1) {
		super(var1);
		this.j = 10.0D;
		this.a(0.5F, 0.5F);
	}

	public ahj(World var1, double var2, double var4, double var6) {
		super(var1);
		this.j = 10.0D;
		this.a(0.5F, 0.5F);
		this.b(var2, var4, var6);
	}

	public ahj(World var1, EntityLiving var2, EntityLiving var3, float var4, float var5) {
		super(var1);
		this.j = 10.0D;
		this.c = var2;
		if (var2 instanceof ahd) {
			this.a = 1;
		}

		this.t = var2.t + (double) var2.aR() - 0.10000000149011612D;
		double var6 = var3.s - var2.s;
		double var8 = var3.aQ().b + (double) (var3.K / 3.0F) - this.t;
		double var10 = var3.u - var2.u;
		double var12 = (double) NumberConverter.a(var6 * var6 + var10 * var10);
		if (var12 >= 1.0E-7D) {
			float var14 = (float) (Math.atan2(var10, var6) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var15 = (float) (-(Math.atan2(var8, var12) * 180.0D / 3.1415927410125732D));
			double var16 = var6 / var12;
			double var18 = var10 / var12;
			this.b(var2.s + var16, this.t, var2.u + var18, var14, var15);
			float var20 = (float) (var12 * 0.20000000298023224D);
			this.c(var6, var8 + (double) var20, var10, var4, var5);
		}
	}

	public ahj(World var1, EntityLiving var2, float var3) {
		super(var1);
		this.j = 10.0D;
		this.c = var2;
		if (var2 instanceof ahd) {
			this.a = 1;
		}

		this.a(0.5F, 0.5F);
		this.b(var2.s, var2.t + (double) var2.aR(), var2.u, var2.y, var2.z);
		this.s -= (double) (NumberConverter.b(this.y / 180.0F * 3.1415927F) * 0.16F);
		this.t -= 0.10000000149011612D;
		this.u -= (double) (NumberConverter.a(this.y / 180.0F * 3.1415927F) * 0.16F);
		this.b(this.s, this.t, this.u);
		this.v = (double) (-NumberConverter.a(this.y / 180.0F * 3.1415927F) * NumberConverter.b(this.z / 180.0F * 3.1415927F));
		this.x = (double) (NumberConverter.b(this.y / 180.0F * 3.1415927F) * NumberConverter.b(this.z / 180.0F * 3.1415927F));
		this.w = (double) (-NumberConverter.a(this.z / 180.0F * 3.1415927F));
		this.c(this.v, this.w, this.x, var3 * 1.5F, 1.0F);
	}

	protected void h() {
		this.ac.a(16, Byte.valueOf((byte) 0));
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = NumberConverter.a(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double) var9;
		var3 /= (double) var9;
		var5 /= (double) var9;
		var1 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var3 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var5 += this.V.nextGaussian() * (double) (this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) var8;
		var1 *= (double) var7;
		var3 *= (double) var7;
		var5 *= (double) var7;
		this.v = var1;
		this.w = var3;
		this.x = var5;
		float var10 = NumberConverter.a(var1 * var1 + var5 * var5);
		this.A = this.y = (float) (Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
		this.B = this.z = (float) (Math.atan2(var3, (double) var10) * 180.0D / 3.1415927410125732D);
		this.ap = 0;
	}

	public void s_() {
		super.s_();
		if (this.B == 0.0F && this.A == 0.0F) {
			float var1 = NumberConverter.a(this.v * this.v + this.x * this.x);
			this.A = this.y = (float) (Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);
			this.B = this.z = (float) (Math.atan2(this.w, (double) var1) * 180.0D / 3.1415927410125732D);
		}

		dt var18 = new dt(this.d, this.e, this.f);
		bec var2 = this.o.p(var18);
		atr var3 = var2.c();
		if (var3.r() != bof.a) {
			var3.a((ard) this.o, var18);
			brt var4 = var3.a(this.o, var18, var2);
			if (var4 != null && var4.a(new brw(this.s, this.t, this.u))) {
				this.i = true;
			}
		}

		if (this.b > 0) {
			--this.b;
		}

		if (this.i) {
			int var20 = var3.c(var2);
			if (var3 == this.g && var20 == this.h) {
				++this.ap;
				if (this.ap >= 1200) {
					this.J();
				}

			} else {
				this.i = false;
				this.v *= (double) (this.V.nextFloat() * 0.2F);
				this.w *= (double) (this.V.nextFloat() * 0.2F);
				this.x *= (double) (this.V.nextFloat() * 0.2F);
				this.ap = 0;
				this.aq = 0;
			}
		} else {
			++this.aq;
			brw var19 = new brw(this.s, this.t, this.u);
			brw var5 = new brw(this.s + this.v, this.t + this.w, this.u + this.x);
			bru var6 = this.o.a(var19, var5, false, true, false);
			var19 = new brw(this.s, this.t, this.u);
			var5 = new brw(this.s + this.v, this.t + this.w, this.u + this.x);
			if (var6 != null) {
				var5 = new brw(var6.c.a, var6.c.b, var6.c.c);
			}

			Entity var7 = null;
			List var8 = this.o.b((Entity) this, this.aQ().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
			double var9 = 0.0D;

			int var11;
			float var13;
			for (var11 = 0; var11 < var8.size(); ++var11) {
				Entity var12 = (Entity) var8.get(var11);
				if (var12.ad() && (var12 != this.c || this.aq >= 5)) {
					var13 = 0.3F;
					brt var14 = var12.aQ().b((double) var13, (double) var13, (double) var13);
					bru var15 = var14.a(var19, var5);
					if (var15 != null) {
						double var16 = var19.f(var15.c);
						if (var16 < var9 || var9 == 0.0D) {
							var7 = var12;
							var9 = var16;
						}
					}
				}
			}

			if (var7 != null) {
				var6 = new bru(var7);
			}

			if (var6 != null && var6.d != null && var6.d instanceof ahd) {
				ahd var21 = (ahd) var6.d;
				if (var21.by.invulnerable || this.c instanceof ahd && !((ahd) this.c).a(var21)) {
					var6 = null;
				}
			}

			float var22;
			float var25;
			float var29;
			if (var6 != null) {
				if (var6.d != null) {
					var22 = NumberConverter.a(this.v * this.v + this.w * this.w + this.x * this.x);
					int var24 = NumberConverter.f((double) var22 * this.ar);
					if (this.l()) {
						var24 += this.V.nextInt(var24 / 2 + 2);
					}

					wh var26;
					if (this.c == null) {
						var26 = wh.a(this, this);
					} else {
						var26 = wh.a(this, this.c);
					}

					if (this.au() && !(var6.d instanceof aer)) {
						var6.d.e(5);
					}

					if (var6.d.a(var26, (float) var24)) {
						if (var6.d instanceof EntityLiving) {
							EntityLiving var27 = (EntityLiving) var6.d;
							if (!this.o.D) {
								var27.o(var27.bu() + 1);
							}

							if (this.as > 0) {
								var29 = NumberConverter.a(this.v * this.v + this.x * this.x);
								if (var29 > 0.0F) {
									var6.d.g(this.v * (double) this.as * 0.6000000238418579D / (double) var29, 0.1D, this.x * (double) this.as * 0.6000000238418579D / (double) var29);
								}
							}

							if (this.c instanceof EntityLiving) {
								aph.a(var27, this.c);
								aph.b((EntityLiving) this.c, var27);
							}

							if (this.c != null && var6.d != this.c && var6.d instanceof ahd && this.c instanceof EntityPlayer) {
								((EntityPlayer) this.c).a.a((id) (new jo(6, 0.0F)));
							}
						}

						this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
						if (!(var6.d instanceof aer)) {
							this.J();
						}
					} else {
						this.v *= -0.10000000149011612D;
						this.w *= -0.10000000149011612D;
						this.x *= -0.10000000149011612D;
						this.y += 180.0F;
						this.A += 180.0F;
						this.aq = 0;
					}
				} else {
					dt var23 = var6.a();
					this.d = var23.n();
					this.e = var23.o();
					this.f = var23.p();
					var2 = this.o.p(var23);
					this.g = var2.c();
					this.h = this.g.c(var2);
					this.v = (double) ((float) (var6.c.a - this.s));
					this.w = (double) ((float) (var6.c.b - this.t));
					this.x = (double) ((float) (var6.c.c - this.u));
					var25 = NumberConverter.a(this.v * this.v + this.w * this.w + this.x * this.x);
					this.s -= this.v / (double) var25 * 0.05000000074505806D;
					this.t -= this.w / (double) var25 * 0.05000000074505806D;
					this.u -= this.x / (double) var25 * 0.05000000074505806D;
					this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
					this.i = true;
					this.b = 7;
					this.a(false);
					if (this.g.r() != bof.a) {
						this.g.a(this.o, var23, var2, (Entity) this);
					}
				}
			}

			if (this.l()) {
				for (var11 = 0; var11 < 4; ++var11) {
					this.o.a(ew.j, this.s + this.v * (double) var11 / 4.0D, this.t + this.w * (double) var11 / 4.0D, this.u + this.x * (double) var11 / 4.0D, -this.v, -this.w + 0.2D, -this.x, new int[0]);
				}
			}

			this.s += this.v;
			this.t += this.w;
			this.u += this.x;
			var22 = NumberConverter.a(this.v * this.v + this.x * this.x);
			this.y = (float) (Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);

			for (this.z = (float) (Math.atan2(this.w, (double) var22) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
			var25 = 0.99F;
			var13 = 0.05F;
			if (this.V()) {
				for (int var28 = 0; var28 < 4; ++var28) {
					var29 = 0.25F;
					this.o.a(ew.e, this.s - this.v * (double) var29, this.t - this.w * (double) var29, this.u - this.x * (double) var29, this.v, this.w, this.x, new int[0]);
				}

				var25 = 0.6F;
			}

			if (this.U()) {
				this.N();
			}

			this.v *= (double) var25;
			this.w *= (double) var25;
			this.x *= (double) var25;
			this.w -= (double) var13;
			this.b(this.s, this.t, this.u);
			this.Q();
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.put("xTile", (short) this.d);
		var1.put("yTile", (short) this.e);
		var1.put("zTile", (short) this.f);
		var1.put("life", (short) this.ap);
		oa var2 = (oa) atr.c.c(this.g);
		var1.put("inTile", var2 == null ? "" : var2.toString());
		var1.put("inData", (byte) this.h);
		var1.put("shake", (byte) this.b);
		var1.put("inGround", (byte) (this.i ? 1 : 0));
		var1.put("pickup", (byte) this.a);
		var1.put("damage", this.ar);
	}

	public void a(NBTCompoundTag var1) {
		this.d = var1.e("xTile");
		this.e = var1.e("yTile");
		this.f = var1.e("zTile");
		this.ap = var1.e("life");
		if (var1.b("inTile", 8)) {
			this.g = atr.b(var1.j("inTile"));
		} else {
			this.g = atr.c(var1.d("inTile") & 255);
		}

		this.h = var1.d("inData") & 255;
		this.b = var1.d("shake") & 255;
		this.i = var1.d("inGround") == 1;
		if (var1.b("damage", 99)) {
			this.ar = var1.i("damage");
		}

		if (var1.b("pickup", 99)) {
			this.a = var1.d("pickup");
		} else if (var1.b("player", 99)) {
			this.a = var1.n("player") ? 1 : 0;
		}

	}

	public void d(ahd var1) {
		if (!this.o.D && this.i && this.b <= 0) {
			boolean var2 = this.a == 1 || this.a == 2 && var1.by.instabuild;
			if (this.a == 1 && !var1.bg.a(new amj(amk.g, 1))) {
				var2 = false;
			}

			if (var2) {
				this.a("random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				var1.a((Entity) this, 1);
				this.J();
			}

		}
	}

	protected boolean r_() {
		return false;
	}

	public void b(double var1) {
		this.ar = var1;
	}

	public double j() {
		return this.ar;
	}

	public void a(int var1) {
		this.as = var1;
	}

	public boolean aE() {
		return false;
	}

	public void a(boolean var1) {
		byte var2 = this.ac.a(16);
		if (var1) {
			this.ac.b(16, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.ac.b(16, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public boolean l() {
		byte var1 = this.ac.a(16);
		return (var1 & 1) != 0;
	}
}
