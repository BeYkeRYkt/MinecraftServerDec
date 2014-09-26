package net.minecraft;

public abstract class TileEntityLockable extends TileEntity implements IInventoryHasType, ILockable {

	private ContainerLock lock;

	public TileEntityLockable() {
		this.lock = ContainerLock.notLocked;
	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		this.lock = ContainerLock.fromNBT(tag);
	}

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		if (this.lock != null) {
			this.lock.write(tag);
		}

	}

	public boolean isLocked() {
		return this.lock != null && !this.lock.isNotLocked();
	}

	public ContainerLock getLock() {
		return this.lock;
	}

	public void setLock(ContainerLock lock) {
		this.lock = lock;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

}
