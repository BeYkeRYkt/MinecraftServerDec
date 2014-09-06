package net.minecraft;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class BlockTripwireHook extends Block {

	public static final beu a = beu.a("facing", (Predicate) en.a);
	public static final bet b = bet.a("powered");
	public static final bet M = bet.a("attached");
	public static final bet N = bet.a("suspended");

	public BlockTripwireHook() {
		super(Material.ORIENTABLE);
		this.j(this.L.b().a(a, BlockFace.c).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)));
		this.a(CreativeModeTab.REDSTONE);
		this.a(true);
	}

	public bec a(bec var1, ard var2, Position var3) {
		return var1.a(N, Boolean.valueOf(!World.a(var2, var3.b())));
	}

	public brt a(World var1, Position var2, bec var3) {
		return null;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean a(World var1, Position var2, BlockFace var3) {
		return var3.k().c() && var1.p(var2.a(var3.d())).getBlock().t();
	}

	public boolean c(World var1, Position var2) {
		Iterator var3 = en.a.iterator();

		BlockFace var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (BlockFace) var3.next();
		} while (!var1.p(var2.a(var4)).getBlock().t());

		return true;
	}

	public bec a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		bec var9 = this.P().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false));
		if (var3.k().c()) {
			var9 = var9.a(a, var3);
		}

		return var9;
	}

	public void a(World var1, Position var2, bec var3, EntityLiving var4, ItemStack var5) {
		this.a(var1, var2, var3, false, false, -1, (bec) null);
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (var4 != this) {
			if (this.e(var1, var2, var3)) {
				BlockFace var5 = (BlockFace) var3.b(a);
				if (!var1.p(var2.a(var5.d())).getBlock().t()) {
					this.b(var1, var2, var3, 0);
					var1.g(var2);
				}
			}

		}
	}

	public void a(World var1, Position var2, bec var3, boolean var4, boolean var5, int var6, bec var7) {
		BlockFace var8 = (BlockFace) var3.b(a);
		boolean var9 = ((Boolean) var3.b(M)).booleanValue();
		boolean var10 = ((Boolean) var3.b(b)).booleanValue();
		boolean var11 = !World.a((ard) var1, var2.b());
		boolean var12 = !var4;
		boolean var13 = false;
		int var14 = 0;
		bec[] var15 = new bec[42];

		Position var17;
		for (int var16 = 1; var16 < 42; ++var16) {
			var17 = var2.a(var8, var16);
			bec var18 = var1.p(var17);
			if (var18.getBlock() == Blocks.TRIPWIRE_HOOK) {
				if (var18.b(a) == var8.d()) {
					var14 = var16;
				}
				break;
			}

			if (var18.getBlock() != Blocks.TRIPWIRE && var16 != var6) {
				var15[var16] = null;
				var12 = false;
			} else {
				if (var16 == var6) {
					var18 = (bec) Objects.firstNonNull(var7, var18);
				}

				boolean var19 = !((Boolean) var18.b(BlockTripwire.N)).booleanValue();
				boolean var20 = ((Boolean) var18.b(BlockTripwire.a)).booleanValue();
				boolean var21 = ((Boolean) var18.b(BlockTripwire.b)).booleanValue();
				var12 &= var21 == var11;
				var13 |= var19 && var20;
				var15[var16] = var18;
				if (var16 == var6) {
					var1.a(var2, (Block) this, this.a(var1));
					var12 &= var19;
				}
			}
		}

		var12 &= var14 > 1;
		var13 &= var12;
		bec var22 = this.P().a(M, Boolean.valueOf(var12)).a(b, Boolean.valueOf(var13));
		if (var14 > 0) {
			var17 = var2.a(var8, var14);
			BlockFace var24 = var8.d();
			var1.a(var17, var22.a(a, var24), 3);
			this.b(var1, var17, var24);
			this.a(var1, var17, var12, var13, var9, var10);
		}

		this.a(var1, var2, var12, var13, var9, var10);
		if (!var4) {
			var1.a(var2, var22.a(a, var8), 3);
			if (var5) {
				this.b(var1, var2, var8);
			}
		}

		if (var9 != var12) {
			for (int var23 = 1; var23 < var14; ++var23) {
				Position var25 = var2.a(var8, var23);
				bec var26 = var15[var23];
				if (var26 != null && var1.p(var25).getBlock() != Blocks.AIR) {
					var1.a(var25, var26.a(M, Boolean.valueOf(var12)), 3);
				}
			}
		}

	}

	public void a(World var1, Position var2, bec var3, Random var4) {
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		this.a(var1, var2, var3, false, true, -1, (bec) null);
	}

	private void a(World var1, Position var2, boolean var3, boolean var4, boolean var5, boolean var6) {
		if (var4 && !var6) {
			var1.a((double) var2.getX() + 0.5D, (double) var2.getY() + 0.1D, (double) var2.getZ() + 0.5D, "random.click", 0.4F, 0.6F);
		} else if (!var4 && var6) {
			var1.a((double) var2.getX() + 0.5D, (double) var2.getY() + 0.1D, (double) var2.getZ() + 0.5D, "random.click", 0.4F, 0.5F);
		} else if (var3 && !var5) {
			var1.a((double) var2.getX() + 0.5D, (double) var2.getY() + 0.1D, (double) var2.getZ() + 0.5D, "random.click", 0.4F, 0.7F);
		} else if (!var3 && var5) {
			var1.a((double) var2.getX() + 0.5D, (double) var2.getY() + 0.1D, (double) var2.getZ() + 0.5D, "random.bowhit", 0.4F, 1.2F / (var1.s.nextFloat() * 0.2F + 0.9F));
		}

	}

	private void b(World var1, Position var2, BlockFace var3) {
		var1.c(var2, (Block) this);
		var1.c(var2.a(var3.d()), (Block) this);
	}

	private boolean e(World var1, Position var2, bec var3) {
		if (!this.c(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	public void a(ard var1, Position var2) {
		float var3 = 0.1875F;
		switch (bbu.a[((BlockFace) var1.p(var2).b(a)).ordinal()]) {
			case 1:
				this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
				break;
			case 2:
				this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
				break;
			case 3:
				this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
				break;
			case 4:
				this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
		}

	}

	public void b(World var1, Position var2, bec var3) {
		boolean var4 = ((Boolean) var3.b(M)).booleanValue();
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		if (var4 || var5) {
			this.a(var1, var2, var3, true, false, -1, (bec) null);
		}

		if (var5) {
			var1.c(var2, (Block) this);
			var1.c(var2.a(((BlockFace) var3.b(a)).d()), (Block) this);
		}

		super.b(var1, var2, var3);
	}

	public int a(ard var1, Position var2, bec var3, BlockFace var4) {
		return ((Boolean) var3.b(b)).booleanValue() ? 15 : 0;
	}

	public int b(ard var1, Position var2, bec var3, BlockFace var4) {
		return !((Boolean) var3.b(b)).booleanValue() ? 0 : (var3.b(a) == var4 ? 15 : 0);
	}

	public boolean g() {
		return true;
	}

	public bec a(int var1) {
		return this.P().a(a, BlockFace.fromByte(var1 & 3)).a(b, Boolean.valueOf((var1 & 8) > 0)).a(M, Boolean.valueOf((var1 & 4) > 0));
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(a)).toByte();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		if (((Boolean) var1.b(M)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M, N });
	}

}
