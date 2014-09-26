package net.minecraft;

public interface IInventoryHasType extends ICustomNameable {

	Container getContainer(InventoryPlayer playerInventory, EntityHuman player);

	String getInventoryType();

}
