package net.minecraft;

public class aak extends aaw {

	acq a;
	EntityLiving b;

	public aak(acq var1) {
		super(var1, false, true);
		this.a = var1;
		this.a(1);
	}

	public boolean a() {
		abi var1 = this.a.n();
		if (var1 == null) {
			return false;
		} else {
			this.b = var1.b((EntityLiving) this.a);
			if (!this.a(this.b, false)) {
				if (this.e.bb().nextInt(20) == 0) {
					this.b = var1.c((EntityLiving) this.a);
					return this.a(this.b, false);
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	public void c() {
		this.a.d(this.b);
		super.c();
	}
}
