package net.minecraft;

import com.google.common.util.concurrent.ListenableFuture;

public interface vn {

	ListenableFuture scheduleSyncTask(Runnable var1);

	boolean isMainThread();
}
