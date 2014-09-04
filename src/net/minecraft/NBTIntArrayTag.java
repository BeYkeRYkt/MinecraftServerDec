package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTIntArrayTag extends NBTTag {

	private int[] iarray;

	NBTIntArrayTag() {
	}

	public NBTIntArrayTag(int[] iarray) {
		this.iarray = iarray;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.iarray.length);

		for (int i = 0; i < this.iarray.length; ++i) {
			output.writeInt(this.iarray[i]);
		}

	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		int var4 = input.readInt();
		limit.onBytesRead((long) (32 * var4));
		this.iarray = new int[var4];

		for (int var5 = 0; var5 < var4; ++var5) {
			this.iarray[var5] = input.readInt();
		}

	}

	public byte getId() {
		return (byte) 11;
	}

	public String toString() {
		String string = "[";
		int[] arr = this.iarray;
		int length = arr.length;

		for (int i = 0; i < length; ++i) {
			string = string + arr[i] + ",";
		}

		return string + "]";
	}

	public NBTTag getCopy() {
		int[] var1 = new int[this.iarray.length];
		System.arraycopy(this.iarray, 0, var1, 0, this.iarray.length);
		return new NBTIntArrayTag(var1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(this.iarray, ((NBTIntArrayTag) var1).iarray) : false;
	}

	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.iarray);
	}

	public int[] getContent() {
		return this.iarray;
	}

}
