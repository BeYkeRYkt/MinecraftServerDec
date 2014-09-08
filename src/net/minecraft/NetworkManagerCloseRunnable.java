package net.minecraft;

class NetworkManagerCloseRunnable implements Runnable {

	final PlayerConnection playerConnection;

	NetworkManagerCloseRunnable(PlayerConnection playerConnection) {
		this.playerConnection = playerConnection;
	}

	public void run() {
		this.playerConnection.networkManager.closeChannel();
	}

}
