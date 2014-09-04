package net.minecraft;

import com.mojang.util.QueueLogAppender;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class qa implements Runnable {

	// $FF: synthetic field
	final JTextArea a;
	// $FF: synthetic field
	final JScrollPane b;
	// $FF: synthetic field
	final pw c;

	qa(pw var1, JTextArea var2, JScrollPane var3) {
		this.c = var1;
		this.a = var2;
		this.b = var3;
	}

	public void run() {
		String var1;
		while ((var1 = QueueLogAppender.getNextLogEvent("ServerGuiConsole")) != null) {
			this.c.a(this.a, this.b, var1);
		}

	}
}
