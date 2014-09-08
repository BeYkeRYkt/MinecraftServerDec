package net.minecraft;

import java.util.concurrent.Callable;

public class PlayerInventory implements IInventory {

	public static int getHotbarSize() {
		return 9;
	}

	public ItemStack[] contents = new ItemStack[36];
	public ItemStack[] armor = new ItemStack[4];
	public int itemInHandIndex;
	public EntityHuman d;
	private ItemStack f;
	public boolean e;

	public PlayerInventory(EntityHuman var1) {
		this.d = var1;
	}

	public ItemStack getItemInHand() {
		return this.itemInHandIndex < 9 && this.itemInHandIndex >= 0 ? this.contents[this.itemInHandIndex] : null;
	}

	private int c(Item var1) {
		for (int var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null && this.contents[var2].getItem() == var1) {
				return var2;
			}
		}

		return -1;
	}

	private int d(ItemStack var1) {
		for (int var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null && this.contents[var2].getItem() == var1.getItem() && this.contents[var2].d() && this.contents[var2].amount < this.contents[var2].getMaxStackSize() && this.contents[var2].amount < this.p_() && (!this.contents[var2].f() || this.contents[var2].getDurability() == var1.getDurability()) && ItemStack.a(this.contents[var2], var1)) {
				return var2;
			}
		}

		return -1;
	}

	public int j() {
		for (int var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] == null) {
				return var1;
			}
		}

		return -1;
	}

	public int a(Item var1, int var2, int var3, NBTCompoundTag var4) {
		int var5 = 0;

		int var6;
		ItemStack var7;
		int var8;
		for (var6 = 0; var6 < this.contents.length; ++var6) {
			var7 = this.contents[var6];
			if (var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getDurability() == var2) && (var4 == null || TestforBlockCommand.a(var4, var7.getTag(), true))) {
				var8 = var3 <= 0 ? var7.amount : Math.min(var3 - var5, var7.amount);
				var5 += var8;
				if (var3 != 0) {
					this.contents[var6].amount -= var8;
					if (this.contents[var6].amount == 0) {
						this.contents[var6] = null;
					}

					if (var3 > 0 && var5 >= var3) {
						return var5;
					}
				}
			}
		}

		for (var6 = 0; var6 < this.armor.length; ++var6) {
			var7 = this.armor[var6];
			if (var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getDurability() == var2) && (var4 == null || TestforBlockCommand.a(var4, var7.getTag(), false))) {
				var8 = var3 <= 0 ? var7.amount : Math.min(var3 - var5, var7.amount);
				var5 += var8;
				if (var3 != 0) {
					this.armor[var6].amount -= var8;
					if (this.armor[var6].amount == 0) {
						this.armor[var6] = null;
					}

					if (var3 > 0 && var5 >= var3) {
						return var5;
					}
				}
			}
		}

		if (this.f != null) {
			if (var1 != null && this.f.getItem() != var1) {
				return var5;
			}

			if (var2 > -1 && this.f.getDurability() != var2) {
				return var5;
			}

			if (var4 != null && !TestforBlockCommand.a(var4, this.f.getTag(), false)) {
				return var5;
			}

			var6 = var3 <= 0 ? this.f.amount : Math.min(var3 - var5, this.f.amount);
			var5 += var6;
			if (var3 != 0) {
				this.f.amount -= var6;
				if (this.f.amount == 0) {
					this.f = null;
				}

				if (var3 > 0 && var5 >= var3) {
					return var5;
				}
			}
		}

		return var5;
	}

	private int e(ItemStack var1) {
		Item var2 = var1.getItem();
		int var3 = var1.amount;
		int var4 = this.d(var1);
		if (var4 < 0) {
			var4 = this.j();
		}

		if (var4 < 0) {
			return var3;
		} else {
			if (this.contents[var4] == null) {
				this.contents[var4] = new ItemStack(var2, 0, var1.getDurability());
				if (var1.hasTag()) {
					this.contents[var4].setTag((NBTCompoundTag) var1.getTag().getCopy());
				}
			}

			int var5 = var3;
			if (var3 > this.contents[var4].getMaxStackSize() - this.contents[var4].amount) {
				var5 = this.contents[var4].getMaxStackSize() - this.contents[var4].amount;
			}

			if (var5 > this.p_() - this.contents[var4].amount) {
				var5 = this.p_() - this.contents[var4].amount;
			}

			if (var5 == 0) {
				return var3;
			} else {
				var3 -= var5;
				this.contents[var4].amount += var5;
				this.contents[var4].c = 5;
				return var3;
			}
		}
	}

	public void k() {
		for (int var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] != null) {
				this.contents[var1].a(this.d.world, this.d, var1, this.itemInHandIndex == var1);
			}
		}

	}

	public boolean a(Item var1) {
		int var2 = this.c(var1);
		if (var2 < 0) {
			return false;
		} else {
			if (--this.contents[var2].amount <= 0) {
				this.contents[var2] = null;
			}

			return true;
		}
	}

	public boolean b(Item var1) {
		int var2 = this.c(var1);
		return var2 >= 0;
	}

	public boolean a(ItemStack var1) {
		if (var1 != null && var1.amount != 0 && var1.getItem() != null) {
			try {
				int var2;
				if (var1.g()) {
					var2 = this.j();
					if (var2 >= 0) {
						this.contents[var2] = ItemStack.b(var1);
						this.contents[var2].c = 5;
						var1.amount = 0;
						return true;
					} else if (this.d.playerProperties.instabuild) {
						var1.amount = 0;
						return true;
					} else {
						return false;
					}
				} else {
					do {
						var2 = var1.amount;
						var1.amount = this.e(var1);
					} while (var1.amount > 0 && var1.amount < var2);

					if (var1.amount == var2 && this.d.playerProperties.instabuild) {
						var1.amount = 0;
						return true;
					} else {
						return var1.amount < var2;
					}
				}
			} catch (Throwable var5) {
				CrashReport var3 = CrashReport.generateCrashReport(var5, "Adding item to inventory");
				CrashReportSystemDetails var4 = var3.generateSystemDetails("Item being added");
				var4.addDetails("Item ID", (Object) Integer.valueOf(Item.getId(var1.getItem())));
				var4.addDetails("Item data", (Object) Integer.valueOf(var1.getDurability()));
				var4.addDetails("Item name", (Callable) (new ahc(this, var1)));
				throw new ReportedException(var3);
			}
		} else {
			return false;
		}
	}

	public ItemStack a(int var1, int var2) {
		ItemStack[] var3 = this.contents;
		if (var1 >= this.contents.length) {
			var3 = this.armor;
			var1 -= this.contents.length;
		}

		if (var3[var1] != null) {
			ItemStack var4;
			if (var3[var1].amount <= var2) {
				var4 = var3[var1];
				var3[var1] = null;
				return var4;
			} else {
				var4 = var3[var1].a(var2);
				if (var3[var1].amount == 0) {
					var3[var1] = null;
				}

				return var4;
			}
		} else {
			return null;
		}
	}

	public ItemStack b(int var1) {
		ItemStack[] var2 = this.contents;
		if (var1 >= this.contents.length) {
			var2 = this.armor;
			var1 -= this.contents.length;
		}

		if (var2[var1] != null) {
			ItemStack var3 = var2[var1];
			var2[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		ItemStack[] var3 = this.contents;
		if (var1 >= var3.length) {
			var1 -= var3.length;
			var3 = this.armor;
		}

		var3[var1] = var2;
	}

	public float a(Block var1) {
		float var2 = 1.0F;
		if (this.contents[this.itemInHandIndex] != null) {
			var2 *= this.contents[this.itemInHandIndex].a(var1);
		}

		return var2;
	}

	public NBTListTag a(NBTListTag var1) {
		int var2;
		NBTCompoundTag var3;
		for (var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null) {
				var3 = new NBTCompoundTag();
				var3.put("Slot", (byte) var2);
				this.contents[var2].write(var3);
				var1.addTag((NBTTag) var3);
			}
		}

		for (var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null) {
				var3 = new NBTCompoundTag();
				var3.put("Slot", (byte) (var2 + 100));
				this.armor[var2].write(var3);
				var1.addTag((NBTTag) var3);
			}
		}

		return var1;
	}

	public void b(NBTListTag var1) {
		this.contents = new ItemStack[36];
		this.armor = new ItemStack[4];

		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			int var4 = var3.getByte("Slot") & 255;
			ItemStack var5 = ItemStack.a(var3);
			if (var5 != null) {
				if (var4 >= 0 && var4 < this.contents.length) {
					this.contents[var4] = var5;
				}

				if (var4 >= 100 && var4 < this.armor.length + 100) {
					this.armor[var4 - 100] = var5;
				}
			}
		}

	}

	public int n_() {
		return this.contents.length + 4;
	}

	public ItemStack a(int var1) {
		ItemStack[] var2 = this.contents;
		if (var1 >= var2.length) {
			var1 -= var2.length;
			var2 = this.armor;
		}

		return var2[var1];
	}

	public String getName() {
		return "container.inventory";
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

	public boolean b(Block var1) {
		if (var1.getMaterial().l()) {
			return true;
		} else {
			ItemStack var2 = this.a(this.itemInHandIndex);
			return var2 != null ? var2.b(var1) : false;
		}
	}

	public ItemStack e(int var1) {
		return this.armor[var1];
	}

	public int m() {
		int var1 = 0;

		for (int var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null && this.armor[var2].getItem() instanceof ItemArmor) {
				int var3 = ((ItemArmor) this.armor[var2].getItem()).c;
				var1 += var3;
			}
		}

		return var1;
	}

	public void a(float var1) {
		var1 /= 4.0F;
		if (var1 < 1.0F) {
			var1 = 1.0F;
		}

		for (int var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null && this.armor[var2].getItem() instanceof ItemArmor) {
				this.armor[var2].a((int) var1, (EntityLiving) this.d);
				if (this.armor[var2].amount == 0) {
					this.armor[var2] = null;
				}
			}
		}

	}

	public void n() {
		int var1;
		for (var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] != null) {
				this.d.a(this.contents[var1], true, false);
				this.contents[var1] = null;
			}
		}

		for (var1 = 0; var1 < this.armor.length; ++var1) {
			if (this.armor[var1] != null) {
				this.d.a(this.armor[var1], true, false);
				this.armor[var1] = null;
			}
		}

	}

	public void update() {
		this.e = true;
	}

	public void b(ItemStack var1) {
		this.f = var1;
	}

	public ItemStack p() {
		return this.f;
	}

	public boolean a(EntityHuman var1) {
		return this.d.dead ? false : var1.getDistanceSquared(this.d) <= 64.0D;
	}

	public boolean c(ItemStack var1) {
		int var2;
		for (var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null && this.armor[var2].a(var1)) {
				return true;
			}
		}

		for (var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null && this.contents[var2].a(var1)) {
				return true;
			}
		}

		return false;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public void b(PlayerInventory var1) {
		int var2;
		for (var2 = 0; var2 < this.contents.length; ++var2) {
			this.contents[var2] = ItemStack.b(var1.contents[var2]);
		}

		for (var2 = 0; var2 < this.armor.length; ++var2) {
			this.armor[var2] = ItemStack.b(var1.armor[var2]);
		}

		this.itemInHandIndex = var1.itemInHandIndex;
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
		int var1;
		for (var1 = 0; var1 < this.contents.length; ++var1) {
			this.contents[var1] = null;
		}

		for (var1 = 0; var1 < this.armor.length; ++var1) {
			this.armor[var1] = null;
		}

	}
}
