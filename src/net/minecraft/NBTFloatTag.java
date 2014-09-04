package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTFloatTag extends ge {

	private float b;

	NBTFloatTag() {
	}

	public NBTFloatTag(float var1) {
		this.b = var1;
	}

	void write(DataOutput var1) throws IOException {
		var1.writeFloat(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		var3.a(32L);
		this.b = var1.readFloat();
	}

	public byte getId() {
		return (byte) 5;
	}

	public String toString() {
		return "" + this.b + "f";
	}

	public NBTTag getCopy() {
		return new NBTFloatTag(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTFloatTag var2 = (NBTFloatTag) var1;
			return this.b == var2.b;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ Float.floatToIntBits(this.b);
	}

	public long c() {
		return (long) this.b;
	}

	public int d() {
		return uv.d(this.b);
	}

	public short e() {
		return (short) (uv.d(this.b) & '\uffff');
	}

	public byte f() {
		return (byte) (uv.d(this.b) & 255);
	}

	public double g() {
		return (double) this.b;
	}

	public float h() {
		return this.b;
	}
}
