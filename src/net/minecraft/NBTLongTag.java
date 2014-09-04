package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTLongTag extends NBTNumberTag {

	private long l;

	NBTLongTag() {
	}

	public NBTLongTag(long l) {
		this.l = l;
	}

	void write(DataOutput output) throws IOException {
		output.writeLong(this.l);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limiter) throws IOException {
		limiter.onBytesRead(64L);
		this.l = input.readLong();
	}

	public byte getId() {
		return (byte) 4;
	}

	public String toString() {
		return "" + this.l + "L";
	}

	public NBTTag getCopy() {
		return new NBTLongTag(this.l);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTLongTag var2 = (NBTLongTag) var1;
			return this.l == var2.l;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ (int) (this.l ^ this.l >>> 32);
	}

	public long toLong() {
		return this.l;
	}

	public int toInt() {
		return (int) (this.l & -1L);
	}

	public short toShort() {
		return (short) ((int) (this.l & 65535L));
	}

	public byte toByte() {
		return (byte) ((int) (this.l & 255L));
	}

	public double toDouble() {
		return (double) this.l;
	}

	public float toFloat() {
		return (float) this.l;
	}
}
