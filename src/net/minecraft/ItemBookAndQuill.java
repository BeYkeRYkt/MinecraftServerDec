package net.minecraft;

public class ItemBookAndQuill extends Item {

	public ItemBookAndQuill() {
		this.setMaxStackSize(1);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		var3.a(var1);
		var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
		return var1;
	}

	public static boolean isValid(NBTCompoundTag tag) {
		if (tag == null) {
			return false;
		} else if (!tag.isTagAssignableFrom("pages", 9)) {
			return false;
		} else {
			NBTListTag pages = tag.getList("pages", 8);

			for (int i = 0; i < pages.getSize(); ++i) {
				String page = pages.getString(i);
				if (page == null) {
					return false;
				}
				if (page.length() > 32767) {
					return false;
				}
			}
			return true;
		}
	}

}
