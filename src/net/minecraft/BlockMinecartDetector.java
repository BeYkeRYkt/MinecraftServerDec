package net.minecraft;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class BlockMinecartDetector extends ati {

	public static final bev b = bev.a("shape", atl.class, (Predicate) (new auz()));
	public static final bet M = bet.a("powered");

	public BlockMinecartDetector() {
		super(true);
		this.setBlockState(this.L.b().a(M, Boolean.valueOf(false)).a(b, atl.a));
		this.a(true);
	}

	public int a(World var1) {
		return 20;
	}

	public boolean g() {
		return true;
	}

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
		if (!var1.isStatic) {
			if (!((Boolean) var3.b(M)).booleanValue()) {
				this.e(var1, var2, var3);
			}
		}
	}

	public void a(World var1, Position var2, BlockState var3, Random var4) {
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		if (!var1.isStatic && ((Boolean) var3.b(M)).booleanValue()) {
			this.e(var1, var2, var3);
		}
	}

	public int a(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return ((Boolean) var3.b(M)).booleanValue() ? 15 : 0;
	}

	public int b(ard var1, Position var2, BlockState var3, BlockFace var4) {
		return !((Boolean) var3.b(M)).booleanValue() ? 0 : (var4 == BlockFace.UP ? 15 : 0);
	}

	private void e(World var1, Position var2, BlockState var3) {
		boolean var4 = ((Boolean) var3.b(M)).booleanValue();
		boolean var5 = false;
		List var6 = this.a(var1, var2, adx.class, new Predicate[0]);
		if (!var6.isEmpty()) {
			var5 = true;
		}

		if (var5 && !var4) {
			var1.a(var2, var3.a(M, Boolean.valueOf(true)), 3);
			var1.c(var2, (Block) this);
			var1.c(var2.b(), (Block) this);
			var1.b(var2, var2);
		}

		if (!var5 && var4) {
			var1.a(var2, var3.a(M, Boolean.valueOf(false)), 3);
			var1.c(var2, (Block) this);
			var1.c(var2.b(), (Block) this);
			var1.b(var2, var2);
		}

		if (var5) {
			var1.a(var2, (Block) this, this.a(var1));
		}

		var1.e(var2, this);
	}

	public void c(World var1, Position var2, BlockState var3) {
		super.c(var1, var2, var3);
		this.e(var1, var2, var3);
	}

	public bex l() {
		return b;
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		if (((Boolean) var1.getBlockState(var2).b(M)).booleanValue()) {
			List var3 = this.a(var1, var2, EntityMinecartCommandBlock.class, new Predicate[0]);
			if (!var3.isEmpty()) {
				return ((EntityMinecartCommandBlock) var3.get(0)).getListener().getSuccessCount();
			}

			List var4 = this.a(var1, var2, adx.class, new Predicate[] { EntityPredicates.c });
			if (!var4.isEmpty()) {
				return Container.b((IInventory) var4.get(0));
			}
		}

		return 0;
	}

	protected List a(World var1, Position var2, Class var3, Predicate... var4) {
		AxisAlignedBB var5 = this.a(var2);
		return var4.length != 1 ? var1.a(var3, var5) : var1.a(var3, var5, var4[0]);
	}

	private AxisAlignedBB a(Position var1) {
		float var2 = 0.2F;
		return new AxisAlignedBB((double) ((float) var1.getX() + 0.2F), (double) var1.getY(), (double) ((float) var1.getZ() + 0.2F), (double) ((float) (var1.getX() + 1) - 0.2F), (double) ((float) (var1.getY() + 1) - 0.2F), (double) ((float) (var1.getZ() + 1) - 0.2F));
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(b, atl.a(var1 & 7)).a(M, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(BlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((atl) var1.b(b)).a();
		if (((Boolean) var1.b(M)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { b, M });
	}

}
