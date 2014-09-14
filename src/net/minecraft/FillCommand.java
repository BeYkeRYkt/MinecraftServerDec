package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FillCommand extends AbstractCommand {

	public String getName() {
		return "fill";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.fill.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 7) {
			throw new dp("commands.fill.usage", new Object[0]);
		} else {
			var1.a(ag.b, 0);
			Position var3 = a(var1, var2, 0, false);
			Position var4 = a(var1, var2, 3, false);
			Block var5 = AbstractCommand.g(var1, var2[6]);
			int var6 = 0;
			if (var2.length >= 8) {
				var6 = a(var2[7], 0, 15);
			}

			Position var7 = new Position(Math.min(var3.getX(), var4.getX()), Math.min(var3.getY(), var4.getY()), Math.min(var3.getZ(), var4.getZ()));
			Position var8 = new Position(Math.max(var3.getX(), var4.getX()), Math.max(var3.getY(), var4.getY()), Math.max(var3.getZ(), var4.getZ()));
			int var9 = (var8.getX() - var7.getX() + 1) * (var8.getY() - var7.getY() + 1) * (var8.getZ() - var7.getZ() + 1);
			if (var9 > '\u8000') {
				throw new di("commands.fill.tooManyBlocks", new Object[] { Integer.valueOf(var9), Integer.valueOf('\u8000') });
			} else if (var7.getY() >= 0 && var8.getY() < 256) {
				World var10 = var1.getPrimaryWorld();

				for (int var11 = var7.getZ(); var11 < var8.getZ() + 16; var11 += 16) {
					for (int var12 = var7.getX(); var12 < var8.getX() + 16; var12 += 16) {
						if (!var10.isLoaded(new Position(var12, var8.getY() - var7.getY(), var11))) {
							throw new di("commands.fill.outOfWorld", new Object[0]);
						}
					}
				}

				NBTCompoundTag var22 = new NBTCompoundTag();
				boolean var23 = false;
				if (var2.length >= 10 && var5.x()) {
					String var13 = a(var1, var2, 9).getStrippedMessage();

					try {
						var22 = gg.a(var13);
						var23 = true;
					} catch (gf var21) {
						throw new di("commands.fill.tagError", new Object[] { var21.getMessage() });
					}
				}

				ArrayList var24 = Lists.newArrayList();
				var9 = 0;

				for (int var14 = var7.getZ(); var14 <= var8.getZ(); ++var14) {
					for (int var15 = var7.getY(); var15 <= var8.getY(); ++var15) {
						for (int var16 = var7.getX(); var16 <= var8.getX(); ++var16) {
							Position var17 = new Position(var16, var15, var14);
							IBlockState var19;
							if (var2.length >= 9) {
								if (!var2[8].equals("outline") && !var2[8].equals("hollow")) {
									if (var2[8].equals("destroy")) {
										var10.b(var17, true);
									} else if (var2[8].equals("keep")) {
										if (!var10.d(var17)) {
											continue;
										}
									} else if (var2[8].equals("replace") && !var5.x()) {
										if (var2.length > 9) {
											Block var18 = AbstractCommand.g(var1, var2[9]);
											if (var10.getBlockState(var17).getBlock() != var18) {
												continue;
											}
										}

										if (var2.length > 10) {
											int var28 = AbstractCommand.a(var2[10]);
											var19 = var10.getBlockState(var17);
											if (var19.getBlock().getData(var19) != var28) {
												continue;
											}
										}
									}
								} else if (var16 != var7.getX() && var16 != var8.getX() && var15 != var7.getY() && var15 != var8.getY() && var14 != var7.getZ() && var14 != var8.getZ()) {
									if (var2[8].equals("hollow")) {
										var10.setBlockAt(var17, Blocks.AIR.getBlockState(), 2);
										var24.add(var17);
									}
									continue;
								}
							}

							TileEntity var29 = var10.getTileEntity(var17);
							if (var29 != null) {
								if (var29 instanceof IInventory) {
									((IInventory) var29).l();
								}

								var10.setBlockAt(var17, Blocks.BARRIER.getBlockState(), var5 == Blocks.BARRIER ? 2 : 4);
							}

							var19 = var5.setData(var6);
							if (var10.setBlockAt(var17, var19, 2)) {
								var24.add(var17);
								++var9;
								if (var23) {
									TileEntity var20 = var10.getTileEntity(var17);
									if (var20 != null) {
										var22.put("x", var17.getX());
										var22.put("y", var17.getY());
										var22.put("z", var17.getZ());
										var20.read(var22);
									}
								}
							}
						}
					}
				}

				Iterator var25 = var24.iterator();

				while (var25.hasNext()) {
					Position var26 = (Position) var25.next();
					Block var27 = var10.getBlockState(var26).getBlock();
					var10.b(var26, var27);
				}

				if (var9 <= 0) {
					throw new di("commands.fill.failed", new Object[0]);
				} else {
					var1.a(ag.b, var9);
					a(var1, this, "commands.fill.success", new Object[] { Integer.valueOf(var9) });
				}
			} else {
				throw new di("commands.fill.outOfWorld", new Object[0]);
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : (var2.length > 3 && var2.length <= 6 ? a(var2, 3, var3) : (var2.length == 7 ? a(var2, Block.BLOCKREGISTRY.c()) : (var2.length == 9 ? a(var2, new String[] { "replace", "destroy", "keep", "hollow", "outline" }) : null)));
	}
}
