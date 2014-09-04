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
			dt var3 = a(var1, var2, 0, false);
			dt var4 = a(var1, var2, 3, false);
			dt var5 = a(var1, var2, 6, false);
			bjb var6 = new bjb(var3, var4);
			bjb var7 = new bjb(var5, var5.a(var6.b()));
			int var8 = var6.c() * var6.d() * var6.e();
			if (var8 > 524288) {
				throw new di("commands.compare.tooManyBlocks", new Object[] { Integer.valueOf(var8), Integer.valueOf(524288) });
			} else if (var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
				World var9 = var1.e();
				if (var9.a(var6) && var9.a(var7)) {
					boolean var10 = false;
					if (var2.length > 9 && var2[9].equals("masked")) {
						var10 = true;
					}

					var8 = 0;
					dt var11 = new dt(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

					for (int var12 = var6.c; var12 <= var6.f; ++var12) {
						for (int var13 = var6.b; var13 <= var6.e; ++var13) {
							for (int var14 = var6.a; var14 <= var6.d; ++var14) {
								dt var15 = new dt(var14, var13, var12);
								dt var16 = var15.a((fd) var11);
								boolean var17 = false;
								bec var18 = var9.p(var15);
								if (!var10 || var18.c() != aty.a) {
									if (var18 == var9.p(var16)) {
										bcm var19 = var9.s(var15);
										bcm var20 = var9.s(var16);
										if (var19 != null && var20 != null) {
											NBTCompoundTag var21 = new NBTCompoundTag();
											var19.b(var21);
											var21.o("x");
											var21.o("y");
											var21.o("z");
											NBTCompoundTag var22 = new NBTCompoundTag();
											var20.b(var22);
											var22.o("x");
											var22.o("y");
											var22.o("z");
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

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, dt var3) {
		return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : (var2.length > 3 && var2.length <= 6 ? a(var2, 3, var3) : (var2.length > 6 && var2.length <= 9 ? a(var2, 6, var3) : (var2.length == 10 ? a(var2, new String[] { "masked", "all" }) : null)));
	}
}
