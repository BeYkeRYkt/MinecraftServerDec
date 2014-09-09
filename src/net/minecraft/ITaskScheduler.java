package net.minecraft;

import com.google.common.util.concurrent.ListenableFuture;

public interface ITaskScheduler {

	ListenableFuture<?> scheduleSyncTask(Runnable runnable);

	boolean isMainThread();

}
