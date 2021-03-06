package net.minecraft;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pipebukkit.server.inventory.PipeAnvilInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerAnvil extends Container {

	private InventoryAnvil anvil;
	private IInventory g = new InventoryResult();
	private IInventory h;
	private World i;
	private Position j;
	public int a;
	private int k;
	private String l;
	private final EntityHuman m;

	public ContainerAnvil(InventoryAnvil anvil, InventoryPlayer var1, World var2, Position var3, EntityHuman var4) {
		this.anvil = anvil;
		h = new SubInventoryAnvil(var1.owner, this, "Repair", true, 2);
		this.j = var3;
		this.i = var2;
		this.m = var4;
		this.addSlot(new Slot(this.h, 0, 27, 47));
		this.addSlot(new Slot(this.h, 1, 76, 47));
		this.addSlot((Slot) (new aif(this, this.g, 2, 134, 47, var2, var3)));

		int var5;
		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.addSlot(new Slot(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.addSlot(new Slot(var1, var5, 8 + var5 * 18, 142));
		}

	}

	public void a(IInventory var1) {
		super.a(var1);
		if (var1 == this.h) {
			this.e();
		}

	}

	public void e() {
		boolean var1 = false;
		boolean var2 = true;
		boolean var3 = true;
		boolean var4 = true;
		boolean var5 = true;
		boolean var6 = true;
		boolean var7 = true;
		ItemStack var8 = this.h.getItem(0);
		this.a = 1;
		int var9 = 0;
		byte var10 = 0;
		byte var11 = 0;
		if (var8 == null) {
			this.g.setItem(0, (ItemStack) null);
			this.a = 0;
		} else {
			ItemStack var12 = var8.getCopy();
			ItemStack var13 = this.h.getItem(1);
			Map var14 = aph.a(var12);
			boolean var15 = false;
			int var25 = var10 + var8.A() + (var13 == null ? 0 : var13.A());
			this.k = 0;
			int var16;
			if (var13 != null) {
				var15 = var13.getItem() == Items.ENCHANTED_BOOK && Items.ENCHANTED_BOOK.h(var13).getSize() > 0;
				int var17;
				int var18;
				if (var12.e() && var12.getItem().a(var8, var13)) {
					var16 = Math.min(var12.getWearout(), var12.getMaxWearout() / 4);
					if (var16 <= 0) {
						this.g.setItem(0, (ItemStack) null);
						this.a = 0;
						return;
					}

					for (var17 = 0; var16 > 0 && var17 < var13.amount; ++var17) {
						var18 = var12.getWearout() - var16;
						var12.setWearout(var18);
						++var9;
						var16 = Math.min(var12.getWearout(), var12.getMaxWearout() / 4);
					}

					this.k = var17;
				} else {
					if (!var15 && (var12.getItem() != var13.getItem() || !var12.e())) {
						this.g.setItem(0, (ItemStack) null);
						this.a = 0;
						return;
					}

					int var20;
					if (var12.e() && !var15) {
						var16 = var8.getMaxWearout() - var8.getWearout();
						var17 = var13.getMaxWearout() - var13.getWearout();
						var18 = var17 + var12.getMaxWearout() * 12 / 100;
						int var19 = var16 + var18;
						var20 = var12.getMaxWearout() - var19;
						if (var20 < 0) {
							var20 = 0;
						}

						if (var20 < var12.getWearout()) {
							var12.setWearout(var20);
							var9 += 2;
						}
					}

					Map var26 = aph.a(var13);
					Iterator var27 = var26.keySet().iterator();

					while (var27.hasNext()) {
						var18 = ((Integer) var27.next()).intValue();
						Enchantment var28 = Enchantment.getById(var18);
						if (var28 != null) {
							var20 = var14.containsKey(Integer.valueOf(var18)) ? ((Integer) var14.get(Integer.valueOf(var18))).intValue() : 0;
							int var21 = ((Integer) var26.get(Integer.valueOf(var18))).intValue();
							int var10000;
							if (var20 == var21) {
								++var21;
								var10000 = var21;
							} else {
								var10000 = Math.max(var21, var20);
							}

							var21 = var10000;
							boolean var22 = var28.canEnchant(var8);
							if (this.m.playerProperties.instabuild || var8.getItem() == Items.ENCHANTED_BOOK) {
								var22 = true;
							}

							Iterator var23 = var14.keySet().iterator();

							while (var23.hasNext()) {
								int var24 = ((Integer) var23.next()).intValue();
								if (var24 != var18 && !var28.a(Enchantment.getById(var24))) {
									var22 = false;
									++var9;
								}
							}

							if (var22) {
								if (var21 > var28.getMaxLevel()) {
									var21 = var28.getMaxLevel();
								}

								var14.put(Integer.valueOf(var18), Integer.valueOf(var21));
								int var29 = 0;
								switch (var28.getRandomWeight()) {
									case 1:
										var29 = 8;
										break;
									case 2:
										var29 = 4;
									case 3:
									case 4:
									case 6:
									case 7:
									case 8:
									case 9:
									default:
										break;
									case 5:
										var29 = 2;
										break;
									case 10:
										var29 = 1;
								}

								if (var15) {
									var29 = Math.max(1, var29 / 2);
								}

								var9 += var29 * var21;
							}
						}
					}
				}
			}

			if (StringUtils.isBlank(this.l)) {
				if (var8.hasDisplayName()) {
					var11 = 1;
					var9 += var11;
					var12.removeDisplayName();
				}
			} else if (!this.l.equals(var8.getDisplayName())) {
				var11 = 1;
				var9 += var11;
				var12.setDisplayName(this.l);
			}

			this.a = var25 + var9;
			if (var9 <= 0) {
				var12 = null;
			}

			if (var11 == var9 && var11 > 0 && this.a >= 40) {
				this.a = 39;
			}

			if (this.a >= 40 && !this.m.playerProperties.instabuild) {
				var12 = null;
			}

			if (var12 != null) {
				var16 = var12.A();
				if (var13 != null && var16 < var13.A()) {
					var16 = var13.A();
				}

				var16 = var16 * 2 + 1;
				var12.c(var16);
				aph.a(var14, var12);
			}

			this.g.setItem(0, var12);
			this.b();
		}
	}

	public void addSlotListener(ICrafting var1) {
		super.addSlotListener(var1);
		var1.sendContainerProperty(this, 0, this.a);
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);
		if (!this.i.isStatic) {
			for (int var2 = 0; var2 < this.h.getSize(); ++var2) {
				ItemStack var3 = this.h.splitWithoutUpdate(var2);
				if (var3 != null) {
					var1.dropItem(var3, false);
				}
			}

		}
	}

	public boolean isContainerValid(EntityHuman var1) {
		return this.i.getBlockState(this.j).getBlock() != Blocks.ANVIL ? false : var1.getDistanceSquared((double) this.j.getX() + 0.5D, (double) this.j.getY() + 0.5D, (double) this.j.getZ() + 0.5D) <= 64.0D;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 != 0 && var2 != 1) {
				if (var2 >= 3 && var2 < 39 && !this.a(var5, 0, 2, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
				return null;
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

	public void setResultItemName(String name) {
		this.l = name;
		if (this.getSlot(2).hasItem()) {
			ItemStack var2 = this.getSlot(2).getItemStack();
			if (StringUtils.isBlank(name)) {
				var2.removeDisplayName();
			} else {
				var2.setDisplayName(this.l);
			}
		}

		this.e();
	}

	// $FF: synthetic method
	static IInventory a(ContainerAnvil var0) {
		return var0.h;
	}

	// $FF: synthetic method
	static int b(ContainerAnvil var0) {
		return var0.k;
	}

	@Override
	public PipeInventory getPipeInventory() {
		return new PipeAnvilInventory(anvil, h, g);
	}

}
