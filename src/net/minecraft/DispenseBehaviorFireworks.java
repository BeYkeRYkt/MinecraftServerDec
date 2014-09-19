package net.minecraft;

final class DispenseBehaviorFireworks extends DispenseBehaviorItem {

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		BlockFace var3 = BlockDispenser.b(var1.getData());
		double var4 = var1.getX() + (double) var3.g();
		double var6 = (double) ((float) var1.getPosition().getY() + 0.2F);
		double var8 = var1.getZ() + (double) var3.i();
		EntityFireworks var10 = new EntityFireworks(var1.getWorld(), var4, var6, var8, var2);
		var1.getWorld().addEntity((Entity) var10);
		var2.a(1);
		return var2;
	}

	protected void a(ISourceBlock var1) {
		var1.getWorld().triggerEffect(1002, var1.getPosition(), 0);
	}
}
