package net.minecraft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TileEntityChest extends TileEntityLockable implements ITickable, IInventory {

	private ItemStack[] m = new ItemStack[27];
	public boolean a;
	public TileEntityChest f;
	public TileEntityChest g;
	public TileEntityChest h;
	public TileEntityChest i;
	public float j;
	public float k;
	public int viewersNumber;
	private int n;
	private int o = -1;
	private String p;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public int getSize() {
		return 27;
	}

	public ItemStack getItem(int var1) {
		return this.m[var1];
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.m[var1] != null) {
			ItemStack var3;
			if (this.m[var1].amount <= var2) {
				var3 = this.m[var1];
				this.m[var1] = null;
				this.update();
				return var3;
			} else {
				var3 = this.m[var1].a(var2);
				if (this.m[var1].amount == 0) {
					this.m[var1] = null;
				}

				this.update();
				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.m[var1] != null) {
			ItemStack var2 = this.m[var1];
			this.m[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.m[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

		this.update();
	}

	public String getName() {
		return this.hasCustomName() ? this.p : "container.chest";
	}

	public boolean hasCustomName() {
		return this.p != null && this.p.length() > 0;
	}

	public void a(String var1) {
		this.p = var1;
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.m = new ItemStack[this.getSize()];
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.p = var1.getString("CustomName");
		}

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if (var5 >= 0 && var5 < this.m.length) {
				this.m[var5] = ItemStack.a(var4);
			}
		}

	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.m.length; ++var3) {
			if (this.m[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.m[var3].write(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
		if (this.hasCustomName()) {
			var1.put("CustomName", this.p);
		}

	}

	public int getMaxStackSize() {
		return 64;
	}

	public boolean canInteract(EntityHuman var1) {
		return this.world.getTileEntity(this.position) != this ? false : var1.getDistanceSquared((double) this.position.getX() + 0.5D, (double) this.position.getY() + 0.5D, (double) this.position.getZ() + 0.5D) <= 64.0D;
	}

	public void E() {
		super.E();
		this.a = false;
	}

	private void a(TileEntityChest var1, BlockFace var2) {
		if (var1.x()) {
			this.a = false;
		} else if (this.a) {
			switch (bcs.a[var2.ordinal()]) {
				case 1:
					if (this.f != var1) {
						this.a = false;
					}
					break;
				case 2:
					if (this.i != var1) {
						this.a = false;
					}
					break;
				case 3:
					if (this.g != var1) {
						this.a = false;
					}
					break;
				case 4:
					if (this.h != var1) {
						this.a = false;
					}
			}
		}

	}

	public void m() {
		if (!this.a) {
			this.a = true;
			this.h = this.a(BlockFace.WEST);
			this.g = this.a(BlockFace.EAST);
			this.f = this.a(BlockFace.NORTH);
			this.i = this.a(BlockFace.SOUTH);
		}
	}

	protected TileEntityChest a(BlockFace var1) {
		Position var2 = this.position.a(var1);
		if (this.b(var2)) {
			TileEntity var3 = this.world.getTileEntity(var2);
			if (var3 instanceof TileEntityChest) {
				TileEntityChest var4 = (TileEntityChest) var3;
				var4.a(this, var1.getOpposite());
				return var4;
			}
		}

		return null;
	}

	private boolean b(Position var1) {
		if (this.world == null) {
			return false;
		} else {
			Block var2 = this.world.getBlockState(var1).getBlock();
			return var2 instanceof BlockChest && ((BlockChest) var2).b == this.n();
		}
	}

	public void doTick() {
		this.m();
		int var1 = this.position.getX();
		int var2 = this.position.getY();
		int var3 = this.position.getZ();
		++this.n;
		float var4;
		if (!this.world.isStatic && this.viewersNumber != 0 && (this.n + var1 + var2 + var3) % 200 == 0) {
			this.viewersNumber = 0;
			var4 = 5.0F;
			List var5 = this.world.a(EntityHuman.class, new AxisAlignedBB((double) ((float) var1 - var4), (double) ((float) var2 - var4), (double) ((float) var3 - var4), (double) ((float) (var1 + 1) + var4), (double) ((float) (var2 + 1) + var4), (double) ((float) (var3 + 1) + var4)));
			Iterator var6 = var5.iterator();

			while (var6.hasNext()) {
				EntityHuman var7 = (EntityHuman) var6.next();
				if (var7.activeContainer instanceof ContainerChest) {
					IInventory var8 = ((ContainerChest) var7.activeContainer).e();
					if (var8 == this || var8 instanceof InventoryLargeChest && ((InventoryLargeChest) var8).a((IInventory) this)) {
						++this.viewersNumber;
					}
				}
			}
		}

		this.k = this.j;
		var4 = 0.1F;
		double var14;
		if (this.viewersNumber > 0 && this.j == 0.0F && this.f == null && this.h == null) {
			double var11 = (double) var1 + 0.5D;
			var14 = (double) var3 + 0.5D;
			if (this.i != null) {
				var14 += 0.5D;
			}

			if (this.g != null) {
				var11 += 0.5D;
			}

			this.world.makeSound(var11, (double) var2 + 0.5D, var14, "random.chestopen", 0.5F, this.world.s.nextFloat() * 0.1F + 0.9F);
		}

		if (this.viewersNumber == 0 && this.j > 0.0F || this.viewersNumber > 0 && this.j < 1.0F) {
			float var12 = this.j;
			if (this.viewersNumber > 0) {
				this.j += var4;
			} else {
				this.j -= var4;
			}

			if (this.j > 1.0F) {
				this.j = 1.0F;
			}

			float var13 = 0.5F;
			if (this.j < var13 && var12 >= var13 && this.f == null && this.h == null) {
				var14 = (double) var1 + 0.5D;
				double var9 = (double) var3 + 0.5D;
				if (this.i != null) {
					var9 += 0.5D;
				}

				if (this.g != null) {
					var14 += 0.5D;
				}

				this.world.makeSound(var14, (double) var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.world.s.nextFloat() * 0.1F + 0.9F);
			}

			if (this.j < 0.0F) {
				this.j = 0.0F;
			}
		}

	}

	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			this.viewersNumber = var2;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	public void onContainerOpen(EntityHuman who) {
		if (!who.isSpectator()) {
			if (this.viewersNumber < 0) {
				this.viewersNumber = 0;
			}

			++this.viewersNumber;
			this.world.c(this.position, this.getBlock(), 1, this.viewersNumber);
			this.world.c(this.position, this.getBlock());
			this.world.c(this.position.b(), this.getBlock());
		}
		viewers.add(who);
	}

	public void onContainerClose(EntityHuman who) {
		if (!who.isSpectator() && this.getBlock() instanceof BlockChest) {
			--this.viewersNumber;
			this.world.c(this.position, this.getBlock(), 1, this.viewersNumber);
			this.world.c(this.position, this.getBlock());
			this.world.c(this.position.b(), this.getBlock());
		}
		viewers.remove(who);
	}

	public boolean canSuckItemFromInventory(int var1, ItemStack var2) {
		return true;
	}

	public void y() {
		super.y();
		this.E();
		this.m();
	}

	public int n() {
		if (this.o == -1) {
			if (this.world == null || !(this.getBlock() instanceof BlockChest)) {
				return 0;
			}

			this.o = ((BlockChest) this.getBlock()).b;
		}

		return this.o;
	}

	public String getInventoryType() {
		return "minecraft:chest";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new ContainerChest(var1, this, var2);
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
		for (int var1 = 0; var1 < this.m.length; ++var1) {
			this.m[var1] = null;
		}

	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

}
