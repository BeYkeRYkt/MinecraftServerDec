package net.minecraft;

class or extends oc {

	// $FF: synthetic field
	final amj b;
	// $FF: synthetic field
	final oq c;

	or(oq var1, amj var2) {
		this.c = var1;
		this.b = var2;
	}

	protected aho a(World var1, ex var2) {
		return new ahv(var1, var2.a(), var2.b(), var2.c(), this.b.k());
	}

	protected float a() {
		return super.a() * 0.5F;
	}

	protected float b() {
		return super.b() * 1.25F;
	}
}
