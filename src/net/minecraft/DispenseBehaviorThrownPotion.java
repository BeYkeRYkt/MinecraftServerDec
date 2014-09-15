package net.minecraft;

class DispenseBehaviorThrownPotion extends DispenseBehaviorProjectile {

	// $FF: synthetic field
	final ItemStack b;
	// $FF: synthetic field
	final DispenseBehaviorPotion c;

	DispenseBehaviorThrownPotion(DispenseBehaviorPotion var1, ItemStack var2) {
		this.c = var1;
		this.b = var2;
	}

	protected aho a(World var1, IPosition var2) {
		return new EntityPotion(var1, var2.getX(), var2.getY(), var2.getZ(), this.b.getCopy());
	}

	protected float a() {
		return super.a() * 0.5F;
	}

	protected float b() {
		return super.b() * 1.25F;
	}
}
