package net.minecraft;

public class ItemMonsterEgg extends Item {

	public ItemMonsterEgg() {
		this.a(true);
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public String a(ItemStack var1) {
		String var2 = ("" + LocaleI18n.get(this.getName() + ".name")).trim();
		String var3 = EntityTypes.getNameById(var1.i());
		if (var3 != null) {
			var2 = var2 + " " + LocaleI18n.get("entity." + var3 + ".name");
		}

		return var2;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var3.D) {
			return true;
		} else if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			if (var9.getBlock() == Blocks.MOB_SPAWNER) {
				TileEntity var10 = var3.s(var4);
				if (var10 instanceof TileEntityMobSpawner) {
					aqi var11 = ((TileEntityMobSpawner) var10).b();
					var11.a(EntityTypes.getNameById(var1.i()));
					var10.o_();
					var3.h(var4);
					if (!var2.by.instabuild) {
						--var1.b;
					}

					return true;
				}
			}

			var4 = var4.a(var5);
			double var13 = 0.0D;
			if (var5 == BlockFace.b && var9 instanceof BlockFence) {
				var13 = 0.5D;
			}

			Entity var12 = a(var3, var1.i(), (double) var4.getX() + 0.5D, (double) var4.getY() + var13, (double) var4.getZ() + 0.5D);
			if (var12 != null) {
				if (var12 instanceof EntityLiving && var1.s()) {
					var12.a(var1.q());
				}

				if (!var2.by.instabuild) {
					--var1.b;
				}
			}

			return true;
		}
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var2.D) {
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

					if (var2.p(var5).getBlock() instanceof axl) {
						Entity var6 = a(var2, var1.i(), (double) var5.getX() + 0.5D, (double) var5.getY() + 0.5D, (double) var5.getZ() + 0.5D);
						if (var6 != null) {
							if (var6 instanceof EntityLiving && var1.s()) {
								((EntityInsentient) var6).a(var1.q());
							}

							if (!var3.by.instabuild) {
								--var1.b;
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
					var8.b(var2, var4, var6, DataTypesConverter.g(var0.s.nextFloat() * 360.0F), 0.0F);
					var10.headPitch = var10.yaw;
					var10.aG = var10.yaw;
					var10.a(var0.E(new Position(var10)), (xq) null);
					var0.d(var8);
					var10.x();
				}
			}

			return var8;
		}
	}
}
