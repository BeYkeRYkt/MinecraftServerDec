package pipebukkit.server.inventory;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.minecraft.CraftingManager;
import net.minecraft.Item;
import net.minecraft.ShapedRecipes;
import net.minecraft.ShapelessRecipes;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class PipeRecipes {

	public static boolean addRecipe(Recipe recipe) {
		if (recipe instanceof ShapedRecipe) {
			PipeRecipes.addShapedRecipe((ShapedRecipe) recipe);
			return true;
		} else if (recipe instanceof ShapelessRecipe) {
			addShapelessRecipe((ShapelessRecipe) recipe);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public static void addShapedRecipe(ShapedRecipe shapedRecipe) {
		ArrayList<Object> nmsRecipeData = new ArrayList<Object>();
		String[] shape = shapedRecipe.getShape();
		for (int i = 0; i < shape.length; i++) {
			nmsRecipeData.add(shape[i]);
		}
		for (Entry<Character, ItemStack> entry : shapedRecipe.getIngredientMap().entrySet()) {
			ItemStack itemStack = entry.getValue();
			if (itemStack == null) {
				continue;
			}
			nmsRecipeData.add(entry.getKey());
			nmsRecipeData.add(new net.minecraft.ItemStack(Item.getById(itemStack.getTypeId()), 1, itemStack.getDurability()));
		}
		CraftingManager.getInstance().registerShapedRecipe(new PipeItemStack(shapedRecipe.getResult()).getHandle(), nmsRecipeData);
	}

	@SuppressWarnings("deprecation")
	public static void addShapelessRecipe(ShapelessRecipe shapelessRecipe) {
		ArrayList<Object> nmsRecipeData = new ArrayList<Object>();
		for (ItemStack itemStack : shapelessRecipe.getIngredientList()) {
			if (itemStack == null) {
				continue;
			}
			nmsRecipeData.add(new net.minecraft.ItemStack(Item.getById(itemStack.getTypeId()), 1, itemStack.getDurability()));
		}
		CraftingManager.getInstance().registerShapedRecipe(new PipeItemStack(shapelessRecipe.getResult()).getHandle(), nmsRecipeData);
	}

	public static ShapedRecipe fromNMSShapedRecipe(ShapedRecipes nmsRecipe) {
		return null;
	}

	public static ShapelessRecipe fromNMSShapelessRecipe(ShapelessRecipes nmsRecipe) {
		return null;
	}

}
