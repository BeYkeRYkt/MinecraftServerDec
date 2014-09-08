package net.minecraft;

public class aaa extends zb {

	private EntityCreature a;
	private abh b;

	public aaa(EntityCreature var1) {
		this.a = var1;
		if (!(var1.s() instanceof aay)) {
			throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
		}
	}

	public boolean a() {
		if (this.a.world.w()) {
			return false;
		} else {
			Position var1 = new Position(this.a);
			abi var2 = this.a.world.ae().a(var1, 16);
			if (var2 == null) {
				return false;
			} else {
				this.b = var2.b(var1);
				return this.b == null ? false : (double) this.b.b(var1) < 2.25D;
			}
		}
	}

	public boolean b() {
		return this.a.world.w() ? false : !this.b.i() && this.b.c(new Position(this.a));
	}

	public void c() {
		((aay) this.a.s()).b(false);
		((aay) this.a.s()).c(false);
	}

	public void d() {
		((aay) this.a.s()).b(true);
		((aay) this.a.s()).c(true);
		this.b = null;
	}

	public void e() {
		this.b.b();
	}
}
