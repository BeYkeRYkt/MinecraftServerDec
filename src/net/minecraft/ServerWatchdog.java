package net.minecraft;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerWatchdog implements Runnable {

	private static final Logger logger = LogManager.getLogger();
	private final DedicatedMinecraftServer minecraftserver;
	private final long timeout;

	public ServerWatchdog(DedicatedMinecraftServer minecraftserver) {
		this.minecraftserver = minecraftserver;
		this.timeout = minecraftserver.getMaxTickTime();
	}

	public void run() {
		while (this.minecraftserver.isTicking()) {
			long lastTick = this.minecraftserver.getLastTickTime();
			long currentTime = MinecraftServer.getCurrentMillis();
			long diff = currentTime - lastTick;
			if (diff > this.timeout) {
				logger.fatal("A single server tick took " + String.format("%.2f", new Object[] { Float.valueOf((float) diff / 1000.0F) }) + " seconds (should be max " + String.format("%.2f", new Object[] { Float.valueOf(0.05F) }) + ")");
				logger.fatal("Considering it to be crashed, server will forcibly shutdown.");
				ThreadMXBean mxbean = ManagementFactory.getThreadMXBean();
				ThreadInfo[] threadinfo = mxbean.dumpAllThreads(true, true);
				StringBuilder builder = new StringBuilder();
				Error error = new Error();

				for (ThreadInfo threadInfo : threadinfo) {
					if (threadInfo.getThreadId() == this.minecraftserver.getMainServerThread().getId()) {
						error.setStackTrace(threadInfo.getStackTrace());
					}
					builder.append(threadInfo);
					builder.append("\n");
				}

				CrashReport crashreport = new CrashReport("Watching Server", error);
				this.minecraftserver.b(crashreport);
				j var17 = crashreport.a("Thread Dump");
				var17.a("Threads", builder);
				File file = new File(new File(this.minecraftserver.w(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
				if (crashreport.write(file)) {
					logger.error("This crash report has been saved to: " + file.getAbsolutePath());
				} else {
					logger.error("We were unable to save this crash report to disk.");
				}

				this.halt();
			}

			try {
				Thread.sleep(lastTick + this.timeout - currentTime);
			} catch (InterruptedException var15) {
			}
		}

	}

	private void halt() {
		try {
			Timer timer = new Timer();
			timer.schedule(new TerminateServerTask(), 10000L);
			System.exit(1);
		} catch (Throwable t) {
			Runtime.getRuntime().halt(1);
		}

	}

}
