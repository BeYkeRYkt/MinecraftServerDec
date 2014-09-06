package net.minecraft;

final class DispenseBehaviorBonemeal extends eg {

	protected ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		EntityTNTPrimed var5 = new EntityTNTPrimed(var3, (double) var4.getX() + 0.5D, (double) var4.getY(), (double) var4.getZ() + 0.5D, (EntityLiving) null);
		var3.d((Entity) var5);
		var3.a((Entity) var5, "game.tnt.primed", 1.0F, 1.0F);
		--var2.b;
		return var2;
	}
}
