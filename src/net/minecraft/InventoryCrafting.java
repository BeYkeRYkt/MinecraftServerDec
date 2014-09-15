package net.minecraft;

public class InventoryCrafting implements IInventory {

	private final ItemStack[] a;
	private final int b;
	private final int c;
	private final Container d;

	public InventoryCrafting(Container var1, int var2, int var3) {
		int var4 = var2 * var3;
		this.a = new ItemStack[var4];
		this.d = var1;
		this.b = var2;
		this.c = var3;
	}

	public int n_() {
		return this.a.length;
	}

	public ItemStack a(int var1) {
		return var1 >= this.n_() ? null : this.a[var1];
	}

	public ItemStack c(int var1, int var2) {
		return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 <= this.c ? this.a(var1 + var2 * this.b) : null;
	}

	public String getName() {
		return "container.crafting";
	}

	public boolean k_() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.k_() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack b(int var1) {
		if (this.a[var1] != null) {
			ItemStack var2 = this.a[var1];
			this.a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public ItemStack a(int var1, int var2) {
		if (this.a[var1] != null) {
			ItemStack var3;
			if (this.a[var1].amount <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				this.d.a((IInventory) this);
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if (this.a[var1].amount == 0) {
					this.a[var1] = null;
				}

				this.d.a((IInventory) this);
				return var3;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.a[var1] = var2;
		this.d.a((IInventory) this);
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

	public int h() {
		return this.c;
	}

	public int i() {
		return this.b;
	}
}
