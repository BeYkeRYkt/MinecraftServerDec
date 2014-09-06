package net.minecraft;

public class abh {

	private final Position a;
	private final Position b;
	private final BlockFace c;
	private int d;
	private boolean e;
	private int f;

	public abh(Position var1, int var2, int var3, int var4) {
		this(var1, a(var2, var3), var4);
	}

	private static BlockFace a(int var0, int var1) {
		return var0 < 0 ? BlockFace.e : (var0 > 0 ? BlockFace.f : (var1 < 0 ? BlockFace.c : BlockFace.d));
	}

	public abh(Position var1, BlockFace var2, int var3) {
		this.a = var1;
		this.c = var2;
		this.b = var1.a(var2, 2);
		this.d = var3;
	}

	public int b(int var1, int var2, int var3) {
		return (int) this.a.c((double) var1, (double) var2, (double) var3);
	}

	public int a(Position var1) {
		return (int) var1.i(this.d());
	}

	public int b(Position var1) {
		return (int) this.b.i(var1);
	}

	public boolean c(Position var1) {
		int var2 = var1.getX() - this.a.getX();
		int var3 = var1.getZ() - this.a.getY();
		return var2 * this.c.g() + var3 * this.c.i() >= 0;
	}

	public void a() {
		this.f = 0;
	}

	public void b() {
		++this.f;
	}

	public int c() {
		return this.f;
	}

	public Position d() {
		return this.a;
	}

	public Position e() {
		return this.b;
	}

	public int f() {
		return this.c.g() * 2;
	}

	public int g() {
		return this.c.i() * 2;
	}

	public int h() {
		return this.d;
	}

	public void a(int var1) {
		this.d = var1;
	}

	public boolean i() {
		return this.e;
	}

	public void a(boolean var1) {
		this.e = var1;
	}
}
