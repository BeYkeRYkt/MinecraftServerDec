package net.minecraft;

public abstract class NBTNumberTag extends NBTTag {

	public abstract long toLong();

	public abstract int toInt();

	public abstract short toShort();

	public abstract byte toByte();

	public abstract double toDouble();

	public abstract float toFloat();

}
