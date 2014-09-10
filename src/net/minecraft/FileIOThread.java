package net.minecraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileIOThread implements Runnable {

	private static final FileIOThread instance = new FileIOThread();

	public static FileIOThread getInstance() {
		return instance;
	}

	private List<IAsyncChunkSaver> chunkSavers = Collections.synchronizedList(new ArrayList<IAsyncChunkSaver>());
	private volatile long chunksToSave;
	private volatile long savedChunks;
	private volatile boolean savingAllFiles;

	private FileIOThread() {
		Thread thread = new Thread(this, "File IO Thread");
		thread.start();
	}

	public void run() {
		for (int i = 0; i < this.chunkSavers.size(); ++i) {
			IAsyncChunkSaver chunkSaver = this.chunkSavers.get(i);
			boolean flag = chunkSaver.saveChunks();

			if (!flag) {
				this.chunkSavers.remove(i--);
				++this.savedChunks;
			}

			try {
				Thread.sleep(this.savingAllFiles ? 0L : 10L);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		if (this.chunkSavers.isEmpty()) {
			try {
				Thread.sleep(25L);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void addChunkSaver(IAsyncChunkSaver chunkSaver) {
		if (!this.chunkSavers.contains(chunkSaver)) {
			++this.chunksToSave;
			this.chunkSavers.add(chunkSaver);
		}
	}

	public void saveAllChunks() throws InterruptedException {
		this.savingAllFiles = true;

		while (this.chunksToSave != this.savedChunks) {
			Thread.sleep(10L);
		}

		this.savingAllFiles = false;
	}

}
