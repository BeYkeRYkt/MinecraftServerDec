package net.minecraft;

final class oq implements eo {

	private final eg b = new eg();

	public ItemStack a(dz var1, ItemStack var2) {
		return amw.f(var2.i()) ? (new or(this, var2)).a(var1, var2) : this.b.a(var1, var2);
	}
}
