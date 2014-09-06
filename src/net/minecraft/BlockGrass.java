package net.minecraft;

import java.util.Random;

public class BlockGrass extends Block implements atz {

	public static final bet a = bet.a("snowy");

	protected BlockGrass() {
		super(Material.GRASS);
		this.j(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(true);
		this.a(CreativeModeTab.b);
	}

	public bec a(bec var1, ard var2, Position var3) {
		Block var4 = var2.p(var3.a()).getBlock();
		return var1.a(a, Boolean.valueOf(var4 == aty.aJ || var4 == aty.aH));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D) {
			if (var1.l(var2.a()) < 4 && var1.p(var2.a()).getBlock().n() > 2) {
				var1.a(var2, aty.d.P());
			} else {
				if (var1.l(var2.a()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						Position var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						Block var7 = var1.p(var6.a()).getBlock();
						bec var8 = var1.p(var6);
						if (var8.getBlock() == aty.d && var8.b(BlockDirt.a) == avd.a && var1.l(var6.a()) >= 4 && var7.n() <= 2) {
							var1.a(var6, aty.c.P());
						}
					}
				}

			}
		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return aty.d.a(aty.d.P().a(BlockDirt.a, avd.a), var2, var3);
	}

	public boolean a(World var1, Position var2, bec var3, boolean var4) {
		return true;
	}

	public boolean a(World var1, Random var2, Position var3, bec var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, bec var4) {
		Position var5 = var3.a();
		int var6 = 0;

		while (var6 < 128) {
			Position var7 = var5;
			int var8 = 0;

			while (true) {
				if (var8 < var6 / 16) {
					var7 = var7.a(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
					if (var1.p(var7.b()).getBlock() == aty.c && !var1.p(var7).getBlock().t()) {
						++var8;
						continue;
					}
				} else if (var1.p(var7).getBlock().material == Material.AIR) {
					if (var2.nextInt(8) == 0) {
						awa var11 = var1.b(var7).a(var2, var7);
						avy var9 = var11.a().a();
						bec var10 = var9.P().a(var9.l(), var11);
						if (var9.f(var1, var7, var10)) {
							var1.a(var7, var10, 3);
						}
					} else {
						bec var12 = aty.H.P().a(BlockLongGrass.a, bbi.b);
						if (aty.H.f(var1, var7, var12)) {
							var1.a(var7, var12, 3);
						}
					}
				}

				++var6;
				break;
			}
		}

	}

	public int c(bec var1) {
		return 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
