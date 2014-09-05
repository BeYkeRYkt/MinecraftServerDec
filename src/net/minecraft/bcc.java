package net.minecraft;

import java.util.Random;

public class bcc extends Block {

	public bcc() {
		super(bof.G);
		this.a(CreativeModeTab.c);
	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		var4.aB();
	}

	public boolean c() {
		return false;
	}

	public brt a(World var1, Position var2, bec var3) {
		return null;
	}

	public boolean d() {
		return false;
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.F;
	}

	protected boolean G() {
		return true;
	}
}
