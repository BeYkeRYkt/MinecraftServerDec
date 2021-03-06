package net.minecraft;

public class ItemMonsterEgg extends Item {

	public ItemMonsterEgg() {
		this.a(true);
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public String a(ItemStack var1) {
		String var2 = ("" + LocaleI18n.get(this.getName() + ".name")).trim();
		String var3 = EntityTypes.getNameById(var1.getWearout());
		if (var3 != null) {
			var2 = var2 + " " + LocaleI18n.get("entity." + var3 + ".name");
		}

		return var2;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var3.isStatic) {
			return true;
		} else if (!var2.a(var4.getRelative(var5), var5, var1)) {
			return false;
		} else {
			IBlockState var9 = var3.getBlockState(var4);
			if (var9.getBlock() == Blocks.MOB_SPAWNER) {
				TileEntity var10 = var3.getTileEntity(var4);
				if (var10 instanceof TileEntityMobSpawner) {
					MobSpawnerAbstract var11 = ((TileEntityMobSpawner) var10).getSpawner();
					var11.setMobName(EntityTypes.getNameById(var1.getWearout()));
					var10.update();
					var3.notify(var4);
					if (!var2.playerProperties.instabuild) {
						--var1.amount;
					}

					return true;
				}
			}

			var4 = var4.getRelative(var5);
			double var13 = 0.0D;
			if (var5 == BlockFace.UP && var9 instanceof BlockFence) {
				var13 = 0.5D;
			}

			Entity var12 = a(var3, var1.getWearout(), (double) var4.getX() + 0.5D, (double) var4.getY() + var13, (double) var4.getZ() + 0.5D);
			if (var12 != null) {
				if (var12 instanceof EntityLiving && var1.hasDisplayName()) {
					var12.a(var1.getDisplayName());
				}

				if (!var2.playerProperties.instabuild) {
					--var1.amount;
				}
			}

			return true;
		}
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var2.isStatic) {
			return var1;
		} else {
			MovingObjectPosition var4 = this.a(var2, var3, true);
			if (var4 == null) {
				return var1;
			} else {
				if (var4.type == EnumMovingObjectType.BLOCK) {
					Position var5 = var4.getPosition();
					if (!var2.a(var3, var5)) {
						return var1;
					}

					if (!var3.a(var5, var4.face, var1)) {
						return var1;
					}

					if (var2.getBlockState(var5).getBlock() instanceof axl) {
						Entity var6 = a(var2, var1.getWearout(), (double) var5.getX() + 0.5D, (double) var5.getY() + 0.5D, (double) var5.getZ() + 0.5D);
						if (var6 != null) {
							if (var6 instanceof EntityLiving && var1.hasDisplayName()) {
								((EntityInsentient) var6).a(var1.getDisplayName());
							}

							if (!var3.playerProperties.instabuild) {
								--var1.amount;
							}

							var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
						}
					}
				}

				return var1;
			}
		}
	}

	public static Entity a(World var0, int var1, double var2, double var4, double var6) {
		if (!EntityTypes.eggInfo.containsKey(Integer.valueOf(var1))) {
			return null;
		} else {
			Entity var8 = null;

			for (int var9 = 0; var9 < 1; ++var9) {
				var8 = EntityTypes.createEntity(var1, var0);
				if (var8 instanceof EntityLiving) {
					EntityInsentient var10 = (EntityInsentient) var8;
					var8.setPositionRotation(var2, var4, var6, MathHelper.g(var0.random.nextFloat() * 360.0F), 0.0F);
					var10.headPitch = var10.yaw;
					var10.aG = var10.yaw;
					var10.a(var0.E(new Position(var10)), (xq) null);
					var0.addEntity(var8);
					var10.x();
				}
			}

			return var8;
		}
	}
}
