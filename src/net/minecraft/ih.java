package net.minecraft;

final class ih implements Runnable {

	// $FF: synthetic field
	final id a;
	// $FF: synthetic field
	final hg b;

	ih(id var1, hg var2) {
		this.a = var1;
		this.b = var2;
	}

	public void run() {
		this.a.a(this.b);
	}
}
