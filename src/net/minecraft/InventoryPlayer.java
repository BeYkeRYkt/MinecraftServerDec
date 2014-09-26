package net.minecraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryHolder;

public class InventoryPlayer implements IInventory {

	public static int getHotbarSize() {
		return 9;
	}

	public ItemStack[] contents = new ItemStack[36];
	public ItemStack[] armor = new ItemStack[4];
	public int itemInHandIndex;
	public EntityHuman owner;
	private ItemStack carried;
	public boolean e;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public InventoryPlayer(EntityHuman viewers) {
		this.owner = viewers;
	}

	public ItemStack getItemInHand() {
		return this.itemInHandIndex < 9 && this.itemInHandIndex >= 0 ? this.contents[this.itemInHandIndex] : null;
	}

	private int firstItem(Item var1) {
		for (int var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null && this.contents[var2].getItem() == var1) {
				return var2;
			}
		}

		return -1;
	}

	private int firstPartial(ItemStack var1) {
		for (int var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null && this.contents[var2].getItem() == var1.getItem() && this.contents[var2].d() && this.contents[var2].amount < this.contents[var2].getMaxStackSize() && this.contents[var2].amount < this.getMaxStackSize() && (!this.contents[var2].f() || this.contents[var2].getWearout() == var1.getWearout()) && ItemStack.isSameNBTTags(this.contents[var2], var1)) {
				return var2;
			}
		}

		return -1;
	}

	public int getFirstEmptySlot() {
		for (int var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] == null) {
				return var1;
			}
		}

		return -1;
	}

	public int a(Item var1, int var2, int var3, NBTCompoundTag var4) {
		int var5 = 0;

		int var6;
		ItemStack var7;
		int var8;
		for (var6 = 0; var6 < this.contents.length; ++var6) {
			var7 = this.contents[var6];
			if (var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getWearout() == var2) && (var4 == null || TestforBlockCommand.a(var4, var7.getTag(), true))) {
				var8 = var3 <= 0 ? var7.amount : Math.min(var3 - var5, var7.amount);
				var5 += var8;
				if (var3 != 0) {
					this.contents[var6].amount -= var8;
					if (this.contents[var6].amount == 0) {
						this.contents[var6] = null;
					}

					if (var3 > 0 && var5 >= var3) {
						return var5;
					}
				}
			}
		}

		for (var6 = 0; var6 < this.armor.length; ++var6) {
			var7 = this.armor[var6];
			if (var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getWearout() == var2) && (var4 == null || TestforBlockCommand.a(var4, var7.getTag(), false))) {
				var8 = var3 <= 0 ? var7.amount : Math.min(var3 - var5, var7.amount);
				var5 += var8;
				if (var3 != 0) {
					this.armor[var6].amount -= var8;
					if (this.armor[var6].amount == 0) {
						this.armor[var6] = null;
					}

					if (var3 > 0 && var5 >= var3) {
						return var5;
					}
				}
			}
		}

		if (this.carried != null) {
			if (var1 != null && this.carried.getItem() != var1) {
				return var5;
			}

			if (var2 > -1 && this.carried.getWearout() != var2) {
				return var5;
			}

			if (var4 != null && !TestforBlockCommand.a(var4, this.carried.getTag(), false)) {
				return var5;
			}

			var6 = var3 <= 0 ? this.carried.amount : Math.min(var3 - var5, this.carried.amount);
			var5 += var6;
			if (var3 != 0) {
				this.carried.amount -= var6;
				if (this.carried.amount == 0) {
					this.carried = null;
				}

				if (var3 > 0 && var5 >= var3) {
					return var5;
				}
			}
		}

		return var5;
	}

	private int e(ItemStack var1) {
		Item var2 = var1.getItem();
		int var3 = var1.amount;
		int var4 = this.firstPartial(var1);
		if (var4 < 0) {
			var4 = this.getFirstEmptySlot();
		}

		if (var4 < 0) {
			return var3;
		} else {
			if (this.contents[var4] == null) {
				this.contents[var4] = new ItemStack(var2, 0, var1.getWearout());
				if (var1.hasTag()) {
					this.contents[var4].setTag((NBTCompoundTag) var1.getTag().getCopy());
				}
			}

			int var5 = var3;
			if (var3 > this.contents[var4].getMaxStackSize() - this.contents[var4].amount) {
				var5 = this.contents[var4].getMaxStackSize() - this.contents[var4].amount;
			}

			if (var5 > this.getMaxStackSize() - this.contents[var4].amount) {
				var5 = this.getMaxStackSize() - this.contents[var4].amount;
			}

			if (var5 == 0) {
				return var3;
			} else {
				var3 -= var5;
				this.contents[var4].amount += var5;
				this.contents[var4].c = 5;
				return var3;
			}
		}
	}

	public void k() {
		for (int var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] != null) {
				this.contents[var1].a(this.owner.world, this.owner, var1, this.itemInHandIndex == var1);
			}
		}

	}

	public boolean a(Item var1) {
		int var2 = this.firstItem(var1);
		if (var2 < 0) {
			return false;
		} else {
			if (--this.contents[var2].amount <= 0) {
				this.contents[var2] = null;
			}

			return true;
		}
	}

	public boolean hasItem(Item var1) {
		int var2 = this.firstItem(var1);
		return var2 >= 0;
	}

	public boolean pickup(ItemStack itemStack) {
		if (itemStack != null && itemStack.amount != 0 && itemStack.getItem() != null) {
			try {
				int var2;
				if (itemStack.g()) {
					var2 = this.getFirstEmptySlot();
					if (var2 >= 0) {
						this.contents[var2] = ItemStack.getCopy(itemStack);
						this.contents[var2].c = 5;
						itemStack.amount = 0;
						return true;
					} else if (this.owner.playerProperties.instabuild) {
						itemStack.amount = 0;
						return true;
					} else {
						return false;
					}
				} else {
					do {
						var2 = itemStack.amount;
						itemStack.amount = this.e(itemStack);
					} while (itemStack.amount > 0 && itemStack.amount < var2);

					if (itemStack.amount == var2 && this.owner.playerProperties.instabuild) {
						itemStack.amount = 0;
						return true;
					} else {
						return itemStack.amount < var2;
					}
				}
			} catch (Throwable var5) {
				CrashReport var3 = CrashReport.generateCrashReport(var5, "Adding item to inventory");
				CrashReportSystemDetails var4 = var3.generateSystemDetails("Item being added");
				var4.addDetails("Item ID", Item.getId(itemStack.getItem()));
				var4.addDetails("Item data", itemStack.getWearout());
				var4.addDetails("Item name", itemStack.getDisplayName());
				throw new ReportedException(var3);
			}
		} else {
			return false;
		}
	}

	public ItemStack splitStack(int var1, int var2) {
		ItemStack[] var3 = this.contents;
		if (var1 >= this.contents.length) {
			var3 = this.armor;
			var1 -= this.contents.length;
		}

		if (var3[var1] != null) {
			ItemStack var4;
			if (var3[var1].amount <= var2) {
				var4 = var3[var1];
				var3[var1] = null;
				return var4;
			} else {
				var4 = var3[var1].a(var2);
				if (var3[var1].amount == 0) {
					var3[var1] = null;
				}

				return var4;
			}
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		ItemStack[] var2 = this.contents;
		if (var1 >= this.contents.length) {
			var2 = this.armor;
			var1 -= this.contents.length;
		}

		if (var2[var1] != null) {
			ItemStack var3 = var2[var1];
			var2[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		ItemStack[] var3 = this.contents;
		if (var1 >= var3.length) {
			var1 -= var3.length;
			var3 = this.armor;
		}

		var3[var1] = var2;
	}

	public float a(Block var1) {
		float var2 = 1.0F;
		if (this.contents[this.itemInHandIndex] != null) {
			var2 *= this.contents[this.itemInHandIndex].a(var1);
		}

		return var2;
	}

	public NBTListTag write(NBTListTag var1) {
		int var2;
		NBTCompoundTag var3;
		for (var2 = 0; var2 < this.contents.length; ++var2) {
			if (this.contents[var2] != null) {
				var3 = new NBTCompoundTag();
				var3.put("Slot", (byte) var2);
				this.contents[var2].write(var3);
				var1.addTag((NBTTag) var3);
			}
		}

		for (var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null) {
				var3 = new NBTCompoundTag();
				var3.put("Slot", (byte) (var2 + 100));
				this.armor[var2].write(var3);
				var1.addTag((NBTTag) var3);
			}
		}

		return var1;
	}

	public void read(NBTListTag var1) {
		this.contents = new ItemStack[36];
		this.armor = new ItemStack[4];

		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			int var4 = var3.getByte("Slot") & 255;
			ItemStack var5 = ItemStack.fromNBT(var3);
			if (var5 != null) {
				if (var4 >= 0 && var4 < this.contents.length) {
					this.contents[var4] = var5;
				}

				if (var4 >= 100 && var4 < this.armor.length + 100) {
					this.armor[var4 - 100] = var5;
				}
			}
		}

	}

	public int getSize() {
		return this.contents.length + 4;
	}

	public ItemStack getItem(int slot) {
		ItemStack[] items = this.contents;
		if (slot >= items.length) {
			slot -= items.length;
			items = this.armor;
		}

		return items[slot];
	}

	public String getName() {
		return "container.inventory";
	}

	public boolean hasCustomName() {
		return false;
	}

	public IChatBaseComponent getComponentName() {
		return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
	}

	public int getMaxStackSize() {
		return 64;
	}

	public boolean b(Block var1) {
		if (var1.getMaterial().alwaysDropsItem()) {
			return true;
		} else {
			ItemStack var2 = this.getItem(this.itemInHandIndex);
			return var2 != null ? var2.canDestroySpecialBlock(var1) : false;
		}
	}

	public ItemStack getArmor(int index) {
		return this.armor[index];
	}

	public int m() {
		int var1 = 0;

		for (int var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null && this.armor[var2].getItem() instanceof ItemArmor) {
				int var3 = ((ItemArmor) this.armor[var2].getItem()).c;
				var1 += var3;
			}
		}

		return var1;
	}

	public void a(float var1) {
		var1 /= 4.0F;
		if (var1 < 1.0F) {
			var1 = 1.0F;
		}

		for (int var2 = 0; var2 < this.armor.length; ++var2) {
			if (this.armor[var2] != null && this.armor[var2].getItem() instanceof ItemArmor) {
				this.armor[var2].a((int) var1, (EntityLiving) this.owner);
				if (this.armor[var2].amount == 0) {
					this.armor[var2] = null;
				}
			}
		}

	}

	public void dropAllItems() {
		int var1;
		for (var1 = 0; var1 < this.contents.length; ++var1) {
			if (this.contents[var1] != null) {
				this.owner.a(this.contents[var1], true, false);
				this.contents[var1] = null;
			}
		}

		for (var1 = 0; var1 < this.armor.length; ++var1) {
			if (this.armor[var1] != null) {
				this.owner.a(this.armor[var1], true, false);
				this.armor[var1] = null;
			}
		}

	}

	public void update() {
		this.e = true;
	}

	public void setCarried(ItemStack itemStack) {
		this.carried = itemStack;
	}

	public ItemStack getCarried() {
		return this.carried;
	}

	public boolean canInteract(EntityHuman who) {
		return this.owner.dead ? false : who.getDistanceSquared(this.owner) <= 64.0D;
	}

	public boolean c(ItemStack itemStack) {
		for (int i = 0; i < this.armor.length; ++i) {
			if (this.armor[i] != null && this.armor[i].a(itemStack)) {
				return true;
			}
		}

		for (int i = 0; i < this.contents.length; ++i) {
			if (this.contents[i] != null && this.contents[i].a(itemStack)) {
				return true;
			}
		}

		return false;
	}

	public void onContainerOpen(EntityHuman who) {
		viewers.add(who);
	}

	public void onContainerClose(EntityHuman who) {
		viewers.remove(who);
	}

	public boolean canSuckItemFromInventory(int slot, ItemStack item) {
		return true;
	}

	public void copyInventoryFrom(InventoryPlayer otherInventory) {
		for (int i = 0; i < this.contents.length; ++i) {
			this.contents[i] = ItemStack.getCopy(otherInventory.contents[i]);
		}

		for (int i = 0; i < this.armor.length; ++i) {
			this.armor[i] = ItemStack.getCopy(otherInventory.armor[i]);
		}

		this.itemInHandIndex = otherInventory.itemInHandIndex;
	}

	public int getProperty(int property) {
		return 0;
	}

	public void readClientCustomInput(int powerSlot, int powerType) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int i = 0; i < this.contents.length; ++i) {
			this.contents[i] = null;
		}

		for (int i = 0; i < this.armor.length; ++i) {
			this.armor[i] = null;
		}

	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

	@Override
	public ItemStack[] getItems() {
		return contents;
	}

	@Override
	public InventoryHolder getHolder() {
		return owner.getBukkitEntity(HumanEntity.class);
	}

}
