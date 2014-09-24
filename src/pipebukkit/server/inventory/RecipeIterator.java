package pipebukkit.server.inventory;

import java.util.Iterator;
import java.util.NoSuchElementException;

import net.minecraft.CraftingManager;
import net.minecraft.IRecipe;

import org.bukkit.inventory.Recipe;

public class RecipeIterator implements Iterator<Recipe> {

	private Iterator<IRecipe> craftingRecipes = CraftingManager.getInstance().getRecipes().iterator();

	private Iterator<?> lastIterator = craftingRecipes;

	@Override
	public boolean hasNext() {
		return craftingRecipes.hasNext();
	}

	@Override
	public Recipe next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return PipeRecipes.fromNMSRecipe((IRecipe) lastIterator.next());
	}

	@Override
	public void remove() {
		lastIterator.remove();
	}

}
