package net.minecraft;

class pp extends Thread {

	// $FF: synthetic field
	final DedicatedMinecraftServer a;

	pp(DedicatedMinecraftServer var1, String var2) {
		super(var2);
		this.a = var1;
		this.setDaemon(true);
		this.start();
	}

	public void run() {
		while (true) {
			try {
				while (true) {
					Thread.sleep(2147483647L);
				}
			} catch (InterruptedException var2) {
				;
			}
		}
	}
}
