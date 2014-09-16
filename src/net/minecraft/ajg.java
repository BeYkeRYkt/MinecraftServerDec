package net.minecraft;

public class ajg extends Slot {

	private final InventoryMerchant a;
	private EntityHuman b;
	private int c;
	private final IMerchant h;

	public ajg(EntityHuman var1, IMerchant var2, InventoryMerchant var3, int var4, int var5, int var6) {
		super(var3, var4, var5, var6);
		this.b = var1;
		this.h = var2;
		this.a = var3;
	}

	public boolean a(ItemStack var1) {
		return false;
	}

	public ItemStack a(int var1) {
		if (this.hasItem()) {
			this.c += Math.min(var1, this.getItemStack().amount);
		}

		return super.a(var1);
	}

	protected void a(ItemStack var1, int var2) {
		this.c += var2;
		this.c(var1);
	}

	protected void c(ItemStack var1) {
		var1.a(this.b.world, this.b, this.c);
		this.c = 0;
	}

	public void a(EntityHuman var1, ItemStack var2) {
		this.c(var2);
		MerchantRecipe var3 = this.a.getRecipe();
		if (var3 != null) {
			ItemStack var4 = this.a.getItem(0);
			ItemStack var5 = this.a.getItem(1);
			if (this.a(var3, var4, var5) || this.a(var3, var5, var4)) {
				this.h.a(var3);
				var1.b(StatisticList.G);
				if (var4 != null && var4.amount <= 0) {
					var4 = null;
				}

				if (var5 != null && var5.amount <= 0) {
					var5 = null;
				}

				this.a.setItem(0, var4);
				this.a.setItem(1, var5);
			}
		}

	}

	private boolean a(MerchantRecipe var1, ItemStack var2, ItemStack var3) {
		ItemStack var4 = var1.a();
		ItemStack var5 = var1.b();
		if (var2 != null && var2.getItem() == var4.getItem()) {
			if (var5 != null && var3 != null && var5.getItem() == var3.getItem()) {
				var2.amount -= var4.amount;
				var3.amount -= var5.amount;
				return true;
			}

			if (var5 == null && var3 == null) {
				var2.amount -= var4.amount;
				return true;
			}
		}

		return false;
	}
}
