package net.minecraft;

public class zp extends zb {

	private EntityCreature a;
	private EntityLiving b;
	private double c;
	private double d;
	private double e;
	private double f;
	private float g;

	public zp(EntityCreature var1, double var2, float var4) {
		this.a = var1;
		this.f = var2;
		this.g = var4;
		this.a(1);
	}

	public boolean a() {
		this.b = this.a.u();
		if (this.b == null) {
			return false;
		} else if (this.b.h(this.a) > (double) (this.g * this.g)) {
			return false;
		} else {
			Vec3D var1 = abf.a(this.a, 16, 7, new Vec3D(this.b.locationX, this.b.locationY, this.b.locationZ));
			if (var1 == null) {
				return false;
			} else {
				this.c = var1.x;
				this.d = var1.y;
				this.e = var1.z;
				return true;
			}
		}
	}

	public boolean b() {
		return !this.a.s().m() && this.b.ai() && this.b.h(this.a) < (double) (this.g * this.g);
	}

	public void d() {
		this.b = null;
	}

	public void c() {
		this.a.s().a(this.c, this.d, this.e, this.f);
	}
}
