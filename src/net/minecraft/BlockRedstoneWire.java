package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {

	public static final bev a = bev.a("north", azu.class);
	public static final bev b = bev.a("east", azu.class);
	public static final bev M = bev.a("south", azu.class);
	public static final bev N = bev.a("west", azu.class);
	public static final bew O = bew.a("power", 0, 15);
	private boolean P = true;
	private final Set Q = Sets.newHashSet();

	public BlockRedstoneWire() {
		super(Material.ORIENTABLE);
		this.j(this.L.b().a(a, azu.c).a(b, azu.c).a(M, azu.c).a(N, azu.c).a(O, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	public bec a(bec var1, ard var2, Position var3) {
		var1 = var1.a(N, this.c(var2, var3, PaintingDirection.e));
		var1 = var1.a(b, this.c(var2, var3, PaintingDirection.f));
		var1 = var1.a(a, this.c(var2, var3, PaintingDirection.c));
		var1 = var1.a(M, this.c(var2, var3, PaintingDirection.d));
		return var1;
	}

	private azu c(ard var1, Position var2, PaintingDirection var3) {
		Position var4 = var2.a(var3);
		Block var5 = var1.p(var2.a(var3)).getBlock();
		if (!a(var1.p(var4), var3) && (var5.s() || !d(var1.p(var4.b())))) {
			Block var6 = var1.p(var2.a()).getBlock();
			return !var6.s() && var5.s() && d(var1.p(var4.a())) ? azu.a : azu.c;
		} else {
			return azu.b;
		}
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

	public boolean c(World var1, Position var2) {
		return World.a((ard) var1, var2.b()) || var1.p(var2.b()).getBlock() == aty.aX;
	}

	private bec e(World var1, Position var2, bec var3) {
		var3 = this.a(var1, var2, var2, var3);
		ArrayList var4 = Lists.newArrayList((Iterable) this.Q);
		this.Q.clear();
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			Position var6 = (Position) var5.next();
			var1.c(var6, (Block) this);
		}

		return var3;
	}

	private bec a(World var1, Position var2, Position var3, bec var4) {
		bec var5 = var4;
		int var6 = ((Integer) var4.b(O)).intValue();
		byte var7 = 0;
		int var14 = this.a(var1, var3, var7);
		this.P = false;
		int var8 = var1.A(var2);
		this.P = true;
		if (var8 > 0 && var8 > var14 - 1) {
			var14 = var8;
		}

		int var9 = 0;
		Iterator var10 = en.a.iterator();

		while (var10.hasNext()) {
			PaintingDirection var11 = (PaintingDirection) var10.next();
			Position var12 = var2.a(var11);
			boolean var13 = var12.getX() != var3.getX() || var12.getZ() != var3.getZ();
			if (var13) {
				var9 = this.a(var1, var12, var9);
			}

			if (var1.p(var12).getBlock().t() && !var1.p(var2.a()).getBlock().t()) {
				if (var13 && var2.getY() >= var3.getY()) {
					var9 = this.a(var1, var12.a(), var9);
				}
			} else if (!var1.p(var12).getBlock().t() && var13 && var2.getY() <= var3.getY()) {
				var9 = this.a(var1, var12.b(), var9);
			}
		}

		if (var9 > var14) {
			var14 = var9 - 1;
		} else if (var14 > 0) {
			--var14;
		} else {
			var14 = 0;
		}

		if (var8 > var14 - 1) {
			var14 = var8;
		}

		if (var6 != var14) {
			var4 = var4.a(O, Integer.valueOf(var14));
			if (var1.p(var2) == var5) {
				var1.a(var2, var4, 2);
			}

			this.Q.add(var2);
			PaintingDirection[] var15 = PaintingDirection.values();
			int var16 = var15.length;

			for (int var17 = 0; var17 < var16; ++var17) {
				PaintingDirection var18 = var15[var17];
				this.Q.add(var2.a(var18));
			}
		}

		return var4;
	}

	private void d(World var1, Position var2) {
		if (var1.p(var2).getBlock() == this) {
			var1.c(var2, (Block) this);
			PaintingDirection[] var3 = PaintingDirection.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				PaintingDirection var6 = var3[var5];
				var1.c(var2.a(var6), (Block) this);
			}

		}
	}

	public void c(World var1, Position var2, bec var3) {
		if (!var1.D) {
			this.e(var1, var2, var3);
			Iterator var4 = en.b.iterator();

			PaintingDirection var5;
			while (var4.hasNext()) {
				var5 = (PaintingDirection) var4.next();
				var1.c(var2.a(var5), (Block) this);
			}

			var4 = en.a.iterator();

			while (var4.hasNext()) {
				var5 = (PaintingDirection) var4.next();
				this.d(var1, var2.a(var5));
			}

			var4 = en.a.iterator();

			while (var4.hasNext()) {
				var5 = (PaintingDirection) var4.next();
				Position var6 = var2.a(var5);
				if (var1.p(var6).getBlock().t()) {
					this.d(var1, var6.a());
				} else {
					this.d(var1, var6.b());
				}
			}

		}
	}

	public void b(World var1, Position var2, bec var3) {
		super.b(var1, var2, var3);
		if (!var1.D) {
			PaintingDirection[] var4 = PaintingDirection.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				PaintingDirection var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}

			this.e(var1, var2, var3);
			Iterator var8 = en.a.iterator();

			PaintingDirection var9;
			while (var8.hasNext()) {
				var9 = (PaintingDirection) var8.next();
				this.d(var1, var2.a(var9));
			}

			var8 = en.a.iterator();

			while (var8.hasNext()) {
				var9 = (PaintingDirection) var8.next();
				Position var10 = var2.a(var9);
				if (var1.p(var10).getBlock().t()) {
					this.d(var1, var10.a());
				} else {
					this.d(var1, var10.b());
				}
			}

		}
	}

	private int a(World var1, Position var2, int var3) {
		if (var1.p(var2).getBlock() != this) {
			return var3;
		} else {
			int var4 = ((Integer) var1.p(var2).b(O)).intValue();
			return var4 > var3 ? var4 : var3;
		}
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			if (this.c(var1, var2)) {
				this.e(var1, var2, var3);
			} else {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			}

		}
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.aC;
	}

	public int b(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return !this.P ? 0 : this.a(var1, var2, var3, var4);
	}

	public int a(ard var1, Position var2, bec var3, PaintingDirection var4) {
		if (!this.P) {
			return 0;
		} else {
			int var5 = ((Integer) var3.b(O)).intValue();
			if (var5 == 0) {
				return 0;
			} else if (var4 == PaintingDirection.b) {
				return var5;
			} else {
				EnumSet var6 = EnumSet.noneOf(PaintingDirection.class);
				Iterator var7 = en.a.iterator();

				while (var7.hasNext()) {
					PaintingDirection var8 = (PaintingDirection) var7.next();
					if (this.d(var1, var2, var8)) {
						var6.add(var8);
					}
				}

				if (var4.k().c() && var6.isEmpty()) {
					return var5;
				} else if (var6.contains(var4) && !var6.contains(var4.f()) && !var6.contains(var4.e())) {
					return var5;
				} else {
					return 0;
				}
			}
		}
	}

	private boolean d(ard var1, Position var2, PaintingDirection var3) {
		Position var4 = var2.a(var3);
		bec var5 = var1.p(var4);
		Block var6 = var5.getBlock();
		boolean var7 = var6.t();
		boolean var8 = var1.p(var2.a()).getBlock().t();
		return !var8 && var7 && e(var1, var4.a()) ? true : (a(var5, var3) ? true : (var6 == aty.bc && var5.b(ava.N) == var3 ? true : !var7 && e(var1, var4.b())));
	}

	protected static boolean e(ard var0, Position var1) {
		return d(var0.p(var1));
	}

	protected static boolean d(bec var0) {
		return a(var0, (PaintingDirection) null);
	}

	protected static boolean a(bec var0, PaintingDirection var1) {
		Block var2 = var0.getBlock();
		if (var2 == aty.af) {
			return true;
		} else if (aty.bb.e(var2)) {
			PaintingDirection var3 = (PaintingDirection) var0.b(BlockRepeater.N);
			return var3 == var1 || var3.d() == var1;
		} else {
			return var2.g() && var1 != null;
		}
	}

	public boolean g() {
		return this.P;
	}

	public bec a(int var1) {
		return this.P().a(O, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(O)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, M, N, O });
	}

}
