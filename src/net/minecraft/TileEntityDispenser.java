package net.minecraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileEntityDispenser extends TileEntityLockable implements IInventory {

	private static final Random f = new Random();
	private ItemStack[] items = new ItemStack[9];
	protected String customName;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public int getSize() {
		return 9;
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
				this.update();
				return var3;
			} else {
				var3 = this.items[var1].a(var2);
				if (this.items[var1].amount == 0) {
					this.items[var1] = null;
				}

				this.update();
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

	public int m() {
		int var1 = -1;
		int var2 = 1;

		for (int var3 = 0; var3 < this.items.length; ++var3) {
			if (this.items[var3] != null && f.nextInt(var2++) == 0) {
				var1 = var3;
			}
		}

		return var1;
	}

	public void setItem(int var1, ItemStack var2) {
		this.items[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

		this.update();
	}

	public int a(ItemStack var1) {
		for (int var2 = 0; var2 < this.items.length; ++var2) {
			if (this.items[var2] == null || this.items[var2].getItem() == null) {
				this.setItem(var2, var1);
				return var2;
			}
		}

		return -1;
	}

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.dispenser";
	}

	public void a(String var1) {
		this.customName = var1;
	}

	public boolean hasCustomName() {
		return this.customName != null;
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.items = new ItemStack[this.getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.items.length) {
				this.items[var5] = ItemStack.fromNBT(var4);
			}
		}

		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.customName = var1.getString("CustomName");
		}

	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
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
		if (this.hasCustomName()) {
			var1.put("CustomName", this.customName);
		}

	}

	public int getMaxStackSize() {
		return 64;
	}

	public boolean canInteract(EntityHuman var1) {
		return this.world.getTileEntity(this.position) != this ? false : var1.getDistanceSquared((double) this.position.getX() + 0.5D, (double) this.position.getY() + 0.5D, (double) this.position.getZ() + 0.5D) <= 64.0D;
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

	public String getInventoryType() {
		return "minecraft:dispenser";
	}

	public Container getContainer(PlayerInventory var1, EntityHuman var2) {
		return new aip(var1, this);
	}

	public int getProperty(int var1) {
		return 0;
	}

	public void selectBeaconPower(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int var1 = 0; var1 < this.items.length; ++var1) {
			this.items[var1] = null;
		}

	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

	@Override
	public ItemStack[] getItems() {
		return items;
	}

}
