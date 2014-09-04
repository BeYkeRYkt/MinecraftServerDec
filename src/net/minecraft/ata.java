package net.minecraft;

public class ata implements vv {

	private final World a;
	private final dt b;

	public ata(World var1, dt var2) {
		this.a = var1;
		this.b = var2;
	}

	public String d_() {
		return "anvil";
	}

	public boolean k_() {
		return false;
	}

	public ho e_() {
		return new hz(aty.cf.a() + ".name", new Object[0]);
	}

	public aib a(ahb var1, ahd var2) {
		return new aid(var1, this.a, this.b, var2);
	}

	public String k() {
		return "minecraft:anvil";
	}
}
