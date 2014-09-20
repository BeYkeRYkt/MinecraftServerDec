package net.minecraft;

import java.util.Random;

public class BlockPortal extends awt {

	public static final bev a = bev.a("axis", el.class, (Enum[]) (new el[] { el.a, el.c }));

	public BlockPortal() {
		super(Material.PORTAL, false);
		this.setBlockState(this.L.b().a(a, el.a));
		this.a(true);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.worldProvider.isSleepAllowed() && var1.getGameRules().b("doMobSpawning") && var4.nextInt(2000) < var1.getDifficulty().getId()) {
			int var5 = var2.getY();

			Position var6;
			for (var6 = var2; !World.a((ard) var1, var6) && var6.getY() > 0; var6 = var6.getDown()) {
				;
			}

			if (var5 > 0 && !var1.getBlockState(var6.getUp()).getBlock().t()) {
				Entity var7 = ItemMonsterEgg.a(var1, 57, (double) var6.getX() + 0.5D, (double) var6.getY() + 1.1D, (double) var6.getZ() + 0.5D);
				if (var7 != null) {
					var7.portalCooldown = var7.ar();
				}
			}
		}

	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		return null;
	}

	public void a(ard var1, Position var2) {
		el var3 = (el) var1.getBlockState(var2).b(a);
		float var4 = 0.125F;
		float var5 = 0.125F;
		if (var3 == el.a) {
			var4 = 0.5F;
		}

		if (var3 == el.c) {
			var5 = 0.5F;
		}

		this.a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
	}

	public static int a(el var0) {
		return var0 == el.a ? 1 : (var0 == el.c ? 2 : 0);
	}

	public boolean d() {
		return false;
	}

	public boolean d(World var1, Position var2) {
		ayz var3 = new ayz(var1, var2, el.a);
		if (var3.b() && ayz.a(var3) == 0) {
			var3.c();
			return true;
		} else {
			ayz var4 = new ayz(var1, var2, el.c);
			if (var4.b() && ayz.a(var4) == 0) {
				var4.c();
				return true;
			} else {
				return false;
			}
		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		el var5 = (el) var3.b(a);
		ayz var6;
		if (var5 == el.a) {
			var6 = new ayz(var1, var2, el.a);
			if (!var6.b() || ayz.a(var6) < ayz.b(var6) * ayz.c(var6)) {
				var1.a(var2, Blocks.AIR.getBlockState());
			}
		} else if (var5 == el.c) {
			var6 = new ayz(var1, var2, el.c);
			if (!var6.b() || ayz.a(var6) < ayz.b(var6) * ayz.c(var6)) {
				var1.a(var2, Blocks.AIR.getBlockState());
			}
		}

	}

	public int getDropCount(Random var1) {
		return 0;
	}

	public void a(World var1, Position var2, IBlockState var3, Entity var4) {
		if (var4.vehicle == null && var4.passenger == null) {
			var4.aq();
		}

	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, (var1 & 3) == 2 ? el.c : el.a);
	}

	public int getData(IBlockState var1) {
		return a((el) var1.b(a));
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
