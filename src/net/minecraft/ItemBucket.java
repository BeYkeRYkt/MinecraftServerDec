package net.minecraft;

public class ItemBucket extends Item {

	private Block a;

	public ItemBucket(Block var1) {
		this.maxStackSize = 1;
		this.a = var1;
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		boolean var4 = this.a == Blocks.AIR;
		MovingObjectPosition var5 = this.a(var2, var3, var4);
		if (var5 == null) {
			return var1;
		} else {
			if (var5.type == EnumMovingObjectType.BLOCK) {
				Position var6 = var5.getPosition();
				if (!var2.a(var3, var6)) {
					return var1;
				}

				if (var4) {
					if (!var3.a(var6.getRelative(var5.face), var5.face, var1)) {
						return var1;
					}

					IBlockState var7 = var2.getBlockState(var6);
					Material var8 = var7.getBlock().getMaterial();
					if (var8 == Material.WATER && ((Integer) var7.b(axl.b)).intValue() == 0) {
						var2.g(var6);
						var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
						return this.a(var1, var3, Items.WATER_BUCKET);
					}

					if (var8 == Material.LAVA && ((Integer) var7.b(axl.b)).intValue() == 0) {
						var2.g(var6);
						var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
						return this.a(var1, var3, Items.LAVA_BUCKET);
					}
				} else {
					if (this.a == Blocks.AIR) {
						return new ItemStack(Items.BUCKET);
					}

					Position var9 = var6.getRelative(var5.face);
					if (!var3.a(var9, var5.face, var1)) {
						return var1;
					}

					if (this.a(var2, var9) && !var3.playerProperties.instabuild) {
						var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
						return new ItemStack(Items.BUCKET);
					}
				}
			}

			return var1;
		}
	}

	private ItemStack a(ItemStack var1, EntityHuman var2, Item var3) {
		if (var2.playerProperties.instabuild) {
			return var1;
		} else if (--var1.amount <= 0) {
			return new ItemStack(var3);
		} else {
			if (!var2.playerInventory.pickup(new ItemStack(var3))) {
				var2.dropItem(new ItemStack(var3, 1, 0), false);
			}

			return var1;
		}
	}

	public boolean a(World var1, Position var2) {
		if (this.a == Blocks.AIR) {
			return false;
		} else {
			Material var3 = var1.getBlockState(var2).getBlock().getMaterial();
			boolean var4 = !var3.isBuildable();
			if (!var1.d(var2) && !var4) {
				return false;
			} else {
				if (var1.worldProvider.n() && this.a == Blocks.FLOWING_WATER) {
					int var5 = var2.getX();
					int var6 = var2.getY();
					int var7 = var2.getZ();
					var1.makeSound((double) ((float) var5 + 0.5F), (double) ((float) var6 + 0.5F), (double) ((float) var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

					for (int var8 = 0; var8 < 8; ++var8) {
						var1.a(Particle.m, (double) var5 + Math.random(), (double) var6 + Math.random(), (double) var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
					}
				} else {
					if (!var1.isStatic && var4 && !var3.isLiquid()) {
						var1.b(var2, true);
					}

					var1.setBlockAt(var2, this.a.getBlockState(), 3);
				}

				return true;
			}
		}
	}
}
