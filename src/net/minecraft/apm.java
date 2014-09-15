package net.minecraft;

final class apm implements apl {

	public float a;
	public EnumMonsterType b;

	private apm() {
	}

	public void a(Enchantment var1, int var2) {
		this.a += var1.a(var2, this.b);
	}

	// $FF: synthetic method
	apm(api var1) {
		this();
	}
}
