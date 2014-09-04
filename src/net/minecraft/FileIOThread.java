package net.minecraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileIOThread implements Runnable {

	private static final FileIOThread a = new FileIOThread();
	private List<brq> b = Collections.synchronizedList(new ArrayList<brq>());
	private volatile long c;
	private volatile long d;
	private volatile boolean e;

	private FileIOThread() {
		Thread thread = new Thread(this, "File IO Thread");
		thread.start();
	}

	public static FileIOThread getInstance() {
		return a;
	}

	public void run() {
		this.c();
	}

	private void c() {
		for (int var1 = 0; var1 < this.b.size(); ++var1) {
			brq var2 = (brq) this.b.get(var1);
			boolean var3 = var2.c();
			if (!var3) {
				this.b.remove(var1--);
				++this.d;
			}

			try {
				Thread.sleep(this.e ? 0L : 10L);
			} catch (InterruptedException var6) {
				var6.printStackTrace();
			}
		}

		if (this.b.isEmpty()) {
			try {
				Thread.sleep(25L);
			} catch (InterruptedException var5) {
				var5.printStackTrace();
			}
		}

	}

	public void a(brq var1) {
		if (!this.b.contains(var1)) {
			++this.c;
			this.b.add(var1);
		}
	}

	public void b() throws InterruptedException {
		this.e = true;

		while (this.c != this.d) {
			Thread.sleep(10L);
		}

		this.e = false;
	}

}
