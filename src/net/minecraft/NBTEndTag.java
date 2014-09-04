package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;

public class NBTEndTag extends NBTTag {

	void read(DataInput var1, int var2, NBTReadLimiter var3) {
	}

	void write(DataOutput var1) {
	}

	public byte getId() {
		return (byte) 0;
	}

	public String toString() {
		return "END";
	}

	public NBTTag getCopy() {
		return new NBTEndTag();
	}
}
