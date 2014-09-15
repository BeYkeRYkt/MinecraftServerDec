package net.minecraft;

public class PathfinderGoalRandomLookaround extends PathfinderGoal {

	private EntityInsentient a;
	private double b;
	private double c;
	private int d;

	public PathfinderGoalRandomLookaround(EntityInsentient var1) {
		this.a = var1;
		this.a(3);
	}

	public boolean a() {
		return this.a.bb().nextFloat() < 0.02F;
	}

	public boolean b() {
		return this.d >= 0;
	}

	public void c() {
		double var1 = 6.283185307179586D * this.a.bb().nextDouble();
		this.b = Math.cos(var1);
		this.c = Math.sin(var1);
		this.d = 20 + this.a.bb().nextInt(20);
	}

	public void e() {
		--this.d;
		this.a.p().a(this.a.locationX + this.b, this.a.locationY + (double) this.a.getHeadHeight(), this.a.locationZ + this.c, 10.0F, (float) this.a.bP());
	}
}
