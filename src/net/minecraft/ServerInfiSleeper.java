package net.minecraft;

class ServerInfiSleeper extends Thread {

	final DedicatedMinecraftServer minecraftserver;

	ServerInfiSleeper(DedicatedMinecraftServer minecraftserver, String name) {
		super(name);
		this.minecraftserver = minecraftserver;
		this.setDaemon(true);
		this.start();
	}

	public void run() {
		while (true) {
			try {
				while (true) {
					Thread.sleep(Integer.MAX_VALUE);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
