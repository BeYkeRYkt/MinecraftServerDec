package net.minecraft;

public abstract class DispenseBehaviorProjectile extends DispenseBehaviorItem {

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		IPosition var4 = BlockDispenser.a(var1);
		BlockFace var5 = BlockDispenser.b(var1.getData());
		aho var6 = this.a(var3, var4);
		var6.shoot((double) var5.g(), (double) ((float) var5.h() + 0.1F), (double) var5.i(), this.b(), this.a());
		var3.addEntity((Entity) var6);
		var2.a(1);
		return var2;
	}

	protected void a(ISourceBlock var1) {
		var1.getWorld().triggerEffect(1002, var1.getPosition(), 0);
	}

	protected abstract aho a(World var1, IPosition var2);

	protected float a() {
		return 6.0F;
	}

	protected float b() {
		return 1.1F;
	}
}
