package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapelessRecipes implements IRecipe {

	private final ItemStack a;
	private final List b;

	public ShapelessRecipes(ItemStack var1, List var2) {
		this.a = var1;
		this.b = var2;
	}

	public ItemStack getResult() {
		return this.a;
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
		ArrayList var3 = Lists.newArrayList((Iterable) this.b);

		for (int var4 = 0; var4 < var1.getRows(); ++var4) {
			for (int var5 = 0; var5 < var1.getCols(); ++var5) {
				ItemStack var6 = var1.getItem(var5, var4);
				if (var6 != null) {
					boolean var7 = false;
					Iterator var8 = var3.iterator();

					while (var8.hasNext()) {
						ItemStack var9 = (ItemStack) var8.next();
						if (var6.getItem() == var9.getItem() && (var9.getWearout() == 32767 || var6.getWearout() == var9.getWearout())) {
							var7 = true;
							var3.remove(var9);
							break;
						}
					}

					if (!var7) {
						return false;
					}
				}
			}
		}

		return var3.isEmpty();
	}

	public ItemStack a(InventoryCrafting var1) {
		return this.a.getCopy();
	}

	public int a() {
		return this.b.size();
	}
}
