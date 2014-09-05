package net.minecraft;

public class alg extends Item {

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, ej var5, float var6, float var7, float var8) {
		if (!var3.D) {
			ahm var9 = new ahm(var3, (double) ((float) var4.n() + var6), (double) ((float) var4.o() + var7), (double) ((float) var4.p() + var8), var1);
			var3.d((Entity) var9);
			if (!var2.by.instabuild) {
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}
}
