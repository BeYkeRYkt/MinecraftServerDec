package net.minecraft;

public class aje implements IInventory {

	private final IMerchant a;
	private ItemStack[] b = new ItemStack[3];
	private final EntityHuman c;
	private aqc d;
	private int e;

	public aje(EntityHuman var1, IMerchant var2) {
		this.c = var1;
		this.a = var2;
	}

	public int n_() {
		return this.b.length;
	}

	public ItemStack a(int var1) {
		return this.b[var1];
	}

	public ItemStack a(int var1, int var2) {
		if (this.b[var1] != null) {
			ItemStack var3;
			if (var1 == 2) {
				var3 = this.b[var1];
				this.b[var1] = null;
				return var3;
			} else if (this.b[var1].amount <= var2) {
				var3 = this.b[var1];
				this.b[var1] = null;
				if (this.e(var1)) {
					this.h();
				}

				return var3;
			} else {
				var3 = this.b[var1].a(var2);
				if (this.b[var1].amount == 0) {
					this.b[var1] = null;
				}

				if (this.e(var1)) {
					this.h();
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	private boolean e(int var1) {
		return var1 == 0 || var1 == 1;
	}

	public ItemStack b(int var1) {
		if (this.b[var1] != null) {
			ItemStack var2 = this.b[var1];
			this.b[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.b[var1] = var2;
		if (var2 != null && var2.amount > this.p_()) {
			var2.amount = this.p_();
		}

		if (this.e(var1)) {
			this.h();
		}

	}

	public String getName() {
		return "mob.villager";
	}

	public boolean k_() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.k_() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public int p_() {
		return 64;
	}

	public boolean a(EntityHuman var1) {
		return this.a.u_() == var1;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public void update() {
		this.h();
	}

	public void h() {
		this.d = null;
		ItemStack var1 = this.b[0];
		ItemStack var2 = this.b[1];
		if (var1 == null) {
			var1 = var2;
			var2 = null;
		}

		if (var1 == null) {
			this.a(2, (ItemStack) null);
		} else {
			MerchantRecipeList var3 = this.a.b_(this.c);
			if (var3 != null) {
				aqc var4 = var3.a(var1, var2, this.e);
				if (var4 != null && !var4.h()) {
					this.d = var4;
					this.a(2, var4.d().getCopy());
				} else if (var2 != null) {
					var4 = var3.a(var2, var1, this.e);
					if (var4 != null && !var4.h()) {
						this.d = var4;
						this.a(2, var4.d().getCopy());
					} else {
						this.a(2, (ItemStack) null);
					}
				} else {
					this.a(2, (ItemStack) null);
				}
			}
		}

		this.a.a_(this.a(2));
	}

	public aqc i() {
		return this.d;
	}

	public void d(int var1) {
		this.e = var1;
		this.h();
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
		for (int var1 = 0; var1 < this.b.length; ++var1) {
			this.b[var1] = null;
		}

	}
}
