package net.minecraft;

public class ItemEnderEye extends Item {

	public ItemEnderEye() {
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		BlockState var9 = var3.getBlockState(var4);
		if (var2.a(var4.a(var5), var5, var1) && var9.getBlock() == Blocks.END_PORTAL_FRAME && !((Boolean) var9.b(BlockEnderPortalFrame.b)).booleanValue()) {
			if (var3.D) {
				return true;
			} else {
				var3.a(var4, var9.a(BlockEnderPortalFrame.b, Boolean.valueOf(true)), 2);
				var3.e(var4, Blocks.END_PORTAL_FRAME);
				--var1.amount;

				for (int var10 = 0; var10 < 16; ++var10) {
					double var11 = (double) ((float) var4.getX() + (5.0F + rnd.nextFloat() * 6.0F) / 16.0F);
					double var13 = (double) ((float) var4.getY() + 0.8125F);
					double var15 = (double) ((float) var4.getZ() + (5.0F + rnd.nextFloat() * 6.0F) / 16.0F);
					double var17 = 0.0D;
					double var19 = 0.0D;
					double var21 = 0.0D;
					var3.a(Particle.l, var11, var13, var15, var17, var19, var21, new int[0]);
				}

				BlockFace var23 = (BlockFace) var9.b(BlockEnderPortalFrame.a);
				int var24 = 0;
				int var12 = 0;
				boolean var25 = false;
				boolean var14 = true;
				BlockFace var26 = var23.e();

				for (int var16 = -2; var16 <= 2; ++var16) {
					Position var28 = var4.a(var26, var16);
					BlockState var18 = var3.getBlockState(var28);
					if (var18.getBlock() == Blocks.END_PORTAL_FRAME) {
						if (!((Boolean) var18.b(BlockEnderPortalFrame.b)).booleanValue()) {
							var14 = false;
							break;
						}

						var12 = var16;
						if (!var25) {
							var24 = var16;
							var25 = true;
						}
					}
				}

				if (var14 && var12 == var24 + 2) {
					Position var27 = var4.a(var23, 4);

					int var29;
					for (var29 = var24; var29 <= var12; ++var29) {
						Position var30 = var27.a(var26, var29);
						BlockState var32 = var3.getBlockState(var30);
						if (var32.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean) var32.b(BlockEnderPortalFrame.b)).booleanValue()) {
							var14 = false;
							break;
						}
					}

					int var31;
					Position var33;
					for (var29 = var24 - 1; var29 <= var12 + 1; var29 += 4) {
						var27 = var4.a(var26, var29);

						for (var31 = 1; var31 <= 3; ++var31) {
							var33 = var27.a(var23, var31);
							BlockState var20 = var3.getBlockState(var33);
							if (var20.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean) var20.b(BlockEnderPortalFrame.b)).booleanValue()) {
								var14 = false;
								break;
							}
						}
					}

					if (var14) {
						for (var29 = var24; var29 <= var12; ++var29) {
							var27 = var4.a(var26, var29);

							for (var31 = 1; var31 <= 3; ++var31) {
								var33 = var27.a(var23, var31);
								var3.a(var33, Blocks.END_PORTAL.getBlockState(), 2);
							}
						}
					}
				}

				return true;
			}
		} else {
			return false;
		}
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		MovingObjectPosition var4 = this.a(var2, var3, false);
		if (var4 != null && var4.type == EnumMovingObjectType.BLOCK && var2.getBlockState(var4.getPosition()).getBlock() == Blocks.END_PORTAL_FRAME) {
			return var1;
		} else {
			if (!var2.D) {
				Position var5 = var2.a("Stronghold", new Position(var3));
				if (var5 != null) {
					EntityEnderSignal var6 = new EntityEnderSignal(var2, var3.locationX, var3.locationY, var3.locationZ);
					var6.a(var5);
					var2.d((Entity) var6);
					var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
					var2.a((EntityHuman) null, 1002, new Position(var3), 0);
					if (!var3.playerProperties.instabuild) {
						--var1.amount;
					}

					var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
				}
			}

			return var1;
		}
	}
}
