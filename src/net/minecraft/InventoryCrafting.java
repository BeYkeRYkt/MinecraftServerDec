package net.minecraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

public class InventoryCrafting implements IInventory {

	private final ItemStack[] items;
	private final int cols;
	private final int rows;
	private final Container container;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();
	private EntityHuman owner;

	public InventoryCrafting(EntityHuman owner, Container container, int cols, int rows) {
		int size = cols * rows;
		this.items = new ItemStack[size];
		this.container = container;
		this.cols = cols;
		this.rows = rows;
	}

	public int getSize() {
		return this.items.length;
	}

	public ItemStack getItem(int slot) {
		return slot >= this.getSize() ? null : this.items[slot];
	}

	public ItemStack getItem(int col, int row) {
		return col >= 0 && col < this.cols && row >= 0 && row <= this.rows ? this.getItem(col + row * this.cols) : null;
	}

	public String getName() {
		return "container.crafting";
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
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

	public ItemStack splitStack(int var1, int var2) {
		if (this.items[var1] != null) {
			ItemStack var3;
			if (this.items[var1].amount <= var2) {
				var3 = this.items[var1];
				this.items[var1] = null;
				this.container.a((IInventory) this);
				return var3;
			} else {
				var3 = this.items[var1].a(var2);
				if (this.items[var1].amount == 0) {
					this.items[var1] = null;
				}

				this.container.a((IInventory) this);
				return var3;
			}
		} else {
			return null;
		}
	}

	public void setItem(int slot, ItemStack itemStack) {
		this.items[slot] = itemStack;
		this.container.a((IInventory) this);
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void update() {
	}

	public boolean canInteract(EntityHuman var1) {
		return true;
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

	public int getProperty(int var1) {
		return 0;
	}

	public void readClientCustomInput(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int i = 0; i < this.items.length; ++i) {
			this.items[i] = null;
		}

	}

	public int getRows() {
		return this.rows;
	}

	public int getCols() {
		return this.cols;
	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

	@Override
	public ItemStack[] getItems() {
		return items;
	}

	@Override
	public InventoryHolder getHolder() {
		if (owner != null) {
			return owner.getBukkitEntity(Player.class);
		}
		return null;
	}

}
