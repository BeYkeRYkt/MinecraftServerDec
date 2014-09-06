package net.minecraft;

public class Position extends fd {

	public static final Position ZERO = new Position(0, 0, 0);
	private static final int b = 1 + DataTypesConverter.c(DataTypesConverter.b(30000000));
	private static final int c = b;
	private static final int d = 64 - b - c;
	private static final int f = 0 + c;
	private static final int g = f + d;
	private static final long h = (1L << b) - 1L;
	private static final long i = (1L << d) - 1L;
	private static final long j = (1L << c) - 1L;

	public Position(int var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public Position(double var1, double var3, double var5) {
		super(var1, var3, var5);
	}

	public Position(Entity var1) {
		this(var1.locationX, var1.locationY, var1.locationZ);
	}

	public Position(Vec3D var1) {
		this(var1.x, var1.y, var1.z);
	}

	public Position(fd var1) {
		this(var1.getX(), var1.getY(), var1.getZ());
	}

	public Position a(double var1, double var3, double var5) {
		return new Position((double) this.getX() + var1, (double) this.getY() + var3, (double) this.getZ() + var5);
	}

	public Position a(int var1, int var2, int var3) {
		return new Position(this.getX() + var1, this.getY() + var2, this.getZ() + var3);
	}

	public Position a(fd var1) {
		return new Position(this.getX() + var1.getX(), this.getY() + var1.getY(), this.getZ() + var1.getZ());
	}

	public Position a(int var1) {
		return new Position(this.getX() * var1, this.getY() * var1, this.getZ() * var1);
	}

	public Position a() {
		return this.b(1);
	}

	public Position b(int var1) {
		return this.a(BlockFace.b, var1);
	}

	public Position b() {
		return this.c(1);
	}

	public Position c(int var1) {
		return this.a(BlockFace.a, var1);
	}

	public Position c() {
		return this.d(1);
	}

	public Position d(int var1) {
		return this.a(BlockFace.c, var1);
	}

	public Position d() {
		return this.e(1);
	}

	public Position e(int var1) {
		return this.a(BlockFace.d, var1);
	}

	public Position e() {
		return this.f(1);
	}

	public Position f(int var1) {
		return this.a(BlockFace.e, var1);
	}

	public Position f() {
		return this.g(1);
	}

	public Position g(int var1) {
		return this.a(BlockFace.f, var1);
	}

	public Position a(BlockFace var1) {
		return this.a(var1, 1);
	}

	public Position a(BlockFace var1, int var2) {
		return new Position(this.getX() + var1.g() * var2, this.getY() + var1.h() * var2, this.getZ() + var1.i() * var2);
	}

	public Position c(fd var1) {
		return new Position(this.getY() * var1.getZ() - this.getZ() * var1.getY(), this.getZ() * var1.getX() - this.getX() * var1.getZ(), this.getX() * var1.getY() - this.getY() * var1.getX());
	}

	public long g() {
		return ((long) this.getX() & h) << g | ((long) this.getY() & i) << f | ((long) this.getZ() & j) << 0;
	}

	public static Position a(long var0) {
		int var2 = (int) (var0 << 64 - g - b >> 64 - b);
		int var3 = (int) (var0 << 64 - f - d >> 64 - d);
		int var4 = (int) (var0 << 64 - c >> 64 - c);
		return new Position(var2, var3, var4);
	}

	public static Iterable a(Position var0, Position var1) {
		Position var2 = new Position(Math.min(var0.getX(), var1.getX()), Math.min(var0.getY(), var1.getY()), Math.min(var0.getZ(), var1.getZ()));
		Position var3 = new Position(Math.max(var0.getX(), var1.getX()), Math.max(var0.getY(), var1.getY()), Math.max(var0.getZ(), var1.getZ()));
		return new du(var2, var3);
	}

	public static Iterable b(Position var0, Position var1) {
		Position var2 = new Position(Math.min(var0.getX(), var1.getX()), Math.min(var0.getY(), var1.getY()), Math.min(var0.getZ(), var1.getZ()));
		Position var3 = new Position(Math.max(var0.getX(), var1.getX()), Math.max(var0.getY(), var1.getY()), Math.max(var0.getZ(), var1.getZ()));
		return new dw(var2, var3);
	}

	// $FF: synthetic method
	public fd d(fd var1) {
		return this.c(var1);
	}

}
