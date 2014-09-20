package net.minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.inventory.InventoryHolder;

public class InventoryLargeChest implements ILockable {

	private String inventoryName;
	private ILockable leftChest;
	private ILockable rightChest;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public InventoryLargeChest(String inventoryName, ILockable leftChest, ILockable rightChest) {
		this.inventoryName = inventoryName;

		if (leftChest == null) {
			leftChest = rightChest;
		}

		if (rightChest == null) {
			rightChest = leftChest;
		}

		this.leftChest = leftChest;
		this.rightChest = rightChest;
		if (leftChest.isLocked()) {
			rightChest.setLock(leftChest.getLock());
		} else if (rightChest.isLocked()) {
			leftChest.setLock(rightChest.getLock());
		}

	}

	public int getSize() {
		return this.leftChest.getSize() + this.rightChest.getSize();
	}

	public boolean isPartOfInventory(IInventory inventory) {
		return this.leftChest == inventory || this.rightChest == inventory;
	}

	public String getName() {
		return this.leftChest.hasCustomName() ? this.leftChest.getName() : (this.rightChest.hasCustomName() ? this.rightChest.getName() : this.inventoryName);
	}

	public boolean hasCustomName() {
		return this.leftChest.hasCustomName() || this.rightChest.hasCustomName();
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public ItemStack getItem(int slot) {
		return slot >= this.leftChest.getSize() ? this.rightChest.getItem(slot - this.leftChest.getSize()) : this.leftChest.getItem(slot);
	}

	public ItemStack splitStack(int slot, int splitSize) {
		return slot >= this.leftChest.getSize() ? this.rightChest.splitStack(slot - this.leftChest.getSize(), splitSize) : this.leftChest.splitStack(slot, splitSize);
	}

	public ItemStack splitWithoutUpdate(int splitSize) {
		return splitSize >= this.leftChest.getSize() ? this.rightChest.splitWithoutUpdate(splitSize - this.leftChest.getSize()) : this.leftChest.splitWithoutUpdate(splitSize);
	}

	public void setItem(int slot, ItemStack itemStack) {
		if (slot >= this.leftChest.getSize()) {
			this.rightChest.setItem(slot - this.leftChest.getSize(), itemStack);
		} else {
			this.leftChest.setItem(slot, itemStack);
		}
	}

	public int getMaxStackSize() {
		return this.leftChest.getMaxStackSize();
	}

	public void update() {
		this.leftChest.update();
		this.rightChest.update();
	}

	public boolean canInteract(EntityHuman who) {
		return this.leftChest.canInteract(who) && this.rightChest.canInteract(who);
	}

	public void onContainerOpen(EntityHuman who) {
		this.leftChest.onContainerOpen(who);
		this.rightChest.onContainerOpen(who);
		viewers.add(who);
	}

	public void onContainerClose(EntityHuman who) {
		this.leftChest.onContainerClose(who);
		this.rightChest.onContainerClose(who);
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

	public boolean isLocked() {
		return this.leftChest.isLocked() || this.rightChest.isLocked();
	}

	public void setLock(ContainerLock var1) {
		this.leftChest.setLock(var1);
		this.rightChest.setLock(var1);
	}

	public ContainerLock getLock() {
		return this.leftChest.getLock();
	}

	public String getInventoryType() {
		return this.leftChest.getInventoryType();
	}

	public Container getContainer(PlayerInventory playerInventory, EntityHuman human) {
		return new ContainerChest(playerInventory, this, human);
	}

	public void clearInventory() {
		this.leftChest.clearInventory();
		this.rightChest.clearInventory();
	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

	@Override
	public ItemStack[] getItems() {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		items.addAll(Arrays.asList(leftChest.getItems()));
		items.addAll(Arrays.asList(rightChest.getItems()));
		return items.toArray(new ItemStack[items.size()]);
	}

	@Override
	public InventoryHolder getHolder() {
		return null;
	}

}
