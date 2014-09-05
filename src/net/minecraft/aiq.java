package net.minecraft;

import java.util.List;
import java.util.Random;

public class aiq extends Container {

	public IInventory a = new air(this, "Enchant", true, 2);
	private World i;
	private Position j;
	private Random k = new Random();
	public int f;
	public int[] g = new int[3];
	public int[] h = new int[] { -1, -1, -1 };

	public aiq(PlayerInventory var1, World var2, Position var3) {
		this.i = var2;
		this.j = var3;
		this.f = var1.d.ci();
		this.a((ajk) (new ais(this, this.a, 0, 15, 47)));
		this.a((ajk) (new ait(this, this.a, 1, 35, 47)));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.a(new ajk(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a(new ajk(var1, var4, 8 + var4 * 18, 142));
		}

	}

	public void a(ICrafting var1) {
		super.a(var1);
		var1.a(this, 0, this.g[0]);
		var1.a(this, 1, this.g[1]);
		var1.a(this, 2, this.g[2]);
		var1.a(this, 3, this.f & -16);
		var1.a(this, 4, this.h[0]);
		var1.a(this, 5, this.h[1]);
		var1.a(this, 6, this.h[2]);
	}

	public void b() {
		super.b();

		for (int var1 = 0; var1 < this.e.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.e.get(var1);
			var2.a(this, 0, this.g[0]);
			var2.a(this, 1, this.g[1]);
			var2.a(this, 2, this.g[2]);
			var2.a(this, 3, this.f & -16);
			var2.a(this, 4, this.h[0]);
			var2.a(this, 5, this.h[1]);
			var2.a(this, 6, this.h[2]);
		}

	}

	public void a(IInventory var1) {
		if (var1 == this.a) {
			ItemStack var2 = var1.a(0);
			int var3;
			if (var2 != null && var2.v()) {
				if (!this.i.D) {
					var3 = 0;

					int var4;
					for (var4 = -1; var4 <= 1; ++var4) {
						for (int var5 = -1; var5 <= 1; ++var5) {
							if ((var4 != 0 || var5 != 0) && this.i.d(this.j.a(var5, 0, var4)) && this.i.d(this.j.a(var5, 1, var4))) {
								if (this.i.p(this.j.a(var5 * 2, 0, var4 * 2)).c() == aty.X) {
									++var3;
								}

								if (this.i.p(this.j.a(var5 * 2, 1, var4 * 2)).c() == aty.X) {
									++var3;
								}

								if (var5 != 0 && var4 != 0) {
									if (this.i.p(this.j.a(var5 * 2, 0, var4)).c() == aty.X) {
										++var3;
									}

									if (this.i.p(this.j.a(var5 * 2, 1, var4)).c() == aty.X) {
										++var3;
									}

									if (this.i.p(this.j.a(var5, 0, var4 * 2)).c() == aty.X) {
										++var3;
									}

									if (this.i.p(this.j.a(var5, 1, var4 * 2)).c() == aty.X) {
										++var3;
									}
								}
							}
						}
					}

					this.k.setSeed((long) this.f);

					for (var4 = 0; var4 < 3; ++var4) {
						this.g[var4] = aph.a(this.k, var4, var3, var2);
						this.h[var4] = -1;
						if (this.g[var4] < var4 + 1) {
							this.g[var4] = 0;
						}
					}

					for (var4 = 0; var4 < 3; ++var4) {
						if (this.g[var4] > 0) {
							List var7 = this.a(var2, var4, this.g[var4]);
							if (var7 != null && !var7.isEmpty()) {
								apo var6 = (apo) var7.get(this.k.nextInt(var7.size()));
								this.h[var4] = var6.b.B | var6.c << 8;
							}
						}
					}

					this.b();
				}
			} else {
				for (var3 = 0; var3 < 3; ++var3) {
					this.g[var3] = 0;
					this.h[var3] = -1;
				}
			}
		}

	}

	public boolean a(EntityHuman var1, int var2) {
		ItemStack var3 = this.a.a(0);
		ItemStack var4 = this.a.a(1);
		int var5 = var2 + 1;
		if ((var4 == null || var4.b < var5) && !var1.by.instabuild) {
			return false;
		} else if (this.g[var2] > 0 && var3 != null && (var1.bz >= var5 && var1.bz >= this.g[var2] || var1.by.instabuild)) {
			if (!this.i.D) {
				List var6 = this.a(var3, var2, this.g[var2]);
				boolean var7 = var3.getItem() == amk.aL;
				if (var6 != null) {
					var1.b(var5);
					if (var7) {
						var3.a((Item) amk.cd);
					}

					for (int var8 = 0; var8 < var6.size(); ++var8) {
						apo var9 = (apo) var6.get(var8);
						if (var7) {
							amk.cd.a(var3, var9);
						} else {
							var3.a(var9.b, var9.c);
						}
					}

					if (!var1.by.instabuild) {
						var4.b -= var5;
						if (var4.b <= 0) {
							this.a.a(1, (ItemStack) null);
						}
					}

					this.a.o_();
					this.f = var1.ci();
					this.a(this.a);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	private List a(ItemStack var1, int var2, int var3) {
		this.k.setSeed((long) (this.f + var2));
		List var4 = aph.b(this.k, var1, var3);
		if (var1.getItem() == amk.aL && var4 != null && var4.size() > 1) {
			var4.remove(this.k.nextInt(var4.size()));
		}

		return var4;
	}

	public void b(EntityHuman var1) {
		super.b(var1);
		if (!this.i.D) {
			for (int var2 = 0; var2 < this.a.n_(); ++var2) {
				ItemStack var3 = this.a.b(var2);
				if (var3 != null) {
					var1.a(var3, false);
				}
			}

		}
	}

	public boolean a(EntityHuman var1) {
		return this.i.p(this.j).c() != aty.bC ? false : var1.e((double) this.j.n() + 0.5D, (double) this.j.o() + 0.5D, (double) this.j.p() + 0.5D) <= 64.0D;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			ItemStack var5 = var4.d();
			var3 = var5.getCopy();
			if (var2 == 0) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if (var2 == 1) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if (var5.getItem() == amk.aW && akv.a(var5.i()) == akv.l) {
				if (!this.a(var5, 1, 2, true)) {
					return null;
				}
			} else {
				if (((ajk) this.c.get(0)).e() || !((ajk) this.c.get(0)).a(var5)) {
					return null;
				}

				if (var5.hasTag() && var5.b == 1) {
					((ajk) this.c.get(0)).d(var5.getCopy());
					var5.b = 0;
				} else if (var5.b >= 1) {
					((ajk) this.c.get(0)).d(new ItemStack(var5.getItem(), 1, var5.i()));
					--var5.b;
				}
			}

			if (var5.b == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}
}
