package net.minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.inventory.InventoryHolder;

public abstract class InventoryMinecart extends adx implements ILockable {

	protected ItemStack[] items = new ItemStack[36];
	private boolean b = true;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public InventoryMinecart(World var1) {
		super(var1);
	}

	public InventoryMinecart(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public void a(DamageSource var1) {
		super.a(var1);
		vs.a(this.world, (Entity) this, this);
	}

	public ItemStack getItem(int var1) {
		return this.items[var1];
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.items[var1] != null) {
			ItemStack var3;
			if (this.items[var1].amount <= var2) {
				var3 = this.items[var1];
				this.items[var1] = null;
				return var3;
			} else {
				var3 = this.items[var1].a(var2);
				if (this.items[var1].amount == 0) {
					this.items[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.items[var1] != null) {
			ItemStack var2 = this.items[var1];
			this.items[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.items[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

	}

	public void update() {
	}

	public boolean canInteract(EntityHuman var1) {
		return this.dead ? false : var1.getDistanceSquared(this) <= 64.0D;
	}

	public void onContainerOpen(EntityHuman var1) {
		viewers.add(var1);
	}

	public void onContainerClose(EntityHuman var1) {
		viewers.remove(var1);
	}

	public boolean canSuckItemFromInventory(int var1, ItemStack var2) {
		return true;
	}

	public String getName() {
		return this.hasCustomName() ? this.getCustomName() : "container.minecart";
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void c(int var1) {
		this.b = false;
		super.c(var1);
	}

	public void die() {
		if (this.b) {
			vs.a(this.world, (Entity) this, this);
		}

		super.die();
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.items.length; ++var3) {
			if (this.items[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.items[var3].write(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.items = new ItemStack[this.getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.items.length) {
				this.items[var5] = ItemStack.fromNBT(var4);
			}
		}

	}

	public boolean e(EntityHuman var1) {
		if (!this.world.isStatic) {
			var1.openDispenser((IInventory) this);
		}

		return true;
	}

	protected void o() {
		int var1 = 15 - Container.b((IInventory) this);
		float var2 = 0.98F + (float) var1 * 0.001F;
		this.motionX *= (double) var2;
		this.motionY *= 0.0D;
		this.motionZ *= (double) var2;
	}

	public int getProperty(int var1) {
		return 0;
	}

	public void selectBeaconPower(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public boolean isLocked() {
		return false;
	}

	public void setLock(ContainerLock var1) {
	}

	public ContainerLock getLock() {
		return ContainerLock.notLocked;
	}

	public void clearInventory() {
		for (int var1 = 0; var1 < this.items.length; ++var1) {
			this.items[var1] = null;
		}

	}

	public List<EntityHuman> getViewers() {
		return viewers;
	}

	@Override
	public ItemStack[] getItems() {
		return Arrays.copyOfRange(items, 0, getSize());
	}

	@Override
	public InventoryHolder getHolder() {
		org.bukkit.entity.Entity minecart = getBukkitEntity(org.bukkit.entity.Entity.class);
		if (minecart instanceof InventoryHolder) {
			return (InventoryHolder) minecart;
		}
		return null;
	}

}
