package net.minecraft;

public abstract class ati extends Block {

	protected final boolean a;

	public static boolean d(World var0, Position var1) {
		return d(var0.p(var1));
	}

	public static boolean d(bec var0) {
		Block var1 = var0.getBlock();
		return var1 == aty.av || var1 == aty.D || var1 == aty.E || var1 == aty.cs;
	}

	protected ati(boolean var1) {
		super(Material.ORIENTABLE);
		this.a = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.a(CreativeModeTab.e);
	}

	public brt a(World var1, Position var2, bec var3) {
		return null;
	}

	public boolean c() {
		return false;
	}

	public bru a(World var1, Position var2, Vec3D var3, Vec3D var4) {
		this.a(var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	public void a(ard var1, Position var2) {
		bec var3 = var1.p(var2);
		atl var4 = var3.getBlock() == this ? (atl) var3.b(this.l()) : null;
		if (var4 != null && var4.c()) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		}

	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return World.a((ard) var1, var2.b());
	}

	public void c(World var1, Position var2, bec var3) {
		if (!var1.D) {
			var3 = this.a(var1, var2, var3, true);
			if (this.a) {
				this.a(var1, var2, var3, (Block) this);
			}
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.D) {
			atl var5 = (atl) var3.b(this.l());
			boolean var6 = false;
			if (!World.a((ard) var1, var2.b())) {
				var6 = true;
			}

			if (var5 == atl.c && !World.a((ard) var1, var2.f())) {
				var6 = true;
			} else if (var5 == atl.d && !World.a((ard) var1, var2.e())) {
				var6 = true;
			} else if (var5 == atl.e && !World.a((ard) var1, var2.c())) {
				var6 = true;
			} else if (var5 == atl.f && !World.a((ard) var1, var2.d())) {
				var6 = true;
			}

			if (var6) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			} else {
				this.b(var1, var2, var3, var4);
			}

		}
	}

	protected void b(World var1, Position var2, bec var3, Block var4) {
	}

	protected bec a(World var1, Position var2, bec var3, boolean var4) {
		return var1.D ? var3 : (new atk(this, var1, var2, var3)).a(var1.z(var2), var4).b();
	}

	public int i() {
		return 0;
	}

	public void b(World var1, Position var2, bec var3) {
		super.b(var1, var2, var3);
		if (((atl) var3.b(this.l())).c()) {
			var1.c(var2.a(), (Block) this);
		}

		if (this.a) {
			var1.c(var2, (Block) this);
			var1.c(var2.b(), (Block) this);
		}

	}

	public abstract bex l();
}
