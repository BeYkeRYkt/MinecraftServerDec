package net.minecraft;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTTag {

	public static final String[] names = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]" };

	abstract void write(DataOutput output) throws IOException;

	abstract void read(DataInput input, int currentDepth, NBTReadLimiter limiter) throws IOException;

	public abstract String toString();

	public abstract byte getId();

	protected static NBTTag byId(byte id) {
		switch (id) {
			case 0:
				return new NBTEndTag();
			case 1:
				return new NBTByteTag();
			case 2:
				return new NBTShortTag();
			case 3:
				return new NBTIntTag();
			case 4:
				return new NBTLongTag();
			case 5:
				return new NBTFloatTag();
			case 6:
				return new NBTDoubleTag();
			case 7:
				return new NBTByteArrayTag();
			case 8:
				return new NBTStringTag();
			case 9:
				return new NBTListTag();
			case 10:
				return new NBTCompoundTag();
			case 11:
				return new NBTIntArrayTag();
			default:
				return null;
		}
	}

	public abstract NBTTag getCopy();

	public boolean equals(Object obj) {
		if (!(obj instanceof NBTTag)) {
			return false;
		} else {
			NBTTag tag = (NBTTag) obj;
			return this.getId() == tag.getId();
		}
	}

	public int hashCode() {
		return this.getId();
	}

	protected String getAsString() {
		return this.toString();
	}

	public boolean isEmpty() {
		return false;
	}

}
