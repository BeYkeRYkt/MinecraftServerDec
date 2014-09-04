package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTByteTag extends NBTNumberTag {

	private byte b;

	NBTByteTag() {
	}

	public NBTByteTag(byte b) {
		this.b = b;
	}

	void write(DataOutput output) throws IOException {
		output.writeByte(this.b);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limiter) throws IOException {
		limiter.onBytesRead(8L);
		this.b = input.readByte();
	}

	public byte getId() {
		return (byte) 1;
	}

	public String toString() {
		return "" + this.b + "b";
	}

	public NBTTag getCopy() {
		return new NBTByteTag(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTByteTag var2 = (NBTByteTag) var1;
			return this.b == var2.b;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.b;
	}

	public long toLong() {
		return (long) this.b;
	}

	public int toInt() {
		return this.b;
	}

	public short toShort() {
		return (short) this.b;
	}

	public byte toByte() {
		return this.b;
	}

	public double toDouble() {
		return (double) this.b;
	}

	public float toFloat() {
		return (float) this.b;
	}

}
