package net.minecraft;

import java.util.List;

public interface ICrafting {

	void sendContainerItems(Container container, List<ItemStack> items);

	void sendContainerItem(Container container, int slot, ItemStack item);

	void sendContainerProperty(Container container, int slot, int id);

	void sendContainerProperties(Container container, IInventory inventory);

}
