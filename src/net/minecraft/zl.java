package net.minecraft;

public class zl extends zb {

	private EntityCreature a;
	private abh b;
	private int c = -1;
	private int d = -1;

	public zl(EntityCreature var1) {
		this.a = var1;
		this.a(1);
	}

	public boolean a() {
		Position var1 = new Position(this.a);
		if ((!this.a.world.w() || this.a.world.S() && !this.a.world.b(var1).e()) && !this.a.world.worldProvider.noSkyLight()) {
			if (this.a.bb().nextInt(50) != 0) {
				return false;
			} else if (this.c != -1 && this.a.getDistanceSquared((double) this.c, this.a.locationY, (double) this.d) < 4.0D) {
				return false;
			} else {
				abi var2 = this.a.world.ae().a(var1, 14);
				if (var2 == null) {
					return false;
				} else {
					this.b = var2.c(var1);
					return this.b != null;
				}
			}
		} else {
			return false;
		}
	}

	public boolean b() {
		return !this.a.s().m();
	}

	public void c() {
		this.c = -1;
		Position var1 = this.b.e();
		int var2 = var1.getX();
		int var3 = var1.getY();
		int var4 = var1.getZ();
		if (this.a.b(var1) > 256.0D) {
			Vec3D var5 = abf.a(this.a, 14, 3, new Vec3D((double) var2 + 0.5D, (double) var3, (double) var4 + 0.5D));
			if (var5 != null) {
				this.a.s().a(var5.x, var5.y, var5.z, 1.0D);
			}
		} else {
			this.a.s().a((double) var2 + 0.5D, (double) var3, (double) var4 + 0.5D, 1.0D);
		}

	}

	public void d() {
		this.c = this.b.e().getX();
		this.d = this.b.e().getZ();
		this.b = null;
	}
}
