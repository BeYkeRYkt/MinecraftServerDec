package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTFloatTag extends NBTNumberTag {

	private float f;

	NBTFloatTag() {
	}

	public NBTFloatTag(float f) {
		this.f = f;
	}

	void write(DataOutput output) throws IOException {
		output.writeFloat(this.f);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		limit.onBytesRead(32L);
		this.f = input.readFloat();
	}

	public byte getId() {
		return (byte) 5;
	}

	public String toString() {
		return "" + this.f + "f";
	}

	public NBTTag getCopy() {
		return new NBTFloatTag(this.f);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTFloatTag var2 = (NBTFloatTag) var1;
			return this.f == var2.f;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ Float.floatToIntBits(this.f);
	}

	public long toLong() {
		return (long) this.f;
	}

	public int toInt() {
		return MathHelper.d(this.f);
	}

	public short toShort() {
		return (short) (MathHelper.d(this.f) & '\uffff');
	}

	public byte toByte() {
		return (byte) (MathHelper.d(this.f) & 255);
	}

	public double toDouble() {
		return (double) this.f;
	}

	public float toFloat() {
		return this.f;
	}
}
