package net.minecraft;

final class DispenseBehaviorBonemeal extends DispenseBehaviorItem {

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		Position var4 = var1.getPosition().getRelative(BlockDispenser.b(var1.getData()));
		EntityTNTPrimed var5 = new EntityTNTPrimed(var3, (double) var4.getX() + 0.5D, (double) var4.getY(), (double) var4.getZ() + 0.5D, (EntityLiving) null);
		var3.addEntity((Entity) var5);
		var3.a((Entity) var5, "game.tnt.primed", 1.0F, 1.0F);
		--var2.amount;
		return var2;
	}
}
