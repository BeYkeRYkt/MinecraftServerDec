package net.minecraft;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class WorldBorderCommand extends AbstractCommand {

	public String getName() {
		return "worldborder";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.worldborder.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws dp, dk {
		if (var2.length < 1) {
			throw new dp("commands.worldborder.usage", new Object[0]);
		} else {
			WorldBorder var3 = this.d();
			double var4;
			double var6;
			long var8;
			if (var2[0].equals("set")) {
				if (var2.length != 2 && var2.length != 3) {
					throw new dp("commands.worldborder.set.usage", new Object[0]);
				}

				var4 = var3.getCurrentRadius();
				var6 = a(var2[1], 1.0D, 6.0E7D);
				var8 = var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L;
				if (var8 > 0L) {
					var3.changeSize(var4, var6, var8);
					if (var4 > var6) {
						a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					} else {
						a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					}
				} else {
					var3.setSize(var6);
					a(var1, this, "commands.worldborder.set.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("add")) {
				if (var2.length != 2 && var2.length != 3) {
					throw new dp("commands.worldborder.add.usage", new Object[0]);
				}

				var4 = var3.getOldRadius();
				var6 = var4 + a(var2[1], -var4, 6.0E7D - var4);
				var8 = var3.getSpeed() + (var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L);
				if (var8 > 0L) {
					var3.changeSize(var4, var6, var8);
					if (var4 > var6) {
						a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					} else {
						a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					}
				} else {
					var3.setSize(var6);
					a(var1, this, "commands.worldborder.set.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("center")) {
				if (var2.length != 3) {
					throw new dp("commands.worldborder.center.usage", new Object[0]);
				}

				Position var10 = var1.getEntityPosition();
				double var5 = b((double) var10.getX() + 0.5D, var2[1], true);
				double var7 = b((double) var10.getZ() + 0.5D, var2[2], true);
				var3.setCenter(var5, var7);
				a(var1, this, "commands.worldborder.center.success", new Object[] { Double.valueOf(var5), Double.valueOf(var7) });
			} else if (var2[0].equals("damage")) {
				if (var2.length < 2) {
					throw new dp("commands.worldborder.damage.usage", new Object[0]);
				}

				if (var2[1].equals("buffer")) {
					if (var2.length != 3) {
						throw new dp("commands.worldborder.damage.buffer.usage", new Object[0]);
					}

					var4 = a(var2[2], 0.0D);
					var6 = var3.getDamageBuffer();
					var3.setDamageBuffer(var4);
					a(var1, this, "commands.worldborder.damage.buffer.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var4) }), String.format("%.1f", new Object[] { Double.valueOf(var6) }) });
				} else if (var2[1].equals("amount")) {
					if (var2.length != 3) {
						throw new dp("commands.worldborder.damage.amount.usage", new Object[0]);
					}

					var4 = a(var2[2], 0.0D);
					var6 = var3.getDamageAmount();
					var3.setDamageAmount(var4);
					a(var1, this, "commands.worldborder.damage.amount.success", new Object[] { String.format("%.2f", new Object[] { Double.valueOf(var4) }), String.format("%.2f", new Object[] { Double.valueOf(var6) }) });
				}
			} else if (var2[0].equals("warning")) {
				if (var2.length < 2) {
					throw new dp("commands.worldborder.warning.usage", new Object[0]);
				}

				int var11 = a(var2[2], 0);
				int var12;
				if (var2[1].equals("time")) {
					if (var2.length != 3) {
						throw new dp("commands.worldborder.warning.time.usage", new Object[0]);
					}

					var12 = var3.getWarningTime();
					var3.setWarningTime(var11);
					a(var1, this, "commands.worldborder.warning.time.success", new Object[] { Integer.valueOf(var11), Integer.valueOf(var12) });
				} else if (var2[1].equals("distance")) {
					if (var2.length != 3) {
						throw new dp("commands.worldborder.warning.distance.usage", new Object[0]);
					}

					var12 = var3.getWarningBlocks();
					var3.setWarningBlocks(var11);
					a(var1, this, "commands.worldborder.warning.distance.success", new Object[] { Integer.valueOf(var11), Integer.valueOf(var12) });
				}
			} else if (var2[0].equals("get")) {
				var4 = var3.getOldRadius();
				var1.a(ag.e, MathHelper.toFixedPointInt(var4 + 0.5D));
				var1.sendChatMessage(new ChatMessage("commands.worldborder.get.success", new Object[] { String.format("%.0f", new Object[] { Double.valueOf(var4) }) }));
			}

		}
	}

	protected WorldBorder d() {
		return MinecraftServer.getInstance().getWorld().getWorldBorder();
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "set", "center", "damage", "warning", "add", "get" }) : (var2.length == 2 && var2[0].equals("damage") ? a(var2, new String[] { "buffer", "amount" }) : (var2.length == 2 && var2[0].equals("warning") ? a(var2, new String[] { "time", "distance" }) : null));
	}
}
