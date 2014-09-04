package net.minecraft;

public class zi extends zh {

	private final agp e;

	public zi(agp var1) {
		super(var1, ahd.class, 8.0F);
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
