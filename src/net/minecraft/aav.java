package net.minecraft;

public class aav extends aaw {

	xx a;
	EntityLiving b;
	private int c;

	public aav(xx var1) {
		super(var1, false);
		this.a = var1;
		this.a(1);
	}

	public boolean a() {
		if (!this.a.cj()) {
			return false;
		} else {
			EntityLiving var1 = this.a.cm();
			if (var1 == null) {
				return false;
			} else {
				this.b = var1.be();
				int var2 = var1.bf();
				return var2 != this.c && this.a(this.b, false) && this.a.a(this.b, var1);
			}
		}
	}

	public void c() {
		this.e.d(this.b);
		EntityLiving var1 = this.a.cm();
		if (var1 != null) {
			this.c = var1.bf();
		}

		super.c();
	}
}
