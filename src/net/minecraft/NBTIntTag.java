package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTIntTag extends NBTNumberTag {

	private int i;

	NBTIntTag() {
	}

	public NBTIntTag(int i) {
		this.i = i;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.i);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limiter) throws IOException {
		limiter.onBytesRead(32L);
		this.i = input.readInt();
	}

	public byte getId() {
		return (byte) 3;
	}

	public String toString() {
		return "" + this.i;
	}

	public NBTTag getCopy() {
		return new NBTIntTag(this.i);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTIntTag var2 = (NBTIntTag) var1;
			return this.i == var2.i;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.i;
	}

	public long toLong() {
		return (long) this.i;
	}

	public int toInt() {
		return this.i;
	}

	public short toShort() {
		return (short) (this.i & '\uffff');
	}

	public byte toByte() {
		return (byte) (this.i & 255);
	}

	public double toDouble() {
		return (double) this.i;
	}

	public float toFloat() {
		return (float) this.i;
	}
}
