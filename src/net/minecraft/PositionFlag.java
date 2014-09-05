package net.minecraft;

import java.util.EnumSet;
import java.util.Set;

public enum PositionFlag {

	X(0), 
	Y(1), 
	Z(2), 
	PITCH(3), 
	YAW(4);

	private int id;

	private PositionFlag(int var3) {
		this.id = var3;
	}

	private int getId() {
		return 1 << this.id;
	}

	private boolean isSet(int id) {
		return (id & this.getId()) == this.getId();
	}

	public static Set<PositionFlag> fromBitfield(int bitfield) {
		EnumSet<PositionFlag> flags = EnumSet.noneOf(PositionFlag.class);

		for (PositionFlag flag : values()) {
			if (flag.isSet(bitfield)) {
				flags.add(flag);
			}
		}

		return flags;
	}

	public static int toBitfield(Set<PositionFlag> flags) {
		int bitfield = 0;

		for (PositionFlag flag : flags) {
			bitfield |= flag.getId();
		}

		return bitfield;
	}

}
