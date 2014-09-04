package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTByteArrayTag extends NBTTag {

	private byte[] barray;

	NBTByteArrayTag() {
	}

	public NBTByteArrayTag(byte[] barray) {
		this.barray = barray;
	}

	void write(DataOutput output) throws IOException {
		output.writeInt(this.barray.length);
		output.write(this.barray);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		int length = input.readInt();
		limit.onBytesRead((long) (8 * length));
		this.barray = new byte[length];
		input.readFully(this.barray);
	}

	public byte getId() {
		return (byte) 7;
	}

	public String toString() {
		return "[" + this.barray.length + " bytes]";
	}

	public NBTTag getCopy() {
		byte[] copy = new byte[this.barray.length];
		System.arraycopy(this.barray, 0, copy, 0, this.barray.length);
		return new NBTByteArrayTag(copy);
	}

	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(this.barray, ((NBTByteArrayTag) var1).barray) : false;
	}

	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.barray);
	}

	public byte[] getContent() {
		return this.barray;
	}
}
