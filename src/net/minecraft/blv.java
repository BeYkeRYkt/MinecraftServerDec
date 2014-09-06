package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class blv extends bmk {

	private static final List a = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.bu, 0, 1, 1, 10), new vl(Items.i, 0, 1, 3, 3), new vl(Items.j, 0, 1, 5, 10), new vl(Items.k, 0, 1, 3, 5), new vl(Items.aC, 0, 4, 9, 5), new vl(Items.P, 0, 1, 3, 15), new vl(Items.e, 0, 1, 3, 15), new vl(Items.b, 0, 1, 1, 5), new vl(Items.l, 0, 1, 1, 5), new vl(Items.Z, 0, 1, 1, 5), new vl(Items.Y, 0, 1, 1, 5), new vl(Items.aa, 0, 1, 1, 5), new vl(Items.ab, 0, 1, 1, 5), new vl(Items.ao, 0, 1, 1, 1), new vl(Items.aA, 0, 1, 1, 1),
			new vl(Items.ck, 0, 1, 1, 1), new vl(Items.cl, 0, 1, 1, 1), new vl(Items.cm, 0, 1, 1, 1) }));
	private boolean b;

	public blv() {
	}

	public blv(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bmh) var1, var2, var3, 1, 1);
	}

	public static blv a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
		return a(var7) && bms.a(var0, var7) == null ? new blv(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 6);
			this.a(var1, var3, 3, 1, 2, 3, 1, 4, Blocks.STONEBRICK.P(), Blocks.STONEBRICK.P(), false);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 1, 1, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 1, 5, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 2, 2, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 2, 4, var3);

			for (int var4 = 2; var4 <= 4; ++var4) {
				this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 2, 1, var4, var3);
			}

			if (!this.b && var3.b((fd) (new Position(this.a(3, 3), this.d(2), this.b(3, 3))))) {
				this.b = true;
				this.a(var1, var3, var2, 3, 2, 3, vl.a(a, new vl[] { Items.cd.b(var2) }), 2 + var2.nextInt(2));
			}

			return true;
		}
	}

}
