package net.minecraft;

public class zo extends zb {

	private EntityCreature a;
	private double b;
	private double c;
	private double d;
	private double e;

	public zo(EntityCreature var1, double var2) {
		this.a = var1;
		this.e = var2;
		this.a(1);
	}

	public boolean a() {
		if (this.a.ce()) {
			return false;
		} else {
			Position var1 = this.a.cf();
			Vec3D var2 = abf.a(this.a, 16, 7, new Vec3D((double) var1.getX(), (double) var1.getY(), (double) var1.getZ()));
			if (var2 == null) {
				return false;
			} else {
				this.b = var2.x;
				this.c = var2.y;
				this.d = var2.z;
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
}
