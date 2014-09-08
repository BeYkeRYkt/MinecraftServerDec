package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class StatsCommand extends AbstractCommand {

	public String getName() {
		return "stats";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.stats.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 1) {
			throw new dp("commands.stats.usage", new Object[0]);
		} else {
			boolean var3;
			if (var2[0].equals("entity")) {
				var3 = false;
			} else {
				if (!var2[0].equals("block")) {
					throw new dp("commands.stats.usage", new Object[0]);
				}

				var3 = true;
			}

			byte var4;
			if (var3) {
				if (var2.length < 5) {
					throw new dp("commands.stats.block.usage", new Object[0]);
				}

				var4 = 4;
			} else {
				if (var2.length < 3) {
					throw new dp("commands.stats.entity.usage", new Object[0]);
				}

				var4 = 2;
			}

			int var11 = var4 + 1;
			String var5 = var2[var4];
			if ("set".equals(var5)) {
				if (var2.length < var11 + 3) {
					if (var11 == 5) {
						throw new dp("commands.stats.block.set.usage", new Object[0]);
					}

					throw new dp("commands.stats.entity.set.usage", new Object[0]);
				}
			} else {
				if (!"clear".equals(var5)) {
					throw new dp("commands.stats.usage", new Object[0]);
				}

				if (var2.length < var11 + 1) {
					if (var11 == 5) {
						throw new dp("commands.stats.block.clear.usage", new Object[0]);
					}

					throw new dp("commands.stats.entity.clear.usage", new Object[0]);
				}
			}

			ag var6 = ag.a(var2[var11++]);
			if (var6 == null) {
				throw new di("commands.stats.failed", new Object[0]);
			} else {
				World var7 = var1.e();
				af var8;
				Position var9;
				TileEntity var10;
				if (var3) {
					var9 = a(var1, var2, 1, false);
					var10 = var7.s(var9);
					if (var10 == null) {
						throw new di("commands.stats.noCompatibleBlock", new Object[] { Integer.valueOf(var9.getX()), Integer.valueOf(var9.getY()), Integer.valueOf(var9.getZ()) });
					}

					if (var10 instanceof TileEntityCommand) {
						var8 = ((TileEntityCommand) var10).c();
					} else {
						if (!(var10 instanceof TileEntitySign)) {
							throw new di("commands.stats.noCompatibleBlock", new Object[] { Integer.valueOf(var9.getX()), Integer.valueOf(var9.getY()), Integer.valueOf(var9.getZ()) });
						}

						var8 = ((TileEntitySign) var10).d();
					}
				} else {
					Entity var12 = b(var1, var2[1]);
					var8 = var12.aT();
				}

				if ("set".equals(var5)) {
					String var13 = var2[var11++];
					String var14 = var2[var11];
					if (var13.length() == 0 || var14.length() == 0) {
						throw new di("commands.stats.failed", new Object[0]);
					}

					af.a(var8, var6, var13, var14);
					a(var1, this, "commands.stats.success", new Object[] { var6.b(), var14, var13 });
				} else if ("clear".equals(var5)) {
					af.a(var8, var6, (String) null, (String) null);
					a(var1, this, "commands.stats.cleared", new Object[] { var6.b() });
				}

				if (var3) {
					var9 = a(var1, var2, 1, false);
					var10 = var7.s(var9);
					var10.o_();
				}

			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "entity", "block" }) : (var2.length == 2 && var2[0].equals("entity") ? a(var2, this.d()) : ((var2.length != 3 || !var2[0].equals("entity")) && (var2.length != 5 || !var2[0].equals("block")) ? ((var2.length != 4 || !var2[0].equals("entity")) && (var2.length != 6 || !var2[0].equals("block")) ? ((var2.length != 6 || !var2[0].equals("entity")) && (var2.length != 8 || !var2[0].equals("block")) ? null : a(var2, this.e())) : a(var2, ag.c()))
				: a(var2, new String[] { "set", "clear" })));
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	protected List e() {
		Collection var1 = MinecraftServer.getInstance().getWorldServer(0).Z().c();
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
			if (!var4.getCriteria().isReadOnly()) {
				var2.add(var4.getName());
			}
		}

		return var2;
	}

	public boolean b(String[] var1, int var2) {
		return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
	}
}
