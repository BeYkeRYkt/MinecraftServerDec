package net.minecraft;

public class aoc {

	void a(aop var1) {
		akv[] var2 = akv.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			akv var5 = var2[var4];
			var1.a(new ItemStack(Items.cE, 1, var5.b()), new Object[] { "###", "###", " | ", Character.valueOf('#'), new ItemStack(Blocks.WOOL, 1, var5.a()), Character.valueOf('|'), Items.y });
		}

		var1.a(new aof((aod) null));
		var1.a(new aoe((aod) null));
	}
}
