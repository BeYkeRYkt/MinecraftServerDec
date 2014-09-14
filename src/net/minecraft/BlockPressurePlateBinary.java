package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class BlockPressurePlateBinary extends ath {

	public static final bet a = bet.a("powered");
	private final azh b;

	protected BlockPressurePlateBinary(Material var1, azh var2) {
		super(var1);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
		this.b = var2;
	}

	protected int e(IBlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 15 : 0;
	}

	protected IBlockState a(IBlockState var1, int var2) {
		return var1.a(a, Boolean.valueOf(var2 > 0));
	}

	protected int e(World var1, Position var2) {
		AxisAlignedBB var3 = this.a(var2);
		List var4;
		switch (azg.a[this.b.ordinal()]) {
			case 1:
				var4 = var1.getEntities((Entity) null, var3);
				break;
			case 2:
				var4 = var1.a(EntityLiving.class, var3);
				break;
			default:
				return 0;
		}

		if (!var4.isEmpty()) {
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				Entity var6 = (Entity) var5.next();
				if (!var6.aH()) {
					return 15;
				}
			}
		}

		return 0;
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, Boolean.valueOf(var1 == 1));
	}

	public int getData(IBlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
