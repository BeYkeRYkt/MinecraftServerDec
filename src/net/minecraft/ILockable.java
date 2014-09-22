package net.minecraft;

public interface ILockable extends IInventory, IInventoryHasType {

	boolean isLocked();

	void setLock(ContainerLock var1);

	ContainerLock getLock();
}
