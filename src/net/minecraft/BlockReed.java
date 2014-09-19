package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class BlockReed extends Block {

	public static final bew a = bew.a("age", 0, 15);

	protected BlockReed() {
		super(Material.PLANT);
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
		float var1 = 0.375F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
		this.a(true);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (var1.getBlockState(var2.getDown()).getBlock() == Blocks.REEDS || this.e(var1, var2, var3)) {
			if (var1.d(var2.getUp())) {
				int var5;
				for (var5 = 1; var1.getBlockState(var2.c(var5)).getBlock() == this; ++var5) {
					;
				}

				if (var5 < 3) {
					int var6 = ((Integer) var3.b(a)).intValue();
					if (var6 == 15) {
						var1.a(var2.getUp(), this.getBlockState());
						var1.setBlockAt(var2, var3.a(a, Integer.valueOf(0)), 4);
					} else {
						var1.setBlockAt(var2, var3.a(a, Integer.valueOf(var6 + 1)), 4);
					}
				}
			}

		}
	}

	public boolean c(World var1, Position var2) {
		Block var3 = var1.getBlockState(var2.getDown()).getBlock();
		if (var3 == this) {
			return true;
		} else if (var3 != Blocks.GRASS && var3 != Blocks.DIRT && var3 != Blocks.SAND) {
			return false;
		} else {
			Iterator var4 = UniverseDirection.HORIZONTAL.iterator();

			BlockFace var5;
			do {
				if (!var4.hasNext()) {
					return false;
				}

				var5 = (BlockFace) var4.next();
			} while (var1.getBlockState(var2.getRelative(var5).getDown()).getBlock().getMaterial() != Material.WATER);

			return true;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		this.e(var1, var2, var3);
	}

	protected final boolean e(World var1, Position var2, IBlockState var3) {
		if (this.d(var1, var2)) {
			return true;
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		}
	}

	public boolean d(World var1, Position var2) {
		return this.c(var1, var2);
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return null;
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Items.REEDS;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
