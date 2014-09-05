package net.minecraft;

final class of extends eg {

	private final eg b = new eg();

	public ItemStack b(dz var1, ItemStack var2) {
		akb var3 = (akb) var2.getItem();
		Position var4 = var1.d().a(ave.b(var1.f()));
		if (var3.a(var1.i(), var4)) {
			var2.a(amk.aw);
			var2.b = 1;
			return var2;
		} else {
			return this.b.a(var1, var2);
		}
	}
}
