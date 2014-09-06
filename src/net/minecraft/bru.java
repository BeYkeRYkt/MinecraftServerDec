package net.minecraft;

public class bru {

	private Position e;
	public brv a;
	public BlockFace b;
	public Vec3D c;
	public Entity d;

	public bru(Vec3D var1, BlockFace var2, Position var3) {
		this(brv.b, var1, var2, var3);
	}

	public bru(Vec3D var1, BlockFace var2) {
		this(brv.b, var1, var2, Position.ZERO);
	}

	public bru(Entity var1) {
		this(var1, new Vec3D(var1.locationX, var1.locationY, var1.locationZ));
	}

	public bru(brv var1, Vec3D var2, BlockFace var3, Position var4) {
		this.a = var1;
		this.e = var4;
		this.b = var3;
		this.c = new Vec3D(var2.x, var2.y, var2.z);
	}

	public bru(Entity var1, Vec3D var2) {
		this.a = brv.c;
		this.d = var1;
		this.c = var2;
	}

	public Position a() {
		return this.e;
	}

	public String toString() {
		return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
	}
}
