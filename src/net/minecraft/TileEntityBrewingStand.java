package net.minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TileEntityBrewingStand extends TileEntityLockable implements ITickable, IWorldInventory {

	private static final int[] a = new int[] { 3 };
	private static final int[] f = new int[] { 0, 1, 2 };
	private ItemStack[] items = new ItemStack[4];
	private int brewTime;
	private boolean[] i;
	private Item j;
	private String customName;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.brewing";
	}

	public boolean hasCustomName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void a(String var1) {
		this.customName = var1;
	}

	public int getSize() {
		return this.items.length;
	}

	public void doTick() {
		if (this.brewTime > 0) {
			--this.brewTime;
			if (this.brewTime == 0) {
				this.o();
				this.update();
			} else if (!this.n()) {
				this.brewTime = 0;
				this.update();
			} else if (this.j != this.items[3].getItem()) {
				this.brewTime = 0;
				this.update();
			}
		} else if (this.n()) {
			this.brewTime = 400;
			this.j = this.items[3].getItem();
		}

		if (!this.world.isStatic) {
			boolean[] var1 = this.m();
			if (!Arrays.equals(var1, this.i)) {
				this.i = var1;
				IBlockState var2 = this.world.getBlockState(this.getPosition());
				if (!(var2.getBlock() instanceof BlockBrewingStand)) {
					return;
				}

				for (int var3 = 0; var3 < BlockBrewingStand.a.length; ++var3) {
					var2 = var2.a(BlockBrewingStand.a[var3], Boolean.valueOf(var1[var3]));
				}

				this.world.setBlockAt(this.position, var2, 2);
			}
		}

	}

	private boolean n() {
		if (this.items[3] != null && this.items[3].amount > 0) {
			ItemStack var1 = this.items[3];
			if (!var1.getItem().l(var1)) {
				return false;
			} else {
				boolean var2 = false;

				for (int var3 = 0; var3 < 3; ++var3) {
					if (this.items[var3] != null && this.items[var3].getItem() == Items.POTION) {
						int var4 = this.items[var3].getWearout();
						int var5 = this.c(var4, var1);
						if (!ItemPotion.f(var4) && ItemPotion.f(var5)) {
							var2 = true;
							break;
						}

						List var6 = Items.POTION.e(var4);
						List var7 = Items.POTION.e(var5);
						if ((var4 <= 0 || var6 != var7) && (var6 == null || !var6.equals(var7) && var7 != null) && var4 != var5) {
							var2 = true;
							break;
						}
					}
				}

				return var2;
			}
		} else {
			return false;
		}
	}

	private void o() {
		if (this.n()) {
			ItemStack var1 = this.items[3];

			for (int var2 = 0; var2 < 3; ++var2) {
				if (this.items[var2] != null && this.items[var2].getItem() == Items.POTION) {
					int var3 = this.items[var2].getWearout();
					int var4 = this.c(var3, var1);
					List var5 = Items.POTION.e(var3);
					List var6 = Items.POTION.e(var4);
					if ((var3 <= 0 || var5 != var6) && (var5 == null || !var5.equals(var6) && var6 != null)) {
						if (var3 != var4) {
							this.items[var2].setWearout(var4);
						}
					} else if (!ItemPotion.f(var3) && ItemPotion.f(var4)) {
						this.items[var2].setWearout(var4);
					}
				}
			}

			if (var1.getItem().r()) {
				this.items[3] = new ItemStack(var1.getItem().getCraftingResult());
			} else {
				--this.items[3].amount;
				if (this.items[3].amount <= 0) {
					this.items[3] = null;
				}
			}

		}
	}

	private int c(int var1, ItemStack var2) {
		return var2 == null ? var1 : (var2.getItem().l(var2) ? PotionBrewer.a(var1, var2.getItem().j(var2)) : var1);
	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		NBTListTag var2 = tag.getList("Items", 10);
		this.items = new ItemStack[this.getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if (var5 >= 0 && var5 < this.items.length) {
				this.items[var5] = ItemStack.fromNBT(var4);
			}
		}

		this.brewTime = tag.getShort("BrewTime");
		if (tag.isTagAssignableFrom("CustomName", 8)) {
			this.customName = tag.getString("CustomName");
		}

	}

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		tag.put("BrewTime", (short) this.brewTime);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.items.length; ++var3) {
			if (this.items[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.items[var3].write(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		tag.put("Items", (NBTTag) var2);
		if (this.hasCustomName()) {
			tag.put("CustomName", this.customName);
		}

	}

	public ItemStack getItem(int var1) {
		return var1 >= 0 && var1 < this.items.length ? this.items[var1] : null;
	}

	public ItemStack splitStack(int var1, int var2) {
		if (var1 >= 0 && var1 < this.items.length) {
			ItemStack var3 = this.items[var1];
			this.items[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (var1 >= 0 && var1 < this.items.length) {
			ItemStack var2 = this.items[var1];
			this.items[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		if (var1 >= 0 && var1 < this.items.length) {
			this.items[var1] = var2;
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
		return var1 == 3 ? var2.getItem().l(var2) : var2.getItem() == Items.POTION || var2.getItem() == Items.GLASS_BOTTLE;
	}

	public boolean[] m() {
		boolean[] var1 = new boolean[3];

		for (int var2 = 0; var2 < 3; ++var2) {
			if (this.items[var2] != null) {
				var1[var2] = true;
			}
		}

		return var1;
	}

	public int[] a(BlockFace var1) {
		return var1 == BlockFace.UP ? a : f;
	}

	public boolean a(int var1, ItemStack var2, BlockFace var3) {
		return this.canSuckItemFromInventory(var1, var2);
	}

	public boolean b(int var1, ItemStack var2, BlockFace var3) {
		return true;
	}

	public String getInventoryType() {
		return "minecraft:brewing_stand";
	}

	public Container getContainer(InventoryPlayer var1, EntityHuman var2) {
		return new ContainerBrewingStand(var1, this);
	}

	public int getProperty(int var1) {
		switch (var1) {
			case 0:
				return this.brewTime;
			default:
				return 0;
		}
	}

	public void readClientCustomInput(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 1;
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

	public int getBrewTime() {
		return brewTime;
	}

	public void setBrewTime(int brewTime) {
		this.brewTime = brewTime;
	}

}
