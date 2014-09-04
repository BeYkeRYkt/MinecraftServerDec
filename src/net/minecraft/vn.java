package net.minecraft;

import com.google.common.util.concurrent.ListenableFuture;

public interface vn {

	ListenableFuture a(Runnable var1);

	boolean isMainThread();
}
