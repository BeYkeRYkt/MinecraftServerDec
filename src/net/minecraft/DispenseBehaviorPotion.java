package net.minecraft;

final class DispenseBehaviorPotion implements IDispenseBehavior {

	private final DispenseBehaviorItem b = new DispenseBehaviorItem();

	public ItemStack a(ISourceBlock var1, ItemStack var2) {
		return ItemPotion.f(var2.getWearout()) ? (new DispenseBehaviorThrownPotion(this, var2)).a(var1, var2) : this.b.a(var1, var2);
	}
}
