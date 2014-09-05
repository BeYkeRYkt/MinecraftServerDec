package net.minecraft;

import java.util.Random;

public class awd extends atg {

	public static final bew a = bew.a("legacy_data", 0, 15);
	public static final bev b = bev.a("contents", awf.class);

	public awd() {
		super(bof.q);
		this.j(this.L.b().a(b, awf.a).a(a, Integer.valueOf(0)));
		this.h();
	}

	public void h() {
		float var1 = 0.375F;
		float var2 = var1 / 2.0F;
		this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
	}

	public boolean c() {
		return false;
	}

	public int b() {
		return 3;
	}

	public boolean d() {
		return false;
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		ItemStack var9 = var4.playerInventory.getItemInHand();
		if (var9 != null && var9.getItem() instanceof aju) {
			bdb var10 = this.d(var1, var2);
			if (var10 == null) {
				return false;
			} else if (var10.b() != null) {
				return false;
			} else {
				Block var11 = Block.a(var9.getItem());
				if (!this.a(var11, var9.i())) {
					return false;
				} else {
					var10.a(var9.getItem(), var9.i());
					var10.o_();
					var1.h(var2);
					if (!var4.by.instabuild && --var9.b <= 0) {
						var4.playerInventory.a(var4.playerInventory.c, (ItemStack) null);
					}

					return true;
				}
			}
		} else {
			return false;
		}
	}

	private boolean a(Block var1, int var2) {
		return var1 != aty.N && var1 != aty.O && var1 != aty.aK && var1 != aty.P && var1 != aty.Q && var1 != aty.g && var1 != aty.I ? var1 == aty.H && var2 == bbi.c.a() : true;
	}

	public int j(World var1, Position var2) {
		bdb var3 = this.d(var1, var2);
		return var3 != null && var3.b() != null ? var3.c() : 0;
	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) && World.a((ard) var1, var2.b());
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!World.a((ard) var1, var2.b())) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	public void b(World var1, Position var2, bec var3) {
		bdb var4 = this.d(var1, var2);
		if (var4 != null && var4.b() != null) {
			a(var1, var2, new ItemStack(var4.b(), 1, var4.c()));
		}

		super.b(var1, var2, var3);
	}

	public void a(World var1, Position var2, bec var3, EntityHuman var4) {
		super.a(var1, var2, var3, var4);
		if (var4.by.instabuild) {
			bdb var5 = this.d(var1, var2);
			if (var5 != null) {
				var5.a((Item) null, 0);
			}
		}

	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.bQ;
	}

	private bdb d(World var1, Position var2) {
		bcm var3 = var1.s(var2);
		return var3 instanceof bdb ? (bdb) var3 : null;
	}

	public bcm a(World var1, int var2) {
		Object var3 = null;
		int var4 = 0;
		switch (var2) {
			case 1:
				var3 = aty.O;
				var4 = awa.b.b();
				break;
			case 2:
				var3 = aty.N;
				break;
			case 3:
				var3 = aty.g;
				var4 = ayx.a.a();
				break;
			case 4:
				var3 = aty.g;
				var4 = ayx.b.a();
				break;
			case 5:
				var3 = aty.g;
				var4 = ayx.c.a();
				break;
			case 6:
				var3 = aty.g;
				var4 = ayx.d.a();
				break;
			case 7:
				var3 = aty.Q;
				break;
			case 8:
				var3 = aty.P;
				break;
			case 9:
				var3 = aty.aK;
				break;
			case 10:
				var3 = aty.I;
				break;
			case 11:
				var3 = aty.H;
				var4 = bbi.c.a();
				break;
			case 12:
				var3 = aty.g;
				var4 = ayx.e.a();
				break;
			case 13:
				var3 = aty.g;
				var4 = ayx.f.a();
		}

		return new bdb(Item.getItemOf((Block) var3), var4);
	}

	protected bed e() {
		return new bed(this, new bex[] { b, a });
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	public bec a(bec var1, ard var2, Position var3) {
		awf var4 = awf.a;
		bcm var5 = var2.s(var3);
		if (var5 instanceof bdb) {
			bdb var6 = (bdb) var5;
			Item var7 = var6.b();
			if (var7 instanceof aju) {
				int var8 = var6.c();
				Block var9 = Block.a(var7);
				if (var9 == aty.g) {
					switch (awe.a[ayx.a(var8).ordinal()]) {
						case 1:
							var4 = awf.l;
							break;
						case 2:
							var4 = awf.m;
							break;
						case 3:
							var4 = awf.n;
							break;
						case 4:
							var4 = awf.o;
							break;
						case 5:
							var4 = awf.p;
							break;
						case 6:
							var4 = awf.q;
							break;
						default:
							var4 = awf.a;
					}
				} else if (var9 == aty.H) {
					switch (var8) {
						case 0:
							var4 = awf.t;
							break;
						case 2:
							var4 = awf.u;
							break;
						default:
							var4 = awf.a;
					}
				} else if (var9 == aty.N) {
					var4 = awf.k;
				} else if (var9 == aty.O) {
					switch (awe.b[awa.a(awc.b, var8).ordinal()]) {
						case 1:
							var4 = awf.b;
							break;
						case 2:
							var4 = awf.c;
							break;
						case 3:
							var4 = awf.d;
							break;
						case 4:
							var4 = awf.e;
							break;
						case 5:
							var4 = awf.f;
							break;
						case 6:
							var4 = awf.g;
							break;
						case 7:
							var4 = awf.h;
							break;
						case 8:
							var4 = awf.i;
							break;
						case 9:
							var4 = awf.j;
							break;
						default:
							var4 = awf.a;
					}
				} else if (var9 == aty.Q) {
					var4 = awf.r;
				} else if (var9 == aty.P) {
					var4 = awf.s;
				} else if (var9 == aty.I) {
					var4 = awf.t;
				} else if (var9 == aty.aK) {
					var4 = awf.v;
				}
			}
		}

		return var1.a(b, var4);
	}

}
