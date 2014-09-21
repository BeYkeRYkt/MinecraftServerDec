package net.minecraft;

import java.util.ArrayList;
import java.util.List;

public class TileEntityFurnace extends TileEntityLockable implements ITickable, IWorldInventory {

	private static final int[] a = new int[] { 0 };
	private static final int[] f = new int[] { 2, 1 };
	private static final int[] g = new int[] { 1 };
	private ItemStack[] items = new ItemStack[3];
	private int burnTime;
	private int fuel;
	private int cookTime;
	private int cookTimeTotal;
	private String customName;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public int getSize() {
		return this.items.length;
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
		boolean var3 = var2 != null && var2.a(this.items[var1]) && ItemStack.isSameNBTTags(var2, this.items[var1]);
		this.items[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

		if (var1 == 0 && !var3) {
			this.cookTimeTotal = this.a(var2);
			this.cookTime = 0;
			this.update();
		}

	}

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.furnace";
	}

	public boolean hasCustomName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void a(String var1) {
		this.customName = var1;
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.items = new ItemStack[this.getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if (var5 >= 0 && var5 < this.items.length) {
				this.items[var5] = ItemStack.fromNBT(var4);
			}
		}

		this.burnTime = var1.getShort("BurnTime");
		this.cookTime = var1.getShort("CookTime");
		this.cookTimeTotal = var1.getShort("CookTimeTotal");
		this.fuel = b(this.items[1]);
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.customName = var1.getString("CustomName");
		}

	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		var1.put("BurnTime", (short) this.burnTime);
		var1.put("CookTime", (short) this.cookTime);
		var1.put("CookTimeTotal", (short) this.cookTimeTotal);
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

	public boolean m() {
		return this.burnTime > 0;
	}

	public void doTick() {
		boolean var1 = this.m();
		boolean var2 = false;
		if (this.m()) {
			--this.burnTime;
		}

		if (!this.world.isStatic) {
			if (!this.m() && (this.items[1] == null || this.items[0] == null)) {
				if (!this.m() && this.cookTime > 0) {
					this.cookTime = MathHelper.a(this.cookTime - 2, 0, this.cookTimeTotal);
				}
			} else {
				if (!this.m() && this.o()) {
					this.fuel = this.burnTime = b(this.items[1]);
					if (this.m()) {
						var2 = true;
						if (this.items[1] != null) {
							--this.items[1].amount;
							if (this.items[1].amount == 0) {
								Item var3 = this.items[1].getItem().getCraftingResult();
								this.items[1] = var3 != null ? new ItemStack(var3) : null;
							}
						}
					}
				}

				if (this.m() && this.o()) {
					++this.cookTime;
					if (this.cookTime == this.cookTimeTotal) {
						this.cookTime = 0;
						this.cookTimeTotal = this.a(this.items[0]);
						this.n();
						var2 = true;
					}
				} else {
					this.cookTime = 0;
				}
			}

			if (var1 != this.m()) {
				var2 = true;
				BlockFurnace.a(this.m(), this.world, this.position);
			}
		}

		if (var2) {
			this.update();
		}

	}

	public int a(ItemStack var1) {
		return 200;
	}

	private boolean o() {
		if (this.items[0] == null) {
			return false;
		} else {
			ItemStack var1 = RecipesFurnace.getInstance().a(this.items[0]);
			return var1 == null ? false : (this.items[2] == null ? true : (!this.items[2].a(var1) ? false : (this.items[2].amount < this.getMaxStackSize() && this.items[2].amount < this.items[2].getMaxStackSize() ? true : this.items[2].amount < var1.getMaxStackSize())));
		}
	}

	public void n() {
		if (this.o()) {
			ItemStack var1 = RecipesFurnace.getInstance().a(this.items[0]);
			if (this.items[2] == null) {
				this.items[2] = var1.getCopy();
			} else if (this.items[2].getItem() == var1.getItem()) {
				++this.items[2].amount;
			}

			if (this.items[0].getItem() == Item.getItemOf(Blocks.SPONGE) && this.items[0].getWearout() == 1 && this.items[1] != null && this.items[1].getItem() == Items.BUCKET) {
				this.items[1] = new ItemStack(Items.WATER_BUCKET);
			}

			--this.items[0].amount;
			if (this.items[0].amount <= 0) {
				this.items[0] = null;
			}

		}
	}

	public static int b(ItemStack var0) {
		if (var0 == null) {
			return 0;
		} else {
			Item var1 = var0.getItem();
			if (var1 instanceof ItemBlock && Block.getBlockByItem(var1) != Blocks.AIR) {
				Block var2 = Block.getBlockByItem(var1);
				if (var2 == Blocks.WOODEN_SLAB) {
					return 150;
				}

				if (var2.getMaterial() == Material.WOOD) {
					return 300;
				}

				if (var2 == Blocks.COAL_BLOCK) {
					return 16000;
				}
			}

			return var1 instanceof ItemTool && ((ItemTool) var1).h().equals("WOOD") ? 200 : (var1 instanceof ItemSword && ((ItemSword) var1).h().equals("WOOD") ? 200 : (var1 instanceof ItemHoe && ((ItemHoe) var1).g().equals("WOOD") ? 200 : (var1 == Items.STICK ? 100 : (var1 == Items.COAL ? 1600 : (var1 == Items.LAVA_BUCKET ? 20000 : (var1 == Item.getItemOf(Blocks.SAPLING) ? 100 : (var1 == Items.BLAZE_ROD ? 2400 : 0)))))));
		}
	}

	public static boolean c(ItemStack var0) {
		return b(var0) > 0;
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

	public boolean canSuckItemFromInventory(int slot, ItemStack itemStack) {
		return slot == 2 ? false : (slot != 1 ? true : c(itemStack) || aiu.c_(itemStack));
	}

	public int[] a(BlockFace var1) {
		return var1 == BlockFace.DOWN ? f : (var1 == BlockFace.UP ? a : g);
	}

	public boolean a(int var1, ItemStack var2, BlockFace var3) {
		return this.canSuckItemFromInventory(var1, var2);
	}

	public boolean b(int var1, ItemStack var2, BlockFace var3) {
		if (var3 == BlockFace.DOWN && var1 == 1) {
			Item var4 = var2.getItem();
			if (var4 != Items.WATER_BUCKET && var4 != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	public String getInventoryType() {
		return "minecraft:furnace";
	}

	public Container getContainer(InventoryPlayer var1, EntityHuman var2) {
		return new aiv(var1, this);
	}

	public int getProperty(int property) {
		switch (property) {
			case 0:
				return this.burnTime;
			case 1:
				return this.fuel;
			case 2:
				return this.cookTime;
			case 3:
				return this.cookTimeTotal;
			default:
				return 0;
		}
	}

	public void readClientCustomInput(int var1, int var2) {
	}

	public int getPropertiesCount() {
		return 4;
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

	public int getBurnTime() {
		return burnTime;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setBurnTime(int burnTime) {
		this.burnTime = burnTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

}
