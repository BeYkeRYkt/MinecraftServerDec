package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;

public class BlockLadder extends Block {

	public static final beu a = beu.a("facing", (Predicate) en.a);

	protected BlockLadder() {
		super(Material.ORIENTABLE);
		this.j(this.L.b().a(a, BlockFace.NORTH));
		this.a(CreativeModeTab.DECORATIONS);
	}

	public AxisAlignedBB a(World var1, Position var2, bec var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public void a(ard var1, Position var2) {
		bec var3 = var1.p(var2);
		if (var3.getBlock() == this) {
			float var4 = 0.125F;
			switch (axf.a[((BlockFace) var3.b(a)).ordinal()]) {
				case 1:
					this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
					break;
				case 2:
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
					break;
				case 3:
					this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					break;
				case 4:
				default:
					this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
			}

		}
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, Position var2) {
		return var1.p(var2.e()).getBlock().t() ? true : (var1.p(var2.f()).getBlock().t() ? true : (var1.p(var2.c()).getBlock().t() ? true : var1.p(var2.d()).getBlock().t()));
	}

	public bec a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (var3.k().c() && this.b(var1, var2, var3)) {
			return this.P().a(a, var3);
		} else {
			Iterator var9 = en.a.iterator();

			BlockFace var10;
			do {
				if (!var9.hasNext()) {
					return this.P();
				}

				var10 = (BlockFace) var9.next();
			} while (!this.b(var1, var2, var10));

			return this.P().a(a, var10);
		}
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		BlockFace var5 = (BlockFace) var3.b(a);
		if (!this.b(var1, var2, var5)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	protected boolean b(World var1, Position var2, BlockFace var3) {
		return var1.p(var2.a(var3.getOpposite())).getBlock().t();
	}

	public bec a(int var1) {
		BlockFace var2 = BlockFace.getById(var1);
		if (var2.k() == el.b) {
			var2 = BlockFace.NORTH;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((BlockFace) var1.b(a)).getId();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
