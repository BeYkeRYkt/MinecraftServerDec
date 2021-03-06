package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class PathfinderGoalTakeFlower extends PathfinderGoal {

	private EntityVillager a;
	private EntityIronGolem b;
	private int c;
	private boolean d;

	public PathfinderGoalTakeFlower(EntityVillager var1) {
		this.a = var1;
		this.a(3);
	}

	public boolean a() {
		if (this.a.l() >= 0) {
			return false;
		} else if (!this.a.world.w()) {
			return false;
		} else {
			List var1 = this.a.world.getEntititesInAABB(EntityIronGolem.class, this.a.getBoundingBox().grow(6.0D, 2.0D, 6.0D));
			if (var1.isEmpty()) {
				return false;
			} else {
				Iterator var2 = var1.iterator();

				while (var2.hasNext()) {
					EntityIronGolem var3 = (EntityIronGolem) var2.next();
					if (var3.ck() > 0) {
						this.b = var3;
						break;
					}
				}

				return this.b != null;
			}
		}
	}

	public boolean b() {
		return this.b.ck() > 0;
	}

	public void c() {
		this.c = this.a.bb().nextInt(320);
		this.d = false;
		this.b.s().n();
	}

	public void d() {
		this.b = null;
		this.a.s().n();
	}

	public void e() {
		this.a.p().a(this.b, 30.0F, 30.0F);
		if (this.b.ck() == this.c) {
			this.a.s().a((Entity) this.b, 0.5D);
			this.d = true;
		}

		if (this.d && this.a.getDistanceSquared(this.b) < 4.0D) {
			this.b.a(false);
			this.a.s().n();
		}

	}
}
