package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class BlockStem extends auc implements atz {

	public static final bew a = bew.a("age", 0, 7);
	public static final beu b = beu.a("facing", (Predicate) (new baz()));
	private final Block M;

	protected BlockStem(Block var1) {
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)).a(b, BlockFace.UP));
		this.M = var1;
		this.a(true);
		float var2 = 0.125F;
		this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
		this.a((CreativeModeTab) null);
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		var1 = var1.a(b, BlockFace.UP);
		Iterator var4 = en.a.iterator();

		while (var4.hasNext()) {
			BlockFace var5 = (BlockFace) var4.next();
			if (var2.getBlockState(var3.a(var5)).getBlock() == this.M) {
				var1 = var1.a(b, var5);
				break;
			}
		}

		return var1;
	}

	protected boolean c(Block var1) {
		return var1 == Blocks.FARMLAND;
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.l(var2.a()) >= 9) {
			float var5 = BlockCrops.a(this, var1, var2);
			if (var4.nextInt((int) (25.0F / var5) + 1) == 0) {
				int var6 = ((Integer) var3.b(a)).intValue();
				if (var6 < 7) {
					var3 = var3.a(a, Integer.valueOf(var6 + 1));
					var1.setBlockAt(var2, var3, 2);
				} else {
					Iterator var7 = en.a.iterator();

					while (var7.hasNext()) {
						BlockFace var8 = (BlockFace) var7.next();
						if (var1.getBlockState(var2.a(var8)).getBlock() == this.M) {
							return;
						}
					}

					var2 = var2.a(en.a.a(var4));
					Block var9 = var1.getBlockState(var2.b()).getBlock();
					if (var1.getBlockState(var2).getBlock().material == Material.AIR && (var9 == Blocks.FARMLAND || var9 == Blocks.DIRT || var9 == Blocks.GRASS)) {
						var1.a(var2, this.M.getBlockState());
					}
				}
			}

		}
	}

	public void g(World var1, Position var2, IBlockState var3) {
		int var4 = ((Integer) var3.b(a)).intValue() + MathHelper.a(var1.s, 2, 5);
		var1.setBlockAt(var2, var3.a(a, Integer.valueOf(Math.min(7, var4))), 2);
	}

	public void h() {
		float var1 = 0.125F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
	}

	public void a(ard var1, Position var2) {
		this.F = (double) ((float) (((Integer) var1.getBlockState(var2).b(a)).intValue() * 2 + 2) / 16.0F);
		float var3 = 0.125F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float) this.F, 0.5F + var3);
	}

	public void a(World var1, Position var2, IBlockState var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (!var1.isStatic) {
			Item var6 = this.j();
			if (var6 != null) {
				int var7 = ((Integer) var3.b(a)).intValue();

				for (int var8 = 0; var8 < 3; ++var8) {
					if (var1.s.nextInt(15) <= var7) {
						a(var1, var2, new ItemStack(var6));
					}
				}

			}
		}
	}

	protected Item j() {
		return this.M == Blocks.PUMPKIN ? Items.PUMPKIN_SEEDS : (this.M == Blocks.MELON_BLOCK ? Items.MELON_SEEDS : null);
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return null;
	}

	public boolean a(World var1, Position var2, IBlockState var3, boolean var4) {
		return ((Integer) var3.b(a)).intValue() != 7;
	}

	public boolean a(World var1, Random var2, Position var3, IBlockState var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, IBlockState var4) {
		this.g(var1, var3, var4);
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
