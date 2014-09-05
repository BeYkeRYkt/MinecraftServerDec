package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTDoubleTag extends NBTNumberTag {

	private double d;

	NBTDoubleTag() {
	}

	public NBTDoubleTag(double d) {
		this.d = d;
	}

	void write(DataOutput output) throws IOException {
		output.writeDouble(this.d);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		limit.onBytesRead(64L);
		this.d = input.readDouble();
	}

	public byte getId() {
		return (byte) 6;
	}

	public String toString() {
		return "" + this.d + "d";
	}

	public NBTTag getCopy() {
		return new NBTDoubleTag(this.d);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTDoubleTag var2 = (NBTDoubleTag) var1;
			return this.d == var2.d;
		} else {
			return false;
		}
	}

	public int hashCode() {
		long var1 = Double.doubleToLongBits(this.d);
		return super.hashCode() ^ (int) (var1 ^ var1 >>> 32);
	}

	public long toLong() {
		return (long) Math.floor(this.d);
	}

	public int toInt() {
		return DataTypesConverter.toFixedPointInt(this.d);
	}

	public short toShort() {
		return (short) (DataTypesConverter.toFixedPointInt(this.d) & '\uffff');
	}

	public byte toByte() {
		return (byte) (DataTypesConverter.toFixedPointInt(this.d) & 255);
	}

	public double toDouble() {
		return this.d;
	}

	public float toFloat() {
		return (float) this.d;
	}
}
