package net.minecraft;

public interface ILockable extends IInventory, vv {

	boolean isLocked();

	void setLock(ContainerLock var1);

	ContainerLock getLock();
}
