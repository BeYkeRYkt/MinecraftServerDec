package net.minecraft;

public class ItemBookAndQuill extends Item {

	public ItemBookAndQuill() {
		this.setMaxStackSize(1);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		var3.a(var1);
		var3.b(StatisticList.J[Item.getId((Item) this)]);
		return var1;
	}

	public static boolean b(NBTCompoundTag var0) {
		if (var0 == null) {
			return false;
		} else if (!var0.isTagAssignableFrom("pages", 9)) {
			return false;
		} else {
			NBTListTag var1 = var0.getList("pages", 8);

			for (int var2 = 0; var2 < var1.getSize(); ++var2) {
				String var3 = var1.getString(var2);
				if (var3 == null) {
					return false;
				}

				if (var3.length() > 32767) {
					return false;
				}
			}

			return true;
		}
	}
}
