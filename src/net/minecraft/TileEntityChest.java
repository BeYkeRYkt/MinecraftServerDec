package net.minecraft;

import java.util.ArrayList;
import java.util.List;

public class TileEntityChest extends TileEntityLockable implements IInventory {

	private ItemStack[] items = new ItemStack[27];
	public boolean doubleChestChecked;
	public TileEntityChest northChest;
	public TileEntityChest eastChest;
	public TileEntityChest westChest;
	public TileEntityChest southChest;
	private int moajangCodeViewersCount;
	private int chestType = -1;
	private String customName;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public int getSize() {
		return 27;
	}

	public ItemStack getItem(int slot) {
		return this.items[slot];
	}

	public ItemStack splitStack(int slot, int splitSize) {
		if (this.items[slot] != null) {
			ItemStack itemStack;
			if (this.items[slot].amount <= splitSize) {
				itemStack = this.items[slot];
				this.items[slot] = null;
				this.update();
				return itemStack;
			} else {
				itemStack = this.items[slot].a(splitSize);
				if (this.items[slot].amount == 0) {
					this.items[slot] = null;
				}
				this.update();
				return itemStack;
			}
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int slot) {
		if (this.items[slot] != null) {
			ItemStack itemStack = this.items[slot];
			this.items[slot] = null;
			return itemStack;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.items[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

		this.update();
	}

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.chest";
	}

	public boolean hasCustomName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		NBTListTag itemsTag = tag.getList("Items", 10);
		this.items = new ItemStack[this.getSize()];
		if (tag.isTagAssignableFrom("CustomName", 8)) {
			this.customName = tag.getString("CustomName");
		}

		for (int slot = 0; slot < itemsTag.getSize(); ++slot) {
			NBTCompoundTag slotTag = itemsTag.getCompound(slot);
			int i = slotTag.getByte("Slot") & 255;
			if (i >= 0 && i < this.items.length) {
				this.items[i] = ItemStack.fromNBT(slotTag);
			}
		}

	}

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		NBTListTag itemsTag = new NBTListTag();

		for (int slot = 0; slot < this.items.length; ++slot) {
			if (this.items[slot] != null) {
				NBTCompoundTag slotTag = new NBTCompoundTag();
				slotTag.put("Slot", (byte) slot);
				this.items[slot].write(slotTag);
				itemsTag.addTag(slotTag);
			}
		}

		tag.put("Items", (NBTTag) itemsTag);
		if (this.hasCustomName()) {
			tag.put("CustomName", this.customName);
		}

	}

	public int getMaxStackSize() {
		return 64;
	}

	public boolean canInteract(EntityHuman who) {
		return this.world.getTileEntity(this.position) != this ? false : who.getDistanceSquared(this.position.getX() + 0.5D, this.position.getY() + 0.5D, this.position.getZ() + 0.5D) <= 64.0D;
	}

	public void removeBlockData() {
		super.removeBlockData();
		this.doubleChestChecked = false;
	}

	private void validateConnectedChest(TileEntityChest teChest, BlockFace face) {
		if (teChest.isInvalid()) {
			this.doubleChestChecked = false;
		} else if (this.doubleChestChecked) {
			switch (face) {
				case NORTH: {
					if (this.northChest != teChest) {
						this.doubleChestChecked = false;
					}
					break;
				}
				case SOUTH: {
					if (this.southChest != teChest) {
						this.doubleChestChecked = false;
					}
					break;
				}
				case EAST: {
					if (this.eastChest != teChest) {
						this.doubleChestChecked = false;
					}
					break;
				}
				case WEST: {
					if (this.westChest != teChest) {
						this.doubleChestChecked = false;
					}
					break;
				}
				default: {
					break;
				}
			}
		}

	}

	public void checkDoubleChest() {
		if (!this.doubleChestChecked) {
			this.doubleChestChecked = true;
			this.westChest = this.getConnectedChest(BlockFace.WEST);
			this.eastChest = this.getConnectedChest(BlockFace.EAST);
			this.northChest = this.getConnectedChest(BlockFace.NORTH);
			this.southChest = this.getConnectedChest(BlockFace.SOUTH);
		}
	}

	protected TileEntityChest getConnectedChest(BlockFace face) {
		Position connectedChestPosition = this.position.getRelative(face);
		if (this.isChestWithSameType(connectedChestPosition)) {
			TileEntity tileEntity = this.world.getTileEntity(connectedChestPosition);
			if (tileEntity instanceof TileEntityChest) {
				TileEntityChest connectedTEChest = (TileEntityChest) tileEntity;
				connectedTEChest.validateConnectedChest(this, face.getOpposite());
				return connectedTEChest;
			}
		}

		return null;
	}

	private boolean isChestWithSameType(Position position) {
		if (this.world == null) {
			return false;
		} else {
			Block block = this.world.getBlockState(position).getBlock();
			return block instanceof BlockChest && ((BlockChest) block).chestType == this.getChestType();
		}
	}

	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			moajangCodeViewersCount = var2;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	public void onContainerOpen(EntityHuman who) {
		if (!who.isSpectator()) {
			viewers.add(who);
			this.world.c(this.position, this.getBlock(), 1, viewers.size());
			this.world.c(this.position, this.getBlock());
			this.world.c(this.position.b(), this.getBlock());
			if (viewers.size() == 1 && northChest == null && westChest == null) {
				double chestCenterX = position.getX() + 0.5D;
				double chestCenterZ = position.getZ() + 0.5D;

				if (southChest != null) {
					chestCenterZ += 0.5D;
				}

				if (eastChest != null) {
					chestCenterX += 0.5D;
				}

				world.makeSound(chestCenterX, position.getY() + 0.5D, chestCenterZ, "random.chestopen", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
			}
		}
	}

	public void onContainerClose(EntityHuman who) {
		if (!who.isSpectator() && getBlock() instanceof BlockChest) {
			if (moajangCodeViewersCount < 0) {
				moajangCodeViewersCount = 0;
			} 
			viewers.remove(who);
			this.world.c(this.position, this.getBlock(), 1, viewers.size());
			this.world.c(this.position, this.getBlock());
			this.world.c(this.position.b(), this.getBlock());
			if (viewers.size() == 0 && northChest == null && westChest == null) {
				double chestCenterX = position.getX() + 0.5D;
				double chestCenterZ = position.getZ() + 0.5D;
				if (this.southChest != null) {
					chestCenterZ += 0.5D;
				}

				if (this.eastChest != null) {
					chestCenterX += 0.5D;
				}

				this.world.makeSound(chestCenterX, position.getY() + 0.5D, chestCenterZ, "random.chestclosed", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
			}
		}
	}

	public boolean canSuckItemFromInventory(int var1, ItemStack var2) {
		return true;
	}

	public void setValid() {
		super.setValid();
		this.removeBlockData();
		this.checkDoubleChest();
	}

	public int getChestType() {
		if (this.chestType == -1) {
			if (this.world == null || !(this.getBlock() instanceof BlockChest)) {
				return 0;
			}

			this.chestType = ((BlockChest) this.getBlock()).chestType;
		}

		return this.chestType;
	}

	public String getInventoryType() {
		return "minecraft:chest";
	}

	public Container getContainer(PlayerInventory playerInventory, EntityHuman human) {
		return new ContainerChest(playerInventory, this, human);
	}

	public int getProperty(int propertyIndex) {
		return 0;
	}

	public void selectBeaconPower(int powerSlot, int powerType) {
	}

	public int getPropertiesCount() {
		return 0;
	}

	public void clearInventory() {
		for (int i = 0; i < this.items.length; ++i) {
			this.items[i] = null;
		}
	}

	public int getAllViewersCount() {
		return viewers.size() + moajangCodeViewersCount;
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
