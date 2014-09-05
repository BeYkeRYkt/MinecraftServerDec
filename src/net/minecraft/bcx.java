package net.minecraft;

import java.util.Random;

public class bcx extends bdf implements IInventory {

	private static final Random f = new Random();
	private ItemStack[] g = new ItemStack[9];
	protected String a;

	public int n_() {
		return 9;
	}

	public ItemStack a(int var1) {
		return this.g[var1];
	}

	public ItemStack a(int var1, int var2) {
		if (this.g[var1] != null) {
			ItemStack var3;
			if (this.g[var1].b <= var2) {
				var3 = this.g[var1];
				this.g[var1] = null;
				this.o_();
				return var3;
			} else {
				var3 = this.g[var1].a(var2);
				if (this.g[var1].b == 0) {
					this.g[var1] = null;
				}

				this.o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack b(int var1) {
		if (this.g[var1] != null) {
			ItemStack var2 = this.g[var1];
			this.g[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public int m() {
		int var1 = -1;
		int var2 = 1;

		for (int var3 = 0; var3 < this.g.length; ++var3) {
			if (this.g[var3] != null && f.nextInt(var2++) == 0) {
				var1 = var3;
			}
		}

		return var1;
	}

	public void a(int var1, ItemStack var2) {
		this.g[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

		this.o_();
	}

	public int a(ItemStack var1) {
		for (int var2 = 0; var2 < this.g.length; ++var2) {
			if (this.g[var2] == null || this.g[var2].getItem() == null) {
				this.a(var2, var1);
				return var2;
			}
		}

		return -1;
	}

	public String d_() {
		return this.k_() ? this.a : "container.dispenser";
	}

	public void a(String var1) {
		this.a = var1;
	}

	public boolean k_() {
		return this.a != null;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.g = new ItemStack[this.n_()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.g.length) {
				this.g[var5] = ItemStack.a(var4);
			}
		}

		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.a = var1.getString("CustomName");
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.g.length; ++var3) {
			if (this.g[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.g[var3].b(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
		if (this.k_()) {
			var1.put("CustomName", this.a);
		}

	}

	public int p_() {
		return 64;
	}

	public boolean a(EntityHuman var1) {
		return this.b.s(this.c) != this ? false : var1.e((double) this.c.n() + 0.5D, (double) this.c.o() + 0.5D, (double) this.c.p() + 0.5D) <= 64.0D;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public String k() {
		return "minecraft:dispenser";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aip(var1, this);
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public void l() {
		for (int var1 = 0; var1 < this.g.length; ++var1) {
			this.g[var1] = null;
		}

	}

}
