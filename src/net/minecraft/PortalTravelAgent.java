package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PortalTravelAgent {

	private final WorldServer a;
	private final Random b;
	private final LongHashMap c = new LongHashMap();
	private final List d = Lists.newArrayList();

	public PortalTravelAgent(WorldServer var1) {
		this.a = var1;
		this.b = new Random(var1.J());
	}

	public void a(Entity var1, float var2) {
		if (this.a.worldProvider.getDimensionId() != 1) {
			if (!this.b(var1, var2)) {
				this.a(var1);
				this.b(var1, var2);
			}
		} else {
			int var3 = MathHelper.toFixedPointInt(var1.locationX);
			int var4 = MathHelper.toFixedPointInt(var1.locationY) - 1;
			int var5 = MathHelper.toFixedPointInt(var1.locationZ);
			byte var6 = 1;
			byte var7 = 0;

			for (int var8 = -2; var8 <= 2; ++var8) {
				for (int var9 = -2; var9 <= 2; ++var9) {
					for (int var10 = -1; var10 < 3; ++var10) {
						int var11 = var3 + var9 * var6 + var8 * var7;
						int var12 = var4 + var10;
						int var13 = var5 + var9 * var7 - var8 * var6;
						boolean var14 = var10 < 0;
						this.a.a(new Position(var11, var12, var13), var14 ? Blocks.OBSIDIAN.getBlockState() : Blocks.AIR.getBlockState());
					}
				}
			}

			var1.setPositionRotation((double) var3, (double) var4, (double) var5, var1.yaw, 0.0F);
			var1.motionX = var1.motionY = var1.motionZ = 0.0D;
		}
	}

	public boolean b(Entity var1, float var2) {
		boolean var3 = true;
		double var4 = -1.0D;
		int var6 = MathHelper.toFixedPointInt(var1.locationX);
		int var7 = MathHelper.toFixedPointInt(var1.locationZ);
		boolean var8 = true;
		Object var9 = Position.ZERO;
		long var10 = ChunkCoordIntPair.toLongHash(var6, var7);
		if (this.c.contains(var10)) {
			ari var12 = (ari) this.c.getEntry(var10);
			var4 = 0.0D;
			var9 = var12;
			var12.b = this.a.getTime();
			var8 = false;
		} else {
			Position var34 = new Position(var1);

			for (int var13 = -128; var13 <= 128; ++var13) {
				Position var16;
				for (int var14 = -128; var14 <= 128; ++var14) {
					for (Position var15 = var34.a(var13, this.a.V() - 1 - var34.getY(), var14); var15.getY() >= 0; var15 = var16) {
						var16 = var15.getDown();
						if (this.a.getBlockState(var15).getBlock() == Blocks.PORTAL) {
							while (this.a.getBlockState(var16 = var15.getDown()).getBlock() == Blocks.PORTAL) {
								var15 = var16;
							}

							double var17 = var15.i(var34);
							if (var4 < 0.0D || var17 < var4) {
								var4 = var17;
								var9 = var15;
							}
						}
					}
				}
			}
		}

		if (var4 >= 0.0D) {
			if (var8) {
				this.c.put(var10, new ari(this, (Position) var9, this.a.getTime()));
				this.d.add(Long.valueOf(var10));
			}

			double var35 = (double) ((Position) var9).getX() + 0.5D;
			double var36 = (double) ((Position) var9).getY() + 0.5D;
			double var37 = (double) ((Position) var9).getZ() + 0.5D;
			BlockFace var18 = null;
			if (this.a.getBlockState(((Position) var9).e()).getBlock() == Blocks.PORTAL) {
				var18 = BlockFace.NORTH;
			}

			if (this.a.getBlockState(((Position) var9).f()).getBlock() == Blocks.PORTAL) {
				var18 = BlockFace.SOUTH;
			}

			if (this.a.getBlockState(((Position) var9).c()).getBlock() == Blocks.PORTAL) {
				var18 = BlockFace.EAST;
			}

			if (this.a.getBlockState(((Position) var9).d()).getBlock() == Blocks.PORTAL) {
				var18 = BlockFace.WEST;
			}

			BlockFace var19 = BlockFace.fromDirection(var1.aG());
			if (var18 != null) {
				BlockFace var20 = var18.f();
				Position var21 = ((Position) var9).getRelative(var18);
				boolean var22 = this.a(var21);
				boolean var23 = this.a(var21.getRelative(var20));
				if (var23 && var22) {
					var9 = ((Position) var9).getRelative(var20);
					var18 = var18.getOpposite();
					var20 = var20.getOpposite();
					Position var24 = ((Position) var9).getRelative(var18);
					var22 = this.a(var24);
					var23 = this.a(var24.getRelative(var20));
				}

				float var38 = 0.5F;
				float var25 = 0.5F;
				if (!var23 && var22) {
					var38 = 1.0F;
				} else if (var23 && !var22) {
					var38 = 0.0F;
				} else if (var23) {
					var25 = 0.0F;
				}

				var35 = (double) ((Position) var9).getX() + 0.5D;
				var36 = (double) ((Position) var9).getY() + 0.5D;
				var37 = (double) ((Position) var9).getZ() + 0.5D;
				var35 += (double) ((float) var20.g() * var38 + (float) var18.g() * var25);
				var37 += (double) ((float) var20.i() * var38 + (float) var18.i() * var25);
				float var26 = 0.0F;
				float var27 = 0.0F;
				float var28 = 0.0F;
				float var29 = 0.0F;
				if (var18 == var19) {
					var26 = 1.0F;
					var27 = 1.0F;
				} else if (var18 == var19.getOpposite()) {
					var26 = -1.0F;
					var27 = -1.0F;
				} else if (var18 == var19.e()) {
					var28 = 1.0F;
					var29 = -1.0F;
				} else {
					var28 = -1.0F;
					var29 = 1.0F;
				}

				double var30 = var1.motionX;
				double var32 = var1.motionZ;
				var1.motionX = var30 * (double) var26 + var32 * (double) var29;
				var1.motionZ = var30 * (double) var28 + var32 * (double) var27;
				var1.yaw = var2 - (float) (var19.toDirection() * 90) + (float) (var18.toDirection() * 90);
			} else {
				var1.motionX = var1.motionY = var1.motionZ = 0.0D;
			}

			var1.setPositionRotation(var35, var36, var37, var1.yaw, var1.pitch);
			return true;
		} else {
			return false;
		}
	}

	private boolean a(Position var1) {
		return !this.a.d(var1) || !this.a.d(var1.getUp());
	}

	public boolean a(Entity var1) {
		byte var2 = 16;
		double var3 = -1.0D;
		int var5 = MathHelper.toFixedPointInt(var1.locationX);
		int var6 = MathHelper.toFixedPointInt(var1.locationY);
		int var7 = MathHelper.toFixedPointInt(var1.locationZ);
		int var8 = var5;
		int var9 = var6;
		int var10 = var7;
		int var11 = 0;
		int var12 = this.b.nextInt(4);

		int var13;
		double var14;
		int var16;
		double var17;
		int var19;
		int var20;
		int var21;
		int var22;
		int var23;
		int var24;
		int var25;
		int var26;
		int var27;
		double var32;
		double var33;
		for (var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
			var14 = (double) var13 + 0.5D - var1.locationX;

			for (var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
				var17 = (double) var16 + 0.5D - var1.locationZ;

				label271: for (var19 = this.a.V() - 1; var19 >= 0; --var19) {
					if (this.a.d(new Position(var13, var19, var16))) {
						while (var19 > 0 && this.a.d(new Position(var13, var19 - 1, var16))) {
							--var19;
						}

						for (var20 = var12; var20 < var12 + 4; ++var20) {
							var21 = var20 % 2;
							var22 = 1 - var21;
							if (var20 % 4 >= 2) {
								var21 = -var21;
								var22 = -var22;
							}

							for (var23 = 0; var23 < 3; ++var23) {
								for (var24 = 0; var24 < 4; ++var24) {
									for (var25 = -1; var25 < 4; ++var25) {
										var26 = var13 + (var24 - 1) * var21 + var23 * var22;
										var27 = var19 + var25;
										int var28 = var16 + (var24 - 1) * var22 - var23 * var21;
										if (var25 < 0 && !this.a.getBlockState(new Position(var26, var27, var28)).getBlock().getMaterial().isBuildable() || var25 >= 0 && !this.a.d(new Position(var26, var27, var28))) {
											continue label271;
										}
									}
								}
							}

							var32 = (double) var19 + 0.5D - var1.locationY;
							var33 = var14 * var14 + var32 * var32 + var17 * var17;
							if (var3 < 0.0D || var33 < var3) {
								var3 = var33;
								var8 = var13;
								var9 = var19;
								var10 = var16;
								var11 = var20 % 4;
							}
						}
					}
				}
			}
		}

		if (var3 < 0.0D) {
			for (var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
				var14 = (double) var13 + 0.5D - var1.locationX;

				for (var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
					var17 = (double) var16 + 0.5D - var1.locationZ;

					label219: for (var19 = this.a.V() - 1; var19 >= 0; --var19) {
						if (this.a.d(new Position(var13, var19, var16))) {
							while (var19 > 0 && this.a.d(new Position(var13, var19 - 1, var16))) {
								--var19;
							}

							for (var20 = var12; var20 < var12 + 2; ++var20) {
								var21 = var20 % 2;
								var22 = 1 - var21;

								for (var23 = 0; var23 < 4; ++var23) {
									for (var24 = -1; var24 < 4; ++var24) {
										var25 = var13 + (var23 - 1) * var21;
										var26 = var19 + var24;
										var27 = var16 + (var23 - 1) * var22;
										if (var24 < 0 && !this.a.getBlockState(new Position(var25, var26, var27)).getBlock().getMaterial().isBuildable() || var24 >= 0 && !this.a.d(new Position(var25, var26, var27))) {
											continue label219;
										}
									}
								}

								var32 = (double) var19 + 0.5D - var1.locationY;
								var33 = var14 * var14 + var32 * var32 + var17 * var17;
								if (var3 < 0.0D || var33 < var3) {
									var3 = var33;
									var8 = var13;
									var9 = var19;
									var10 = var16;
									var11 = var20 % 2;
								}
							}
						}
					}
				}
			}
		}

		int var29 = var8;
		int var15 = var9;
		var16 = var10;
		int var30 = var11 % 2;
		int var18 = 1 - var30;
		if (var11 % 4 >= 2) {
			var30 = -var30;
			var18 = -var18;
		}

		if (var3 < 0.0D) {
			var9 = MathHelper.a(var9, 70, this.a.V() - 10);
			var15 = var9;

			for (var19 = -1; var19 <= 1; ++var19) {
				for (var20 = 1; var20 < 3; ++var20) {
					for (var21 = -1; var21 < 3; ++var21) {
						var22 = var29 + (var20 - 1) * var30 + var19 * var18;
						var23 = var15 + var21;
						var24 = var16 + (var20 - 1) * var18 - var19 * var30;
						boolean var34 = var21 < 0;
						this.a.a(new Position(var22, var23, var24), var34 ? Blocks.OBSIDIAN.getBlockState() : Blocks.AIR.getBlockState());
					}
				}
			}
		}

		IBlockState var31 = Blocks.PORTAL.getBlockState().a(BlockPortal.a, var30 != 0 ? el.a : el.c);

		for (var20 = 0; var20 < 4; ++var20) {
			for (var21 = 0; var21 < 4; ++var21) {
				for (var22 = -1; var22 < 4; ++var22) {
					var23 = var29 + (var21 - 1) * var30;
					var24 = var15 + var22;
					var25 = var16 + (var21 - 1) * var18;
					boolean var35 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
					this.a.setBlockAt(new Position(var23, var24, var25), var35 ? Blocks.OBSIDIAN.getBlockState() : var31, 2);
				}
			}

			for (var21 = 0; var21 < 4; ++var21) {
				for (var22 = -1; var22 < 4; ++var22) {
					var23 = var29 + (var21 - 1) * var30;
					var24 = var15 + var22;
					var25 = var16 + (var21 - 1) * var18;
					this.a.c(new Position(var23, var24, var25), this.a.getBlockState(new Position(var23, var24, var25)).getBlock());
				}
			}
		}

		return true;
	}

	public void a(long var1) {
		if (var1 % 100L == 0L) {
			Iterator var3 = this.d.iterator();
			long var4 = var1 - 600L;

			while (var3.hasNext()) {
				Long var6 = (Long) var3.next();
				ari var7 = (ari) this.c.getEntry(var6.longValue());
				if (var7 == null || var7.b < var4) {
					var3.remove();
					this.c.remove(var6.longValue());
				}
			}
		}

	}
}
