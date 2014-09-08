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
		this.f = var1.world;
		this.a(1);
	}

	public boolean a() {
		if (!this.f.w()) {
			return false;
		} else if (!this.a.au()) {
			return false;
		} else if (!this.f.i(new Position(this.a.locationX, this.a.aQ().minY, this.a.locationZ))) {
			return false;
		} else {
			Vec3D var1 = this.f();
			if (var1 == null) {
				return false;
			} else {
				this.b = var1.x;
				this.c = var1.y;
				this.d = var1.z;
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

	private Vec3D f() {
		Random var1 = this.a.bb();
		Position var2 = new Position(this.a.locationX, this.a.aQ().minY, this.a.locationZ);

		for (int var3 = 0; var3 < 10; ++var3) {
			Position var4 = var2.a(var1.nextInt(20) - 10, var1.nextInt(6) - 3, var1.nextInt(20) - 10);
			if (!this.f.i(var4) && this.a.a(var4) < 0.0F) {
				return new Vec3D((double) var4.getX(), (double) var4.getY(), (double) var4.getZ());
			}
		}

		return null;
	}
}
