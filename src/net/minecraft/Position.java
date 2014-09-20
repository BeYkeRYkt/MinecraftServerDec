package net.minecraft;

public class Position extends fd {

	public static final Position ZERO = new Position(0, 0, 0);
	private static final int b = 1 + MathHelper.c(MathHelper.b(30000000));
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

	public Position getUp() {
		return this.getUp(1);
	}

	public Position getUp(int var1) {
		return this.getRelative(BlockFace.UP, var1);
	}

	public Position getDown() {
		return this.getDown(1);
	}

	public Position getDown(int var1) {
		return this.getRelative(BlockFace.DOWN, var1);
	}

	public Position getNorth() {
		return this.getNorth(1);
	}

	public Position getNorth(int var1) {
		return this.getRelative(BlockFace.NORTH, var1);
	}

	public Position getSouth() {
		return this.getSouth(1);
	}

	public Position getSouth(int var1) {
		return this.getRelative(BlockFace.SOUTH, var1);
	}

	public Position getWest() {
		return this.getWest(1);
	}

	public Position getWest(int var1) {
		return this.getRelative(BlockFace.WEST, var1);
	}

	public Position getEast() {
		return this.getEast(1);
	}

	public Position getEast(int var1) {
		return this.getRelative(BlockFace.EAST, var1);
	}

	public Position getRelative(BlockFace var1) {
		return this.getRelative(var1, 1);
	}

	public Position getRelative(BlockFace face, int var2) {
		return new Position(this.getX() + face.g() * var2, this.getY() + face.h() * var2, this.getZ() + face.i() * var2);
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
