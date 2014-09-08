package net.minecraft;

public class BlockFenceGate extends avb {

	public static final bet a = bet.a("open");
	public static final bet b = bet.a("powered");
	public static final bet M = bet.a("in_wall");

	public BlockFenceGate() {
		super(Material.WOOD);
		this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)));
		this.a(CreativeModeTab.REDSTONE);
	}

	public bec a(bec var1, ard var2, Position var3) {
		el var4 = ((BlockFace) var1.b(N)).k();
		if (var4 == el.c && (var2.p(var3.e()).getBlock() == Blocks.COBBLESTONE_WALL || var2.p(var3.f()).getBlock() == Blocks.COBBLESTONE_WALL) || var4 == el.a && (var2.p(var3.c()).getBlock() == Blocks.COBBLESTONE_WALL || var2.p(var3.d()).getBlock() == Blocks.COBBLESTONE_WALL)) {
			var1 = var1.a(M, Boolean.valueOf(true));
		}

		return var1;
	}

	public boolean c(World var1, Position var2) {
		return var1.p(var2.b()).getBlock().r().isBuildable() ? super.c(var1, var2) : false;
	}

	public AxisAlignedBB a(World var1, Position var2, bec var3) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			return null;
		} else {
			el var4 = ((BlockFace) var3.b(N)).k();
			return var4 == el.c ? new AxisAlignedBB((double) var2.getX(), (double) var2.getY(), (double) ((float) var2.getZ() + 0.375F), (double) (var2.getX() + 1), (double) ((float) var2.getY() + 1.5F), (double) ((float) var2.getZ() + 0.625F)) : new AxisAlignedBB((double) ((float) var2.getX() + 0.375F), (double) var2.getY(), (double) var2.getZ(), (double) ((float) var2.getX() + 0.625F), (double) ((float) var2.getY() + 1.5F), (double) (var2.getZ() + 1));
		}
	}

	public void a(ard var1, Position var2) {
		el var3 = ((BlockFace) var1.p(var2).b(N)).k();
		if (var3 == el.c) {
			this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
		} else {
			this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
		}

	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean b(ard var1, Position var2) {
		return ((Boolean) var1.p(var2).b(a)).booleanValue();
	}

	public bec a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(N, var8.aO()).a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false));
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			var3 = var3.a(a, Boolean.valueOf(false));
			var1.a(var2, var3, 2);
		} else {
			BlockFace var9 = BlockFace.fromDirection((double) var4.yaw);
			if (var3.b(N) == var9.getOpposite()) {
				var3 = var3.a(N, var9);
			}

			var3 = var3.a(a, Boolean.valueOf(true));
			var1.a(var2, var3, 2);
		}

		var1.a(var4, ((Boolean) var3.b(a)).booleanValue() ? 1003 : 1006, var2, 0);
		return true;
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			boolean var5 = var1.z(var2);
			if (var5 || var4.g()) {
				if (var5 && !((Boolean) var3.b(a)).booleanValue() && !((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(a, Boolean.valueOf(true)).a(b, Boolean.valueOf(true)), 2);
					var1.a((EntityHuman) null, 1003, var2, 0);
				} else if (!var5 && ((Boolean) var3.b(a)).booleanValue() && ((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)), 2);
					var1.a((EntityHuman) null, 1006, var2, 0);
				} else if (var5 != ((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(b, Boolean.valueOf(var5)), 2);
				}
			}

		}
	}

	public bec a(int var1) {
		return this.P().a(N, BlockFace.fromDirection(var1)).a(a, Boolean.valueOf((var1 & 4) != 0)).a(b, Boolean.valueOf((var1 & 8) != 0));
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(N)).toDirection();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		if (((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, a, b, M });
	}

}
