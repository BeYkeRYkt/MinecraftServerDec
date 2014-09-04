package net.minecraft;

public class yu extends zb {

	private final xn a;
	private final float b;
	private float c;
	private boolean d;
	private int e;
	private int f;

	public yu(xn var1, float var2) {
		this.a = var1;
		this.b = var2;
		this.a(7);
	}

	public void c() {
		this.c = 0.0F;
	}

	public void d() {
		this.d = false;
		this.c = 0.0F;
	}

	public boolean a() {
		return this.a.ai() && this.a.l != null && this.a.l instanceof ahd && (this.d || this.a.bV());
	}

	public void e() {
		ahd var1 = (ahd) this.a.l;
		EntityCreature var2 = (EntityCreature) this.a;
		float var3 = NumberConverter.g(var1.y - this.a.y) * 0.5F;
		if (var3 > 5.0F) {
			var3 = 5.0F;
		}

		if (var3 < -5.0F) {
			var3 = -5.0F;
		}

		this.a.y = NumberConverter.g(this.a.y + var3);
		if (this.c < this.b) {
			this.c += (this.b - this.c) * 0.01F;
		}

		if (this.c > this.b) {
			this.c = this.b;
		}

		int var4 = NumberConverter.c(this.a.s);
		int var5 = NumberConverter.c(this.a.t);
		int var6 = NumberConverter.c(this.a.u);
		float var7 = this.c;
		if (this.d) {
			if (this.e++ > this.f) {
				this.d = false;
			}

			var7 += var7 * 1.15F * NumberConverter.a((float) this.e / (float) this.f * 3.1415927F);
		}

		float var8 = 0.91F;
		if (this.a.C) {
			var8 = this.a.o.p(new dt(NumberConverter.d((float) var4), NumberConverter.d((float) var5) - 1, NumberConverter.d((float) var6))).c().K * 0.91F;
		}

		float var9 = 0.16277136F / (var8 * var8 * var8);
		float var10 = NumberConverter.a(var2.y * 3.1415927F / 180.0F);
		float var11 = NumberConverter.b(var2.y * 3.1415927F / 180.0F);
		float var12 = var2.bH() * var9;
		float var13 = Math.max(var7, 1.0F);
		var13 = var12 / var13;
		float var14 = var7 * var13;
		float var15 = -(var14 * var10);
		float var16 = var14 * var11;
		if (NumberConverter.e(var15) > NumberConverter.e(var16)) {
			if (var15 < 0.0F) {
				var15 -= this.a.J / 2.0F;
			}

			if (var15 > 0.0F) {
				var15 += this.a.J / 2.0F;
			}

			var16 = 0.0F;
		} else {
			var15 = 0.0F;
			if (var16 < 0.0F) {
				var16 -= this.a.J / 2.0F;
			}

			if (var16 > 0.0F) {
				var16 += this.a.J / 2.0F;
			}
		}

		int var17 = NumberConverter.c(this.a.s + (double) var15);
		int var18 = NumberConverter.c(this.a.u + (double) var16);
		int var19 = NumberConverter.d(this.a.J + 1.0F);
		int var20 = NumberConverter.d(this.a.K + var1.K + 1.0F);
		int var21 = NumberConverter.d(this.a.J + 1.0F);
		if (var4 != var17 || var6 != var18) {
			atr var22 = this.a.o.p(new dt(var4, var5, var6)).c();
			boolean var23 = !this.a(var22) && (var22.r() != bof.a || !this.a(this.a.o.p(new dt(var4, var5 - 1, var6)).c()));
			if (var23 && 0 == bpy.a(this.a.o, this.a, var17, var5, var18, var19, var20, var21, false, false, true) && 1 == bpy.a(this.a.o, this.a, var4, var5 + 1, var6, var19, var20, var21, false, false, true) && 1 == bpy.a(this.a.o, this.a, var17, var5 + 1, var18, var19, var20, var21, false, false, true)) {
				var2.r().a();
			}
		}

		if (!var1.by.instabuild && this.c >= this.b * 0.5F && this.a.bb().nextFloat() < 0.006F && !this.d) {
			amj var24 = var1.bz();
			if (var24 != null && var24.b() == amk.bY) {
				var24.a(1, (EntityLiving) var1);
				if (var24.b == 0) {
					amj var25 = new amj(amk.aR);
					var25.d(var24.o());
					var1.bg.a[var1.bg.c] = var25;
				}
			}
		}

		this.a.g(0.0F, var7);
	}

	private boolean a(atr var1) {
		return var1 instanceof bat || var1 instanceof awq;
	}

	public boolean f() {
		return this.d;
	}

	public void g() {
		this.d = true;
		this.e = 0;
		this.f = this.a.bb().nextInt(841) + 140;
	}

	public boolean h() {
		return !this.f() && this.c > this.b * 0.3F;
	}
}
