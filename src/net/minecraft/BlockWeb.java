package net.minecraft;

import java.util.Random;

public class BlockWeb extends Block {

	public BlockWeb() {
		super(Material.WEB);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public void a(World var1, Position var2, bec var3, Entity var4) {
		var4.aB();
	}

	public boolean c() {
		return false;
	}

	public AxisAlignedBB a(World var1, Position var2, bec var3) {
		return null;
	}

	public boolean d() {
		return false;
	}

	public Item a(bec var1, Random var2, int var3) {
		return Items.STRING;
	}

	protected boolean G() {
		return true;
	}
}
