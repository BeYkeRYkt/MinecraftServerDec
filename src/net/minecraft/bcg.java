package net.minecraft;

public class bcg extends Block {

	public static final bev a = bev.a("color", akv.class);

	protected bcg() {
		super(bof.r);
		this.j(this.L.b().a(a, akv.a));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.a(true);
		this.a(CreativeModeTab.c);
		this.b(0);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void h() {
		this.b(0);
	}

	public void a(ard var1, Position var2) {
		this.b(0);
	}

	protected void b(int var1) {
		byte var2 = 0;
		float var3 = (float) (1 * (1 + var2)) / 16.0F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) && this.d(var1, var2);
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		this.e(var1, var2, var3);
	}

	private boolean e(World var1, Position var2, bec var3) {
		if (!this.d(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	private boolean d(World var1, Position var2) {
		return !var1.d(var2.b());
	}

	public int a(bec var1) {
		return ((akv) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, akv.b(var1));
	}

	public int c(bec var1) {
		return ((akv) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
