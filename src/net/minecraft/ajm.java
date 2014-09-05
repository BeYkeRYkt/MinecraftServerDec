package net.minecraft;

public class ajm extends amr {

	public ajm(Block var1) {
		super(var1, var1, new String[] { "intact", "slightlyDamaged", "veryDamaged" });
	}

	public int a(int var1) {
		return var1 << 2;
	}
}
