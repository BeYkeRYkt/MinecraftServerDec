package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTDoubleTag extends ge {

	private double b;

	NBTDoubleTag() {
	}

	public NBTDoubleTag(double var1) {
		this.b = var1;
	}

	void write(DataOutput var1) throws IOException {
		var1.writeDouble(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		var3.a(64L);
		this.b = var1.readDouble();
	}

	public byte getId() {
		return (byte) 6;
	}

	public String toString() {
		return "" + this.b + "d";
	}

	public NBTTag getCopy() {
		return new NBTDoubleTag(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTDoubleTag var2 = (NBTDoubleTag) var1;
			return this.b == var2.b;
		} else {
			return false;
		}
	}

	public int hashCode() {
		long var1 = Double.doubleToLongBits(this.b);
		return super.hashCode() ^ (int) (var1 ^ var1 >>> 32);
	}

	public long c() {
		return (long) Math.floor(this.b);
	}

	public int d() {
		return uv.c(this.b);
	}

	public short e() {
		return (short) (uv.c(this.b) & '\uffff');
	}

	public byte f() {
		return (byte) (uv.c(this.b) & 255);
	}

	public double g() {
		return this.b;
	}

	public float h() {
		return (float) this.b;
	}
}
