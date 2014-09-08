package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class zv extends zb {

	private EntityVillager a;
	private EntityLiving b;
	private double c;
	private int d;

	public zv(EntityVillager var1, double var2) {
		this.a = var1;
		this.c = var2;
		this.a(1);
	}

	public boolean a() {
		if (this.a.l() >= 0) {
			return false;
		} else if (this.a.bb().nextInt(400) != 0) {
			return false;
		} else {
			List var1 = this.a.world.a(EntityVillager.class, this.a.aQ().b(6.0D, 3.0D, 6.0D));
			double var2 = Double.MAX_VALUE;
			Iterator var4 = var1.iterator();

			while (var4.hasNext()) {
				EntityVillager var5 = (EntityVillager) var4.next();
				if (var5 != this.a && !var5.cl() && var5.l() < 0) {
					double var6 = var5.getDistanceSquared(this.a);
					if (var6 <= var2) {
						var2 = var6;
						this.b = var5;
					}
				}
			}

			if (this.b == null) {
				Vec3D var8 = abf.a(this.a, 16, 3);
				if (var8 == null) {
					return false;
				}
			}

			return true;
		}
	}

	public boolean b() {
		return this.d > 0;
	}

	public void c() {
		if (this.b != null) {
			this.a.m(true);
		}

		this.d = 1000;
	}

	public void d() {
		this.a.m(false);
		this.b = null;
	}

	public void e() {
		--this.d;
		if (this.b != null) {
			if (this.a.getDistanceSquared(this.b) > 4.0D) {
				this.a.s().a((Entity) this.b, this.c);
			}
		} else if (this.a.s().m()) {
			Vec3D var1 = abf.a(this.a, 16, 3);
			if (var1 == null) {
				return;
			}

			this.a.s().a(var1.x, var1.y, var1.z, this.c);
		}

	}
}
