package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class ajr extends ItemTool {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.ae, Blocks.aU, Blocks.aZ, Blocks.bk, Blocks.au }));

	protected ajr(ami var1) {
		super(3.0F, var1, c);
	}

	public float a(ItemStack var1, Block var2) {
		return var2.r() != Material.WOOD && var2.r() != Material.PLANT && var2.r() != Material.REPLACEABLE_PLANT ? super.a(var1, var2) : this.a;
	}

}
