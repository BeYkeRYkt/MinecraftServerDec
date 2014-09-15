package net.minecraft;

import java.util.List;

public interface ICrafting {

	void setContainerData(Container container, List<ItemStack> items);

	void setContainerData(Container container, int slot, ItemStack item);

	void setContainerData(Container container, int slot, int id);

	void setContainerData(Container container, IInventory inventory);

}
