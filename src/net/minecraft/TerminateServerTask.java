package net.minecraft;

import java.util.TimerTask;

class TerminateServerTask extends TimerTask {

	public void run() {
		Runtime.getRuntime().halt(1);
	}

}
