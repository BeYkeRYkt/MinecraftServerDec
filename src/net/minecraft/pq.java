package net.minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pq extends Thread {

	// $FF: synthetic field
	final DedicatedMinecraftServer a;

	pq(DedicatedMinecraftServer var1, String var2) {
		super(var2);
		this.a = var1;
	}

	public void run() {
		BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

		String var2;
		try {
			while (!this.a.isStopped() && this.a.isTicking() && (var2 = var1.readLine()) != null) {
				this.a.a(var2, (CommandSenderInterface) this.a);
			}
		} catch (IOException var4) {
			DedicatedMinecraftServer.aR().error("Exception handling console input", (Throwable) var4);
		}

	}
}
