package net.minecraft;

final class ot extends eg {

	public ItemStack b(dz var1, ItemStack var2) {
		PaintingDirection var3 = BlockDispenser.b(var1.f());
		double var4 = var1.a() + (double) var3.g();
		double var6 = (double) ((float) var1.d().getY() + 0.2F);
		double var8 = var1.c() + (double) var3.i();
		EntityFireworks var10 = new EntityFireworks(var1.i(), var4, var6, var8, var2);
		var1.i().d((Entity) var10);
		var2.a(1);
		return var2;
	}

	protected void a(dz var1) {
		var1.i().b(1002, var1.d(), 0);
	}
}
