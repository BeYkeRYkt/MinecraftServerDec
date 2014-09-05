package net.minecraft;

final class op extends oc {

	protected aho a(World var1, ex var2) {
		return new EntityThrownExpBottle(var1, var2.a(), var2.b(), var2.c());
	}

	protected float a() {
		return super.a() * 0.5F;
	}

	protected float b() {
		return super.b() * 1.25F;
	}
}
