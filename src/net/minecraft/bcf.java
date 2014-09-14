package net.minecraft;

import java.util.Random;

public abstract class bcf extends BlockStepAbstract {

	public static final bev b = bev.a("variant", EnumWoodType.class);

	public bcf() {
		super(Material.WOOD);
		IBlockState var1 = this.L.b();
		if (!this.j()) {
			var1 = var1.a(a, awr.b);
		}

		this.setBlockState(var1.a(b, EnumWoodType.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Item.getItemOf((Block) Blocks.WOODEN_SLAB);
	}

	public String b(int var1) {
		return super.getName() + "." + EnumWoodType.a(var1).c();
	}

	public bex l() {
		return b;
	}

	public Object a(ItemStack var1) {
		return EnumWoodType.a(var1.getDurability() & 7);
	}

	public IBlockState a(int var1) {
		IBlockState var2 = this.getBlockState().a(b, EnumWoodType.a(var1 & 7));
		if (!this.j()) {
			var2 = var2.a(a, (var1 & 8) == 0 ? awr.b : awr.a);
		}

		return var2;
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((EnumWoodType) var1.b(b)).a();
		if (!this.j() && var1.b(a) == awr.a) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return this.j() ? new bed(this, new bex[] { b }) : new bed(this, new bex[] { a, b });
	}

	public int a(IBlockState var1) {
		return ((EnumWoodType) var1.b(b)).a();
	}

}
