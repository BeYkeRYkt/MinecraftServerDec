package net.minecraft;

import java.util.List;

public class TestforBlocksCommand extends AbstractCommand {

	public String getName() {
		return "testforblocks";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.compare.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 9) {
			throw new dp("commands.compare.usage", new Object[0]);
		} else {
			var1.a(ag.b, 0);
			Position var3 = a(var1, var2, 0, false);
			Position var4 = a(var1, var2, 3, false);
			Position var5 = a(var1, var2, 6, false);
			CuboidArea var6 = new CuboidArea(var3, var4);
			CuboidArea var7 = new CuboidArea(var5, var5.a(var6.b()));
			int var8 = var6.c() * var6.d() * var6.e();
			if (var8 > 524288) {
				throw new di("commands.compare.tooManyBlocks", new Object[] { Integer.valueOf(var8), Integer.valueOf(524288) });
			} else if (var6.minY >= 0 && var6.maxY < 256 && var7.minY >= 0 && var7.maxY < 256) {
				World var9 = var1.getWorld();
				if (var9.a(var6) && var9.a(var7)) {
					boolean var10 = false;
					if (var2.length > 9 && var2[9].equals("masked")) {
						var10 = true;
					}

					var8 = 0;
					Position var11 = new Position(var7.minX - var6.minX, var7.minY - var6.minY, var7.minZ - var6.minZ);

					for (int var12 = var6.minZ; var12 <= var6.maxZ; ++var12) {
						for (int var13 = var6.minY; var13 <= var6.maxY; ++var13) {
							for (int var14 = var6.minX; var14 <= var6.maxX; ++var14) {
								Position var15 = new Position(var14, var13, var12);
								Position var16 = var15.a((fd) var11);
								boolean var17 = false;
								BlockState var18 = var9.getBlockState(var15);
								if (!var10 || var18.getBlock() != Blocks.AIR) {
									if (var18 == var9.getBlockState(var16)) {
										TileEntity var19 = var9.getTileEntity(var15);
										TileEntity var20 = var9.getTileEntity(var16);
										if (var19 != null && var20 != null) {
											NBTCompoundTag var21 = new NBTCompoundTag();
											var19.write(var21);
											var21.remove("x");
											var21.remove("y");
											var21.remove("z");
											NBTCompoundTag var22 = new NBTCompoundTag();
											var20.write(var22);
											var22.remove("x");
											var22.remove("y");
											var22.remove("z");
											if (!var21.equals(var22)) {
												var17 = true;
											}
										} else if (var19 != null) {
											var17 = true;
										}
									} else {
										var17 = true;
									}

									++var8;
									if (var17) {
										throw new di("commands.compare.failed", new Object[0]);
									}
								}
							}
						}
					}

					var1.a(ag.b, var8);
					a(var1, this, "commands.compare.success", new Object[] { Integer.valueOf(var8) });
				} else {
					throw new di("commands.compare.outOfWorld", new Object[0]);
				}
			} else {
				throw new di("commands.compare.outOfWorld", new Object[0]);
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : (var2.length > 3 && var2.length <= 6 ? a(var2, 3, var3) : (var2.length > 6 && var2.length <= 9 ? a(var2, 6, var3) : (var2.length == 10 ? a(var2, new String[] { "masked", "all" }) : null)));
	}
}
