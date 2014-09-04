package net.minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ServerConsoleReader extends Thread {

	final DedicatedMinecraftServer minecraftserver;

	ServerConsoleReader(DedicatedMinecraftServer minecraftserver, String name) {
		super(name);
		this.minecraftserver = minecraftserver;
	}

	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		try {
			while (!this.minecraftserver.isStopped() && this.minecraftserver.isTicking() && (line = reader.readLine()) != null) {
				this.minecraftserver.addPendingCommand(line, (CommandSenderInterface) this.minecraftserver);
			}
		} catch (IOException var4) {
			DedicatedMinecraftServer.aR().error("Exception handling console input", (Throwable) var4);
		}

	}
}
