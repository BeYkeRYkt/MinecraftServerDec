package net.minecraft;

class r {

	private final String a;
	private final String b;

	public r(String var1, Object var2) {
		this.a = var1;
		if (var2 == null) {
			this.b = "~~NULL~~";
		} else if (var2 instanceof Throwable) {
			Throwable var3 = (Throwable) var2;
			this.b = "~~ERROR~~ " + var3.getClass().getSimpleName() + ": " + var3.getMessage();
		} else {
			this.b = var2.toString();
		}

	}

	public String a() {
		return this.a;
	}

	public String b() {
		return this.b;
	}
}
