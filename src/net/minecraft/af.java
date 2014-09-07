package net.minecraft;

public class af {

	private static final int a = ag.values().length;
	private static final String[] b = new String[a];
	private String[] c;
	private String[] d;

	public af() {
		this.c = b;
		this.d = b;
	}

	public void a(CommandSenderInterface var1, ag var2, int var3) {
		String var4 = this.c[var2.a()];
		if (var4 != null) {
			String var5;
			try {
				var5 = AbstractCommand.e(var1, var4);
			} catch (dj var10) {
				return;
			}

			String var6 = this.d[var2.a()];
			if (var6 != null) {
				Scoreboard var7 = var1.e().Z();
				ScoreboardObjective var8 = var7.b(var6);
				if (var8 != null) {
					if (var7.b(var5, var8)) {
						ScoreboardScore var9 = var7.c(var5, var8);
						var9.setScore(var3);
					}
				}
			}
		}
	}

	public void a(NBTCompoundTag var1) {
		if (var1.isTagAssignableFrom("CommandStats", 10)) {
			NBTCompoundTag var2 = var1.getCompound("CommandStats");
			ag[] var3 = ag.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				ag var6 = var3[var5];
				String var7 = var6.b() + "Name";
				String var8 = var6.b() + "Objective";
				if (var2.isTagAssignableFrom(var7, 8) && var2.isTagAssignableFrom(var8, 8)) {
					String var9 = var2.getString(var7);
					String var10 = var2.getString(var8);
					a(this, var6, var9, var10);
				}
			}

		}
	}

	public void b(NBTCompoundTag var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		ag[] var3 = ag.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			ag var6 = var3[var5];
			String var7 = this.c[var6.a()];
			String var8 = this.d[var6.a()];
			if (var7 != null && var8 != null) {
				var2.put(var6.b() + "Name", var7);
				var2.put(var6.b() + "Objective", var8);
			}
		}

		if (!var2.isEmpty()) {
			var1.put("CommandStats", (NBTTag) var2);
		}

	}

	public static void a(af var0, ag var1, String var2, String var3) {
		if (var2 != null && var2.length() != 0 && var3 != null && var3.length() != 0) {
			if (var0.c == b || var0.d == b) {
				var0.c = new String[a];
				var0.d = new String[a];
			}

			var0.c[var1.a()] = var2;
			var0.d[var1.a()] = var3;
		} else {
			a(var0, var1);
		}
	}

	private static void a(af var0, ag var1) {
		if (var0.c != b && var0.d != b) {
			var0.c[var1.a()] = null;
			var0.d[var1.a()] = null;
			boolean var2 = true;
			ag[] var3 = ag.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				ag var6 = var3[var5];
				if (var0.c[var6.a()] != null && var0.d[var6.a()] != null) {
					var2 = false;
					break;
				}
			}

			if (var2) {
				var0.c = b;
				var0.d = b;
			}

		}
	}

	public void a(af var1) {
		ag[] var2 = ag.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ag var5 = var2[var4];
			a(this, var5, var1.c[var5.a()], var1.d[var5.a()]);
		}

	}

}
