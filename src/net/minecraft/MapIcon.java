package net.minecraft;

public class MapIcon {

	private byte direction;
	private byte x;
	private byte z;
	private byte type;

	public MapIcon(byte direction, byte x, byte z, byte ензу) {
		this.direction = direction;
		this.x = x;
		this.z = z;
		this.type = ензу;
	}

	public MapIcon(MapIcon var1) {
		this.direction = var1.direction;
		this.x = var1.x;
		this.z = var1.z;
		this.type = var1.type;
	}

	public byte getDirection() {
		return this.direction;
	}

	public byte getX() {
		return this.x;
	}

	public byte getZ() {
		return this.z;
	}

	public byte getType() {
		return this.type;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof MapIcon)) {
			return false;
		} else {
			MapIcon icon = (MapIcon) obj;
			return this.direction != icon.direction ? false : (this.type != icon.type ? false : (this.x != icon.x ? false : this.z == icon.z));
		}
	}

	public int hashCode() {
		int hash = 31 * this.direction + this.x;
		hash = 31 * hash + this.z;
		hash = 31 * hash + this.type;
		return hash;
	}

}
