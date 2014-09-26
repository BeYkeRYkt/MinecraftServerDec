package net.minecraft;

public interface IRecipe {

	boolean a(InventoryCrafting var1, World var2);

	ItemStack getResult(InventoryCrafting var1);

	int a();

	ItemStack getResult();

	ItemStack[] b(InventoryCrafting var1);

}
