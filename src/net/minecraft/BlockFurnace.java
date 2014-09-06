package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockFurnace extends atg {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	private final boolean b;
	private static boolean M;

	protected BlockFurnace(boolean var1) {
		super(Material.STONE);
		this.j(this.L.b().a(a, PaintingDirection.c));
		this.b = var1;
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.al);
	}

	public void c(World var1, Position var2, bec var3) {
		this.e(var1, var2, var3);
	}

	private void e(World var1, Position var2, bec var3) {
		if (!var1.D) {
			Block var4 = var1.p(var2.c()).getBlock();
			Block var5 = var1.p(var2.d()).getBlock();
			Block var6 = var1.p(var2.e()).getBlock();
			Block var7 = var1.p(var2.f()).getBlock();
			PaintingDirection var8 = (PaintingDirection) var3.b(a);
			if (var8 == PaintingDirection.c && var4.m() && !var5.m()) {
				var8 = PaintingDirection.d;
			} else if (var8 == PaintingDirection.d && var5.m() && !var4.m()) {
				var8 = PaintingDirection.c;
			} else if (var8 == PaintingDirection.e && var6.m() && !var7.m()) {
				var8 = PaintingDirection.f;
			} else if (var8 == PaintingDirection.f && var7.m() && !var6.m()) {
				var8 = PaintingDirection.e;
			}

			var1.a(var2, var3.a(a, var8), 2);
		}
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			TileEntity var9 = var1.s(var2);
			if (var9 instanceof TileEntityFurnace) {
				var4.a((IInventory) ((TileEntityFurnace) var9));
			}

			return true;
		}
	}

	public static void a(boolean var0, World var1, Position var2) {
		bec var3 = var1.p(var2);
		TileEntity var4 = var1.s(var2);
		M = true;
		if (var0) {
			var1.a(var2, Blocks.am.P().a(a, var3.b(a)), 3);
			var1.a(var2, Blocks.am.P().a(a, var3.b(a)), 3);
		} else {
			var1.a(var2, Blocks.al.P().a(a, var3.b(a)), 3);
			var1.a(var2, Blocks.al.P().a(a, var3.b(a)), 3);
		}

		M = false;
		if (var4 != null) {
			var4.D();
			var1.a(var2, var4);
		}

	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityFurnace();
	}

	public bec a(World var1, Position var2, PaintingDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, var8.aO().d());
	}

	public void a(World var1, Position var2, bec var3, EntityLiving var4, ItemStack var5) {
		var1.a(var2, var3.a(a, var4.aO().d()), 2);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof TileEntityFurnace) {
				((TileEntityFurnace) var6).a(var5.q());
			}
		}

	}

	public void b(World var1, Position var2, bec var3) {
		if (!M) {
			TileEntity var4 = var1.s(var2);
			if (var4 instanceof TileEntityFurnace) {
				vs.a(var1, var2, (TileEntityFurnace) var4);
				var1.e(var2, this);
			}
		}

		super.b(var1, var2, var3);
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		return Container.a(var1.s(var2));
	}

	public int b() {
		return 3;
	}

	public bec a(int var1) {
		PaintingDirection var2 = PaintingDirection.a(var1);
		if (var2.k() == el.b) {
			var2 = PaintingDirection.c;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((PaintingDirection) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
