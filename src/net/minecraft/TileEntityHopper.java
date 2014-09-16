package net.minecraft;

import java.util.ArrayList;
import java.util.List;

public class TileEntityHopper extends TileEntityLockable implements IHopper, ITickable {

	private ItemStack[] a = new ItemStack[5];
	private String f;
	private int g = -1;
	private List<EntityHuman> viewers = new ArrayList<EntityHuman>();

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.a = new ItemStack[this.getSize()];
		if (var1.isTagAssignableFrom("CustomName", 8)) {
			this.f = var1.getString("CustomName");
		}

		this.g = var1.getInt("TransferCooldown");

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTCompoundTag var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if (var5 >= 0 && var5 < this.a.length) {
				this.a[var5] = ItemStack.a(var4);
			}
		}

	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.a.length; ++var3) {
			if (this.a[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.a[var3].write(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
		var1.put("TransferCooldown", this.g);
		if (this.hasCustomName()) {
			var1.put("CustomName", this.f);
		}

	}

	public void update() {
		super.update();
	}

	public int getSize() {
		return this.a.length;
	}

	public ItemStack getItem(int var1) {
		return this.a[var1];
	}

	public ItemStack splitStack(int var1, int var2) {
		if (this.a[var1] != null) {
			ItemStack var3;
			if (this.a[var1].amount <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if (this.a[var1].amount == 0) {
					this.a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack splitWithoutUpdate(int var1) {
		if (this.a[var1] != null) {
			ItemStack var2 = this.a[var1];
			this.a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void setItem(int var1, ItemStack var2) {
		this.a[var1] = var2;
		if (var2 != null && var2.amount > this.getMaxStackSize()) {
			var2.amount = this.getMaxStackSize();
		}

	}

	public String getName() {
		return this.hasCustomName() ? this.f : "container.hopper";
	}

	public boolean hasCustomName() {
		return this.f != null && this.f.length() > 0;
	}

	public void a(String var1) {
		this.f = var1;
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

	public void doTick() {
		if (this.world != null && !this.world.isStatic) {
			--this.g;
			if (!this.n()) {
				this.d(0);
				this.m();
			}

		}
	}

	public boolean m() {
		if (this.world != null && !this.world.isStatic) {
			if (!this.n() && BlockHopper.f(this.u())) {
				boolean var1 = false;
				if (!this.p()) {
					var1 = this.r();
				}

				if (!this.q()) {
					var1 = a((IHopper) this) || var1;
				}

				if (var1) {
					this.d(8);
					this.update();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	private boolean p() {
		ItemStack[] var1 = this.a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ItemStack var4 = var1[var3];
			if (var4 != null) {
				return false;
			}
		}

		return true;
	}

	private boolean q() {
		ItemStack[] var1 = this.a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ItemStack var4 = var1[var3];
			if (var4 == null || var4.amount != var4.getMaxStackSize()) {
				return false;
			}
		}

		return true;
	}

	private boolean r() {
		IInventory var1 = this.G();
		if (var1 == null) {
			return false;
		} else {
			BlockFace var2 = BlockHopper.b(this.u()).getOpposite();
			if (this.a(var1, var2)) {
				return false;
			} else {
				for (int var3 = 0; var3 < this.getSize(); ++var3) {
					if (this.getItem(var3) != null) {
						ItemStack var4 = this.getItem(var3).getCopy();
						ItemStack var5 = a(var1, this.splitStack(var3, 1), var2);
						if (var5 == null || var5.amount == 0) {
							var1.update();
							return true;
						}

						this.setItem(var3, var4);
					}
				}

				return false;
			}
		}
	}

	private boolean a(IInventory var1, BlockFace var2) {
		if (var1 instanceof IWorldInventory) {
			IWorldInventory var3 = (IWorldInventory) var1;
			int[] var4 = var3.a(var2);

			for (int var5 = 0; var5 < var4.length; ++var5) {
				ItemStack var6 = var3.getItem(var4[var5]);
				if (var6 == null || var6.amount != var6.getMaxStackSize()) {
					return false;
				}
			}
		} else {
			int var7 = var1.getSize();

			for (int var8 = 0; var8 < var7; ++var8) {
				ItemStack var9 = var1.getItem(var8);
				if (var9 == null || var9.amount != var9.getMaxStackSize()) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean b(IInventory var0, BlockFace var1) {
		if (var0 instanceof IWorldInventory) {
			IWorldInventory var2 = (IWorldInventory) var0;
			int[] var3 = var2.a(var1);

			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var2.getItem(var3[var4]) != null) {
					return false;
				}
			}
		} else {
			int var5 = var0.getSize();

			for (int var6 = 0; var6 < var5; ++var6) {
				if (var0.getItem(var6) != null) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean a(IHopper var0) {
		IInventory var1 = b(var0);
		if (var1 != null) {
			BlockFace var2 = BlockFace.DOWN;
			if (b(var1, var2)) {
				return false;
			}

			if (var1 instanceof IWorldInventory) {
				IWorldInventory var3 = (IWorldInventory) var1;
				int[] var4 = var3.a(var2);

				for (int var5 = 0; var5 < var4.length; ++var5) {
					if (a(var0, var1, var4[var5], var2)) {
						return true;
					}
				}
			} else {
				int var7 = var1.getSize();

				for (int var8 = 0; var8 < var7; ++var8) {
					if (a(var0, var1, var8, var2)) {
						return true;
					}
				}
			}
		} else {
			EntityItem var6 = a(var0.getPrimaryWorld(), var0.A(), var0.B() + 1.0D, var0.C());
			if (var6 != null) {
				return a((IInventory) var0, var6);
			}
		}

		return false;
	}

	private static boolean a(IHopper var0, IInventory var1, int var2, BlockFace var3) {
		ItemStack var4 = var1.getItem(var2);
		if (var4 != null && b(var1, var4, var2, var3)) {
			ItemStack var5 = var4.getCopy();
			ItemStack var6 = a(var0, var1.splitStack(var2, 1), (BlockFace) null);
			if (var6 == null || var6.amount == 0) {
				var1.update();
				return true;
			}

			var1.setItem(var2, var5);
		}

		return false;
	}

	public static boolean a(IInventory var0, EntityItem var1) {
		boolean var2 = false;
		if (var1 == null) {
			return false;
		} else {
			ItemStack var3 = var1.l().getCopy();
			ItemStack var4 = a(var0, var3, (BlockFace) null);
			if (var4 != null && var4.amount != 0) {
				var1.a(var4);
			} else {
				var2 = true;
				var1.die();
			}

			return var2;
		}
	}

	public static ItemStack a(IInventory var0, ItemStack var1, BlockFace var2) {
		if (var0 instanceof IWorldInventory && var2 != null) {
			IWorldInventory var6 = (IWorldInventory) var0;
			int[] var7 = var6.a(var2);

			for (int var5 = 0; var5 < var7.length && var1 != null && var1.amount > 0; ++var5) {
				var1 = tryTakeInItemFromSlot(var0, var1, var7[var5], var2);
			}
		} else {
			int var3 = var0.getSize();

			for (int var4 = 0; var4 < var3 && var1 != null && var1.amount > 0; ++var4) {
				var1 = tryTakeInItemFromSlot(var0, var1, var4, var2);
			}
		}

		if (var1 != null && var1.amount == 0) {
			var1 = null;
		}

		return var1;
	}

	private static boolean canTakeItemFromInventory(IInventory var0, ItemStack var1, int var2, BlockFace var3) {
		return !var0.canSuckItemFromInventory(var2, var1) ? false : !(var0 instanceof IWorldInventory) || ((IWorldInventory) var0).a(var2, var1, var3);
	}

	private static boolean b(IInventory var0, ItemStack var1, int var2, BlockFace var3) {
		return !(var0 instanceof IWorldInventory) || ((IWorldInventory) var0).b(var2, var1, var3);
	}

	private static ItemStack tryTakeInItemFromSlot(IInventory var0, ItemStack var1, int var2, BlockFace var3) {
		ItemStack var4 = var0.getItem(var2);
		if (canTakeItemFromInventory(var0, var1, var2, var3)) {
			boolean var5 = false;
			if (var4 == null) {
				var0.setItem(var2, var1);
				var1 = null;
				var5 = true;
			} else if (a(var4, var1)) {
				int var6 = var1.getMaxStackSize() - var4.amount;
				int var7 = Math.min(var1.amount, var6);
				var1.amount -= var7;
				var4.amount += var7;
				var5 = var7 > 0;
			}

			if (var5) {
				if (var0 instanceof TileEntityHopper) {
					TileEntityHopper var8 = (TileEntityHopper) var0;
					if (var8.o()) {
						var8.d(8);
					}

					var0.update();
				}

				var0.update();
			}
		}

		return var1;
	}

	private IInventory G() {
		BlockFace var1 = BlockHopper.b(this.u());
		return b(this.getPrimaryWorld(), (double) (this.position.getX() + var1.g()), (double) (this.position.getY() + var1.h()), (double) (this.position.getZ() + var1.i()));
	}

	public static IInventory b(IHopper var0) {
		return b(var0.getPrimaryWorld(), var0.A(), var0.B() + 1.0D, var0.C());
	}

	public static EntityItem a(World var0, double var1, double var3, double var5) {
		List var7 = var0.a(EntityItem.class, new AxisAlignedBB(var1, var3, var5, var1 + 1.0D, var3 + 1.0D, var5 + 1.0D), EntityPredicates.a);
		return var7.size() > 0 ? (EntityItem) var7.get(0) : null;
	}

	public static IInventory b(World var0, double var1, double var3, double var5) {
		Object var7 = null;
		int var8 = MathHelper.toFixedPointInt(var1);
		int var9 = MathHelper.toFixedPointInt(var3);
		int var10 = MathHelper.toFixedPointInt(var5);
		Position var11 = new Position(var8, var9, var10);
		TileEntity var12 = var0.getTileEntity(new Position(var8, var9, var10));
		if (var12 instanceof IInventory) {
			var7 = (IInventory) var12;
			if (var7 instanceof TileEntityChest) {
				Block var13 = var0.getBlockState(new Position(var8, var9, var10)).getBlock();
				if (var13 instanceof BlockChest) {
					var7 = ((BlockChest) var13).d(var0, var11);
				}
			}
		}

		if (var7 == null) {
			List var14 = var0.getEntities((Entity) null, new AxisAlignedBB(var1, var3, var5, var1 + 1.0D, var3 + 1.0D, var5 + 1.0D), EntityPredicates.c);
			if (var14.size() > 0) {
				var7 = (IInventory) var14.get(var0.s.nextInt(var14.size()));
			}
		}

		return (IInventory) var7;
	}

	private static boolean a(ItemStack var0, ItemStack var1) {
		return var0.getItem() != var1.getItem() ? false : (var0.getWearout() != var1.getWearout() ? false : (var0.amount > var0.getMaxStackSize() ? false : ItemStack.a(var0, var1)));
	}

	public double A() {
		return (double) this.position.getX();
	}

	public double B() {
		return (double) this.position.getY();
	}

	public double C() {
		return (double) this.position.getZ();
	}

	public void d(int var1) {
		this.g = var1;
	}

	public boolean n() {
		return this.g > 0;
	}

	public boolean o() {
		return this.g <= 1;
	}

	public String getInventoryType() {
		return "minecraft:hopper";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aix(var1, this, var2);
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
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}

	}

	@Override
	public List<EntityHuman> getViewers() {
		return viewers;
	}

}
