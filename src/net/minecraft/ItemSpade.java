package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class ItemSpade extends ItemTool {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND }));

	public ItemSpade(EnumToolMaterial var1) {
		super(1.0F, var1, c);
	}

	public boolean canDestroySpecialBlock(Block var1) {
		return var1 == Blocks.SNOW_LAYER ? true : var1 == Blocks.SNOW;
	}

}
