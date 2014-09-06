package net.minecraft;

import java.util.List;
import java.util.Random;

public class bhh extends bhp {

	private final List a;
	private final int b;

	public bhh(List var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		Block var4;
		while (((var4 = var1.p(var3).getBlock()).r() == Material.AIR || var4.r() == Material.LEAVES) && var3.getY() > 1) {
			var3 = var3.b();
		}

		if (var3.getY() < 1) {
			return false;
		} else {
			var3 = var3.a();

			for (int var5 = 0; var5 < 4; ++var5) {
				Position var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
				if (var1.d(var6) && World.a((ard) var1, var6.b())) {
					var1.a(var6, aty.ae.P(), 2);
					TileEntity var7 = var1.s(var6);
					if (var7 instanceof TileEntityChest) {
						vl.a(var2, this.a, (IInventory) ((TileEntityChest) var7), this.b);
					}

					Position var8 = var6.f();
					Position var9 = var6.e();
					Position var10 = var6.c();
					Position var11 = var6.d();
					if (var1.d(var9) && World.a((ard) var1, var9.b())) {
						var1.a(var9, aty.aa.P(), 2);
					}

					if (var1.d(var8) && World.a((ard) var1, var8.b())) {
						var1.a(var8, aty.aa.P(), 2);
					}

					if (var1.d(var10) && World.a((ard) var1, var10.b())) {
						var1.a(var10, aty.aa.P(), 2);
					}

					if (var1.d(var11) && World.a((ard) var1, var11.b())) {
						var1.a(var11, aty.aa.P(), 2);
					}

					return true;
				}
			}

			return false;
		}
	}
}
