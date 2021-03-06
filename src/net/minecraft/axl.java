package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public abstract class axl extends Block {

	public static final bew b = bew.a("level", 0, 15);

	protected axl(Material var1) {
		super(var1);
		this.setBlockState(this.L.b().a(b, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.a(true);
	}

	public boolean b(ard var1, Position var2) {
		return this.material != Material.LAVA;
	}

	public static float b(int var0) {
		if (var0 >= 8) {
			var0 = 0;
		}

		return (float) (var0 + 1) / 9.0F;
	}

	protected int e(ard var1, Position var2) {
		return var1.getBlockState(var2).getBlock().getMaterial() == this.material ? ((Integer) var1.getBlockState(var2).b(b)).intValue() : -1;
	}

	protected int f(ard var1, Position var2) {
		int var3 = this.e(var1, var2);
		return var3 >= 8 ? 0 : var3;
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean a(IBlockState var1, boolean var2) {
		return var2 && ((Integer) var1.b(b)).intValue() == 0;
	}

	public boolean b(ard var1, Position var2, BlockFace var3) {
		Material var4 = var1.getBlockState(var2).getBlock().getMaterial();
		return var4 == this.material ? false : (var3 == BlockFace.UP ? true : (var4 == Material.ICE ? false : super.b(var1, var2, var3)));
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return null;
	}

	public int b() {
		return 1;
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return null;
	}

	public int getDropCount(Random var1) {
		return 0;
	}

	protected Vec3D h(ard var1, Position var2) {
		Vec3D var3 = new Vec3D(0.0D, 0.0D, 0.0D);
		int var4 = this.f(var1, var2);
		Iterator var5 = UniverseDirection.HORIZONTAL.iterator();

		BlockFace var6;
		Position var7;
		while (var5.hasNext()) {
			var6 = (BlockFace) var5.next();
			var7 = var2.getRelative(var6);
			int var8 = this.f(var1, var7);
			int var9;
			if (var8 < 0) {
				if (!var1.getBlockState(var7).getBlock().getMaterial().isSolid()) {
					var8 = this.f(var1, var7.getDown());
					if (var8 >= 0) {
						var9 = var8 - (var4 - 8);
						var3 = var3.b((double) ((var7.getX() - var2.getX()) * var9), (double) ((var7.getY() - var2.getY()) * var9), (double) ((var7.getZ() - var2.getZ()) * var9));
					}
				}
			} else if (var8 >= 0) {
				var9 = var8 - var4;
				var3 = var3.b((double) ((var7.getX() - var2.getX()) * var9), (double) ((var7.getY() - var2.getY()) * var9), (double) ((var7.getZ() - var2.getZ()) * var9));
			}
		}

		if (((Integer) var1.getBlockState(var2).b(b)).intValue() >= 8) {
			var5 = UniverseDirection.HORIZONTAL.iterator();

			while (var5.hasNext()) {
				var6 = (BlockFace) var5.next();
				var7 = var2.getRelative(var6);
				if (this.b(var1, var7, var6) || this.b(var1, var7.getUp(), var6)) {
					var3 = var3.a().b(0.0D, -6.0D, 0.0D);
					break;
				}
			}
		}

		return var3.a();
	}

	public Vec3D a(World var1, Position var2, Entity var3, Vec3D var4) {
		return var4.e(this.h(var1, var2));
	}

	public int a(World var1) {
		return this.material == Material.WATER ? 5 : (this.material == Material.LAVA ? (var1.worldProvider.noSkyLight() ? 10 : 30) : 0);
	}

	public void onPlace(World var1, Position var2, IBlockState var3) {
		this.e(var1, var2, var3);
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		this.e(var1, var2, var3);
	}

	public boolean e(World var1, Position var2, IBlockState var3) {
		if (this.material == Material.LAVA) {
			boolean var4 = false;
			BlockFace[] var5 = BlockFace.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				BlockFace var8 = var5[var7];
				if (var8 != BlockFace.DOWN && var1.getBlockState(var2.getRelative(var8)).getBlock().getMaterial() == Material.WATER) {
					var4 = true;
					break;
				}
			}

			if (var4) {
				Integer var9 = (Integer) var3.b(b);
				if (var9.intValue() == 0) {
					var1.a(var2, Blocks.OBSIDIAN.getBlockState());
					this.d(var1, var2);
					return true;
				}

				if (var9.intValue() <= 4) {
					var1.a(var2, Blocks.COBBLESTONE.getBlockState());
					this.d(var1, var2);
					return true;
				}
			}
		}

		return false;
	}

	protected void d(World var1, Position var2) {
		double var3 = (double) var2.getX();
		double var5 = (double) var2.getY();
		double var7 = (double) var2.getZ();
		var1.makeSound(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + (var1.random.nextFloat() - var1.random.nextFloat()) * 0.8F);

		for (int var9 = 0; var9 < 8; ++var9) {
			var1.addParticle(Particle.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(b, Integer.valueOf(var1));
	}

	public int getData(IBlockState var1) {
		return ((Integer) var1.b(b)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { b });
	}

	public static BlockFlowing a(Material var0) {
		if (var0 == Material.WATER) {
			return Blocks.FLOWING_WATER;
		} else if (var0 == Material.LAVA) {
			return Blocks.FLOWING_LAVA;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

	public static BlockStationary b(Material var0) {
		if (var0 == Material.WATER) {
			return Blocks.WATER;
		} else if (var0 == Material.LAVA) {
			return Blocks.LAVA;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

}
