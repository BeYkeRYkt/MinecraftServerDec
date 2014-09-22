package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pipebukkit.server.inventory.PipeInventory;

public abstract class Container {

	public List<ItemStack> itemStacks = Lists.newArrayList();
	public List<Slot> slots = Lists.newArrayList();
	public int windowId;
	private int f = -1;
	private int g;
	private final Set h = Sets.newHashSet();
	protected List<ICrafting> listeners = Lists.newArrayList();
	private Set<EntityHuman> unConfirmedTransactions = Sets.newHashSet();

	protected Slot addSlot(Slot slot) {
		slot.index = this.slots.size();
		this.slots.add(slot);
		this.itemStacks.add(null);
		return slot;
	}

	public void addSlotListener(ICrafting icrafting) {
		if (this.listeners.contains(icrafting)) {
			throw new IllegalArgumentException("Listener already listening");
		} else {
			this.listeners.add(icrafting);
			icrafting.setContainerData(this, this.getContents());
			this.b();
		}
	}

	public List<ItemStack> getContents() {
		ArrayList<ItemStack> items = Lists.newArrayList();

		for (int i = 0; i < this.slots.size(); ++i) {
			items.add(this.slots.get(i).getItemStack());
		}

		return items;
	}

	public void b() {
		for (int var1 = 0; var1 < this.slots.size(); ++var1) {
			ItemStack var2 = ((Slot) this.slots.get(var1)).getItemStack();
			ItemStack var3 = (ItemStack) this.itemStacks.get(var1);
			if (!ItemStack.matches(var3, var2)) {
				var3 = var2 == null ? null : var2.getCopy();
				this.itemStacks.set(var1, var3);

				for (int var4 = 0; var4 < this.listeners.size(); ++var4) {
					((ICrafting) this.listeners.get(var4)).setContainerData(this, var1, var3);
				}
			}
		}

	}

	public boolean a(EntityHuman var1, int var2) {
		return false;
	}

	public Slot a(IInventory var1, int var2) {
		for (int var3 = 0; var3 < this.slots.size(); ++var3) {
			Slot var4 = (Slot) this.slots.get(var3);
			if (var4.a(var1, var2)) {
				return var4;
			}
		}

		return null;
	}

	public Slot getSlot(int var1) {
		return (Slot) this.slots.get(var1);
	}

	public ItemStack b(EntityHuman var1, int var2) {
		Slot var3 = (Slot) this.slots.get(var2);
		return var3 != null ? var3.getItemStack() : null;
	}

	public ItemStack a(int var1, int var2, int var3, EntityHuman var4) {
		ItemStack var5 = null;
		InventoryPlayer var6 = var4.playerInventory;
		int var9;
		ItemStack var17;
		if (var3 == 5) {
			int var7 = this.g;
			this.g = c(var2);
			if ((var7 != 1 || this.g != 2) && var7 != this.g) {
				this.d();
			} else if (var6.getCarried() == null) {
				this.d();
			} else if (this.g == 0) {
				this.f = b(var2);
				if (a(this.f, var4)) {
					this.g = 1;
					this.h.clear();
				} else {
					this.d();
				}
			} else if (this.g == 1) {
				Slot var8 = (Slot) this.slots.get(var1);
				if (var8 != null && a(var8, var6.getCarried(), true) && var8.a(var6.getCarried()) && var6.getCarried().amount > this.h.size() && this.b(var8)) {
					this.h.add(var8);
				}
			} else if (this.g == 2) {
				if (!this.h.isEmpty()) {
					var17 = var6.getCarried().getCopy();
					var9 = var6.getCarried().amount;
					Iterator var10 = this.h.iterator();

					while (var10.hasNext()) {
						Slot var11 = (Slot) var10.next();
						if (var11 != null && a(var11, var6.getCarried(), true) && var11.a(var6.getCarried()) && var6.getCarried().amount >= this.h.size() && this.b(var11)) {
							ItemStack var12 = var17.getCopy();
							int var13 = var11.hasItem() ? var11.getItemStack().amount : 0;
							a(this.h, this.f, var12, var13);
							if (var12.amount > var12.getMaxStackSize()) {
								var12.amount = var12.getMaxStackSize();
							}

							if (var12.amount > var11.b(var12)) {
								var12.amount = var11.b(var12);
							}

							var9 -= var12.amount - var13;
							var11.d(var12);
						}
					}

					var17.amount = var9;
					if (var17.amount <= 0) {
						var17 = null;
					}

					var6.setCarried(var17);
				}

				this.d();
			} else {
				this.d();
			}
		} else if (this.g != 0) {
			this.d();
		} else {
			Slot var16;
			int var21;
			ItemStack var23;
			if ((var3 == 0 || var3 == 1) && (var2 == 0 || var2 == 1)) {
				if (var1 == -999) {
					if (var6.getCarried() != null) {
						if (var2 == 0) {
							var4.dropItem(var6.getCarried(), true);
							var6.setCarried((ItemStack) null);
						}

						if (var2 == 1) {
							var4.dropItem(var6.getCarried().a(1), true);
							if (var6.getCarried().amount == 0) {
								var6.setCarried((ItemStack) null);
							}
						}
					}
				} else if (var3 == 1) {
					if (var1 < 0) {
						return null;
					}

					var16 = (Slot) this.slots.get(var1);
					if (var16 != null && var16.a(var4)) {
						var17 = this.b(var4, var1);
						if (var17 != null) {
							Item var19 = var17.getItem();
							var5 = var17.getCopy();
							if (var16.getItemStack() != null && var16.getItemStack().getItem() == var19) {
								this.a(var1, var2, true, var4);
							}
						}
					}
				} else {
					if (var1 < 0) {
						return null;
					}

					var16 = (Slot) this.slots.get(var1);
					if (var16 != null) {
						var17 = var16.getItemStack();
						ItemStack var20 = var6.getCarried();
						if (var17 != null) {
							var5 = var17.getCopy();
						}

						if (var17 == null) {
							if (var20 != null && var16.a(var20)) {
								var21 = var2 == 0 ? var20.amount : 1;
								if (var21 > var16.b(var20)) {
									var21 = var16.b(var20);
								}

								if (var20.amount >= var21) {
									var16.d(var20.a(var21));
								}

								if (var20.amount == 0) {
									var6.setCarried((ItemStack) null);
								}
							}
						} else if (var16.a(var4)) {
							if (var20 == null) {
								var21 = var2 == 0 ? var17.amount : (var17.amount + 1) / 2;
								var23 = var16.a(var21);
								var6.setCarried(var23);
								if (var17.amount == 0) {
									var16.d((ItemStack) null);
								}

								var16.a(var4, var6.getCarried());
							} else if (var16.a(var20)) {
								if (var17.getItem() == var20.getItem() && var17.getWearout() == var20.getWearout() && ItemStack.isSameNBTTags(var17, var20)) {
									var21 = var2 == 0 ? var20.amount : 1;
									if (var21 > var16.b(var20) - var17.amount) {
										var21 = var16.b(var20) - var17.amount;
									}

									if (var21 > var20.getMaxStackSize() - var17.amount) {
										var21 = var20.getMaxStackSize() - var17.amount;
									}

									var20.a(var21);
									if (var20.amount == 0) {
										var6.setCarried((ItemStack) null);
									}

									var17.amount += var21;
								} else if (var20.amount <= var16.b(var20)) {
									var16.d(var20);
									var6.setCarried(var17);
								}
							} else if (var17.getItem() == var20.getItem() && var20.getMaxStackSize() > 1 && (!var17.f() || var17.getWearout() == var20.getWearout()) && ItemStack.isSameNBTTags(var17, var20)) {
								var21 = var17.amount;
								if (var21 > 0 && var21 + var20.amount <= var20.getMaxStackSize()) {
									var20.amount += var21;
									var17 = var16.a(var21);
									if (var17.amount == 0) {
										var16.d((ItemStack) null);
									}

									var16.a(var4, var6.getCarried());
								}
							}
						}

						var16.update();
					}
				}
			} else if (var3 == 2 && var2 >= 0 && var2 < 9) {
				var16 = (Slot) this.slots.get(var1);
				if (var16.a(var4)) {
					var17 = var6.getItem(var2);
					boolean var18 = var17 == null || var16.inventory == var6 && var16.a(var17);
					var21 = -1;
					if (!var18) {
						var21 = var6.getFirstEmptySlot();
						var18 |= var21 > -1;
					}

					if (var16.hasItem() && var18) {
						var23 = var16.getItemStack();
						var6.setItem(var2, var23.getCopy());
						if ((var16.inventory != var6 || !var16.a(var17)) && var17 != null) {
							if (var21 > -1) {
								var6.pickup(var17);
								var16.a(var23.amount);
								var16.d((ItemStack) null);
								var16.a(var4, var23);
							}
						} else {
							var16.a(var23.amount);
							var16.d(var17);
							var16.a(var4, var23);
						}
					} else if (!var16.hasItem() && var17 != null && var16.a(var17)) {
						var6.setItem(var2, (ItemStack) null);
						var16.d(var17);
					}
				}
			} else if (var3 == 3 && var4.playerProperties.instabuild && var6.getCarried() == null && var1 >= 0) {
				var16 = (Slot) this.slots.get(var1);
				if (var16 != null && var16.hasItem()) {
					var17 = var16.getItemStack().getCopy();
					var17.amount = var17.getMaxStackSize();
					var6.setCarried(var17);
				}
			} else if (var3 == 4 && var6.getCarried() == null && var1 >= 0) {
				var16 = (Slot) this.slots.get(var1);
				if (var16 != null && var16.hasItem() && var16.a(var4)) {
					var17 = var16.a(var2 == 0 ? 1 : var16.getItemStack().amount);
					var16.a(var4, var17);
					var4.dropItem(var17, true);
				}
			} else if (var3 == 6 && var1 >= 0) {
				var16 = (Slot) this.slots.get(var1);
				var17 = var6.getCarried();
				if (var17 != null && (var16 == null || !var16.hasItem() || !var16.a(var4))) {
					var9 = var2 == 0 ? 0 : this.slots.size() - 1;
					var21 = var2 == 0 ? 1 : -1;

					for (int var22 = 0; var22 < 2; ++var22) {
						for (int var24 = var9; var24 >= 0 && var24 < this.slots.size() && var17.amount < var17.getMaxStackSize(); var24 += var21) {
							Slot var25 = (Slot) this.slots.get(var24);
							if (var25.hasItem() && a(var25, var17, true) && var25.a(var4) && this.a(var17, var25) && (var22 != 0 || var25.getItemStack().amount != var25.getItemStack().getMaxStackSize())) {
								int var14 = Math.min(var17.getMaxStackSize() - var17.amount, var25.getItemStack().amount);
								ItemStack var15 = var25.a(var14);
								var17.amount += var14;
								if (var15.amount <= 0) {
									var25.d((ItemStack) null);
								}

								var25.a(var4, var15);
							}
						}
					}
				}

				this.b();
			}
		}

		return var5;
	}

	public boolean a(ItemStack var1, Slot var2) {
		return true;
	}

	protected void a(int var1, int var2, boolean var3, EntityHuman var4) {
		this.a(var1, var2, 1, var4);
	}

	public void onClose(EntityHuman var1) {
		InventoryPlayer var2 = var1.playerInventory;
		if (var2.getCarried() != null) {
			var1.dropItem(var2.getCarried(), false);
			var2.setCarried((ItemStack) null);
		}
	}

	public void a(IInventory var1) {
		this.b();
	}

	public void setItem(int var1, ItemStack var2) {
		this.getSlot(var1).d(var2);
	}

	public boolean isTransactionsConfirmed(EntityHuman human) {
		return !this.unConfirmedTransactions.contains(human);
	}

	public void notifyTransactionStatus(EntityHuman human, boolean flag) {
		if (flag) {
			this.unConfirmedTransactions.remove(human);
		} else {
			this.unConfirmedTransactions.add(human);
		}
	}

	public abstract boolean a(EntityHuman var1);

	protected boolean a(ItemStack var1, int var2, int var3, boolean var4) {
		boolean var5 = false;
		int var6 = var2;
		if (var4) {
			var6 = var3 - 1;
		}

		Slot var7;
		ItemStack var8;
		if (var1.d()) {
			while (var1.amount > 0 && (!var4 && var6 < var3 || var4 && var6 >= var2)) {
				var7 = (Slot) this.slots.get(var6);
				var8 = var7.getItemStack();
				if (var8 != null && var8.getItem() == var1.getItem() && (!var1.f() || var1.getWearout() == var8.getWearout()) && ItemStack.isSameNBTTags(var1, var8)) {
					int var9 = var8.amount + var1.amount;
					if (var9 <= var1.getMaxStackSize()) {
						var1.amount = 0;
						var8.amount = var9;
						var7.update();
						var5 = true;
					} else if (var8.amount < var1.getMaxStackSize()) {
						var1.amount -= var1.getMaxStackSize() - var8.amount;
						var8.amount = var1.getMaxStackSize();
						var7.update();
						var5 = true;
					}
				}

				if (var4) {
					--var6;
				} else {
					++var6;
				}
			}
		}

		if (var1.amount > 0) {
			if (var4) {
				var6 = var3 - 1;
			} else {
				var6 = var2;
			}

			while (!var4 && var6 < var3 || var4 && var6 >= var2) {
				var7 = (Slot) this.slots.get(var6);
				var8 = var7.getItemStack();
				if (var8 == null) {
					var7.d(var1.getCopy());
					var7.update();
					var1.amount = 0;
					var5 = true;
					break;
				}

				if (var4) {
					--var6;
				} else {
					++var6;
				}
			}
		}

		return var5;
	}

	public static int b(int var0) {
		return var0 >> 2 & 3;
	}

	public static int c(int var0) {
		return var0 & 3;
	}

	public static boolean a(int var0, EntityHuman var1) {
		return var0 == 0 ? true : (var0 == 1 ? true : var0 == 2 && var1.playerProperties.instabuild);
	}

	protected void d() {
		this.g = 0;
		this.h.clear();
	}

	public static boolean a(Slot var0, ItemStack var1, boolean var2) {
		boolean var3 = var0 == null || !var0.hasItem();
		if (var0 != null && var0.hasItem() && var1 != null && var1.a(var0.getItemStack()) && ItemStack.isSameNBTTags(var0.getItemStack(), var1)) {
			int var10002 = var2 ? 0 : var1.amount;
			var3 |= var0.getItemStack().amount + var10002 <= var1.getMaxStackSize();
		}

		return var3;
	}

	public static void a(Set var0, int var1, ItemStack var2, int var3) {
		switch (var1) {
			case 0:
				var2.amount = MathHelper.d((float) var2.amount / (float) var0.size());
				break;
			case 1:
				var2.amount = 1;
				break;
			case 2:
				var2.amount = var2.getItem().getMaxStackSize();
		}

		var2.amount += var3;
	}

	public boolean b(Slot var1) {
		return true;
	}

	public static int a(TileEntity var0) {
		return var0 instanceof IInventory ? b((IInventory) var0) : 0;
	}

	public static int b(IInventory var0) {
		if (var0 == null) {
			return 0;
		} else {
			int var1 = 0;
			float var2 = 0.0F;

			for (int var3 = 0; var3 < var0.getSize(); ++var3) {
				ItemStack var4 = var0.getItem(var3);
				if (var4 != null) {
					var2 += (float) var4.amount / (float) Math.min(var0.getMaxStackSize(), var4.getMaxStackSize());
					++var1;
				}
			}

			var2 /= (float) var0.getSize();
			return MathHelper.d(var2 * 14.0F) + (var1 > 0 ? 1 : 0);
		}
	}

	public abstract PipeInventory getPipeInventory();

}
