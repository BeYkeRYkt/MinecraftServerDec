package net.minecraft;

public class InventoryEnderChest extends wa {

	private TileEntityEnderChest a;

	public InventoryEnderChest() {
		super("container.enderchest", false, 27);
	}

	public void a(TileEntityEnderChest var1) {
		this.a = var1;
	}

	public void a(NBTListTag var1) {
		int var2;
		for (var2 = 0; var2 < this.n_(); ++var2) {
			this.a(var2, (ItemStack) null);
		}

		for (var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			int var4 = var3.getByte("Slot") & 255;
			if (var4 >= 0 && var4 < this.n_()) {
				this.a(var4, ItemStack.a(var3));
			}
		}

	}

	public NBTListTag h() {
		NBTListTag var1 = new NBTListTag();

		for (int var2 = 0; var2 < this.n_(); ++var2) {
			ItemStack var3 = this.a(var2);
			if (var3 != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var2);
				var3.write(var4);
				var1.addTag((NBTTag) var4);
			}
		}

		return var1;
	}

	public boolean a(EntityHuman var1) {
		return this.a != null && !this.a.a(var1) ? false : super.a(var1);
	}

	public void b(EntityHuman var1) {
		if (this.a != null) {
			this.a.b();
		}

		super.b(var1);
	}

	public void c(EntityHuman var1) {
		if (this.a != null) {
			this.a.d();
		}

		super.c(var1);
		this.a = null;
	}
}
