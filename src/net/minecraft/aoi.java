package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class aoi implements aoo {

	private ItemStack a;

	public boolean a(ain var1, World var2) {
		this.a = null;
		int var3 = 0;
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;

		for (int var9 = 0; var9 < var1.n_(); ++var9) {
			ItemStack var10 = var1.a(var9);
			if (var10 != null) {
				if (var10.getItem() == Items.GUNPOWDER) {
					++var4;
				} else if (var10.getItem() == Items.FIREWORK_CHARGE) {
					++var6;
				} else if (var10.getItem() == Items.DYE) {
					++var5;
				} else if (var10.getItem() == Items.PAPER) {
					++var3;
				} else if (var10.getItem() == Items.GLOWSTONE_DUST) {
					++var7;
				} else if (var10.getItem() == Items.DIAMOND) {
					++var7;
				} else if (var10.getItem() == Items.FIRE_CHARGE) {
					++var8;
				} else if (var10.getItem() == Items.FEATHER) {
					++var8;
				} else if (var10.getItem() == Items.GOLD_NUGGET) {
					++var8;
				} else {
					if (var10.getItem() != Items.SKULL) {
						return false;
					}

					++var8;
				}
			}
		}

		var7 += var5 + var8;
		if (var4 <= 3 && var3 <= 1) {
			NBTCompoundTag var16;
			NBTCompoundTag var19;
			if (var4 >= 1 && var3 == 1 && var7 == 0) {
				this.a = new ItemStack(Items.FIREWORKS);
				if (var6 > 0) {
					var16 = new NBTCompoundTag();
					var19 = new NBTCompoundTag();
					NBTListTag var23 = new NBTListTag();

					for (int var24 = 0; var24 < var1.n_(); ++var24) {
						ItemStack var26 = var1.a(var24);
						if (var26 != null && var26.getItem() == Items.FIREWORK_CHARGE && var26.hasTag() && var26.getTag().isTagAssignableFrom("Explosion", 10)) {
							var23.addTag((NBTTag) var26.getTag().getCompound("Explosion"));
						}
					}

					var19.put("Explosions", (NBTTag) var23);
					var19.put("Flight", (byte) var4);
					var16.put("Fireworks", (NBTTag) var19);
					this.a.d(var16);
				}

				return true;
			} else if (var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
				this.a = new ItemStack(Items.FIREWORK_CHARGE);
				var16 = new NBTCompoundTag();
				var19 = new NBTCompoundTag();
				byte var22 = 0;
				ArrayList var12 = Lists.newArrayList();

				for (int var13 = 0; var13 < var1.n_(); ++var13) {
					ItemStack var14 = var1.a(var13);
					if (var14 != null) {
						if (var14.getItem() == Items.DYE) {
							var12.add(Integer.valueOf(ItemDye.a[var14.i() & 15]));
						} else if (var14.getItem() == Items.GLOWSTONE_DUST) {
							var19.put("Flicker", true);
						} else if (var14.getItem() == Items.DIAMOND) {
							var19.put("Trail", true);
						} else if (var14.getItem() == Items.FIRE_CHARGE) {
							var22 = 1;
						} else if (var14.getItem() == Items.FEATHER) {
							var22 = 4;
						} else if (var14.getItem() == Items.GOLD_NUGGET) {
							var22 = 2;
						} else if (var14.getItem() == Items.SKULL) {
							var22 = 3;
						}
					}
				}

				int[] var25 = new int[var12.size()];

				for (int var27 = 0; var27 < var25.length; ++var27) {
					var25[var27] = ((Integer) var12.get(var27)).intValue();
				}

				var19.put("Colors", var25);
				var19.put("Type", var22);
				var16.put("Explosion", (NBTTag) var19);
				this.a.d(var16);
				return true;
			} else if (var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
				ArrayList var15 = Lists.newArrayList();

				for (int var17 = 0; var17 < var1.n_(); ++var17) {
					ItemStack var11 = var1.a(var17);
					if (var11 != null) {
						if (var11.getItem() == Items.DYE) {
							var15.add(Integer.valueOf(ItemDye.a[var11.i() & 15]));
						} else if (var11.getItem() == Items.FIREWORK_CHARGE) {
							this.a = var11.getCopy();
							this.a.b = 1;
						}
					}
				}

				int[] var18 = new int[var15.size()];

				for (int var20 = 0; var20 < var18.length; ++var20) {
					var18[var20] = ((Integer) var15.get(var20)).intValue();
				}

				if (this.a != null && this.a.hasTag()) {
					NBTCompoundTag var21 = this.a.getTag().getCompound("Explosion");
					if (var21 == null) {
						return false;
					} else {
						var21.put("FadeColors", var18);
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public ItemStack a(ain var1) {
		return this.a.getCopy();
	}

	public int a() {
		return 10;
	}

	public ItemStack b() {
		return this.a;
	}

	public ItemStack[] b(ain var1) {
		ItemStack[] var2 = new ItemStack[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.a(var3);
			if (var4 != null && var4.getItem().r()) {
				var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
			}
		}

		return var2;
	}
}
