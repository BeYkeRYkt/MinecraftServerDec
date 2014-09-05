package net.minecraft;

public class qx {

	public World a;
	public EntityPlayer b;
	private GameMode gameMode;
	private boolean d;
	private int e;
	private Position f;
	private int g;
	private boolean h;
	private Position i;
	private int j;
	private int k;

	public qx(World var1) {
		this.gameMode = GameMode.NOT_SET;
		this.f = Position.a;
		this.i = Position.a;
		this.k = -1;
		this.a = var1;
	}

	public void a(GameMode var1) {
		this.gameMode = var1;
		var1.setGameModeProperties(this.b.by);
		this.b.t();
		this.b.b.getPlayerList().sendPacket((Packet) (new kh(kj.b, new EntityPlayer[] { this.b })));
	}

	public GameMode getGameMode() {
		return this.gameMode;
	}

	public boolean c() {
		return this.gameMode.isSurvivalOrAdventure();
	}

	public boolean d() {
		return this.gameMode.isCreative();
	}

	public void b(GameMode var1) {
		if (this.gameMode == GameMode.NOT_SET) {
			this.gameMode = var1;
		}

		this.a(this.gameMode);
	}

	public void a() {
		++this.g;
		float var3;
		int var4;
		if (this.h) {
			int var1 = this.g - this.j;
			Block var2 = this.a.p(this.i).c();
			if (var2.r() == Material.AIR) {
				this.h = false;
			} else {
				var3 = var2.a((EntityHuman) this.b, this.b.o, this.i) * (float) (var1 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.a.c(this.b.getId(), this.i, var4);
					this.k = var4;
				}

				if (var3 >= 1.0F) {
					this.h = false;
					this.b(this.i);
				}
			}
		} else if (this.d) {
			Block var5 = this.a.p(this.f).c();
			if (var5.r() == Material.AIR) {
				this.a.c(this.b.getId(), this.f, -1);
				this.k = -1;
				this.d = false;
			} else {
				int var6 = this.g - this.e;
				var3 = var5.a((EntityHuman) this.b, this.b.o, this.i) * (float) (var6 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != this.k) {
					this.a.c(this.b.getId(), this.f, var4);
					this.k = var4;
				}
			}
		}

	}

	public void a(Position var1, PaintingDirection var2) {
		if (this.d()) {
			if (!this.a.a((EntityHuman) null, var1, var2)) {
				this.b(var1);
			}

		} else {
			Block var3 = this.a.p(var1).c();
			if (this.gameMode.buildDisallowed()) {
				if (this.gameMode == GameMode.SPECTATOR) {
					return;
				}

				if (!this.b.cm()) {
					ItemStack var4 = this.b.bY();
					if (var4 == null) {
						return;
					}

					if (!var4.c(var3)) {
						return;
					}
				}
			}

			this.a.a((EntityHuman) null, var1, var2);
			this.e = this.g;
			float var6 = 1.0F;
			if (var3.r() != Material.AIR) {
				var3.a(this.a, var1, (EntityHuman) this.b);
				var6 = var3.a((EntityHuman) this.b, this.b.o, var1);
			}

			if (var3.r() != Material.AIR && var6 >= 1.0F) {
				this.b(var1);
			} else {
				this.d = true;
				this.f = var1;
				int var5 = (int) (var6 * 10.0F);
				this.a.c(this.b.getId(), var1, var5);
				this.k = var5;
			}

		}
	}

	public void a(Position var1) {
		if (var1.equals(this.f)) {
			int var2 = this.g - this.e;
			Block var3 = this.a.p(var1).c();
			if (var3.r() != Material.AIR) {
				float var4 = var3.a((EntityHuman) this.b, this.b.o, var1) * (float) (var2 + 1);
				if (var4 >= 0.7F) {
					this.d = false;
					this.a.c(this.b.getId(), var1, -1);
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
		this.a.c(this.b.getId(), this.f, -1);
	}

	private boolean c(Position var1) {
		bec var2 = this.a.p(var1);
		var2.c().a(this.a, var1, var2, (EntityHuman) this.b);
		boolean var3 = this.a.g(var1);
		if (var3) {
			var2.c().d(this.a, var1, var2);
		}

		return var3;
	}

	public boolean b(Position var1) {
		if (this.gameMode.isCreative() && this.b.bz() != null && this.b.bz().getItem() instanceof anm) {
			return false;
		} else {
			bec var2 = this.a.p(var1);
			bcm var3 = this.a.s(var1);
			if (this.gameMode.buildDisallowed()) {
				if (this.gameMode == GameMode.SPECTATOR) {
					return false;
				}

				if (!this.b.cm()) {
					ItemStack var4 = this.b.bY();
					if (var4 == null) {
						return false;
					}

					if (!var4.c(var2.c())) {
						return false;
					}
				}
			}

			this.a.a(this.b, 2001, var1, Block.f(var2));
			boolean var7 = this.c(var1);
			if (this.d()) {
				this.b.playerConncetion.sendPacket((Packet) (new iw(this.a, var1)));
			} else {
				ItemStack var5 = this.b.bY();
				boolean var6 = this.b.b(var2.c());
				if (var5 != null) {
					var5.a(this.a, var2.c(), var1, this.b);
					if (var5.b == 0) {
						this.b.bZ();
					}
				}

				if (var7 && var6) {
					var2.c().a(this.a, (EntityHuman) this.b, var1, var2, var3);
				}
			}

			return var7;
		}
	}

	public boolean a(EntityHuman var1, World var2, ItemStack var3) {
		if (this.gameMode == GameMode.SPECTATOR) {
			return false;
		} else {
			int var4 = var3.b;
			int var5 = var3.i();
			ItemStack var6 = var3.a(var2, var1);
			if (var6 == var3 && (var6 == null || var6.b == var4 && var6.l() <= 0 && var6.i() == var5)) {
				return false;
			} else {
				var1.playerInventory.contents[var1.playerInventory.c] = var6;
				if (this.d()) {
					var6.b = var4;
					if (var6.e()) {
						var6.b(var5);
					}
				}

				if (var6.b == 0) {
					var1.playerInventory.contents[var1.playerInventory.c] = null;
				}

				if (!var1.bR()) {
					((EntityPlayer) var1).a(var1.defaultContainer);
				}

				return true;
			}
		}
	}

	public boolean a(EntityHuman var1, World var2, ItemStack var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (this.gameMode == GameMode.SPECTATOR) {
			bcm var13 = var2.s(var4);
			if (var13 instanceof vy) {
				Block var14 = var2.p(var4).c();
				vy var15 = (vy) var13;
				if (var15 instanceof bcr && var14 instanceof BlockChest) {
					var15 = ((BlockChest) var14).d(var2, var4);
				}

				if (var15 != null) {
					var1.a((IInventory) var15);
					return true;
				}
			} else if (var13 instanceof IInventory) {
				var1.a((IInventory) var13);
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
