package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class ane extends ItemTool {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { Blocks.aL, Blocks.DIRT, Blocks.ak, Blocks.GRASS, Blocks.GRAVEL, Blocks.bw, Blocks.SAND, Blocks.aJ, Blocks.aH, Blocks.aW }));

	public ane(ami var1) {
		super(1.0F, var1, c);
	}

	public boolean b(Block var1) {
		return var1 == Blocks.aH ? true : var1 == Blocks.aJ;
	}

}
