package net.minecraft;

final class oj extends eg {

	protected amj b(dz var1, amj var2) {
		World var3 = var1.i();
		dt var4 = var1.d().a(ave.b(var1.f()));
		aek var5 = new aek(var3, (double) var4.n() + 0.5D, (double) var4.o(), (double) var4.p() + 0.5D, (EntityLiving) null);
		var3.d((Entity) var5);
		var3.a((Entity) var5, "game.tnt.primed", 1.0F, 1.0F);
		--var2.b;
		return var2;
	}
}
