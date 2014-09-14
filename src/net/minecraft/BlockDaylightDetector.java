package net.minecraft;

import java.util.Random;

public class BlockDaylightDetector extends atg {

	public static final bew a = bew.a("power", 0, 15);
	private final boolean b;

	public BlockDaylightDetector(boolean var1) {
		super(Material.WOOD);
		this.b = var1;
		this.setBlockState(this.L.b().a(a, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
		this.a(CreativeModeTab.REDSTONE);
		this.c(0.2F);
		this.a(f);
		this.setName("daylightDetector");
	}

	public void a(ard var1, Position var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
	}

	public int a(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return ((Integer) var3.b(a)).intValue();
	}

	public void d(World var1, Position var2) {
		if (!var1.worldProvider.noSkyLight()) {
			IBlockState var3 = var1.getBlockState(var2);
			int var4 = var1.b(EnumSkyBlock.SKY, var2) - var1.ab();
			float var5 = var1.d(1.0F);
			float var6 = var5 < 3.1415927F ? 0.0F : 6.2831855F;
			var5 += (var6 - var5) * 0.2F;
			var4 = Math.round((float) var4 * MathHelper.b(var5));
			var4 = MathHelper.a(var4, 0, 15);
			if (this.b) {
				var4 = 15 - var4;
			}

			if (((Integer) var3.b(a)).intValue() != var4) {
				var1.setBlockAt(var2, var3.a(a, Integer.valueOf(var4)), 3);
			}

		}
	}

	public boolean a(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var4.cm()) {
			if (var1.isStatic) {
				return true;
			} else {
				if (this.b) {
					var1.setBlockAt(var2, Blocks.DAYLIGHT_DETECTOR.getBlockState().a(a, var3.b(a)), 4);
					Blocks.DAYLIGHT_DETECTOR.d(var1, var2);
				} else {
					var1.setBlockAt(var2, Blocks.DAYLIGHT_DETECTOR_INVERTED.getBlockState().a(a, var3.b(a)), 4);
					Blocks.DAYLIGHT_DETECTOR_INVERTED.d(var1, var2);
				}

				return true;
			}
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		}
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Item.getItemOf((Block) Blocks.DAYLIGHT_DETECTOR);
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int b() {
		return 3;
	}

	public boolean g() {
		return true;
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityLightDetector();
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
