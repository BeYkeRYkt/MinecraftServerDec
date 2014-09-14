package pipebukkit.server.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.bukkit.plugin.Plugin;

public class PipeFuture<T> extends PipeTask implements Future<T> {

	private Callable<T> callable;
	private T result;

	private boolean done = false;
	private LinkedBlockingQueue<Boolean> flag = new LinkedBlockingQueue<Boolean>(1);

	public PipeFuture(Plugin plugin, Callable<T> callable) {
		super(plugin, null, 0, -1L);
	}

	@Override
	public synchronized void run() {
		try {
			result = callable.call();
		} catch (Exception e) {
		} finally {
			done = true;
			flag.add(true);
		}
	}

	@Override
	public synchronized boolean cancel(boolean mayInterruptIfRunning) {
		if (getPeriod() != -1L) {
			return false;
		}
		setPeriod(-2L);
		return true;
	}

	@Override
	public boolean isCancelled() {
		return getPeriod() == -2L;
	}

	@Override
	public boolean isDone() {
		return done;
	}

	@Override
	public synchronized T get() throws InterruptedException, ExecutionException {
		if (isDone()) {
			return result;
		} else {
			flag.take();
			return result;
		}
	}

	@Override
	public synchronized T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		if (isDone()) {
			return result;
		} else {
			if (flag.poll(timeout, unit) != null) {
				return result;
			} else {
				throw new TimeoutException();
			}
		}
	}

	public synchronized boolean cancel0() {
		if (getPeriod() != -1l) {
			return false;
		}
		setPeriod(-2l);
		return true;
	}

}
