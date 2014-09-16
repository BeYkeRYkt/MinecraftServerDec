package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CloneCommand extends AbstractCommand {

	public String getName() {
		return "clone";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.clone.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 9) {
			throw new dp("commands.clone.usage", new Object[0]);
		} else {
			var1.a(ag.b, 0);
			Position var3 = a(var1, var2, 0, false);
			Position var4 = a(var1, var2, 3, false);
			Position var5 = a(var1, var2, 6, false);
			CuboidArea var6 = new CuboidArea(var3, var4);
			CuboidArea var7 = new CuboidArea(var5, var5.a(var6.b()));
			int var8 = var6.c() * var6.d() * var6.e();
			if (var8 > '\u8000') {
				throw new di("commands.clone.tooManyBlocks", new Object[] { Integer.valueOf(var8), Integer.valueOf('\u8000') });
			} else {
				boolean var9 = false;
				Block var10 = null;
				int var11 = -1;
				if ((var2.length < 11 || !var2[10].equals("force") && !var2[10].equals("move")) && var6.a(var7)) {
					throw new di("commands.clone.noOverlap", new Object[0]);
				} else {
					if (var2.length >= 11 && var2[10].equals("move")) {
						var9 = true;
					}

					if (var6.minY >= 0 && var6.maxY < 256 && var7.minY >= 0 && var7.maxY < 256) {
						World var12 = var1.getWorld();
						if (var12.a(var6) && var12.a(var7)) {
							boolean var13 = false;
							if (var2.length >= 10) {
								if (var2[9].equals("masked")) {
									var13 = true;
								} else if (var2[9].equals("filtered")) {
									if (var2.length < 12) {
										throw new dp("commands.clone.usage", new Object[0]);
									}

									var10 = g(var1, var2[11]);
									if (var2.length >= 13) {
										var11 = a(var2[12], 0, 15);
									}
								}
							}

							ArrayList var14 = Lists.newArrayList();
							ArrayList var15 = Lists.newArrayList();
							ArrayList var16 = Lists.newArrayList();
							LinkedList var17 = Lists.newLinkedList();
							Position var18 = new Position(var7.minX - var6.minX, var7.minY - var6.minY, var7.minZ - var6.minZ);

							for (int var19 = var6.minZ; var19 <= var6.maxZ; ++var19) {
								for (int var20 = var6.minY; var20 <= var6.maxY; ++var20) {
									for (int var21 = var6.minX; var21 <= var6.maxX; ++var21) {
										Position var22 = new Position(var21, var20, var19);
										Position var23 = var22.a((fd) var18);
										IBlockState var24 = var12.getBlockState(var22);
										if ((!var13 || var24.getBlock() != Blocks.AIR) && (var10 == null || var24.getBlock() == var10 && (var11 < 0 || var24.getBlock().getData(var24) == var11))) {
											TileEntity var25 = var12.getTileEntity(var22);
											if (var25 != null) {
												NBTCompoundTag var26 = new NBTCompoundTag();
												var25.write(var26);
												var15.add(new bb(var23, var24, var26));
												var17.addLast(var22);
											} else if (!var24.getBlock().m() && !var24.getBlock().d()) {
												var16.add(new bb(var23, var24, (NBTCompoundTag) null));
												var17.addFirst(var22);
											} else {
												var14.add(new bb(var23, var24, (NBTCompoundTag) null));
												var17.addLast(var22);
											}
										}
									}
								}
							}

							if (var9) {
								Iterator var27;
								Position var29;
								for (var27 = var17.iterator(); var27.hasNext(); var12.setBlockAt(var29, Blocks.BARRIER.getBlockState(), 2)) {
									var29 = (Position) var27.next();
									TileEntity var31 = var12.getTileEntity(var29);
									if (var31 instanceof IInventory) {
										((IInventory) var31).clearInventory();
									}
								}

								var27 = var17.iterator();

								while (var27.hasNext()) {
									var29 = (Position) var27.next();
									var12.setBlockAt(var29, Blocks.AIR.getBlockState(), 3);
								}
							}

							ArrayList var28 = Lists.newArrayList();
							var28.addAll(var14);
							var28.addAll(var15);
							var28.addAll(var16);
							List var30 = Lists.reverse(var28);

							Iterator var32;
							bb var34;
							TileEntity var36;
							for (var32 = var30.iterator(); var32.hasNext(); var12.setBlockAt(var34.a, Blocks.BARRIER.getBlockState(), 2)) {
								var34 = (bb) var32.next();
								var36 = var12.getTileEntity(var34.a);
								if (var36 instanceof IInventory) {
									((IInventory) var36).clearInventory();
								}
							}

							var8 = 0;
							var32 = var28.iterator();

							while (var32.hasNext()) {
								var34 = (bb) var32.next();
								if (var12.setBlockAt(var34.a, var34.b, 2)) {
									++var8;
								}
							}

							for (var32 = var15.iterator(); var32.hasNext(); var12.setBlockAt(var34.a, var34.b, 2)) {
								var34 = (bb) var32.next();
								var36 = var12.getTileEntity(var34.a);
								if (var34.c != null && var36 != null) {
									var34.c.put("x", var34.a.getX());
									var34.c.put("y", var34.a.getY());
									var34.c.put("z", var34.a.getZ());
									var36.read(var34.c);
									var36.update();
								}
							}

							var32 = var30.iterator();

							while (var32.hasNext()) {
								var34 = (bb) var32.next();
								var12.b(var34.a, var34.b.getBlock());
							}

							List var33 = var12.getNextTickList(var6, false);
							if (var33 != null) {
								Iterator var35 = var33.iterator();

								while (var35.hasNext()) {
									NextTickListEntry var37 = (NextTickListEntry) var35.next();
									if (var6.b((fd) var37.position)) {
										Position var38 = var37.position.a((fd) var18);
										var12.addNextTickEntry(var38, var37.getBlock(), (int) (var37.b - var12.getWorldData().getTime()), var37.c);
									}
								}
							}

							if (var8 <= 0) {
								throw new di("commands.clone.failed", new Object[0]);
							} else {
								var1.a(ag.b, var8);
								a(var1, this, "commands.clone.success", new Object[] { Integer.valueOf(var8) });
							}
						} else {
							throw new di("commands.clone.outOfWorld", new Object[0]);
						}
					} else {
						throw new di("commands.clone.outOfWorld", new Object[0]);
					}
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : (var2.length > 3 && var2.length <= 6 ? a(var2, 3, var3) : (var2.length > 6 && var2.length <= 9 ? a(var2, 6, var3) : (var2.length == 10 ? a(var2, new String[] { "replace", "masked", "filtered" }) : (var2.length == 11 ? a(var2, new String[] { "normal", "force", "move" }) : (var2.length == 12 && "filtered".equals(var2[9]) ? a(var2, Block.BLOCKREGISTRY.c()) : null)))));
	}
}
