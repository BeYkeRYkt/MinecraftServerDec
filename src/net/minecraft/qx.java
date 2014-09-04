package net.minecraft;

public class qx {

	public World a;
	public EntityPlayer b;
	private GameMode c;
	private boolean d;
	private int e;
	private dt f;
	private int g;
	private boolean h;
	private dt i;
	private int j;
	private int k;

	public qx(World var1) {
		this.c = GameMode.NOT_SET;
		this.f = dt.a;
		this.i = dt.a;
		this.k = -1;
		this.a = var1;
	}

	public void a(GameMode var1) {
		this.c = var1;
		var1.setGameModeProperties(this.b.by);
		this.b.t();
		this.b.b.getPlayerList().a((id) (new kh(kj.b, new EntityPlayer[] { this.b })));
	}

	public GameMode b() {
		return this.c;
	}

	public boolean c() {
		return this.c.isSurvivalOrAdventure();
	}

	public boolean d() {
		return this.c.isCreative();
	}

	public void b(GameMode var1) {
		if (this.c == GameMode.NOT_SET) {
			this.c = var1;
		}

		this.a(this.c);
	}

	public void a() {
		++this.g;
		float var3;
		int var4;
		if (this.h) {
			int var1 = this.g - this.j;
			atr var2 = this.a.p(this.i).c();
			if (var2.r() == bof.a) {
				this.h = false;
			} else {
				var3 = var2.a((ahd) this.b, this.b.o, this.i) * (float) (var1 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.a.c(this.b.F(), this.i, var4);
					this.k = var4;
				}

				if (var3 >= 1.0F) {
					this.h = false;
					this.b(this.i);
				}
			}
		} else if (this.d) {
			atr var5 = this.a.p(this.f).c();
			if (var5.r() == bof.a) {
				this.a.c(this.b.F(), this.f, -1);
				this.k = -1;
				this.d = false;
			} else {
				int var6 = this.g - this.e;
				var3 = var5.a((ahd) this.b, this.b.o, this.i) * (float) (var6 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.a.c(this.b.F(), this.f, var4);
					this.k = var4;
				}
			}
		}

	}

	public void a(dt var1, ej var2) {
		if (this.d()) {
			if (!this.a.a((ahd) null, var1, var2)) {
				this.b(var1);
			}

		} else {
			atr var3 = this.a.p(var1).c();
			if (this.c.buildDisallowed()) {
				if (this.c == GameMode.SPECTATOR) {
					return;
				}

				if (!this.b.cm()) {
					amj var4 = this.b.bY();
					if (var4 == null) {
						return;
					}

					if (!var4.c(var3)) {
						return;
					}
				}
			}

			this.a.a((ahd) null, var1, var2);
			this.e = this.g;
			float var6 = 1.0F;
			if (var3.r() != bof.a) {
				var3.a(this.a, var1, (ahd) this.b);
				var6 = var3.a((ahd) this.b, this.b.o, var1);
			}

			if (var3.r() != bof.a && var6 >= 1.0F) {
				this.b(var1);
			} else {
				this.d = true;
				this.f = var1;
				int var5 = (int) (var6 * 10.0F);
				this.a.c(this.b.F(), var1, var5);
				this.k = var5;
			}

		}
	}

	public void a(dt var1) {
		if (var1.equals(this.f)) {
			int var2 = this.g - this.e;
			atr var3 = this.a.p(var1).c();
			if (var3.r() != bof.a) {
				float var4 = var3.a((ahd) this.b, this.b.o, var1) * (float) (var2 + 1);
				if (var4 >= 0.7F) {
					this.d = false;
					this.a.c(this.b.F(), var1, -1);
					this.b(var1);
				} else if (!this.h) {
					this.d = false;
					this.h = true;
					this.i = var1;
					this.j = this.e;
				}
			}
		}

	}

	public void e() {
		this.d = false;
		this.a.c(this.b.F(), this.f, -1);
	}

	private boolean c(dt var1) {
		bec var2 = this.a.p(var1);
		var2.c().a(this.a, var1, var2, (ahd) this.b);
		boolean var3 = this.a.g(var1);
		if (var3) {
			var2.c().d(this.a, var1, var2);
		}

		return var3;
	}

	public boolean b(dt var1) {
		if (this.c.isCreative() && this.b.bz() != null && this.b.bz().b() instanceof anm) {
			return false;
		} else {
			bec var2 = this.a.p(var1);
			bcm var3 = this.a.s(var1);
			if (this.c.buildDisallowed()) {
				if (this.c == GameMode.SPECTATOR) {
					return false;
				}

				if (!this.b.cm()) {
					amj var4 = this.b.bY();
					if (var4 == null) {
						return false;
					}

					if (!var4.c(var2.c())) {
						return false;
					}
				}
			}

			this.a.a(this.b, 2001, var1, atr.f(var2));
			boolean var7 = this.c(var1);
			if (this.d()) {
				this.b.a.a((id) (new iw(this.a, var1)));
			} else {
				amj var5 = this.b.bY();
				boolean var6 = this.b.b(var2.c());
				if (var5 != null) {
					var5.a(this.a, var2.c(), var1, this.b);
					if (var5.b == 0) {
						this.b.bZ();
					}
				}

				if (var7 && var6) {
					var2.c().a(this.a, (ahd) this.b, var1, var2, var3);
				}
			}

			return var7;
		}
	}

	public boolean a(ahd var1, World var2, amj var3) {
		if (this.c == GameMode.SPECTATOR) {
			return false;
		} else {
			int var4 = var3.b;
			int var5 = var3.i();
			amj var6 = var3.a(var2, var1);
			if (var6 == var3 && (var6 == null || var6.b == var4 && var6.l() <= 0 && var6.i() == var5)) {
				return false;
			} else {
				var1.bg.a[var1.bg.c] = var6;
				if (this.d()) {
					var6.b = var4;
					if (var6.e()) {
						var6.b(var5);
					}
				}

				if (var6.b == 0) {
					var1.bg.a[var1.bg.c] = null;
				}

				if (!var1.bR()) {
					((EntityPlayer) var1).a(var1.bh);
				}

				return true;
			}
		}
	}

	public boolean a(ahd var1, World var2, amj var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (this.c == GameMode.SPECTATOR) {
			bcm var13 = var2.s(var4);
			if (var13 instanceof vy) {
				atr var14 = var2.p(var4).c();
				vy var15 = (vy) var13;
				if (var15 instanceof bcr && var14 instanceof auj) {
					var15 = ((auj) var14).d(var2, var4);
				}

				if (var15 != null) {
					var1.a((vq) var15);
					return true;
				}
			} else if (var13 instanceof vq) {
				var1.a((vq) var13);
				return true;
			}

			return false;
		} else {
			if (!var1.aw() || var1.bz() == null) {
				bec var9 = var2.p(var4);
				if (var9.c().a(var2, var4, var9, var1, var5, var6, var7, var8)) {
					return true;
				}
			}

			if (var3 == null) {
				return false;
			} else if (this.d()) {
				int var12 = var3.i();
				int var10 = var3.b;
				boolean var11 = var3.a(var1, var2, var4, var5, var6, var7, var8);
				var3.b(var12);
				var3.b = var10;
				return var11;
			} else {
				return var3.a(var1, var2, var4, var5, var6, var7, var8);
			}
		}
	}

	public void a(WorldServer var1) {
		this.a = var1;
	}
}
