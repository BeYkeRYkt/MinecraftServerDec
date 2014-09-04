package net.minecraft;

import java.util.Calendar;

public class abo extends abn {

	private dt a;

	public abo(World var1) {
		super(var1);
		this.a(0.5F, 0.9F);
		this.a(true);
	}

	protected void h() {
		super.h();
		this.ac.a(16, new Byte((byte) 0));
	}

	protected float bA() {
		return 0.1F;
	}

	protected float bB() {
		return super.bB() * 0.95F;
	}

	protected String z() {
		return this.n() && this.V.nextInt(4) != 0 ? null : "mob.bat.idle";
	}

	protected String bn() {
		return "mob.bat.hurt";
	}

	protected String bo() {
		return "mob.bat.death";
	}

	public boolean ae() {
		return false;
	}

	protected void s(Entity var1) {
	}

	protected void bK() {
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(6.0D);
	}

	public boolean n() {
		return (this.ac.a(16) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.ac.a(16);
		if (var1) {
			this.ac.b(16, Byte.valueOf((byte) (var2 | 1)));
		} else {
			this.ac.b(16, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public void s_() {
		super.s_();
		if (this.n()) {
			this.v = this.w = this.x = 0.0D;
			this.t = (double) uv.c(this.t) + 1.0D - (double) this.K;
		} else {
			this.w *= 0.6000000238418579D;
		}

	}

	protected void E() {
		super.E();
		dt var1 = new dt(this);
		dt var2 = var1.a();
		if (this.n()) {
			if (!this.o.p(var2).c().t()) {
				this.a(false);
				this.o.a((ahd) null, 1015, var1, 0);
			} else {
				if (this.V.nextInt(200) == 0) {
					this.aI = (float) this.V.nextInt(360);
				}

				if (this.o.a(this, 4.0D) != null) {
					this.a(false);
					this.o.a((ahd) null, 1015, var1, 0);
				}
			}
		} else {
			if (this.a != null && (!this.o.d(this.a) || this.a.o() < 1)) {
				this.a = null;
			}

			if (this.a == null || this.V.nextInt(30) == 0 || this.a.c((double) ((int) this.s), (double) ((int) this.t), (double) ((int) this.u)) < 4.0D) {
				this.a = new dt((int) this.s + this.V.nextInt(7) - this.V.nextInt(7), (int) this.t + this.V.nextInt(6) - 2, (int) this.u + this.V.nextInt(7) - this.V.nextInt(7));
			}

			double var3 = (double) this.a.n() + 0.5D - this.s;
			double var5 = (double) this.a.o() + 0.1D - this.t;
			double var7 = (double) this.a.p() + 0.5D - this.u;
			this.v += (Math.signum(var3) * 0.5D - this.v) * 0.10000000149011612D;
			this.w += (Math.signum(var5) * 0.699999988079071D - this.w) * 0.10000000149011612D;
			this.x += (Math.signum(var7) * 0.5D - this.x) * 0.10000000149011612D;
			float var9 = (float) (Math.atan2(this.x, this.v) * 180.0D / 3.1415927410125732D) - 90.0F;
			float var10 = uv.g(var9 - this.y);
			this.aY = 0.5F;
			this.y += var10;
			if (this.V.nextInt(100) == 0 && this.o.p(var2).c().t()) {
				this.a(true);
			}
		}

	}

	protected boolean r_() {
		return false;
	}

	public void e(float var1, float var2) {
	}

	protected void a(double var1, boolean var3, atr var4, dt var5) {
	}

	public boolean aH() {
		return true;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.o.D && this.n()) {
				this.a(false);
			}

			return super.a(var1, var2);
		}
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.ac.b(16, Byte.valueOf(var1.d("BatFlags")));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("BatFlags", this.ac.a(16));
	}

	public boolean bQ() {
		dt var1 = new dt(this.s, this.aQ().b, this.u);
		if (var1.o() >= 63) {
			return false;
		} else {
			int var2 = this.o.l(var1);
			byte var3 = 4;
			if (this.a(this.o.Y())) {
				var3 = 7;
			} else if (this.V.nextBoolean()) {
				return false;
			}

			return var2 > this.V.nextInt(var3) ? false : super.bQ();
		}
	}

	private boolean a(Calendar var1) {
		return var1.get(2) + 1 == 10 && var1.get(5) >= 20 || var1.get(2) + 1 == 11 && var1.get(5) <= 3;
	}

	public float aR() {
		return this.K / 2.0F;
	}
}
