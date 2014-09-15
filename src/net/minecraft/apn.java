package net.minecraft;

final class apn implements apl {

	public int a;
	public DamageSource b;

	private apn() {
	}

	public void a(Enchantment var1, int var2) {
		this.a += var1.a(var2, this.b);
	}

	// $FF: synthetic method
	apn(api var1) {
		this();
	}
}
