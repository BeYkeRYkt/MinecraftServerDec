package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlockStairs extends Block {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	public static final bev b = bev.a("half", bau.class);
	public static final bev M = bev.a("shape", bav.class);
	private static final int[][] N = new int[][] { { 4, 5 }, { 5, 7 }, { 6, 7 }, { 4, 6 }, { 0, 1 }, { 1, 3 }, { 2, 3 }, { 0, 2 } };
	private final Block O;
	private final IBlockState P;
	private boolean Q;
	private int R;

	protected BlockStairs(IBlockState var1) {
		super(var1.getBlock().material);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, bau.b).a(M, bav.a));
		this.O = var1.getBlock();
		this.P = var1;
		this.c(this.O.w);
		this.b(this.O.x / 3.0F);
		this.a(this.O.H);
		this.e(255);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public void a(ard var1, Position var2) {
		if (this.Q) {
			this.a(0.5F * (float) (this.R % 2), 0.5F * (float) (this.R / 4 % 2), 0.5F * (float) (this.R / 2 % 2), 0.5F + 0.5F * (float) (this.R % 2), 0.5F + 0.5F * (float) (this.R / 4 % 2), 0.5F + 0.5F * (float) (this.R / 2 % 2));
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void e(ard var1, Position var2) {
		if (var1.getBlockState(var2).b(b) == bau.a) {
			this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

	}

	public static boolean c(Block var0) {
		return var0 instanceof BlockStairs;
	}

	public static boolean a(ard var0, Position var1, IBlockState var2) {
		IBlockState var3 = var0.getBlockState(var1);
		Block var4 = var3.getBlock();
		return c(var4) && var3.b(b) == var2.b(b) && var3.b(a) == var2.b(a);
	}

	public int f(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		BlockFace var4 = (BlockFace) var3.b(a);
		bau var5 = (bau) var3.b(b);
		boolean var6 = var5 == bau.a;
		IBlockState var7;
		Block var8;
		BlockFace var9;
		if (var4 == BlockFace.EAST) {
			var7 = var1.getBlockState(var2.f());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.NORTH && !a(var1, var2.d(), var3)) {
					return var6 ? 1 : 2;
				}

				if (var9 == BlockFace.SOUTH && !a(var1, var2.c(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == BlockFace.WEST) {
			var7 = var1.getBlockState(var2.e());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.NORTH && !a(var1, var2.d(), var3)) {
					return var6 ? 2 : 1;
				}

				if (var9 == BlockFace.SOUTH && !a(var1, var2.c(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == BlockFace.SOUTH) {
			var7 = var1.getBlockState(var2.d());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.WEST && !a(var1, var2.f(), var3)) {
					return var6 ? 2 : 1;
				}

				if (var9 == BlockFace.EAST && !a(var1, var2.e(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == BlockFace.NORTH) {
			var7 = var1.getBlockState(var2.c());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.WEST && !a(var1, var2.f(), var3)) {
					return var6 ? 1 : 2;
				}

				if (var9 == BlockFace.EAST && !a(var1, var2.e(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public int g(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		BlockFace var4 = (BlockFace) var3.b(a);
		bau var5 = (bau) var3.b(b);
		boolean var6 = var5 == bau.a;
		IBlockState var7;
		Block var8;
		BlockFace var9;
		if (var4 == BlockFace.EAST) {
			var7 = var1.getBlockState(var2.e());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.NORTH && !a(var1, var2.c(), var3)) {
					return var6 ? 1 : 2;
				}

				if (var9 == BlockFace.SOUTH && !a(var1, var2.d(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == BlockFace.WEST) {
			var7 = var1.getBlockState(var2.f());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.NORTH && !a(var1, var2.c(), var3)) {
					return var6 ? 2 : 1;
				}

				if (var9 == BlockFace.SOUTH && !a(var1, var2.d(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == BlockFace.SOUTH) {
			var7 = var1.getBlockState(var2.c());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.WEST && !a(var1, var2.e(), var3)) {
					return var6 ? 2 : 1;
				}

				if (var9 == BlockFace.EAST && !a(var1, var2.f(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == BlockFace.NORTH) {
			var7 = var1.getBlockState(var2.d());
			var8 = var7.getBlock();
			if (c(var8) && var5 == var7.b(b)) {
				var9 = (BlockFace) var7.b(a);
				if (var9 == BlockFace.WEST && !a(var1, var2.e(), var3)) {
					return var6 ? 1 : 2;
				}

				if (var9 == BlockFace.EAST && !a(var1, var2.f(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public boolean h(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		BlockFace var4 = (BlockFace) var3.b(a);
		bau var5 = (bau) var3.b(b);
		boolean var6 = var5 == bau.a;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 1.0F;
		float var11 = 0.0F;
		float var12 = 0.5F;
		boolean var13 = true;
		IBlockState var14;
		Block var15;
		BlockFace var16;
		if (var4 == BlockFace.EAST) {
			var9 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getBlockState(var2.f());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.NORTH && !a(var1, var2.d(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if (var16 == BlockFace.SOUTH && !a(var1, var2.c(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == BlockFace.WEST) {
			var10 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getBlockState(var2.e());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.NORTH && !a(var1, var2.d(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if (var16 == BlockFace.SOUTH && !a(var1, var2.c(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == BlockFace.SOUTH) {
			var11 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getBlockState(var2.d());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.WEST && !a(var1, var2.f(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if (var16 == BlockFace.EAST && !a(var1, var2.e(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == BlockFace.NORTH) {
			var14 = var1.getBlockState(var2.c());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.WEST && !a(var1, var2.f(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if (var16 == BlockFace.EAST && !a(var1, var2.e(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		}

		this.a(var9, var7, var11, var10, var8, var12);
		return var13;
	}

	public boolean i(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		BlockFace var4 = (BlockFace) var3.b(a);
		bau var5 = (bau) var3.b(b);
		boolean var6 = var5 == bau.a;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 0.5F;
		float var11 = 0.5F;
		float var12 = 1.0F;
		boolean var13 = false;
		IBlockState var14;
		Block var15;
		BlockFace var16;
		if (var4 == BlockFace.EAST) {
			var14 = var1.getBlockState(var2.e());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.NORTH && !a(var1, var2.c(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if (var16 == BlockFace.SOUTH && !a(var1, var2.d(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == BlockFace.WEST) {
			var14 = var1.getBlockState(var2.f());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var9 = 0.5F;
				var10 = 1.0F;
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.NORTH && !a(var1, var2.c(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if (var16 == BlockFace.SOUTH && !a(var1, var2.d(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == BlockFace.SOUTH) {
			var14 = var1.getBlockState(var2.c());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var11 = 0.0F;
				var12 = 0.5F;
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.WEST && !a(var1, var2.e(), var3)) {
					var13 = true;
				} else if (var16 == BlockFace.EAST && !a(var1, var2.f(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == BlockFace.NORTH) {
			var14 = var1.getBlockState(var2.d());
			var15 = var14.getBlock();
			if (c(var15) && var5 == var14.b(b)) {
				var16 = (BlockFace) var14.b(a);
				if (var16 == BlockFace.WEST && !a(var1, var2.e(), var3)) {
					var13 = true;
				} else if (var16 == BlockFace.EAST && !a(var1, var2.f(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		}

		if (var13) {
			this.a(var9, var7, var11, var10, var8, var12);
		}

		return var13;
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		this.e(var1, var2);
		super.a(var1, var2, var3, var4, var5, var6);
		boolean var7 = this.h(var1, var2);
		super.a(var1, var2, var3, var4, var5, var6);
		if (var7 && this.i(var1, var2)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}

		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void a(World var1, Position var2, EntityHuman var3) {
		this.O.a(var1, var2, var3);
	}

	public void d(World var1, Position var2, IBlockState var3) {
		this.O.d(var1, var2, var3);
	}

	public float a(Entity var1) {
		return this.O.a(var1);
	}

	public int a(World var1) {
		return this.O.a(var1);
	}

	public Vec3D a(World var1, Position var2, Entity var3, Vec3D var4) {
		return this.O.a(var1, var2, var3, var4);
	}

	public boolean y() {
		return this.O.y();
	}

	public boolean a(IBlockState var1, boolean var2) {
		return this.O.a(var1, var2);
	}

	public boolean c(World var1, Position var2) {
		return this.O.c(var1, var2);
	}

	public void c(World var1, Position var2, IBlockState var3) {
		this.a(var1, var2, this.P, Blocks.AIR);
		this.O.c(var1, var2, this.P);
	}

	public void b(World var1, Position var2, IBlockState var3) {
		this.O.b(var1, var2, this.P);
	}

	public void a(World var1, Position var2, Entity var3) {
		this.O.a(var1, var2, var3);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		this.O.b(var1, var2, var3, var4);
	}

	public boolean a(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		return this.O.a(var1, var2, this.P, var4, BlockFace.DOWN, 0.0F, 0.0F, 0.0F);
	}

	public void a(World var1, Position var2, Explosion var3) {
		this.O.a(var1, var2, var3);
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return this.O.getMapColor(this.P);
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		IBlockState var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		var9 = var9.a(a, var8.aO()).a(M, bav.a);
		return var3 != BlockFace.DOWN && (var3 == BlockFace.UP || (double) var5 <= 0.5D) ? var9.a(b, bau.b) : var9.a(b, bau.a);
	}

	public MovingObjectPosition a(World var1, Position var2, Vec3D var3, Vec3D var4) {
		MovingObjectPosition[] var5 = new MovingObjectPosition[8];
		IBlockState var6 = var1.getBlockState(var2);
		int var7 = ((BlockFace) var6.b(a)).toDirection();
		boolean var8 = var6.b(b) == bau.a;
		int[] var9 = N[var7 + (var8 ? 4 : 0)];
		this.Q = true;

		for (int var10 = 0; var10 < 8; ++var10) {
			this.R = var10;
			if (Arrays.binarySearch(var9, var10) < 0) {
				var5[var10] = super.a(var1, var2, var3, var4);
			}
		}

		int[] var19 = var9;
		int var11 = var9.length;

		for (int var12 = 0; var12 < var11; ++var12) {
			int var13 = var19[var12];
			var5[var13] = null;
		}

		MovingObjectPosition var20 = null;
		double var21 = 0.0D;
		MovingObjectPosition[] var22 = var5;
		int var14 = var5.length;

		for (int var15 = 0; var15 < var14; ++var15) {
			MovingObjectPosition var16 = var22[var15];
			if (var16 != null) {
				double var17 = var16.vec.g(var4);
				if (var17 > var21) {
					var20 = var16;
					var21 = var17;
				}
			}
		}

		return var20;
	}

	public IBlockState setData(int var1) {
		IBlockState var2 = this.getBlockState().a(b, (var1 & 4) > 0 ? bau.a : bau.b);
		var2 = var2.a(a, BlockFace.getById(5 - (var1 & 3)));
		return var2;
	}

	public int getData(IBlockState var1) {
		int var2 = 0;
		if (var1.b(b) == bau.a) {
			var2 |= 4;
		}

		var2 |= 5 - ((BlockFace) var1.b(a)).getId();
		return var2;
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		if (this.h(var2, var3)) {
			switch (this.g(var2, var3)) {
				case 0:
					var1 = var1.a(M, bav.a);
					break;
				case 1:
					var1 = var1.a(M, bav.c);
					break;
				case 2:
					var1 = var1.a(M, bav.b);
			}
		} else {
			switch (this.f(var2, var3)) {
				case 0:
					var1 = var1.a(M, bav.a);
					break;
				case 1:
					var1 = var1.a(M, bav.e);
					break;
				case 2:
					var1 = var1.a(M, bav.d);
			}
		}

		return var1;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M });
	}

}
