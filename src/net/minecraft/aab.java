package net.minecraft;

public class aab extends zb {

	private EntityCreature a;

	public aab(EntityCreature var1) {
		this.a = var1;
	}

	public boolean a() {
		return this.a.world.w();
	}

	public void c() {
		((aay) this.a.s()).e(true);
	}

	public void d() {
		((aay) this.a.s()).e(false);
	}
}
