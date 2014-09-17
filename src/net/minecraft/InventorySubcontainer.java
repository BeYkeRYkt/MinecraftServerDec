package net.minecraft;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class InventorySubcontainer implements IInventory {

	private String name;
	private int size;
	private ItemStack[] items;
	private List<IInventoryListener> d;
	private boolean hasCustomName;

	public InventorySubcontainer(String var1, boolean var2, int size) {
		this.name = var1;
		this.hasCustomName = var2;
		this.size = size;
		this.items = new ItemStack[size];
	}

	public void a(IInventoryListener var1) {
		if (this.d == null) {
			this.d = Lists.newArrayList();
		}

		this.d.add(var1);
	}

	public void b(IInventoryListener var1) {
		this.d.remove(var1);
	}

	public ItemStack getItem(int var1) {
		return var1 >= 0 && var1 < this.items.length ? this.items[var1] : null;
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.items[var1] != null) {
			ItemStack var3;
			if (this.items[var1].amount <= var2) {
				var3 = this.items[var1];
				this.items[var1] = null;
				this.update();
				return var3;
			} else {
				var3 = this.items[var1].a(var2);
				if (this.items[var1].amount == 0) {
					this.items[var1] = null;
				}

				this.update();
				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack a(ItemStack var1) {
		ItemStack var2 = var1.getCopy();

		for (int var3 = 0; var3 < this.size; ++var3) {
			ItemStack var4 = this.getItem(var3);
			if (var4 == null) {
				this.setItem(var3, var2);
				this.update();
				return null;
			}

			if (ItemStack.c(var4, var2)) {
				int var5 = Math.min(this.getMaxStackSize(), var4.getMaxStackSize());
				int var6 = Math.min(var2.amount, var5 - var4.amount);
				if (var6 > 0) {
					var4.amount += var6;
					var2.amount -= var6;
					if (var2.amount <= 0) {
						this.update();
						return null;
					}
				}
			}
		}

		if (var2.amount != var1.amount) {
			this.update();
		}

		return var2;
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

		this.update();
	}

	public int getSize() {
		return this.size;
	}

	public String getName() {
		return this.name;
	}

	public boolean hasCustomName() {
		return this.hasCustomName;
	}

	public void setCustomName(String name) {
		this.hasCustomName = true;
		this.name = name;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void update() {
		if (this.d != null) {
			for (int var1 = 0; var1 < this.d.size(); ++var1) {
				((IInventoryListener) this.d.get(var1)).a(this);
			}
		}

	}

	public boolean canInteract(EntityHuman var1) {
		return true;
	}

	public void onContainerOpen(EntityHuman var1) {
	}

	public void onContainerClose(EntityHuman var1) {
	}

	public boolean canSuckItemFromInventory(int var1, ItemStack var2) {
		return true;
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
		for (int var1 = 0; var1 < this.items.length; ++var1) {
			this.items[var1] = null;
		}

	}

	@Override
	public List<EntityHuman> getViewers() {
		return new ArrayList<EntityHuman>();
	}

	@Override
	public ItemStack[] getItems() {
		return items;
	}

}
