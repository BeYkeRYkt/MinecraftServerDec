package net.minecraft;

import java.util.Random;

public class ala extends Item {

	public boolean f_(ItemStack var1) {
		return false;
	}

	public amx g(ItemStack var1) {
		return this.h(var1).getSize() > 0 ? amx.b : super.g(var1);
	}

	public NBTListTag h(ItemStack var1) {
		NBTCompoundTag var2 = var1.getTag();
		return var2 != null && var2.isTagAssignableFrom("StoredEnchantments", 9) ? (NBTListTag) var2.getTag("StoredEnchantments") : new NBTListTag();
	}

	public void a(ItemStack var1, apo var2) {
		NBTListTag var3 = this.h(var1);
		boolean var4 = true;

		for (int var5 = 0; var5 < var3.getSize(); ++var5) {
			NBTCompoundTag var6 = var3.getCompound(var5);
			if (var6.getShort("id") == var2.b.id) {
				if (var6.getShort("lvl") < var2.c) {
					var6.put("lvl", (short) var2.c);
				}

				var4 = false;
				break;
			}
		}

		if (var4) {
			NBTCompoundTag var7 = new NBTCompoundTag();
			var7.put("id", (short) var2.b.id);
			var7.put("lvl", (short) var2.c);
			var3.addTag((NBTTag) var7);
		}

		if (!var1.hasTag()) {
			var1.d(new NBTCompoundTag());
		}

		var1.getTag().put("StoredEnchantments", (NBTTag) var3);
	}

	public ItemStack a(apo var1) {
		ItemStack var2 = new ItemStack(this);
		this.a(var2, var1);
		return var2;
	}

	public vl b(Random var1) {
		return this.a(var1, 1, 1, 1);
	}

	public vl a(Random var1, int var2, int var3, int var4) {
		ItemStack var5 = new ItemStack(Items.aL, 1, 0);
		aph.a(var1, var5, 30);
		return new vl(var5, var2, var3, var4);
	}
}
