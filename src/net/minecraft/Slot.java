package net.minecraft;

public class Slot {

	private final int a;
	public final IInventory inventory;
	public int index;
	public int f;
	public int g;

	public Slot(IInventory var1, int var2, int var3, int var4) {
		this.inventory = var1;
		this.a = var2;
		this.f = var3;
		this.g = var4;
	}

	public void a(ItemStack var1, ItemStack var2) {
		if (var1 != null && var2 != null) {
			if (var1.getItem() == var2.getItem()) {
				int var3 = var2.amount - var1.amount;
				if (var3 > 0) {
					this.a(var1, var3);
				}

			}
		}
	}

	protected void a(ItemStack var1, int var2) {
	}

	protected void c(ItemStack var1) {
	}

	public void a(EntityHuman var1, ItemStack var2) {
		this.update();
	}

	public boolean a(ItemStack var1) {
		return true;
	}

	public ItemStack getItemStack() {
		return this.inventory.getItem(this.a);
	}

	public boolean hasItem() {
		return this.getItemStack() != null;
	}

	public void d(ItemStack var1) {
		this.inventory.setItem(this.a, var1);
		this.update();
	}

	public void update() {
		this.inventory.update();
	}

	public int a() {
		return this.inventory.getMaxStackSize();
	}

	public int b(ItemStack var1) {
		return this.a();
	}

	public ItemStack a(int var1) {
		return this.inventory.splitStack(this.a, var1);
	}

	public boolean a(IInventory var1, int var2) {
		return var1 == this.inventory && var2 == this.a;
	}

	public boolean a(EntityHuman var1) {
		return true;
	}
}
