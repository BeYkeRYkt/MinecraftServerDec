package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockCauldron extends Block {

	public static final bew a = bew.a("level", 0, 3);

	public BlockCauldron() {
		super(Material.ORE);
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
	}

	public void a(World var1, Position var2, BlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
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

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		float var6 = (float) var2.getY() + (6.0F + (float) (3 * var5)) / 16.0F;
		if (!var1.isStatic && var4.au() && var5 > 0 && var4.getBoundingBox().minY <= (double) var6) {
			var4.N();
			this.a(var1, var2, var3, var5 - 1);
		}

	}

	public boolean a(World var1, Position var2, BlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			ItemStack var9 = var4.playerInventory.getItemInHand();
			if (var9 == null) {
				return true;
			} else {
				int var10 = ((Integer) var3.b(a)).intValue();
				Item var11 = var9.getItem();
				if (var11 == Items.WATER_BUCKET) {
					if (var10 < 3) {
						if (!var4.playerProperties.instabuild) {
							var4.playerInventory.a(var4.playerInventory.itemInHandIndex, new ItemStack(Items.BUCKET));
						}

						this.a(var1, var2, var3, 3);
					}

					return true;
				} else {
					ItemStack var13;
					if (var11 == Items.GLASS_BOTTLE) {
						if (var10 > 0) {
							if (!var4.playerProperties.instabuild) {
								var13 = new ItemStack(Items.POTION, 1, 0);
								if (!var4.playerInventory.a(var13)) {
									var1.d((Entity) (new EntityItem(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 1.5D, (double) var2.getZ() + 0.5D, var13)));
								} else if (var4 instanceof EntityPlayer) {
									((EntityPlayer) var4).a(var4.defaultContainer);
								}

								--var9.amount;
								if (var9.amount <= 0) {
									var4.playerInventory.a(var4.playerInventory.itemInHandIndex, (ItemStack) null);
								}
							}

							this.a(var1, var2, var3, var10 - 1);
						}

						return true;
					} else {
						if (var10 > 0 && var11 instanceof ItemArmor) {
							ItemArmor var12 = (ItemArmor) var11;
							if (var12.w_() == EnumArmorMaterial.LEATHER && var12.d_(var9)) {
								var12.c(var9);
								this.a(var1, var2, var3, var10 - 1);
								return true;
							}
						}

						if (var10 > 0 && var11 instanceof ItemBanner && TileEntityBanner.c(var9) > 0) {
							var13 = var9.getCopy();
							var13.amount = 1;
							TileEntityBanner.e(var13);
							if (var9.amount <= 1 && !var4.playerProperties.instabuild) {
								var4.playerInventory.a(var4.playerInventory.itemInHandIndex, var13);
							} else {
								if (!var4.playerInventory.a(var13)) {
									var1.d((Entity) (new EntityItem(var1, (double) var2.getX() + 0.5D, (double) var2.getY() + 1.5D, (double) var2.getZ() + 0.5D, var13)));
								} else if (var4 instanceof EntityPlayer) {
									((EntityPlayer) var4).a(var4.defaultContainer);
								}

								if (!var4.playerProperties.instabuild) {
									--var9.amount;
								}
							}

							if (!var4.playerProperties.instabuild) {
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

	public void a(World var1, Position var2, BlockState var3, int var4) {
		var1.a(var2, var3.a(a, Integer.valueOf(MathHelper.a(var4, 0, 3))), 2);
		var1.e(var2, this);
	}

	public void k(World var1, Position var2) {
		if (var1.s.nextInt(20) == 1) {
			BlockState var3 = var1.getBlockState(var2);
			if (((Integer) var3.b(a)).intValue() < 3) {
				var1.a(var2, var3.a(a), 2);
			}

		}
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Items.CAULDRON;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		return ((Integer) var1.getBlockState(var2).b(a)).intValue();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, Integer.valueOf(var1));
	}

	public int c(BlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
