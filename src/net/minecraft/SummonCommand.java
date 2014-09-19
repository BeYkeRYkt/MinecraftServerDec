package net.minecraft;

import java.util.List;

public class SummonCommand extends AbstractCommand {

	public String getName() {
		return "summon";
	}

	public int a() {
		return 2;
	}

	public String getUsage(CommandSenderInterface var1) {
		return "commands.summon.usage";
	}

	public void executeCommand(CommandSenderInterface var1, String[] var2) throws di {
		if (var2.length < 1) {
			throw new dp("commands.summon.usage", new Object[0]);
		} else {
			String var3 = var2[0];
			Position var4 = var1.getEntityPosition();
			Vec3D var5 = var1.getCenter();
			double var6 = var5.x;
			double var8 = var5.y;
			double var10 = var5.z;
			if (var2.length >= 4) {
				var6 = b(var6, var2[1], true);
				var8 = b(var8, var2[2], false);
				var10 = b(var10, var2[3], true);
				var4 = new Position(var6, var8, var10);
			}

			World var12 = var1.getWorld();
			if (!var12.isLoaded(var4)) {
				throw new di("commands.summon.outOfWorld", new Object[0]);
			} else if ("LightningBolt".equals(var3)) {
				var12.c((Entity) (new EntityLightning(var12, var6, var8, var10)));
				a(var1, this, "commands.summon.success", new Object[0]);
			} else {
				NBTCompoundTag var13 = new NBTCompoundTag();
				boolean var14 = false;
				if (var2.length >= 5) {
					IChatBaseComponent var15 = a(var1, var2, 4);

					try {
						var13 = gg.a(var15.getJsonMessage());
						var14 = true;
					} catch (gf var20) {
						throw new di("commands.summon.tagError", new Object[] { var20.getMessage() });
					}
				}

				var13.put("id", var3);

				Entity var21;
				try {
					var21 = EntityTypes.loadEntity(var13, var12);
				} catch (RuntimeException var19) {
					throw new di("commands.summon.failed", new Object[0]);
				}

				if (var21 == null) {
					throw new di("commands.summon.failed", new Object[0]);
				} else {
					var21.setPositionRotation(var6, var8, var10, var21.yaw, var21.pitch);
					if (!var14 && var21 instanceof EntityInsentient) {
						((EntityInsentient) var21).a(var12.E(new Position(var21)), (xq) null);
					}

					var12.addEntity(var21);
					Entity var16 = var21;

					for (NBTCompoundTag var17 = var13; var16 != null && var17.isTagAssignableFrom("Riding", 10); var17 = var17.getCompound("Riding")) {
						Entity var18 = EntityTypes.loadEntity(var17.getCompound("Riding"), var12);
						if (var18 != null) {
							var18.setPositionRotation(var6, var8, var10, var18.yaw, var18.pitch);
							var12.addEntity(var18);
							var16.mount(var18);
						}

						var16 = var18;
					}

					a(var1, this, "commands.summon.success", new Object[0]);
				}
			}
		}
	}

	public List getTabCompleteList(CommandSenderInterface var1, String[] var2, Position var3) {
		return var2.length == 1 ? a(var2, EntityTypes.getNonAbstractEntityNames()) : (var2.length > 1 && var2.length <= 4 ? a(var2, 1, var3) : null);
	}
}
