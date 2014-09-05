package net.minecraft;

class GameRule {

	private String a;
	private boolean b;
	private int c;
	private double d;
	private final GameRuleValue e;

	public GameRule(String var1, GameRuleValue var2) {
		this.e = var2;
		this.a(var1);
	}

	public void a(String var1) {
		this.a = var1;
		this.b = Boolean.parseBoolean(var1);
		this.c = this.b ? 1 : 0;

		try {
			this.c = Integer.parseInt(var1);
		} catch (NumberFormatException var4) {
			;
		}

		try {
			this.d = Double.parseDouble(var1);
		} catch (NumberFormatException var3) {
			;
		}

	}

	public String a() {
		return this.a;
	}

	public boolean b() {
		return this.b;
	}

	public int c() {
		return this.c;
	}

	public GameRuleValue e() {
		return this.e;
	}
}
