package net.minecraft;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class ReplaceItemCommand extends AbstractCommand {

	private static final Map a = Maps.newHashMap();

	public String getName() {
		return "replaceitem";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.replaceitem.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 1) {
			throw new dp("commands.replaceitem.usage", new Object[0]);
		} else {
			boolean var3;
			if (var2[0].equals("entity")) {
				var3 = false;
			} else {
				if (!var2[0].equals("block")) {
					throw new dp("commands.replaceitem.usage", new Object[0]);
				}

				var3 = true;
			}

			byte var4;
			if (var3) {
				if (var2.length < 6) {
					throw new dp("commands.replaceitem.block.usage", new Object[0]);
				}

				var4 = 4;
			} else {
				if (var2.length < 4) {
					throw new dp("commands.replaceitem.entity.usage", new Object[0]);
				}

				var4 = 2;
			}

			int var16 = var4 + 1;
			int var5 = this.e(var2[var4]);

			Item var6;
			try {
				var6 = f(var1, var2[var16]);
			} catch (dk var15) {
				if (Block.getBlockByName(var2[var16]) != Blocks.AIR) {
					throw var15;
				}

				var6 = null;
			}

			++var16;
			int var7 = var2.length > var16 ? a(var2[var16++], 1, 64) : 1;
			int var8 = var2.length > var16 ? a(var2[var16++]) : 0;
			ItemStack var9 = new ItemStack(var6, var7, var8);
			if (var2.length > var16) {
				String var10 = a(var1, var2, var16).getJsonMessage();

				try {
					var9.setTag(gg.a(var10));
				} catch (gf var14) {
					throw new di("commands.replaceitem.tagError", new Object[] { var14.getMessage() });
				}
			}

			if (var9.getItem() == null) {
				var9 = null;
			}

			if (var3) {
				var1.a(ag.d, 0);
				Position var17 = a(var1, var2, 1, false);
				World var11 = var1.getWorld();
				TileEntity var12 = var11.getTileEntity(var17);
				if (var12 == null || !(var12 instanceof IInventory)) {
					throw new di("commands.replaceitem.noContainer", new Object[] { Integer.valueOf(var17.getX()), Integer.valueOf(var17.getY()), Integer.valueOf(var17.getZ()) });
				}

				IInventory var13 = (IInventory) var12;
				if (var5 >= 0 && var5 < var13.getSize()) {
					var13.setItem(var5, var9);
				}
			} else {
				Entity var18 = b(var1, var2[1]);
				var1.a(ag.d, 0);
				if (var18 instanceof EntityHuman) {
					((EntityHuman) var18).defaultContainer.b();
				}

				if (!var18.d(var5, var9)) {
					throw new di("commands.replaceitem.failed", new Object[] { Integer.valueOf(var5), Integer.valueOf(var7), var9 == null ? "Air" : var9.C() });
				}

				if (var18 instanceof EntityHuman) {
					((EntityHuman) var18).defaultContainer.b();
				}
			}

			var1.a(ag.d, var7);
			a(var1, this, "commands.replaceitem.success", new Object[] { Integer.valueOf(var5), Integer.valueOf(var7), var9 == null ? "Air" : var9.C() });
		}
	}

	private int e(String var1) throws di {
		if (!a.containsKey(var1)) {
			throw new di("commands.generic.parameter.invalid", new Object[] { var1 });
		} else {
			return ((Integer) a.get(var1)).intValue();
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, new String[] { "entity", "block" }) : (var2.length == 2 && var2[0].equals("entity") ? a(var2, this.d()) : ((var2.length != 3 || !var2[0].equals("entity")) && (var2.length != 5 || !var2[0].equals("block")) ? ((var2.length != 4 || !var2[0].equals("entity")) && (var2.length != 6 || !var2[0].equals("block")) ? null : a(var2, Item.REGISTRY.c())) : a(var2, a.keySet())));
	}

	protected String[] d() {
		return MinecraftServer.getInstance().I();
	}

	public boolean b(String[] var1, int var2) {
		return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
	}

	static {
		int var0;
		for (var0 = 0; var0 < 54; ++var0) {
			a.put("slot.container." + var0, Integer.valueOf(var0));
		}

		for (var0 = 0; var0 < 9; ++var0) {
			a.put("slot.hotbar." + var0, Integer.valueOf(var0));
		}

		for (var0 = 0; var0 < 27; ++var0) {
			a.put("slot.inventory." + var0, Integer.valueOf(9 + var0));
		}

		for (var0 = 0; var0 < 27; ++var0) {
			a.put("slot.enderchest." + var0, Integer.valueOf(200 + var0));
		}

		for (var0 = 0; var0 < 8; ++var0) {
			a.put("slot.villager." + var0, Integer.valueOf(300 + var0));
		}

		for (var0 = 0; var0 < 15; ++var0) {
			a.put("slot.horse." + var0, Integer.valueOf(500 + var0));
		}

		a.put("slot.weapon", Integer.valueOf(99));
		a.put("slot.armor.head", Integer.valueOf(103));
		a.put("slot.armor.chest", Integer.valueOf(102));
		a.put("slot.armor.legs", Integer.valueOf(101));
		a.put("slot.armor.feet", Integer.valueOf(100));
		a.put("slot.horse.saddle", Integer.valueOf(400));
		a.put("slot.horse.armor", Integer.valueOf(401));
		a.put("slot.horse.chest", Integer.valueOf(499));
	}
}
