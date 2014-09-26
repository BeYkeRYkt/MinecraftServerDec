package net.minecraft;

public class ContainerLock {

	public static final ContainerLock notLocked = new ContainerLock("");

	public static ContainerLock fromNBT(NBTCompoundTag tag) {
		if (tag.isTagAssignableFrom("Lock", 8)) {
			String itemDisplayName = tag.getString("Lock");
			return new ContainerLock(itemDisplayName);
		} else {
			return notLocked;
		}
	}

	private final String unlockingItemDisplayerName;

	public ContainerLock(String itemDisplayName) {
		this.unlockingItemDisplayerName = itemDisplayName;
	}

	public boolean isNotLocked() {
		return this.unlockingItemDisplayerName == null || this.unlockingItemDisplayerName.isEmpty();
	}

	public String getUnlockingItemDisplayName() {
		return this.unlockingItemDisplayerName;
	}

	public void write(NBTCompoundTag tag) {
		tag.put("Lock", this.unlockingItemDisplayerName);
	}
}
