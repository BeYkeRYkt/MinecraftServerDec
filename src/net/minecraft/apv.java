package net.minecraft;

import java.util.Random;

public class apv extends apf {

	public apv(int var1, BlockNameInfo var2, int var3) {
		super(var1, var2, var3, apg.e);
		this.c("thorns");
	}

	public int a(int var1) {
		return 10 + 20 * (var1 - 1);
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int b() {
		return 3;
	}

	public boolean a(ItemStack var1) {
		return var1.getItem() instanceof ajn ? true : super.a(var1);
	}

	public void b(EntityLiving var1, Entity var2, int var3) {
		Random var4 = var1.bb();
		ItemStack var5 = aph.a(apf.j, var1);
		if (a(var3, var4)) {
			var2.a(wh.a((Entity) var1), (float) b(var3, var4));
			var2.a("damage.thorns", 0.5F, 1.0F);
			if (var5 != null) {
				var5.a(3, var1);
			}
		} else if (var5 != null) {
			var5.a(1, var1);
		}

	}

	public static boolean a(int var0, Random var1) {
		return var0 <= 0 ? false : var1.nextFloat() < 0.15F * (float) var0;
	}

	public static int b(int var0, Random var1) {
		return var0 > 10 ? var0 - 10 : 1 + var1.nextInt(4);
	}
}
