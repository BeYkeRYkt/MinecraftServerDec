package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockCauldron extends Block {

	public static final bew a = bew.a("level", 0, 3);

	public BlockCauldron() {
		super(Material.ORE);
		this.j(this.L.b().a(a, Integer.valueOf(0)));
	}

	public void a(World var1, Position var2, bec var3, brt var4, List var5, Entity var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		float var7 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.h();
	}

	public void h() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		float var6 = (float) var2.getY() + (6.0F + (float) (3 * var5)) / 16.0F;
		if (!var1.D && var4.au() && var5 > 0 && var4.aQ().b <= (double) var6) {
			var4.N();
			this.a(var1, var2, var3, var5 - 1);
		}

	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			ItemStack var9 = var4.playerInventory.getItemInHand();
			if (var9 == null) {
				return true;
			} else {
				int var10 = ((Integer) var3.b(a)).intValue();
				Item var11 = var9.getItem();
				if (var11 == amk.ax) {
					if (var10 < 3) {
						if (!var4.by.instabuild) {
							var4.playerInventory.a(var4.playerInventory.c, new ItemStack(amk.aw));
						}

						this.a(var1, var2, var3, 3);
					}

					return true;
				} else {
					ItemStack var13;
					if (var11 == amk.bA) {
						if (var10 > 0) {
							if (!var4.by.instabuild) {
								var13 = new ItemStack(amk.bz, 1, 0);
								if (!var4.playerInventory.a(var13)) {
									var1.d((Entity) (new EntityItem(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 1.5D, (double) var2.getZ() + 0.5D, var13)));
								} else if (var4 instanceof EntityPlayer) {
									((EntityPlayer) var4).a(var4.defaultContainer);
								}

								--var9.b;
								if (var9.b <= 0) {
									var4.playerInventory.a(var4.playerInventory.c, (ItemStack) null);
								}
							}

							this.a(var1, var2, var3, var10 - 1);
						}

						return true;
					} else {
						if (var10 > 0 && var11 instanceof ajn) {
							ajn var12 = (ajn) var11;
							if (var12.w_() == ajp.a && var12.d_(var9)) {
								var12.c(var9);
								this.a(var1, var2, var3, var10 - 1);
								return true;
							}
						}

						if (var10 > 0 && var11 instanceof ajs && TileEntityBanner.c(var9) > 0) {
							var13 = var9.getCopy();
							var13.b = 1;
							TileEntityBanner.e(var13);
							if (var9.b <= 1 && !var4.by.instabuild) {
								var4.playerInventory.a(var4.playerInventory.c, var13);
							} else {
								if (!var4.playerInventory.a(var13)) {
									var1.d((Entity) (new EntityItem(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 1.5D, (double) var2.getZ() + 0.5D, var13)));
								} else if (var4 instanceof EntityPlayer) {
									((EntityPlayer) var4).a(var4.defaultContainer);
								}

								if (!var4.by.instabuild) {
									--var9.b;
								}
							}

							if (!var4.by.instabuild) {
								this.a(var1, var2, var3, var10 - 1);
							}

							return true;
						} else {
							return false;
						}
					}
				}
			}
		}
	}

	public void a(World var1, Position var2, bec var3, int var4) {
		var1.a(var2, var3.a(a, Integer.valueOf(DataTypesConverter.a(var4, 0, 3))), 2);
		var1.e(var2, this);
	}

	public void k(World var1, Position var2) {
		if (var1.s.nextInt(20) == 1) {
			bec var3 = var1.p(var2);
			if (((Integer) var3.b(a)).intValue() < 3) {
				var1.a(var2, var3.a(a), 2);
			}

		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.bG;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		return ((Integer) var1.p(var2).b(a)).intValue();
	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
