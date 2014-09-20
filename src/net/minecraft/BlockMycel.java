package net.minecraft;

import java.util.Random;

public class BlockMycel extends Block {

	public static final bet a = bet.a("snowy");

	protected BlockMycel() {
		super(Material.GRASS);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(true);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		Block var4 = var2.getBlockState(var3.getUp()).getBlock();
		return var1.a(a, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (!var1.isStatic) {
			if (var1.getLightLevel(var2.getUp()) < 4 && var1.getBlockState(var2.getUp()).getBlock().n() > 2) {
				var1.a(var2, Blocks.DIRT.getBlockState().a(BlockDirt.a, avd.a));
			} else {
				if (var1.getLightLevel(var2.getUp()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						Position var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						IBlockState var7 = var1.getBlockState(var6);
						Block var8 = var1.getBlockState(var6.getUp()).getBlock();
						if (var7.getBlock() == Blocks.DIRT && var7.b(BlockDirt.a) == avd.a && var1.getLightLevel(var6.getUp()) >= 4 && var8.n() <= 2) {
							var1.a(var6, this.getBlockState());
						}
					}
				}

			}
		}
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Blocks.DIRT.getItemDrop(Blocks.DIRT.getBlockState().a(BlockDirt.a, avd.a), var2, var3);
	}

	public int getData(IBlockState var1) {
		return 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
