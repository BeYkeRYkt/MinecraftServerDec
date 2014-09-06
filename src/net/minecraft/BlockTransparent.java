package net.minecraft;

public class BlockTransparent extends Block {

	protected boolean Q;

	protected BlockTransparent(Material var1, boolean var2) {
		super(var1);
		this.Q = var2;
	}

	public boolean c() {
		return false;
	}
}
