package net.minecraft;

public class RecipesBanner {

	void a(CraftingManager var1) {
		akv[] var2 = akv.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			akv var5 = var2[var4];
			var1.registerShapedRecipe(new ItemStack(Items.BANNER, 1, var5.b()), new Object[] { "###", "###", " | ", Character.valueOf('#'), new ItemStack(Blocks.WOOL, 1, var5.a()), Character.valueOf('|'), Items.STICK });
		}

		var1.addRecipe(new aof((aod) null));
		var1.addRecipe(new aoe((aod) null));
	}
}
