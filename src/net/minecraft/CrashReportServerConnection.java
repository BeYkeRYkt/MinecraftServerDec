package net.minecraft;

import java.util.concurrent.Callable;

class CrashReportServerConnection implements Callable<String> {

	final NetworkManager networkManager;

	CrashReportServerConnection(NetworkManager networkManager) {
		this.networkManager = networkManager;
	}

	public String call() {
		return this.networkManager.toString();
	}

}
