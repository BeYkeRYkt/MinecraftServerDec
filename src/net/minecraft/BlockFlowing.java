package net.minecraft;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockFlowing extends axl {

	int a;

	protected BlockFlowing(Material var1) {
		super(var1);
	}

	private void f(World var1, Position var2, IBlockState var3) {
		var1.setBlockAt(var2, b(this.material).getBlockState().a(b, var3.b(b)), 2);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		int var5 = ((Integer) var3.b(b)).intValue();
		byte var6 = 1;
		if (this.material == Material.LAVA && !var1.worldProvider.n()) {
			var6 = 2;
		}

		int var7 = this.a(var1);
		int var16;
		if (var5 > 0) {
			int var8 = -100;
			this.a = 0;

			BlockFace var10;
			for (Iterator var9 = en.a.iterator(); var9.hasNext(); var8 = this.a(var1, var2.getRelative(var10), var8)) {
				var10 = (BlockFace) var9.next();
			}

			int var14 = var8 + var6;
			if (var14 >= 8 || var8 < 0) {
				var14 = -1;
			}

			if (this.e((ard) var1, var2.getUp()) >= 0) {
				var16 = this.e((ard) var1, var2.getUp());
				if (var16 >= 8) {
					var14 = var16;
				} else {
					var14 = var16 + 8;
				}
			}

			if (this.a >= 2 && this.material == Material.WATER) {
				IBlockState var17 = var1.getBlockState(var2.getDown());
				if (var17.getBlock().getMaterial().isBuildable()) {
					var14 = 0;
				} else if (var17.getBlock().getMaterial() == this.material && ((Integer) var17.b(b)).intValue() == 0) {
					var14 = 0;
				}
			}

			if (this.material == Material.LAVA && var5 < 8 && var14 < 8 && var14 > var5 && var4.nextInt(4) != 0) {
				var7 *= 4;
			}

			if (var14 == var5) {
				this.f(var1, var2, var3);
			} else {
				var5 = var14;
				if (var14 < 0) {
					var1.g(var2);
				} else {
					var3 = var3.a(b, Integer.valueOf(var14));
					var1.setBlockAt(var2, var3, 2);
					var1.a(var2, (Block) this, var7);
					var1.c(var2, (Block) this);
				}
			}
		} else {
			this.f(var1, var2, var3);
		}

		IBlockState var13 = var1.getBlockState(var2.getDown());
		if (this.h(var1, var2.getDown(), var13)) {
			if (this.material == Material.LAVA && var1.getBlockState(var2.getDown()).getBlock().getMaterial() == Material.WATER) {
				var1.a(var2.getDown(), Blocks.STONE.getBlockState());
				this.d(var1, var2.getDown());
				return;
			}

			if (var5 >= 8) {
				this.a(var1, var2.getDown(), var13, var5);
			} else {
				this.a(var1, var2.getDown(), var13, var5 + 8);
			}
		} else if (var5 >= 0 && (var5 == 0 || this.g(var1, var2.getDown(), var13))) {
			Set var15 = this.e(var1, var2);
			var16 = var5 + var6;
			if (var5 >= 8) {
				var16 = 1;
			}

			if (var16 >= 8) {
				return;
			}

			Iterator var11 = var15.iterator();

			while (var11.hasNext()) {
				BlockFace var12 = (BlockFace) var11.next();
				this.a(var1, var2.getRelative(var12), var1.getBlockState(var2.getRelative(var12)), var16);
			}
		}

	}

	private void a(World var1, Position var2, IBlockState var3, int var4) {
		if (this.h(var1, var2, var3)) {
			if (var3.getBlock() != Blocks.AIR) {
				if (this.material == Material.LAVA) {
					this.d(var1, var2);
				} else {
					var3.getBlock().b(var1, var2, var3, 0);
				}
			}

			var1.setBlockAt(var2, this.getBlockState().a(b, Integer.valueOf(var4)), 3);
		}

	}

	private int a(World var1, Position var2, int var3, BlockFace var4) {
		int var5 = 1000;
		Iterator var6 = en.a.iterator();

		while (var6.hasNext()) {
			BlockFace var7 = (BlockFace) var6.next();
			if (var7 != var4) {
				Position var8 = var2.getRelative(var7);
				IBlockState var9 = var1.getBlockState(var8);
				if (!this.g(var1, var8, var9) && (var9.getBlock().getMaterial() != this.material || ((Integer) var9.b(b)).intValue() > 0)) {
					if (!this.g(var1, var8.getDown(), var9)) {
						return var3;
					}

					if (var3 < 4) {
						int var10 = this.a(var1, var8, var3 + 1, var7.getOpposite());
						if (var10 < var5) {
							var5 = var10;
						}
					}
				}
			}
		}

		return var5;
	}

	private Set e(World var1, Position var2) {
		int var3 = 1000;
		EnumSet var4 = EnumSet.noneOf(BlockFace.class);
		Iterator var5 = en.a.iterator();

		while (var5.hasNext()) {
			BlockFace var6 = (BlockFace) var5.next();
			Position var7 = var2.getRelative(var6);
			IBlockState var8 = var1.getBlockState(var7);
			if (!this.g(var1, var7, var8) && (var8.getBlock().getMaterial() != this.material || ((Integer) var8.b(b)).intValue() > 0)) {
				int var9;
				if (this.g(var1, var7.getDown(), var1.getBlockState(var7.getDown()))) {
					var9 = this.a(var1, var7, 1, var6.getOpposite());
				} else {
					var9 = 0;
				}

				if (var9 < var3) {
					var4.clear();
				}

				if (var9 <= var3) {
					var4.add(var6);
					var3 = var9;
				}
			}
		}

		return var4;
	}

	private boolean g(World var1, Position var2, IBlockState var3) {
		Block var4 = var1.getBlockState(var2).getBlock();
		return !(var4 instanceof BlockDoor) && var4 != Blocks.STANDING_SIGN && var4 != Blocks.LADDER && var4 != Blocks.REEDS ? (var4.material == Material.PORTAL ? true : var4.material.isSolid()) : true;
	}

	protected int a(World var1, Position var2, int var3) {
		int var4 = this.e((ard) var1, var2);
		if (var4 < 0) {
			return var3;
		} else {
			if (var4 == 0) {
				++this.a;
			}

			if (var4 >= 8) {
				var4 = 0;
			}

			return var3 >= 0 && var4 >= var3 ? var3 : var4;
		}
	}

	private boolean h(World var1, Position var2, IBlockState var3) {
		Material var4 = var3.getBlock().getMaterial();
		return var4 != this.material && var4 != Material.LAVA && !this.g(var1, var2, var3);
	}

	public void c(World var1, Position var2, IBlockState var3) {
		if (!this.e(var1, var2, var3)) {
			var1.a(var2, (Block) this, this.a(var1));
		}

	}
}
