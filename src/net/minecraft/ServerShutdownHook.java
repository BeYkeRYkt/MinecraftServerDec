package net.minecraft;

public final class ServerShutdownHook extends Thread {

	final DedicatedMinecraftServer mcserver;

	public ServerShutdownHook(String name, DedicatedMinecraftServer mcserver) {
		super(name);
		this.mcserver = mcserver;
	}

	public void run() {
		if (!mcserver.isStopped()) {
			this.mcserver.stop();
		}
	}

}
