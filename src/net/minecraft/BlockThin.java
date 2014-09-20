package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockThin extends Block {

	public static final bet b = bet.a("north");
	public static final bet M = bet.a("east");
	public static final bet N = bet.a("south");
	public static final bet O = bet.a("west");
	private final boolean a;

	protected BlockThin(Material var1, boolean var2) {
		super(var1);
		this.setBlockState(this.L.b().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
		this.a = var2;
		this.a(CreativeModeTab.DECORATIONS);
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		return var1.a(b, Boolean.valueOf(this.c(var2.getBlockState(var3.getNorth()).getBlock()))).a(N, Boolean.valueOf(this.c(var2.getBlockState(var3.getSouth()).getBlock()))).a(O, Boolean.valueOf(this.c(var2.getBlockState(var3.getWest()).getBlock()))).a(M, Boolean.valueOf(this.c(var2.getBlockState(var3.getEast()).getBlock())));
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return !this.a ? null : super.a(var1, var2, var3);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		boolean var7 = this.c(var1.getBlockState(var2.getNorth()).getBlock());
		boolean var8 = this.c(var1.getBlockState(var2.getSouth()).getBlock());
		boolean var9 = this.c(var1.getBlockState(var2.getWest()).getBlock());
		boolean var10 = this.c(var1.getBlockState(var2.getEast()).getBlock());
		if ((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
			if (var9) {
				this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
				super.a(var1, var2, var3, var4, var5, var6);
			} else if (var10) {
				this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
				super.a(var1, var2, var3, var4, var5, var6);
			}
		} else {
			this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if ((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
			if (var7) {
				this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
				super.a(var1, var2, var3, var4, var5, var6);
			} else if (var8) {
				this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
				super.a(var1, var2, var3, var4, var5, var6);
			}
		} else {
			this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	public void h() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void a(ard var1, Position var2) {
		float var3 = 0.4375F;
		float var4 = 0.5625F;
		float var5 = 0.4375F;
		float var6 = 0.5625F;
		boolean var7 = this.c(var1.getBlockState(var2.getNorth()).getBlock());
		boolean var8 = this.c(var1.getBlockState(var2.getSouth()).getBlock());
		boolean var9 = this.c(var1.getBlockState(var2.getWest()).getBlock());
		boolean var10 = this.c(var1.getBlockState(var2.getEast()).getBlock());
		if ((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
			if (var9) {
				var3 = 0.0F;
			} else if (var10) {
				var4 = 1.0F;
			}
		} else {
			var3 = 0.0F;
			var4 = 1.0F;
		}

		if ((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
			if (var7) {
				var5 = 0.0F;
			} else if (var8) {
				var6 = 1.0F;
			}
		} else {
			var5 = 0.0F;
			var6 = 1.0F;
		}

		this.a(var3, 0.0F, var5, var4, 1.0F, var6);
	}

	public final boolean c(Block var1) {
		return var1.m() || var1 == this || var1 == Blocks.GLASS || var1 == Blocks.STAINED_GLASS || var1 == Blocks.STAINED_GLASS_PANE || var1 instanceof BlockThin;
	}

	protected boolean G() {
		return true;
	}

	public int getData(IBlockState var1) {
		return 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { b, M, O, N });
	}

}
