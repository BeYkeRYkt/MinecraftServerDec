package net.minecraft;

public class bru {

	private Position e;
	public brv a;
	public PaintingDirection b;
	public brw c;
	public Entity d;

	public bru(brw var1, PaintingDirection var2, Position var3) {
		this(brv.b, var1, var2, var3);
	}

	public bru(brw var1, PaintingDirection var2) {
		this(brv.b, var1, var2, Position.a);
	}

	public bru(Entity var1) {
		this(var1, new brw(var1.locationX, var1.locationY, var1.locationZ));
	}

	public bru(brv var1, brw var2, PaintingDirection var3, Position var4) {
		this.a = var1;
		this.e = var4;
		this.b = var3;
		this.c = new brw(var2.a, var2.b, var2.c);
	}

	public bru(Entity var1, brw var2) {
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
