package net.minecraft;

import java.util.Random;

public class BlockStone extends Block {

	public static final bev a = bev.a("variant", bbb.class);

	public BlockStone() {
		super(Material.STONE);
		this.j(this.L.b().a(a, bbb.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item a(bec var1, Random var2, int var3) {
		return var1.b(a) == bbb.a ? Item.getItemOf(Blocks.COBBLESTONE) : Item.getItemOf(Blocks.STONE);
	}

	public int a(bec var1) {
		return ((bbb) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, bbb.a(var1));
	}

	public int c(bec var1) {
		return ((bbb) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
