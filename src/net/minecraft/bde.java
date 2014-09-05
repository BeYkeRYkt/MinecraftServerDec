package net.minecraft;

import java.util.List;

public class bde extends bdf implements bdd, pm {

	private ItemStack[] a = new ItemStack[5];
	private String f;
	private int g = -1;

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.getList("Items", 10);
		this.a = new ItemStack[this.n_()];
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

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.a.length; ++var3) {
			if (this.a[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.put("Slot", (byte) var3);
				this.a[var3].b(var4);
				var2.addTag((NBTTag) var4);
			}
		}

		var1.put("Items", (NBTTag) var2);
		var1.put("TransferCooldown", this.g);
		if (this.k_()) {
			var1.put("CustomName", this.f);
		}

	}

	public void o_() {
		super.o_();
	}

	public int n_() {
		return this.a.length;
	}

	public ItemStack a(int var1) {
		return this.a[var1];
	}

	public ItemStack a(int var1, int var2) {
		if (this.a[var1] != null) {
			ItemStack var3;
			if (this.a[var1].b <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if (this.a[var1].b == 0) {
					this.a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack b(int var1) {
		if (this.a[var1] != null) {
			ItemStack var2 = this.a[var1];
			this.a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.a[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

	}

	public String d_() {
		return this.k_() ? this.f : "container.hopper";
	}

	public boolean k_() {
		return this.f != null && this.f.length() > 0;
	}

	public void a(String var1) {
		this.f = var1;
	}

	public int p_() {
		return 64;
	}

	public boolean a(EntityHuman var1) {
		return this.b.s(this.c) != this ? false : var1.e((double) this.c.n() + 0.5D, (double) this.c.o() + 0.5D, (double) this.c.p() + 0.5D) <= 64.0D;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public void c() {
		if (this.b != null && !this.b.D) {
			--this.g;
			if (!this.n()) {
				this.d(0);
				this.m();
			}

		}
	}

	public boolean m() {
		if (this.b != null && !this.b.D) {
			if (!this.n() && BlockHopper.f(this.u())) {
				boolean var1 = false;
				if (!this.p()) {
					var1 = this.r();
				}

				if (!this.q()) {
					var1 = a((bdd) this) || var1;
				}

				if (var1) {
					this.d(8);
					this.o_();
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
			if (var4 == null || var4.b != var4.c()) {
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
			PaintingDirection var2 = BlockHopper.b(this.u()).d();
			if (this.a(var1, var2)) {
				return false;
			} else {
				for (int var3 = 0; var3 < this.n_(); ++var3) {
					if (this.a(var3) != null) {
						ItemStack var4 = this.a(var3).getCopy();
						ItemStack var5 = a(var1, this.a(var3, 1), var2);
						if (var5 == null || var5.b == 0) {
							var1.o_();
							return true;
						}

						this.a(var3, var4);
					}
				}

				return false;
			}
		}
	}

	private boolean a(IInventory var1, PaintingDirection var2) {
		if (var1 instanceof we) {
			we var3 = (we) var1;
			int[] var4 = var3.a(var2);

			for (int var5 = 0; var5 < var4.length; ++var5) {
				ItemStack var6 = var3.a(var4[var5]);
				if (var6 == null || var6.b != var6.c()) {
					return false;
				}
			}
		} else {
			int var7 = var1.n_();

			for (int var8 = 0; var8 < var7; ++var8) {
				ItemStack var9 = var1.a(var8);
				if (var9 == null || var9.b != var9.c()) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean b(IInventory var0, PaintingDirection var1) {
		if (var0 instanceof we) {
			we var2 = (we) var0;
			int[] var3 = var2.a(var1);

			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var2.a(var3[var4]) != null) {
					return false;
				}
			}
		} else {
			int var5 = var0.n_();

			for (int var6 = 0; var6 < var5; ++var6) {
				if (var0.a(var6) != null) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean a(bdd var0) {
		IInventory var1 = b(var0);
		if (var1 != null) {
			PaintingDirection var2 = PaintingDirection.a;
			if (b(var1, var2)) {
				return false;
			}

			if (var1 instanceof we) {
				we var3 = (we) var1;
				int[] var4 = var3.a(var2);

				for (int var5 = 0; var5 < var4.length; ++var5) {
					if (a(var0, var1, var4[var5], var2)) {
						return true;
					}
				}
			} else {
				int var7 = var1.n_();

				for (int var8 = 0; var8 < var7; ++var8) {
					if (a(var0, var1, var8, var2)) {
						return true;
					}
				}
			}
		} else {
			EntityItem var6 = a(var0.z(), var0.A(), var0.B() + 1.0D, var0.C());
			if (var6 != null) {
				return a((IInventory) var0, var6);
			}
		}

		return false;
	}

	private static boolean a(bdd var0, IInventory var1, int var2, PaintingDirection var3) {
		ItemStack var4 = var1.a(var2);
		if (var4 != null && b(var1, var4, var2, var3)) {
			ItemStack var5 = var4.getCopy();
			ItemStack var6 = a(var0, var1.a(var2, 1), (PaintingDirection) null);
			if (var6 == null || var6.b == 0) {
				var1.o_();
				return true;
			}

			var1.a(var2, var5);
		}

		return false;
	}

	public static boolean a(IInventory var0, EntityItem var1) {
		boolean var2 = false;
		if (var1 == null) {
			return false;
		} else {
			ItemStack var3 = var1.l().getCopy();
			ItemStack var4 = a(var0, var3, (PaintingDirection) null);
			if (var4 != null && var4.b != 0) {
				var1.a(var4);
			} else {
				var2 = true;
				var1.J();
			}

			return var2;
		}
	}

	public static ItemStack a(IInventory var0, ItemStack var1, PaintingDirection var2) {
		if (var0 instanceof we && var2 != null) {
			we var6 = (we) var0;
			int[] var7 = var6.a(var2);

			for (int var5 = 0; var5 < var7.length && var1 != null && var1.b > 0; ++var5) {
				var1 = c(var0, var1, var7[var5], var2);
			}
		} else {
			int var3 = var0.n_();

			for (int var4 = 0; var4 < var3 && var1 != null && var1.b > 0; ++var4) {
				var1 = c(var0, var1, var4, var2);
			}
		}

		if (var1 != null && var1.b == 0) {
			var1 = null;
		}

		return var1;
	}

	private static boolean a(IInventory var0, ItemStack var1, int var2, PaintingDirection var3) {
		return !var0.b(var2, var1) ? false : !(var0 instanceof we) || ((we) var0).a(var2, var1, var3);
	}

	private static boolean b(IInventory var0, ItemStack var1, int var2, PaintingDirection var3) {
		return !(var0 instanceof we) || ((we) var0).b(var2, var1, var3);
	}

	private static ItemStack c(IInventory var0, ItemStack var1, int var2, PaintingDirection var3) {
		ItemStack var4 = var0.a(var2);
		if (a(var0, var1, var2, var3)) {
			boolean var5 = false;
			if (var4 == null) {
				var0.a(var2, var1);
				var1 = null;
				var5 = true;
			} else if (a(var4, var1)) {
				int var6 = var1.c() - var4.b;
				int var7 = Math.min(var1.b, var6);
				var1.b -= var7;
				var4.b += var7;
				var5 = var7 > 0;
			}

			if (var5) {
				if (var0 instanceof bde) {
					bde var8 = (bde) var0;
					if (var8.o()) {
						var8.d(8);
					}

					var0.o_();
				}

				var0.o_();
			}
		}

		return var1;
	}

	private IInventory G() {
		PaintingDirection var1 = BlockHopper.b(this.u());
		return b(this.z(), (double) (this.c.n() + var1.g()), (double) (this.c.o() + var1.h()), (double) (this.c.p() + var1.i()));
	}

	public static IInventory b(bdd var0) {
		return b(var0.z(), var0.A(), var0.B() + 1.0D, var0.C());
	}

	public static EntityItem a(World var0, double var1, double var3, double var5) {
		List var7 = var0.a(EntityItem.class, new brt(var1, var3, var5, var1 + 1.0D, var3 + 1.0D, var5 + 1.0D), EntityPredicates.a);
		return var7.size() > 0 ? (EntityItem) var7.get(0) : null;
	}

	public static IInventory b(World var0, double var1, double var3, double var5) {
		Object var7 = null;
		int var8 = DataTypesConverter.toFixedPointInt(var1);
		int var9 = DataTypesConverter.toFixedPointInt(var3);
		int var10 = DataTypesConverter.toFixedPointInt(var5);
		Position var11 = new Position(var8, var9, var10);
		bcm var12 = var0.s(new Position(var8, var9, var10));
		if (var12 instanceof IInventory) {
			var7 = (IInventory) var12;
			if (var7 instanceof bcr) {
				Block var13 = var0.p(new Position(var8, var9, var10)).c();
				if (var13 instanceof BlockChest) {
					var7 = ((BlockChest) var13).d(var0, var11);
				}
			}
		}

		if (var7 == null) {
			List var14 = var0.a((Entity) null, new brt(var1, var3, var5, var1 + 1.0D, var3 + 1.0D, var5 + 1.0D), EntityPredicates.c);
			if (var14.size() > 0) {
				var7 = (IInventory) var14.get(var0.s.nextInt(var14.size()));
			}
		}

		return (IInventory) var7;
	}

	private static boolean a(ItemStack var0, ItemStack var1) {
		return var0.getItem() != var1.getItem() ? false : (var0.i() != var1.i() ? false : (var0.b > var0.c() ? false : ItemStack.a(var0, var1)));
	}

	public double A() {
		return (double) this.c.n();
	}

	public double B() {
		return (double) this.c.o();
	}

	public double C() {
		return (double) this.c.p();
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

	public String k() {
		return "minecraft:hopper";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aix(var1, this, var2);
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public void l() {
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}

	}
}
