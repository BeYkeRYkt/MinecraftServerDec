package net.minecraft;

public class aut implements vv {

	private final World a;
	private final dt b;

	public aut(World var1, dt var2) {
		this.a = var1;
		this.b = var2;
	}

	public String d_() {
		return null;
	}

	public boolean k_() {
		return false;
	}

	public ho e_() {
		return new hz(aty.ai.a() + ".name", new Object[0]);
	}

	public aib a(ahb var1, ahd var2) {
		return new aio(var1, this.a, this.b);
	}

	public String k() {
		return "minecraft:crafting_table";
	}
}
