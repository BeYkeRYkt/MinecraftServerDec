package net.minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ServerConsoleReader extends Thread {

	final DedicatedMinecraftServer minecraftserver;

	ServerConsoleReader(DedicatedMinecraftServer var1, String var2) {
		super(var2);
		this.minecraftserver = var1;
	}

	public void run() {
		BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

		String var2;
		try {
			while (!this.minecraftserver.isStopped() && this.minecraftserver.isTicking() && (var2 = var1.readLine()) != null) {
				this.minecraftserver.addPendingCommand(var2, (CommandSenderInterface) this.minecraftserver);
			}
		} catch (IOException var4) {
			DedicatedMinecraftServer.aR().error("Exception handling console input", (Throwable) var4);
		}

	}
}
