package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTShortTag extends NBTNumberTag {

	private short s;

	public NBTShortTag() {
	}

	public NBTShortTag(short s) {
		this.s = s;
	}

	void write(DataOutput output) throws IOException {
		output.writeShort(this.s);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limiter) throws IOException {
		limiter.onBytesRead(16L);
		this.s = input.readShort();
	}

	public byte getId() {
		return (byte) 2;
	}

	public String toString() {
		return "" + this.s + "s";
	}

	public NBTTag getCopy() {
		return new NBTShortTag(this.s);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTShortTag var2 = (NBTShortTag) var1;
			return this.s == var2.s;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.s;
	}

	public long toLong() {
		return (long) this.s;
	}

	public int toInt() {
		return this.s;
	}

	public short toShort() {
		return this.s;
	}

	public byte toByte() {
		return (byte) (this.s & 255);
	}

	public double toDouble() {
		return (double) this.s;
	}

	public float toFloat() {
		return (float) this.s;
	}
}
