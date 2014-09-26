package net.minecraft;

import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;

class ServerConnectionFuture implements GenericFutureListener<Future<? super Void>> {

	final NetworkManager networkManager;
	final ChatComponentText text;

	ServerConnectionFuture(NetworkManager networkManager, ChatComponentText text) {
		this.networkManager = networkManager;
		this.text = text;
	}

	public void operationComplete(Future<? super Void> future) {
		this.networkManager.disconnect(this.text);
	}

}
