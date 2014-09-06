package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BlockTripwire extends Block {

	public static final bet a = bet.a("powered");
	public static final bet b = bet.a("suspended");
	public static final bet M = bet.a("attached");
	public static final bet N = bet.a("disarmed");
	public static final bet O = bet.a("north");
	public static final bet P = bet.a("east");
	public static final bet Q = bet.a("south");
	public static final bet R = bet.a("west");

	public BlockTripwire() {
		super(Material.ORIENTABLE);
		this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)).a(R, Boolean.valueOf(false)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
		this.a(true);
	}

	public bec a(bec var1, ard var2, Position var3) {
		return var1.a(O, Boolean.valueOf(c(var2, var3, var1, PaintingDirection.c))).a(P, Boolean.valueOf(c(var2, var3, var1, PaintingDirection.f))).a(Q, Boolean.valueOf(c(var2, var3, var1, PaintingDirection.d))).a(R, Boolean.valueOf(c(var2, var3, var1, PaintingDirection.e)));
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

	public Item a(bec var1, Random var2, int var3) {
		return amk.F;
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		boolean var6 = !World.a((ard) var1, var2.b());
		if (var5 != var6) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	public void a(ard var1, Position var2) {
		bec var3 = var1.p(var2);
		boolean var4 = ((Boolean) var3.b(M)).booleanValue();
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		if (!var5) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
		} else if (!var4) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		} else {
			this.a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
		}

	}

	public void c(World var1, Position var2, bec var3) {
		var3 = var3.a(b, Boolean.valueOf(!World.a((ard) var1, var2.b())));
		var1.a(var2, var3, 3);
		this.e(var1, var2, var3);
	}

	public void b(World var1, Position var2, bec var3) {
		this.e(var1, var2, var3.a(a, Boolean.valueOf(true)));
	}

	public void a(World var1, Position var2, bec var3, EntityHuman var4) {
		if (!var1.D) {
			if (var4.bY() != null && var4.bY().getItem() == amk.be) {
				var1.a(var2, var3.a(N, Boolean.valueOf(true)), 4);
			}

		}
	}

	private void e(World var1, Position var2, bec var3) {
		PaintingDirection[] var4 = new PaintingDirection[] { PaintingDirection.d, PaintingDirection.e };
		int var5 = var4.length;
		int var6 = 0;

		while (var6 < var5) {
			PaintingDirection var7 = var4[var6];
			int var8 = 1;

			while (true) {
				if (var8 < 42) {
					Position var9 = var2.a(var7, var8);
					bec var10 = var1.p(var9);
					if (var10.getBlock() == aty.bR) {
						if (var10.b(BlockTripwireHook.a) == var7.d()) {
							aty.bR.a(var1, var9, var10, false, true, var8, var3);
						}
					} else if (var10.getBlock() == aty.bS) {
						++var8;
						continue;
					}
				}

				++var6;
				break;
			}
		}

	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		if (!var1.D) {
			if (!((Boolean) var3.b(a)).booleanValue()) {
				this.d(var1, var2);
			}
		}
	}

	public void a(World var1, Position var2, bec var3, Random var4) {
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var1.p(var2).b(a)).booleanValue()) {
				this.d(var1, var2);
			}
		}
	}

	private void d(World var1, Position var2) {
		bec var3 = var1.p(var2);
		boolean var4 = ((Boolean) var3.b(a)).booleanValue();
		boolean var5 = false;
		List var6 = var1.b((Entity) null, new brt((double) var2.getX() + this.B, (double) var2.getY() + this.C, (double) var2.getZ() + this.D, (double) var2.getX() + this.E, (double) var2.getY() + this.F, (double) var2.getZ() + this.G));
		if (!var6.isEmpty()) {
			Iterator var7 = var6.iterator();

			while (var7.hasNext()) {
				Entity var8 = (Entity) var7.next();
				if (!var8.aH()) {
					var5 = true;
					break;
				}
			}
		}

		if (var5 != var4) {
			var3 = var3.a(a, Boolean.valueOf(var5));
			var1.a(var2, var3, 3);
			this.e(var1, var2, var3);
		}

		if (var5) {
			var1.a(var2, (Block) this, this.a(var1));
		}

	}

	public static boolean c(ard var0, Position var1, bec var2, PaintingDirection var3) {
		Position var4 = var1.a(var3);
		bec var5 = var0.p(var4);
		Block var6 = var5.getBlock();
		if (var6 == aty.bR) {
			PaintingDirection var9 = var3.d();
			return var5.b(BlockTripwireHook.a) == var9;
		} else if (var6 == aty.bS) {
			boolean var7 = ((Boolean) var2.b(b)).booleanValue();
			boolean var8 = ((Boolean) var5.b(b)).booleanValue();
			return var7 == var8;
		} else {
			return false;
		}
	}

	public bec a(int var1) {
		return this.P().a(a, Boolean.valueOf((var1 & 1) > 0)).a(b, Boolean.valueOf((var1 & 2) > 0)).a(M, Boolean.valueOf((var1 & 4) > 0)).a(N, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(bec var1) {
		int var2 = 0;
		if (((Boolean) var1.b(a)).booleanValue()) {
			var2 |= 1;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var2 |= 2;
		}

		if (((Boolean) var1.b(M)).booleanValue()) {
			var2 |= 4;
		}

		if (((Boolean) var1.b(N)).booleanValue()) {
			var2 |= 8;
		}

		return var2;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M, N, O, P, R, Q });
	}

}
