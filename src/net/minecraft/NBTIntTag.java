package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTIntTag extends ge {

	private int b;

	NBTIntTag() {
	}

	public NBTIntTag(int var1) {
		this.b = var1;
	}

	void write(DataOutput var1) throws IOException {
		var1.writeInt(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		var3.a(32L);
		this.b = var1.readInt();
	}

	public byte getId() {
		return (byte) 3;
	}

	public String toString() {
		return "" + this.b;
	}

	public NBTTag getCopy() {
		return new NBTIntTag(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTIntTag var2 = (NBTIntTag) var1;
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
		return (short) (this.b & '\uffff');
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
