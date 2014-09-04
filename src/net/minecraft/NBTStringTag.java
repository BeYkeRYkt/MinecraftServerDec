package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTStringTag extends NBTTag {

	private String string;

	public NBTStringTag() {
		this.string = "";
	}

	public NBTStringTag(String string) {
		this.string = string;
		if (string == null) {
			throw new IllegalArgumentException("Empty string not allowed");
		}
	}

	void write(DataOutput output) throws IOException {
		output.writeUTF(this.string);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		this.string = input.readUTF();
		limit.onBytesRead((long) (16 * this.string.length()));
	}

	public byte getId() {
		return (byte) 8;
	}

	public String toString() {
		return "\"" + this.string.replace("\"", "\\\"") + "\"";
	}

	public NBTTag getCopy() {
		return new NBTStringTag(this.string);
	}

	public boolean equals(Object var1) {
		if (!super.equals(var1)) {
			return false;
		} else {
			NBTStringTag var2 = (NBTStringTag) var1;
			return this.string == null && var2.string == null || this.string != null && this.string.equals(var2.string);
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.string.hashCode();
	}

	public boolean isEmpty() {
		return string.isEmpty();
	}

	public String getAsString() {
		return this.string;
	}

}
