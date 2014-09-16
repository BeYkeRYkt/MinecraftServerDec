package net.minecraft;

public interface IMerchant {

	void a_(EntityHuman var1);

	EntityHuman u_();

	MerchantRecipeList b_(EntityHuman var1);

	void a(MerchantRecipe var1);

	void a_(ItemStack var1);

	IChatBaseComponent getComponentName();
}
