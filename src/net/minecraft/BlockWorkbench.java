package net.minecraft;

public class BlockWorkbench extends Block {

	protected BlockWorkbench() {
		super(Material.WOOD);
		this.a(CreativeModeTab.c);
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			var4.a((vv) (new aut(var1, var2)));
			return true;
		}
	}
}
