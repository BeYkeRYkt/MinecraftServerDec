package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class WorldGenTaigaStructure extends WorldGenerator {

	private final Block a;
	private final int b;

	public WorldGenTaigaStructure(Block var1, int var2) {
		super(false);
		this.a = var1;
		this.b = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		while (true) {
			if (var3.getY() > 3) {
				label47: {
					if (!var1.d(var3.getDown())) {
						Block var4 = var1.getBlockState(var3.getDown()).getBlock();
						if (var4 == Blocks.GRASS || var4 == Blocks.DIRT || var4 == Blocks.STONE) {
							break label47;
						}
					}

					var3 = var3.getDown();
					continue;
				}
			}

			if (var3.getY() <= 3) {
				return false;
			}

			int var12 = this.b;

			for (int var5 = 0; var12 >= 0 && var5 < 3; ++var5) {
				int var6 = var12 + var2.nextInt(2);
				int var7 = var12 + var2.nextInt(2);
				int var8 = var12 + var2.nextInt(2);
				float var9 = (float) (var6 + var7 + var8) * 0.333F + 0.5F;
				Iterator var10 = Position.a(var3.a(-var6, -var7, -var8), var3.a(var6, var7, var8)).iterator();

				while (var10.hasNext()) {
					Position var11 = (Position) var10.next();
					if (var11.i(var3) <= (double) (var9 * var9)) {
						var1.setBlockAt(var11, this.a.getBlockState(), 4);
					}
				}

				var3 = var3.a(-(var12 + 1) + var2.nextInt(2 + var12 * 2), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + var12 * 2));
			}

			return true;
		}
	}
}
