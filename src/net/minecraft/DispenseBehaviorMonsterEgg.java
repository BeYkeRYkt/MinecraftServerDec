package net.minecraft;

final class DispenseBehaviorMonsterEgg extends DispenseBehaviorItem {

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		BlockFace var3 = BlockDispenser.b(var1.f());
		double var4 = var1.getX() + (double) var3.g();
		double var6 = (double) ((float) var1.d().getY() + 0.2F);
		double var8 = var1.getZ() + (double) var3.i();
		Entity var10 = ItemMonsterEgg.a(var1.i(), var2.getDurability(), var4, var6, var8);
		if (var10 instanceof EntityLiving && var2.s()) {
			((EntityInsentient) var10).a(var2.q());
		}

		var2.a(1);
		return var2;
	}
}
