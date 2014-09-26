package net.minecraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.InventoryHolder;

public class InventoryResult implements IInventory {

	private ItemStack[] resultItems = new ItemStack[1];

	public int getSize() {
		return 1;
	}

	public ItemStack getItem(int var1) {
		return this.resultItems[0];
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
		if (this.resultItems[0] != null) {
			ItemStack var3 = this.resultItems[0];
			this.resultItems[0] = null;
			return var3;
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.resultItems[0] != null) {
			ItemStack var2 = this.resultItems[0];
			this.resultItems[0] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.resultItems[0] = var2;
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

	public void readClientCustomInput(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int i = 0; i < this.resultItems.length; ++i) {
			this.resultItems[i] = null;
		}
	}

	@Override
	public List<EntityHuman> getViewers() {
		return new ArrayList<EntityHuman>();
	}

	@Override
	public ItemStack[] getItems() {
		return resultItems;
	}

	@Override
	public InventoryHolder getHolder() {
		return null;
	}

}
