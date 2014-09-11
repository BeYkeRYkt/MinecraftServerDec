package net.minecraft;

import java.util.Random;

public class bhq extends WorldGenerator {

	private BlockFlowers a;
	private BlockState b;

	public bhq(BlockFlowers var1, EnumFlowerType var2) {
		this.a(var1, var2);
	}

	public void a(BlockFlowers var1, EnumFlowerType var2) {
		this.a = var1;
		this.b = var1.getBlockState().a(var1.l(), var2);
	}

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (!var1.worldProvider.noSkyLight() || var5.getY() < 255) && this.a.f(var1, var5, this.b)) {
				var1.a(var5, this.b, 2);
			}
		}

		return true;
	}
}
