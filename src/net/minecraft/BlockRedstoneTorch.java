package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BlockRedstoneTorch extends BlockTorch {

	private static Map b = Maps.newHashMap();
	private final boolean M;

	private boolean a(World var1, Position var2, boolean var3) {
		if (!b.containsKey(var1)) {
			b.put(var1, Lists.newArrayList());
		}

		List var4 = (List) b.get(var1);
		if (var3) {
			var4.add(new azx(var2, var1.getLastUpdate()));
		}

		int var5 = 0;

		for (int var6 = 0; var6 < var4.size(); ++var6) {
			azx var7 = (azx) var4.get(var6);
			if (var7.a.equals(var2)) {
				++var5;
				if (var5 >= 8) {
					return true;
				}
			}
		}

		return false;
	}

	protected BlockRedstoneTorch(boolean var1) {
		this.M = var1;
		this.a(true);
		this.a((CreativeModeTab) null);
	}

	public int a(World var1) {
		return 2;
	}

	public void c(World var1, Position var2, BlockState var3) {
		if (this.M) {
			BlockFace[] var4 = BlockFace.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				BlockFace var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}
		}

	}

	public void b(World var1, Position var2, BlockState var3) {
		if (this.M) {
			BlockFace[] var4 = BlockFace.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				BlockFace var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}
		}

	}

	public int a(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return this.M && var3.b(a) != var4 ? 15 : 0;
	}

	private boolean g(World var1, Position var2, BlockState var3) {
		BlockFace var4 = ((BlockFace) var3.b(a)).getOpposite();
		return var1.b(var2.a(var4), var4);
	}

	public void a(World var1, Position var2, BlockState var3, Random var4) {
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		boolean var5 = this.g(var1, var2, var3);
		List var6 = (List) b.get(var1);

		while (var6 != null && !var6.isEmpty() && var1.getLastUpdate() - ((azx) var6.get(0)).b > 60L) {
			var6.remove(0);
		}

		if (this.M) {
			if (var5) {
				var1.a(var2, Blocks.UNLIT_REDSTONE_TORCH.getBlockState().a(a, var3.b(a)), 3);
				if (this.a(var1, var2, true)) {
					var1.makeSound((double) ((float) var2.getX() + 0.5F), (double) ((float) var2.getY() + 0.5F), (double) ((float) var2.getZ() + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

					for (int var7 = 0; var7 < 5; ++var7) {
						double var8 = (double) var2.getX() + var4.nextDouble() * 0.6D + 0.2D;
						double var10 = (double) var2.getY() + var4.nextDouble() * 0.6D + 0.2D;
						double var12 = (double) var2.getZ() + var4.nextDouble() * 0.6D + 0.2D;
						var1.a(Particle.l, var8, var10, var12, 0.0D, 0.0D, 0.0D, new int[0]);
					}

					var1.a(var2, var1.getBlockState(var2).getBlock(), 160);
				}
			}
		} else if (!var5 && !this.a(var1, var2, false)) {
			var1.a(var2, Blocks.REDSTONE_TORCH.getBlockState().a(a, var3.b(a)), 3);
		}

	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
		if (!this.e(var1, var2, var3)) {
			if (this.M == this.g(var1, var2, var3)) {
				var1.a(var2, (Block) this, this.a(var1));
			}

		}
	}

	public int b(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return var4 == BlockFace.DOWN ? this.a(var1, var2, var3, var4) : 0;
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.REDSTONE_TORCH);
	}

	public boolean g() {
		return true;
	}

	public boolean b(Block var1) {
		return var1 == Blocks.UNLIT_REDSTONE_TORCH || var1 == Blocks.REDSTONE_TORCH;
	}

}
