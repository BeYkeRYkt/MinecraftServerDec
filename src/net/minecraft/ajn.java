package net.minecraft;

public class ajn extends alq {

	private static final int[] k = new int[] { 11, 16, 15, 13 };
	public static final String[] a = new String[] { "minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots" };
	private static final eo l = new ajo();
	public final int b;
	public final int c;
	public final int d;
	private final ajp m;

	public ajn(ajp var1, int var2, int var3) {
		this.m = var1;
		this.b = var3;
		this.d = var2;
		this.c = var1.b(var3);
		this.d(var1.a(var3));
		this.h = 1;
		this.a(akf.j);
		ave.M.a(this, l);
	}

	public int b() {
		return this.m.a();
	}

	public ajp w_() {
		return this.m;
	}

	public boolean d_(amj var1) {
		return this.m != ajp.a ? false : (!var1.n() ? false : (!var1.o().isTagAssignableFrom("display", 10) ? false : var1.o().getCompound("display").isTagAssignableFrom("color", 3)));
	}

	public int b(amj var1) {
		if (this.m != ajp.a) {
			return -1;
		} else {
			NBTCompoundTag var2 = var1.o();
			if (var2 != null) {
				NBTCompoundTag var3 = var2.getCompound("display");
				if (var3 != null && var3.isTagAssignableFrom("color", 3)) {
					return var3.getInt("color");
				}
			}

			return 10511680;
		}
	}

	public void c(amj var1) {
		if (this.m == ajp.a) {
			NBTCompoundTag var2 = var1.o();
			if (var2 != null) {
				NBTCompoundTag var3 = var2.getCompound("display");
				if (var3.hasKey("color")) {
					var3.remove("color");
				}

			}
		}
	}

	public void b(amj var1, int var2) {
		if (this.m != ajp.a) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTCompoundTag var3 = var1.o();
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

	public boolean a(amj var1, amj var2) {
		return this.m.b() == var2.b() ? true : super.a(var1, var2);
	}

	public amj a(amj var1, World var2, ahd var3) {
		int var4 = xn.c(var1) - 1;
		amj var5 = var3.q(var4);
		if (var5 == null) {
			var3.c(var4, var1.k());
			var1.b = 0;
		}

		return var1;
	}

	// $FF: synthetic method
	static int[] d() {
		return k;
	}

}
