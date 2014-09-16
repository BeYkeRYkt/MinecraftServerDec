package net.minecraft;

import java.util.ArrayList;
import java.util.List;

public class InventoryMerchant implements IInventory {

	private final IMerchant merchant;
	private ItemStack[] items = new ItemStack[3];
	private final EntityHuman player;
	private MerchantRecipe recipe;
	private int e;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();
	

	public InventoryMerchant(EntityHuman var1, IMerchant var2) {
		this.player = var1;
		this.merchant = var2;
	}

	public int getSize() {
		return this.items.length;
	}

	public ItemStack getItem(int var1) {
		return this.items[var1];
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.items[var1] != null) {
			ItemStack var3;
			if (var1 == 2) {
				var3 = this.items[var1];
				this.items[var1] = null;
				return var3;
			} else if (this.items[var1].amount <= var2) {
				var3 = this.items[var1];
				this.items[var1] = null;
				if (this.e(var1)) {
					this.h();
				}

				return var3;
			} else {
				var3 = this.items[var1].a(var2);
				if (this.items[var1].amount == 0) {
					this.items[var1] = null;
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

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.items[var1] != null) {
			ItemStack var2 = this.items[var1];
			this.items[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.items[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

		if (this.e(var1)) {
			this.h();
		}

	}

	public String getName() {
		return "mob.villager";
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public int getMaxStackSize() {
		return 64;
	}

	public boolean canInteract(EntityHuman who) {
		return this.merchant.u_() == who;
	}

	public void onContainerOpen(EntityHuman who) {
		viewers.add(who);
	}

	public void onContainerClose(EntityHuman who) {
		viewers.remove(who);
	}

	public boolean canSuckItemFromInventory(int var1, ItemStack var2) {
		return true;
	}

	public void update() {
		this.h();
	}

	public void h() {
		this.recipe = null;
		ItemStack var1 = this.items[0];
		ItemStack var2 = this.items[1];
		if (var1 == null) {
			var1 = var2;
			var2 = null;
		}

		if (var1 == null) {
			this.setItem(2, (ItemStack) null);
		} else {
			MerchantRecipeList var3 = this.merchant.b_(this.player);
			if (var3 != null) {
				MerchantRecipe var4 = var3.a(var1, var2, this.e);
				if (var4 != null && !var4.h()) {
					this.recipe = var4;
					this.setItem(2, var4.d().getCopy());
				} else if (var2 != null) {
					var4 = var3.a(var2, var1, this.e);
					if (var4 != null && !var4.h()) {
						this.recipe = var4;
						this.setItem(2, var4.d().getCopy());
					} else {
						this.setItem(2, (ItemStack) null);
					}
				} else {
					this.setItem(2, (ItemStack) null);
				}
			}
		}

		this.merchant.a_(this.getItem(2));
	}

	public MerchantRecipe getRecipe() {
		return this.recipe;
	}

	public void d(int var1) {
		this.e = var1;
		this.h();
	}

	public int getProperty(int var1) {
		return 0;
	}

	public void selectBeaconPower(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int i = 0; i < this.items.length; ++i) {
			this.items[i] = null;
		}
	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

}
