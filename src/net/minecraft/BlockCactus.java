package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class BlockCactus extends Block {

	public static final bew a = bew.a("age", 0, 15);

	protected BlockCactus() {
		super(Material.CACTUS);
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
		this.a(true);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		Position var5 = var2.a();
		if (var1.d(var5)) {
			int var6;
			for (var6 = 1; var1.getBlockState(var2.c(var6)).getBlock() == this; ++var6) {
				;
			}

			if (var6 < 3) {
				int var7 = ((Integer) var3.b(a)).intValue();
				if (var7 == 15) {
					var1.a(var5, this.getBlockState());
					IBlockState var8 = var3.a(a, Integer.valueOf(0));
					var1.setBlockAt(var2, var8, 4);
					this.a(var1, var5, var8, (Block) this);
				} else {
					var1.setBlockAt(var2, var3.a(a, Integer.valueOf(var7 + 1)), 4);
				}

			}
		}
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		float var4 = 0.0625F;
		return new AxisAlignedBB((double) ((float) var2.getX() + var4), (double) var2.getY(), (double) ((float) var2.getZ() + var4), (double) ((float) (var2.getX() + 1) - var4), (double) ((float) (var2.getY() + 1) - var4), (double) ((float) (var2.getZ() + 1) - var4));
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) ? this.d(var1, var2) : false;
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!this.d(var1, var2)) {
			var1.b(var2, true);
		}

	}

	public boolean d(World var1, Position var2) {
		Iterator var3 = en.a.iterator();

		while (var3.hasNext()) {
			BlockFace var4 = (BlockFace) var3.next();
			if (var1.getBlockState(var2.getRelative(var4)).getBlock().getMaterial().isBuildable()) {
				return false;
			}
		}

		Block var5 = var1.getBlockState(var2.b()).getBlock();
		return var5 == Blocks.CACTUS || var5 == Blocks.SAND;
	}

	public void a(World var1, Position var2, IBlockState var3, Entity var4) {
		var4.damageEntity(DamageSource.CACTUS, 1.0F);
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
