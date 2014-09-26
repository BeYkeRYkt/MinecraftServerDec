package pipebukkit.server.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.CraftingManager;
import net.minecraft.IRecipe;
import net.minecraft.Item;
import net.minecraft.RecipesFurnace;
import net.minecraft.ShapedRecipes;
import net.minecraft.ShapelessRecipes;

import org.bukkit.inventory.FurnaceRecipe;
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
		} else if (recipe instanceof FurnaceRecipe) {
			addFurnaceRecipe((FurnaceRecipe) recipe);
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
		CraftingManager.getInstance().registerShapedRecipe(new PipeItemStack(shapedRecipe.getResult()).getHandle(), nmsRecipeData.toArray());
		CraftingManager.getInstance().sortRecipes();
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
		CraftingManager.getInstance().registerShapedRecipe(new PipeItemStack(shapelessRecipe.getResult()).getHandle(), nmsRecipeData.toArray());
		CraftingManager.getInstance().sortRecipes();
	}

	public static void addFurnaceRecipe(FurnaceRecipe furnaceRecipe) {
		RecipesFurnace.getInstance().registerRecipe(new PipeItemStack(furnaceRecipe.getInput()).getHandle(), new PipeItemStack(furnaceRecipe.getResult()).getHandle(), 0F);
	}

	public static Recipe fromNMSRecipe(IRecipe nmsRecipe) {
		if (nmsRecipe instanceof ShapedRecipes) {
			return fromNMSShapedRecipe((ShapedRecipes) nmsRecipe);
		} else if (nmsRecipe instanceof ShapelessRecipes) {
			return fromNMSShapelessRecipe((ShapelessRecipes) nmsRecipe);
		}
		return null;
	}

	private static String shapeSymbols = "qwertyuio";
	public static ShapedRecipe fromNMSShapedRecipe(ShapedRecipes nmsRecipe) {
		ShapedRecipe shapedRecipe = new ShapedRecipe(new PipeItemStack(nmsRecipe.getResult()));
		HashMap<ItemStack, Character> usedIngredientsMapping = new HashMap<ItemStack, Character>();
		char[][] shape = new char[nmsRecipe.getRows()][nmsRecipe.getColumns()];
		for (int i = 0; i < nmsRecipe.getIngredients().length; i++) {
			net.minecraft.ItemStack nmsItemStack = nmsRecipe.getIngredients()[i];
			char symbol = ' ';
			if (nmsItemStack != null) {
				PipeItemStack itemStack = new PipeItemStack(nmsItemStack.getCopy());
				if (usedIngredientsMapping.containsKey(itemStack)) {
					symbol = usedIngredientsMapping.get(itemStack);
				} else {
					symbol = shapeSymbols.charAt(usedIngredientsMapping.size());
					usedIngredientsMapping.put(itemStack, symbol);
				}
			}
			shape[i / nmsRecipe.getRows()][i % nmsRecipe.getColumns()] = symbol;
		}
		ArrayList<String> shapeData = new ArrayList<String>();
		for (int i = 0; i < shape.length; i++) {
			shapeData.add(new String(shape[i]));
		}
		shapedRecipe.shape(shapeData.toArray(new String[0]));
		for (Entry<ItemStack, Character> entry : usedIngredientsMapping.entrySet()) {
			shapedRecipe.setIngredient(entry.getValue(), entry.getKey().getData());
		}
		return shapedRecipe;
	}

	public static ShapelessRecipe fromNMSShapelessRecipe(ShapelessRecipes nmsRecipe) {
		ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new PipeItemStack(nmsRecipe.getResult()));
		for (net.minecraft.ItemStack nmsItemStack : nmsRecipe.getIngredients()) {
			shapelessRecipe.addIngredient(new PipeItemStack(nmsItemStack).getData());
		}
		return shapelessRecipe;
	}

}
