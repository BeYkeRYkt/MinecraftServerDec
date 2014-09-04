package net.minecraft;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class px extends WindowAdapter {

	// $FF: synthetic field
	final DedicatedMinecraftServer a;

	px(DedicatedMinecraftServer var1) {
		this.a = var1;
	}

	public void windowClosing(WindowEvent var1) {
		this.a.stopTicking();

		while (!this.a.isStopped()) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException var3) {
				var3.printStackTrace();
			}
		}

		System.exit(0);
	}
}
