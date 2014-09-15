package net.minecraft;

public interface IDispenseBehavior {

	IDispenseBehavior a = new DispenseBehaviorNoop();

	ItemStack a(ISourceBlock var1, ItemStack var2);

}
