package net.minecraft;

public class PathfinderGoalFloat extends PathfinderGoal {

	private EntityInsentient a;

	public PathfinderGoalFloat(EntityInsentient var1) {
		this.a = var1;
		this.a(4);
		((aay) var1.s()).d(true);
	}

	public boolean a() {
		return this.a.V() || this.a.ab();
	}

	public void e() {
		if (this.a.bb().nextFloat() < 0.8F) {
			this.a.r().a();
		}

	}
}
