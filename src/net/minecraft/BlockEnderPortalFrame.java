package net.minecraft;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class BlockEnderPortalFrame extends Block {

	public static final beu a = beu.a("facing", (Predicate) UniverseDirection.HORIZONTAL);
	public static final bet b = bet.a("eye");

	public BlockEnderPortalFrame() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, Boolean.valueOf(false)));
	}

	public boolean c() {
		return false;
	}

	public void h() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
	}

	public void a(World var1, Position var2, IBlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		if (((Boolean) var1.getBlockState(var2).b(b)).booleanValue()) {
			this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		this.h();
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return null;
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(a, var8.aO().getOpposite()).a(b, Boolean.valueOf(false));
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int l(World var1, Position var2) {
		return ((Boolean) var1.getBlockState(var2).b(b)).booleanValue() ? 15 : 0;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(b, Boolean.valueOf((var1 & 4) != 0)).a(a, BlockFace.fromDirection(var1 & 3));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(a)).toDirection();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
