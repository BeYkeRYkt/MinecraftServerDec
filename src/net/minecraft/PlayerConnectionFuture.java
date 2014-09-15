package net.minecraft;

import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;

class PlayerConnectionFuture implements GenericFutureListener<Future<? super Void>> {

	final ChatComponentText message;
	final PlayerConnection playerConnection;

	PlayerConnectionFuture(PlayerConnection playerConnection, ChatComponentText message) {
		this.playerConnection = playerConnection;
		this.message = message;
	}

	public void operationComplete(Future<? super Void> var1) {
		this.playerConnection.networkManager.disconnect(this.message);
	}

}
