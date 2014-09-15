package net.minecraft;

final class WorldGenStrongholdUnknown extends WorldGenStrongholdPieceWeight {

	WorldGenStrongholdUnknown(Class var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public boolean a(int var1) {
		return super.a(var1) && var1 > 4;
	}
}
