package net.minecraft;

final class DispenseBehaviorFilledBucket extends DispenseBehaviorItem {

	private final DispenseBehaviorItem b = new DispenseBehaviorItem();

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		ItemBucket var3 = (ItemBucket) var2.getItem();
		Position var4 = var1.d().getRelative(BlockDispenser.b(var1.f()));
		if (var3.a(var1.i(), var4)) {
			var2.setItem(Items.BUCKET);
			var2.amount = 1;
			return var2;
		} else {
			return this.b.a(var1, var2);
		}
	}
}
