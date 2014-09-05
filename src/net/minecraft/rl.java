package net.minecraft;

class rl implements Runnable {

	// $FF: synthetic field
	final PlayerConnection a;

	rl(PlayerConnection var1) {
		this.a = var1;
	}

	public void run() {
		this.a.a.l();
	}
}
