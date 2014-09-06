package net.minecraft;

final class DispenseBehaviorFilledBucket extends eg {

	private final eg b = new eg();

	public ItemStack b(dz var1, ItemStack var2) {
		ItemBucket var3 = (ItemBucket) var2.getItem();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		if (var3.a(var1.i(), var4)) {
			var2.a(Items.BUCKET);
			var2.b = 1;
			return var2;
		} else {
			return this.b.a(var1, var2);
		}
	}
}
