package net.minecraft;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class qb implements Runnable {

	// $FF: synthetic field
	final JTextArea a;
	// $FF: synthetic field
	final JScrollPane b;
	// $FF: synthetic field
	final String c;
	// $FF: synthetic field
	final pw d;

	qb(pw var1, JTextArea var2, JScrollPane var3, String var4) {
		this.d = var1;
		this.a = var2;
		this.b = var3;
		this.c = var4;
	}

	public void run() {
		this.d.a(this.a, this.b, this.c);
	}
}
