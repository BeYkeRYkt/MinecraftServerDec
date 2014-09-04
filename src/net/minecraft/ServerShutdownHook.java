package net.minecraft;

public final class ServerShutdownHook extends Thread {

	final DedicatedMinecraftServer mcserver;

	public ServerShutdownHook(String var1, DedicatedMinecraftServer var2) {
		super(var1);
		this.mcserver = var2;
	}

	public void run() {
		if (!mcserver.isStopped()) {
			this.mcserver.stop();
		}
	}
}
