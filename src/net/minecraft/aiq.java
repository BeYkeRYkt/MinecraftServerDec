package net.minecraft;

import java.util.List;
import java.util.Random;

public class aiq extends Container {

	public IInventory a = new air(this, "Enchant", true, 2);
	private World i;
	private Position j;
	private Random k = new Random();
	public int f;
	public int[] g = new int[3];
	public int[] h = new int[] { -1, -1, -1 };

	public aiq(PlayerInventory var1, World var2, Position var3) {
		this.i = var2;
		this.j = var3;
		this.f = var1.d.ci();
		this.addSlot((Slot) (new ais(this, this.a, 0, 15, 47)));
		this.addSlot((Slot) (new ait(this, this.a, 1, 35, 47)));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.addSlot(new Slot(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.addSlot(new Slot(var1, var4, 8 + var4 * 18, 142));
		}

	}

	public void addSlotListener(ICrafting var1) {
		super.addSlotListener(var1);
		var1.setContainerData(this, 0, this.g[0]);
		var1.setContainerData(this, 1, this.g[1]);
		var1.setContainerData(this, 2, this.g[2]);
		var1.setContainerData(this, 3, this.f & -16);
		var1.setContainerData(this, 4, this.h[0]);
		var1.setContainerData(this, 5, this.h[1]);
		var1.setContainerData(this, 6, this.h[2]);
	}

	public void b() {
		super.b();

		for (int var1 = 0; var1 < this.listeners.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.listeners.get(var1);
			var2.setContainerData(this, 0, this.g[0]);
			var2.setContainerData(this, 1, this.g[1]);
			var2.setContainerData(this, 2, this.g[2]);
			var2.setContainerData(this, 3, this.f & -16);
			var2.setContainerData(this, 4, this.h[0]);
			var2.setContainerData(this, 5, this.h[1]);
			var2.setContainerData(this, 6, this.h[2]);
		}

	}

	public void a(IInventory var1) {
		if (var1 == this.a) {
			ItemStack var2 = var1.getItem(0);
			int var3;
			if (var2 != null && var2.v()) {
				if (!this.i.isStatic) {
					var3 = 0;

					int var4;
					for (var4 = -1; var4 <= 1; ++var4) {
						for (int var5 = -1; var5 <= 1; ++var5) {
							if ((var4 != 0 || var5 != 0) && this.i.d(this.j.a(var5, 0, var4)) && this.i.d(this.j.a(var5, 1, var4))) {
								if (this.i.getBlockState(this.j.a(var5 * 2, 0, var4 * 2)).getBlock() == Blocks.BOOKSHELF) {
									++var3;
								}

								if (this.i.getBlockState(this.j.a(var5 * 2, 1, var4 * 2)).getBlock() == Blocks.BOOKSHELF) {
									++var3;
								}

								if (var5 != 0 && var4 != 0) {
									if (this.i.getBlockState(this.j.a(var5 * 2, 0, var4)).getBlock() == Blocks.BOOKSHELF) {
										++var3;
									}

									if (this.i.getBlockState(this.j.a(var5 * 2, 1, var4)).getBlock() == Blocks.BOOKSHELF) {
										++var3;
									}

									if (this.i.getBlockState(this.j.a(var5, 0, var4 * 2)).getBlock() == Blocks.BOOKSHELF) {
										++var3;
									}

									if (this.i.getBlockState(this.j.a(var5, 1, var4 * 2)).getBlock() == Blocks.BOOKSHELF) {
										++var3;
									}
								}
							}
						}
					}

					this.k.setSeed((long) this.f);

					for (var4 = 0; var4 < 3; ++var4) {
						this.g[var4] = aph.a(this.k, var4, var3, var2);
						this.h[var4] = -1;
						if (this.g[var4] < var4 + 1) {
							this.g[var4] = 0;
						}
					}

					for (var4 = 0; var4 < 3; ++var4) {
						if (this.g[var4] > 0) {
							List var7 = this.a(var2, var4, this.g[var4]);
							if (var7 != null && !var7.isEmpty()) {
								apo var6 = (apo) var7.get(this.k.nextInt(var7.size()));
								this.h[var4] = var6.b.id | var6.c << 8;
							}
						}
					}

					this.b();
				}
			} else {
				for (var3 = 0; var3 < 3; ++var3) {
					this.g[var3] = 0;
					this.h[var3] = -1;
				}
			}
		}

	}

	public boolean a(EntityHuman var1, int var2) {
		ItemStack var3 = this.a.getItem(0);
		ItemStack var4 = this.a.getItem(1);
		int var5 = var2 + 1;
		if ((var4 == null || var4.amount < var5) && !var1.playerProperties.instabuild) {
			return false;
		} else if (this.g[var2] > 0 && var3 != null && (var1.xpLevel >= var5 && var1.xpLevel >= this.g[var2] || var1.playerProperties.instabuild)) {
			if (!this.i.isStatic) {
				List var6 = this.a(var3, var2, this.g[var2]);
				boolean var7 = var3.getItem() == Items.BOOK;
				if (var6 != null) {
					var1.b(var5);
					if (var7) {
						var3.setItem((Item) Items.ENCHANTED_BOOK);
					}

					for (int var8 = 0; var8 < var6.size(); ++var8) {
						apo var9 = (apo) var6.get(var8);
						if (var7) {
							Items.ENCHANTED_BOOK.a(var3, var9);
						} else {
							var3.a(var9.b, var9.c);
						}
					}

					if (!var1.playerProperties.instabuild) {
						var4.amount -= var5;
						if (var4.amount <= 0) {
							this.a.setItem(1, (ItemStack) null);
						}
					}

					this.a.update();
					this.f = var1.ci();
					this.a(this.a);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	private List a(ItemStack var1, int var2, int var3) {
		this.k.setSeed((long) (this.f + var2));
		List var4 = aph.b(this.k, var1, var3);
		if (var1.getItem() == Items.BOOK && var4 != null && var4.size() > 1) {
			var4.remove(this.k.nextInt(var4.size()));
		}

		return var4;
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);
		if (!this.i.isStatic) {
			for (int var2 = 0; var2 < this.a.getSize(); ++var2) {
				ItemStack var3 = this.a.splitWithoutUpdate(var2);
				if (var3 != null) {
					var1.dropItem(var3, false);
				}
			}

		}
	}

	public boolean a(EntityHuman var1) {
		return this.i.getBlockState(this.j).getBlock() != Blocks.ENCHANTING_TABLE ? false : var1.getDistanceSquared((double) this.j.getX() + 0.5D, (double) this.j.getY() + 0.5D, (double) this.j.getZ() + 0.5D) <= 64.0D;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 == 0) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if (var2 == 1) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if (var5.getItem() == Items.DYE && akv.a(var5.getWearout()) == akv.l) {
				if (!this.a(var5, 1, 2, true)) {
					return null;
				}
			} else {
				if (((Slot) this.slots.get(0)).hasItem() || !((Slot) this.slots.get(0)).a(var5)) {
					return null;
				}

				if (var5.hasTag() && var5.amount == 1) {
					((Slot) this.slots.get(0)).d(var5.getCopy());
					var5.amount = 0;
				} else if (var5.amount >= 1) {
					((Slot) this.slots.get(0)).d(new ItemStack(var5.getItem(), 1, var5.getWearout()));
					--var5.amount;
				}
			}

			if (var5.amount == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.update();
			}

			if (var5.amount == var3.amount) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}
}
