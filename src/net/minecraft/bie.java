package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bie extends bhp {

	private static final Logger a = LogManager.getLogger();
	private static final String[] b = new String[] { "Skeleton", "Zombie", "Zombie", "Spider" };
	private static final List c = Lists
			.newArrayList((Object[]) (new vl[] { new vl(Items.aA, 0, 1, 1, 10), new vl(Items.j, 0, 1, 4, 10), new vl(Items.P, 0, 1, 1, 10), new vl(Items.O, 0, 1, 4, 10), new vl(Items.H, 0, 1, 4, 10), new vl(Items.F, 0, 1, 4, 10), new vl(Items.aw, 0, 1, 1, 10), new vl(Items.ao, 0, 1, 1, 1), new vl(Items.aC, 0, 1, 4, 10), new vl(Items.cq, 0, 1, 1, 4), new vl(Items.cr, 0, 1, 1, 4), new vl(Items.co, 0, 1, 1, 10), new vl(Items.cl, 0, 1, 1, 2), new vl(Items.ck, 0, 1, 1, 5), new vl(Items.cm, 0, 1, 1, 1) }));

	public boolean b(World var1, Random var2, Position var3) {
		boolean var4 = true;
		int var5 = var2.nextInt(2) + 2;
		int var6 = -var5 - 1;
		int var7 = var5 + 1;
		boolean var8 = true;
		boolean var9 = true;
		int var10 = var2.nextInt(2) + 2;
		int var11 = -var10 - 1;
		int var12 = var10 + 1;
		int var13 = 0;

		int var14;
		int var15;
		int var16;
		Position var17;
		for (var14 = var6; var14 <= var7; ++var14) {
			for (var15 = -1; var15 <= 4; ++var15) {
				for (var16 = var11; var16 <= var12; ++var16) {
					var17 = var3.a(var14, var15, var16);
					Material var18 = var1.p(var17).getBlock().r();
					boolean var19 = var18.isBuildable();
					if (var15 == -1 && !var19) {
						return false;
					}

					if (var15 == 4 && !var19) {
						return false;
					}

					if ((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && var1.d(var17) && var1.d(var17.a())) {
						++var13;
					}
				}
			}
		}

		if (var13 >= 1 && var13 <= 5) {
			for (var14 = var6; var14 <= var7; ++var14) {
				for (var15 = 3; var15 >= -1; --var15) {
					for (var16 = var11; var16 <= var12; ++var16) {
						var17 = var3.a(var14, var15, var16);
						if (var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
							if (var1.p(var17).getBlock() != Blocks.ae) {
								var1.g(var17);
							}
						} else if (var17.getY() >= 0 && !var1.p(var17.b()).getBlock().r().isBuildable()) {
							var1.g(var17);
						} else if (var1.p(var17).getBlock().r().isBuildable() && var1.p(var17).getBlock() != Blocks.ae) {
							if (var15 == -1 && var2.nextInt(4) != 0) {
								var1.a(var17, Blocks.MOSSY_COBBLESTONE.P(), 2);
							} else {
								var1.a(var17, Blocks.COBBLESTONE.P(), 2);
							}
						}
					}
				}
			}

			var14 = 0;

			while (var14 < 2) {
				var15 = 0;

				while (true) {
					if (var15 < 3) {
						label197: {
							var16 = var3.getX() + var2.nextInt(var5 * 2 + 1) - var5;
							int var24 = var3.getY();
							int var25 = var3.getZ() + var2.nextInt(var10 * 2 + 1) - var10;
							Position var26 = new Position(var16, var24, var25);
							if (var1.d(var26)) {
								int var20 = 0;
								Iterator var21 = en.a.iterator();

								while (var21.hasNext()) {
									PaintingDirection var22 = (PaintingDirection) var21.next();
									if (var1.p(var26.a(var22)).getBlock().r().isBuildable()) {
										++var20;
									}
								}

								if (var20 == 1) {
									var1.a(var26, Blocks.ae.f(var1, var26, Blocks.ae.P()), 2);
									List var27 = vl.a(c, new vl[] { Items.cd.b(var2) });
									TileEntity var28 = var1.s(var26);
									if (var28 instanceof TileEntityChest) {
										vl.a(var2, var27, (IInventory) ((TileEntityChest) var28), 8);
									}
									break label197;
								}
							}

							++var15;
							continue;
						}
					}

					++var14;
					break;
				}
			}

			var1.a(var3, Blocks.ac.P(), 2);
			TileEntity var23 = var1.s(var3);
			if (var23 instanceof TileEntityMobSpawner) {
				((TileEntityMobSpawner) var23).b().a(this.a(var2));
			} else {
				a.error("Failed to fetch mob spawner entity at (" + var3.getX() + ", " + var3.getY() + ", " + var3.getZ() + ")");
			}

			return true;
		} else {
			return false;
		}
	}

	private String a(Random var1) {
		return b[var1.nextInt(b.length)];
	}

}
