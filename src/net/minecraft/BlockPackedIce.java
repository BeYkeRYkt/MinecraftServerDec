package net.minecraft;

import java.util.Random;

public class BlockPackedIce extends Block {

	public BlockPackedIce() {
		super(Material.SNOW_LAYER);
		this.K = 0.98F;
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int getDropCount(Random var1) {
		return 0;
	}
}
