package net.minecraft;

import com.google.common.base.Predicate;

public class BlockLog1 extends axm {

	public static final bev b = bev.a("variant", EnumWoodType.class, (Predicate) (new ays()));

	public BlockLog1() {
		this.setBlockState(this.L.b().a(b, EnumWoodType.a).a(a, axo.b));
	}

	public IBlockState setData(int var1) {
		IBlockState var2 = this.getBlockState().a(b, EnumWoodType.a((var1 & 3) % 4));
		switch (var1 & 12) {
			case 0:
				var2 = var2.a(a, axo.b);
				break;
			case 4:
				var2 = var2.a(a, axo.a);
				break;
			case 8:
				var2 = var2.a(a, axo.c);
				break;
			default:
				var2 = var2.a(a, axo.d);
		}

		return var2;
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((EnumWoodType) var1.b(b)).a();
		switch (ayt.a[((axo) var1.b(a)).ordinal()]) {
			case 1:
				var3 |= 4;
				break;
			case 2:
				var3 |= 8;
				break;
			case 3:
				var3 |= 12;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { b, a });
	}

	protected ItemStack i(IBlockState var1) {
		return new ItemStack(Item.getItemOf((Block) this), 1, ((EnumWoodType) var1.b(b)).a());
	}

	public int getItemDropData(IBlockState var1) {
		return ((EnumWoodType) var1.b(b)).a();
	}

}
