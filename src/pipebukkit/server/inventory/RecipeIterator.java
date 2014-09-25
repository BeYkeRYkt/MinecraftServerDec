package pipebukkit.server.inventory;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import net.minecraft.CraftingManager;
import net.minecraft.IRecipe;
import net.minecraft.RecipesFurnace;

import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;

public class RecipeIterator implements Iterator<Recipe> {

	private Iterator<IRecipe> craftingRecipes = CraftingManager.getInstance().getRecipes().iterator();
	private Iterator<Entry<net.minecraft.ItemStack, net.minecraft.ItemStack>> furnaceRecipes = RecipesFurnace.getInstance().getRecipes().entrySet().iterator();

	private Iterator<?> lastIterator = craftingRecipes;

	@Override
	public boolean hasNext() {
		return craftingRecipes.hasNext() || furnaceRecipes.hasNext();
	}

	@Override
	public Recipe next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (!craftingRecipes.hasNext()) {
			lastIterator = furnaceRecipes;
			Entry<net.minecraft.ItemStack, net.minecraft.ItemStack> recipe = furnaceRecipes.next();
			return new FurnaceRecipe(new PipeItemStack(recipe.getValue().getCopy()), new PipeItemStack(recipe.getKey().getCopy()).getData());
		} else {
			return PipeRecipes.fromNMSRecipe(craftingRecipes.next());
		}
	}

	@Override
	public void remove() {
		lastIterator.remove();
	}

}
