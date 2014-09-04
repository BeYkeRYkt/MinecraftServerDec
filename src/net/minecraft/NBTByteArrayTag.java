package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTByteArrayTag extends NBTTag {

	private byte[] b;

	NBTByteArrayTag() {
	}

	public NBTByteArrayTag(byte[] var1) {
		this.b = var1;
	}

	void write(DataOutput var1) throws IOException {
		var1.writeInt(this.b.length);
		var1.write(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		int var4 = var1.readInt();
		var3.a((long) (8 * var4));
		this.b = new byte[var4];
		var1.readFully(this.b);
	}

	public byte getId() {
		return (byte) 7;
	}

	public String toString() {
		return "[" + this.b.length + " bytes]";
	}

	public NBTTag getCopy() {
		byte[] var1 = new byte[this.b.length];
		System.arraycopy(this.b, 0, var1, 0, this.b.length);
		return new NBTByteArrayTag(var1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(this.b, ((NBTByteArrayTag) var1).b) : false;
	}

	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.b);
	}

	public byte[] c() {
		return this.b;
	}
}
