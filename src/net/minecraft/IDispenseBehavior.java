package net.minecraft;

public interface IDispenseBehavior {

	IDispenseBehavior NOP = new DispenseBehaviorNoop();

	ItemStack a(ISourceBlock var1, ItemStack var2);

}
