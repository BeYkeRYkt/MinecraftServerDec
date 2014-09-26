package pipebukkit.server.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

import org.apache.commons.lang.Validate;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

public class PipeScheduler implements BukkitScheduler {

	private AtomicInteger idGenerator = new AtomicInteger(1);

	private volatile int currentTick = -1;

	private Executor executor = Executors.newCachedThreadPool();
	private ConcurrentLinkedQueue<PipeTask> queuedTasks = new ConcurrentLinkedQueue<PipeTask>();
	private ConcurrentHashMap<Integer, PipeTask> runningTasks = new ConcurrentHashMap<Integer, PipeTask>();

	public void doTick(int currentTick) {
		this.currentTick = currentTick;
		Iterator<PipeTask> iterator = queuedTasks.iterator();
		while (iterator.hasNext()) {
			PipeTask task = iterator.next();
			long period = task.getPeriod();
			if (period == -2) {
				iterator.remove();
				continue;
			}
			if (task.getNextRun() <= currentTick) {
				runningTasks.put(task.getTaskId(), task);
				if (period == -1) {
					iterator.remove();
				} else {
					task.setNextRun(currentTick + task.getPeriod());
				}
			}
		}
		for (PipeTask runningTask : runningTasks.values()) {
			if (runningTask.isSync()) {
				try {
					runningTask.run();
				} catch (final Throwable throwable) {
					runningTask.getOwner().getLogger().log(Level.WARNING, String.format("Task #%s for %s generated an exception", runningTask.getTaskId(), runningTask.getOwner().getDescription().getFullName()), throwable);
				}
			} else {
				executor.execute(runningTask);
			}
		}
		runningTasks.clear();
	}

	@Override
	public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> callable) {
		PipeFuture<T> task = new PipeFuture<T>(plugin, callable);
		addTaskToQueue(task, 0);
		return task;
	}

	@Override
	public void cancelAllTasks() {
		for (PipeTask task : queuedTasks) {
			task.cancel0();
		}
		queuedTasks.clear();
	}

	@Override
	public void cancelTask(int taskId) {
		Iterator<PipeTask> iterator = queuedTasks.iterator();
		while (iterator.hasNext()) {
			PipeTask task = iterator.next();
			if (task.getTaskId() == taskId) {
				task.cancel0();
				iterator.remove();
				break;
			}
		}
	}

	@Override
	public void cancelTasks(Plugin plugin) {
		Iterator<PipeTask> iterator = queuedTasks.iterator();
		while (iterator.hasNext()) {
			PipeTask task = iterator.next();
			if (task.getOwner().equals(plugin)) {
				task.cancel0();
				iterator.remove();
			}
		}
	}

	@Override
	public List<BukkitWorker> getActiveWorkers() {
		ArrayList<BukkitWorker> workers = new ArrayList<BukkitWorker>();
		for (final PipeTask taskObj : runningTasks.values()) {
			if (taskObj.isSync()) {
				continue;
			}
			final PipeAsyncTask task = (PipeAsyncTask) taskObj;
			synchronized (task.getWorkers()) {
				workers.addAll(task.getWorkers());
			}
		}
		return workers;
	}

	@Override
	public List<BukkitTask> getPendingTasks() {
		final ArrayList<BukkitTask> pending = new ArrayList<BukkitTask>();
		for (PipeTask task : runningTasks.values()) {
			if (task.getPeriod() >= -1L) {
				pending.add(task);
			}
		}

		for (PipeTask task : queuedTasks) {
			if (task.getPeriod() >= -1L && !pending.contains(task)) {
				pending.add(task);
			}
		}

		 return pending;
	}

	@Override
	public boolean isCurrentlyRunning(int taskId) {
		PipeTask task = runningTasks.get(taskId);
		if (task == null || task.isSync()) {
			return false;
		}
		return false;
	}

	@Override
	public boolean isQueued(int taskId) {
		if (taskId <= 0) {
			return false;
		}
		for (PipeTask task : queuedTasks) {
			if (task.getTaskId() == taskId) {
				return task.getPeriod() >= -1;
			}
		}
		PipeTask task = runningTasks.get(taskId);
		return task != null && task.getPeriod() >= -1;
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return runTaskAsynchronously(plugin, (Runnable) task);
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return runTaskLaterAsynchronously(plugin, (Runnable) task, delay);
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return runTaskTimerAsynchronously(plugin, (Runnable) task, delay, period);
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable) {
		return scheduleAsyncDelayedTask(plugin, runnable, 0L);
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable, long delay) {
		return scheduleAsyncRepeatingTask(plugin, runnable, delay, -1L);
	}

	@Override
	public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long repeat) {
		return runTaskTimerAsynchronously(plugin, runnable, delay, repeat).getTaskId();
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable runnable) throws IllegalArgumentException {
		return runTaskLaterAsynchronously(plugin, runnable, 0L);
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long delay) throws IllegalArgumentException {
		return runTaskTimerAsynchronously(plugin, runnable, delay, -1L);
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long delay, long repeat) throws IllegalArgumentException {
		if (delay < 0L) {
			delay = 0;
		}
		if (repeat == 0L) {
			repeat = 1L;
		} else if (repeat < -1L) {
			repeat = -1L;
		}
		return addTaskToQueue(new PipeAsyncTask(runningTasks, plugin, runnable, nextId(), repeat), delay);
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
		return scheduleSyncDelayedTask(plugin, (Runnable) task);
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
		return scheduleSyncDelayedTask(plugin, (Runnable) task, delay);
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
		return scheduleSyncRepeatingTask(plugin, (Runnable) task, delay, period);
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable) {
		return scheduleSyncDelayedTask(plugin, runnable, 0L);
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable, long delay) {
		return scheduleSyncRepeatingTask(plugin, runnable, delay, -1L);
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long repeat) {
		return runTaskTimer(plugin, runnable, delay, repeat).getTaskId();
	}

	@Override
	public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return runTask(plugin, (Runnable) task);
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return runTaskLater(plugin, (Runnable) task, delay);
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return runTaskTimer(plugin, (Runnable) task, delay, period);
	}

	@Override
	public BukkitTask runTask(Plugin plugin, Runnable runnable) throws IllegalArgumentException {
		return runTaskLater(plugin, runnable, 0L);
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, Runnable runnable, long delay) throws IllegalArgumentException {
		return runTaskTimer(plugin, runnable, delay, -1L);
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, Runnable runnable, long delay, long repeat) throws IllegalArgumentException {
		if (delay < 0L) {
			delay = 0;
		}
		if (repeat == 0L) {
			repeat = 1L;
		} else if (repeat < -1L) {
			repeat = -1L;
		}
		return addTaskToQueue(new PipeTask(plugin, runnable, nextId(), repeat), delay);
	}

	private PipeTask addTaskToQueue(final PipeTask task, final long delay) {
		Validate.notNull(task.getOwner(), "Plugin cannot be null");
		Validate.notNull(task, "Task cannot be null");
		if (!task.getOwner().isEnabled()) {
			throw new IllegalPluginAccessException("Plugin attempted to register task while disabled");
		}
		task.setNextRun(currentTick + delay);
		queuedTasks.add(task);
		return task;
	}

	private int nextId() {
		return idGenerator.incrementAndGet();
	}

}
