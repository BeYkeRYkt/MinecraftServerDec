package net.minecraft;

import java.util.List;

import org.bukkit.inventory.InventoryHolder;

public interface IInventory extends ICustomNameable {

	public int getSize();

	public ItemStack getItem(int slot);

	public ItemStack splitStack(int slot, int splitSize);

	public ItemStack splitWithoutUpdate(int slot);

	public void setItem(int slot, ItemStack itemStack);

	public int getMaxStackSize();

	public void update();

	public boolean canInteract(EntityHuman who);

	public void onContainerOpen(EntityHuman who);

	public void onContainerClose(EntityHuman who);

	public boolean canSuckItemFromInventory(int slot, ItemStack itemStack);

	public int getProperty(int propertyNumber);

	public void selectBeaconPower(int powerSlot, int powerType);

	public int getPropertiesCount();

	public void clearInventory();

	public List<EntityHuman> getViewers();

	public ItemStack[] getItems();

	public InventoryHolder getHolder();

}
