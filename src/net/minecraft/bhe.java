package net.minecraft;

class bhe extends Position {

	private final int b;

	public bhe(Position var1, int var2) {
		super(var1.n(), var1.o(), var1.p());
		this.b = var2;
	}

	public int q() {
		return this.b;
	}
}
