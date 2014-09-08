package net.minecraft;

public class ContainerMerchant extends Container {

	private aqb a;
	private aje f;
	private final World g;

	public ContainerMerchant(PlayerInventory var1, aqb var2, World var3) {
		this.a = var2;
		this.g = var3;
		this.f = new aje(var1.d, var2);
		this.addSlot(new Slot(this.f, 0, 36, 53));
		this.addSlot(new Slot(this.f, 1, 62, 53));
		this.addSlot((Slot) (new ajg(var1.d, var2, this.f, 2, 120, 53)));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.addSlot(new Slot(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.addSlot(new Slot(var1, var4, 8 + var4 * 18, 142));
		}

	}

	public aje e() {
		return this.f;
	}

	public void addSlotListener(ICrafting var1) {
		super.addSlotListener(var1);
	}

	public void b() {
		super.b();
	}

	public void a(IInventory var1) {
		this.f.h();
		super.a(var1);
	}

	public void selectOffer(int var1) {
		this.f.d(var1);
	}

	public boolean a(EntityHuman var1) {
		return this.a.u_() == var1;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 != 0 && var2 != 1) {
				if (var2 >= 3 && var2 < 30) {
					if (!this.a(var5, 30, 39, false)) {
						return null;
					}
				} else if (var2 >= 30 && var2 < 39 && !this.a(var5, 3, 30, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
				return null;
			}

			if (var5.amount == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.update();
			}

			if (var5.amount == var3.amount) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);
		this.a.a_((EntityHuman) null);
		super.onClose(var1);
		if (!this.g.D) {
			ItemStack var2 = this.f.b(0);
			if (var2 != null) {
				var1.dropItem(var2, false);
			}

			var2 = this.f.b(1);
			if (var2 != null) {
				var1.dropItem(var2, false);
			}

		}
	}
}
