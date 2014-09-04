package net.minecraft;

import java.util.List;

public class aef extends aed implements bdd {

	private boolean a = true;
	private int b = -1;
	private dt c;

	public aef(World var1) {
		super(var1);
		this.c = dt.a;
	}

	public aef(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
		this.c = dt.a;
	}

	public adz s() {
		return adz.f;
	}

	public bec u() {
		return aty.cp.P();
	}

	public int w() {
		return 1;
	}

	public int n_() {
		return 5;
	}

	public boolean e(ahd var1) {
		if (!this.o.D) {
			var1.a((vq) this);
		}

		return true;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		boolean var5 = !var4;
		if (var5 != this.y()) {
			this.i(var5);
		}

	}

	public boolean y() {
		return this.a;
	}

	public void i(boolean var1) {
		this.a = var1;
	}

	public World z() {
		return this.o;
	}

	public double A() {
		return this.s;
	}

	public double B() {
		return this.t;
	}

	public double C() {
		return this.u;
	}

	public void s_() {
		super.s_();
		if (!this.o.D && this.ai() && this.y()) {
			dt var1 = new dt(this);
			if (var1.equals(this.c)) {
				--this.b;
			} else {
				this.m(0);
			}

			if (!this.E()) {
				this.m(0);
				if (this.D()) {
					this.m(4);
					this.o_();
				}
			}
		}

	}

	public boolean D() {
		if (bde.a((bdd) this)) {
			return true;
		} else {
			List var1 = this.o.a(adw.class, this.aQ().b(0.25D, 0.0D, 0.25D), xe.a);
			if (var1.size() > 0) {
				bde.a((vq) this, (adw) var1.get(0));
			}

			return false;
		}
	}

	public void a(wh var1) {
		super.a(var1);
		this.a(alq.a((atr) aty.cp), 1, 0.0F);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("TransferCooldown", this.b);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		this.b = var1.f("TransferCooldown");
	}

	public void m(int var1) {
		this.b = var1;
	}

	public boolean E() {
		return this.b > 0;
	}

	public String k() {
		return "minecraft:hopper";
	}

	public aib a(ahb var1, ahd var2) {
		return new aix(var1, this, var2);
	}
}
