package net.minecraft;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.InventoryHolder;

public class InventorySubcontainer implements IInventory {

	private String name;
	private int size;
	private ItemStack[] items;
	private List<IInventoryListener> listeners = Lists.newArrayList();;
	private boolean hasCustomName;

	public InventorySubcontainer(String name, boolean hasCustomName, int size) {
		this.name = name;
		this.hasCustomName = hasCustomName;
		this.size = size;
		this.items = new ItemStack[size];
	}

	public void addInventoryListener(IInventoryListener listener) {
		this.listeners.add(listener);
	}

	public void removeInventoryListener(IInventoryListener listener) {
		this.listeners.remove(listener);
	}

	public ItemStack getItem(int slot) {
		return slot >= 0 && slot < this.items.length ? this.items[slot] : null;
	}

	public ItemStack splitStack(int slot, int splitSize) {
		if (this.items[slot] != null) {
			ItemStack var3;
			if (this.items[slot].amount <= splitSize) {
				var3 = this.items[slot];
				this.items[slot] = null;
				this.update();
				return var3;
			} else {
				var3 = this.items[slot].a(splitSize);
				if (this.items[slot].amount == 0) {
					this.items[slot] = null;
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

	public ItemStack splitWithoutUpdate(int slot) {
		if (this.items[slot] != null) {
			ItemStack var2 = this.items[slot];
			this.items[slot] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int slot, ItemStack itemStack) {
		this.items[slot] = itemStack;
		if (itemStack != null && itemStack.amount > this.getMaxStackSize()) {
			itemStack.amount = this.getMaxStackSize();
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
		if (this.listeners != null) {
			for (int i = 0; i < this.listeners.size(); ++i) {
				((IInventoryListener) this.listeners.get(i)).a(this);
			}
		}

	}

	public boolean canInteract(EntityHuman who) {
		return true;
	}

	public void onContainerOpen(EntityHuman who) {
	}

	public void onContainerClose(EntityHuman who) {
	}

	public boolean canSuckItemFromInventory(int slot, ItemStack item) {
		return true;
	}

	public int getProperty(int property) {
		return 0;
	}

	public void selectBeaconPower(int powerSlot, int powerType) {
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
		return new ArrayList<EntityHuman>();
	}

	@Override
	public ItemStack[] getItems() {
		return items;
	}

	@Override
	public InventoryHolder getHolder() {
		return null;
	}

}
