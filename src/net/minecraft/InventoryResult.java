package net.minecraft;

import java.util.ArrayList;
import java.util.List;

public class InventoryResult implements IInventory {

	private ItemStack[] a = new ItemStack[1];

	public int getSize() {
		return 1;
	}

	public ItemStack getItem(int var1) {
		return this.a[0];
	}

	public String getName() {
		return "Result";
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.a[0] != null) {
			ItemStack var3 = this.a[0];
			this.a[0] = null;
			return var3;
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.a[0] != null) {
			ItemStack var2 = this.a[0];
			this.a[0] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.a[0] = var2;
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void update() {
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
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}
	}

	@Override
	public List<EntityHuman> getViewers() {
		return new ArrayList<EntityHuman>();
	}

}
