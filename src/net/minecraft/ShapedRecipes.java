package net.minecraft;

public class ShapedRecipes implements IRecipe {

	private final int columns;
	private final int rows;
	private final ItemStack[] ingredients;
	private final ItemStack result;
	private boolean copyNBT;

	public ShapedRecipes(int columns, int rows, ItemStack[] ingredients, ItemStack result) {
		this.columns = columns;
		this.rows = rows;
		this.ingredients = ingredients;
		this.result = result;
	}

	public ItemStack getResult() {
		return this.result;
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public ItemStack[] getIngredients() {
		return ingredients;
	}

	public ItemStack[] b(InventoryCrafting var1) {
		ItemStack[] var2 = new ItemStack[var1.getSize()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.getItem(var3);
			if (var4 != null && var4.getItem().r()) {
				var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
			}
		}

		return var2;
	}

	public boolean a(InventoryCrafting var1, World var2) {
		for (int var3 = 0; var3 <= 3 - this.columns; ++var3) {
			for (int var4 = 0; var4 <= 3 - this.rows; ++var4) {
				if (this.a(var1, var3, var4, true)) {
					return true;
				}

				if (this.a(var1, var3, var4, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean a(InventoryCrafting var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 3; ++var6) {
				int var7 = var5 - var2;
				int var8 = var6 - var3;
				ItemStack var9 = null;
				if (var7 >= 0 && var8 >= 0 && var7 < this.columns && var8 < this.rows) {
					if (var4) {
						var9 = this.ingredients[this.columns - var7 - 1 + var8 * this.columns];
					} else {
						var9 = this.ingredients[var7 + var8 * this.columns];
					}
				}

				ItemStack var10 = var1.getItem(var5, var6);
				if (var10 != null || var9 != null) {
					if (var10 == null && var9 != null || var10 != null && var9 == null) {
						return false;
					}

					if (var9.getItem() != var10.getItem()) {
						return false;
					}

					if (var9.getWearout() != 32767 && var9.getWearout() != var10.getWearout()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public ItemStack getResult(InventoryCrafting inventoryCrafting) {
		ItemStack result = this.getResult().getCopy();
		if (this.copyNBT) {
			for (int i = 0; i < inventoryCrafting.getSize(); ++i) {
				ItemStack itemStack = inventoryCrafting.getItem(i);
				if (itemStack != null && itemStack.hasTag()) {
					result.setTag((NBTCompoundTag) itemStack.getTag().getCopy());
				}
			}
		}

		return result;
	}

	public int a() {
		return this.columns * this.rows;
	}

	public ShapedRecipes c() {
		this.copyNBT = true;
		return this;
	}
}
