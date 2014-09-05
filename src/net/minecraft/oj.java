package net.minecraft;

final class oj extends eg {

	protected ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		aek var5 = new aek(var3, (double) var4.n() + 0.5D, (double) var4.o(), (double) var4.p() + 0.5D, (EntityLiving) null);
		var3.d((Entity) var5);
		var3.a((Entity) var5, "game.tnt.primed", 1.0F, 1.0F);
		--var2.b;
		return var2;
	}
}
