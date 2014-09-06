package net.minecraft;

import java.util.Random;

public class BlockOre extends Block {

	public BlockOre() {
		super(Material.STONE);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item a(bec var1, Random var2, int var3) {
		return this == Blocks.COAL_ORE ? Items.COAL : (this == Blocks.DIAMOND_ORE ? Items.DIAMOND : (this == Blocks.LAPIS_ORE ? Items.DYE : (this == Blocks.EMERALD_ORE ? Items.EMERALD : (this == Blocks.QUARTZ_ORE ? Items.QUARTZ : Item.getItemOf((Block) this)))));
	}

	public int a(Random var1) {
		return this == Blocks.LAPIS_ORE ? 4 + var1.nextInt(5) : 1;
	}

	public int a(int var1, Random var2) {
		if (var1 > 0 && Item.getItemOf((Block) this) != this.a((bec) this.O().a().iterator().next(), var2, var1)) {
			int var3 = var2.nextInt(var1 + 2) - 1;
			if (var3 < 0) {
				var3 = 0;
			}

			return this.a(var2) * (var3 + 1);
		} else {
			return this.a(var2);
		}
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (this.a(var3, var1.s, var5) != Item.getItemOf((Block) this)) {
			int var6 = 0;
			if (this == Blocks.COAL_ORE) {
				var6 = DataTypesConverter.a(var1.s, 0, 2);
			} else if (this == Blocks.DIAMOND_ORE) {
				var6 = DataTypesConverter.a(var1.s, 3, 7);
			} else if (this == Blocks.EMERALD_ORE) {
				var6 = DataTypesConverter.a(var1.s, 3, 7);
			} else if (this == Blocks.LAPIS_ORE) {
				var6 = DataTypesConverter.a(var1.s, 2, 5);
			} else if (this == Blocks.QUARTZ_ORE) {
				var6 = DataTypesConverter.a(var1.s, 2, 5);
			}

			this.b(var1, var2, var6);
		}

	}

	public int j(World var1, Position var2) {
		return 0;
	}

	public int a(bec var1) {
		return this == Blocks.LAPIS_ORE ? akv.l.b() : 0;
	}
}
