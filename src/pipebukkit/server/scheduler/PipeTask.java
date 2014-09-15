package pipebukkit.server.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

class PipeTask implements BukkitTask, Runnable {

	/**
	 * -1 means no repeating <br>
	 * -2 means cancel <br>
	 * Never 0 <br>
	 * >0 means number of ticks to wait between each execution
	 */
	private volatile long period;
	private long nextRun;
	private final Runnable task;
	private final Plugin plugin;
	private final int id;

	public PipeTask() {
		this(null, null, -1, -1);
	}

	public PipeTask(final Runnable task) {
		this(null, task, -1, -1);
	}

	public PipeTask(final Plugin plugin, final Runnable task, final int id, final long period) {
		this.plugin = plugin;
		this.task = task;
		this.id = id;
		this.period = period;
	}

	@Override
	public final int getTaskId() {
		return id;
	}

	@Override
	public final Plugin getOwner() {
		return plugin;
	}

	@Override
	public boolean isSync() {
		return true;
	}

	@Override
	public void run() {
		task.run();
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public long getNextRun() {
		return nextRun;
	}

	public void setNextRun(long nextRun) {
		this.nextRun = nextRun;
	}

	public Class<? extends Runnable> getTaskClass() {
		return task.getClass();
	}

	@Override
	public void cancel() {
		Bukkit.getScheduler().cancelTask(id);
	}

	public boolean cancel0() {
		setPeriod(-2l);
		return true;
	}

}
