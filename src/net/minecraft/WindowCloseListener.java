package net.minecraft;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class WindowCloseListener extends WindowAdapter {

	final DedicatedMinecraftServer minecraftserver;

	WindowCloseListener(DedicatedMinecraftServer minecraftserver) {
		this.minecraftserver = minecraftserver;
	}

	public void windowClosing(WindowEvent var1) {
		this.minecraftserver.stopTicking();

		while (!this.minecraftserver.isStopped()) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException var3) {
				var3.printStackTrace();
			}
		}

		System.exit(0);
	}
}
