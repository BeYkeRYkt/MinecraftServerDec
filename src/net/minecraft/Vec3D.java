package net.minecraft;

public class Vec3D {

	public final double x;
	public final double y;
	public final double z;

	public Vec3D(double var1, double var3, double var5) {
		if (var1 == -0.0D) {
			var1 = 0.0D;
		}

		if (var3 == -0.0D) {
			var3 = 0.0D;
		}

		if (var5 == -0.0D) {
			var5 = 0.0D;
		}

		this.x = var1;
		this.y = var3;
		this.z = var5;
	}

	public Vec3D a() {
		double var1 = (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		return var1 < 1.0E-4D ? new Vec3D(0.0D, 0.0D, 0.0D) : new Vec3D(this.x / var1, this.y / var1, this.z / var1);
	}

	public double b(Vec3D var1) {
		return this.x * var1.x + this.y * var1.y + this.z * var1.z;
	}

	public Vec3D d(Vec3D var1) {
		return this.a(var1.x, var1.y, var1.z);
	}

	public Vec3D a(double var1, double var3, double var5) {
		return this.b(-var1, -var3, -var5);
	}

	public Vec3D e(Vec3D var1) {
		return this.b(var1.x, var1.y, var1.z);
	}

	public Vec3D b(double var1, double var3, double var5) {
		return new Vec3D(this.x + var1, this.y + var3, this.z + var5);
	}

	public double f(Vec3D var1) {
		double var2 = var1.x - this.x;
		double var4 = var1.y - this.y;
		double var6 = var1.z - this.z;
		return (double) MathHelper.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
	}

	public double g(Vec3D var1) {
		double var2 = var1.x - this.x;
		double var4 = var1.y - this.y;
		double var6 = var1.z - this.z;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public double b() {
		return (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	public Vec3D a(Vec3D var1, double var2) {
		double var4 = var1.x - this.x;
		double var6 = var1.y - this.y;
		double var8 = var1.z - this.z;
		if (var4 * var4 < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - this.x) / var4;
			return var10 >= 0.0D && var10 <= 1.0D ? new Vec3D(this.x + var4 * var10, this.y + var6 * var10, this.z + var8 * var10) : null;
		}
	}

	public Vec3D b(Vec3D var1, double var2) {
		double var4 = var1.x - this.x;
		double var6 = var1.y - this.y;
		double var8 = var1.z - this.z;
		if (var6 * var6 < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - this.y) / var6;
			return var10 >= 0.0D && var10 <= 1.0D ? new Vec3D(this.x + var4 * var10, this.y + var6 * var10, this.z + var8 * var10) : null;
		}
	}

	public Vec3D c(Vec3D var1, double var2) {
		double var4 = var1.x - this.x;
		double var6 = var1.y - this.y;
		double var8 = var1.z - this.z;
		if (var8 * var8 < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - this.z) / var8;
			return var10 >= 0.0D && var10 <= 1.0D ? new Vec3D(this.x + var4 * var10, this.y + var6 * var10, this.z + var8 * var10) : null;
		}
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	public Vec3D a(float var1) {
		float var2 = MathHelper.b(var1);
		float var3 = MathHelper.a(var1);
		double var4 = this.x;
		double var6 = this.y * (double) var2 + this.z * (double) var3;
		double var8 = this.z * (double) var2 - this.y * (double) var3;
		return new Vec3D(var4, var6, var8);
	}

	public Vec3D b(float var1) {
		float var2 = MathHelper.b(var1);
		float var3 = MathHelper.a(var1);
		double var4 = this.x * (double) var2 + this.z * (double) var3;
		double var6 = this.y;
		double var8 = this.z * (double) var2 - this.x * (double) var3;
		return new Vec3D(var4, var6, var8);
	}
}
