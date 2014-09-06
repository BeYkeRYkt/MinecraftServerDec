package net.minecraft;

public class BlockRedstone extends BlockOreBlock {

	public BlockRedstone(MaterialMapColor var1) {
		super(var1);
		this.a(CreativeModeTab.REDSTONE);
	}

	public boolean g() {
		return true;
	}

	public int a(ard var1, Position var2, bec var3, PaintingDirection var4) {
		return 15;
	}
}
