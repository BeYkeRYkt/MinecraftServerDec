package net.minecraft;

public class PathfinderGoalOpenDoor extends yv {

	boolean g;
	int h;

	public PathfinderGoalOpenDoor(EntityInsentient var1, boolean var2) {
		super(var1);
		this.a = var1;
		this.g = var2;
	}

	public boolean b() {
		return this.g && this.h > 0 && super.b();
	}

	public void c() {
		this.h = 20;
		this.c.a(this.a.world, this.b, true);
	}

	public void d() {
		if (this.g) {
			this.c.a(this.a.world, this.b, false);
		}

	}

	public void e() {
		--this.h;
		super.e();
	}
}
