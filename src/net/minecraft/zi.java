package net.minecraft;

public class zi extends zh {

	private final EntityVillager e;

	public zi(EntityVillager var1) {
		super(var1, EntityHuman.class, 8.0F);
		this.e = var1;
	}

	public boolean a() {
		if (this.e.cm()) {
			this.b = this.e.u_();
			return true;
		} else {
			return false;
		}
	}
}
