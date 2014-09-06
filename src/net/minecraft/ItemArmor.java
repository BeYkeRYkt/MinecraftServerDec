package net.minecraft;

public class ItemArmor extends Item {

	private static final int[] k = new int[] { 11, 16, 15, 13 };
	public static final String[] a = new String[] { "minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots" };
	private static final eo l = new ajo();
	public final int b;
	public final int c;
	public final int d;
	private final EnumArmorMaterial m;

	public ItemArmor(EnumArmorMaterial var1, int var2, int var3) {
		this.m = var1;
		this.b = var3;
		this.d = var2;
		this.c = var1.b(var3);
		this.setDurability(var1.a(var3));
		this.maxStackSize = 1;
		this.setCreativeModeTab(CreativeModeTab.COMBAT);
		BlockDispenser.M.a(this, l);
	}

	public int b() {
		return this.m.a();
	}

	public EnumArmorMaterial w_() {
		return this.m;
	}

	public boolean d_(ItemStack var1) {
		return this.m != EnumArmorMaterial.LEATHER ? false : (!var1.hasTag() ? false : (!var1.getTag().isTagAssignableFrom("display", 10) ? false : var1.getTag().getCompound("display").isTagAssignableFrom("color", 3)));
	}

	public int b(ItemStack var1) {
		if (this.m != EnumArmorMaterial.LEATHER) {
			return -1;
		} else {
			NBTCompoundTag var2 = var1.getTag();
			if (var2 != null) {
				NBTCompoundTag var3 = var2.getCompound("display");
				if (var3 != null && var3.isTagAssignableFrom("color", 3)) {
					return var3.getInt("color");
				}
			}

			return 10511680;
		}
	}

	public void c(ItemStack var1) {
		if (this.m == EnumArmorMaterial.LEATHER) {
			NBTCompoundTag var2 = var1.getTag();
			if (var2 != null) {
				NBTCompoundTag var3 = var2.getCompound("display");
				if (var3.hasKey("color")) {
					var3.remove("color");
				}

			}
		}
	}

	public void b(ItemStack var1, int var2) {
		if (this.m != EnumArmorMaterial.LEATHER) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTCompoundTag var3 = var1.getTag();
			if (var3 == null) {
				var3 = new NBTCompoundTag();
				var1.d(var3);
			}

			NBTCompoundTag var4 = var3.getCompound("display");
			if (!var3.isTagAssignableFrom("display", 10)) {
				var3.put("display", (NBTTag) var4);
			}

			var4.put("color", var2);
		}
	}

	public boolean a(ItemStack var1, ItemStack var2) {
		return this.m.b() == var2.getItem() ? true : super.a(var1, var2);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		int var4 = EntityInsentient.c(var1) - 1;
		ItemStack var5 = var3.q(var4);
		if (var5 == null) {
			var3.c(var4, var1.getCopy());
			var1.b = 0;
		}

		return var1;
	}

	// $FF: synthetic method
	static int[] d() {
		return k;
	}

}
