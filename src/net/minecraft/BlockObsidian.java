package net.minecraft;

import java.util.Random;

public class BlockObsidian extends Block {

	public BlockObsidian() {
		super(Material.STONE);
		this.a(CreativeModeTab.b);
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(aty.Z);
	}

	public MaterialMapColor g(bec var1) {
		return MaterialMapColor.J;
	}
}
