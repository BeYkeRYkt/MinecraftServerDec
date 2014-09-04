package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTShortTag extends ge {

	private short b;

	public NBTShortTag() {
	}

	public NBTShortTag(short var1) {
		this.b = var1;
	}

	void write(DataOutput var1) throws IOException {
		var1.writeShort(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		var3.a(16L);
		this.b = var1.readShort();
	}

	public byte getId() {
		return (byte) 2;
	}

	public String toString() {
		return "" + this.b + "s";
	}

	public NBTTag getCopy() {
		return new NBTShortTag(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTShortTag var2 = (NBTShortTag) var1;
			return this.b == var2.b;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.b;
	}

	public long c() {
		return (long) this.b;
	}

	public int d() {
		return this.b;
	}

	public short e() {
		return this.b;
	}

	public byte f() {
		return (byte) (this.b & 255);
	}

	public double g() {
		return (double) this.b;
	}

	public float h() {
		return (float) this.b;
	}
}
