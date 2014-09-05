package net.minecraft;

import java.util.Random;

public class yx extends zb {

	private EntityCreature a;
	private double b;
	private double c;
	private double d;
	private double e;
	private World f;

	public yx(EntityCreature var1, double var2) {
		this.a = var1;
		this.e = var2;
		this.f = var1.o;
		this.a(1);
	}

	public boolean a() {
		if (!this.f.w()) {
			return false;
		} else if (!this.a.au()) {
			return false;
		} else if (!this.f.i(new Position(this.a.locationX, this.a.aQ().b, this.a.locationZ))) {
			return false;
		} else {
			brw var1 = this.f();
			if (var1 == null) {
				return false;
			} else {
				this.b = var1.a;
				this.c = var1.b;
				this.d = var1.c;
				return true;
			}
		}
	}

	public boolean b() {
		return !this.a.s().m();
	}

	public void c() {
		this.a.s().a(this.b, this.c, this.d, this.e);
	}

	private brw f() {
		Random var1 = this.a.bb();
		Position var2 = new Position(this.a.locationX, this.a.aQ().b, this.a.locationZ);

		for (int var3 = 0; var3 < 10; ++var3) {
			Position var4 = var2.a(var1.nextInt(20) - 10, var1.nextInt(6) - 3, var1.nextInt(20) - 10);
			if (!this.f.i(var4) && this.a.a(var4) < 0.0F) {
				return new brw((double) var4.n(), (double) var4.o(), (double) var4.p());
			}
		}

		return null;
	}
}
