package net.minecraft;

import java.util.Comparator;

class RecipeSorter implements Comparator<IRecipe> {

	@Override
	public int compare(IRecipe recipe1, IRecipe recipe2) {
		return recipe1 instanceof ShapelessRecipes && recipe2 instanceof ShapedRecipes ? 1 : (recipe2 instanceof ShapelessRecipes && recipe1 instanceof ShapedRecipes ? -1 : (recipe2.a() < recipe1.a() ? -1 : (recipe2.a() > recipe1.a() ? 1 : 0)));
	}

}
