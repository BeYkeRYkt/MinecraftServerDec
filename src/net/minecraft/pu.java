package net.minecraft;

import java.util.TimerTask;

class pu extends TimerTask {

	// $FF: synthetic field
	final ServerWatchdog a;

	pu(ServerWatchdog var1) {
		this.a = var1;
	}

	public void run() {
		Runtime.getRuntime().halt(1);
	}
}
