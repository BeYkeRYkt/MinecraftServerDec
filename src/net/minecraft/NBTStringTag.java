package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTStringTag extends NBTTag {

	private String b;

	public NBTStringTag() {
		this.b = "";
	}

	public NBTStringTag(String var1) {
		this.b = var1;
		if (var1 == null) {
			throw new IllegalArgumentException("Empty string not allowed");
		}
	}

	void write(DataOutput var1) throws IOException {
		var1.writeUTF(this.b);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		this.b = var1.readUTF();
		var3.a((long) (16 * this.b.length()));
	}

	public byte getId() {
		return (byte) 8;
	}

	public String toString() {
		return "\"" + this.b.replace("\"", "\\\"") + "\"";
	}

	public NBTTag getCopy() {
		return new NBTStringTag(this.b);
	}

	public boolean c_() {
		return this.b.isEmpty();
	}

	public boolean equals(Object var1) {
		if (!super.equals(var1)) {
			return false;
		} else {
			NBTStringTag var2 = (NBTStringTag) var1;
			return this.b == null && var2.b == null || this.b != null && this.b.equals(var2.b);
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.b.hashCode();
	}

	public String a_() {
		return this.b;
	}
}
