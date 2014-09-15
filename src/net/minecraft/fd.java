package net.minecraft;

import com.google.common.base.Objects;

public class fd implements Comparable {

	public static final fd e = new fd(0, 0, 0);
	private final int a;
	private final int b;
	private final int c;

	public fd(int var1, int var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public fd(double var1, double var3, double var5) {
		this(MathHelper.toFixedPointInt(var1), MathHelper.toFixedPointInt(var3), MathHelper.toFixedPointInt(var5));
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof fd)) {
			return false;
		} else {
			fd var2 = (fd) var1;
			return this.getX() != var2.getX() ? false : (this.getY() != var2.getY() ? false : this.getZ() == var2.getZ());
		}
	}

	public int hashCode() {
		return (this.getY() + this.getZ() * 31) * 31 + this.getX();
	}

	public int g(fd var1) {
		return this.getY() == var1.getY() ? (this.getZ() == var1.getZ() ? this.getX() - var1.getX() : this.getZ() - var1.getZ()) : this.getY() - var1.getY();
	}

	public int getX() {
		return this.a;
	}

	public int getY() {
		return this.b;
	}

	public int getZ() {
		return this.c;
	}

	public fd d(fd var1) {
		return new fd(this.getY() * var1.getZ() - this.getZ() * var1.getY(), this.getZ() * var1.getX() - this.getX() * var1.getZ(), this.getX() * var1.getY() - this.getY() * var1.getX());
	}

	public double c(double var1, double var3, double var5) {
		double var7 = (double) this.getX() - var1;
		double var9 = (double) this.getY() - var3;
		double var11 = (double) this.getZ() - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double d(double var1, double var3, double var5) {
		double var7 = (double) this.getX() + 0.5D - var1;
		double var9 = (double) this.getY() + 0.5D - var3;
		double var11 = (double) this.getZ() + 0.5D - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double i(fd var1) {
		return this.c((double) var1.getX(), (double) var1.getY(), (double) var1.getZ());
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
	}

	// $FF: synthetic method
	public int compareTo(Object var1) {
		return this.g((fd) var1);
	}

}
