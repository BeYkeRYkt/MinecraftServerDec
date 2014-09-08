package net.minecraft;

public abstract class blb extends bms {

	protected static final BlockState a = Blocks.PRISMARINE.a(BlockPrismarine.b);
	protected static final BlockState b = Blocks.PRISMARINE.a(BlockPrismarine.M);
	protected static final BlockState c = Blocks.PRISMARINE.a(BlockPrismarine.N);
	protected static final BlockState d = b;
	protected static final BlockState e = Blocks.SEA_LANTERN.getBlockState();
	protected static final BlockState f = Blocks.WATER.getBlockState();
	protected static final int g = a(2, 0, 0);
	protected static final int h = a(2, 2, 0);
	protected static final int i = a(0, 1, 0);
	protected static final int j = a(4, 1, 0);
	protected blf k;

	protected static final int a(int var0, int var1, int var2) {
		return var1 * 25 + var2 * 5 + var0;
	}

	public blb() {
		super(0);
	}

	public blb(int var1) {
		super(var1);
	}

	public blb(BlockFace var1, bjb var2) {
		super(1);
		this.m = var1;
		this.l = var2;
	}

	protected blb(int var1, BlockFace var2, blf var3, int var4, int var5, int var6) {
		super(var1);
		this.m = var2;
		this.k = var3;
		int var7 = var3.a;
		int var8 = var7 % 5;
		int var9 = var7 / 5 % 5;
		int var10 = var7 / 25;
		if (var2 != BlockFace.NORTH && var2 != BlockFace.SOUTH) {
			this.l = new bjb(0, 0, 0, var6 * 8 - 1, var5 * 4 - 1, var4 * 8 - 1);
		} else {
			this.l = new bjb(0, 0, 0, var4 * 8 - 1, var5 * 4 - 1, var6 * 8 - 1);
		}

		switch (bkj.a[var2.ordinal()]) {
			case 1:
				this.l.a(var8 * 8, var10 * 4, -(var9 + var6) * 8 + 1);
				break;
			case 2:
				this.l.a(var8 * 8, var10 * 4, var9 * 8);
				break;
			case 3:
				this.l.a(-(var9 + var6) * 8 + 1, var10 * 4, var8 * 8);
				break;
			default:
				this.l.a(var9 * 8, var10 * 4, var8 * 8);
		}

	}

	protected void a(NBTCompoundTag var1) {
	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(World var1, bjb var2, int var3, int var4, boolean var5) {
		if (var5) {
			this.a(var1, var2, var3 + 0, 0, var4 + 0, var3 + 2, 0, var4 + 8 - 1, a, a, false);
			this.a(var1, var2, var3 + 5, 0, var4 + 0, var3 + 8 - 1, 0, var4 + 8 - 1, a, a, false);
			this.a(var1, var2, var3 + 3, 0, var4 + 0, var3 + 4, 0, var4 + 2, a, a, false);
			this.a(var1, var2, var3 + 3, 0, var4 + 5, var3 + 4, 0, var4 + 8 - 1, a, a, false);
			this.a(var1, var2, var3 + 3, 0, var4 + 2, var3 + 4, 0, var4 + 2, b, b, false);
			this.a(var1, var2, var3 + 3, 0, var4 + 5, var3 + 4, 0, var4 + 5, b, b, false);
			this.a(var1, var2, var3 + 2, 0, var4 + 3, var3 + 2, 0, var4 + 4, b, b, false);
			this.a(var1, var2, var3 + 5, 0, var4 + 3, var3 + 5, 0, var4 + 4, b, b, false);
		} else {
			this.a(var1, var2, var3 + 0, 0, var4 + 0, var3 + 8 - 1, 0, var4 + 8 - 1, a, a, false);
		}

	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, BlockState var9) {
		for (int var10 = var4; var10 <= var7; ++var10) {
			for (int var11 = var3; var11 <= var6; ++var11) {
				for (int var12 = var5; var12 <= var8; ++var12) {
					if (this.a(var1, var11, var10, var12, var2) == f) {
						this.a(var1, var9, var11, var10, var12, var2);
					}
				}
			}
		}

	}

	protected boolean a(bjb var1, int var2, int var3, int var4, int var5) {
		int var6 = this.a(var2, var3);
		int var7 = this.b(var2, var3);
		int var8 = this.a(var4, var5);
		int var9 = this.b(var4, var5);
		return var1.a(Math.min(var6, var8), Math.min(var7, var9), Math.max(var6, var8), Math.max(var7, var9));
	}

	protected boolean a(World var1, bjb var2, int var3, int var4, int var5) {
		int var6 = this.a(var3, var5);
		int var7 = this.d(var4);
		int var8 = this.b(var3, var5);
		if (var2.b((fd) (new Position(var6, var7, var8)))) {
			EntityGuardian var9 = new EntityGuardian(var1);
			var9.a(true);
			var9.g(var9.bt());
			var9.setPositionRotation((double) var6 + 0.5D, (double) var7, (double) var8 + 0.5D, 0.0F, 0.0F);
			var9.a(var1.E(new Position(var9)), (xq) null);
			var1.d((Entity) var9);
			return true;
		} else {
			return false;
		}
	}

}
