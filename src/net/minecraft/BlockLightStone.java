package net.minecraft;

import java.util.Random;

public class BlockLightStone extends Block {

	public BlockLightStone(Material var1) {
		super(var1);
		this.a(CreativeModeTab.b);
	}

	public int a(int var1, Random var2) {
		return DataTypesConverter.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 4);
	}

	public int a(Random var1) {
		return 2 + var1.nextInt(3);
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.aT;
	}

	public MaterialMapColor g(bec var1) {
		return MaterialMapColor.d;
	}
}
