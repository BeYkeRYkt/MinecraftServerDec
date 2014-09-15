package net.minecraft;

public class aji implements IInventory {

	private ItemStack[] a = new ItemStack[1];

	public int n_() {
		return 1;
	}

	public ItemStack a(int var1) {
		return this.a[0];
	}

	public String getName() {
		return "Result";
	}

	public boolean k_() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.k_() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack a(int var1, int var2) {
		if (this.a[0] != null) {
			ItemStack var3 = this.a[0];
			this.a[0] = null;
			return var3;
		} else {
			return null;
		}
	}

	public ItemStack b(int var1) {
		if (this.a[0] != null) {
			ItemStack var2 = this.a[0];
			this.a[0] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.a[0] = var2;
	}

	public int p_() {
		return 64;
	}

	public void update() {
	}

	public boolean a(EntityHuman var1) {
		return true;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
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
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}

	}
}
