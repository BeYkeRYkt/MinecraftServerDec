package net.minecraft;

public class PathfinderGoalTradeWithPlayer extends PathfinderGoal {

	private EntityVillager a;

	public PathfinderGoalTradeWithPlayer(EntityVillager var1) {
		this.a = var1;
		this.a(5);
	}

	public boolean a() {
		if (!this.a.isAlive()) {
			return false;
		} else if (this.a.V()) {
			return false;
		} else if (!this.a.onGround) {
			return false;
		} else if (this.a.velocityChanged) {
			return false;
		} else {
			EntityHuman var1 = this.a.u_();
			return var1 == null ? false : (this.a.getDistanceSquared(var1) > 16.0D ? false : var1.activeContainer instanceof Container);
		}
	}

	public void c() {
		this.a.s().n();
	}

	public void d() {
		this.a.a_((EntityHuman) null);
	}
}
