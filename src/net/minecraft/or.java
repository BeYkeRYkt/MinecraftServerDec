package net.minecraft;

class or extends oc {

	// $FF: synthetic field
	final ItemStack b;
	// $FF: synthetic field
	final DispenseBehaviorPotion c;

	or(DispenseBehaviorPotion var1, ItemStack var2) {
		this.c = var1;
		this.b = var2;
	}

	protected aho a(World var1, ex var2) {
		return new EntityPotion(var1, var2.a(), var2.b(), var2.c(), this.b.getCopy());
	}

	protected float a() {
		return super.a() * 0.5F;
	}

	protected float b() {
		return super.b() * 1.25F;
	}
}
