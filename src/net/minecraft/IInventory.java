package net.minecraft;

public interface IInventory extends vz {

	int getSize();

	ItemStack getItem(int slot);

	ItemStack splitStack(int slot, int splitSize);

	ItemStack splitWithoutUpdate(int slot);

	void setItem(int slot, ItemStack itemStack);

	int getMaxStackSize();

	void update();

	boolean canInteract(EntityHuman who);

	void onContainerOpen(EntityHuman who);

	void onContainerClose(EntityHuman who);

	boolean b(int var1, ItemStack var2);

	int getProperty(int propertyNumber);

	void b(int var1, int var2);

	int getPropertiesCount();

	void clearInventory();

}
