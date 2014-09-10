package net.minecraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileIOThread implements Runnable {

	private static final FileIOThread instance = new FileIOThread();

	public static FileIOThread getInstance() {
		return instance;
	}

	private List<IAsyncChunkSaver> chunkSavers = Collections.synchronizedList(new ArrayList<IAsyncChunkSaver>());
	private volatile boolean savingAllFiles;

	private FileIOThread() {
		Thread thread = new Thread(this, "File IO Thread");
		thread.setDaemon(true);
		thread.start();
	}

	public void run() {
		while (true) {
			if (!chunkSavers.isEmpty()) {
				IAsyncChunkSaver chunkSaver = chunkSavers.get(0);
				boolean hasChunksToSave = chunkSaver.saveChunks();
				if (!hasChunksToSave) {
					chunkSavers.remove(0);
				}
			}

			try {
				if (!savingAllFiles) {
					Thread.sleep(10L);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
	
			if (this.chunkSavers.isEmpty()) {
				try {
					Thread.sleep(25L);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void addChunkSaver(IAsyncChunkSaver chunkSaver) {
		if (!this.chunkSavers.contains(chunkSaver)) {
			this.chunkSavers.add(chunkSaver);
		}
	}

	public void saveAllChunks() throws InterruptedException {
		this.savingAllFiles = true;

		while (!chunkSavers.isEmpty()) {
			Thread.sleep(10L);
		}

		this.savingAllFiles = false;
	}

}
